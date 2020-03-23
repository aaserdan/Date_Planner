package controllers;

/**
 * This class serves as the controller for all of the screens
 *
 * Last updated March 20 2020
 *
 * @author Nimra
 */
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 *
 */
public class SettingController implements Initializable {

    //Combobox for setting of partner one
    @FXML
    protected ComboBox<String> settingP1ComboBox;

    //Combobox for setting of partner two
    @FXML
    protected ComboBox<String> settingP2ComboBox;

    public void settingPartnerOne(ActionEvent _event) throws Exception {

    }

    public void settingPartnerTwo(ActionEvent _event) throws Exception {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
