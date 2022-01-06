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
   <form action="${pageContext.request.contextPath }/MyclassServlet?action=add" method="post">
      <table>
        <tr>
          <td>所在专业：</td>
          <td>
            <select name="mid">
              <%
                List<MojarEntity> ar=(ArrayList)request.getAttribute("mojarallp");
                for(int i=0;i<ar.size();i++)
                {
              %>
              <option value="<%=ar.get(i).getMid()%>"><%=ar.get(i).getMname() %></option>
              <%
                }
              %>
             
            </select>
          </td>
        </tr>
         <tr>
           <tr>
          <td>所在年级：</td>
          <td>
            <select name="gid">
              <%
                List<GradeEntity> gradear=(ArrayList)request.getAttribute("gradeallp");
                for(int i=0;i<ar.size();i++)
                {
              %>
              <option value="<%=gradear.get(i).getGid()%>"><%=gradear.get(i).getMname() %></option>
              <%
                }
              %>
             
            </select>
          </td>
        </tr>
         <tr>
          <td>班级名：</td>
          <td>
             <input type="text" name="mname">
          </td>
        </tr>
 	        <tr>
          <td>班级备注：</td>
          <td>
             <input type="text" name="mremark">
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