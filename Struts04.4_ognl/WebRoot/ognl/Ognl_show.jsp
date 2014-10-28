<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Ognl_show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    访问普通属性:<s:property value="name"/><br>
    访问普通方法:<s:property value="fun()"/><br>
    访问静态属性:<s:property value="@com.wepull.actions.OgnlAction@LEN"/><br>
    访问静态方法:<s:property value="@com.wepull.actions.OgnlAction@getLen()"/><br>
    访问sun方法:<s:property value="@@max(3,5)"/><br>
    访问对象属性:<s:property value="per.name"/><br>
    访问对象方法:<s:property value="per.say()"/><br>
    访问对象：<s:property value="per"/><br>
    <p>&nbsp;</p>
    访问list：<s:property value="pers[0].name"/><br>
    访问list：<s:property value="pers[0].sex"/><br>
    访问map的key：<s:property value="map.keys"/><br>
    访问map的value：<s:property value="map.values"/><br>
    访问map的大小：<s:property value="map.size"/><br>
    
    循环迭代标签:<!-- status  状态码 -->
    <s:iterator value="pers" var="p" >
    	<s:property value="#p.name"/>
    </s:iterator>
    
    <s:iterator value="pers"  >
    	<s:property value="sex"/>
    </s:iterator><br/>
     <p>&nbsp;</p>
  网页元素：<br/>
  用户名:<s:textfield name="username"></s:textfield><br/>
  密码:<s:password></s:password><br>
  <s:file></s:file><br/>
  
 下拉列表:<!-- listKey->相当于option的value   listValue展示 -->
 <s:select list="pers" name="pp" listKey="id" listValue="name"></s:select>
 
 复选框:<s:checkbox name="font" value="足球"></s:checkbox>
 复选框集合:
 <s:checkboxlist list="{'游戏','篮球','足球'}" name="ft"></s:checkboxlist><br/>
  <p>&nbsp;</p>
 if--else if--else：<br>
 pers[0].id为:<s:property value="pers[0].id"/>
 <s:if test="pers[0].id<0">一</s:if>
 <s:elseif test="pers[0]<5||pers[0]>0">二</s:elseif>
 <s:else >三</s:else>
    <s:debug></s:debug>
  </body>
</html>
