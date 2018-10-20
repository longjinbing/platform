		var vue = new Vue({
		el : '#content',
		data : {
            course: {},
            provinceList: [],
            cityList: [],
            universityList: [],
            collegeList: [],
            categoryList: [],
            teacherList: [],
            province: 0,
            city: 0,
            school: 0,
            university: 0,
            college: 0,
            yearList: [],
            courseTeacher: {}
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
				/*this.getCollege();*/
                this.getTeacher();
				this.getCategory();
			},
			getCategory:function(){
				if(this.categoryList.length<=0){
                    var _this=this;
                    $.get(transUrl("/coursecatogry/categorylist"),function(r){
                        _this.categoryList=r.data;
                        _this.course.courseCatogryId=_this.categoryList[0].id;
                    })
				}
			},
            getCollege:function(){
                var _this=this;
                $.get(transUrl("/university/college"),function(r){
                    _this.provinceList=r.data;
                    _this.province=_this.provinceList[0].id;
                })
            },
            getTeacher:function(){
                var _this=this;
                $.get(transUrl("/university/teacher"),function(r){
                    _this.provinceList=r.data;
                    _this.province=_this.provinceList[0].id;
                })
            },
            teacherForm:function(){
                var id=getSelectedRow();
                var _this=this;
                if (id != '') {
                    var url=transUrl("/courseteacher/course/");
                    $.get(url+ id, function (r) {
                        if(check(r)){
                            _this.courseTeacher.courseId = id;
                            if(r.data!=null){
                                _this.courseTeacher=r.data;
                                for(var i=0;i<_this.provinceList.length;i++) {
                                    for (var j = 0; j < _this.provinceList[i].citys.length; j++) {
                                        for (var k = 0; k < _this.provinceList[i].citys[j].universitys.length; k++) {
                                            for (var m = 0; m < _this.provinceList[i].citys[j].universitys[k].colleges.length; m++) {
                                                for (var n = 0; n < _this.provinceList[i].citys[j].universitys[k].colleges[m].teachers.length ;n++) {
                                                    if (_this.provinceList[i].citys[j].universitys[k].colleges[m].teachers[n].id == _this.courseTeacher.userId) {
                                                        _this.province = _this.provinceList[i].id;
                                                        _this.city = _this.provinceList[i].citys[j].id;
                                                        _this.university = _this.provinceList[i].citys[j].universitys[k].id;
                                                        _this.college = _this.provinceList[i].citys[j].universitys[k].colleges[m].id;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            _this.modalTitle = "选择教师";
                            $("#teachermodal").modal("show");
                        }
                    });
                    if(vue.courseTeacher==null){alert("网络错误")}
                }
            },
            saveOrUpdateTeacher : function() {
			    if(this.courseTeacher.userId>0){
                var url = vue.courseTeacher.id == null ? transUrl("/courseteacher/save") : transUrl("/courseteacher/update");
                $.ajax({
                    type : "POST",
                    url : url,
                    contentType : "application/json",
                    data : JSON.stringify(vue.courseTeacher),
                    success : function(r) {
                        if(check(r)){
                            vue.reload();
                            vue.$data.courseTeacher={};
                            $("#teachermodal").modal("hide");
                            tips("操作成功");
                        }
                    }
                });
                }else{
			        top.layer.msg("信息不完整，无法保存");
                }
            },
			addForm : function() {
				vue.course = {};
                this.course.year=parseInt((new Date).getFullYear());
                this.course.term=1;
                clearVailator();
				openForm("新增");
			},
            mange:function(){
                var id=getSelectedRow();
                if (id != '') {
                	newtab("/course/manage/"+id,"课程学生管理");
				}
			},
            comment:function(){
                var id=getSelectedRow();
                if (id != '') {
                    newtab("/course/comment/"+id,"课程评价管理");
                }
            },
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var _this=this;
					var url=transUrl("/course/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.course=r.data;
                            for(var i=0;i<_this.provinceList.length;i++) {
                                for (var j = 0; j < _this.provinceList[i].citys.length; j++) {
                                    for (var k = 0; k < _this.provinceList[i].citys[j].universitys.length; k++) {
                                        for (var m = 0; m < _this.provinceList[i].citys[j].universitys[k].colleges.length; m++) {
                                            if (_this.provinceList[i].citys[j].universitys[k].colleges[m].id == _this.course.collegeId) {
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
					if(vue.course==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/course/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.course= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/course/delete");
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
				var url = vue.course.id == null ? transUrl("/course/save") : transUrl("/course/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.course),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.course={};
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
            orderChange:function(num){
                this.course.number=num;
            },
            statusChange:function(value){
                this.course.status=value;
            },
			exportData : function(exportType) {
				$('#datatable').tableExport({
					type : exportType,
					escape : 'false',
					fileName : 'course'
				})
			}
		},
			created:function(){
			this.init();
			},
            watch:{
                province:function(val){
                	console.log("省份")
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
                    console.log("市")
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
                    this.college=this.collegeList[0].id;

                },
                college:function(val){
                    for(var i=0;i<this.collegeList.length;i++){
                        if(this.collegeList[i].id==val){
                            if(this.collegeList[i].teachers==undefined){
                                this.teacherList[i].colleges=[];
                            }
                            this.teacherList=this.collegeList[i].teachers;

                        };
                    }
                    if(this.teacherList.length==0){
                        var obj={
                            id:0,
                            name:'暂无相关教师信息'
                        }
                        this.teacherList.push(obj);
                    }
                    this.courseTeacher.userId=this.teacherList[0].id;

                }
            }
	});
	var validator;
	$(function() {
		var url=transUrl("/course/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
            rules : {
                name : {
                    required : true
                },
                year : {
                    required : true
                },
                courseCatogryId : {
                    required : true
                },
                term : {
                    required : true
                },
                status : {
                    required : true
                },
                number : {
                    required : true
                },
                remark : {
                    required : true
                },
                collegeId : {
                    required : true
                },
                contacts : {
                    required : true
                },
                phone : {
                    required : true
                }			},
            messages : {
                name : {
                    required : "请填写"
                },
                year : {
                    required : "请填写"
                },
                courseCatogryId : {
                    required : "请填写"
                },
                term : {
                    required : "请填写"
                },
                status : {
                    required : "请填写"
                },
                number : {
                    required : "请填写"
                },
                remark : {
                    required : "请填写"
                },
                collegeId : {
                    required : "请填写"
                },
                contacts : {
                    required : "请填写"
                },
                phone : {
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
                width:'3%'
            }, 	{
                title : '序号',
                field : 'id',
                align : 'left',
                visible : true,
                width:'3%',
                valign : 'middle',
                formatter : function(value, row, index) {
                    return autoId("datatable", index);
                }}, 			{
                title : '课程年份',
                field : 'year',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'8%',
                formatter:function(value,row,index){
                	var term=row.term==1?"上学期":"下学期"
                	return '<span>'+value+term+'</span>';
                }
            },
                {
                    title : '课程名称',
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
                    width:'12%',
                    formatter:function(value,row,index){
                        return overflowHidden(value,20);
                    }
                }, 			{
                    title : '课程类别',
                    field : 'categoryName',
                    align : 'left',
                    visible : true,
                    sortable:true,
                    valign : 'middle',
                    width:'5%',
                    formatter:function(value,row,index){
                        return overflowHidden(value,20);
                    }
                }, 			{
                    title : '教师',
                    field : 'teacherName',
                    align : 'left',
                    visible : true,
                    sortable:true,
                    valign : 'middle',
                    width:'8%',
                    formatter:function(value,row,index){
                        if (value == undefined) {
                            return '<span class="btn btn-xs btn-danger">请分配教师</span>';
                        } else {
                            return overflowHidden(value, 20);
                        }
                    }
                }, 			{
                    title : '电话',
                    field : 'mobile',
                    align : 'left',
                    visible : true,
                    sortable:true,
                    valign : 'middle',
                    width:'8%',
                    formatter:function(value,row,index){
                        if (value == undefined) {
                            return '<span class="btn btn-xs btn-danger">请分配教师</span>';
                        } else {
                            return overflowHidden(value, 20);
                        }
                    }
                }, 			{
                    title : '联系人',
                    field : 'contacts',
                    align : 'left',
                    visible : true,
                    sortable:true,
                    valign : 'middle',
                    width:'8%',
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
                    title : '状态',
                    field : 'status',
                    align : 'left',
                    visible : true,
                    sortable:true,
                    valign : 'middle',
                    width:'5%',
                    formatter:function(value,row,index){
                        return transAccountStatus(value);
                    }
                }, 			{
                    title : '人数',
                    field : 'number',
                    align : 'left',
                    visible : true,
                    sortable:true,
                    valign : 'middle',
                    width:'5%',
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
                    width:'8%',
                    formatter:function(value,row,index){
                        return overflowHidden(value,15);
                    }
                }
            ];
        };
