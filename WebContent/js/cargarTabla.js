$(document).ready(function () {
        $('#PersonTableContainer').jtable({
            title: 'Tablita',
            paging: true, //Enable paging
            pageSize: 10, //Set page size (default: 10)
            selecting: true,
            actions: {
                listAction: 'PruebaGrilla'
            },
            fields: {
                dni: {
                	title: 'DNI',
                    key: true,
                },
                nombre: {
                    title: 'Nombre',
                    width: '30%'
                },
                apellido: {
                    title: 'Apellido',
                    width: '30%'
                },
                fechaNacimiento: {
                    title: 'Fecha Nacimiento',
                    width: '20%',
                    create: false,
                    edit: false
                },
                nroClub: {
                    title: 'nroClub',
                    width: '20%',
                    
                },
                sexo: {
                    title: 'sexo',
                    width: '20%',
                    
                }
                
            }
            
        });
        $('table.PersonTableContainer').jtable('load');
    });

/*
 selectionChanged: function () 
{
	var $selectedRows = $('#PersonTableContainer').jtable('selectedRows');

	if ($selectedRows.length > 0) {
		$selectedRows.each(function () {
            var record = $(this).data('record');
            alert(record.dni);
        });
	}
	else
		alert("Hola");
	
}
 */


$(document).ready(function() {
    $('#play').click(function(){
    	var nroCarrera = $("#cbCarrera").val();
    	$('#PersonTableContainer').jtable('load', {push : 1, nroCarrera : nroCarrera});
    }); 
});
