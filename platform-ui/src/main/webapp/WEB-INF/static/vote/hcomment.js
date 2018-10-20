		var vue = new Vue({
		el : '#content',
		data : {
			comment : {},
            courseId:$("#courseId").val(),
			statusList:[]
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
            clear:function(){
                var id=getSelectedRow();
                if (id != '') {
                    var row=$("#datatable").bootstrapTable('getSelections');
                    if(row[0].status==1){
                        top.layer.msg('评价还未开始，无需清除');
                    }else {
                        confirm('确定要清除评价吗？', function() {
                            var url=transUrl("/comment/clear");
                            $.ajax({
                                type : "POST",
                                url : url,
                                contentType : "application/json",
                                data : JSON.stringify(id),
                                success : function(r) {
                                    if(check(r)){
                                        vue.reload();
                                        tips("完成评价成功");
                                    }
                                },
                                error : function() {
                                    alert("网络错误，请稍后重试");
                                }
                            });
                        })
                    }
                }
            },
			start:function(){
                var id=getSelectedRow();
                if (id != '') {
                        var row=$("#datatable").bootstrapTable('getSelections');
                        if(row[0].type==1) {
                            if (row[0].status == 2) {
                                top.layer.msg('评价已经在进行中了！');
                            } else if (row[0].status == 3) {
                                top.layer.msg('评价已经结束了，不能再次开启！');
                            } else {
                                confirm('确定要开启评价吗？', function () {
                                    var url = transUrl("/hcomment/start");
                                    $.ajax({
                                        type: "POST",
                                        url: url,
                                        contentType: "application/json",
                                        data: JSON.stringify(id),
                                        success: function (r) {
                                            if (check(r)) {
                                                vue.reload();
                                                tips("开启评价成功");
                                            }
                                        },
                                        error: function () {
                                            alert("网络错误，请稍后重试");
                                        }
                                    });
                                })
                            }
                        }else{
                            top.layer.msg('系统暂不支持使用该种评价');
						}
                }
			},
            end:function(){
                var id=getSelectedRow();
                if (id != '') {
                    var row=$("#datatable").bootstrapTable('getSelections');
                    if(row[0].status==1){
                        top.layer.msg('评价还未开始！');
                    }else if(row[0].status==3){
                        top.layer.msg('评价已经结束了，无需再次结束！');
                    }else {
                        confirm('确定要完成评价吗？', function() {
                            var url=transUrl("/hcomment/end");
                            $.ajax({
                                type : "POST",
                                url : url,
                                contentType : "application/json",
                                data : JSON.stringify(id),
                                success : function(r) {
                                    if(check(r)){
                                        vue.reload();
                                        tips("完成评价成功");
                                    }
                                },
                                error : function() {
                                    alert("网络错误，请稍后重试");
                                }
                            });
                        })
                    }
                }
            },
            progress:function(){
                var id=getSelectedRow();
                if (id != '') {
                    var row=$("#datatable").bootstrapTable('getSelections');
                    if(row[0].status==1){
                        top.layer.msg('评价还未开始！');
                    }else {
                       newtab("/course/result/"+id,"课程评价进度");
                    }
                }
			},
			addForm : function() {
				vue.comment = {};
				this.comment.courseId=this.courseId;
                clearVailator();
				openForm("新增");
			},
            question:function(){
                var id=getSelectedRow();
                if (id != '') {
                    var row=$("#datatable").bootstrapTable('getSelections');
                    console.log(row);
                    if(row[0].type==1||row[0].type==2){
                        top.layer.msg('该评价类型不支持自定义问题');
					}else {
                        newtab("/course/question/" + id, "评价问题管理");
                    }
                }
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/hcomment/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.comment=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.comment==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/hcomment/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.comment= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/hcomment/delete");
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
				var url = vue.comment.id == null ? transUrl("/hcomment/save") : transUrl("/hcomment/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.comment),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.comment={};
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
					fileName : 'comment'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/hcomment/list?pid=")+vue.courseId;
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				name : {
					required : true
				},
				description : {
					required : true
				},
				remark : {
					required : true
				},
				status : {
					required : true
				},
				type : {
					required : true
				}			},
			messages : {
				name : {
					required : "请填写"
				},
				description : {
					required : "请填写"
				},
				remark : {
					required : "请填写"
				},
				status : {
					required : "请填写"
				},
				type : {
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
			title : '名称',
			field : 'name',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,15);
			}
		}, 			{
			title : '描述',
			field : 'description',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
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
					return '<span class="btn btn-xs btn-default">未开始</span>'
				}else if(value==2){
                    return '<span class="btn btn-xs btn-warning">正在进行</span>'
                }else if(value==3){
                    return '<span class="btn btn-xs btn-success">已完成</span>'
                }
			}
		}, 			{
			title : '评价类型',
			field : 'type',
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
