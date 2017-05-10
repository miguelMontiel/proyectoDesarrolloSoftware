package textxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class InformacionController implements Initializable 
{
    @FXML
    private Button buttonSesion;
    @FXML
    private Button buttonSesion1;
    @FXML
    private TableView<?> tableClients;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
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
}
