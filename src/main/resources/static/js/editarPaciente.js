$(document).ready(function() {
//on ready
});

async function editarPaciente(){

    let datos ={};
    datos.nombre = document.getElementById ("txtNombre").value;
    datos.apellido = document.getElementById ("txtApellido").value;
    datos.telefono = document.getElementById ("txtTelefono").value;
    datos.dni = document.getElementById ("txtDni").value;
    datos.fechaAlta = document.getElementById ("txtFechaAlta").value;
    datos.domicilio = document.getElementById ("txtDomicilio").value;

    const request = await fetch('/pacientes',{
    method: 'PUT',
    headers:{
        'Accept':'application/json',
        'Content-Type':'application/json'
        },
        body: JSON.stringify(datos)
    });


}