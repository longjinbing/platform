		var vue = new Vue({
		el : '#content',
		data : {
			courseUser : {},
            courseId:$("#courseId").val(),
			sysUser:{},
            modalTitle:'',
			add:false
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
            importForm:function(){
                this.modalTitle="导入";
                $("#importmodal").modal("show");
            },
            import:function(){
                if($('#excelfile').val()==undefined){
                    return false;
                }
                var dataString = new FormData();
                dataString.append("file",document.getElementById("excelfile").files[0])
                dataString.append("id",this.courseId);
                $.ajax({
                    url: transUrl("/courseuser/savebatch"),  //Server script to process data
                    type: 'POST',
                    data: dataString,
                    before:function(){
                        var index = layer.load(1, {
                            shade: [0.1,'#fff'] //0.1透明度的白色背景
                        });
                    },
                    before:function(){
                        var index = layer.load(1, {
                            shade: [0.1,'#fff'] //0.1透明度的白色背景
                        });
                    },
                    dataType: "JSON",
                    cache: false,
                    processData: false,
                    enctype:'multipart/form-data',
                    contentType: false,
                    success: function (r) {
                        if(check(r)){
                            $("#importmodal").modal("hide");
                            alert(r.msg);
                            vue.reload();
                        }
                    },
                    error:function () {
                        alert("网络故障");
                    }
                });
            },
			addForm : function() {
				vue.courseUser = {};
				this.sysUser={};
				this.courseUser.courseId=this.courseId;
                clearVailator();
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/courseuser/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.courseUser=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.courseUser==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/courseuser/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.courseUser= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/courseuser/delete");
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
				if(this.sysUser.username==undefined) {
                    var url = vue.courseUser.id == null ? transUrl("/courseuser/save") : transUrl("/courseuser/update");
                    $.ajax({
                        type: "POST",
                        url: url,
                        contentType: "application/json",
                        data: JSON.stringify(vue.courseUser),
                        success: function (r) {
                            if (check(r)) {
                                vue.reload();
                                vue.$data.courseUser = {};
                                closeForm();
                                tips("操作成功");
                            }
                        }
                    });
                }else{
                    var url = transUrl("/sysuser/add");
                    $.ajax({
                        type : "POST",
                        url : url,
                        contentType : "application/json",
                        data : JSON.stringify(vue.sysUser),
                        success : function(r) {
                            if(check(r)){
                            	vue.courseUser.userId=r.data;
                            	vue.sysUser={};
                                vue.saveOrUpdate();
                            }
                        }
                    });
				}
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
					fileName : 'courseUser'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/courseuser/list?pid=")+vue.courseId;
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
            rules : {
                username : {
                    required : true,
                    minlength:2,
                    maxlength:10,
                },
                number:{
                    required:true,
                    minlength:6,
                    maxlength:15,
                    remote : {
                        type : "get",
                        url : transUrl("/sysuser/number"),
                        dataType : "html",
                        dataFilter : function(r) {
                            r=JSON.parse(r);
                            if(r.code==0){
                            	vue.courseUser.userId=r.data;
                            	vue.add=false;
                                return true;
                            }
                            vue.courseUser.userId=0;
                            vue.add=true;
                            return true;
                        }
                    }
                },
                password : {
                    required : true,
                    minlength:6,
                    maxlength:16,
                },
                email : {
                    required : true,
                    email:true
                },
                mobile : {
                    required : true,
                    minlength:11
                }
            },
            messages : {
                username : {
                    required : "请填写",
                    minlength:'2-10字符串',
                    maxlength:'2-10字符串',
                },
                number : {
                    required : "请输入学号",
                    minlength : "6-15个字符",
                    maxlength : "6-15个字符",
                    remote:"需填写信息"
                },
                password : {
                    required : "请填写",
                    minlength:'至少6位',
                    maxlength:'最多16位',
                },
                email : {
                    required : "请填写",
                    email:'格式错误'
                },
                mobile : {
                    required : "请填写",
                    minlength:"格式错误"
                }
            },
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
		}},
			{
			title : '姓名',
			field : 'studentName',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '学号',
			field : 'number',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'8%',
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
                width:'10%',
                formatter:function(value,row,index){
                    return overflowHidden(value,20);
                }
            }, 			{
                title : '班级',
                field : 'gradesName',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'10%',
                formatter:function(value,row,index){
                    return overflowHidden(value,20);
                }
            }, 			{
                title : '邮箱',
                field : 'email',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'10%',
                formatter:function(value,row,index){
                    return overflowHidden(value,20);
                }
            }, 			{
                title : '手机',
                field : 'mobile',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'10%',
                formatter:function(value,row,index){
                    return overflowHidden(value,20);
                }
            }, 			{
			title : '课程名称',
			field : 'courseName',
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
            },             {
                title : '加入时间',
                field : 'createTime',
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
