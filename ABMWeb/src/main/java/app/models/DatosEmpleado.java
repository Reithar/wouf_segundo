package app.models;

import java.util.List;
import java.util.*;
import java.text.SimpleDateFormat;
import org.javalite.common.Util;
import org.javalite.activejdbc.Base;

public class DatosEmpleado {
    
    private String documento;
    private String nombre;
    private String apellido;
    private String fecha_alta;
    private String sucursalId;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getSucrusalId() {
        return sucursalId;
    }

    public void setSucursalId(String sucrusalId) {
        this.sucursalId = sucrusalId;
    }

    public DatosEmpleado rellenar(Map datos_empleado) {
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        setFecha_alta(formatoFecha.format(fechaActual));
        
        setNombre(((String) datos_empleado.get("nombre")).toUpperCase());
        setApellido(((String) datos_empleado.get("apellido")).toUpperCase());
        setDocumento(((String) datos_empleado.get("documento")));
        setSucursalId((String) datos_empleado.get("sucursalId"));
        
        return this;
    }
    
    public void validar (){
        if(!documento.matches(" [0-9]*")) {
            throw new IllegalArgumentException("El documento debe contener solo valores numericos");
        } else if (!apellido.matches(("^[A-Za-z]{3,}$"))){
            throw new IllegalArgumentException("El apellido debe contener solo caracteres y mas de");
        } else if (!nombre.matches(("^[A-Za-z ]{3,}$"))){
            throw new IllegalArgumentException("El nombre debe contener solo caracteres y mas de");
        }
        
    }
    
    public static List getListado(){
        String sql = ""
                + " SELECT"
                + "     e.id"
                + "     documento "
                + "     nombre || ' ' || apellido as nombre_empleado "
                + "     CASE "
                + "         WHEN mov.tipo_movimiento = 'E' THEN 'Entrada' "
                + "         WHEN mov.tipo_movimiento = 'S' THEN 'Salida' "
                + "     END as tipo_movimiento,"
                + "     um.fecha_hora "
                + " FROM fichadas.empleado = "
                + " LEFT JOIN ("
                + "     SELECT empleado_id, MAX(fecha_hora) as fecha_hora"
                + "     FROM fichadas.movimiento "
                + "     GROUP BY 1 "
                + ") um "
                + "ON e.id = um.empleado_id "
                + "left join fichadas_movimiento mov "
                + "     on um.empleado_id = mov.empleado_id"
                + "     and um.fecha_hora = mov.fecha_hora ";
        
        List res = Base.findAll(sql);
        return res;
    }
    public static Map getById(Integer id){
        String sql = ""
                + "select"
                + "     e.id,   "
                + "     e.documento, "
                + "     e.nombre,    "
                + "     e.apellido,  "
                + "     e.nombre as sucursal, "
                + "     e.fecha_alta "
                + "from fichadas.empleado e "
                + "inner join "
                + "     fichadas.sucursal s on e.sucursal_id as.id "
                + "where e.id = ?";
        
        List<Map> res = Base.findAll(sql, id);//"SELECT * FROM fichadas.empleado where id = ?", id);
        if(!Util.empty(res)){
            return res.get(0);
        }
        return null;
    }
}
