package it.polito.tdp.tesiSuperlega.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import it.polito.tdp.tesiSuperlega.db.fifaDAO;

public class Model {

	private fifaDAO dao;
	private Map<Integer, Giocatore> giocatoriNoEdit;
	private Map<Integer, Giocatore> giocatori;
	private List<Giocatore> giocatoriScelti;
	private List<Squadra> squadre;
	private Squadra squadraScelta;
	private int budgetRimasto;
	private List<Giocatore> portieri;
	private List<Giocatore> difensori;
	private List<Giocatore> centrocampisti;
	private List<Giocatore> attaccanti;
	private int numPortieri;
	private int numDifensori;
	private int numCentrocampisti;
	private int numAttaccanti;
	private int modDifesa;
	private int modCentrocampo;
	private int modAttacco;
	private int passi;
    private Simulatore sim;
	
	public Model() {
		this.dao = new fifaDAO();
		this.giocatoriNoEdit = new HashMap<Integer, Giocatore>();
		this.dao.getAllGiocatori(giocatoriNoEdit);
		this.giocatori = new HashMap<Integer, Giocatore>(giocatoriNoEdit);
		this.squadre = new ArrayList<Squadra>(this.dao.getAllSquadre());
		this.giocatoriScelti = new ArrayList<>();
		this.numPortieri = 1;
		this.portieri = new ArrayList<>(this.ottieniListaRuoli("P"));
		this.difensori = new ArrayList<>(this.ottieniListaRuoli("D"));
		this.centrocampisti = new ArrayList<>(this.ottieniListaRuoli("C"));
		this.attaccanti = new ArrayList<>(this.ottieniListaRuoli("A"));
		this.passi=-1;
		this.sim = new Simulatore();

	}

	/*public Map<Integer, Giocatore> getGiocatori() {
		return giocatori;
	}*/

	public List<Squadra> getSquadre() {
		return squadre;
	}
	
	
	
	/*public List<Giocatore> getPortieri(){
		return this.dao.getPortieri();
	}
	
	public List<Giocatore> getDifensori(){
		return this.dao.getDifensori();
	}

	public List<Giocatore> getCentrocampisti(){
		return this.dao.getCentrocampisti();
	}

	public List<Giocatore> getAttaccanti(){
		return this.dao.getAttaccanti();
	} */

	
	
	public int getNumDifensori() {
		return numDifensori;
	}

	public int getNumPortieri() {
		return numPortieri;
	}

	public int getNumCentrocampisti() {
		return numCentrocampisti;
	}

	public int getNumAttaccanti() {
		return numAttaccanti;
	}

	public void salaryCapScelto(int salaryCap) {
		this.budgetRimasto = salaryCap;
		this.squadraScelta.setBudgetRimasto(salaryCap);
		for(Squadra s : this.squadre) {
			s.setBudgetRimasto(salaryCap);
		}
	}
	
	public int getBudgetRimasto() {
		return budgetRimasto;
	}
	
	
	public void setBudgetRimasto(int budgetRimasto) {
		this.budgetRimasto = budgetRimasto;
	}

	public void squadraScelta(Squadra s) {
		this.squadraScelta = s;
		this.squadre.remove(s); //lista delle squadre senza la squadra scelta dall'utente
	}

	public Squadra getSquadraScelta() {
		return squadraScelta;
	}

	public List<Giocatore> getGiocatoriScelti() {
		return giocatoriScelti;
	}

	public void moduloScelto(String modulo) {
		
		if(modulo.equals("442")) {
			this.numDifensori = 4;
			this.modDifesa = 4;
			this.numCentrocampisti = 4;
			this.modCentrocampo = 4;
			this.numAttaccanti = 2;
			this.modAttacco = 2;
		}
		else if(modulo.equals("433")) {
			this.numDifensori = 4;
			this.modDifesa = 4;
			this.numCentrocampisti = 3;
			this.modCentrocampo = 3;
			this.numAttaccanti = 3;
			this.modAttacco = 3;
		}
		else if(modulo.equals("352")) {
			this.numDifensori = 3;
			this.modDifesa = 3;
			this.numCentrocampisti = 5;
			this.modCentrocampo = 5;
			this.numAttaccanti = 2;
			this.modAttacco = 2;
		}
		else {
			this.numDifensori = 3;
			this.modDifesa = 3;
			this.numCentrocampisti = 4;
			this.modCentrocampo = 4;
			this.numAttaccanti = 3;
			this.modAttacco = 3;
		}
		
	}
	
	public List<Giocatore> getAllGiocatoriByRuolo(String ruolo){
		if(ruolo.equals("P")) {
			this.ordinaLista(portieri);
			return this.portieri;
		}
		else if(ruolo.equals("D")) {
			this.ordinaLista(difensori);
			return this.difensori;
		}
		else if(ruolo.equals("C")) {
			this.ordinaLista(centrocampisti);
			return this.centrocampisti;
		}
		else {
			this.ordinaLista(attaccanti);
			return this.attaccanti;
	}
}
	
	
	public List<Giocatore> giocatoreSuggerito(String ruolo, double budget) {  
		List<Giocatore> oro = new ArrayList<>();
		List<Giocatore> argento = new ArrayList<>();
		List<Giocatore> bronzo = new ArrayList<>();
		List<Giocatore> platino = new ArrayList<>();
		List<Giocatore> result = new ArrayList<>();
		
		
			for(Giocatore g : this.giocatori.values()) {
				if(g.getRuolo().equals(ruolo) && g.getStipendio()< budget) {
					
					if(g.getOverall()>=88) {
						oro.add(g);
						
					}
					else if(g.getOverall()>=82) {
						argento.add(g);
						
					}
					else if(g.getOverall()>=74){
						bronzo.add(g);
						
					}else {
						platino.add(g);
					}
					
				}

			
		}
			
			ordinaPS(oro);
			ordinaPS(argento);
			ordinaPS(bronzo);
			ordinaPS(platino);
			
			result.addAll(oro);
			result.addAll(argento);
			result.addAll(bronzo);
			result.addAll(platino);
			
		return result;
	}


	private void ordinaPS(List<Giocatore> l) {
		
		Collections.sort(l, new Comparator<Giocatore>() {

			@Override
			public int compare(Giocatore o1, Giocatore o2) {
				
				double v1 = (double)o1.getOverall()/o1.getStipendio();
				double v2 = (double)o2.getOverall()/o2.getStipendio();
				
				if(v1>v2)
					return -1;
				else
					return 1;
			
			}
			
		});
		
	}

	public boolean giocatoreScelto(Giocatore g) {
		boolean scelta = false;
		if(this.giocatoriScelti.isEmpty()) {
			//creo il grafo
			this.squadraScelta.creaGrafo();
			for(Squadra s : this.squadre) {
				s.creaGrafo();;
			}
		}
		if(this.budgetRimasto - g.getStipendio() >= 0) {
			String ruolo = g.getRuolo();
			this.giocatoriScelti.add(g);
			this.squadraScelta.setTotAttacco(this.squadraScelta.getTotAttacco()+g.getAttacco().getTotAttacco());
			this.squadraScelta.setTotDifesa(this.squadraScelta.getTotDifesa()+g.getDifesa().getTotDifesa());
			g.setSquadraSuperlega(squadraScelta);
			this.budgetRimasto -= g.getStipendio();
			this.squadraScelta.aggiungiVertici(g);
			//vertici aggiunti solo per mia squadra
			scelta = true;
			squadraScelta.getGiocatoriDellaSquadra().add(g);
			if(ruolo.equals("P")) {
				this.numPortieri--;
				this.portieri.remove(g);
				this.giocatori.remove(g.getFifaId());
			}
			else if(ruolo.equals("D")) {
				this.numDifensori--;
				this.difensori.remove(g);
				this.giocatori.remove(g.getFifaId());
			}
			else if(ruolo.equals("C")) {
				this.numCentrocampisti--;
				this.centrocampisti.remove(g);
				this.giocatori.remove(g.getFifaId());
			}
			else {
				this.numAttaccanti--;
				this.attaccanti.remove(g);
				this.giocatori.remove(g.getFifaId());
			}
		}
		return scelta;	
	}

	public String prossimoRuolo() {
		
		if(this.numPortieri>0) {
			return "P";
		}
		else if(this.numDifensori>0) {
			return "D";
		}
		else if(this.numCentrocampisti>0) {
			return "C";
		}
		else if(this.numAttaccanti>0) {
			return "A";
		}
		else
			return null;
	}

	public List<Giocatore> giocatoriAltreSquadre(Giocatore g) {
		String ruolo = g.getRuolo();
		List<Giocatore> result = new ArrayList<>();
		this.passi++;
		
		Collections.reverse(this.squadre); //chi ha scelto per primo, secondo,..., ultimo sceglierà per ultimo, pernultimo, ..., primo al turno successivo
		
		for(Squadra s : this.squadre) {
			
			Giocatore daAssegnare = trovaGiocatoreDaAssegnare(ruolo, s);
			if(daAssegnare == null)
				return null;
			
			s.decrementaBudget(daAssegnare.getStipendio());
			s.setTotAttacco(s.getTotAttacco()+daAssegnare.getAttacco().getTotAttacco());
			s.setTotDifesa(s.getTotDifesa()+daAssegnare.getDifesa().getTotDifesa());
			result.add(daAssegnare);
			s.getGiocatoriDellaSquadra().add(daAssegnare);
			s.aggiungiVertici(daAssegnare);
			daAssegnare.setSquadraSuperlega(s);
			this.giocatori.remove(daAssegnare.getFifaId());
			if(ruolo.equals("P")) {
				this.portieri.remove(daAssegnare);
				s.setBudgetPortiere(s.getBudgetPortiere() - daAssegnare.getStipendio());
				//se ho finito con i portieri, assegno il budget rimanente al ruolo successivo
				if(numPortieri==0) {
					s.setBudgetDifesa(s.getBudgetDifesa()+s.getBudgetPortiere());
					s.setBudgetPortiere(0);
				}	
			}
			else if(ruolo.equals("D")) {
				this.difensori.remove(daAssegnare);
				s.setBudgetDifesa(s.getBudgetDifesa() - daAssegnare.getStipendio());
				
				if(numDifensori==0) {
					s.setBudgetCentrocampo(s.getBudgetCentrocampo()+s.getBudgetDifesa());
					s.setBudgetDifesa(0);		
				}
			}
			else if(ruolo.equals("C")) {
				this.centrocampisti.remove(daAssegnare);
				s.setBudgetCentrocampo(s.getBudgetCentrocampo() - daAssegnare.getStipendio());
				
				if(numCentrocampisti==0) {
					s.setBudgetAttacco(s.getBudgetAttacco()+s.getBudgetCentrocampo());
					s.setBudgetCentrocampo(0);
				}
			}
			else {
				this.attaccanti.remove(daAssegnare);
				s.setBudgetAttacco(s.getBudgetAttacco() - daAssegnare.getStipendio());
			}
		}
		
		
		return result;
	}
	

	private Giocatore trovaGiocatoreDaAssegnare(String ruolo, Squadra squadra) {
		Giocatore g = null;
		boolean giocOk = false;
		int cont = 0;
		List<Giocatore> listaGiocatoriPerSquadre = new ArrayList<>(this.getAllGiocatoriByRuolo(ruolo));
		
		while(!giocOk) {
	
			if(cont<listaGiocatoriPerSquadre.size()) {
				g = listaGiocatoriPerSquadre.get(cont);
				cont++;
			}else {
					g = giocatoreCasuale(listaGiocatoriPerSquadre);
					
			}
				
			giocOk = controlliGiocatore(g, squadra);
		}
		
		
		return g;
	}
	
	

	private boolean controlliGiocatore(Giocatore g, Squadra squadra) {	
		String ruolo = g.getRuolo();
		
		if(ruolo.equals("P")) {
			//un portiere non può costare più del 20% del budget totale
			if(g.getStipendio()> perRuoloModulo(ruolo)*squadra.getBudgetPortiere()) {
			
			return false;
			}
			else 
				return true;
		}
		else if(ruolo.equals("D")){
			//un difensore non può costare più del 30% del budget totale
			if(g.getStipendio()>perRuoloModulo(ruolo)*squadra.getBudgetDifesa()) {
			
				return false;
			}
			else 
				return true;
			
		}
		else if(ruolo.equals("C")){
			//un centrocampista non può costare più del 70% del budget totale
			if(g.getStipendio()>perRuoloModulo(ruolo)*squadra.getBudgetCentrocampo()) {
				return false;
			}
			else 
				return true;
		}
		else {
			//un attaccante può avere lo stipendio che vuole
			if(g.getStipendio()>perRuoloModulo(ruolo)*squadra.getBudgetAttacco()) {
				return false;
			}
			else 
				return true;
			
		}
	}
	
	private double perRuoloModulo(String ruolo) {
		
		if(ruolo.equals("P"))
			return 1;
		else if(ruolo.equals("D")) {
			
			if(this.modDifesa==3) {
				
				if(this.numDifensori==2) { //scelta del primo difensore --> posso sprendere di più
					return 0.5;
				}else
					return 0.25;            //per gli altri due spendo di meno
			}
			else { //difesa a 4
				
				if(this.numDifensori == 3) { //per il primo difensore posso spendere fino al 40% del budget
					return 0.4;
				}else
					return 0.2;				//per gli altri 3 solo il 20% a testa
			}
		}
		else if(ruolo.equals("C")) {
			
			if(this.modCentrocampo == 3) {
				if(this.numCentrocampisti==2) //come per difesa a 3
					return 0.5;
				else
					return 0.25;
				
			}
			else if(this.modCentrocampo == 4) { //come per difesa a 4
				if(this.numCentrocampisti==3) { 
					return 0.4;
				}else
					return 0.2;
				
			}
			else {//centrocampo a 5
				if(this.numCentrocampisti==4) {
					return 0.4;
				}else
					return 0.15;
				
			}
		
		}
		else{
			
			if(this.modAttacco==2) {
				if(this.numAttaccanti==1)
					return 0.6;
				else 
					return 0.4;
			}
			else {
				if(this.numAttaccanti==2)
					return 0.50;
				else
					return 0.25;
			}
		}
	}

	private Giocatore giocatoreCasuale(List<Giocatore> possibili) {
		Giocatore g = null;
		int totGiocatori = possibili.size();
		double prob = Math.random()*totGiocatori;
		
		g = possibili.get((int) prob);
		
		return g;
	}

	

	public void creaArchi() {  //creo intesa tra tutti i giocatori
		
		this.squadraScelta.creaArchi();
		
		for(Squadra s : this.squadre) {
			s.creaArchi();
		}	
	}

	public void rimuoviGiocatore(Giocatore g) {
		this.giocatoriScelti.remove(g);
		String ruolo = g.getRuolo();
		
		if(ruolo.equals("P")) {
			this.numPortieri++;
			this.portieri.add(g);
			this.ordinaLista(this.portieri);
			this.giocatori.put(g.getFifaId(), g);
		}
		else if(ruolo.equals("D")) {
			this.numDifensori++;
			this.difensori.add(g);
			this.ordinaLista(this.difensori);
			this.giocatori.put(g.getFifaId(), g);
		}
		else if(ruolo.equals("C")) {
			this.numCentrocampisti++;
			this.centrocampisti.add(g);
			this.ordinaLista(this.centrocampisti);
			this.giocatori.put(g.getFifaId(), g);
		}
		else {
			this.numAttaccanti++;
			this.attaccanti.add(g);
			this.ordinaLista(this.attaccanti);
			this.giocatori.put(g.getFifaId(), g);
		}
		
		this.squadraScelta.getGrafo().removeVertex(g);
		this.squadraScelta.getGiocatoriDellaSquadra().remove(g);
		
	}
	

	private void ordinaLista(List<Giocatore> l) {
		Collections.sort(l, new Comparator<Giocatore>() {

			@Override
			public int compare(Giocatore o1, Giocatore o2) {
				return o2.getOverall()-o1.getOverall();
			}
			
		});
		
	}

	public void reset() {
		
		this.squadraScelta.resetGrafo();
		this.giocatori.clear();
		this.dao.getAllGiocatori(giocatori);
		this.giocatoriScelti.clear();
		this.squadre.clear();
		this.squadre = this.dao.getAllSquadre();
		this.squadraScelta = null;
		this.portieri.clear();
		this.difensori.clear();
		this.centrocampisti.clear();
		this.attaccanti.clear();
		this.portieri = new ArrayList<>(this.ottieniListaRuoli("P"));
		this.difensori = new ArrayList<>(this.ottieniListaRuoli("D"));
		this.centrocampisti = new ArrayList<>(this.ottieniListaRuoli("C"));
		this.attaccanti = new ArrayList<>(this.ottieniListaRuoli("A"));
		
	}

	private List<Giocatore> ottieniListaRuoli(String ruolo) {
		List<Giocatore> result = new ArrayList<>();
		for(Giocatore g : this.giocatoriNoEdit.values()) {
			if(g.getRuolo().equals(ruolo)) {
				result.add(g);
			}
		}
		return result;
	}

	public Statistiche simula(Squadra casa, Squadra trasferta) {
		sim.init(casa, trasferta);
		sim.run();
		
		return sim.getStat();
	}

	
	

	

}
