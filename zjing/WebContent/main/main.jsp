<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.SuperSlide.js"></script>
  <script type="text/javascript">
  $(function(){
      $(".sideMenu").slide({
         titCell:"h3", 
         targetCell:"ul",
         defaultIndex:0, 
         effect:'slideDown', 
         delayTime:'500' , 
         trigger:'click', 
         triggerTime:'150', 
         defaultPlay:true, 
         returnDefault:false,
         easing:'easeInQuint',
         endFun:function(){
              scrollWW();
         }
       });
      $(window).resize(function() {
          scrollWW();
      });
  });
  function scrollWW(){
    if($(".side").height()<$(".sideMenu").height()){
       $(".scroll").show();
       var pos = $(".sideMenu ul:visible").position().top-38;
       $('.sideMenu').animate({top:-pos});
    }else{
       $(".scroll").hide();
       $('.sideMenu').animate({top:0});
       n=1;
    }
  } 

var n=1;
function menuScroll(num){
  var Scroll = $('.sideMenu');
  var ScrollP = $('.sideMenu').position();
  /*alert(n);
  alert(ScrollP.top);*/
  if(num==1){
     Scroll.animate({top:ScrollP.top-38});
     n = n+1;
  }else{
    if (ScrollP.top > -38 && ScrollP.top != 0) { ScrollP.top = -38; }
    if (ScrollP.top<0) {
      Scroll.animate({top:38+ScrollP.top});
    }else{
      n=1;
    }
    if(n>1){
      n = n-1;
    }
  }
}
  </script>
  <style>
  	li{
  		cursor: pointer;
  	}
  </style>
  <title>后台首页</title>
</head>
<body>
    <div class="top">
      <div id="top_t">
        <div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
          <div id="photo" class="fl">
            <a href="#"><img src="images/a.png" alt="" width="60" height="60"></a>
          </div>
          <div id="base_info" class="fr">
            <div class="help_info">
              <a href="1" id="hp">&nbsp;</a>
              <a href="2" id="gy">&nbsp;</a>
              <a href="3" id="out">&nbsp;</a>
            </div>
            <div class="info_center">
              admin
              <span id="nt">通知</span><span><a href="#" id="notice">3</a></span>
            </div>
          </div>
        </div>
      </div>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：</div>
      </div>
    </div>
    <div class="side">
        <div class="sideMenu" style="margin:0 auto">
          <h3>导航菜单</h3>
          <ul id="father">
            <li><a href="${pageContext.request.contextPath }/CollegeServlet?action=all" target="right">学院管理</a></li>
            <li><a href="${pageContext.request.contextPath }/DeptServlet?action=all" target="right">系别管理</a></li>
            <li><a href="${pageContext.request.contextPath }/MojarServlet?action=all" target="right">专业管理</a></li>
            <li><a href="${pageContext.request.contextPath }/GradeServlet?action=all" target="right">年级管理</a></li>
            <li><a href="${pageContext.request.contextPath }/MyclassServlet?action=all" target="right">班级管理</a></li>
          </ul>
          <h3> 导航菜单</h3>
          <ul>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
          </ul>
          <h3> 导航菜单</h3>
          <ul>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
          </ul>
          <h3>导航菜单</h3>
          <ul>
            <li >导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li class="on">导航菜单</li>
            <li>导航菜单</li>
          </ul>
          <h3> 导航菜单</h3>
          <ul>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
          </ul>
          <h3> 导航菜单</h3>
          <ul>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
            <li>导航菜单</li>
          </ul>
       </div>
    </div>
    <div class="main">
       <iframe name="right" id="rightMain" src="${pageContext.request.contextPath }/main/right.jsp" frameborder="no" scrolling="auto" width="100%" height="auto" allowtransparency="true"></iframe>
    </div>
    <div class="bottom">
      <div id="bottom_bg">版权</div>
    </div>
    <div class="scroll">
          <a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a>
          <a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
    </div>
    <script>
    	var father = document.getElementById("father");
    	var father_li = father.getElementsByTagName("li");
    	for(var i = 0;i<father_li.length;i++){
    		father_li[i].index = i;
    		father_li[i].onclick = function(){
    			for(var j = 0;j < father_li.length;j++){
    				father_li[j].className = "";
    			}
    			father_li[this.index].className = "on";
    		}
    	}
    </script>
</body>

</html>
   
 