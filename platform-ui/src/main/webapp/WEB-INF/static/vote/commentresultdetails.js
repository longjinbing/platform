		var vue = new Vue({
		el : '#content',
		data : {
			commentResultDetails : {}
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
			addForm : function() {
				vue.commentResultDetails = {};
                clearVailator();
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/commentresultdetails/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.commentResultDetails=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.commentResultDetails==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/commentresultdetails/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.commentResultDetails= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/commentresultdetails/delete");
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
				var url = vue.commentResultDetails.id == null ? transUrl("/commentresultdetails/save") : transUrl("/commentresultdetails/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.commentResultDetails),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.commentResultDetails={};
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
					fileName : 'commentResultDetails'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/commentresultdetails/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				commentResultId : {
					required : true
				},
				a1 : {
					required : true
				},
				a2 : {
					required : true
				},
				a3 : {
					required : true
				},
				a4 : {
					required : true
				},
				a5 : {
					required : true
				},
				a6 : {
					required : true
				},
				a7 : {
					required : true
				},
				a8 : {
					required : true
				},
				a9 : {
					required : true
				},
				a10 : {
					required : true
				},
				a11 : {
					required : true
				},
				a12 : {
					required : true
				},
				a13 : {
					required : true
				},
				a14 : {
					required : true
				},
				a15 : {
					required : true
				},
				a16 : {
					required : true
				},
				a17 : {
					required : true
				},
				a18 : {
					required : true
				},
				a19 : {
					required : true
				},
				a20 : {
					required : true
				},
				status : {
					required : true
				}			},
			messages : {
				commentResultId : {
					required : "请填写"
				},
				a1 : {
					required : "请填写"
				},
				a2 : {
					required : "请填写"
				},
				a3 : {
					required : "请填写"
				},
				a4 : {
					required : "请填写"
				},
				a5 : {
					required : "请填写"
				},
				a6 : {
					required : "请填写"
				},
				a7 : {
					required : "请填写"
				},
				a8 : {
					required : "请填写"
				},
				a9 : {
					required : "请填写"
				},
				a10 : {
					required : "请填写"
				},
				a11 : {
					required : "请填写"
				},
				a12 : {
					required : "请填写"
				},
				a13 : {
					required : "请填写"
				},
				a14 : {
					required : "请填写"
				},
				a15 : {
					required : "请填写"
				},
				a16 : {
					required : "请填写"
				},
				a17 : {
					required : "请填写"
				},
				a18 : {
					required : "请填写"
				},
				a19 : {
					required : "请填写"
				},
				a20 : {
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
			title : '',
			field : 'commentResultId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a1',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a2',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a3',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a4',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a5',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a6',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a7',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a8',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a9',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a10',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a11',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a12',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a13',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a14',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a15',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a16',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a17',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a18',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a19',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
			field : 'a20',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '',
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
			title : '',
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
			title : '',
			field : 'status',
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
