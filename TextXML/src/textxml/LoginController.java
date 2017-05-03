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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable 
{
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/proyectodp";
    
    @FXML
    private Button buttonAccesar;
    @FXML
    private Button buttonRegresar;
    @FXML
    private TextField usuarioTextfield;
    @FXML
    private TextField passwordTextfield;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void paginaInformacion(ActionEvent event) throws IOException 
    {
        if(esValido())
        {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("Informacion.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.hide();
            app_stage.show();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Datos equivocados");
        }

    }

    @FXML
    private void paginaIndex(ActionEvent event) throws IOException 
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.hide();
        app_stage.show();
    }
    
    private boolean esValido()
    {
        boolean let_in = false;
        
        String usuario = usuarioTextfield.getText();
        String password = passwordTextfield.getText();
        
        Connection connection = null;
        Statement statement = null;
        
        try 
        {            
            connection = DriverManager.getConnection(url, login, password);
            connection.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            statement = connection.createStatement();
            
            ResultSet resultset = statement.executeQuery
            (
                "SELECT * FROM Users WHERE USERNAME = " + "'" + usuario + "'" + " AND PASSWORD= " + "'" + password + "'"
            );
            
            while (resultset.next()) 
            {
                if (resultset.getString("USERNAME") != null && resultset.getString("PASSWORD") != null) 
                { 
                    let_in = true;
                }  
            }
            resultset.close();
            statement.close();
            connection.close();
        } 
        
        catch (Exception e) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("isValidCredentials operation done successfully");
        return let_in;
    }
}
