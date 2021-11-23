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
  <title>Cadastro Alimentação - Health Track</title>

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
        <form class="row g-4" action="cad-alimentacao" method="post">
          <h5>Cadastro Alimentação</h5>
          <c:if test="${not empty msg }">
		  	<div class="alert alert-success">${msg}</div>
		  </c:if>
		  <c:if test="${not empty error }">
		  	<div class="alert alert-danger">${error}</div>
		  </c:if>
          <hr>
          
          <input type="hidden" name="txtUsFeedId" value="${ currentFeed.id }">

          <div class="col-md-12">
            <label for="ddlFeed" class="form-label">Informe o tipo de alimento</label>            
            <select id="ddlFeed" class="form-select" name="ddlFeed">
              	<c:forEach var="feed" items="${feedList}">
					<option value="${feed.id}" ${ currentFeed.feed.id == feed.id ? 'selected=selected' : '' }>${feed.name}</option>
				</c:forEach>
            </select>            
          </div>                   
          
          <div class="col-md-3">
            <label for="txtDate" class="form-label">Data</label>
            <input type="date" class="form-control" id="txtDate" name="txtDate" value="${ currentFeed.date }">
          </div>
          
          <div class="col-md-3">
            <label for="txtQuantity" class="form-label">Quantidade</label>
            <input type="number" class="form-control" id="txtTime" min="1" name="txtQuantity" value="${ currentFeed.quantity }">
          </div>
          
          <div class="col-md-3">
            <label for="txtCal" class="form-label">Calorias</label>
            <input type="number" class="form-control" id="txtCal" min="1" name="txtCal" value="${ currentFeed.cal }">
          </div>
          
          <div class="col-md-3">
            <label for="ddlType" class="form-label">Tipo</label>
            <select id="ddlType" class="form-select" name="ddlType" >
              <option value="1" ${ currentFeed.type == "1" ? 'selected' : '' }>Gramas</option>
              <option value="2" ${ currentFeed.type == "2" ? 'selected' : '' }>Quantidade</option>
            </select>
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
