<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.CollegeEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!doctype html>
 <html lang="zh-CN">
 <head>
   <meta charset="UTF-8">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
   
  <style type="text/css">
  
     *{
        text-align: center;
     }
  </style>
   <title>Document</title>
 </head>
 <body>
  <div class="container">
     <div id="table" class="mt10">
      <div class="box_bottom pb5 pt5 pr10" style="border-top:1px solid #dadada;">
              <div class="search_bar_btn" style="text-align:right;">
                 <a href="college/add.jsp" class="ext_btn"><span class="add"></span>添加</a>
              </div>
            </div>
     
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="10%">编号</th>
                   <th width="30%">学院名称</th>
                   <th width="50%">学院备注</th>
                   <th width="10%">修改</th>
                </tr>
                
     <%
        List<CollegeEntity> ar=(ArrayList)request.getAttribute("myar");
         for(int i=0;i<ar.size();i++)
         {
     %>
       <tr class="tr">
         <td><%=ar.get(i).getEid() %></td>
         <td><%=ar.get(i).getEname() %></td>
         <td><%=ar.get(i).getEremark() %></td>
         <td><a href="${pageContext.request.contextPath }/CollegeServlet?action=one&eid=<%=ar.get(i).getEid() %>">修改</a></td>
      </tr>
      <%
         }
      %>
           </table>
        </div>
     </div>
   </div> 
 </body>
 </html>
  