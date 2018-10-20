		var vue = new Vue({
		el : '#content',
		data : {
            course: {},
            categoryList: [],
            yearList: []
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
			addForm : function() {
				vue.course = {};
                this.course.year=parseInt((new Date).getFullYear());
                this.course.term=1;
                this.course.courseCatogryId=this.categoryList[0].id;
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
					var url=transUrl("/hcourse/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.course=r.data;
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
					var url = transUrl("/hcourse/details/")+id;
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
						var url=transUrl("/hcourse/delete");
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
				var url = vue.course.id == null ? transUrl("/hcourse/save") : transUrl("/hcourse/update");
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
			}
	});
	var validator;
	$(function() {
		var url=transUrl("/hcourse/list");
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
