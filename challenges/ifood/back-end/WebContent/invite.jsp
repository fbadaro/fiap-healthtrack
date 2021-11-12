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

<!-- Invite  -->
<link rel="stylesheet" href="assets/css/dashboard.css">
<link rel="stylesheet" href="assets/css/invite.css">

</head>

<body>
	<header class="navbar navbar-dark sticky-top flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company
			Name</a>
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
						<li class="nav-item"><a class="nav-link" href="dashboard.jsp" aria-current="page"
							href="#"> <svg xmlns="http://www.w3.org/2000/svg" width="24"
									height="24" viewBox="0 0 24 24" fill="none"
									stroke="currentColor" stroke-width="2" stroke-linecap="round"
									stroke-linejoin="round" class="feather feather-home"
									aria-hidden="true">
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
					<h1 class="h4">Meus Invites</h1>
				</div>

				<div class="row">
					<div class="col-md-8 col-sm-12 invite-list"
						style="margin-bottom: 60px;">
						<ul class="list-group list-group-flush">
							<li class="list-group-item lista-header">
								<div class="row">
									<div class="col-md-9 col-7 lista-itens lista-nome-restaurante">
										<p>Restaurante</p>
									</div>
									<div class="col-md-2 col-3 lista-itens">
										<p>Data Invite</p>
									</div>
									<div class="col-md-1 col-2 lista-itens">
										<p>Status</p>
									</div>
								</div>
							</li>
							<li class="list-group-item">
								<div class="row">
									<div class="col-md-2 col-2 lista-itens">
										<img src="https://via.placeholder.com/50" class="img-fluid"
											alt="..." style="border-radius: 100%;">
									</div>
									<div class="col-md-7 col-5 lista-itens lista-nome-restaurante">
										<p>Dino's Restaurante</p>
									</div>
									<div class="col-md-2 col lista-itens">
										<p>07/11/2021</p>
									</div>
									<div class="col-md-1 col lista-itens">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-check-circle-fill"
											viewBox="0 0 16 16">
                        <path
												d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
                      </svg>
									</div>
								</div>
							</li>
							<li class="list-group-item">
								<div class="row">
									<div class="col-md-2 col-2 lista-itens">
										<img src="https://via.placeholder.com/50" class="img-fluid"
											alt="..." style="border-radius: 100%;">
									</div>
									<div class="col-md-7 col-5 lista-itens lista-nome-restaurante">
										<p>Sabor Peruano</p>
									</div>
									<div class="col-md-2 col lista-itens">
										<p>05/11/2021</p>
									</div>
									<div class="col-md-1 col lista-itens">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-check-circle-fill"
											viewBox="0 0 16 16">
                        <path
												d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
                      </svg>
									</div>
								</div>
							</li>
							<li class="list-group-item">
								<div class="row">
									<div class="col-md-2 col-2 lista-itens">
										<img src="https://via.placeholder.com/50" class="img-fluid"
											alt="..." style="border-radius: 100%;">
									</div>
									<div class="col-md-7 col-5 lista-itens lista-nome-restaurante">
										<p>Sushi em Casa</p>
									</div>
									<div class="col-md-2 col lista-itens">
										<p>08/11/2021</p>
									</div>
									<div class="col-md-1 col lista-itens">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-arrow-right"
											viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
												d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
                      </svg>
									</div>
								</div>
							</li>
						</ul>
					</div>
					<div class="col-md-3 col-12 invite-card">
						<div class="card mb-3 col-12" style="max-width: 18rem;">
							<div class="card-header">Resumo</div>
							<div class="card-body">
								<p class="card-text">
									Invites Restantes: <span>7</span>
								</p>
								<p class="card-text">
									Invites Enviados: <span>3</span>
								</p>
								<p class="card-text">
									Invites Aceitos: <span>2</span>
								</p>
							</div>
							<div class="card-footer">
								<p class="card-text">
									Bônus: <span>R$ 150.00</span>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="row overview-invites"></div>
			</main>
		</div>
	</div>

	<%@ include file="main-js.jsp"%>
</body>

</html>