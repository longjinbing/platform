		var vue = new Vue({
		el : '#content',
		data : {
			sysRole : {},
            deptlisturl:"/sysdept/deptlist",
			modalTitle:''
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
            change:function(obj){
            	Vue.set(this.sysRole,'deptId',obj.id);
                Vue.set(this.sysRole,'deptName',obj.name);
			},
			addForm : function() {
				vue.sysRole = {};
                clearVailator();
				openForm("新增");
			},
            menuForm:function(){
                var id= getSelectedRow();
                if (id != '') {
                	vue.sysRole.id=id;
                    var url=transUrl('/sysrolemenu/menulist/')+id;
                    $.get(url,function(r){
                    	var data=r.menulist;
                    	var result=[];
                    	for(var i=0;i<data.length;i++){
							result.push(getNode(data[i]));
						}
                        var treeData = {
                            onchange: function (input, yntree){
                            },
                            // 是否严格的遵循父子互相关联的做法
                            checkStrictly: true,
                            data:result
                        };
                        $("#tree").html("");
                        yntree = new YnTree(document.getElementById("tree"), treeData);
                        $("#tree ul>li ul>li ul>li span").remove();
                        vue.modalTitle="分配权限";
                        $("#menumodal").modal("show");
                    })
                }
            },
            saveMenu:function(){
                var url=transUrl("/sysrolemenu/save?id=")+vue.sysRole.id+"&menuIds="+yntree.getValues();
                $.get(url, function (r) {
                    if (r.code === 0) {
                    } else {
                        alert(r.msg);
                    }
                    $('#menumodal').modal('hide');
                });
            },
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/sysrole/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.sysRole=r.data;
						clearVailator();
                            refershselectztree();
						openForm("修改信息");
						}
				    });
					if(vue.sysRole==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/sysrole/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.sysRole= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/sysrole/delete");
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
				var url = vue.sysRole.id == null ? transUrl("/sysrole/save") : transUrl("/sysrole/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysRole),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.sysRole={};
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
					fileName : 'sysRole'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/sysrole/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
               parentId:{
                    required : true
				},
				name : {
					required : true
				},
				remark : {
					required : true
				},
				description : {
					required : true
				},
			},
			messages : {
                parentId:{
                    required : "请选择"
                },
				name : {
					required : "请填写"
				},
				remark : {
					required : "请填写"
				},
				description : {
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
		}},
			{
			title : '角色名称',
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

        function getNode(node){
        	var obj=node;
            if(node.children.length>0){
                var result=[];
                for(var i=0;i<node.children.length;i++){
                    result.push(getNode(node.children[i]));
                }
                obj.children=result;
            }
            obj.inputName="";
            obj.value=obj.id;
            obj.datas={};
            obj.disabled=false;
            return obj;
        }
        var yntree;

