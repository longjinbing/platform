		var vue = new Vue({
		el : '#content',
		data : {
			commentResult : {},
			questionList:[],
			answer:{},
			num:0,
			grades:{}
		},
        filters:{
            stringFormat:function (value) {
                return overflowHidden(value,25);
            }
        },
		methods : {
            addForm : function() {
                var id=getSelectedRow();
                if (id != '') {
                    var row=$("#datatable").bootstrapTable('getSelections');
                    if(row[0].status>1) {
                        top.layer.msg('评价已填写，无法填写');
                    }else {
                    	var _this=this;
                    	this.commentResult=row[0];
                        var url = transUrl("/question/list/")+row[0].commentsId;
                        $.get(url, function (r) {
                            if (check(r)) {
                                vue.questionList=r.data;
                                $("#questionmodal").modal("show");
                                $("#question-wrap").on("click","input",function () {
                                    if(_this.check()){
										$("#save-button").removeClass("disabled");
									}else {
                                        setTimeout(function () {
                                            _this.next();
                                        }, 500)
                                    }
                                });
                                $("#answer-wrap").on("click","div",function () {
                                _this.num=$(this).index();
                                });
                            }
                        });
                    }
                }
            },
            gradesForm:function(){
                var id=getSelectedRow();
                if (id != '') {
                    var row=$("#datatable").bootstrapTable('getSelections');
                    if(row[0].status==1) {
                        top.layer.msg('请先评价完成再次查看成绩');
                    }else {
                        var url = transUrl("/hcommentresult/result/")+row[0].id;
                        $.get(url, function (r) {
                            if (check(r)) {
								vue.grades=r.data;
                                $("#resultmodal").modal("show");
                            }
                        })
                    	}
                    }
			},
            saveanswer:function(){
				if(!this.check()){
					top.leyer.msg("请完成评价再提交");
				}else{
					this.answer.commentResultId=this.commentResult.id;
					this.answer.answers=[];
					for(var i=0;i<this.questionList.length;i++){
						this.answer.answers.push(this.questionList[i].answer);
					}
                        var url = this.commentResult.status==1?transUrl("/hcommentresult/save"):transUrl("/hcommentresult/update");
                    $.ajax({
                        type : "POST",
                        url : url,
                        contentType : "application/json",
                        data : JSON.stringify(this.answer),
                        success : function(r) {
                            if(check(r)){
                                vue.reload();
                                $("#questionmodal").modal("hide");
                                vue.num=0;
                                vue.questionList={};
                                tip("操作成功")
                            }
                        },
                        error : function() {
                            alert("网络错误，请稍后重试");
                        }
                    });
				}
			},
			check:function(){
            	var flag=true;
            for(var i=0;i<this.questionList.length;i++){
            	if(this.questionList[i].answer==undefined){
            		flag=false;
				}
			}
			return flag;
			},
            pre:function(){

            	if(this.num==0){
            		top.layer.msg("您已经到第一题了，没有上一题了");
				}else {
                    this.num--;
                }
			},
            next:function(){
            	if(this.num<this.questionList.length-1) {
                    this.num++;
                }else{
                    if(this.check()){
                        $("#save-button").removeClass("disabled");
					}
                    top.layer.msg("您已经答完了，可以进行提交");
				}
            },
            editForm : function() {
                var id=getSelectedRow();
                if (id != '') {
                    var row=$("#datatable").bootstrapTable('getSelections');
                    if(row[0].status==4) {
                        top.layer.msg('评价已经结束，无法填写');
                    }else if(row[0].status==3) {
                        top.layer.msg('评价已修改一次，无法再次修改');
                    }else if(row[0].status==1) {
                        top.layer.msg('评价还未填写，不需要修改');
                    }else {
                        var _this=this;
                        this.commentResult=row[0];
                        var url = transUrl("/question/list/")+row[0].commentsId;
                        $.get(url, function (r) {
                            if (check(r)) {
                                vue.questionList=r.data;
                                $("#questionmodal").modal("show");
                                $("#question-wrap").on("click","input",function () {
                                    if(_this.check()){
                                        $("#save-button").removeClass("disabled");
                                    }else {
                                        setTimeout(function () {
                                            _this.next();
                                        }, 500)
                                    }
                                });
                                $("#answer-wrap").on("click","div",function () {
                                    _this.num=$(this).index();
                                });
                            }
                        });
                    }
                }
            },
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/hcommentresult/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.commentResult= r.data;
							openForm("查看详情",550,"detailswrap");
						}
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
					fileName : 'commentResult'
				})
			}
		}
	});
	var validator;
	$(function() {
		var url=transUrl("/hcommentresult/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
        validator=$("#modal-form").validate({
            onfocusout: function(element) { $(element).valid(); },
			rules : {
				userId : {
					required : true
				},
				commentId : {
					required : true
				},
				questionId : {
					required : true
				},
				answer : {
					required : true
				},
				remark : {
					required : true
				},
				status : {
					required : true
				}			},
			messages : {
				userId : {
					required : "请填写"
				},
				commentId : {
					required : "请填写"
				},
				questionId : {
					required : "请填写"
				},
				answer : {
					required : "请填写"
				},
				remark : {
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
		}},			{
			title : '待评价学生',
			field : 'commentName',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'6%',
			formatter:function(value,row,index){
				return overflowHidden(value,20);
			}
		},			{
            title : '学号',
            field : 'number',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'8%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        },			{
            title : '课程名称',
            field : 'courseName',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'17%',
            formatter:function(value,row,index){
                return overflowHidden(value,15);
            }
        },			{
            title : '评价名称',
            field : 'commentsName',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'17%',
            formatter:function(value,row,index){
                return overflowHidden(value,15);
            }
        },			{
            title : '评价类型',
            field : 'commentsName',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'5%',
            formatter:function(value,row,index){
                if(row.userId==row.createId){
                    return "自我评价";
                }else{
                    return   "互相评价";
                }
            }
        },			{
            title : '教师姓名',
            field : 'teacherName',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'6%',
            formatter:function(value,row,index){
                return overflowHidden(value,20);
            }
        },			{
            title : '手机',
            field : 'teacherMobile',
            align : 'left',
            visible : true,
            sortable:true,
            valign : 'middle',
            width:'8%',
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
                    if(value==1){
                        return '<span class="btn btn-xs btn-danger">未评价</span>';
                    }else if(value==2){
                        return '<span class="btn btn-xs btn-success">已评价</span>';
                    }else if(value==3){
                        return '<span class="btn btn-xs btn-success">已修改</span>';
                    }else if(value==4){
                        return '<span class="btn btn-xs btn-success">已结束</span>';
                    }
                }
            }, 			{
			title : '评价时间',
			field : 'createTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
                if(row.status==1){
                    return comment(value);
                }else if(row.status==4||row.status==3||row.status==2){
                    if(value==undefined){
                        return '<span class="btn btn-xs btn-danger">未评价</span>';
                    }else {
                        return value;
                    }
                };
			}
		}, 			{
			title : '修改时间',
			field : 'updateTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
                if(row.status==1){
                    return comment(value);
                }else if(row.status==2){
                    return '<span class="btn btn-xs btn-success">允许修改</span>';
                }else if(row.status==3){
                    return '<span class="btn btn-xs btn-info">无法修改</span>';
                }else if(row.status==4){
                    return '<span class="btn btn-xs btn-info">无法修改</span>';
                } ;
			}
		}, 			{
			title : '成绩',
			field : 'remark',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'6%',
			formatter:function(value,row,index){
				if(value==undefined){
				    if(row.status==4){
				        return '<span class="btn btn-xs btn-danger">0.00</span>';
                    }else{
                        return "0.00";
                    }
				}else {
                    return overflowHidden(value, 20);
                }
			}
		}
		];
	};
	function comment(value) {
		if(value==undefined){
			return "<span class='btn btn-xs btn-danger'>请尽快完成评价</span>"
		}else{
            return value;
		}
    }
