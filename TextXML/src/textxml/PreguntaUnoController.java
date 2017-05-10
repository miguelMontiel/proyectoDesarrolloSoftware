package textxml;

//import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import static textxml.RegistroController.url;

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
    
    int i = 2, btnM, btnN, btnB;
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/proyectodp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        labelPreguntas.setText("1. En general estoy satisfecho con el servicio brindado:");
        if(buttonMal.isPressed())
        {
            btnM++;
        }
        if(buttonNeutral.isPressed())
        {
            btnN++;
        }
        if(buttonBueno.isPressed())
        {
            btnB++;
        }
    }

    @FXML
    private void siguientePregunta(MouseEvent event) throws IOException, Exception
    {
        switch (i) 
        {
            case 2:
                labelPreguntas.setText(i + ". ¿Cuales son las probabilidades de que vuelva a usar nuestro servicio?");
                i++;
                break;
                
            case 3:
                labelPreguntas.setText(i + ". ¿Que tan probable es que nos recomiende con un amigo o familiar?");
                i++;
                break;
                
            case 4:
                labelPreguntas.setText(i + ". ¿Que tan profesional fue el servicio que recibio?");
                i++;
                break;
                
            case 5:
                labelPreguntas.setText(i + ". La rapidez del servicio fue...");
                i++;
                break;
                
            default:
                Insertar();
                
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(home_page_scene);
                app_stage.hide();
                app_stage.show();
                break;
        }
    }
    
    void Insertar() throws Exception
    {            
        System.out.println("Malos = " + btnM);
        System.out.println("Neutrales = " + btnN);
        System.out.println("Buenos = " + btnB);
        
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
                    "INSERT INTO answers (ID, Malas, Neutrales, Buenas, Active) VALUES (NULL, '" + btnM + "', '" + btnN + "', '" + btnB + "', 1)"
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
