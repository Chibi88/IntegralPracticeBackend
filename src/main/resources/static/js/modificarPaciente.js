$(document).ready(function() {
//on ready
});

async function modificarPaciente(){

    let datos ={};
    datos.id = document.getElementById ("id").value;
    datos.nombre = document.getElementById ("nombre").value;
    datos.apellido = document.getElementById ("apellido").value;
    datos.telefono = document.getElementById ("telefono").value;


    const request = await fetch('/pacientes',{
    method: 'PUT',
    headers:{
        'Accept':'application/json',
        'Content-Type':'application/json'
        },
        body: JSON.stringify(datos)
    });


}