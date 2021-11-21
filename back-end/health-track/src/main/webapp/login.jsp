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
<title>Health Track</title>

<!-- Main  -->
<%@ include file="main-css.jsp"%>

<link rel="stylesheet" href="assets/css/login.css">
</head>

<body>
	<main class="container-fluid">
		<div class="row vh-100">
			<div class="ht-login-wrapper d-none d-md-block col-md-4 col-xl-8">
				<div class="disclaimer d-none d-lg-block">
					<h1>Dica Health Track: Tenha uma boa noite de sono!</h1>
					<p>Dormir bem evita doenças como obesidade e ansiedade. Seu
						desempenho melhora durante o dia, pois você ganha mais disposição
						e concentração. O recomendado é dormir, pelo menos, de seis a oito
						horas por dia.</p>
				</div>
			</div>
			<div class="ht-login-auth-wrapper col-12 col-md-8 col-xl-4">
				<div class="ht-login-auth">
					<span class="logo">Health Track</span>

					<form action="login" method="post">

						<div class="form-group">
							<label for="txtUserEmail" class="fw-bold">Email</label> <input
								type="text" class="form-control" id="txtUserEmail" name="txtUserEmail"
								aria-describedby="user">
						</div>

						<div class="form-group">
							<label for="txtUserPass" class="fw-bold">Password</label> <input
								type="password" class="form-control" id="txtUserPass"
								name="txtUserPass">
						</div>

						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input"
								id="chkPersistLogin"> <label class="form-check-label"
								for="chkPersistLogin">Continuar logado?</label> <a href="#"
								title="Esqueceu sua senha" class="float-end">Esqueceu sua
								senha?</a>
						</div>

						<a href="cadastro.jsp" type="submit" class="btn btn-secondary float-start">Criar Conta</a> 						
						<input type="submit" class="btn btn-primary float-end" value="Entrar" />

						<c:if test="${not empty error}">
							<strong style="color: red; display: block; clear: both">Usuario ou Senha invalidos</strong>
						</c:if>

					</form>

					<div class="ht-login-auth-social-wrapper">
						<ul class="ht-login-auth-social">
							<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
										width="16" height="16" fill="currentColor"
										class="bi bi-facebook" viewBox="0 0 16 16">
                    <path
											d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z" />
                  </svg>
							</a></li>
							<li><a href="#"> <svg xmlns="http://www.w3.org/2000/svg"
										width="16" height="16" fill="currentColor"
										class="bi bi-twitter" viewBox="0 0 16 16">
                    <path
											d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z" />
                  </svg>
							</a></li>
							<li><a href="#"><svg xmlns="http://www.w3.org/2000/svg"
										width="16" height="16" fill="currentColor"
										class="bi bi-google" viewBox="0 0 16 16">
                    <path
											d="M15.545 6.558a9.42 9.42 0 0 1 .139 1.626c0 2.434-.87 4.492-2.384 5.885h.002C11.978 15.292 10.158 16 8 16A8 8 0 1 1 8 0a7.689 7.689 0 0 1 5.352 2.082l-2.284 2.284A4.347 4.347 0 0 0 8 3.166c-2.087 0-3.86 1.408-4.492 3.304a4.792 4.792 0 0 0 0 3.063h.003c.635 1.893 2.405 3.301 4.492 3.301 1.078 0 2.004-.276 2.722-.764h-.003a3.702 3.702 0 0 0 1.599-2.431H8v-3.08h7.545z" />
                  </svg> </a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="main-js.jsp"%>
</body>

</html>
