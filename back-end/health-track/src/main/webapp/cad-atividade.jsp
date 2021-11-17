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
  <title>Cadastro Atividade - Health Track</title>

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
        <form class="row g-4">
          <h5>Cadastro de Atividade</h5>
          <hr>

          <div class="col-md-12">
            <label for="ddlAtividade" class="form-label">Selecione o tipo de atividade</label>
            <select id="ddlAtividade" class="form-select">
              <option value="1">Musculação</option>
              <option value="2">Caminhada</option>
              <option value="3">Natação</option>
              <option value="4">Bicicleta</option>
              <option value="5">Corrida</option>
              <option value="6">Esteira</option>
            </select>
          </div>
          <div class="col-md-6">
            <label for="txtDate" class="form-label">Data</label>
            <input type="date" class="form-control" id="txtDate">
          </div>
          <div class="col-md-6">
            <label for="txtTime" class="form-label">Duração Atividade</label>
            <input type="time" class="form-control" id="txtTime">
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
