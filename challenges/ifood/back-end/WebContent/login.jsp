<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ifood - Restaurantes</title>

<!-- Main  -->
<%@ include file="main-css.jsp"%>

<!-- Login  -->
<link rel="stylesheet" href="assets/css/login.css">

</head>

<body>
	<main class="container-fluid">
		<div class="row vh-100">
			<div class="ifd-login-wrapper d-none d-md-block col-md-4 col-xl-8">
				<div class="disclaimer d-none d-lg-block">
					<h1>Faça parte da 1 opção na hora de pedir comida.</h1>
					<p>E ganhe 3 meses de mensalidade grátis!</p>

					<a href="cadastro-responsavel.jsp" class="btn btn-outline-light btn-lg">Quero fazer parte!</a>
				</div>
			</div>

			<div class="ifd-login-auth-wrapper col-12 col-md-8 col-xl-4">
				<div class="ifd-login-auth">
					<span class="logo">Ifood Restaurantes</span>

					<form action="login" method="post">
						<div class="form-group">
							<label for="txtUserEmail" class="fw-bold">Email</label> 
							<input type="text" class="form-control" name="txtUserEmail" id="txtUserEmail" aria-describedby="user" maxlength="100">
						</div>

						<div class="form-group">
							<label for="txtUserPass" class="fw-bold">Senha</label> 
							<input type="password" class="form-control" name="txtUserPass" id="txtUserPass">
						</div>
						
						<c:if test="${not empty error}">
						<strong style="color: red">Usuario ou Senha invalidos</strong>
						</c:if>						

						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input"
								id="chkPersistLogin"> <label class="form-check-label"
								for="chkPersistLogin">Continuar logado?</label> <a href="#"
								title="Esqueceu sua senha" class="float-end">Esqueceu sua
								senha?</a>
						</div>
						
						<input type="submit" class="btn btn-primary float-end" value="Entrar" />
					</form>		
				</div>
			</div>
		</div>
	</main>
	<%@ include file="main-js.jsp"%>
</body>

</html>
