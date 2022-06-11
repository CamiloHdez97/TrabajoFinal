// Call the dataTables jQuery plugin
$(document).ready(function() {
    actualizarEmailDelUsuario();
});
function actualizarEmailDelUsuario() {
    document.getElementById('txt-email').outerHTML = localStorage.email;
}
async function registrarProducto(){
    let datos = {};
    datos.descripcion = document.getElementById('txtDescripcion').value;
    datos.valor = document.getElementById('txtValor').value;
    datos.cant = document.getElementById('txtCantidad').value;

    if (datos.descripcion == "" || datos.valor == "" || datos.cant == "") {
       alert('Falta rellenar uno o mas campos.');
         return;
    }

    //Evaluar expresión de valor y cantidad como numéricos.
     var re = /^[0-9]+$/;
     if(!re.test(document.getElementById('txtValor').value) || !re.test(document.getElementById('txtCantidad').value) ){
        alert('Los campos "Valor" y "Cantidad", solo permite valores numéricos.');
        return;
     }

//Productos tomado de la ruta (link) del controlador.
  const request = await fetch('api/productos', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token
    },
    body: JSON.stringify(datos)
  });

    alert("El producto se agrego con exito!");
    window.location.href = 'inventario.html'

}