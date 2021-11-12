<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<!-- Dashboard  -->
<link rel="stylesheet" href="assets/css/dashboard.css">

</head>

<body>
	<header class="navbar navbar-dark sticky-top flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company Name</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search"> -->
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="#">Sair</a>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active" href="dashboard.jsp"
							aria-current="page" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-home" aria-hidden="true">
                  <path
										d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                  <polyline points="9 22 9 12 15 12 15 22"></polyline>
                </svg> Meu Dashboard
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-file" aria-hidden="true">
                  <path
										d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                  <polyline points="13 2 13 9 20 9"></polyline>
                </svg> Ordens
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-shopping-cart" aria-hidden="true">
                  <circle cx="9" cy="21" r="1"></circle>
                  <circle cx="20" cy="21" r="1"></circle>
                  <path
										d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                </svg> Cardápio
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-users" aria-hidden="true">
                  <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                  <circle cx="9" cy="7" r="4"></circle>
                  <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                  <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                </svg> Clientes
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-bar-chart-2" aria-hidden="true">
                  <line x1="18" y1="20" x2="18" y2="10"></line>
                  <line x1="12" y1="20" x2="12" y2="4"></line>
                  <line x1="6" y1="20" x2="6" y2="14"></line>
                </svg> Relatorios
						</a></li>
						<li class="nav-item"><a class="nav-link" href="invite.jsp"> <svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-layers" aria-hidden="true">
                  <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                  <polyline points="2 17 12 22 22 17"></polyline>
                  <polyline points="2 12 12 17 22 12"></polyline>
                </svg> Invites
						</a></li>
					</ul>
				</div>
			</nav>

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div class="chartjs-size-monitor">
					<div class="chartjs-size-monitor-expand">
						<div class=""></div>
					</div>
					<div class="chartjs-size-monitor-shrink">
						<div class=""></div>
					</div>
				</div>

				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h4">Olá, bem vindo ${currentUser.nome}</h1>

					<div class="btn-toolbar mb-2 mb-md-0">
						<button type="button"
							class="btn btn-sm btn-outline-secondary dropdown-toggle">
							<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								viewBox="0 0 24 24" fill="none" stroke="currentColor"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								class="feather feather-calendar" aria-hidden="true">
                <rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect>
                <line x1="16" y1="2" x2="16" y2="6"></line>
                <line x1="8" y1="2" x2="8" y2="6"></line>
                <line x1="3" y1="10" x2="21" y2="10"></line>
              </svg>
							Esta semana
						</button>
					</div>

				</div>

				<div class="container-fluid">
					<div class="row">

						<div class="col-md-12" style="margin-bottom: 60px;">
							<div class="card mb-3">
								<div class="row g-0">
									<div class="col-md-2 col-lg-1" style="padding: 15px;">
										<img src="https://via.placeholder.com/150" class="img-fluid"
											alt="..." style="border-radius: 100%;">
									</div>
									<div class="col-md-9 col-lg-11">
										<div class="card-body">
											<h5 class="card-title">
												<strong>${currentCompany.nome}</strong>
											</h5>
											<p class="card-text">
												<small class="text-muted">Av Capitao Casa, n 154 - SBC - SP</small>
											</p>
											<br>

											<p class="card-text">
												<strong>Minha Descrição</strong><br> <span> ${currentCompany.descricao}
												</span>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="col-md-12" style="margin-bottom: 30px;">
							<table class="table">
							  <thead>
							    <tr>
							      <th scope="col">#</th>
							      <th scope="col">Dia</th>
							      <th scope="col">Prato</th>
							      <th scope="col">Descricao</th>
							  	  <th scope="col">Restaurante</th>
							      <th scope="col">Cardapio</th>
							    </tr>
							  </thead>
							  
							  <tbody>
								<tr>
							      <td>1</td>
							      <td>Segunda</td>
							      <td>N°1</td>
							      <td>Pão australiano, cheddar, cebola caramelizada, hamburger de 220g</td>
							      <td>Bom Prato Esfiharia</td>
							      <td>Cardapio Janta Novembro</td>
							    </tr>	
							    <tr>
							      <td>1</td>
							      <td>Terca</td>
							      <td>N°2</td>
							      <td>Pão brioche, queijo emental, cebola, alface, tomate, hamburger de costela de 220g</td>
							      <td>Bom Prato Esfiharia</td>
							      <td>Cardapio Janta Novembro</td>
							    </tr>	
							    <tr>
							      <td>1</td>
							      <td>Quarta</td>
							      <td>N°3</td>
							      <td>Pão de hamburger, queijo prato, tomate, picles, ketchup, hamburger de 220g</td>
							      <td>Bom Prato Esfiharia</td>
							      <td>Cardapio Janta Novembro</td>
							    </tr>	
							    <tr>
							      <td>1</td>
							      <td>Quinta</td>
							      <td>N°4</td>
							      <td>Pão de hamburger, queijo prato, presunto, ovo frito, tomate, alface, hamburger de 220g</td>
							      <td>Bom Prato Esfiharia</td>
							      <td>Cardapio Janta Novembro</td>
							    </tr>	
							    <tr>
							      <td>1</td>
							      <td>Sexta</td>
							      <td>N°5</td>
							      <td>Pão de hamburger, queijo vegano, tomate, alface, hamburger de grão de bico</td>
							      <td>Bom Prato Esfiharia</td>
							      <td>Cardapio Janta Novembro</td>
							    </tr>	
							    <tr>
							      <td>1</td>
							      <td>Sabado</td>
							      <td>N°6</td>
							      <td>Pão brioche, catupiry, tomate, hamburger de costela de 300g</td>
							      <td>Bom Prato Esfiharia</td>
							      <td>Cardapio Janta Novembro</td>
							    </tr>	
							    <tr>
							      <td>1</td>
							      <td>Domingo</td>
							      <td>N°7</td>
							      <td>Pão francês, pernil desfiado, vinagrete, queijo gratinado</td>
							      <td>Bom Prato Esfiharia</td>
							      <td>Cardapio Janta Novembro</td>
							    </tr>													   
							  </tbody>
							</table>
						</div>

						<div class="col-md-6">
							<canvas id="myChart1" width="100" height="30"></canvas>
						</div>

						<div class="col-md-6">
							<canvas id="myChart2" width="100" height="30"></canvas>
						</div>
					</div>
				</div>

			</main>
		</div>
	</div>
	<%@ include file="main-js.jsp"%>
	<%@ include file="dashboard-js.jsp"%>
</body>
</html>
