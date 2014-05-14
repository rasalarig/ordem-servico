<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Ordem de Serviço</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">
<link href="resources/css/sb-admin.css" rel="stylesheet">

</head>
<body>


	<div class="container">
		<div class="row">
		<center><h1>Iniciativa21 - O.S</h1></center>
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="eflog" method="post">
							<fieldset>
								<div class="form-group">
									<input	class="form-control" placeholder="login" type="text" name="email" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="senha" type="password" value="">
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<button class="btn btn-lg btn-success btn-block">Login</button> 

								<br>
								<c:if test="${msgErro != null}">
										<div class="alert alert-danger">${msgErro}</div>
								</c:if>

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Core Scripts - Include with every page -->
	<script src="resources/js/jquery-1.10.2.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>

	<!-- SB Admin Scripts - Include with every page -->
	<script src="resources/js/sb-admin.js"></script>


</body>
</html>