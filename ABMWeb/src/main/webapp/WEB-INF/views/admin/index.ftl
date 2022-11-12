<h2>Ejemplo de autenticacion</h2>
<h4>Administracion</h4>
<p>Este es el area de administracion. Solo los usuarios con rol "administracion" pueden acceder.</p>
<#if session.puede_acceder_area_restringida!false>
<a href="${context_path}/admin/restringido">Ir al área restringida</a>
</#if>
<#if session.puede_acceder_a_otra_area!false>
<a href="${context_path}/admin/otra">Ir a otra área</a>
</#if>