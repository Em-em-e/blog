<%@ page language="java" pageEncoding="utf-8"
 contentType="text/html;charset=utf-8"%>	
<%@taglib prefix="s" uri="/struts-tags" %>
<% String path=application.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>CODER-LI的博客</title>
<meta name="keywords" content="个人博客,李亮个人博客,李亮" />
<link href="<%=path %>/css/base.css" rel="stylesheet">
<link href="<%=path %>/css/mood.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>
<header>
  <div id="logo"><a href="/"></a></div>
  <nav class="topnav" id="topnav"><a href="index.html"><span>首页</span><span class="en">Protal</span></a><a href="about.html"><span>关于我</span><span class="en">About</span></a><a href="moodlist.action"><span>碎言碎语</span><span class="en">Doing</span></a><a href="share.html"><span>模板分享</span><span class="en">Share</span></a><a href="knowledge.html"><span>学无止境</span><span class="en">Learn</span></a><a href="book.html"><span>留言版</span><span class="en">Gustbook</span></a>
  </nav>
</header>
<div class="moodlist">
  <h1 class="t_nav"><span>删删写写，回回忆忆，虽无法行云流水，却也可碎言碎语。</span><a href="/" class="n1">网站首页</a><a href="/" class="n2">碎言碎语</a></h1>
  <div class="bloglist">
  	<s:iterator var="m" value="list">
  		<ul class="arrow_box">
    		<div class="sy">
    		<s:if test="photo!=null">
    			<s:if test='photo!=""'>
    				<img src="<%=basePath %>images/<s:property value="photo"/>">
    			</s:if>
    		</s:if>
    		<p><s:property value="msg"/></p>
    		</div>
    		<span class="dateview"><s:property value="time"/></span>
    	</ul>
  	</s:iterator>
  </div>
  <div class="page">
  		<a href="moodlist.action?page=1">1</a>
  		<a class="title_a" title="Total record"><b>${totalPage}</b></a>
        <s:iterator begin="page" end="totalPage" var="p">
        	<s:if test="#p==page">
        	   <a class="if_a">${p}</a>
        	</s:if>
        	<s:else>
        	   <a href="moodlist.action?page=${p}">${p}</a>
        	</s:else>
        </s:iterator>
        <a href="moodlist.action?page=${page==totalPage?page:page+1}">&gt;</a>
        <a href="moodlist.action?page=${totalPage}">&gt;&gt;</a>
  </div>
</div>
<footer>
  <p>Design by DanceSmile <a href="http://www.miitbeian.gov.cn/" target="_blank">鄂ICP备15021396号</a> </p>
</footer>
<script src="js/silder.js"></script>
</body>
</html>