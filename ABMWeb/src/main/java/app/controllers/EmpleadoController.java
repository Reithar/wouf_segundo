package app.controllers;

import org.javalite.activeweb.AppController;
import java.util.List;
import app.models.Sucursal;

public class EmpleadoController extends AppController {
    
    public void index(){
    }
    
    public void mostrar(){
        List<Sucursal> listaSucursal = Sucursal.findAll();
        view("listasucursal", listaSucursal);
        
        //LazyList<Empleado>
    }
}
