package textxml;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static textxml.LoginController.url;

public class InformacionController implements Initializable 
{
    @FXML
    private Button buttonSesion;
    @FXML
    private Button buttonSesion1;
    @FXML
    private TableView<Usuarios> tableClients;
    
    static String login = "root";
    static String passwordDB = "";
    static String url = "jdbc:mysql://localhost/proyectodp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    ResultSet resultset;
    Connection connection = null;
    Statement statement = null;
    
    @FXML
    private TableColumn<?, ?> nombreColumn;
    @FXML
    private TableColumn<?, ?> apellidoColumn;
    @FXML
    private TableColumn<?, ?> correoColumn;
    @FXML
    private TableColumn<?, ?> telefonoColumn;
    @FXML
    private TableColumn<?, ?> fechaNacColumn;
    
    final ObservableList <Usuarios> informeishon = FXCollections.observableArrayList();
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableClients.getColumns();
        Consulta();
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
    
private void Consulta()
    {        
        try 
        {            
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, login, passwordDB);
            statement = connection.createStatement();
            
            resultset = statement.executeQuery
            (
                "SELECT * FROM clients"
            );
            
            while (resultset.next()) 
            { 
                informeishon.add(new Usuarios(
                        resultset.getString("Name"),
                        resultset.getString("Surname"),
                        resultset.getString("Mail"),
                        resultset.getString("Phone"), 
                        resultset.getString("DateBirth")
                ));
                tableClients.setItems(informeishon);
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
    }
}
