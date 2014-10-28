<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'User_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <link href="../global.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    
     
     <br>
     <form name="form1" method="post" action="user/User_add">
       <table width="100%" border="1">
         <tr>
           <td colspan="3" class="tr_title">用户信息添加</td>
         </tr>
         <tr>
           <td width="37%">用户ID：</td>
           <td width="54%"><input type="text" name="userdto.userId"></td>
           <td width="9%">&nbsp;</td>
         </tr>
         <tr>
           <td>用户名：</td>
           <td><input type="text" name="userdto.username"></td>
           <td>&nbsp;</td>
         </tr>
         <tr>
           <td>密码：</td>
           <td><input type="text" name="userdto.password"></td>
           <td>&nbsp;</td>
         </tr>
         <tr>
           <td><input type="submit" name="Submit" value="提交"></td>
           <td><input type="reset" name="Submit2" value="重置"></td>
           <td>&nbsp;</td>
         </tr>
       </table>
  </form>
  </body>
</html>
