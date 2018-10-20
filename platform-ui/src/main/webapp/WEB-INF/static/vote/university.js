		var vue = new Vue({
		el : '#content',
		data : {
			university : {},
			sysRegion:{}
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
			addForm : function() {
				vue.university = {};
                vue.university.regionId=vue.sysRegion.id;
                vue.university.regionName=vue.sysRegion.name;
                clearVailator();
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/university/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.university=r.data;
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.university==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/university/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.university= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/university/delete");
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
				delete vue.university.regionName;
				delete vue.university.createName;
				var url = vue.university.id == null ? transUrl("/university/save") : transUrl("/university/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.university),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.university={};
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
					fileName : 'university'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/university/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
            rules : {
                name : {
                    required : true
                },
                regionId : {
                    required : true
                },
                remark : {
                    required : true
                },
                contacts : {
                    required : true
                },
                phone : {
                    required : true
                }			},
            messages : {
                name : {
                    required : "请填写"
                },
                regionId : {
                    required : "请填写"
                },
                remark : {
                    required : "请填写"
                },
                contacts : {
                    required : "请填写"
                },
                phone : {
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
                        return overflowHidden(value,20);
                    }
                }, 			{
                    title : '地区',
                    field : 'regionName',
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
                    title : '联系人',
                    field : 'contacts',
                    align : 'left',
                    visible : true,
                    sortable:true,
                    valign : 'middle',
                    width:'12%',
                    formatter:function(value,row,index){
                        return overflowHidden(value,20);
                    }
                }, 			{
                    title : '电话',
                    field : 'phone',
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
        var yntree;
        $.get(transUrl("/sysregion/ztreelist"),function(r){
            var data=r.data;
            var result=[];
            for(var i=0;i<data.length;i++){
                result.push(getNode(data[i]));
            }
            var treeData = {
                onchange: function (input, yntree){
                	var e=$(input);
                	if(e.parent().parent().next().find("li").length<=0){
                        var url=transUrl("/university/list?pid=")+e.val();
                        $('#datatable').bootstrapTable('refresh', {'silent': true,'url':url});
                        vue.sysRegion.id=e.val();
                        vue.sysRegion.name=e.parent().text().trim();
                        top.layer.msg('已选择'+vue.sysRegion.name);
					}else{
                        top.layer.msg('请选择市区域');
					}
                    e.prop("checked",false);
                },
                // 是否严格的遵循父子互相关联的做法
                checkStrictly: true,
                data:result
            };
            $("#region-tree").html("");
            yntree = new YnTree(document.getElementById("region-tree"), treeData);
            $("#region-tree>ul>li>ul>li span").remove();
        })

        function getNode(node){
            var obj=node;
            if(node.children.length>0){
                var result=[];
                for(var i=0;i<node.children.length;i++){
                    result.push(getNode(node.children[i]));
                }
                obj.children=result;
            }
            obj.open=false;
            obj.value=obj.id;
            return obj;
		}
