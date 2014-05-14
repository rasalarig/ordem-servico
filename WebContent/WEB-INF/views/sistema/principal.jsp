<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<c:import url="../template/cabecalho.jsp"/>
<c:import url="../template/sidebar.jsp"/>

<!--  Inicio :  Conteudo das paginas -->
<div id="page-wrapper">

	<div class="row">
		<div class="col-lg-12">
			<div class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
                   <p><b>Bem Vindo !!!, ${usuarioLogado.email}</b></p> 
			</div>
		</div>
	</div>

	<br />

	<!-- Button trigger modal -->
	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">Launch demo modal</button>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body">
				  Corpo dos Cadastros !
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	<br />
	<br /> <a href="logout">Sair do Sistema</a>
		
</div>
<!--  Inicio :  Conteudo das paginas --> 


<c:import url="../template/footer.jsp"/>