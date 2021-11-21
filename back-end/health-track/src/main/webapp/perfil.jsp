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
<title>Perfil</title>

<!-- Main  -->
<%@ include file="main-css.jsp"%>

<link rel="stylesheet" href="assets/css/profile.css">
</head>

<body>
	<div class="ht-dashboard">

		<!--  Off Canvas Menu -->
		<%@ include file="main-css.jsp"%>

		<main>
			<!--  Header -->
			<%@ include file="header.jsp"%>

			<div class="container">
				<form class="ht-form-profile">
					<h5>Perfil</h5>
					<hr>

					<div class="row mb-4">
						<label for="txtName" class="col-sm-2 col-form-label">Nome
							Completo</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="txtName" name="txtName"
								value="${ currentUser.name }">
						</div>
					</div>
					<div class="row mb-4">
						<label for="txtEmail" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="txtEmail" name="txtEmail"
								value="${ currentUser.email }">
						</div>
					</div>
					<div class="row mb-4">
						<label for="txtBirthday" class="col-sm-2 col-form-label">Data
							de Nascimento</label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="txtBirthday" name="txtBirthday"
								value="${ currentUser.birthday }">
						</div>
					</div>
					<div class="row mb-4">
						<label for="txtHeight" class="col-sm-2 col-form-label">Altura</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="txtHeight" name="txtHeight"
								pattern="\d{1}\.\d{2}" value="${ currentUser.height }">
						</div>
					</div>
					<div class="row mb-4">
						<label for="txtWeight" class="col-sm-2 col-form-label">Peso</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="txtWeight" name="txtWeight"
								pattern="\d{1}\.\d{2}" value="${ currentUser.weight }">
						</div>
					</div>									

					<h5>Redes Sociais</h5>
					<hr>

					<div class="row mb-4">
						<label for="txtFacebook" class="col-sm-2 col-form-label">Facebook</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="txtFacebook"
								value="https://www.facebook.com/camila.silva/">
						</div>
					</div>
					<div class="row mb-4">
						<label for="txtName" class="col-sm-2 col-form-label">Twitter</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="txtName"
								value="https://www.twitter.com/camila.silva/">
						</div>
					</div>
					<div class="row mb-4">
						<label for="txtName" class="col-sm-2 col-form-label">Instagram</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="txtName"
								value="https://www.instagram.com/camila.silva/">
						</div>
					</div>

					<h5>Trocar Senha</h5>
					<hr>
					<div class="row mb-4">
						<label for="txtPass" class="col-sm-2 col-form-label">Senha
							atual</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="txtPass">
						</div>
					</div>
					<div class="row mb-4">
						<label for="txtNewPass" class="col-sm-2 col-form-label">Nova
							Senha</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="txtNewPass">
						</div>
					</div>

					<button type="submit" class="btn btn-primary float-end">Atualizar
						dados</button>
				</form>

			</div>
		</main>
	</div>

	<%@ include file="main-js.jsp"%>
</body>

</html>
