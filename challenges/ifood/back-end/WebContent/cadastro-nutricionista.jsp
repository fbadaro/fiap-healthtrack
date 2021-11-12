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
<title>Ifood - Nutri</title>

<!-- Main  -->
<%@ include file="main-css.jsp"%>

<!-- Cadastro  -->
<link rel="stylesheet" href="assets/css/cadastro.css">

</head>

<body>
	<main class="container">
		<div class="row justify-content-md-center">
			<div class="ifd-form-wrapper col-md-6">

				<span class="logo">Ifood Nutri</span>
				<hr>

				<h4 class="mt-3 mb-3">
					<strong>Passo 1: Seus Dados</strong>
				</h4>

				<form action="dashboard-nutri" class="row" method="post">
					<div class="mb-3">
						<label for="txtEmail" class="form-label">Email</label> 
						<input type="email" class="form-control" name="txtEmail" id="txtEmail" aria-describedby="emailHelp" 
							maxlength="100">
					</div>
					
					<div class="mb-3">
						<label for="txtCRN" class="form-label">CRN</label> 
						<input type="text" class="form-control" name="txtCRN" id="txtCRN" maxlength="15">
					</div>

					<div class="mb-3">
						<label for="txtCelular" class="form-label">Celular</label> 
						<input type="tel" class="form-control" name="txtCelular" id="txtCelular" maxlength="9">
					</div>

					<div class="col-md-6 mb-3">
						<label for="txtNome" class="form-label">Nome</label> 
						<input type="text" class="form-control" name="txtNome" id="txtNome" maxlength="100">
					</div>

					<div class="col-md-6 mb-3">
						<label for="txtSobrenome" class="form-label">Sobrenome</label> 
						<input type="text" class="form-control" name="txtSobrenome" id="txtSobrenome" maxlength="100">
					</div>

					<div class="mb-3">
						<label for="txtCPF" class="form-label">CPF</label> 
						<input type="text" class="form-control" name="txtCPF" id="txtCPF" maxlength="14" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}">
					</div>

					<div class="mb-3">
						<label for="txtRG" class="form-label">RG</label> 
						<input type="text" class="form-control" name="txtRG" id="txtRG" maxlength="13" pattern="\d{2}\.\d{3}\.\d{3}-\d{1}">
					</div>

					<div class="mb-3">
						<label for="ddlUF" class="form-label">Orgão Emissor</label> 
						<select class="form-select" name="ddlUF" id="ddlUF">
							<option value="SP">São Paulo</option>
							<option value="RJ">Rio de Janeiro</option>
							<option value="MG">Minas Gerais</option>
							<option value="XX">Outros</option>
						</select>
					</div>
					
					<div class="mb-3">
						<div class="form-check">
						<input class="form-check-input" type="checkbox" value="1" name="chkTermos" id="chkTermos">
						<label class="form-check-label" for="chkTermos">
							Ao cadastrar minha conta eu concordo com os <a href="#" title="termos">termos</a>  do Ifood
						</label>
						</div>
					</div>
					
					<div>
						<input type="submit" class="btn btn-primary float-end" value="Enviar" />
					</div>
					
					<c:if test="${not empty error}">
					<strong style="color: red">Erro ao cadastrar usuario</strong>
					</c:if>	
				</form>
			</div>
		</div>
	</main>
	<%@ include file="main-js.jsp"%>
</body>

</html>