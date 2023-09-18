
package Modelo;


abstract class clsPersona {
    //atributos
  private String Nombre;  
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String Fecha_na;
    //contructor
    public clsPersona(String Nombre, String Apellido, String Direccion, String Telefono, String Fecha_na) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Fecha_na = Fecha_na;
    }
// constructor vacio
    public clsPersona(){
    }
    //getter and setter
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getFecha_na() {
        return Fecha_na;
    }

    public void setFecha_na(String Fecha_na) {
        this.Fecha_na = Fecha_na;
    }
   
    
    // metodos
    
    
    
    
}
