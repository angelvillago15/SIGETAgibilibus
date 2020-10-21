
  function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
  }
  
  function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.body.style.backgroundColor = "white";
  }

  $(document).ready(function() {
    $('#calendar').fullCalendar({
        header: { /*botones que hay arriba del calendario numerico*/
            left: 'prev,next',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        
        buttonIcons: true,
        weekNumbers: false, /*Establecido en true muestra una pequeña columna en la parte izquierda del calendario para informar del número de la semana.*/ 
        editable: true, /*Poner a false si se puede editar en plan dinámico*/
        eventLimit: true, /*Permite limitar la cantidad de eventos que se muestran en un día. El resto se mostrará en una ventana emergente. Puedes indicar true, false o un número entero.*/
        events: [ /*Definición de la lista de objetos o eventos que se mostrarán en el calendario. */
            {
                title: 'Reunion',
                description: 'Reunion Vespertina',
                start: '2019-07-01',
                color: '#3A87AD',
                textColor: '#ffffff',
            }
        ],
        /*dayClick: function (date, jsEvent, view) {
            alert('Has hecho click en: '+ date.format());
        }, 
        eventClick: function (calEvent, jsEvent, view) {
            $('#event-title').text(calEvent.title);
            $('#event-description').html(calEvent.description);
            $('#modal-event').modal();
        },*/  
    });
    $('#calendar').fullCalendar( 'removeEvents').fullCalendar('removeEventSources');
  });