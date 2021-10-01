$(document).ready(function() {
        //on ready
  cargarOdontologos()
  $('#odontologos').DataTable();
  });

async function cargarOdontologos(){

    const request = await fetch('odontologos/list',{
    method: 'GET',
    headers: {
                'Accept':'application/json',
                'Content-Type':'application/json'
    }
    });
    const odontologos = await request.json();
    let listadoHtml = '';
        for (let odontologo of odontologos){
        let botonEliminar = '<a href="#" onclick = "eliminarOdontologo('+ odontologo.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i> </a>'
        let botonEditar = '<a href="#" class="btn btn-success btn-circle btn-sm"><i class="fas fa-edit"></i></a>'
        let odontologoHtml = '<tr><td>'+odontologo.id+'</td><td>'+ odontologo.nombre +
                           '</td><td>'+odontologo.apellido+'</td><td>'+ odontologo.matricula +
                           '</td><td>' + botonEditar + '</td><td>'+ botonEliminar + '</td></tr>'

        listadoHtml += odontologoHtml;
        }
        document.querySelector ('#odontologos tbody').innerHTML = listadoHtml;

}

async function eliminarOdontologo (id){

    if (!confirm ('¿Desea eliminar este odontologo?')){
        return;

    }

 const request = await fetch('odontologos/' + id,{
    method: 'DELETE',
    headers: {
               'Accept':'application/json',
               'Content-Type':'application/json'
                 }
    });

    location.reload()

}


