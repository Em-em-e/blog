<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<link type="text/css" rel="stylesheet" href="manager/css/style.css" />
<%// String basePath=(String)request.getAttribute("basePath"); %>
<div id="data">
<table id="datalist">
  <thead >
  	<tr>
  		<td>ID</td>
  		<td>留言内容</td>
  		<td>图片</td>
  		<td>留言日期</td>
  		<td>操作</td>
  	</tr>
  </thead>
  <s:iterator value="list" var="">
  		<tr>
    		<td><s:property value="id"/></td>
    		<td><s:property value="msg"/></td>
    		<td><s:property value="photo"/></td>
    		<td><s:property value="time"/></td>
    		<td><a href="">修改</a>  <a href="">删除</a></td>
  		</tr>
  </s:iterator>
</table>
</div>

<div id="pages">
   <a href="moodlist.action?page=${page==1?page:page-1}">上一页</a>
   <s:iterator begin="1" end="totalPage" var="p">
   	 <s:if test="#p==page">
       <a href="#" class="current_page">${p}</a>
   	 </s:if>
     <s:else>
      <a href="moodlist.action?page=${p}">${p}</a>
   	 </s:else>
   </s:iterator>
   <a href="moodlist.action?page=${page==totalPage?page:page+1}">下一页</a>
</div>
