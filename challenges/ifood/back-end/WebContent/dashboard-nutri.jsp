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
<title>Ifood - Nutri</title>

<!-- Main  -->
<%@ include file="main-css.jsp"%>

<!-- Dashboard  -->
<link rel="stylesheet" href="assets/css/dashboard.css">

</head>

<body>
	<header
		class="nutri navbar navbar-dark  sticky-top flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Ifood
			Nutri</a>
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
						<li class="nav-item"><a class="nav-link active"
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
						<li class="nav-item"><a class="nav-link" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="24" height="24"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-layers" aria-hidden="true">
                  <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                  <polyline points="2 17 12 22 22 17"></polyline>
                  <polyline points="2 12 12 17 22 12"></polyline>
                </svg> Integrações
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
					<h1 class="h4">Olá, bem vindo ${currentNutri.nome}</h1>
				</div>

				<h4>Meus resturantes associados</h4>

				<div class="container-fluid" style="margin-bottom: 90px;">
					<div class="row">

						<div class="col-lg-3">
							<div class="card">
								<img class="card-img-top"
									src="https://via.placeholder.com/350x150" alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Restaurante Dona Maricotas</h5>
									<p class="card-text">Deliciosos pratos divinos, venha
										experimentar o melhor prato de SP.</p>
									<a href="#" class="btn btn-primary">Criar Cardapio</a>
								</div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="card">
								<img class="card-img-top"
									src="https://via.placeholder.com/350x150" alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Bistro Madame Lux</h5>
									<p class="card-text">O melhor bistro de SP, com cardapios
										diferenciados que voce nem imagina.</p>
									<a href="#" class="btn btn-primary">Criar Cardapio</a>
								</div>
							</div>
						</div>

					</div>
				</div>

				<h4>Resturantes para me associar</h4>

				<div class="container-fluid" style="margin-bottom: 30px;">
					<div class="row">

						<div class="col-lg-3">
							<div class="card">
								<img class="card-img-top"
									src="https://via.placeholder.com/350x150" alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Restaurante Dona Florinda</h5>
									<p class="card-text">O melhor restaurante de Acapulco, os
										melhores pratos voce encontra aqui, OBS: Nao temos biscoito.</p>
									<a href="#" class="btn btn-primary">Criar Solicitação</a>
								</div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="card">
								<img class="card-img-top"
									src="https://via.placeholder.com/350x150" alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Restaurante Vento Bravo</h5>
									<p class="card-text">E ai guerreiro, afim de comer a melhor
										comida do universo depois de uma longa jornada, venha para o
										restaurante vento-bravo.</p>
									<a href="#" class="btn btn-primary">Criar Solicitação</a>
								</div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="card">
								<img class="card-img-top"
									src="https://via.placeholder.com/350x150" alt="Card image cap">
								<div class="card-body">
									<h5 class="card-title">Bistro de Rivendell</h5>
									<p class="card-text">Certamente voce nunca experimentou
										algo tão sofisticado como os nossos pratos, Lembas?</p>
									<a href="#" class="btn btn-primary">Criar Solicitação</a>
								</div>
							</div>
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
