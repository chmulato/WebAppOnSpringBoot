$('#confirmacaoExclusaoModal').on('show.bs.modal', function (event) {
	  var botao = $(event.relatedTarget);
	  var nome = botao.data('name');
	  var url = botao.data('url-apagar');
	  
	  var modal = $(this);
	  var form = modal.find('form');
	  form.attr('action', url);
	  
	  modal.find('.modal-body span').html('Tem certeza que deseja o colaborador <strong>' + nome + '</strong>?');
	});		
