<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.svse.entity.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  *
  {
    font-size: 12px;
    
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
  .m
  {
  text-align: center;
  }
</style>
</head>
<body>
<!--pid ename pname-->
   <form action="${pageContext.request.contextPath }/DeptServlet?action=add" method="post">
      <table>
        <tr>
          <td>所在部门：</td>
          <td>
            <select name="eid">
              <%
                List<CollegeEntity> ar=(ArrayList)request.getAttribute("myallp");
                for(int i=0;i<ar.size();i++)
                {
              %>
              <option value="<%=ar.get(i).getEid()%>"><%=ar.get(i).getEname() %></option>
              <%
                }
              %>
             
            </select>
          </td>
        </tr>
         <tr>
          <td>系别名：</td>
          <td>
             <input type="text" name="pname">
          </td>
        </tr>
         <tr>
          <td colspan="2" align="center">
             <input type="submit" value="确定">
          </td>
        </tr>
      </table>
   </form>
</body>
</html>