$(document).ready(function () {
        $('#tablaTorneos').jtable({
            title: 'Torneos',
            paging: true,
            pageSize: 10,
            actions: {
                listAction: 'CargarGrillaTorneos?action=list',
                createAction: 'CargarGrillaTorneos?action=create',
                updateAction: 'CargarGrillaTorneos?action=modify',
                deleteAction: 'CargarGrillaTorneos?action=delete'
            },
            fields: 
            {
                nroTorneo: 
                {
                	title: 'Torneos',
                    key: true,
                    edit: false
                },
                nroClub:
                {
                	title: 'Club',
                    width: '30%',
                    create: false,
                    edit: false
                },
                club: 
                {
                	title: 'Club',
                	list: false,
                	create: true,
                	options: 'CargarGrillaTorneos?action=buscarClubes',
                	edit: true
                },
                nroPrograma: 
                {
                    title: 'Programa',
                    width: '30%',
                    list: true,
                    create: false,
                    edit: false
                },
                programa: 
                {
                	title: 'Programa',
                	list: false,
                	create: true,
                	options: 'CargarGrillaTorneos?action=buscarProgramas',
                	edit: true
                },
                fecha: 
                {
                	title: 'Fecha',
                    width: '20%',
                    create: false,
                    edit: false,
                    list: true
                },
                fechaCreate: 
                {
                    title: 'Fecha',
                    width: '20%',
                    list: false,
                    create: true,
                    edit: true,
                    type: 'date',
                    displayFormat: 'dd/mm/yy'
                }
            },
            messages: 
            {
                serverCommunicationError: 'Ocurrió un error inesperado.',
                loadingMessage: 'Cargando datos...',
                noDataAvailable: 'No hay datos que mostrar!',
                addNewRecord: 'Agregar Torneo',
                editRecord: 'Editar Torneo',
                areYouSure: 'Está Seguro?',
                deleteConfirmation: 'Este registro será eliminado. Está seguro?',
                save: 'Guardar',
                saving: 'Guardando',
                cancel: 'Cancelar',
                deleteText: 'Eliminar',
                deleting: 'Eliminando',
                error: 'Error',
                close: 'Cerrar',
                pagingInfo: 'Mostrando {0}-{1} de {2}',
                pageSizeChangeLabel: 'Mostrar por pAgina',
                gotoPageLabel: 'Ir a'
            }
        });
        $('#tablaTorneos').jtable('load');
    }

);