$(document).ready(function() {
        //on ready
  cargarPacientes()
  $('#pacientes').DataTable();
  });

async function cargarPacientes(){

    const request = await fetch('pacientes/list',{
    method: 'GET',
    headers: {
                'Accept':'application/json',
                'Content-Type':'application/json'
    }
    });
    const pacientes = await request.json();
    let listadoHtml = '';
        for (let paciente of pacientes){
        let botonEliminar = '<a href="#" onclick = "eliminarPaciente('+ paciente.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i> </a>'
        let botonEditar = '<a href="modificarPaciente.html" class="btn btn-success btn-circle btn-sm"><i class="fas fa-edit"></i></a>'
        let pacienteHtml = '<tr><td>'+paciente.id+'</td><td>'+ paciente.nombre +
                           '</td><td>'+paciente.apellido+'</td><td>'+ paciente.telefono +
                           '</td><td>' + botonEditar + '</td><td>'+ botonEliminar + '</td></tr>'

        listadoHtml += pacienteHtml;
        }
        document.querySelector ('#pacientes tbody').innerHTML = listadoHtml;

    console.log(pacientes);
}

async function eliminarPaciente (id){

    if (!confirm ('¿Desea eliminar este usuario?')){
        return;

    }

 const request = await fetch('pacientes/' + id,{
    method: 'DELETE',
    headers: {
               'Accept':'application/json',
               'Content-Type':'application/json'
                 }
    });

    location.reload()

}


