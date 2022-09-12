package it.polito.tdp.tesiSuperlega;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.tesiSuperlega.model.Giocatore;
import it.polito.tdp.tesiSuperlega.model.MinEvento;
import it.polito.tdp.tesiSuperlega.model.Model;
import it.polito.tdp.tesiSuperlega.model.Squadra;
import it.polito.tdp.tesiSuperlega.model.Statistiche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimulazioneController {
	
	Model model;
    Squadra squadraUtente; //serve solo per confrontare il vincitore e nel caso scrivere all'utente 'COMPLIMENTI HAI VINTO!'
    List<Squadra>squadre; //contiene tutte e 12 le squadre
    List<Squadra> squadreT2;
    List<Squadra> squadreSemifinale;
    List<Squadra> squadreFinale;
    List<Statistiche> statisticheT1;
    List<Statistiche> statisticheT2;
    List<Statistiche> statisticheT3;
    List<Statistiche> statisticheT4;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimulaTurno;

    @FXML
    private TableColumn<Squadra, Integer> colDp;

    @FXML
    private TableColumn<Squadra, Integer> colPunti;

    @FXML
    private TableColumn<Squadra, String> colSquadra;

    @FXML
    private Label finCasa;

    @FXML
    private Label finTrasf;
    
    @FXML
    private Label lblRisFin;

    @FXML
    private Label p1casa;

    @FXML
    private Label p1ris;

    @FXML
    private Label p1trasf;

    @FXML
    private Label p2casa;

    @FXML
    private Label p2ris;

    @FXML
    private Label p2trasf;

    @FXML
    private Label p3casa;

    @FXML
    private Label p3ris;

    @FXML
    private Label p3trasf;

    @FXML
    private Label t1s1;

    @FXML
    private Label t1s10;

    @FXML
    private Label t1s11;

    @FXML
    private Label t1s12;

    @FXML
    private Label t1s2;

    @FXML
    private Label t1s3;

    @FXML
    private Label t1s4;

    @FXML
    private Label t1s5;

    @FXML
    private Label t1s6;

    @FXML
    private Label t1s7;

    @FXML
    private Label t1s8;

    @FXML
    private Label t1s9;

    @FXML
    private Label t2s1;

    @FXML
    private Label t2s2;

    @FXML
    private Label t2s3;

    @FXML
    private Label t2s4;

    @FXML
    private Label t2s5;

    @FXML
    private Label t2s6;
    
    @FXML
    private Button btnStatT1;

    @FXML
    private Button btnStatT2;

    @FXML
    private Button btnStatT3;

    @FXML
    private Button btnStatT4;

    @FXML
    private ImageView immVincitore;

    @FXML
    private Label lblVincitore;
    
    @FXML
    private VBox vbox2;

    @FXML
    private VBox vbox3;

    @FXML
    private VBox vbox4;

    @FXML
    private Button btnEsci;

    @FXML
    private ImageView immSquadra;

    @FXML
    private TableView<Squadra> tblClassifica;

    @FXML
    void handleSimulaTurno(ActionEvent event) {
    	if(this.squadreT2.isEmpty()) {
    		List<Statistiche> stat = new ArrayList<>();
    		for(int i = 0; i < this.squadre.size(); i=i+2) {
        		Statistiche statistiche = this.model.simula(this.squadre.get(i), this.squadre.get(i+1));
        		stat.add(statistiche);
        		if(statistiche.getGolCasa()>statistiche.getGolTrasferta())
        			this.squadreT2.add(this.squadre.get(i));
        		else if(statistiche.getGolCasa()<statistiche.getGolTrasferta()) {
        			this.squadreT2.add(this.squadre.get(i+1));
        		}else {
        			//se pareggiano vanno i calci di rigore
        			if(statistiche.isVittoriaRigoriCasa())
        				this.squadreT2.add(this.squadre.get(i));
        			else
        				this.squadreT2.add(this.squadre.get(i+1));
        			
        			
        		}
        	}
    		
    		this.statisticheT1 = new ArrayList<>(stat);
    		this.t1s1.setText(stat.get(0).getCasa().getNomeSqaudra()+" "+stat.get(0).getGolCasa());
    		this.t1s2.setText(stat.get(0).getTrasferta().getNomeSqaudra()+" "+stat.get(0).getGolTrasferta());
    		if(stat.get(0).getGolCasa()==stat.get(0).getGolTrasferta()) {
    			if(stat.get(0).isVittoriaRigoriCasa())
    				this.t1s1.setText(stat.get(0).getCasa().getNomeSqaudra()+" "+stat.get(0).getGolCasa()+" V dcr");
    			else
    				this.t1s2.setText(stat.get(0).getTrasferta().getNomeSqaudra()+" "+stat.get(0).getGolTrasferta()+" V dcr");
    		}

    		
    		this.t1s3.setText(stat.get(1).getCasa().getNomeSqaudra()+" "+stat.get(1).getGolCasa());
    		this.t1s4.setText(stat.get(1).getTrasferta().getNomeSqaudra()+" "+stat.get(1).getGolTrasferta());
    		if(stat.get(1).getGolCasa()==stat.get(1).getGolTrasferta()) {
    			if(stat.get(1).isVittoriaRigoriCasa())
    				this.t1s3.setText(stat.get(1).getCasa().getNomeSqaudra()+" "+stat.get(1).getGolCasa()+" V dcr");
    			else
    				this.t1s4.setText(stat.get(1).getTrasferta().getNomeSqaudra()+" "+stat.get(1).getGolTrasferta()+" V dcr");
    		}

    		

    		this.t1s5.setText(stat.get(2).getCasa().getNomeSqaudra()+" "+stat.get(2).getGolCasa());
    		this.t1s6.setText(stat.get(2).getTrasferta().getNomeSqaudra()+" "+stat.get(2).getGolTrasferta());
    		if(stat.get(2).getGolCasa()==stat.get(2).getGolTrasferta()) {
    			if(stat.get(2).isVittoriaRigoriCasa())
    				this.t1s5.setText(stat.get(2).getCasa().getNomeSqaudra()+" "+stat.get(2).getGolCasa()+" V dcr");
    			else
    				this.t1s6.setText(stat.get(2).getTrasferta().getNomeSqaudra()+" "+stat.get(2).getGolTrasferta()+" V dcr");
    		}

    		

    		this.t1s7.setText(stat.get(3).getCasa().getNomeSqaudra()+" "+stat.get(3).getGolCasa());
    		this.t1s8.setText(stat.get(3).getTrasferta().getNomeSqaudra()+" "+stat.get(3).getGolTrasferta());
    		if(stat.get(3).getGolCasa()==stat.get(3).getGolTrasferta()) {
    			if(stat.get(3).isVittoriaRigoriCasa())
    				this.t1s7.setText(stat.get(3).getCasa().getNomeSqaudra()+" "+stat.get(3).getGolCasa()+" V dcr");
    			else
    				this.t1s8.setText(stat.get(3).getTrasferta().getNomeSqaudra()+" "+stat.get(3).getGolTrasferta()+" V dcr");
    		}

    		

    		this.t1s9.setText(stat.get(4).getCasa().getNomeSqaudra()+" "+stat.get(4).getGolCasa());
    		this.t1s10.setText(stat.get(4).getTrasferta().getNomeSqaudra()+" "+stat.get(4).getGolTrasferta());
    		if(stat.get(4).getGolCasa()==stat.get(4).getGolTrasferta()) {
    			if(stat.get(4).isVittoriaRigoriCasa())
    				this.t1s9.setText(stat.get(4).getCasa().getNomeSqaudra()+" "+stat.get(4).getGolCasa()+" V dcr");
    			else
    				this.t1s10.setText(stat.get(4).getTrasferta().getNomeSqaudra()+" "+stat.get(4).getGolTrasferta()+" V dcr");
    		}

    		
    		
    		this.t1s11.setText(stat.get(5).getCasa().getNomeSqaudra()+" "+stat.get(5).getGolCasa());
    		this.t1s12.setText(stat.get(5).getTrasferta().getNomeSqaudra()+" "+stat.get(5).getGolTrasferta());
    		if(stat.get(5).getGolCasa()==stat.get(5).getGolTrasferta()) {
    			if(stat.get(5).isVittoriaRigoriCasa())
    				this.t1s11.setText(stat.get(5).getCasa().getNomeSqaudra()+" "+stat.get(5).getGolCasa()+" V dcr");
    			else
    				this.t1s12.setText(stat.get(5).getTrasferta().getNomeSqaudra()+" "+stat.get(5).getGolTrasferta()+" V dcr");
    		}

    		
    		
    		
    		Collections.shuffle(this.squadreT2);
    		this.t2s1.setText(this.squadreT2.get(0).getNomeSqaudra());
    		this.t2s2.setText(this.squadreT2.get(1).getNomeSqaudra());
    		this.t2s3.setText(this.squadreT2.get(2).getNomeSqaudra());
    		this.t2s4.setText(this.squadreT2.get(3).getNomeSqaudra());
    		this.t2s5.setText(this.squadreT2.get(4).getNomeSqaudra());
    		this.t2s6.setText(this.squadreT2.get(5).getNomeSqaudra());
    		
    		vbox2.setVisible(true);
    		
    		btnStatT1.setVisible(true);


    	}
    	else if(this.squadreSemifinale.isEmpty()) {
    		
    		List<Statistiche> stat = new ArrayList<>();
    		for(int i = 0; i < this.squadreT2.size(); i=i+2) {
        		Statistiche statistiche = this.model.simula(this.squadreT2.get(i), this.squadreT2.get(i+1));
        		stat.add(statistiche);
        		if(statistiche.getGolCasa()>statistiche.getGolTrasferta())
        			this.squadreSemifinale.add(this.squadreT2.get(i));
        		else if(statistiche.getGolCasa()<statistiche.getGolTrasferta()) {
        			this.squadreSemifinale.add(this.squadreT2.get(i+1));
        		}else {
        			//se pareggiano vanno i calci di rigore
        			if(statistiche.isVittoriaRigoriCasa())
        				this.squadreSemifinale.add(this.squadreT2.get(i));
        			else
        				this.squadreSemifinale.add(this.squadreT2.get(i+1));
        		}
        	}
    		
    		this.statisticheT2 = new ArrayList<>(stat);

    		this.t2s1.setText(stat.get(0).getCasa().getNomeSqaudra()+" "+stat.get(0).getGolCasa());
    		this.t2s2.setText(stat.get(0).getTrasferta().getNomeSqaudra()+" "+stat.get(0).getGolTrasferta());
    		if(stat.get(0).getGolCasa()==stat.get(0).getGolTrasferta()) {
    			if(stat.get(0).isVittoriaRigoriCasa())
    				this.t2s1.setText(stat.get(0).getCasa().getNomeSqaudra()+" "+stat.get(0).getGolCasa()+" V dcr");
    			else
    				this.t2s2.setText(stat.get(0).getTrasferta().getNomeSqaudra()+" "+stat.get(0).getGolTrasferta()+" V dcr");
    		}

    		
    		this.t2s3.setText(stat.get(1).getCasa().getNomeSqaudra()+" "+stat.get(1).getGolCasa());
    		this.t2s4.setText(stat.get(1).getTrasferta().getNomeSqaudra()+" "+stat.get(1).getGolTrasferta());
    		if(stat.get(1).getGolCasa()==stat.get(1).getGolTrasferta()) {
    			if(stat.get(0).isVittoriaRigoriCasa())
    				this.t2s3.setText(stat.get(1).getCasa().getNomeSqaudra()+" "+stat.get(1).getGolCasa()+" V dcr");
    			else
    				this.t2s4.setText(stat.get(1).getTrasferta().getNomeSqaudra()+" "+stat.get(1).getGolTrasferta()+" V dcr");
    		}

    		

    		this.t2s5.setText(stat.get(2).getCasa().getNomeSqaudra()+" "+stat.get(2).getGolCasa());
    		this.t2s6.setText(stat.get(2).getTrasferta().getNomeSqaudra()+" "+stat.get(2).getGolTrasferta());
    		if(stat.get(2).getGolCasa()==stat.get(2).getGolTrasferta()) {
    			if(stat.get(2).isVittoriaRigoriCasa())
    				this.t2s5.setText(stat.get(2).getCasa().getNomeSqaudra()+" "+stat.get(2).getGolCasa()+" V dcr");
    			else
    				this.t2s6.setText(stat.get(2).getTrasferta().getNomeSqaudra()+" "+stat.get(2).getGolTrasferta()+" V dcr");
    		}

    		

    		
    		Collections.shuffle(this.squadreSemifinale);
    		this.p1casa.setText(this.squadreSemifinale.get(0).getNomeSqaudra());
    		this.p1trasf.setText(this.squadreSemifinale.get(1).getNomeSqaudra());
    		
    		this.p2casa.setText(this.squadreSemifinale.get(2).getNomeSqaudra());
    		this.p2trasf.setText(this.squadreSemifinale.get(0).getNomeSqaudra());
    		
    		this.p3casa.setText(this.squadreSemifinale.get(1).getNomeSqaudra());
    		this.p3trasf.setText(this.squadreSemifinale.get(2).getNomeSqaudra());

    		vbox3.setVisible(true);
    		p1ris.setVisible(false);
    		p2ris.setVisible(false);
    		p3ris.setVisible(false);
    		btnStatT1.setVisible(false);
    		btnStatT2.setVisible(true);

    	}
    	else if(this.squadreFinale.isEmpty()) {
    		
    		List<Statistiche> stat = new ArrayList<>();
    		Statistiche statP1 = this.model.simula(this.squadreSemifinale.get(0), this.squadreSemifinale.get(1));
    		stat.add(statP1);
    		Statistiche statP2 = this.model.simula(this.squadreSemifinale.get(2), this.squadreSemifinale.get(0));
    		stat.add(statP2);
    		Statistiche statP3 = this.model.simula(this.squadreSemifinale.get(1), this.squadreSemifinale.get(2));
    		stat.add(statP3);
    		
    		this.statisticheT3 = new ArrayList<>(stat);

    		this.p1ris.setText(stat.get(0).getGolCasa()+" - "+stat.get(0).getGolTrasferta());
    		this.p2ris.setText(stat.get(1).getGolCasa()+" - "+stat.get(1).getGolTrasferta());
    		this.p3ris.setText(stat.get(2).getGolCasa()+" - "+stat.get(2).getGolTrasferta());
    		p1ris.setVisible(true);
    		p2ris.setVisible(true);
    		p3ris.setVisible(true);

    		
    		for(Statistiche s : stat) {
    			if(s.getGolCasa()>s.getGolTrasferta()) {
    				s.getCasa().setPuntiSemifinale(s.getCasa().getPuntiSemifinale()+3);
    				s.getCasa().setDiffPunti(s.getCasa().getDiffPunti()+(s.getGolCasa()-s.getGolTrasferta()));
    				s.getTrasferta().setDiffPunti(s.getTrasferta().getDiffPunti()+(s.getGolTrasferta()-s.getGolCasa()));
    			}
    			else if(s.getGolCasa()<s.getGolTrasferta()) {
    				s.getTrasferta().setPuntiSemifinale(s.getTrasferta().getPuntiSemifinale()+3);
    				s.getCasa().setDiffPunti(s.getCasa().getDiffPunti()+(s.getGolCasa()-s.getGolTrasferta()));
    				s.getTrasferta().setDiffPunti(s.getTrasferta().getDiffPunti()+(s.getGolTrasferta()-s.getGolCasa()));
    				
    			}
    			else {
    				s.getTrasferta().setPuntiSemifinale(s.getTrasferta().getPuntiSemifinale()+1);
    				s.getCasa().setPuntiSemifinale(s.getCasa().getPuntiSemifinale()+1);
    				s.getCasa().setDiffPunti(s.getCasa().getDiffPunti()+(s.getGolCasa()-s.getGolTrasferta()));
    				s.getTrasferta().setDiffPunti(s.getTrasferta().getDiffPunti()+(s.getGolTrasferta()-s.getGolCasa()));
    				
    			}
    		}
    		
    		Collections.sort(this.squadreSemifinale, new Comparator<Squadra>() {

				@Override
				public int compare(Squadra o1, Squadra o2) {
					
					if(o1.getPuntiSemifinale()!=o2.getPuntiSemifinale()) {
						return o2.getPuntiSemifinale()-o1.getPuntiSemifinale();
					}
					else
						return o2.getDiffPunti()-o1.getDiffPunti();
				}	
    		});
    		
    		this.squadreFinale.add(this.squadreSemifinale.get(0));
    		this.squadreFinale.add(this.squadreSemifinale.get(1));
    		this.finCasa.setText(this.squadreFinale.get(0).getNomeSqaudra());
    		this.finTrasf.setText(this.squadreFinale.get(1).getNomeSqaudra());

    		tblClassifica.setItems(FXCollections.observableArrayList(this.squadreSemifinale));
    		
    		vbox4.setVisible(true);
    		lblRisFin.setVisible(false);
    		lblVincitore.setVisible(false);
    		btnStatT3.setVisible(true);
    		btnStatT2.setVisible(false);
    	}
    	else {
    		List<Statistiche> stat = new ArrayList<>();
    		Statistiche stati = this.model.simula(this.squadreFinale.get(0), this.squadreFinale.get(1));
    		stat.add(stati);
    		this.statisticheT4 = new ArrayList<>(stat);

    		this.lblRisFin.setText(stati.getGolCasa()+" - "+stati.getGolTrasferta());
    		Squadra vincitore = null;
    		if(stati.getGolCasa()>stati.getGolTrasferta())
    			vincitore = stati.getCasa();
    		else if(stati.getGolCasa()<stati.getGolTrasferta())
    			vincitore = stati.getTrasferta();
    		else {
    			if(stati.isVittoriaRigoriCasa()) 
    				vincitore = stati.getCasa();
    			
    			else
    				vincitore = stati.getTrasferta();
    			
				lblRisFin.setText(stati.getGolCasa()+" - "+stati.getGolTrasferta());

    		}

    		lblRisFin.setVisible(true);
    		lblVincitore.setVisible(true);
    		
    		if(vincitore.getNomeSqaudra().equals("AC Milan")) {
    			File f1 = new File("immagini/milan.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("Arsenal FC")) {
    			File f1 = new File("immagini/arsenal.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("Chelsea FC")) {
    			File f1 = new File("immagini/chelsea.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("Atletico de Madrid")) {
    			File f1 = new File("immagini/atletico.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("FC Barcellona")) {
    			File f1 = new File("immagini/barca.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("FC Bayern Munchen")) {
    			File f1 = new File("immagini/bayern.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("FC Internazionale")) {
    			File f1 = new File("immagini/inter.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("Juventus FC")) {
    			File f1 = new File("immagini/juve.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("Liverpool FC")) {
    			File f1 = new File("immagini/liverpool.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("Manchester United FC")) {
    			File f1 = new File("immagini/united.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("Tottenham FC")) {
    			File f1 = new File("immagini/tottenham.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		else if(vincitore.getNomeSqaudra().equals("Manchester City FC")) {
    			File f1 = new File("immagini/city.png");
    			immVincitore.setImage(new Image(f1.toURI().toString()));
    		}
    		
    		if(vincitore.equals(squadraUtente)) {
    			if(stati.getGolCasa()==stati.getGolTrasferta())
        			lblVincitore.setText("Complimenti, dopo i calci di rigore, la tua squadra ha vinto!!!");
    			else
        			lblVincitore.setText("Complimenti, la tua squadra ha vinto!!!");


    		}
    		else {
    			if(stati.getGolCasa()==stati.getGolTrasferta())
    				lblVincitore.setText("Peccato, hai perso.\nIl vincitore dopo i calci di rigore è: "+vincitore.getNomeSqaudra());
    			else 
    				lblVincitore.setText("Peccato, hai perso.\nIl vincitore è: "+vincitore.getNomeSqaudra());

    		}
    		btnStatT4.setVisible(true);
    		btnStatT3.setVisible(false);
    		btnSimulaTurno.setDisable(true);

    	}
    	
    }
    
    @FXML
    void handleStatT1(ActionEvent event) throws IOException {
    	Model mod = new Model();
    	
    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statisticheSimulazioneController.fxml"));
	    	Parent root = loader.load();
	    	StatisticheSimulazione controller= loader.getController();
	    	
	    	Scene scene = new Scene(root);
	    	scene.getStylesheets().add("/styles/Styles.css");
	    	
	    	String stat = "";
	    	for(Statistiche st : this.statisticheT1)
				stat += st+"";
	    	controller.setModel(mod, stat, 1);
	    	Stage s = new Stage();
	    	s.setTitle("Statistiche simulazione TURNO 1");
	    	s.setScene(scene);
	    	s.setX(+450.0);
	    	s.setY(+150.0);
	    	s.show(); 
    }

    @FXML
    void handleStatT2(ActionEvent event) throws IOException {
    	Model mod = new Model();
    	
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statisticheSimulazioneController.fxml"));
    	Parent root = loader.load();
    	StatisticheSimulazione controller= loader.getController();
    	
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add("/styles/Styles.css");
    	
    	String stat = "";
    	for(Statistiche st : this.statisticheT2)
			stat += st+"";
    	controller.setModel(mod, stat, 2);    	
    	Stage s = new Stage();
    	s.setTitle("Statistiche simulazione TURNO 2");
    	s.setScene(scene);
    	s.setX(+450.0);
    	s.setY(+150.0);
    	s.show();
    }

    @FXML
    void handleStatT3(ActionEvent event) throws IOException {
    	Model mod = new Model();
    	
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statisticheSimulazioneController.fxml"));
    	Parent root = loader.load();
    	StatisticheSimulazione controller= loader.getController();
    	
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add("/styles/Styles.css");
    	
    	String stat = "";
    	for(Statistiche st : this.statisticheT3)
			stat += st+"";
    	controller.setModel(mod, stat, 3);    	
    	Stage s = new Stage();
    	s.setTitle("Statistiche simulazione SEMIFINALI");
    	s.setScene(scene);
    	s.setX(+450.0);
    	s.setY(+150.0);
    	s.show();
    }

    @FXML
    void handleStatT4(ActionEvent event) throws IOException {
    	Model mod = new Model();
    	
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statisticheSimulazioneController.fxml"));
    	Parent root = loader.load();
    	StatisticheSimulazione controller= loader.getController();
    	
    	Scene scene = new Scene(root);
    	scene.getStylesheets().add("/styles/Styles.css");
    	
    	String stat = "";
    	for(Statistiche st : this.statisticheT4)
			stat += st+"";
    	controller.setModel(mod, stat, 4);    	
    	Stage s = new Stage();
    	s.setTitle("Statistiche simulazione FINALE");
    	s.setScene(scene);
    	s.setX(+450.0);
    	s.setY(+150.0);
    	s.show();
    }
    
    @FXML
    void handleEsci(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void initialize() {
        assert btnSimulaTurno != null : "fx:id=\"btnSimulaTurno\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert btnStatT1 != null : "fx:id=\"btnStatT1\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert btnStatT2 != null : "fx:id=\"btnStatT2\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert btnStatT3 != null : "fx:id=\"btnStatT3\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert btnStatT4 != null : "fx:id=\"btnStatT4\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert colDp != null : "fx:id=\"colDp\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert colPunti != null : "fx:id=\"colPunti\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert colSquadra != null : "fx:id=\"colSquadra\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert finCasa != null : "fx:id=\"finCasa\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert finTrasf != null : "fx:id=\"finTrasf\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert immVincitore != null : "fx:id=\"immVincitore\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert lblRisFin != null : "fx:id=\"lblRisFin\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert lblVincitore != null : "fx:id=\"lblVincitore\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p1casa != null : "fx:id=\"p1casa\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p1ris != null : "fx:id=\"p1ris\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p1trasf != null : "fx:id=\"p1trasf\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p2casa != null : "fx:id=\"p2casa\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p2ris != null : "fx:id=\"p2ris\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p2trasf != null : "fx:id=\"p2trasf\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p3casa != null : "fx:id=\"p3casa\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p3ris != null : "fx:id=\"p3ris\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert p3trasf != null : "fx:id=\"p3trasf\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s1 != null : "fx:id=\"t1s1\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s10 != null : "fx:id=\"t1s10\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s11 != null : "fx:id=\"t1s11\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s12 != null : "fx:id=\"t1s12\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s2 != null : "fx:id=\"t1s2\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s3 != null : "fx:id=\"t1s3\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s4 != null : "fx:id=\"t1s4\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s5 != null : "fx:id=\"t1s5\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s6 != null : "fx:id=\"t1s6\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s7 != null : "fx:id=\"t1s7\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s8 != null : "fx:id=\"t1s8\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t1s9 != null : "fx:id=\"t1s9\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t2s1 != null : "fx:id=\"t2s1\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t2s2 != null : "fx:id=\"t2s2\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t2s3 != null : "fx:id=\"t2s3\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t2s4 != null : "fx:id=\"t2s4\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t2s5 != null : "fx:id=\"t2s5\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert t2s6 != null : "fx:id=\"t2s6\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert tblClassifica != null : "fx:id=\"tblClassifica\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert vbox2 != null : "fx:id=\"vbox2\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert vbox3 != null : "fx:id=\"vbox3\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        assert vbox4 != null : "fx:id=\"vbox4\" was not injected: check your FXML file 'simulazioneController.fxml'.";
        
        colSquadra.setCellValueFactory(new PropertyValueFactory<Squadra, String>("nomeSqaudra"));
        colPunti.setCellValueFactory(new PropertyValueFactory<Squadra, Integer>("puntiSemifinale"));
        colDp.setCellValueFactory(new PropertyValueFactory<Squadra, Integer>("diffPunti"));


    }
    
    public void setModel(Model model, Squadra squadraUtente, List<Squadra> squadre) {
		this.model = model;
		this.squadraUtente = squadraUtente;
		this.squadre = new ArrayList<>(squadre);
		this.squadreT2 = new ArrayList<>();
		this.squadreSemifinale = new ArrayList<>();
		this.squadreFinale = new ArrayList<>();
		vbox2.setVisible(false);
		vbox3.setVisible(false);
		vbox4.setVisible(false);
		btnStatT1.setVisible(false);
		btnStatT2.setVisible(false);
		btnStatT3.setVisible(false);
		btnStatT4.setVisible(false);

		this.btnSimulaTurno.setStyle("-fx-font-size:18px");
		Collections.shuffle(this.squadre);
		
		this.t1s1.setText(this.squadre.get(0).getNomeSqaudra());
		this.t1s2.setText(this.squadre.get(1).getNomeSqaudra());
		this.t1s3.setText(this.squadre.get(2).getNomeSqaudra());
		this.t1s4.setText(this.squadre.get(3).getNomeSqaudra());
		this.t1s5.setText(this.squadre.get(4).getNomeSqaudra());
		this.t1s6.setText(this.squadre.get(5).getNomeSqaudra());
		this.t1s7.setText(this.squadre.get(6).getNomeSqaudra());
		this.t1s8.setText(this.squadre.get(7).getNomeSqaudra());
		this.t1s9.setText(this.squadre.get(8).getNomeSqaudra());
		this.t1s10.setText(this.squadre.get(9).getNomeSqaudra());
		this.t1s11.setText(this.squadre.get(10).getNomeSqaudra());
		this.t1s12.setText(this.squadre.get(11).getNomeSqaudra());
		
		
		if(squadraUtente.getNomeSqaudra().equals("AC Milan")) {
			File f1 = new File("immagini/milan.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("Arsenal FC")) {
			File f1 = new File("immagini/arsenal.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("Chelsea FC")) {
			File f1 = new File("immagini/chelsea.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("Atletico de Madrid")) {
			File f1 = new File("immagini/atletico.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("FC Barcellona")) {
			File f1 = new File("immagini/barca.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("FC Bayern Munchen")) {
			File f1 = new File("immagini/bayern.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("FC Internazionale")) {
			File f1 = new File("immagini/inter.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("Juventus FC")) {
			File f1 = new File("immagini/juve.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("Liverpool FC")) {
			File f1 = new File("immagini/liverpool.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("Manchester United FC")) {
			File f1 = new File("immagini/united.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("Tottenham FC")) {
			File f1 = new File("immagini/tottenham.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		else if(squadraUtente.getNomeSqaudra().equals("Manchester City FC")) {
			File f1 = new File("immagini/city.png");
			immSquadra.setImage(new Image(f1.toURI().toString()));
		}
		

    }

}
