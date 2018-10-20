		var vue = new Vue({
		el : '#content',
		data : {
			token : {}
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/token/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.token= r.data;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
           logout : function() {
                var id = getSelectedRows();
                if (id != '') {
                    confirm('用户将被退出本次登录？', function() {
                        var url=transUrl("/token/logout");
                        $.ajax({
                            type : "POST",
                            url : url,
                            contentType : "application/json",
                            data : JSON.stringify(id),
                            success : function(r) {
                                if(check(r)){
                                    vue.reload();
                                    tips("用户强制退出成功");
                                }
                            },
                            error : function() {
                                alert("网络错误，请稍后重试");
                            }
                        });
                    });
                }
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
					fileName : 'token'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/token/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				token : {
					required : true
				},
				expireTime : {
					required : true
				},
				ticket : {
					required : true
				},
			},
			messages : {
				token : {
					required : "请填写"
				},
				expireTime : {
					required : "请填写"
				},
				ticket : {
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
            width:'3%'
		}, 	{
			title : '序号',
			field : 'id',
			align : 'left',
			visible : true,
			width:'3%',
			valign : 'middle',
			formatter : function(value, row, index) {
				return autoId("datatable", index);
		}},             {
            title : '用户',
            field : 'createName',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'8%',
            formatter:function(value,row,index){
                return overflowHidden(value,15);
            }
        },
			{
			title : '登录凭证',
			field : 'ticket',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'20%',
			formatter:function(value,row,index){
				return overflowHidden(value,30);
			}
		},
            {
                title : '登录IP',
                field : 'ip',
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
                title: '身份凭证',
                field: 'principle',
                align: 'left',
                visible: true,
                sortable: true,
                valign: 'middle',
                width: '20%',
                formatter: function (value, row, index) {
                    return overflowHidden(value, 40);
                }
            }, 			{
			title : '登录时间',
			field : 'createTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		}, {
                title : '状态',
                field : 'remark',
                align : 'left',
                visible : true,
                sortable:true,
                valign : 'middle',
                width:'5%',
                formatter:function(value,row,index){
                    return '<span class="btn btn-xs btn-success">'+value+'</span>';
                }
            }, {
                title : '过期时间',
                field : 'expireTime',
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
