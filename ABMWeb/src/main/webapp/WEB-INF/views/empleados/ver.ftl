

<div class="container table-responsive">
    <h2 class="h2" style="padding: 20px; text-align: center;">Datos empleado</h2>

    <table class="table table-hover">
        <tr>
            <th>id</th>
            <td>${empleado.id}</td>
        </tr>
        <tr>
            <th>Nombre completo</th>
            <td>${empleado.nombre} ${empleado.apellido}</td>
        </tr>
        <tr>
            <th>Documento</th>
            <td>${empleado.documento}</td>
        </tr>
        <tr>
            <th>Sucursal</th>
            <td>${empelado.sucursal}</td>
        </tr>
        <tr>
            <th>Fecha alta</th>
            <td>${empleado.fecha_alta}</td>
        </tr>
    </table>
    <a class="btn btn-primary" href="${context_path}/empleados">volver</a>
</div>