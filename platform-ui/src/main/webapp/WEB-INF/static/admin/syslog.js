		var vue = new Vue({
		el : '#content',
		data : {
			sysLog : {}
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,40);
            }
        },
		methods : {
			addForm : function() {
				vue.sysLog = {};
                clearVailator();
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/syslog/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.sysLog=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.sysLog==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/syslog/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.sysLog= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
            complete : function() {
                var id = getSelectedRows();
                if (id != '') {
                    confirm('确定要该错误修复完毕？', function() {
                        var url=transUrl("/syslog/complete");
                        $.ajax({
                            type : "POST",
                            url : url,
                            contentType : "application/json",
                            data : JSON.stringify(id),
                            success : function(r) {
                                if(check(r)){
                                    vue.reload();
                                    tips("状态更改成功");
                                }
                            },
                            error : function() {
                                alert("网络错误，请稍后重试");
                            }
                        });
                    });
                }
            },
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/syslog/delete");
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
				var url = vue.sysLog.id == null ? transUrl("/syslog/save") : transUrl("/syslog/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysLog),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.sysLog={};
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
					fileName : 'sysLog'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/syslog/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				operation : {
					required : true
				},
				method : {
					required : true
				},
				params : {
					required : true
				},
				ip : {
					required : true
				},
				url : {
					required : true
				},
				remark : {
					required : true
				},
				level : {
					required : true
				},
				errorStack : {
					required : true
				}			},
			messages : {
				operation : {
					required : "请填写"
				},
				method : {
					required : "请填写"
				},
				params : {
					required : "请填写"
				},
				ip : {
					required : "请填写"
				},
				url : {
					required : "请填写"
				},
				remark : {
					required : "请填写"
				},
				level : {
					required : "请填写"
				},
				errorStack : {
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
		}},			{
            title : 'URL',
            field : 'url',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'16%',
            formatter:function(value,row,index){
                return overflowHidden(value,30);
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
        },
            {
                title : '操作',
                field : 'operation',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'12%',
                formatter:function(value,row,index){
                    return overflowHidden(value,20);
                }
            },
            {
                title : '级别',
                field : 'level',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'5%',
                formatter:function(value,row,index){
                    return transSysLogLevel(value);
                }
            }, {
                title : '用户',
                field : 'createName',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'8%',
                formatter:function(value,row,index){
                    return overflowHidden(value,15);
                }
            }, 			{
			title : 'IP地址',
			field : 'ip',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '请求时间',
			field : 'createTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, {
                title : '状态',
                field : 'status',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'5%',
                formatter:function(value,row,index){
                    return transSysLogStaus(value);
                }
            }, {
			title : '处理时间',
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
