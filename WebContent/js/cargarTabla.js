$(document).ready(function () 
	{
        
        tablas();
        
        $('#cbCarrera').change(function(){
        	recargarTablas();
        }); 
    });


function sleep(miliseconds) 
{
   var currentTime = new Date().getTime();
   while (currentTime + miliseconds >= new Date().getTime()) 
   {
   }
}

function tablas()
{
	$('#PersonTableContainer').jtable({
        title: 'Nadadores Inscriptos',
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        selecting: true,
        actions: 
        {
            listAction: 'PruebaGrilla'
        },
        fields: 
        {
            dni: 
            {
            	title: 'DNI',
                key: true,
            },
            nombre: 
            {
                title: 'Nombre',
                width: '30%'
            },
            apellido: 
            {
                title: 'Apellido',
                width: '30%'
            },
            fechaNacimiento: 
            {
                title: 'Nacimiento',
                width: '20%',
            },
            nroClub: 
            {
                title: 'nroClub',
                width: '20%',
                
            },
            sexo: 
            {
                title: 'sexo',
                width: '20%',  
            }
        },
        selectionChanged: function () 
        {
        	var $selectedRows = $('#PersonTableContainer').jtable('selectedRows');

        	if ($selectedRows.length > 0) {
        		$selectedRows.each(function () {
        			var record = $(this).data('record');
                	var nroCarrera = $("#cbCarrera").val();
                    $.get("QuitarNadadorIndividual", {dniNadador : record.dni, nroCarrera : nroCarrera})
                    sleep(200);
                    recargarTablas();
                });
        	}

        }
    });
    
    $('#NadadoresNoInscriptos').jtable({
        title: 'Nadadores no Inscriptos',
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        selecting: true,
        actions: 
        {
            listAction: 'CargarGrillaNoInscriptosAIndividual'
        },
        fields: 
        {
            dni: 
            {
            	title: 'DNI',
                key: true,
            },
            nombre: 
            {
                title: 'Nombre',
                width: '30%'
            },
            apellido: 
            {
                title: 'Apellido',
                width: '30%'
            },
            fechaNacimiento: 
            {
                title: 'Nacimiento',
                width: '20%',
            },
            nroClub: 
            {
                title: 'nroClub',
                width: '20%',
                
            },
            sexo: 
            {
                title: 'sexo',
                width: '20%',  
            }
        },
        selectionChanged: function () 
        {
        	var $selectedRows = $('#NadadoresNoInscriptos').jtable('selectedRows');

        	if ($selectedRows.length > 0) {
        		$selectedRows.each(function () {
                    var record = $(this).data('record');
                	var nroCarrera = $("#cbCarrera").val();
                    $.get("PreInscribirNadadorIndividual", {dniNadador : record.dni, nroCarrera : nroCarrera})
                    sleep(200);
                    recargarTablas();
                });
        	}

        }
    });
}

function recargarTablas()
{
	var nroCarrera = $("#cbCarrera").val();
	$('#NadadoresNoInscriptos').jtable('load', {push : 1, nroCarrera : nroCarrera});
	sleep(200);
	$('#PersonTableContainer').jtable('load', {push : 1, nroCarrera : nroCarrera});
}


