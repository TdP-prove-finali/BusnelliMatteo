package it.polito.tdp.tesiSuperlega.model;

import java.util.ArrayList;
import java.util.List;
public class Statistiche {

	
	private Squadra casa;
	private Squadra trasferta;
	private int golCasa;
	private int golTrasferta;
	private List<MinEvento> eventiPartita = new ArrayList<>();
	private boolean vittoriaRigoriCasa = false;
	private boolean vittoriaRigoriTrasferta = false;
	String vittoria;

	public Statistiche(Squadra casa, Squadra trasferta) {
		super();
		this.casa = casa;
		this.trasferta = trasferta;
	}
	public Squadra getCasa() {
		return casa;
	}
	public void setCasa(Squadra casa) {
		this.casa = casa;
	}
	public Squadra getTrasferta() {
		return trasferta;
	}
	public void setTrasferta(Squadra trasferta) {
		this.trasferta = trasferta;
	}
	public int getGolCasa() {
		return golCasa;
	}
	public void setGolCasa(int golCasa) {
		this.golCasa = golCasa;
	}
	public int getGolTrasferta() {
		return golTrasferta;
	}
	public void setGolTrasferta(int golTrasferta) {
		this.golTrasferta = golTrasferta;
	}
	public List<MinEvento> getEventiPartita() {
		return eventiPartita;
	}
	public void setEventiPartita(List<MinEvento> eventiPartita) {
		this.eventiPartita = eventiPartita;
	}
	public void aggiungiEvento(MinEvento minevento) {
		this.eventiPartita.add(minevento);
		
	}
	public boolean isVittoriaRigoriCasa() {
		return vittoriaRigoriCasa;
	}
	public void setVittoriaRigoriCasa(boolean rigori) {
		this.vittoriaRigoriCasa = rigori;
	}
	public boolean isVittoriaRigoriTrasferta() {
		return vittoriaRigoriTrasferta;
	}
	public void setVittoriaRigoriTrasferta(boolean vittoriaRigoriTrasferta) {
		this.vittoriaRigoriTrasferta = vittoriaRigoriTrasferta;
	}
	public String getVittoria() {
		return vittoria;
	}
	public void setVittoria(String vittoria) {
		this.vittoria = vittoria;
	}
	@Override
	public String toString() {
		String s="";
		s+= this.getCasa().getNomeSqaudra().toUpperCase()+" - "+this.getTrasferta().getNomeSqaudra().toUpperCase()+" "+this.getGolCasa()+" - "+this.getGolTrasferta()+"\nEventi:\n";
		for(MinEvento m : this.getEventiPartita()) {
			s+=+m.getMinuto()+"' "+m.getEvento()+" "+m.getGiocatore().getNomeComune()+" "+m.getGiocatore().getSquadraSuperlega()+"\n";
		}
		s+="\n\n";
		return s;
	}
	
	
	
	
}