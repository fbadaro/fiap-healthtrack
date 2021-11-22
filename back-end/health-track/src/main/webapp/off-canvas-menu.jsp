<a data-bs-toggle="offcanvas" href="#menu" role="button" aria-controls="offcanvasExample" class="ht-hamburguer">
  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list"
    viewBox="0 0 16 16">
    <path fill-rule="evenodd"
      d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z" />
  </svg>
</a>

 <div class="offcanvas offcanvas-start" tabindex="-1" id="menu" aria-labelledby="menu">
   <div class="offcanvas-header">
     <h5 class="offcanvas-title" id="offcanvasExampleLabel">O que você deseja?</h5>
     <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
   </div>
   <div class="offcanvas-body">
     <nav>
       <ul>
         <li>
           <a href="${ pageContext.request.contextPath }/atividade">
             <img src="assets/images/ico-runner.svg" alt=""> Cadastrar Atividade
           </a>
         </li>
         <li>
           <a href="${ pageContext.request.contextPath }/cad-alimentacao">
             <img src="assets/images/ico-apple.svg" alt=""> Cadastrar Alimentação
           </a>
         </li>
         <li>
            <a href="${ pageContext.request.contextPath }/imc">
             <img src="assets/images/ico-muscle.svg" alt=""> Cadastrar meu IMC
           </a>
         </li>
       </ul>
     </nav>
   </div>
 </div>