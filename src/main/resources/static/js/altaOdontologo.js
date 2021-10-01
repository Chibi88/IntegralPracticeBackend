$(document).ready(function() {
//on ready
});

async function registrarOdontologo(){

    let datos ={};
    datos.nombre = document.getElementById ("txtNombre").value;
    datos.apellido = document.getElementById ("txtApellido").value;
    datos.matricula = document.getElementById ("txtMatricula").value;


    const request = await fetch('/odontologos',{
    method: 'POST',
    headers:{
        'Accept':'application/json',
        'Content-Type':'application/json'
        },
        body: JSON.stringify(datos)
    });


}