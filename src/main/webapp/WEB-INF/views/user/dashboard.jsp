<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${pageTitle} </title>
	<jsp:include page="../includes/header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../includes/top.jsp"></jsp:include>
	
	<jsp:include page="${pageName}.jsp"></jsp:include>

	<jsp:include page="../includes/footer.jsp"></jsp:include>
	
</body>
</html>