<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>  
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
      <s:iterator value="pm.datas">
      <tr>
        <td><input type="checkbox" name="ids" value="<s:property value="userId"/>"></td>
        <td><s:property value="userId"></s:property></td>
        <td><s:property value="username"></s:property></td>
        <td><s:property value="password"></s:property></td>
        <td><a href="user/User_toEdit?userdto.userId=<s:property value="userId"/>">更新</a></td>
        <td>&nbsp;</td>
      </tr>
      </s:iterator>
      <tr>
        <td colspan="2"><input type="submit" name="Submit" value="批量删除">
        				<input type="button" name="add" value="添加" onclick="location='user/User_toAdd'">
        </td>
        <td colspan="2">
           <pg:pager items="${pm.total}" url="user/User_list" maxPageItems="3" export="currentPageNumber=pageNumber">
	<pg:first>
		<a href="${pageUrl}">首页</a>
	</pg:first>
	<pg:prev>
		<a href="${pageUrl }">前页</a>
	</pg:prev>
	<pg:pages>
		<c:choose>
			<c:when test="${currentPageNumber eq pageNumber }">
			<font color="red">${pageNumber }</font>
			</c:when>
			<c:otherwise>
				<a href="${pageUrl}">${pageNumber }</a>
			</c:otherwise>
		</c:choose>
	</pg:pages>
	<pg:next>
		<a href="${pageUrl }">后页</a>
	</pg:next>
	<pg:last>
		<a href="${pageUrl }">尾页</a>
	</pg:last>
</pg:pager>
        
        </td>
      </tr>
    </table>
  </form>
  </body>
</html>
