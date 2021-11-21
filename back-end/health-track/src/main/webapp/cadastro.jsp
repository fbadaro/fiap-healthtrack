<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Usuario - Health Track</title>

<!-- Main  -->
<%@ include file="main-css.jsp"%>

<link rel="stylesheet" href="assets/css/dashboard.css">
</head>

<body>
	<div class="ht-dashboard">
		<main>
			<header class="container">
				<div class="ht-header-logo">
					<a href="dash.jsp" title="Health Track" class="ht-logo-letter">
						<img src="assets/images/logo-letters.svg" alt="">
					</a>
					<h6>Cadastro</h6>
				</div>
			</header>

			<div class="container">
				<form action="cadastro" class="row g-4" method="post">
					<h5>Cadastro de Usuario</h5>
					<hr>
					<div class="col-md-6">
						<label for="txtName" class="form-label">Nome</label> <input
							type="text" class="form-control" id="txtName" name="txtName" />
					</div>
					<div class="col-md-6">
						<label for="txtEmail" class="form-label">Email</label> <input
							type="email" class="form-control" id="txtEmail" name="txtEmail" />
					</div>
					<div class="col-md-6">
						<label for="txtLogin" class="form-label">Login</label> <input
							type="text" class="form-control" id="txtLogin" name="txtLogin" />
					</div>
					<div class="col-md-6">
						<label for="txtPass" class="form-label">Senha</label> <input
							type="password" class="form-control" id="txtPass" name="txtPass" />
					</div>

					<h5>Informacoes Pessoais</h5>

					<div class="col-md-4">
						<label for="txtBirthday" class="form-label">Data Nasc</label> <input
							type="date" class="form-control" id="txtBirthday"
							name="txtBirthday" />
					</div>
					<div class="col-md-4">
						<label for="txtHeight" class="form-label">Altura</label> <input
							type="number" class="form-control" id="txtHeight" name="txtHeight" pattern="\d{1}\.\d{2}"/>
					</div>
					<div class="col-md-4">
						<label for="txtWeight" class="form-label">Peso</label> <input
							type="number" class="form-control" id="txtWeight" name="txtWeight" pattern="\d{2}\.\d{2}"/>
					</div>

					<div class="col-12">
						<input type="submit" class="btn btn-primary float-end" value="Cadastrar" />
					</div>
				</form>
			</div>
		</main>
	</div>
	
	<%@ include file="main-js.jsp"%>
</body>

</html>