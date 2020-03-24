package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.*;

import it.polito.tdp.spellchecker.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	ObservableList<String> list = FXCollections.observableArrayList();
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> boxLanguage;

    @FXML
    private TextArea txtInput;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtWrong;

    @FXML
    private Label txtNumberErrors;

    @FXML
    private Button btnClearText;

    @FXML
    private Label txtTime;

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert boxLanguage != null : "fx:id=\"boxLanguage\" was not injected: check your FXML file 'scene_lab3.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'scene_lab3.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'scene_lab3.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'scene_lab3.fxml'.";
        assert txtNumberErrors != null : "fx:id=\"txtNumberErrors\" was not injected: check your FXML file 'scene_lab3.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'scene_lab3.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'scene_lab3.fxml'.";
        
        list.addAll("English","Italian");
       // boxLanguage.setItems(list);
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
