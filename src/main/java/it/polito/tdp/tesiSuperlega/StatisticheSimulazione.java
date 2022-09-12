package it.polito.tdp.tesiSuperlega;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.tesiSuperlega.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class StatisticheSimulazione {

	private Model model;
	private String s;	
	private int turno;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblScritta;

    @FXML
    private TextArea txtResult;

    @FXML
    void initialize() {
        assert lblScritta != null : "fx:id=\"lblScritta\" was not injected: check your FXML file 'statisticheSimulazioneController.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'statisticheSimulazioneController.fxml'.";

    }

    public void setModel(Model model, String s, int turno) {
		this.model = model;
		this.s = s;
		this.turno = turno;
		txtResult.setEditable(false);
		lblScritta.setText("Eventi partite turno "+turno);
		txtResult.setText(s);
		
	}

}
