		var vue = new Vue({
		el : '#content',
		data : {
			question : {},
            commentId:$("#commentId").val(),
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
			addForm : function() {
				vue.question = {};
				this.question.commentId=this.commentId;
                clearVailator();
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/question/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.question=r.data;
						clearVailator();
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
							vue.question= r.data;
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
					fileName : 'question'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/question/list?pid=")+vue.commentId;
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				content : {
					required : true
				},
				proportion : {
					required : true
				},
				questionCategoryId : {
					required : true
				},
				optiona : {
					required : true
				},
				optionb : {
					required : true
				},
				optionc : {
					required : true
				},
				optiond : {
					required : true
				},
				optione : {
					required : true
				},
				type : {
					required : true
				},
				remark : {
					required : true
				},
				answer : {
					required : true
				}			},
			messages : {
				content : {
					required : "请填写"
				},
				proportion : {
					required : "请填写"
				},
				questionCategoryId : {
					required : "请填写"
				},
				optiona : {
					required : "请填写"
				},
				optionb : {
					required : "请填写"
				},
				optionc : {
					required : "请填写"
				},
				optiond : {
					required : "请填写"
				},
				optione : {
					required : "请填写"
				},
				type : {
					required : "请填写"
				},
				remark : {
					required : "请填写"
				},
				answer : {
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
			title : '内容',
			field : 'content',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
                title : '分类',
                field : 'type',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'5%',
                formatter:function(value,row,index){
                    if(value==1){
                    	return '<span class="btn btn-xs btn-success">选择题</span>';
					}else{
                        return '<span class="btn btn-xs btn-success">主观题</span>';
					};
                }
            }, 			{
			title : '分值',
			field : 'proportion',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '选项A',
			field : 'optiona',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'8%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '选项B',
			field : 'optionb',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'8%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '选项C',
			field : 'optionc',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'8%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '选项D',
			field : 'optiond',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'8%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '选项E',
			field : 'optione',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'8%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		} , 			{
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
			title : '答案',
			field : 'answer',
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
