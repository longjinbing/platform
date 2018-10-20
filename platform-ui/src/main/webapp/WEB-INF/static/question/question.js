		var vue = new Vue({
		el : '#content',
		data : {
			question : {}
		},
		methods : {
			addForm : function() {
				vue.question = {};
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/question/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.question=r.question;
						openForm("修改信息");
						}
				    });
					if(vue.question==null){alert("网络错误")}
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/question/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.question= r.question;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/question/delete");
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
				var url = vue.question.id == null ? transUrl("/question/save") : transUrl("/question/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.question),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.question={};
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
					fileName : 'question'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/question/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				title : {
					required : true
				},
				optionA : {
					required : true
				},
				optionB : {
					required : true
				},
				optionC : {
					required : true
				},
				optionD : {
					required : true
				},
				answer : {
					required : true
				},
				type : {
					required : true
				},
				level : {
					required : true
				}			},
			messages : {
				title : {
					required : "请填写题目"
				},
				optionA : {
					required : "请填写选项A"
				},
				optionB : {
					required : "请填写选项B"
				},
				optionC : {
					required : "请填写选项C"
				},
				optionD : {
					required : "请填写选项D"
				},
				answer : {
					required : "请填写答案"
				},
				type : {
					required : "请填写类型"
				},
				level : {
					required : "请填写"
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
			title : '题目',
			field : 'title',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return '<xmp>'+value+'</xmp>';
			}
		},			{
			title : '选项A',
			field : 'optionA',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'10%',
			formatter:function(value,row,index){
                return '<xmp>'+value+'</xmp>';
			}
		},			{
			title : '选项B',
			field : 'optionB',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'10%',
			formatter:function(value,row,index){
                return '<xmp>'+value+'</xmp>';
			}
		},			{
			title : '选项C',
			field : 'optionC',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'10%',
			formatter:function(value,row,index){
                return '<xmp>'+value+'</xmp>';
			}
		},			{
			title : '选项D',
			field : 'optionD',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'10%',
			formatter:function(value,row,index){
                return '<xmp>'+value+'</xmp>';
			}
		},			{
			title : '答案',
			field : 'answer',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,10);
			}
		},			{
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
			title : '',
			field : 'level',
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
