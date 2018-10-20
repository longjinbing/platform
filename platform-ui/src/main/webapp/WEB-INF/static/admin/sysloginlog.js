		var vue = new Vue({
		el : '#content',
		data : {
			sysLoginLog : {}
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
			addForm : function() {
				vue.sysLoginLog = {};
                clearVailator();
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/sysloginlog/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.sysLoginLog=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.sysLoginLog==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/sysloginlog/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.sysLoginLog= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/sysloginlog/delete");
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
				var url = vue.sysLoginLog.id == null ? transUrl("/sysloginlog/save") : transUrl("/sysloginlog/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysLoginLog),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.sysLoginLog={};
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
					fileName : 'sysLoginLog'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/sysloginlog/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				status : {
					required : true
				},
				ip : {
					required : true
				},
				device : {
					required : true
				},
				remark : {
					required : true
				},
				result : {
					required : true
				}			},
			messages : {
				status : {
					required : "请填写"
				},
				ip : {
					required : "请填写"
				},
				device : {
					required : "请填写"
				},
				remark : {
					required : "请填写"
				},
				result : {
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
                title : '用户名',
                field : 'createName',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'8%',
                formatter:function(value,row,index){
                	if(value!=undefined){
                        return overflowHidden(value,15);
					}else{
                		return "未知用户";
					}

                }
            },
			 			{
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
			title : '登录时间',
			field : 'createTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		},		{
			title : '登陆来源',
			field : 'device',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,30);
			}
		},
			{
                title : '用户状态',
                field : 'status',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'12%',
                formatter:function(value,row,index){
                	if(value==1){
                		return "<span class='btn btn-xs btn-success'>登录正常</span>";
					}else{
                        return "<span class='btn btn-xs btn-danger'>登录异常</span>";
					}
                }
            },
            {
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
            },
            {
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
			title : '结果',
			field : 'result',
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
