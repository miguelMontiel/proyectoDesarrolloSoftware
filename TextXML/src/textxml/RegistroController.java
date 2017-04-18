package textxml;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    private TextField textfieldCalle;
    @FXML
    private TextField textfieldColonia;
    @FXML
    private ComboBox<?> comboboxDelegacion;
    
    static String bd = "Farmacia";

    static String login = "root";

    static String password = "";

    static String url = "jdbc:mysql://localhost/" + bd;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    { 
    }    

    @FXML
    private void paginaIndex(ActionEvent event) throws IOException 
    {
        if("".equals(textfieldNombre.getText()) || "".equals(textfieldApellido.getText()) || "".equals(textfieldCorreo.getText()) || "".equals(textfieldCalle.getText()) || "".equals(textfieldColonia.getText()) || "".equals(datepickerFechaNac.getValue()) || "".equals(comboboxDelegacion.getValue()))
        {
            System.out.println("NOOO");
        }
        else
        {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.hide();
            app_stage.show();
        }
    }
    /*
    private boolean esValido()
    {
        boolean let_in = false;
        System.out.println("Nombre = " + textfieldNombre.getText());
        System.out.println("Apellido = " + textfieldApellido.getText());
        System.out.println("Correo = " + textfieldCorreo.getText());
        System.out.println("Calle = " + textfieldCalle.getText());
        System.out.println("Colonia = " + textfieldColonia.getText());
        System.out.println("Fecha de Nacimiento = " + datepickerFechaNac.getValue());
        System.out.println("Delegacion = " + comboboxDelegacion.getValue());
    
        Connection c = null;
        Statement stmt = null;
        try 
        {
            c = DriverManager.getConnection(url, login, password);
            c.setAutoCommit(false);
            
            System.out.println("Conexion exitosa!");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery
            ( 
                "INSERT INTO CRMproyecto VALUES ('','" + textfieldNombre.getText()) 
            );
            
            while (rs.next()) 
            {
                if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) 
                { 
                    String  username = rs.getString("USERNAME");
                    System.out.println( "USERNAME = " + username );
                    String password = rs.getString("PASSWORD");
                    System.out.println("PASSWORD = " + password);
                    let_in = true;
                }  
            }
            rs.close();
            stmt.close();
            c.close();
            } 
            catch ( Exception e ) 
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("isValidCredentials operation done successfully");
return let_in; 
*/
}
