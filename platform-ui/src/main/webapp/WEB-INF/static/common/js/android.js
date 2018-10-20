$(function(){
	var w=parseInt(window.screen.width);
	if(w>500){
		w=500;
	}
	var fontSize=(w/(34*16))*100+'%';
	$("html").css("font-size",fontSize);
})
function img(obj,options) {
	var size=parseInt(window.screen.width)/34;
		obj.jqthumb({
			width : options.width*size,
			height : options.height*size,
			after : function(imgObj) {
				imgObj.css('opacity', 0).animate({
					opacity : 1
				}, 0);
			}
		});
	}
function transPublishTime(time){
	var minute = 1000 * 60;
	var hour = minute * 60;
	var day = hour * 24;
	var halfamonth = day * 15;
	var month = day * 30;
	var year = month * 12;
	var date = new Date(time);
    var dateTimeStamp = date.getTime();
    var now = new Date().getTime();
    var diffValue = now - dateTimeStamp;
    if(diffValue < 0){
    	 return "";
    }
    	var yearC =diffValue/year;
    	var monthC =diffValue/month;
    	var weekC =diffValue/(7*day);
    	var dayC =diffValue/day;
    	var hourC =diffValue/hour;
    	var minC =diffValue/minute;
    	if(yearC>=1){
       	 result=parseInt(yearC) + "年前";
       	 }else if(monthC>=1){
    	 result=parseInt(monthC) + "月前";
    	 }
    	 else if(weekC>=1){
    	 result=parseInt(weekC) + "周前";
    	 }
    	 else if(dayC>=1){
    	 result=parseInt(dayC) +"天前";
    	 }
    	 else if(hourC>=1){
    	 result=parseInt(hourC) +"小时前";
    	 }
    	 else if(minC>=1){
    	 result=parseInt(minC) +"分钟前";
    	 }else{
    	 result="刚刚";
    	 }
    	return result;
}
// 图片懒加载
function lazyImg(){
	 // 获取window的引用:
    var $window = $(window);
    // 获取包含data-src属性的img，并以jQuery对象存入数组:
    var lazyImgs = $.map($('img[data-src]').get(), function (i) {
        return $(i);
    })
     // 定义事件函数:
      var onScroll = function() {
            // 获取页面滚动的高度:
            var wtop = $window.scrollTop();
            // 判断是否还有未加载的img:
            if (lazyImgs.length > 0) {
                // 获取可视区域高度:
                var wheight = $window.height();
                // 存放待删除的索引:
                var loadedIndex = [];
                // 循环处理数组的每个img元素:
                $.each(lazyImgs, function (i, item) {
                    // 判断是否在可视范围内:
                	if ($(item).offset().top - wtop < wheight+40) {
                        // 设置src属性:
                		$(item).attr('src', $(item).attr('data-src'));
                        // 添加到待删除数组:
                        loadedIndex.unshift(i);
                    }
                });
                // 删除已处理的对象:
                $.each(loadedIndex, function (index) {
                    lazyImgs.splice(index, 1);
                });
            }
        };
        // 绑定事件:
        $window.scroll(onScroll);
        // 手动触发一次:
        onScroll();
}

function transUrl(url){
	var rootarr=window.location.href.split('/');
    return rootarr[0]+'//'+rootarr[2]+'/'+rootarr[3]+url;
}
function check(r){
	console.log(1);
	if(r.code==403){
		if(isAndroid()){
			window.location.href="js://webview?action=login&url="+window.location.href;
		}else{
			window.location.href=transUrl("/android/login.html");
		}
		return false;
	}else if(r.code==0){
		return true;
	}else if(r.code==-1){
		console.log(r.code)
		if(r.msg=="未知异常：登录状态异常"){
			if(isAndroid()){
				window.location.href="js://webview?action=login&url="+window.location.href;
			}else{
				window.location.href=transUrl("/android/login.html");
			}
		}else{
		tip("网络环境出现问题");
		}
	}
	
}
function tip(msg){
	layer.msg(msg);
}

function isAndroid(){
	var u = navigator.userAgent;
	var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1;
	return isAndroid;
}

function shareTo(type){
	layer.closeAll();
	tip("分享功能正在上线中，暂时不可用");
}

function share(){
	parent.layer.open({
        title: false,// 标题
        type: 1,// 打开窗口的类型 1：html里的div内容 2：iframe方式，页面的路径
        anim: 2,
        content: $('#share'),
        shade:0,
        closeBtn:0,
        isOutAnim:false
    })
}
function goBack(){
		if(history.length > 1){
            window.history.go( -1 );
        }else{
        	window.location.href = "js://webview?action=goBack";
        }
}