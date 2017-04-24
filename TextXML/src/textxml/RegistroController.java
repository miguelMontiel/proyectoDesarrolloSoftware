package textxml;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/proyectodp";
    @FXML
    private CheckBox checkboxPromociones;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    { 
        comboboxDelegacion.getItems().addAll("A","B","C","D","E");
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
            esValido();
            
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.hide();
            app_stage.show();
        }
    }
    
    void esValido() throws Exception
    {
        System.out.println("Nombre = " + textfieldNombre.getText());
        System.out.println("Apellido = " + textfieldApellido.getText());
        System.out.println("Correo = " + textfieldCorreo.getText());
        System.out.println("Celular = " + textfieldCelular.getText());
        System.out.println("Calle = " + textfieldCalle.getText());
        System.out.println("Colonia = " + textfieldColonia.getText());
        System.out.println("Fecha de Nacimiento = " + datepickerFechaNac.getValue());
        System.out.println("Delegacion = " + comboboxDelegacion.getValue());
        System.out.println("Promocion = " + checkboxPromociones.isSelected());
    
        Connection connection = null;
        Statement statement = null;
        
        try 
        {
            connection = DriverManager.getConnection(url, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            if (connection != null)
            {
                System.out.println("Conexion a base de datos " + url + " ... Ok");
                statement.executeUpdate
                (
                    "INSERT INTO 'clients' VALUES ('','" + 
                            textfieldNombre.getText() + "','" + 
                            textfieldApellido.getText() + "','" + 
                            textfieldCorreo.getText() + "','" + 
                            textfieldCelular.getText() + "','" + 
                            textfieldCalle.getText() + "','" + 
                            textfieldColonia.getText() + "','" + 
                            comboboxDelegacion.getValue() + "','" + 
                            datepickerFechaNac.getValue() + "','" + 
                            checkboxPromociones.isSelected() + "', '')"
                );
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
            return;
        } 
    }
}
