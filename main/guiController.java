package main;

/**
 * This class serves as the controller for home screen
 *
 * Last updated 3/10/2020
 *
 * @author Nimra
 */
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author nimrasami
 */
public class guiController implements Initializable {

    //FXML loader
    @FXML
    private ImageView background;

    public void changeToPlanScreen(ActionEvent _event) throws Exception {

        //new FXML loader and scene for new screen
        Parent root = FXMLLoader.load(getClass().getResource("/Views/PlanScene.fxml"));
        Scene HomeScene = new Scene(root);

        //Get information from primary stage
        Stage appStage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        appStage.setScene(HomeScene);
        appStage.show();
    }

    public void changeToResultsScreen(ActionEvent _event) throws Exception {

        //new FXML loader and scene for new screen
        Parent root = FXMLLoader.load(getClass().getResource("/Views/ResultsScene.fxml"));
        Scene resultScene = new Scene(root);

        //Get information from primary stage
        Stage rStage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        rStage.setScene(resultScene);
        rStage.show();
    }

    /*private void changeToScreen(ActionEvent _event) throws IOException {
        //new FXML loader and scene for new screen
        Parent plan = FXMLLoader.load(getClass().getResource("/GUI/Views/ResultsScene.fxml"));
        Scene planScene = new Scene(plan);

        //Get information from primary stage
        Stage appStage = (Stage) ((Node) _event.getSource()).getScene().getWindow();
        appStage.setScene(planScene);
        appStage.show();
    }
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
