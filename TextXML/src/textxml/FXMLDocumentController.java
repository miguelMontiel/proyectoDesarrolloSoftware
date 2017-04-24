package textxml;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable 
{    
    @FXML
    private Button buttonRegistro;
    @FXML
    private AnchorPane paneIndex;
    @FXML
    private Button buttonPreguntas;
    @FXML
    private Label labelTiempo;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @FXML
    private Button buttonLogin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        labelTiempo.setText("Hola");
    }    
    
    @FXML
    private void paginaLogin(ActionEvent event) throws IOException 
    {
        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.hide();
        stage.show();
    }
    
    @FXML
    private void paginaRegistro(ActionEvent event) throws IOException  
    {
        Parent parent = FXMLLoader.load(getClass().getResource("Registro.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.hide();
        stage.show();
    }
    
    @FXML
    private void paginaPreguntas(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(getClass().getResource("PreguntaUno.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.hide();
        stage.show();
    }
    
    /*
            --- PARA CONEXION A BASE DE DATOS Y COMPROBACION DE CREDENCIALES ---
    
        private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           if (isValidCredentials())
            {
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            }
            else
            {
                username_box.clear();
                password_box.clear();
                invalid_label.setText("Sorry, invalid credentials"); 
            }
    }
     private boolean isValidCredentials()
    {
        boolean let_in = false;
        System.out.println( "SELECT * FROM Users WHERE USERNAME= " + "'" + username_box.getText() + "'" 
            + " AND PASSWORD= " + "'" + password_box.getText() + "'" );
    
        Connection c = null;
        java.sql.Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:first.db");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Users WHERE USERNAME= " + "'" + username_box.getText() + "'" 
            + " AND PASSWORD= " + "'" + password_box.getText() + "'");
            
            while ( rs.next() ) {
                 if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) { 
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
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("isValidCredentials operation done successfully");
return let_in;
    */    
}
