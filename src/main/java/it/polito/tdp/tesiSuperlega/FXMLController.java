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
import it.polito.tdp.tesiSuperlega.model.Model;
import it.polito.tdp.tesiSuperlega.model.Squadra;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class FXMLController {

	private Model model;
	
	@FXML
    private BorderPane borderPane;
	
	@FXML
    private Button btnComponiSquadra;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRimuoviGiocatore;

    @FXML
    private Button btnScegliGiocatore;

    @FXML
    private Button btnSimula;

    @FXML
    private Button btnVisualizzaStatGiocSelezionato;

    @FXML
    private ComboBox<String> cmbModulo;

    @FXML
    private ComboBox<Squadra> cmbsquadra;

    @FXML
    private TableColumn<Giocatore, String> colNome;

    @FXML
    private TableColumn<Giocatore, Integer> colOverall;

    @FXML
    private TableColumn<Giocatore, String> colRuolo;

    @FXML
    private TableColumn<Giocatore, Integer> colStipendio;

    @FXML
    private TableColumn<Giocatore, String> clNome;

    @FXML
    private TableColumn<Giocatore, Integer> clOv;

    @FXML
    private TableColumn<Giocatore, String> clRuolo;

    @FXML
    private TableColumn<Giocatore, Integer> clStip;
    
    @FXML
    private TableColumn<Giocatore, Integer> clVal;

    
    @FXML
    private Label lblGiocatoreSuggerito;
    
    @FXML
    private Label lblBudgetRimanente;

    @FXML
    private Label lblBudgetRimasto;

    @FXML
    private Label lblErrore1;

    @FXML
    private Label lblErrore2;

    @FXML
    private Label lbl1;
    
    @FXML
    private Label lbl2;
    
    @FXML
    private Label lbl3;
    
    @FXML
    private Label lblNumGiocatori;
    
    @FXML
    private Label lblInt;

    @FXML
    private Label lblIntesaTotale;
    
    @FXML
    private TableView<Giocatore> tblvgiocatori;

    @FXML
    private TableView<Giocatore> tblvgiocatoriSquadra;
    
    @FXML
    private TextArea txtGiocatoreSuggerito;

    @FXML
    private TextArea txtGiocatoriSceltiAltreSquadre;

    @FXML
    private TextField txtsalarycap;
    
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
    private Button btnReset;

    private int salaryCap = 0;
    
    private List<ImageView> immagini;
    
    private Squadra scelta = null;
    
    @FXML
    void handleComponiSquadra(ActionEvent event) {
    	lblErrore1.setText("");
    	boolean ok = false;
    	
    	
    		
    		try {
        		salaryCap = Integer.parseInt(txtsalarycap.getText());
        		
        		if(salaryCap>0 && salaryCap<1000000000)
        			ok = true;
        		else
            		lblErrore1.setText("Errore, inserisci un valore numerico tra 0 e 1 miliardo");

        		
        	}catch(NumberFormatException e) {
        		lblErrore1.setText("Errore, ricontrolla i campi inseriti");
        		btnComponiSquadra.setDisable(false);
        		txtsalarycap.clear();
        		return;
        	}
    	
    		
    		if(ok) {
    			if(cmbsquadra.getValue() != null && cmbModulo.getValue() != null) {
    	    		Squadra scelta = cmbsquadra.getValue();
    	    		this.scelta = scelta;
    	    		if(scelta.getNomeSqaudra().equals("AC Milan")) {
    	    			this.immInter.setImage(this.immMilan.getImage());
    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("Arsenal FC")) {
    	    			this.immInter.setImage(this.immArsenal.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("Chelsea FC")) {
    	    			this.immInter.setImage(this.immChelsea.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("Atletico de Madrid")) {
    	    			this.immInter.setImage(this.immAtletico.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("FC Barcellona")) {
    	    			this.immInter.setImage(this.immBarca.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("FC Bayern Munchen")) {
    	    			this.immInter.setImage(this.immBayern.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("Juventus FC")) {
    	    			this.immInter.setImage(this.immJuve.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("Liverpool FC")) {
    	    			this.immInter.setImage(this.immLiverpool.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("Manchester United FC")) {
    	    			this.immInter.setImage(this.immUnited.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("Tottenham FC")) {
    	    			this.immInter.setImage(this.immTott.getImage());

    	    		}
    	    		else if(scelta.getNomeSqaudra().equals("Manchester City FC")) {
    	    			this.immInter.setImage(this.immCity.getImage());

    	    		}
    	    		this.immagini.remove(this.immInter);
    	    		for(ImageView i : this.immagini) {
    	    			i.setVisible(false);
    				}
    	    	btnComponiSquadra.setDisable(true);
    			tblvgiocatori.setVisible(true);
    			btnVisualizzaStatGiocSelezionato.setVisible(true);
    			btnScegliGiocatore.setVisible(true);
    			lblGiocatoreSuggerito.setVisible(true);
    			txtGiocatoreSuggerito.setVisible(true);
    			lblBudgetRimanente.setVisible(true);
    			lblBudgetRimasto.setVisible(true);
    			lbl1.setVisible(true);
    			tblvgiocatoriSquadra.setVisible(true);
    			lbl2.setVisible(true);
    			lbl3.setVisible(true);
    			lblInt.setVisible(true);
    			txtGiocatoriSceltiAltreSquadre.setVisible(true);
    			btnRimuoviGiocatore.setVisible(true);
    			btnSimula.setVisible(true);
    			btnSimula.setDisable(true);
    			btnReset.setVisible(true);
    			btnReset.setDisable(false);

    			
    			this.model.squadraScelta(cmbsquadra.getValue());
    			this.model.salaryCapScelto(salaryCap);
    			lblBudgetRimasto.setText(this.model.getBudgetRimasto()+" €");
    			this.model.moduloScelto(cmbModulo.getValue());
    			lblNumGiocatori.setText(this.model.getNumPortieri()+"P -- "+this.model.getNumDifensori()+"D -- "+this.model.getNumCentrocampisti()+"C -- "+this.model.getNumAttaccanti()+"A");
    			tblvgiocatori.setItems(FXCollections.observableArrayList(this.model.getAllGiocatoriByRuolo(this.model.prossimoRuolo())));

				List<Giocatore> l = new ArrayList<>(this.model.giocatoreSuggerito("P", salaryCap));
				if(this.salaryCap>=20000) {
				for(int i=0; i<3; i++) {
					txtGiocatoreSuggerito.appendText(l.get(i).getNomeComune()+" overall: "+l.get(i).getOverall()+" stipendio: "+l.get(i).getStipendio()+"\n");

				}
    		}
    		}
    		else {
        		btnComponiSquadra.setDisable(false);

    		}
    	}
    	
    	
    	
    	
    }
    
    
    int cont = 0;
    @FXML
    void handleScegliGiocatore(ActionEvent event) {
    	lblErrore2.setText("");
    	txtGiocatoreSuggerito.clear();
    	Giocatore g = tblvgiocatori.getSelectionModel().getSelectedItem();
    	 	
    	if(g != null) {
    		if(this.model.giocatoreScelto(g)) {
    			    			
    			//table view giocatori mia squadra
    			tblvgiocatoriSquadra.setItems(FXCollections.observableArrayList(this.model.getGiocatoriScelti()));
    			
    			
    			//label numero giocatori scelti
    			lblNumGiocatori.setText(this.model.getNumPortieri()+"P -- "+this.model.getNumDifensori()+"D -- "+this.model.getNumCentrocampisti()+"C -- "+this.model.getNumAttaccanti()+"A");
    			lblBudgetRimasto.setText(this.model.getBudgetRimasto()+" €");

    			if(!btnRimuoviGiocatore.isDisabled()) {
    				List<Giocatore> giocatoriSceltiAltreSquadre = new ArrayList<>(this.model.giocatoriAltreSquadre(g));
        			
    			    //solo output ------------------------------------------------------------------------------			
    							if(giocatoriSceltiAltreSquadre.get(0).getRuolo().equals("P")) {
    								cont++;
    								txtGiocatoriSceltiAltreSquadre.appendText("Turno "+cont+" PORTIERI\n\n");
    							}
    							else if(giocatoriSceltiAltreSquadre.get(0).getRuolo().equals("D")) {
    								cont++;
    								txtGiocatoriSceltiAltreSquadre.appendText("\n\nTurno "+cont+" DIFENSORI\n\n");
    							}
    							else if(giocatoriSceltiAltreSquadre.get(0).getRuolo().equals("C")) {
    								cont++;
    								txtGiocatoriSceltiAltreSquadre.appendText("\n\nTurno "+cont+" CENTROCAMPISTI\n\n");
    							}
    							else {
    								cont++;
    								txtGiocatoriSceltiAltreSquadre.appendText("\n\nTurno "+cont+" ATTACCANTI\n\n");
    							}

    				//-------------------------------------------------------------------------------------------------			
    							for(Giocatore gg : giocatoriSceltiAltreSquadre) {
    								txtGiocatoriSceltiAltreSquadre.appendText(gg.getSquadraSuperlega().getNomeSqaudra()+" ha scelto:\n"+gg.getRuolo()+") "+gg.getNomeComune()+" overall: "+gg.getOverall()+" stipendio: "+gg.getStipendio()+"\n\n");
    							}
    			}else {
    				btnRimuoviGiocatore.setDisable(false);
    			}
    			
    			
    			String proxRuolo = this.model.prossimoRuolo();
    			
    			
    			
    			if(proxRuolo != null) {
    				
       				tblvgiocatori.setItems(FXCollections.observableArrayList(this.model.getAllGiocatoriByRuolo(proxRuolo)));
    				List<Giocatore> l = new ArrayList<>(this.model.giocatoreSuggerito(proxRuolo, this.model.getBudgetRimasto()));
    				for(int i=0; i<3; i++) {
    					txtGiocatoreSuggerito.appendText(l.get(i).getNomeComune()+" overall: "+l.get(i).getOverall()+" stipendio: "+l.get(i).getStipendio()+"\n");

    				}
					


    			}else {
    		/*		this.btnRimuoviGiocatore.setDisable(true);
    				this.model.creaArchi();
    				btnScegliGiocatore.setDisable(true);
    				btnSimula.setDisable(false);
    				lblIntesaTotale.setText(this.model.getSquadraScelta().intesaTotale()+"");
    				this.model.getSquadre().add(this.model.getSquadraScelta());
    				
    				Collections.sort(this.model.getSquadre(), new Comparator<Squadra>() {

						@Override
						public int compare(Squadra o1, Squadra o2) {
							return o1.getNomeSqaudra().compareTo(o2.getNomeSqaudra());
						}
    					
    				}); */
    				btnScegliGiocatore.setDisable(true);
    				btnSimula.setDisable(false);
    				lblIntesaTotale.setText(this.model.getSquadraScelta().intesaTotale()+"");
        			lblErrore2.setText("Hai completato la tua squadra!");
    			}
    			
    			
    			
    	    		
    		}else {
    			
    			if(this.model.getBudgetRimasto()<62500) {
    				lblErrore2.setText("ERRORE, hai terminato il budget prima di completare la tua squadra");

    			}else {
    				lblErrore2.setText("ERRORE, budget insufficiente, scegli un altro giocatore");

    			}
    			
    		}
    	}
    }
   
    
    @FXML
    void handleVisualizzaStatGiocSelezionato(ActionEvent event) throws IOException {
    	
    	Model mod = new Model();
    	Giocatore g = tblvgiocatori.getSelectionModel().getSelectedItem();
    	
    	if(g != null) {
	    		
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/statController.fxml"));
	    	Parent root = loader.load();
	    	StatisticheController controller= loader.getController();
	    	
	    	Scene scene = new Scene(root);
	    	scene.getStylesheets().add("/styles/Styles.css");
	    	
	    	controller.setModel(mod, g);
	    	
	    	Stage s = new Stage();
	    	s.setTitle("Statistiche");
	    	s.setScene(scene);
	    	s.setX(+565.0);
	    	s.setY(+250.0);
	    	s.centerOnScreen();
	    	s.show(); 
    	
    	}   	
    }

    @FXML
    void handleRimuoviGiocatore(ActionEvent event) {
    	Giocatore g = tblvgiocatoriSquadra.getSelectionModel().getSelectedItem();
    	
    	if(g != null) {
    		this.model.rimuoviGiocatore(g);
			tblvgiocatoriSquadra.setItems(FXCollections.observableArrayList(this.model.getGiocatoriScelti()));
			String proxRuolo = this.model.prossimoRuolo();
			tblvgiocatori.setItems(FXCollections.observableArrayList(this.model.getAllGiocatoriByRuolo(proxRuolo)));
			lblNumGiocatori.setText(this.model.getNumPortieri()+"P -- "+this.model.getNumDifensori()+"D -- "+this.model.getNumCentrocampisti()+"C -- "+this.model.getNumAttaccanti()+"A");
			btnScegliGiocatore.setDisable(false);
			this.model.setBudgetRimasto(this.model.getBudgetRimasto()+g.getStipendio());
			lblBudgetRimasto.setText(this.model.getBudgetRimasto()+" €");
			lblErrore2.setText("");
			btnRimuoviGiocatore.setDisable(true);
			
    	}
    }
    
    
    @FXML
    void handleSimula(ActionEvent event) throws IOException {
    	this.model.creaArchi();
		
		this.model.getSquadre().add(this.model.getSquadraScelta());
		
		Collections.sort(this.model.getSquadre(), new Comparator<Squadra>() {

			@Override
			public int compare(Squadra o1, Squadra o2) {
				return o1.getNomeSqaudra().compareTo(o2.getNomeSqaudra());
			}
			
		});
    	
    		Model mod = new Model();
    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/elencoGiocatoriController.fxml"));
	    	Parent root = loader.load();
	    	ElencoGiocatoriController controller= loader.getController();
	    	
	    	Scene scene = new Scene(root);
	    	scene.getStylesheets().add("/styles/Styles.css");
	    	
	    	controller.setModel(mod, this.model.getSquadraScelta(), this.model.getSquadre());
	    	
	    	Stage s = new Stage();
	    	s.setTitle("Elenco dei giocatori per ogni squadra");
	    	s.setScene(scene);
	    	s.setFullScreen(true);
	        s.setFullScreenExitHint("");
	    	s.show(); 
    	
    	
    }

    
    
    @FXML
    void handleReset(ActionEvent event) {
    	tblvgiocatori.getItems().clear();
    	tblvgiocatoriSquadra.getItems().clear();
    	this.model.reset();
    	cmbsquadra.getItems().clear();
    	cmbModulo.getItems().clear();
    	cmbsquadra.getItems().addAll(this.model.getSquadre());
		cmbModulo.getItems().add("442");
		cmbModulo.getItems().add("433");
		cmbModulo.getItems().add("352");
		cmbModulo.getItems().add("343");
		btnComponiSquadra.setDisable(false);
    	txtsalarycap.clear();
    	lblBudgetRimasto.setText("");
    	lblNumGiocatori.setText("");
    	lblIntesaTotale.setText("");
    	txtGiocatoreSuggerito.clear();
    	txtGiocatoriSceltiAltreSquadre.clear();
    	lblErrore2.setText("");
  
    	File f7 = new File("immagini/inter.png");
		immInter.setImage(new Image(f7.toURI().toString()));
		this.immagini.add(immInter);
    	for(ImageView i : this.immagini) {
			i.setVisible(true);
		}
    
    }

    @FXML
    void initialize() {
        assert btnComponiSquadra != null : "fx:id=\"btnComponiSquadra\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRimuoviGiocatore != null : "fx:id=\"btnRimuoviGiocatore\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnScegliGiocatore != null : "fx:id=\"btnScegliGiocatore\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnVisualizzaStatGiocSelezionato != null : "fx:id=\"btnVisualizzaStatGiocSelezionato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clNome != null : "fx:id=\"clNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clOv != null : "fx:id=\"clOv\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clRuolo != null : "fx:id=\"clRuolo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clStip != null : "fx:id=\"clStip\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clVal != null : "fx:id=\"clVal\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbModulo != null : "fx:id=\"cmbModulo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbsquadra != null : "fx:id=\"cmbsquadra\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colNome != null : "fx:id=\"colNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colOverall != null : "fx:id=\"colOverall\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colRuolo != null : "fx:id=\"colRuolo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colStipendio != null : "fx:id=\"colStipendio\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immArsenal != null : "fx:id=\"immArsenal\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immAtletico != null : "fx:id=\"immAtletico\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immBarca != null : "fx:id=\"immBarca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immBayern != null : "fx:id=\"immBayern\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immChelsea != null : "fx:id=\"immChelsea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immCity != null : "fx:id=\"immCity\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immInter != null : "fx:id=\"immInter\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immJuve != null : "fx:id=\"immJuve\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immLiverpool != null : "fx:id=\"immLiverpool\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immMilan != null : "fx:id=\"immMilan\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immTott != null : "fx:id=\"immTott\" was not injected: check your FXML file 'Scene.fxml'.";
        assert immUnited != null : "fx:id=\"immUnited\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lbl3 != null : "fx:id=\"lbl3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblBudgetRimanente != null : "fx:id=\"lblBudgetRimanente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblBudgetRimasto != null : "fx:id=\"lblBudgetRimasto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrore1 != null : "fx:id=\"lblErrore1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrore2 != null : "fx:id=\"lblErrore2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblGiocatoreSuggerito != null : "fx:id=\"lblGiocatoreSuggerito\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblInt != null : "fx:id=\"lblInt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblIntesaTotale != null : "fx:id=\"lblIntesaTotale\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblNumGiocatori != null : "fx:id=\"lblNumGiocatori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tblvgiocatori != null : "fx:id=\"tblvgiocatori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tblvgiocatoriSquadra != null : "fx:id=\"tblvgiocatoriSquadra\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGiocatoreSuggerito != null : "fx:id=\"txtGiocatoreSuggerito\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtGiocatoriSceltiAltreSquadre != null : "fx:id=\"txtGiocatoriSceltiAltreSquadre\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtsalarycap != null : "fx:id=\"txtsalarycap\" was not injected: check your FXML file 'Scene.fxml'.";

    

        colNome.setCellValueFactory(new PropertyValueFactory<Giocatore, String>("nomeComune"));
        colRuolo.setCellValueFactory(new PropertyValueFactory<Giocatore, String>("ruolo"));
        colOverall.setCellValueFactory(new PropertyValueFactory<Giocatore, Integer>("overall"));
        colStipendio.setCellValueFactory(new PropertyValueFactory<Giocatore, Integer>("stipendio"));
        
        clNome.setCellValueFactory(new PropertyValueFactory<Giocatore, String>("nomeComune"));
        clRuolo.setCellValueFactory(new PropertyValueFactory<Giocatore, String>("ruolo"));
        clOv.setCellValueFactory(new PropertyValueFactory<Giocatore, Integer>("overall"));
        clStip.setCellValueFactory(new PropertyValueFactory<Giocatore, Integer>("stipendio"));
        clVal.setCellValueFactory(new PropertyValueFactory<Giocatore, Integer>("valoreGiocatoreEuro"));

    }

	public void setModel(Model model) {
		this.model = model;
		this.immagini = new ArrayList<>();
		cmbsquadra.getItems().addAll(this.model.getSquadre());
		Collections.shuffle(this.model.getSquadre());//la prima volta mischio le squadre con un ordine casuale

		
		cmbModulo.getItems().add("442");
		cmbModulo.getItems().add("433");
		cmbModulo.getItems().add("352");
		cmbModulo.getItems().add("343");
		
		btnReset.setDisable(true);
		
		File f1 = new File("immagini/milan.png");
		immMilan.setImage(new Image(f1.toURI().toString()));
		this.immagini.add(immMilan);
		
		File f2 = new File("immagini/arsenal.png");
		immArsenal.setImage(new Image(f2.toURI().toString()));
		this.immagini.add(immArsenal);

		File f4 = new File("immagini/atletico.png");
		immAtletico.setImage(new Image(f4.toURI().toString()));
		this.immagini.add(immAtletico);
		
		File f3 = new File("immagini/chelsea.png");
		immChelsea.setImage(new Image(f3.toURI().toString()));
		this.immagini.add(immChelsea);

		File f5 = new File("immagini/barca.png");
		immBarca.setImage(new Image(f5.toURI().toString()));
		this.immagini.add(immBarca);

		File f6 = new File("immagini/bayern.png");
		immBayern.setImage(new Image(f6.toURI().toString()));
		this.immagini.add(immBayern);

		File f7 = new File("immagini/inter.png");
		immInter.setImage(new Image(f7.toURI().toString()));
		this.immagini.add(immInter);

		File f8 = new File("immagini/juve.png");
		immJuve.setImage(new Image(f8.toURI().toString()));
		this.immagini.add(immJuve);

		File f9 = new File("immagini/liverpool.png");
		immLiverpool.setImage(new Image(f9.toURI().toString()));
		this.immagini.add(immLiverpool);

		File f10 = new File("immagini/city.png");
		immCity.setImage(new Image(f10.toURI().toString()));
		this.immagini.add(immCity);

		File f11 = new File("immagini/united.png");
		immUnited.setImage(new Image(f11.toURI().toString()));
		this.immagini.add(immUnited);

		File f12 = new File("immagini/tottenham.png");
		immTott.setImage(new Image(f12.toURI().toString()));
		this.immagini.add(immTott);

		
		
		

	}
    
    

}
