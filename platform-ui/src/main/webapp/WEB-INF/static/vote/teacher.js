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
            },
            errorFormat:function (value) {
                    return errorMessageFormat(value);
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
								_this.collegeUser.collegeId=r.data.collegeId;
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
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/sysuser/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.collegeUser= r.data;
							openForm("查看详情",550,"detailswrap");
						}
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
					fileName : 'sysUser'
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
		var url=transUrl("/sysuser/tlist");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				username : {
					required : true,
                    minlength:2,
                    maxlength:10,
				},
                number:{
                    required:true,
                    minlength:6,
                    maxlength:15,
                    remote : {
                        type : "get",
                        url : transUrl("/account/number"),
                        dataType : "html",
                        dataFilter : function(r) {
                            r=JSON.parse(r);
                            if(r.code==0){
                                return true;
                            }
                            return false;
                        }
                    }
                },
				password : {
					required : true,
                    minlength:6,
                    maxlength:16,
				},
				email : {
					required : true,
                    email:true
				},
				mobile : {
					required : true,
                    minlength:11
				}
            },
			messages : {
				username : {
					required : "请填写",
                    minlength:'2-10字符串',
                    maxlength:'2-10字符串',
				},
                number : {
                    required : "请输入学号",
                    minlength : "6-15个字符",
                    maxlength : "6-15个字符",
                    remote:"学号已注册"
                },
				password : {
					required : "请填写",
                    minlength:'至少6位',
                    maxlength:'最多16位',
				},
				email : {
					required : "请填写",
					email:'格式错误'
				},
				mobile : {
					required : "请填写",
                    minlength:"格式错误"
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
		}},
			{
			title : '姓名',
			field : 'username',
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
                title : '学院',
                field : 'collegeName',
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
			field : 'email',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, 			{
			title : '手机号',
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
			title : '状态',
			field : 'status',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return transAccountStatus(value);
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
            }
		];
	};
