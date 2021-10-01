$(document).ready(function() {
//on ready
});

const input = document.querySelector('#id');
const input2 = document.querySelector('#apellido');
input.addEventListener('change', cargarId);
input2.addEventListener('change', cargarApellido);

function cargarId(e) {
  let idPaciente = document.querySelector ('#id').value;
  document.querySelector ('#botonBuscar').innerHTML = '<a href="#" onclick = "buscarPacientePorId('+idPaciente+')"class="btn btn-primary btn-user btn-block"> Buscar paciente' +idPaciente+ ' </a>';
}

function cargarApellido(e) {
  let apellidoPaciente = document.querySelector ('#apellido').value;
  document.querySelector ('#botonBuscarApellido').innerHTML = '<a href="#" onclick = "buscarPacientePorApellido()"class="btn btn-primary btn-user btn-block"> Buscar por apellido</a>';
}

async function buscarPacientePorId (id){
let idPaciente = document.querySelector ('#id').value;
const request = await fetch('pacientes/' + idPaciente,{
    method: 'GET',
    headers: {
               'Accept':'application/json',
               'Content-Type':'application/json'
                 }
    });

    const paciente = await request.json();

    console.log(paciente);


    let pacienteTraido =  '<br> <h6 >ID: '+paciente.id+'</h6><h6>Paciente: '+ paciente.nombre + " " + paciente.apellido+
                          ' </h6><h6> Telefono: '+paciente.telefono +' </h6>';

    document.querySelector ('#resultado').innerHTML = pacienteTraido;

}


async function buscarPacientePorApellido(){

let apellidoPaciente = document.querySelector ('#apellido').value;
const request = await fetch('pacientes/getLastname?apellido='+ apellidoPaciente,{
    method: 'GET',
    headers: {
               'Accept':'application/json',
               'Content-Type':'application/json'
                 }
    });

    const pacienteA = await request.json();

    console.log(pacienteA);


    let pacienteTraidoLast =  '<br> <h6 > Ver en consola jajaja -> </h6>';

    document.querySelector ('#resultadoApellido').innerHTML = pacienteTraidoLast;

}
