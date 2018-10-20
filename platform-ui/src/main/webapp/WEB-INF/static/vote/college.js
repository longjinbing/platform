		var vue = new Vue({
		el : '#content',
		data : {
			college : {},
            provinceList:[],
            cityList:[],
            schoolList:[],
			province:[],
			city:[],
			school:[]
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
			getRegion:function(){
				var _this=this;
                $.get(transUrl("/university/school"),function(r){
                	_this.provinceList=r.data;
                	_this.province=_this.provinceList[0].id;
				})
			},
			addForm : function() {
                if (this.provinceList.length == 0) {
                this.getRegion();
                }
				vue.college = {};
                clearVailator();
				openForm("新增");
			},
			editForm : function() {
				var _this=this;
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/college/");
					$.get(url+ id, function (r) {
						if(check(r)){
						_this.college=r.data;
                            if (_this.provinceList.length == 0) {
                                _this.getRegion();
                            }
                            for(var i=0;i<_this.provinceList.length;i++){
                                for(var j=0;j<_this.provinceList[i].citys.length;j++){
                                    for(var k=0;k<_this.provinceList[i].citys[j].universitys.length;k++){
										if(_this.provinceList[i].citys[j].universitys[k].id==_this.college.univerityId){
											_this.city=_this.provinceList[i].citys[j].id;
											_this.province=_this.provinceList[i].id;
										}
                                    }
                                }
							}
						clearVailator();
						openForm("修改信息");
						}
				    });
					if(vue.college==null){alert("网络错误")}
				}

			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/college/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.college= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/college/delete");
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
				var url = vue.college.id == null ? transUrl("/college/save") : transUrl("/college/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.college),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.college={};
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
					fileName : 'college'
				})
			}
		},
			watch:{
			province:function(val){
					for(var i=0;i<this.provinceList.length;i++){
						if(this.provinceList[i].id==val){
                            if(this.provinceList[i].citys==undefined){
                                this.provinceList[i].citys=[];
                            }
							this.cityList=this.provinceList[i].citys;
						};
					}
					if(this.cityList.length==0){
						var obj={
							id:0,
							name:'暂无相关地区信息'
						}
						this.cityList.push(obj);
					}
					this.city=this.cityList[0].id;
			},
                city:function(val){
                        for(var i=0;i<this.cityList.length;i++){
                            if(this.cityList[i].id==val){
                                if(this.cityList[i].universitys==undefined){
                                    this.cityList[i].universitys=[];
                                }
                                this.schoolList=this.cityList[i].universitys;
                            };

                    }
                    if(this.schoolList.length==0){
                        var obj={
                            id:0,
                            name:'暂无相关学校信息'
                        }
                        this.schoolList.push(obj);
                    }
                    this.college.univerityId=this.schoolList[0].id
                }
			}
	});
	var validator;
	$(function() {
		var url=transUrl("/college/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				name : {
					required : true
				},
				remark : {
					required : true
				},
				univerityId : {
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
				remark : {
					required : "请填写"
				},
				univerityId : {
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
		}}, 			{
            title : '学校',
            field : 'universityName',
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
			title : '操作时间',
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
            }
		];
	};
