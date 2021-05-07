<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<!-- <h3>Application error.</h3> -->
	<div class="alert alert-danger" style="margin: 15px; padding:2px"><h3 style="margin-top: 8px;
    margin-left: 10px;">Application error!</h3></div>
	<h4 style="text-indent: 5%">Exception:</h4>
	<div style="background: lightgray;
    margin-left: 8%;
    padding: 2%;border-left: solid 6px #2e2eb8; word-break: break-all; margin-right: 2%">
	${exception.message}
	</div>
	<br>
	<h4 style="text-indent: 5%">Exception Stack Trace:</h4>
	<div style="background: lightgray;
    margin-left: 8%;
    padding: 2%;border-left: solid 6px #2e2eb8; word-break: break-all; margin-right: 2%"><c:forEach items="${exception.stackTrace}" var="line">
	${line}<br>
	</c:forEach></div>
	
</body>
</html>