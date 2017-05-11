package textxml;

import javafx.beans.property.SimpleStringProperty;

public class Usuarios 
{
    private final SimpleStringProperty name;
    private final SimpleStringProperty apellido;
    private final SimpleStringProperty correo;
    private final SimpleStringProperty telefono;
    private final SimpleStringProperty fechaNac;
    
    public Usuarios(String Name, String Apellido, String Correo, String Telefono, String FechaNac)
    {
        this.name = new SimpleStringProperty(Name);
        this.apellido = new SimpleStringProperty(Apellido);
        this.correo = new SimpleStringProperty(Correo);
        this.telefono = new SimpleStringProperty(Telefono);
        this.fechaNac = new SimpleStringProperty(FechaNac);
    }
    
    public String getName()
    {
        return name.get();
    }
    public String getApellido()
    {
        return apellido.get();
    }
    public String getCorreo()
    {
        return correo.get();
    }
    public String getTelefono()
    {
        return telefono.get();
    }
    public String FechaNac()
    {
        return fechaNac.get();
    }
}
