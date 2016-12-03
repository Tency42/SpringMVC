<%--
  author Tency
  
  Date 2016/11
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>UserManage</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.6.js" type="text/javascript"></script>
<script src="js/jquery.myPagination.js" type="text/javascript"></script>


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<center>
		<h1>
			SpringMVC UserManage </br>
			</br> <small> <c:choose>
					<c:when test="${ sessionScope.userName !=null}">
  Welcome ${ sessionScope.userName} <a href="login">Login Out</a>
					</c:when>
					<c:otherwise>
  Please <a href="addUser" type="button"
							class="btn btn-default btn-sm">Sign in</a>
					</c:otherwise>
				</c:choose>
			</small>
		</h1>
	</center>
	<hr/>

	<c:choose>
		<c:when test="${pagers.total le 0 }">
			<p class="bg-warning">
				<br /> There is no data in DB . Please <a
					href="addUser" type="button"
					class="btn btn-default btn-sm">Create</a> an account. <br /> <br />
			</p>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>userId</th>
					<th>userName</th>
					<th>passWord</th>
					<th>operation</th>
				</tr>

 				<c:forEach items="${pagers.datas}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.userName}</td>
						<td>${user.passWord}</td>
						<td>
							<a href="userShow/${user.id}" type="button"
							class="btn btn-sm btn-success">Detail</a> <a
							href="userUpdate/${user.id}" type="button"
							class="btn btn-sm btn-warning">Update</a> <a
							href="userDelete/${user.id}" type="button"
							class="btn btn-sm btn-danger">Delete</a></td>
					</tr>
				</c:forEach> 						
			</table>
			
			<jsp:include page="pager.jsp">
				<jsp:param value="userManage" name="url"/>
				<jsp:param value="${pagers.total}" name="items"/>
			</jsp:include>	
			
		</c:otherwise>
	</c:choose>
	
</body>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>