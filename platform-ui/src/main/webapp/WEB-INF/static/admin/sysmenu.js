		var vue = new Vue({
		el : '#content',
		data : {
			sysMenu : {},
            parentId: 0
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
            orderChange:function(num){
            	this.sysMenu.orderNum=num;
			},
            statusChange:function(value){
            	this.sysMenu.status=value;
			},
			addForm : function() {
				vue.sysMenu = {};
                clearVailator();
                vue.sysMenu.parentId=vue.parentId;
				openForm("新增");
			},
            refershMenu:function(){
                var url=transUrl("/sysmenu/reset");
                confirm('确定要初始化系统吗，系统将恢复初始状态？', function() {
                    $.get(url, function (r) {
                        if(check(r)){
                            tips("初始化成功");
                            top.location.href=transUrl("/logout");
                        }
                    });
                });

            },
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/sysmenu/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.sysMenu=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.sysMenu==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/sysmenu/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.sysMenu= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/sysmenu/delete");
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
				var url = vue.sysMenu.id == null ? transUrl("/sysmenu/save") : transUrl("/sysmenu/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysMenu),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.sysMenu={};
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
					fileName : 'sysMenu'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/sysmenu/list?pid=0");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				parentId : {
					required : true
				},
				name : {
					required : true
				},
				url : {
					required : true
				},
				type : {
					required : true
				},
				icon : {
					required : true
				}
			},
			messages : {
				parentId : {
					required : "请填写"
				},
				name : {
					required : "请填写"
				},
				url : {
					required : "请填写"
				},
				type : {
					required : "请填写"
				},
				icon : {
					required : "请填写"
				}
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
		}},			{
			title : '菜单名称',
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
			title : '菜单URL',
			field : 'url',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '类型',
			field : 'type',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'8%',
			formatter:function(value,row,index){
				return transDirectoryType(value);
			}
		}, 			{
			title : '菜单图标',
			field : 'icon',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return '<span class="'+value+'"></span>';
			}
		}, 			{
			title : '排序',
			field : 'orderNum',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
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
				return transMenuStatus(value);
			}
		}, 			{
			title : '创建时间',
			field : 'updateTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
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
			width:'15%',
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
        var setting = {
            view: {
                selectedMulti: false
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
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
        $.get(transUrl("/sysmenu/ztreelist"),function(r){
            var zNodes=r.data;
            /*获取服务器数据*/
            var zTreeObj = $.fn.zTree.init($("#menu-tree"), setting, zNodes);
        })
        function zTreeOnClick(event, treeId, treeNode){
            var url=transUrl("/sysmenu/list?pid=")+treeNode.id;
            $('#datatable').bootstrapTable('refresh', {'silent': true,'url':url});
            vue.$data.parentId=treeNode.id;
            event.preventDefault();
            event.stopPropagation();
        }
