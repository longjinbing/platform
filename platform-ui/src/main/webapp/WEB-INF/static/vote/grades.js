var vue = new Vue({
    el : '#content',
    data : {
        grades : {},
        provinceList:[],
        cityList:[],
        universityList:[],
        collegeList:[],
        province:0,
        city:0,
        university:0,
        yearList:[]
    },
    filters:{
        stringFormat:function (value) {
            return overflowHidden(value,25);
        }
    },
    methods : {
        init:function(){
            var date=new Date();
            for(var i=0;i<30;i++){
                this.yearList.push(parseInt(date.getFullYear())-15+i);
            }
        },
        getCollege:function(){
                var _this = this;
                $.get(transUrl("/university/college"), function (r) {
                    _this.provinceList = r.data;
                    _this.province = _this.provinceList[0].id;
                })
        },
        addForm : function() {
            vue.grades = {};
            this.grades.year=parseInt((new Date).getFullYear());
            clearVailator();
            openForm("新增");
        },
        editForm : function() {
            var id=getSelectedRow();
            if (id != '') {
                var _this=this;
                var url=transUrl("/grades/");
                $.get(url+ id, function (r) {
                    if(check(r)){
                        vue.grades=r.data;
                        console.log(_this.provinceList.length)
                        for(var i=0;i<_this.provinceList.length;i++) {
                            for (var j = 0; j < _this.provinceList[i].citys.length; j++) {
                                for (var k = 0; k < _this.provinceList[i].citys[j].universitys.length; k++) {
                                    for (var m = 0; m < _this.provinceList[i].citys[j].universitys[k].colleges.length; m++) {
                                      if (_this.provinceList[i].citys[j].universitys[k].colleges[m].id == _this.grades.collegeId) {
                                            _this.province = _this.provinceList[i].id;
                                            _this.city = _this.provinceList[i].citys[j].id;
                                            _this.university = _this.provinceList[i].citys[j].universitys[k].id;
                                        }
                                    }
                                }
                            }
                        }
                        clearVailator();
                        openForm("修改信息");
                    }
                });
                if(vue.grades==null){alert("网络错误")}
            }

        },
        manage:function(){
            var id=getSelectedRow();
            if (id != '') {
                newtab("/course/grades/"+id,"班级学生管理");
            }
        },
        details:function(){
            var id = getSelectedRow();
            if (id != '') {
                var url = transUrl("/grades/details/")+id;
                $.get(url, function(r) {
                    if (check(r)) {
                        vue.grades= r.data;
                        openForm("查看详情",550,"detailswrap");
                    }
                });
            }
        },
        deleteData : function() {
            var id = getSelectedRows();
            if (id != '') {
                confirm('确定要删除选中的记录？', function() {
                    var url=transUrl("/grades/delete");
                    $.ajax({
                        type : "POST",
                        url : url,
                        contentType : "application/json",
                        data : JSON.stringify(id),
                        success : function(r) {
                            if(check(r)){
                                vue.reload();
                                tips("删除成功");
                            }
                        },
                        error : function() {
                            alert("网络错误，请稍后重试");
                        }
                    });
                });
            }
        },
        saveOrUpdate : function() {
            var url = vue.grades.id == null ? transUrl("/grades/save") : transUrl("/grades/update");
            $.ajax({
                type : "POST",
                url : url,
                contentType : "application/json",
                data : JSON.stringify(vue.grades),
                success : function(r) {
                    if(check(r)){
                        vue.reload();
                        vue.$data.grades={};
                        closeForm();
                        tips("操作成功");
                    }
                }
            });
        },
        reload : function() {
            var table=$("tr.selected").eq(0).closest("table");
            table=table.length==0?$('#datatable'):table;
            table.bootstrapTable('refresh', {query:{
                    field : $("#searchField").val(),
                    search : $("#searchText").val(),
                    stime : "",
                    etime : ""
                },'silent': true});
        },
        timeQuery : function() {
            $('#datatable').bootstrapTable('refresh', {query:{
                    field : "",
                    search : "",
                    stime : $("#startTime").val(),
                    etime : $("#endTime").val()
                },'silent': true});
        },
        exportData : function(exportType) {
            $('#datatable').tableExport({
                type : exportType,
                escape : 'false',
                fileName : 'grades'
            })
        }
    },
    created:function(){
        this.init();
        this.getCollege();
    },
    watch:{
        province:function(val){
            for(var i=0;i<this.provinceList.length;i++){
                if(this.provinceList[i].id==val){
                    if(this.provinceList[i].citys==undefined){
                        this.provinceList[i].citys=[];
                    }
                    this.cityList=this.provinceList[i].citys;
                };
            }
            if(this.cityList.length==0){
                var obj={
                    id:0,
                    name:'暂无相关地区信息'
                }
                this.cityList.push(obj);
            }
            this.city=this.cityList[0].id;
        },
        city:function(val){
            for(var i=0;i<this.cityList.length;i++){
                if(this.cityList[i].id==val){
                    if(this.cityList[i].universitys==undefined){
                        this.cityList[i].universitys=[];
                    }
                    this.universityList=this.cityList[i].universitys;
                };
            }
            if(this.universityList.length==0){
                var obj={
                    id:0,
                    name:'暂无相关学校信息'
                }
                this.universityList.push(obj);
            }
            this.university=this.universityList[0].id
        },
        university:function(val){
            for(var i=0;i<this.universityList.length;i++){
                if(this.universityList[i].id==val){
                    if(this.universityList[i].colleges==undefined){
                        this.universityList[i].colleges=[];
                    }
                    this.collegeList=this.universityList[i].colleges;

                };
            }
            if(this.collegeList.length==0){
                var obj={
                    id:0,
                    name:'暂无相关学院信息'
                }
                this.collegeList.push(obj);
            }
            this.grades.collegeId=this.collegeList[0].id;

        }
    }
});
var validator;
$(function() {
    var url=transUrl("/grades/list");
    var table = new BSTable("datatable", url,
        initColumn());
    table.init();
    validator=$("#modal-form").validate({
        onfocusout: function(element) { $(element).valid(); },
        rules : {
            name : {
                required : true
            },
            collegeId : {
                required : true
            },
            remark : {
                required : true
            },
            contacts : {
                required : true
            },
            phone : {
                required : true
            },
            year : {
                required : true
            }			},
        messages : {
            name : {
                required : "请填写"
            },
            collegeId : {
                required : "请填写"
            },
            number : {
                required : "请填写"
            },
            contacts : {
                required : "请填写"
            },
            phone : {
                required : "请填写"
            },
            year : {
                required : "请填写"
            }			},
        submitHandler : function(form) {
            vue.saveOrUpdate();
        },
        errorPlacement : function(error, element) {
            tipError(error, element);
        },
        showErrors : function(errorMap, errorList) {
            for(var obj in errorMap) {
                /*$('#' + obj).parent().addClass('has-error');*/
            }
            this.defaultShowErrors();
        },
        success:function(label) {
            $(label).removeClass('error').addClass("validate-success");
        },
        invalidHandler: function(form, validator) {
        }
    });
});
var initColumn = function() {
    return [ {
        checkbox : true,
        width:'2%'
    }, 	{
        title : '序号',
        field : 'id',
        align : 'left',
        visible : true,
        width:'2%',
        valign : 'middle',
        formatter : function(value, row, index) {
            return autoId("datatable", index);
        }},
        {
            title : '班级名称',
            field : 'name',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'12%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        }, 			{
            title : '学院',
            field : 'collegeName',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'8%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        }, 			{
            title : '入学年份',
            field : 'year',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'4%',
            formatter:function(value,row,index){
                return value+"年";
            }
        }, 			{
            title : '人数',
            field : 'number',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'4%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        }, 			{
            title : '班主任',
            field : 'contacts',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'5%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        }, 			{
            title : '电话',
            field : 'phone',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'8%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        }, 			{
            title : '备注',
            field : 'remark',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'12%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        },             {
            title : '操作人',
            field : 'createName',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'5%',
            formatter:function(value,row,index){
                return overflowHidden(value,15);
            }
        }, 			{
            title : '创建时间',
            field : 'createTime',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'12%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        }, 			{
            title : '更新时间',
            field : 'updateTime',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'12%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        }
    ];
};
