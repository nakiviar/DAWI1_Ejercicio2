<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Listado | Productos</title>
<sb:head />
<sj:head jqueryui="true" jquerytheme="redmond" />
</head>
<body>
	<div id="" style="margin-left: 30%; margin-right: 30%;">
	<!-- EN CONSTRUCCION -->
		<h1>LISTADO DE PRODUCTOS</h1>

<s:iterator value="listaProducto" status="">
<table>
<thead>
<tr>
<th>CODIGO</th>
<th>DESCRIPCION</th>
<th>STOCK</th>
<th>PRECIO</th>
<th>ESTADO</th>
</tr>
</thead>
<tbody>
<tr>
<td><s:property value="codigo"/> </td>
<td><s:property value="descripcion"/> </td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>

</table>
</s:iterator>
		<s:submit value="Registrar" cssClass="btn btn-primary"></s:submit>
		<s:submit value="Eliminar" cssClass="btn btn-info"></s:submit>
		<s:submit value="Actualizar" cssClass="btn btn-danger"></s:submit>
		<s:submit value="Listado" cssClass="btn btn-warning"></s:submit>

		<br>
		<s:actionmessage theme="bootstrap" />
		<s:actionerror theme="bootstrap" />
		<br>
		<p>
			Mensaje sin bootstrap :
			<s:property value="mensaje" />
		</p>
	</div>
</body>
</html>