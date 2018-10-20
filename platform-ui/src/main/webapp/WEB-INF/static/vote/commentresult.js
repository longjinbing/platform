		var vue = new Vue({
		el : '#content',
		data : {
			commentResult : {},
            commentId:$("#commentId").val(),
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
			/*addForm : function() {
				vue.commentResult = {};
                clearVailator();
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/commentresult/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.commentResult=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.commentResult==null){alert("网络错误")}
				}

			},*/
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/commentresult/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.commentResult= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/commentresult/delete");
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
				var url = vue.commentResult.id == null ? transUrl("/commentresult/save") : transUrl("/commentresult/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.commentResult),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.commentResult={};
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
					fileName : 'commentResult'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/commentresult/list?pid=")+vue.commentId;
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				userId : {
					required : true
				},
				commentId : {
					required : true
				},
				questionId : {
					required : true
				},
				answer : {
					required : true
				},
				remark : {
					required : true
				},
				status : {
					required : true
				}			},
			messages : {
				userId : {
					required : "请填写"
				},
				commentId : {
					required : "请填写"
				},
				questionId : {
					required : "请填写"
				},
				answer : {
					required : "请填写"
				},
				remark : {
					required : "请填写"
				},
				status : {
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
            width:'5%'
		}, 	{
			title : '序号',
			field : 'id',
			align : 'left',
			visible : true,
			width:'5%',
			valign : 'middle',
			formatter : function(value, row, index) {
				return autoId("datatable", index);
		}},
			{
			title : '评价人',
			field : 'createName',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '被评价人',
			field : 'commentName',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		},			{
                title : '评价类型',
                field : 'commentsName',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'6%',
                formatter:function(value,row,index){
                    if(row.userId==row.createId){
                        return "自我评价";
                    }else{
                        return   "互相评价";
                    }
                }
            }, 			{
                title : '状态',
                field : 'status',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'12%',
                formatter:function(value,row,index){
                    if(value==1){
                        return '<span class="btn btn-xs btn-danger">未评价</span>';
                    }else if(value==2){
                        return '<span class="btn btn-xs btn-success">已评价</span>';
                    }else if(value==3){
                        return '<span class="btn btn-xs btn-success">已修改</span>';
                    }else if(value==4){
                        return '<span class="btn btn-xs btn-success">已结束</span>';
                    }
                }
            }, 			{
			title : '评价时间',
			field : 'createTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
                if(row.status==1){
                    return comment(value);
                }else if(row.status==4||row.status==3||row.status==2){
                    if(value==undefined){
                        return '<span class="btn btn-xs btn-danger">未评价</span>';
                    }else {
                        return value;
                    }
                };
			}
		}, 			{
			title : '修改时间',
			field : 'updateTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
                if(row.status==1){
                    return comment(value);
                }else if(row.status==2){
                    return '<span class="btn btn-xs btn-success">允许修改</span>';
                }else if(row.status==3){
                    return '<span class="btn btn-xs btn-info">无法修改</span>';
                }else if(row.status==4){
                    return '<span class="btn btn-xs btn-info">无法修改</span>';
                } ;
			}
		}, 			{
			title : '成绩',
			field : 'remark',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
                if(value==undefined){
                    if(row.status==4){
                        return '<span class="btn btn-xs btn-danger">0.00</span>';
                    }else{
                        return "0.00";
                    }
                }else {
                    return overflowHidden(value, 20);
                }
			}
		}
		];
	};
        function comment(value) {
            if(value==undefined){
                return "<span class='btn btn-xs btn-danger'>请尽快完成评价</span>"
            }else{
                return value;
            }
        }
