		var vue = new Vue({
		el : '#content',
		data : {
			questionType : {}
		},
		methods : {
			addForm : function() {
				vue.questionType = {};
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/questiontype/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.questionType=r.questionType;
						openForm("修改信息");
						}
				    });
					if(vue.questionType==null){alert("网络错误")}
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/questiontype/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.questionType= r.questionType;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/questiontype/delete");
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
				var url = vue.questionType.id == null ? transUrl("/questiontype/save") : transUrl("/questiontype/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.questionType),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.questionType={};
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
					searchField : $("#searchField").val(),
					searchText : $("#searchText").val(),
					startTime : "",
					endTime : ""
				},'silent': true});
			},
			timeQuery : function() {
				$('#datatable').bootstrapTable('refresh', {query:{
					searchField : "",
					searchText : "",
					startTime : $("#startTime").val(),
					endTime : $("#endTime").val()
				},'silent': true});
			},
			exportData : function(exportType) {
				$('#datatable').tableExport({
					type : exportType,
					escape : 'false',
					fileName : 'questionType'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/questiontype/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				type : {
					required : true
				},
				desc : {
					required : true
				}			},
			messages : {
				type : {
					required : "请填写类型"
				},
				desc : {
					required : "请填写描述"
				}			},
			submitHandler : function(form) {
				vue.saveOrUpdate();
			},
			errorPlacement : function(error, element) {
				tipError(error, element);
			}
		});
	});
	var initColumn = function() {
		return [ {
			checkbox : true
		}, 	{
			title : '序号',
			field : 'id',
			align : 'left',
			visible : true,
			valign : 'middle',
			formatter : function(value, row, index) {
				return autoId("datatable", index);
		}}, 
			{
			title : '类型',
			field : 'type',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '描述',
			field : 'desc',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		} ];
	};
