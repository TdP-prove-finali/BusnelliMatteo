package it.polito.tdp.tesiSuperlega.model;

public class MinEvento {

	private int minuto;
	private String evento;
	private Giocatore giocatore;
	
	public MinEvento(int minuto, String evento, Giocatore giocatore) {
		super();
		this.minuto = minuto;
		this.evento = evento;
		this.giocatore = giocatore;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	
	
	
	
	
	
	
}
