<div class="container">
    <div class="error"></div>
    <div class="table responsive">
        <h2 class="h2" style?"padding: 20px; text-align: center;">Listado de empleados</h2>
        <table class="table table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre completo</th>
                    <th></th>
                    <th>Ultimo movimiento</th>
                </tr>
            </thead>
        <tbody>
            <#list filas as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.nombre_completo}<td>
                <td>${item.tipo_movimiento!''} - ${item.fecha_hora!''}</td>
                <td><a href="${context_path}/empleados/ver/${item.id}" title="Ver datos">
                    <svg width="1em" height="1em" viewBox='0 0 16 16" class ="bi bi-search" fil
                        <path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.412 0l3.85 3.8
                        <path fill-rule="evenodd" d="MG.5 12a5.5 5.5 0 1 0 0 11 5.5 5.5 0 0 0
                    </svg>
                </a>
            </td>
        </tr>
        </#list>
    </tbody>
<table>
</div>
</div>

<style>
    div.error {color: red; display: none;}
</style>