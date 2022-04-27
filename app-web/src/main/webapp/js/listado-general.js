/*
* Funciones en listadoGeneral.jsp
*/
function guardarId(id) {
	//tomar el hidden que esta en el form y actualizar su value con id
	document.getElementById('idProductoEliminar').value = id;
	// console.log(document.getElementById('idProductoEliminar').value);
}
