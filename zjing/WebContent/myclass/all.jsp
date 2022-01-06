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
         <td>班级名</td>
         <td>所在专业</td>
         <td>所在年级</td>
         <td>班级备注</td>
         <td>修该</td>
         <td>删除</td>
      </tr>
      <%
        List<MyclassEntity> ar=(ArrayList)request.getAttribute("myar");
         for(int i=0;i<ar.size();i++)
         {
      %>
       <tr>
         <td><%=ar.get(i).getCid() %></td>
         <td><%=ar.get(i).getMname() %></td>
         <td><%=ar.get(i).getMojarmname()%></td>
         <td><%=ar.get(i).getGrademname() %></td>
         <td><%=ar.get(i).getMremark() %></td>
         <td><a href="${pageContext.request.contextPath }/MyclassServlet?action=one&cid=<%=ar.get(i).getCid() %>">修改</a></td>
         <td><a href="${pageContext.request.contextPath }/MyclassServlet?action=del&cid=<%=ar.get(i).getCid() %>">删除</a></td>
      </tr>
      <%
         }
      %>
      <tr>
        <td colspan="7">
           <a href="${pageContext.request.contextPath }/MyclassServlet?action=allp">增加班级</a>
        </td>
      </tr>
   </table>

</body>
</html>