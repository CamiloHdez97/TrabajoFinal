// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarProductos();
  $('#inventario').DataTable();
  actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario() {
    document.getElementById('txt-email').outerHTML = localStorage.email;
}

async function cargarProductos(){

//Productos tomado de la ruta (link) del controlador.
  const request = await fetch('api/productos', {
    method: 'GET',
    headers: getHeaders()
  });
  const inventario = await request.json();

 let listadoHtml = '';

 for(let producto of inventario){

  let botonEliminar = '<a href="#" onclick="eliminarProducto(' + producto.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

  let productoHtml = '<tr><td>'+producto.id+'</td><td>'+producto.descripcion+'</td><td>$'+producto.valor+'</td><td>'+producto.cant+'</td><td>' +botonEliminar+ '</td></tr>';

  listadoHtml += productoHtml;

 }
//Especificamos id de la tabla
document.querySelector('#productos tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function eliminarProducto(id){

if (!confirm('¿Desea eliminar este producto?')){
    return;
}

 const request = await fetch('api/productos/' + id, {
    method: 'DELETE',
    headers: getHeaders()
  });

location.reload();

 }