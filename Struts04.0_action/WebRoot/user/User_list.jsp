<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script type="text/javascript">
    	function quanxuan(){
			var ids = document.getElementsByName("ids"); 
			for(var i=0;i<ids.length;i++){
				if(ids[i].checked == true){
					ids[i].checked = false;
				}else{
					ids[i].checked = true;				
				}
			}			
    	}
    	
    </script>
    
  </head>
  
  <body>
  <br>
  <form name="form1" method="post" action="user/User_delete">
    <table width="100%" border="1">
      <tr>
        <td colspan="6" class="tr_title" align="center">用户信息浏览</td>
      </tr>
      <tr>
        <td width="18%"><input type="checkbox" name="checkbox" value="checkbox" onclick="quanxuan()"></td>
        <td width="14%">用户ID</td>
        <td width="26%">用户名</td>
        <td width="18%">密码</td>
        <td width="18%">操作</td>
        <td width="6%">&nbsp;</td>
      </tr>
      <c:forEach items="${users}" var="user">
      <tr>
        <td><input type="checkbox" name="ids" value="${user.userId }"></td>
        <td>${user.userId}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td><a href="user/User_toEdit?userdto.userId=${user.userId}">更新</a></td>
        <td>&nbsp;</td>
      </tr>
      </c:forEach>
      <tr>
        <td colspan="2"><input type="submit" name="Submit" value="批量删除">
        				<input type="button" name="add" value="添加" onclick="location='user/User_toAdd'">
        </td>
        <td colspan="2">
        <c:if test="${pageStr>1}">
        	<a href="user/User_list?pageStr=1">首页</a>
        	<a href="user/User_list?pageStr=${pageStr-1 }">上一页</a>
        </c:if>
         <c:if test="${pageStr<=1}">
        	首页
        	上一页
        </c:if>
        	
        <c:if test="${pageStr<maxPage}">
        	<a href="user/User_list?pageStr=${pageStr+1 }">下一页</a>
        	<a href="user/User_list?pageStr=${maxPage}">末页</a>
        </c:if>
         <c:if test="${pageStr>=maxPage}">
        	下一页
        	末页
        </c:if>
        </td>
      </tr>
    </table>
  </form>
  </body>
</html>
