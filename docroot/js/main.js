

/* $(document).ready( function() {	
	$('#entidad').change( function(){
		$.get('/rest-despachos-portlet/api/jsonws/especialidad/get-especialidades.2/idEntidad/'+$("#entidad option:selected").val(), function(data){
			$("#especialidad").children().remove();
			$("#especialidad").append(new Option("Seleccione",""));
			for( var i = 0 ; i < data.length ; i++)
				$("#especialidad").append(new Option(data[i].nombre, data[i].id));
		}, "json").fail( function(){
			alert("Error obteniendo las especialidades.");
		});
	});
});

*/