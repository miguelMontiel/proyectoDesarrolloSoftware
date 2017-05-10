package textxml;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistroController implements Initializable 
{
    @FXML
    private AnchorPane paneRegistro;
    @FXML
    private Button buttonIngresar;
    @FXML
    private DatePicker datepickerFechaNac;
    @FXML
    private TextField textfieldNombre;
    @FXML
    private TextField textfieldApellido;
    @FXML
    private TextField textfieldCorreo;
    @FXML
    private TextField textfieldCelular;
    @FXML
    private TextField textfieldCalle;
    @FXML
    private TextField textfieldColonia;
    @FXML
    private ComboBox<String> comboboxDelegacion = new ComboBox<String>();
    @FXML
    private CheckBox checkboxPromociones;
    
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/proyectodp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    String nombre;
    String apellido;
    String correo; 
    String celular;
    String calle;
    String colonia;
    String delegacion;
    String fecha;
    boolean promociones;
    int intPromociones;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    { 
        comboboxDelegacion.getItems().addAll("Miguel Hidalgo","Cuauhtemoc","Azcapotzalco","Neza York");
    }    

    @FXML
    private void paginaIndex(ActionEvent event) throws IOException, Exception 
    {
        if("".equals(textfieldNombre.getText()) || "".equals(textfieldApellido.getText()) || "".equals(textfieldCorreo.getText()) || "".equals(textfieldCelular.getText()) || "".equals(textfieldCalle.getText()) || "".equals(textfieldColonia.getText()) || "".equals(datepickerFechaNac.getValue()) || "".equals(comboboxDelegacion.getValue()))
        {
            System.out.println("NOOO");
        }
        else
        {            
            Insertar();
            
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.hide();
            app_stage.show();
        }
    }
    
    void Insertar() throws Exception
    {              
        nombre = textfieldNombre.getText();
        apellido = textfieldApellido.getText();
        correo = textfieldCorreo.getText();
        celular = textfieldCelular.getText();
        calle = textfieldCalle.getText();
        colonia = textfieldColonia.getText();
        delegacion = comboboxDelegacion.getValue();
        fecha = datepickerFechaNac.getEditor().getText();
        promociones = checkboxPromociones.isSelected();
        
        if(promociones)
        {
            intPromociones = 1;
        }
        else
        {
            intPromociones = 0;
        }
    
        System.out.println("Nombre = " + nombre);
        System.out.println("Apellido = " + apellido);
        System.out.println("Correo = " + correo);
        System.out.println("Celular = " + celular);
        System.out.println("Calle = " + calle);
        System.out.println("Colonia = " + colonia);
        System.out.println("Fecha de Nacimiento = " + fecha);
        System.out.println("Delegacion = " + delegacion);
        System.out.println("Promocion = " + promociones);
        System.out.println("Promocion = " + intPromociones);
        
        Connection connection = null;
        Statement statement = null;
        
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, login, password);
            statement = connection.createStatement();
            
            if (connection != null)
            {
                System.out.println("Conexion a base de datos " + url + " ... Ok");
                statement.executeUpdate
                (
                    "INSERT INTO clients (ID, Name, Surname, Mail, Phone, Street, Colony, Delegation, DateBirth, Promotions, Active) VALUES (NULL, '" + nombre + "', '" + apellido + "', '" + correo + "', '" + celular + "', '" + calle + "', '" + colonia + "', '" + delegacion + "', '" + fecha + "', '" + intPromociones + "', 1)"
                );
                System.out.println("Insertado!");
                connection.close();
            }
        }
            
        catch(SQLException ex)
        {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url + ": " + ex.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        } 
    }
}
