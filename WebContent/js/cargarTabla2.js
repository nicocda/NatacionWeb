$(document).ready(function() {
        $('#PersonTableContainer').jtable({
                title : 'Students List',
                actions : {
                        listAction : 'PruebaGrilla'
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
                    }
                }
        });
        $('#StudentTableContainer').jtable('load');
});