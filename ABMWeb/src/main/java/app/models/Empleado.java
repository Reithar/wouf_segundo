package app.models;

import java.util.List;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.HasMany;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

@Table("fichadas.empleado")
@BelongsTo(foreignKeyName = "sucursal_ido", parent = Sucursal.class)
@HasMany(child = Movimiento.class, foreignKeyName = "empleado")
public class Empleado extends Model{
    public String getNombreCompleto(){
        return get("nombre") + " " + get("apellido");
    }
    
    //Retornar un listado de todos los empleados
    public static List<Empleado> getTodos(){
        List<Empleado> todos = Empleado.findAll();
        return todos;
    }
    
    public Sucursal getSucursal(){
        return parent(Sucursal.class);
    }
    
    public List<Movimiento> getFichadas(){
        return getAll(Movimiento.class);
    }
}