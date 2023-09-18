
package Modelo;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import Modelo.clsConexion;
import java.awt.HeadlessException;
// para hacer consultas
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;



public class clsEmpledo extends clsPersona{
    clsConexion cn;
    
    private String id;
    private String codigo;
    private String puesto;
    private String Nit;
    
  
    //contructores
    public clsEmpledo(){}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public clsEmpledo(String id, String codigo, String puesto, String Nit, String Nombre, String Apellido, String Direccion, String Telefono, String Fecha_na) {
        super(Nombre, Apellido, Direccion, Telefono, Fecha_na);
        this.id = id;
        this.codigo = codigo;
        this.puesto = puesto;
        this.Nit = Nit;
    }

    public clsEmpledo(String id, String codigo, String puesto, String Nit) {
        this.id = id;
        this.codigo = codigo;
        this.puesto = puesto;
        this.Nit = Nit;
    }
    
    
    
    
    
    
    
    
    
    
    


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

 
    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }
    // insertar a sql
     public void crear(){
         try{
           PreparedStatement parametro;
           String query = "INSERT INTO empleado(codigo,nombres,apellido,direccion,telefono,fecha,idpuesto)VALUES(?,?,?,?,?,?,?);";
           cn = new clsConexion();
           cn.abrir();
           parametro =( PreparedStatement)cn.cnn.prepareStatement(query);
           parametro.setString(1,this.getCodigo());
           parametro.setString(2,this.getNombre());
           parametro.setString(3,this.getApellido());
           parametro.setString(4,this.getDireccion());
           parametro.setString(5,this.getTelefono());
           parametro.setString(6,this.getFecha_na());
             parametro.setString(7,this.getPuesto());
           int ejecutar = 0;
                  ejecutar = parametro.executeUpdate();
           cn.cerrar();
           JOptionPane.showMessageDialog(null,Integer.toString(ejecutar)+ "registro ingresado");
           
         }catch(HeadlessException  | SQLException ex){
             System.out.println("error"+ ex.getMessage());
         }
     
     }

     // leer
     public DefaultTableModel leer(){
     DefaultTableModel tabla = new DefaultTableModel();
     
      try{
            cn = new clsConexion();
           cn.abrir();
          // PreparedStatement parametro;
           String query = "SELECT codigo,nombres,apellido,direccion,telefono,fecha,puestos.puesto from empleado inner join puestos on empleado.idpuesto = puestos.idpuestos;";
           ResultSet consulta= cn.cnn.createStatement().executeQuery(query);
           String  encabezado[]={"CODIGO","NOMBRE","APELLIDO","DIRECCION","TELEFONO","FECHA DE NACIMIENTO","PUESTO"};
           tabla.setColumnIdentifiers(encabezado);
           
           String datos[]= new String[7];
           while(consulta.next()){
           datos[0]= consulta.getString("codigo");
           datos[1]= consulta.getString("nombres");
           datos[2]= consulta.getString("apellido");
           datos[3]= consulta.getString("direccion");
           datos[4]= consulta.getString("telefono");
           datos[5]= consulta.getString("fecha");
           datos[6]= consulta.getString("puesto");
            tabla.addRow(datos);
           }
          
           
           cn.cerrar();
         }catch(SQLException ex){
             System.out.println("error"+ ex.getMessage());
         }
    
     return tabla;
     
     }
     // burcar par amodificar
     public String[] buscar(){
         String datos[]= new String[7];
     try{
            cn = new clsConexion();
           cn.abrir();
           //PreparedStatement parametro;
           String query = "SELECT codigo,nombres,apellido,direccion,telefono,fecha,idpuesto from empleado where idempleado ="+this.getId()+";";
           ResultSet consulta= cn.cnn.createStatement().executeQuery(query);
            while(consulta.next()){
          
           datos[0]= consulta.getString("codigo");
           datos[1]= consulta.getString("nombres");
           datos[2]= consulta.getString("apellido");
           datos[3]= consulta.getString("direccion");
           datos[4]= consulta.getString("telefono");
           datos[5]= consulta.getString("fecha");
           datos[6]= consulta.getString("idpuesto");
        
            }
       
           
           cn.cerrar();
         }catch(SQLException ex){
             System.out.println("error"+ ex.getMessage());
         }
     
     return datos;
     
     }
     // actualizar
     
      public void actualizar(){
         try{
           PreparedStatement parametro;
           String query = "UPDATE empleado SET codigo = ?, nombres = ?, apellido = ?, direccion = ?, telefono = ?, fecha = ?, idpuesto = ? WHERE idempleado ="+this.getId()+";";
           cn = new clsConexion();
           cn.abrir();
           parametro =( PreparedStatement)cn.cnn.prepareStatement(query);
           parametro.setString(1,this.getCodigo());
           parametro.setString(2,this.getNombre());
           parametro.setString(3,this.getApellido());
           parametro.setString(4,this.getDireccion());
           parametro.setString(5,this.getTelefono());
           parametro.setString(6,this.getFecha_na());
           parametro.setString(7,this.getPuesto());
           
           int ejecutar = 0;
                  ejecutar = parametro.executeUpdate();
           cn.cerrar();
           JOptionPane.showMessageDialog(null,Integer.toString(ejecutar)+ "registro Actualizado");
           
         }catch(HeadlessException  | SQLException ex){
             System.out.println("error"+ ex.getMessage());
         }
     
     }
// eliminar DELETE FROM people WHERE Idpeople = 3;
  public void eliminar(){
         try{
           PreparedStatement parametro;
           String query = "DELETE FROM empleado WHERE idempleado = "+this.getId()+";";
           cn = new clsConexion();
           cn.abrir();
           parametro =( PreparedStatement)cn.cnn.prepareStatement(query);
           //parametro.setString(0,this.getId());

           
           int ejecutar = 0;
                  ejecutar = parametro.executeUpdate();
           cn.cerrar();
           JOptionPane.showMessageDialog(null,Integer.toString(ejecutar)+ "registro eliminado");
           
         }catch(HeadlessException  | SQLException ex){
             System.out.println("error"+ ex.getMessage());
         }
     
     }

    
}
