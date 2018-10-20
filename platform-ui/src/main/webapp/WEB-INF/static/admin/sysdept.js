		var vue = new Vue({
		el : '#content',
		data : {
			sysDept : {},
            parentId:0
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
            orderChange:function(num){
                this.sysDept.orderNum=num;
            },
			addForm : function() {
				vue.sysDept = {};
                clearVailator();
                vue.sysDept.parentId=vue.parentId;
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/sysdept/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.sysDept=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.sysDept==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/sysdept/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.sysDept= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/sysdept/delete");
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
				var url = vue.sysDept.id == null ? transUrl("/sysdept/save") : transUrl("/sysdept/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysDept),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.sysDept={};
							closeForm();
							tips("操作成功");
						}
					}
				});
			},
			reload : function() {
                var treeObj = $.fn.zTree.getZTreeObj("dept-tree");
                treeObj.destroy();
                $.get(transUrl("/sysdept/deptlist"),function(r){
                    zNodes=r.data;
                    /*获取服务器数据*/
                    treeObj = $.fn.zTree.init($("#dept-tree"), setting, zNodes);
                });
                tips("操作成功");
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
					fileName : 'sysDept'
				})
			}
		}
	});
	var validator;
        var setting = {
            view: {
                selectedMulti: false
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            check:{
                enable: false,
                chkStyle: "checkbox",
                chkboxType: { "Y": "p", "N": "s" }
            },
            callback: {
                onClick: zTreeOnClick
            }

        };
        function zTreeOnClick(event, treeId, treeNode){
            var url=transUrl("/sysdept/list?pid=")+treeNode.id;
            $('#datatable').bootstrapTable('refresh', {'silent': true,'url':url});
            vue.$data.parentId=treeNode.id;
            event.preventDefault();
            event.stopPropagation();
        }
	$(function() {
        $.get(transUrl("/sysdept/deptlist"),function(r){
            var zNodes=r.data;
            vue.$data.parentId=r.data[0].id;
            var zTreeObj = $.fn.zTree.init($("#dept-tree"), setting, zNodes);
            var url=transUrl("/sysdept/list?pid=")+vue.$data.parentId;
            var table = new BSTable("datatable", url,
                initColumn());
            table.init();
        })
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				parentId : {
					required : true
				},
				name : {
					required : true
				},
				orderNum : {
					required : true
				},
			},
			messages : {
				parentId : {
					required : "请填写"
				},
				name : {
					required : "请填写"
				},
				orderNum : {
					required : "请填写"
				},
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
		}},		{
			title : '部门名称',
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
			title : '排序',
			field : 'orderNum',
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

