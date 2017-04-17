package textxml;

//import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PreguntaUnoController implements Initializable 
{
    @FXML
    private Label labelPreguntas;
    @FXML
    private Circle buttonMal;
    @FXML
    private Circle buttonNeutral;
    @FXML
    private Circle buttonBueno;
    int i = 1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        labelPreguntas.setText("Hola");
    }

    @FXML
    private void siguientePregunta(MouseEvent event) throws IOException
    {
        switch (i) 
        {
            case 1:
                labelPreguntas.setText("Pregunta " + i);
                i++;
                break;
            case 2:
                labelPreguntas.setText("Pregunta " + i);
                i++;
                break;
            case 3:
                labelPreguntas.setText("Pregunta " + i);
                i++;
                break;
            case 4:
                labelPreguntas.setText("Pregunta " + i);
                i++;
                break;
            case 5:
                labelPreguntas.setText("Pregunta " + i);
                i++;
                break;
            default:
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(home_page_scene);
                app_stage.hide();
                app_stage.show();
                break;
        }
    }
    
    /*
    private boolean esValido()
    {
        boolean let_in = false;
        Connection c = null;
        Statement stmt = null;
        
        try 
        {
            c = DriverManager.getConnection("jdbc:sqlite:first.db");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Users WHERE USERNAME= " + "'" + username_box.getText() + "'" + " AND PASSWORD= " + "'" + password_box.getText() + "'");
            
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
        catch (Exception e) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("isValidCredentials operation done successfully");
        return let_in;
    }
    */
}
