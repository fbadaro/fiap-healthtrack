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
  <title>Cadastro IMC - Health Track</title>

  <!-- Main  -->
  <%@ include file="main-css.jsp"%>
  
  <link rel="stylesheet" href="assets/css/dashboard.css">
</head>

<body>
  <div class="ht-dashboard">
  
    <!--  Off Canvas Menu -->
    <%@ include file="off-canvas-menu.jsp"%>

    <main>
      <!--  Header -->
      <%@ include file="header.jsp"%>

      <div class="container">
        <form class="row g-4" action="imc" method="post">
          
          <h5>Cadastro de IMC</h5>
          <hr>
		<!-- IF para ver se o campo não é vazio, se não for, preencher o campo com aquela cor mais clara -->
          <div class="col-md-6">
      
            <label for="txtHeight" class="form-label">Informe sua altura</label>
            <input type="number" class="form-control" name="height" id="txtHeight" value="${imc.height}">
          </div>
          <div class="col-md-6">
            <label for="txtWeight" class="form-label">Informe seu peso</label>
            <input type="number" class="form-control" name="weight" id="txtWeight" value="${imc.weight}">
          </div>
          <div class="col-md-6">
            <label for="txtDate" class="form-label">Data</label>
            <input type="date" class="form-control" name="date" id="txtDate" value="${ imc.date }">
          </div>
          <div class="col-md-4">
            <label for="txtQuantity" class="form-label">&nbsp;</label>
           </div>
          <div class="col-12">
            <button type="submit" class="btn btn-primary float-end">Cadastrar</button>
          </div>
        </form>
      </div>
    </main>
  </div>

  <%@ include file="main-js.jsp"%>
</body>

</html>
