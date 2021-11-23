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
  <title>Dashboard - Health Track</title>

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
        <div class="ht-welcome">
          <h1 class="ht-title-style-1">Olá ${currentUser.name} ID: ${currentUser.id}</h1>

          <h6 class="bolder">Dica do dia - Informações sobre COVID19 - 26/01/2021</h6>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus nec rhoncus nulla. Interdum et malesuada
            fames ac ante ipsum primis in faucibus. Integer suscipit urna vel euismod euismod. Donec rutrum magna quis
            eleifend pellentesque.</p>

          <img src="assets/images/dashboard.svg" alt="Saude" class="ht-welcome-banner">
        </div>

        <div class="ht-card-wrapper">
          <h5><img src="assets/images/ico-runner.svg" alt="Registro de Atividades">Registro de Atividades</h5>

          <div class="ht-card container">
            <div class="row">
              <div class="ht-card-left col-8">
                <div class="ht-card-content-wrapper">
                  <div class="ht-card-content">
                    <p class="ht-card-title">Historico de Atividades</p>
                    <table class="ht-table">
                      <thead>
                        <tr>
                          <th scope="col"></th>
                          <th scope="col">Tipo Atividade</th>
                          <th scope="col">Duração</th>
                          <th scope="col">Data</th>
                          <th scope="col"></th>
                          <th scope="col"></th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="userActivity" items="${userActivityList}" varStatus="index">                      		                      		                   		                      		            
                      		<tr>
	                          <th scope="row"><span class="index">${ index.count }</span></th>
	                          <td>${ userActivity.activity.getName() }</td>
	                          <td>${ userActivity.getDurationString() }</td>
	                          <td>${ userActivity.date }</td>
	                          <td>
	                            <a href="${ pageContext.request.contextPath }/atividade?item=${ userActivity.id }" title="Editar" class="ico-edit">
	                              <img src="assets/images/ico-edit.svg" alt="Editar">
	                            </a>
	                          </td>
	                          <td>
	                            <a href="#" title="Editar" class="ico-remove">
	                              <img src="assets/images/ico-remove.svg" alt="Remover">
	                            </a>
	                          </td>
	                        </tr>	                        
						</c:forEach> 
                      </tbody>
                    </table>
                  </div>
                                
                </div>
              </div>

              <div class="ht-card-right col-4">
                <div class="ht-card-content">
                  <p class="ht-card-title float-start">Horas registradas de atividades em:</p>

                  <select class="form-select form-select-sm float-end" aria-label=".form-select-sm example"
                    style="width: 115px;">
                    <option value="1">Jan</option>
                    <option value="2">Fev</option>
                    <option value="3">Mar</option>
                    <option value="4">Abr</option>
                    <option value="5">Mai</option>
                    <option value="6">Jun</option>
                    <option value="7">Jul</option>
                    <option value="8">Ago</option>
                    <option value="9">Set</option>
                    <option value="10">Out</option>
                    <option value="11">Nov</option>
                    <option value="12">Dez</option>
                  </select>

                  <div class="ht-card-status">
                    <span class="status">175,18h</span>

                    <svg width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg"
                      class="ico-smile-happy">
                      <path
                        d="M20 0C8.972 0 0 8.972 0 20C0 31.028 8.972 40 20 40C31.028 40 40 31.028 40 20C40 8.972 31.028 0 20 0ZM20 36.3636C10.9771 36.3636 3.63636 29.0229 3.63636 20C3.63636 10.9771 10.9771 3.63636 20 3.63636C29.0229 3.63636 36.3636 10.9771 36.3636 20C36.3636 29.0229 29.0229 36.3636 20 36.3636Z"
                        fill="#6B6B6B" />
                      <path
                        d="M24.8856 24.8855C22.1915 27.5793 17.8085 27.5794 15.1145 24.8856C14.4046 24.1755 13.2533 24.1755 12.5433 24.8856C11.8332 25.5956 11.8332 26.7468 12.5433 27.4568C14.5994 29.513 17.2992 30.5406 20.0001 30.5406C22.7003 30.5406 25.4013 29.5125 27.457 27.4568C28.167 26.7469 28.167 25.5956 27.457 24.8856C26.7468 24.1754 25.5955 24.1755 24.8856 24.8855Z"
                        fill="#6B6B6B" />
                      <path
                        d="M13.9564 17.8351C14.4085 17.3842 14.6667 16.7588 14.6667 16.1212C14.6667 15.4836 14.4085 14.8582 13.9564 14.4073C13.5055 13.9564 12.88 13.697 12.2424 13.697C11.6035 13.697 10.9794 13.9564 10.5284 14.4073C10.0764 14.8582 9.81818 15.4836 9.81818 16.1212C9.81818 16.7588 10.0764 17.3842 10.5284 17.8351C10.9794 18.2873 11.6049 18.5454 12.2424 18.5454C12.88 18.5454 13.5055 18.2873 13.9564 17.8351Z"
                        fill="#6B6B6B" />
                      <path
                        d="M27.7576 13.697C27.12 13.697 26.4945 13.9564 26.0435 14.4073C25.5927 14.8582 25.3333 15.4824 25.3333 16.1212C25.3333 16.76 25.5927 17.3842 26.0435 17.8351C26.4945 18.2873 27.12 18.5454 27.7576 18.5454C28.3951 18.5454 29.0206 18.2873 29.4715 17.8351C29.9224 17.3842 30.1818 16.76 30.1818 16.1212C30.1818 15.4836 29.9223 14.8582 29.4715 14.4073C29.0206 13.9564 28.3951 13.697 27.7576 13.697Z"
                        fill="#6B6B6B" />
                    </svg>

                    <div class="ht-card-status-message">
                      <p><strong>Parabéns</strong></p>
                      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus nec rhoncus nulla.</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <h5><img src="assets/images/ico-apple.svg" alt="Registro de Atividades">Alimentação</h5>

          <div class="ht-card container">
            <div class="row">
              <div class="ht-card-left col-8">
                <div class="ht-card-content-wrapper">
                  <div class="ht-card-content">
                    <p class="ht-card-title">Historico de Atividades</p>
                    
                    <table class="ht-table">
                      <thead>
                        <tr>
                          <th scope="col"></th>
                          <th scope="col">Tipo Alimento</th>
                          <th scope="col">Quantidade</th>
                          <th scope="col">Data</th>
                          <th scope="col">Calorias</th>
                          <th scope="col"></th>
                          <th scope="col"></th>
                        </tr>
                      </thead>
                      <tbody>                      	
                      	<c:forEach var="userFeed" items="${userFeedList}" varStatus="index">                      		                      		                   		                      		            
                      		<tr>
	                          <th scope="row"><span class="index">${ index.count }</span></th>
	                          <td>${ userFeed.feed.getName() }</td>
	                          <td>${ userFeed.quantity }gr</td>
	                          <td>${ userFeed.date }</td>
	                          <td>${ userFeed.cal }</td>
	                          <td>
	                            <a href="${ pageContext.request.contextPath }/cad-alimentacao?item=${ userFeed.id }" title="Editar" class="ico-edit">
	                              <img src="assets/images/ico-edit.svg" alt="Editar">
	                            </a>
	                          </td>
	                          <td>
	                            <a href="#" title="Editar" class="ico-remove">
	                              <img src="assets/images/ico-remove.svg" alt="Remover">
	                            </a>
	                          </td>
	                        </tr>	                        
						</c:forEach>                                                                  
                      </tbody>
                    </table>
                  </div>                                 
                </div>
              </div>

              <div class="ht-card-right col-4">
                <div class="ht-card-content">
                  <p class="ht-card-title float-start">Calorias registradas em:</p>

                  <select class="form-select form-select-sm float-end" aria-label=".form-select-sm example"
                    style="width: 115px;">
                    <option value="1">Jan</option>
                    <option value="2">Fev</option>
                    <option value="3">Mar</option>
                    <option value="4">Abr</option>
                    <option value="5">Mai</option>
                    <option value="6">Jun</option>
                    <option value="7">Jul</option>
                    <option value="8">Ago</option>
                    <option value="9">Set</option>
                    <option value="10">Out</option>
                    <option value="11">Nov</option>
                    <option value="12">Dez</option>
                  </select>

                  <div class="ht-card-status">
                    <span class="status">1000cal</span>

                    <svg width="40" height="40" viewBox="0 0 40 40" fill="none" xmlns="http://www.w3.org/2000/svg"
                      class="ico-smile-happy">
                      <path
                        d="M20 0C8.972 0 0 8.972 0 20C0 31.028 8.972 40 20 40C31.028 40 40 31.028 40 20C40 8.972 31.028 0 20 0ZM20 36.3636C10.9771 36.3636 3.63636 29.0229 3.63636 20C3.63636 10.9771 10.9771 3.63636 20 3.63636C29.0229 3.63636 36.3636 10.9771 36.3636 20C36.3636 29.0229 29.0229 36.3636 20 36.3636Z"
                        fill="#6B6B6B" />
                      <path
                        d="M24.8856 24.8855C22.1915 27.5793 17.8085 27.5794 15.1145 24.8856C14.4046 24.1755 13.2533 24.1755 12.5433 24.8856C11.8332 25.5956 11.8332 26.7468 12.5433 27.4568C14.5994 29.513 17.2992 30.5406 20.0001 30.5406C22.7003 30.5406 25.4013 29.5125 27.457 27.4568C28.167 26.7469 28.167 25.5956 27.457 24.8856C26.7468 24.1754 25.5955 24.1755 24.8856 24.8855Z"
                        fill="#6B6B6B" />
                      <path
                        d="M13.9564 17.8351C14.4085 17.3842 14.6667 16.7588 14.6667 16.1212C14.6667 15.4836 14.4085 14.8582 13.9564 14.4073C13.5055 13.9564 12.88 13.697 12.2424 13.697C11.6035 13.697 10.9794 13.9564 10.5284 14.4073C10.0764 14.8582 9.81818 15.4836 9.81818 16.1212C9.81818 16.7588 10.0764 17.3842 10.5284 17.8351C10.9794 18.2873 11.6049 18.5454 12.2424 18.5454C12.88 18.5454 13.5055 18.2873 13.9564 17.8351Z"
                        fill="#6B6B6B" />
                      <path
                        d="M27.7576 13.697C27.12 13.697 26.4945 13.9564 26.0435 14.4073C25.5927 14.8582 25.3333 15.4824 25.3333 16.1212C25.3333 16.76 25.5927 17.3842 26.0435 17.8351C26.4945 18.2873 27.12 18.5454 27.7576 18.5454C28.3951 18.5454 29.0206 18.2873 29.4715 17.8351C29.9224 17.3842 30.1818 16.76 30.1818 16.1212C30.1818 15.4836 29.9223 14.8582 29.4715 14.4073C29.0206 13.9564 28.3951 13.697 27.7576 13.697Z"
                        fill="#6B6B6B" />
                    </svg>

                    <div class="ht-card-status-message">
                      <p><strong>Parabéns</strong></p>
                      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus nec rhoncus nulla.</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <input type="hidden" id="imc" value="${ imcList }">   
          <input type="hidden" id="imcMonth" value="${ imcMonth }">          

          <h5><img src="assets/images/ico-muscle.svg" alt="Registro de Atividades">Histórico IMC Mensal</h5>
          <canvas id="myChart" width="100" height="30"></canvas>
        </div>
      </div>

      <footer>
        <p>Copyright Health Track 2021 - Todos direitos reservados</p>
      </footer>
    </main>
  </div>

  <%@ include file="main-js.jsp"%>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.4.0/chart.min.js"
    integrity="sha512-JxJpoAvmomz0MbIgw9mx+zZJLEvC6hIgQ6NcpFhVmbK1Uh5WynnRTTSGv3BTZMNBpPbocmdSJfldgV5lVnPtIw=="
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>

  <script>
    var ctx = document.getElementById('myChart');
    var imcList = document.getElementById('imc');
    var imcMonth = document.getElementById('imcMonth');

    const labels = ${ imcMonth };
    const data = {
      labels: labels,
      datasets: [
        {
          label: 'Medição',
          data: ${ imcList },
          borderColor: 'rgb(255, 99, 132)',
          backgroundColor: 'rgba(255, 99, 132, 0.5)',
        }
      ]
    };
    const config = {
      type: 'line',
      data: data,
      options: {
        responsive: true,
        plugins: {
          legend: {
            position: 'top',
          },
          title: {
            display: true,
            text: 'Chart.js Line Chart'
          }
        }
      },
    };

    new Chart(ctx, config);
  </script>
</body>

</html>