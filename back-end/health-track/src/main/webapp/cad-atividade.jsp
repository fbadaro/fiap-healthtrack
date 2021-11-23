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
        <form class="row g-4" action="atividade" method="post">
          <h5>Cadastro de Atividade</h5>
          <c:if test="${not empty msg }">
		  	<div class="alert alert-success">${msg}</div>
		  </c:if>
		  <c:if test="${not empty erro }">
		  	<div class="alert alert-danger">${erro}</div>
		  </c:if>
		  
		  <input type="hidden" name="txtUsFeedId" value="${ userActi.id }">

          <div class="col-md-12">
            <label for="ddlAtividade" class="form-label">Selecione o tipo de atividade</label>
            <select id="ddlAtividade" name="idActivity" class="form-select">
            <c:forEach var="activity" items="${lista}">
				<option value="${activity.id}" ${ userActi.activity.id == activity.id ? 'selected=selected' : '' }>${activity.name}</option>
            </c:forEach>
            </select>
          </div>
          <div class="col-md-6">
            <label for="txtDate" class="form-label">Data</label>
            <input type="date" class="form-control" id="txtDate" name="date" value='${userActi.date}'>
          </div>
          <div class="col-md-6">
            <label for="txtTime" class="form-label">Duração Atividade</label>
            <input type="time" class="form-control" id="txtTime" name="duration" value='${userActi.getDurationString() }'>
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
