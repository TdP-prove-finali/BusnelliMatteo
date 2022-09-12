package it.polito.tdp.tesiSuperlega;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.tesiSuperlega.model.Giocatore;
import it.polito.tdp.tesiSuperlega.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StatisticheController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView immStat;
    
    @FXML
    private URL location;

    @FXML
    private Label lblGiocatore;

    @FXML
    private TextArea txtResult;

    @FXML
    void initialize() {
        assert lblGiocatore != null : "fx:id=\"lblGiocatore\" was not injected: check your FXML file 'Statistiche.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Statistiche.fxml'.";

    }

	public void setModel(Model model, Giocatore g) {
		this.model = model;
		
		File f1 = new File("immagini/statistiche.png");
		immStat.setImage(new Image(f1.toURI().toString()));
		
		
		lblGiocatore.setText(g.getNomeCompleto());
		
		txtResult.setText(g+"");
	}

    
}
