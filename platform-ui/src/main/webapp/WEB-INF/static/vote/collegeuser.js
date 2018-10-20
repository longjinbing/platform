		var vue = new Vue({
		el : '#content',
		data : {
            collegeUser : {},
            provinceList: [],
            cityList: [],
            universityList: [],
            collegeList: [],
            province: 0,
            city: 0,
            university: 0,
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
            getCollege:function(){
                var _this=this;
                $.get(transUrl("/university/college"),function(r){
                    _this.provinceList=r.data;
                    _this.province=_this.provinceList[0].id;
                })
            },
            editForm : function() {
                var id=getSelectedRow();
                if (id != '') {
                    var _this=this;
                    _this.collegeUser.userId=id;
                    var url=transUrl("/collegeuser/");
                    $.get(url+ id, function (r) {
                        if(check(r)){
                            if(r.data!=null){
                                _this.collegeUser=r.data;
                                for(var i=0;i<_this.provinceList.length;i++) {
                                    for (var j = 0; j < _this.provinceList[i].citys.length; j++) {
                                        for (var k = 0; k < _this.provinceList[i].citys[j].universitys.length; k++) {
                                            for (var m = 0; m < _this.provinceList[i].citys[j].universitys[k].colleges.length; m++) {
                                                if (_this.provinceList[i].citys[j].universitys[k].colleges[m].id == _this.collegeUser.collegeId) {
                                                    _this.province = _this.provinceList[i].id;
                                                    _this.city = _this.provinceList[i].citys[j].id;
                                                    _this.university = _this.provinceList[i].citys[j].universitys[k].id;
                                                }
                                            }
                                        }
                                    }
                                }
                            }else{
                                _this.province = _this.provinceList[0].id;
                            }
                            clearVailator();
                            openForm("修改信息");
                        }
                    });
                    if(vue.collegeUser==null){alert("网络错误")}
                }

            },
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/collegeuser/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.collegeUser= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/collegeuser/delete");
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
				var url = vue.collegeUser.id == null ? transUrl("/collegeuser/save") : transUrl("/collegeuser/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.collegeUser),
					success : function(r) {
						if(check(r)){
							vue.reload();
							vue.$data.collegeUser={};
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
					fileName : 'collegeUser'
				})
			}
		},
            created:function () {
                this.getCollege();
            },
            watch:{
                province:function(val){
                    console.log("省份")
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
                    console.log("市")
                    for(var i=0;i<this.cityList.length;i++){
                        if(this.cityList[i].id==val){
                            if(this.cityList[i].universitys==undefined){
                                this.cityList[i].universitys=[];
                            }
                            this.universityList=this.cityList[i].universitys;
                        };
                    }
                    if(this.universityList.length==0){
                        var obj={
                            id:0,
                            name:'暂无相关学校信息'
                        }
                        this.universityList.push(obj);
                    }
                    this.university=this.universityList[0].id
                },
                university:function(val){
                    for(var i=0;i<this.universityList.length;i++){
                        if(this.universityList[i].id==val){
                            if(this.universityList[i].colleges==undefined){
                                this.universityList[i].colleges=[];
                            }
                            this.collegeList=this.universityList[i].colleges;

                        };
                    }
                    if(this.collegeList.length==0){
                        var obj={
                            id:0,
                            name:'暂无相关学院信息'
                        }
                        this.collegeList.push(obj);
                    }
                    this.collegeUser.collegeId=this.collegeList[0].id;

                }
            }
	});
	var validator;
	$(function() {
		var url=transUrl("/collegeuser/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				collegeId : {
					required : true
				},
				userId : {
					required : true
				},
				creataTime : {
					required : true
				},
				remark : {
					required : true
				}			},
			messages : {
				collegeId : {
					required : "请填写"
				},
				userId : {
					required : "请填写"
				},
				creataTime : {
					required : "请填写"
				},
				remark : {
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
                title : '学校',
                field : 'universityName',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'12%',
                formatter:function(value,row,index) {
                    if (value == undefined) {
return '<span class="btn btn-xs btn-danger">请修改教师所属学校信息</span>';
                    } else {
                        return overflowHidden(value, 20);
                    }
                }
            },
			{
			title : '学院',
			field : 'collegeName',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
                if (value == undefined) {
                    return '<span class="btn btn-xs btn-danger">请修改教师所属学院信息</span>';
                } else {
                    return overflowHidden(value, 20);
                }
			}
		}, 			{
			title : '教师',
			field : 'username',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
                title : '工号',
                field : 'number',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'12%',
                formatter:function(value,row,index){
                    return overflowHidden(value,20);
                }
            }, 			{
                title : '手机',
                field : 'mobile',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'12%',
                formatter:function(value,row,index){
                    return overflowHidden(value,20);
                }
            }, 			{
                title : '邮箱',
                field : '',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'12%',
                formatter:function(value,row,index){
                    return overflowHidden(value,20);
                }
            }, 			{
			title : '注册时间',
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
