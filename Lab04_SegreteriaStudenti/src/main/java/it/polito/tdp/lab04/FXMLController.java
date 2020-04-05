/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class FXMLController {
	
	Model model;
	
	ObservableList<String> listChoiceB; 

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="choiceBC"
    private ChoiceBox<String> choiceBC; // Value injected by FXMLLoader

    @FXML // fx:id="tFM"
    private TextField tFM; // Value injected by FXMLLoader

    @FXML // fx:id="checkBS"
    private CheckBox checkBS; // Value injected by FXMLLoader

    @FXML // fx:id="tFN"
    private TextField tFN; // Value injected by FXMLLoader

    @FXML // fx:id="tFC"
    private TextField tFC; // Value injected by FXMLLoader

    @FXML // fx:id="tAOutput"
    private TextArea tAOutput; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnCompl"
    private Button btnCompl;

    
    public void setModelPlus(Model model) {
		this.model = model;
		
		listChoiceB = FXCollections.observableArrayList();
		listChoiceB.add("");
		
		for(Corso c : model.getTuttiICorsi()) {
			listChoiceB.add(c.getNome());
		}
		
		choiceBC.setItems(listChoiceB);
		
		choiceBC.setValue("");
		
		//btnCompl.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
	}
    
    @FXML
    void completamento(ActionEvent event) {
    	
    	tFN.clear();
    	tFC.clear();
    	tAOutput.clear();
    	
    	Studente stud = model.cercaStudByMatr(tFM.getText());
    	if(stud != null) {
    		tFN.setText(stud.getNome());
    		tFC.setText(stud.getCognome());
    	}else {
    		tAOutput.setText("Matricola errata");
    	}
    }

	@FXML
    void cercaCorsi(ActionEvent event) {

    }

    @FXML
    void cercaIscrittiCorso(ActionEvent event) {
    	
    	tFM.clear();
    	tFN.clear();
    	tFC.clear();
    	tAOutput.clear();
    	
    	String nomeC = choiceBC.getValue();
    	
    	if(nomeC.equals("")){
    		tAOutput.setText("Devi selezionare un corso");
    		return;
    	}
    	
    	List<Studente> list = model.cercaIscrittiCorso(nomeC);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(Studente s : list) {
    		
    		sb.append(String.format("%-10s ", s.getMatricola()));
    		sb.append(String.format("%-20s ", s.getCognome()));
    		sb.append(String.format("%-20s ", s.getNome()));
    		sb.append(String.format("%-10s ", s.getCds()));
    		
    		sb.append("\n");
    		
    		//tAOutput.appendText(s.toString()+"\n");
    	}
    	
    	tAOutput.setText(sb.toString());

    }

    @FXML
    void clearAll(ActionEvent event) {
    	
    	choiceBC.setValue("");
    	tFM.clear();
    	tFN.clear();
    	tFC.clear();
    	tAOutput.clear();

    }

    @FXML
    void iscrivi(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert choiceBC != null : "fx:id=\"choiceBC\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tFM != null : "fx:id=\"tFM\" was not injected: check your FXML file 'Scene.fxml'.";
        assert checkBS != null : "fx:id=\"checkBS\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tFN != null : "fx:id=\"tFN\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tFC != null : "fx:id=\"tFC\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tAOutput != null : "fx:id=\"tAOutput\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
