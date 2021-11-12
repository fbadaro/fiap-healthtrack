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

<!-- Cadastro  -->
<link rel="stylesheet" href="assets/css/cadastro.css">

</head>

<body>
	<main class="container">
		<div class="row justify-content-md-center">
			<div class="ifd-form-wrapper col-md-6">

				<span class="logo">Ifood Restaurantes</span>
				<hr>

				<h4 class="mt-3 mb-3">
					<strong>Passo 2: Dados do Restaurante - ${currentUser.nome}</strong>
				</h4>

				<form action="cadastro-empresa" class="row" method="post">
					<div class="mb-3">
						<label for="txtCNPJ" class="form-label">CNPJ</label> 
						<input type="text" class="form-control" name="txtCNPJ" id="txtCNPJ" pattern="\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}" maxlength="18">
					</div>

					<div class="mb-3">
						<label for="txtRazaoSocial" class="form-label">Razão Social</label> 
						<input type="text" class="form-control" name="txtRazaoSocial" id="txtRazaoSocial" maxlength="250">
					</div>

					<div class="mb-3">
						<label for="txtNome" class="form-label">Nome Fantasia</label> 
						<input type="text" class="form-control" name="txtNome" id="txtNome" maxlength="255">
					</div>
					
					<div class="mb-3">
						<label for="txtDescricao" class="form-label">Descricao da Empresa</label>
						<textarea class="form-control" name="txtDescricao" id="txtDescricao" maxlength="255" ></textarea> 						
					</div>

					<div class="mb-3">
						<label for="txtTelefone" class="form-label">Telefone</label> 
						<input type="tel" class="form-control" name="txtTelefone" id="txtTelefone" maxlength="9">
					</div>
					
					<!-- A partir daqui e o endereco -->
					
					<div class="mb-3">
						<label for="txtCEP" class="form-label">CEP</label>
						<input type="text" class="form-control" name="txtCEP" id="txtCEP" maxlength="9">
					</div>

					<div class="col-md-6 mb-3">
						<label for="ddlUF" class="form-label">Estado</label>
						<select class="form-select" name="ddlUF" id="ddlUF">
							<option value="SP">São Paulo</option>
							<option value="RJ">Rio de Janeiro</option>
							<option value="MG">Minas Gerais</option>
							<option value="XX">Outros</option>
						</select>
					</div>

					<div class="col-md-6 mb-3">
						<label for="ddlCidade" class="form-label">Cidade</label> 
						<select class="form-select" name="ddlCidade" id="ddlCidade">
							<option value="Cidade1">Cidade 1</option>
							<option value="Cidade2">Cidade 2</option>
							<option value="Cidade3">Cidade 3</option>
							<option value="Cidade4">Cidade 4</option>
						</select>
					</div>					

					<div class="col-md-8 mb-3">
						<label for="txtEndereco" class="form-label">Endereço</label> 
						<input type="text" class="form-control" name="txtEndereco" id="txtEndereco" maxlength="255">
					</div>

					<div class="col-md-4 mb-3">
						<label for="txtNumero" class="form-label">Número</label>
						<input type="number" class="form-control" name="txtNumero" id="txtNumero">
					</div>
					
					<div class="mb-3">
						<label for="ddlEspecialidade" class="form-label">Especialidade</label>
						<select class="form-select" name="ddlEspecialidade" id="ddlEspecialidade">
							<c:forEach var="categoria" items="${categorias}">
								<option value="${categoria.id}">${categoria.nome}</option>
							</c:forEach>				
						</select>													
					</div>
					
					<div class="col-md-4 mb-3">
						<label for="txtPedidoMin" class="form-label">Pedido Minimo</label>
						<input type="number" class="form-control" name="txtPedidoMin" id="txtPedidoMin" pattern="[0-9]+([\,|\.][0-9]+)?">
					</div>
					
					<div class="mb-3">
						<div class="form-check">
						<input class="form-check-input" type="checkbox" value="1" name="chkEntrega" id="chkEntrega">
						<label class="form-check-label" for="chkEntrega">
							O Restaurante possui entrega propria?
						</label>
						</div>
					</div>

					<div>
						<input type="submit" class="btn btn-primary float-end" value="Enviar" />
					</div>
					
					<c:if test="${not empty error}">
					<strong style="color: red">Erro ao cadastrar a emrepsa</strong>
					</c:if>	
				</form>													
			</div>
		</div>
	</main>
	<%@ include file="main-js.jsp"%>
</body>

</html>