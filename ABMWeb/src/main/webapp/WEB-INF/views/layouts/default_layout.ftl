<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${context_path}/css/estilos.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Proyecto Activeweb</title>
    </head>
    <body>
        <div class="header">
            <h1>Proyecto Activeweb</h1>
        </div>
        <div class="contenido">
            ${page_content?no_esc}
        </div>
        <hr><!-- comment -->
        <div class="login">
            <#if session.nombre_usuario?has_content>
            <p>conectado como: ${session.nombre_usuario}. <a href="${context_path}/admin/cerrar"> cerrar sesion </a></p>
            <#else>
            <p><a href="${context_path}/admin">Ingresar al area de administracion</a></p><!-- comment -->
            </#if>
        </div>
    </body>
</html>
