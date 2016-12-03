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
<title>UserManage Login</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<div class="container">
		<h1>UserManage Login</h1>
		<hr />

		<form action="login" method="post">
			<div class="form-group">
				<label for="userName">UserName:</label> <input type="text"
					class="form-control" id="userName" name="userName"
					placeholder="Enter UserName" />
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="text"
					class="form-control" id="password" name="passWord"
					placeholder="Enter Password:" />
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-sm btn-success">Sign
					in</button>
			</div>
			New to Here? <a href="addUser">Create</a> an account.
		</form>
	</div>

	<c:if test="${flag }">
		<div class="alert alert-danger alert-dismissable" role="alert">
			<button class="close" type="button" data-dismiss="alert">&times;</button>
			error userName or passWord . Please try again.
			<%
			session.removeAttribute("flag");
			%>
		</div>
	</c:if>
</body>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>