<%@page import="com.svse.entity.*"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  *
  {
    font-size: 12px;
    text-align: center;
  }
  table
  {
    border-collapse: collapse;
    width: 80%;
  }
  td
  {
    border:solid 1px red;
    line-height: 25px;
  }
</style>
</head>
<body>   

   <table align="center">
      <tr>
         <td>编号</td>
         <td>所在学院</td>
         <td>系别名</td>
         <td>修改</td>
         <td>删除</td>
      </tr>
      <%
        List<DeptEntity> ar=(ArrayList)request.getAttribute("myar");
         for(int i=0;i<ar.size();i++)
         {
      %>
       <tr>
         <td><%=ar.get(i).getPid() %></td>
         <td><%=ar.get(i).getEname() %></td>
         <td><%=ar.get(i).getPname() %></td>
         <td><a href="${pageContext.request.contextPath }/DeptServlet?action=one&pid=<%=ar.get(i).getPid() %>">修改</a></td>
         <td><a href="${pageContext.request.contextPath }/DeptServlet?action=del&pid=<%=ar.get(i).getPid() %>">删除</a></td>
      </tr>
      <%
         }
      %>
      <tr>
        <td colspan="6">
           <a href="${pageContext.request.contextPath }/DeptServlet?action=allp">增加系别</a>
        </td>
      </tr>
   </table>

</body>
</html>