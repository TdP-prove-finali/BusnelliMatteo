package it.polito.tdp.tesiSuperlega;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.tesiSuperlega.model.Giocatore;
import it.polito.tdp.tesiSuperlega.model.Model;
import it.polito.tdp.tesiSuperlega.model.Squadra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ElencoGiocatoriController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimula;

    @FXML
    private ImageView immArsenal;

    @FXML
    private ImageView immAtletico;

    @FXML
    private ImageView immBarca;

    @FXML
    private ImageView immBayern;

    @FXML
    private ImageView immChelsea;

    @FXML
    private ImageView immCity;

    @FXML
    private ImageView immInter;

    @FXML
    private ImageView immJuve;

    @FXML
    private ImageView immLiverpool;

    @FXML
    private ImageView immMilan;

    @FXML
    private ImageView immTott;

    @FXML
    private ImageView immUnited;

    @FXML
    private Label lblArsenal;

    @FXML
    private Label lblAtletico;

    @FXML
    private Label lblBarca;

    @FXML
    private Label lblBayern;

    @FXML
    private Label lblChelsea;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblInter;

    @FXML
    private Label lblJuve;

    @FXML
    private Label lblLiverpool;

    @FXML
    private Label lblMilan;

    @FXML
    private Label lblTott;

    @FXML
    private Label lblUnited;

	Model model;
    Squadra squadraUtente;
    List<Squadra>squadre;


    @FXML
    void handleSimula(ActionEvent event) throws IOException {
    	Model mod = new Model();
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/simulazioneController.fxml"));
    	Parent root = loader.load();
    	SimulazioneController controller= loader.getController();
    	
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add("/styles/Styles.css");
    	
    	controller.setModel(mod, this.squadraUtente, this.squadre);
    	
    	Stage s = new Stage();
    	s.setTitle("Simulazione SUPERLEGA");
    	s.setScene(scene);
    	s.setFullScreen(true);
        s.setFullScreenExitHint("");
    	s.show(); 
    }

    @FXML
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immArsenal != null : "fx:id=\"immArsenal\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immAtletico != null : "fx:id=\"immAtletico\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immBarca != null : "fx:id=\"immBarca\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immBayern != null : "fx:id=\"immBayern\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immChelsea != null : "fx:id=\"immChelsea\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immCity != null : "fx:id=\"immCity\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immInter != null : "fx:id=\"immInter\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immJuve != null : "fx:id=\"immJuve\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immLiverpool != null : "fx:id=\"immLiverpool\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immMilan != null : "fx:id=\"immMilan\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immTott != null : "fx:id=\"immTott\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert immUnited != null : "fx:id=\"immUnited\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblArsenal != null : "fx:id=\"lblArsenal\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblAtletico != null : "fx:id=\"lblAtletico\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblBarca != null : "fx:id=\"lblBarca\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblBayern != null : "fx:id=\"lblBayern\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblChelsea != null : "fx:id=\"lblChelsea\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblCity != null : "fx:id=\"lblCity\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblInter != null : "fx:id=\"lblInter\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblJuve != null : "fx:id=\"lblJuve\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblLiverpool != null : "fx:id=\"lblLiverpool\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblMilan != null : "fx:id=\"lblMilan\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblTott != null : "fx:id=\"lblTott\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";
        assert lblUnited != null : "fx:id=\"lblUnited\" was not injected: check your FXML file 'elencoGiocatoriController.fxml'.";

    }

    public void setModel(Model model, Squadra squadraUtente, List<Squadra> squadre) {
		this.model = model;
		this.squadraUtente = squadraUtente;
		this.squadre = new ArrayList<>(squadre);
		
		//milan
		File f1 = new File("immagini/milan.png");
		immMilan.setImage(new Image(f1.toURI().toString()));
		Squadra milan = squadre.get(0);
		String s1 ="";
		for(Giocatore g : milan.getGiocatoriDellaSquadra()) {
			s1 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s1 += "Intesa totale: "+milan.intesaTotale();
		lblMilan.setText(s1);


		
		//arsenal
		File f2 = new File("immagini/arsenal.png");
		immArsenal.setImage(new Image(f2.toURI().toString()));
		Squadra arsenal = squadre.get(1);
		String s2 ="";
		for(Giocatore g : arsenal.getGiocatoriDellaSquadra()) {
			s2 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s2 += "Intesa totale: "+arsenal.intesaTotale();
		lblArsenal.setText(s2);
		
		
		//chelsea
		File f3 = new File("immagini/chelsea.png");
		immChelsea.setImage(new Image(f3.toURI().toString()));
		Squadra chelsea = squadre.get(2);
		String s3 ="";
		for(Giocatore g : chelsea.getGiocatoriDellaSquadra()) {
			s3 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s3 += "Intesa totale: "+chelsea.intesaTotale();
		lblChelsea.setText(s3);
		
		
		//atletico
		File f4 = new File("immagini/atletico.png");
		immAtletico.setImage(new Image(f4.toURI().toString()));
		Squadra atletico = squadre.get(3);
		String s4 ="";
		for(Giocatore g : atletico.getGiocatoriDellaSquadra()) {
			s4 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s4 += "Intesa totale: "+atletico.intesaTotale();
		lblAtletico.setText(s4);
		
		
		//barca
		File f5 = new File("immagini/barca.png");
		immBarca.setImage(new Image(f5.toURI().toString()));
		Squadra barca = squadre.get(4);
		String s5 ="";
		for(Giocatore g : barca.getGiocatoriDellaSquadra()) {
			s5 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s5 += "Intesa totale: "+barca.intesaTotale();
		lblBarca.setText(s5);
		
		
		//bayern
		File f6 = new File("immagini/bayern.png");
		immBayern.setImage(new Image(f6.toURI().toString()));
		Squadra bayern = squadre.get(5);
		String s6 ="";
		for(Giocatore g : bayern.getGiocatoriDellaSquadra()) {
			s6 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s6 += "Intesa totale: "+barca.intesaTotale();
		lblBayern.setText(s6);
		
		
		//inter
		File f7 = new File("immagini/inter.png");
		immInter.setImage(new Image(f7.toURI().toString()));
		Squadra inter = squadre.get(6);
		String s7 ="";
		for(Giocatore g : inter.getGiocatoriDellaSquadra()) {
			s7 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s7 += "Intesa totale: "+barca.intesaTotale();
		lblInter.setText(s7);
		
		
		//juve
		File f8 = new File("immagini/juve.png");
		immJuve.setImage(new Image(f8.toURI().toString()));
		Squadra juve = squadre.get(7);
		String s8 ="";
		for(Giocatore g : juve.getGiocatoriDellaSquadra()) {
			s8 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s8 += "Intesa totale: "+juve.intesaTotale();
		lblJuve.setText(s8);
		
		
		//liverpool
		File f9 = new File("immagini/liverpool.png");
		immLiverpool.setImage(new Image(f9.toURI().toString()));
		Squadra liv = squadre.get(8);
		String s9 ="";
		for(Giocatore g : liv.getGiocatoriDellaSquadra()) {
			s9 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s9 += "Intesa totale: "+liv.intesaTotale();
		lblLiverpool.setText(s9);
		
		
		//city
		File f10 = new File("immagini/city.png");
		immCity.setImage(new Image(f10.toURI().toString()));
		Squadra city = squadre.get(9);
		String s10 ="";
		for(Giocatore g : city.getGiocatoriDellaSquadra()) {
			s10 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s10 += "Intesa totale: "+city.intesaTotale();
		lblCity.setText(s10);
		
		
		//united
		File f11 = new File("immagini/united.png");
		immUnited.setImage(new Image(f11.toURI().toString()));
		Squadra united = squadre.get(10);
		String s11 ="";
		for(Giocatore g : united.getGiocatoriDellaSquadra()) {
			s11 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s11 += "Intesa totale: "+united.intesaTotale();
		lblUnited.setText(s11);
		
		
		//tottenham
		File f12 = new File("immagini/tottenham.png");
		immTott.setImage(new Image(f12.toURI().toString()));
		Squadra tott = squadre.get(11);
		String s12 ="";
		for(Giocatore g : tott.getGiocatoriDellaSquadra()) {
			s12 += g.getRuolo()+") "+g.getNomeComune()+"\n\n";
		}
		s12 += "Intesa totale: "+tott.intesaTotale();
		lblTott.setText(s12);
		
		
		
		
		
		
}


}

