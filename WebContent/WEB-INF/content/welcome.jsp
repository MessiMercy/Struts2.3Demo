<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Messiah</title>
</head>
<body>
hehe <s:text name=""><%=session.getAttribute("user") %></s:text>
<s:text name="tip"><%=session.getAttribute("tip") %></s:text>
<p>本站访问次数为: ${applicationScope.count}</p>
</body>
</html>