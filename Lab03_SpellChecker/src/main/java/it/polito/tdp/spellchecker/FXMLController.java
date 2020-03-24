package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.*;

import it.polito.tdp.spellchecker.model.Model;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private ObservableList<String> list = FXCollections.observableArrayList("English", "Italian");
	
	private Model model;
	private LinkedList<String> listaInput = new LinkedList<String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxLanguage;

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
    	txtInput.clear();
    	txtWrong.clear();
    	txtNumberErrors.setText("");
    	txtTime.setText("");
  
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	double start = 0.0;
    	double stop = 0.0;
    	String pippo = "";
    	int contatore = 0;
    	
    	start = System.nanoTime();

    	String lingua = boxLanguage.getValue();
    	model.loadDictionary(lingua);
    	
    	String input = txtInput.getText();
    	
    	String array[] = input.split(" ");
    	
    	for(int i=0; i<array.length; i++) {
    		array[i] = array[i].replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    		listaInput.add(array[i]);
    	}
    	List<RichWord> parole = model.spellCheckText(listaInput, lingua);
    	listaInput.clear();
    	
    	for(RichWord r : parole) {
    		contatore++;
    		if(pippo == "") {
    			pippo = r.getParola();
    		}else {
    			pippo = pippo + "\n" + r.getParola();
    		}
    	}
    	txtWrong.appendText(pippo + "\n");
    	stop = System.nanoTime();
    	
    	txtNumberErrors.setText("The text contains " + contatore + " errors");
    	txtTime.setText("Spell Check completed in " +  ((stop-start)/1e9) + " seconds");
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
       
        boxLanguage.setItems(list);
        boxLanguage.setValue("English");
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
