package it.polito.tdp.tesiSuperlega.model;

public class Difesa {
	
	private int capacitadifesa;
	private int salto; 
	private int forza; 
	private int bilanciamento; 
	private int aggressivita; 
	private int mentalitaAggressiva; 
	private int mentalitaIntercetto; 
	private int interesseDifensivo; 
	private int takle; 
	private int schivolamentoDifensivo; 
	private int tuffoPortiere; 
 	private int maniPortiere; 
	private int calcioPortiere; 
	private int posizionamentoPortiere; 
	private int riflessiPortiere; 
	private int velocitaPortiere; 
	private int totDifesa;
	
	
	public Difesa(int capacitadifesa, int salto, int forza, int bilanciamento, int aggressivita,
			int mentalitaAggressiva, int mentalitaIntercetto, int interesseDifensivo, int takle,
			int schivolamentoDifensivo, int tuffoPortiere, int maniPortiere, int calcioPortiere,
			int posizionamentoPortiere, int riflessiPortiere, int velocitaPortiere) {
		super();
		this.capacitadifesa = capacitadifesa;
		this.salto = salto;
		this.forza = forza;
		this.bilanciamento = bilanciamento;
		this.aggressivita = aggressivita;
		this.mentalitaAggressiva = mentalitaAggressiva;
		this.mentalitaIntercetto = mentalitaIntercetto;
		this.interesseDifensivo = interesseDifensivo;
		this.takle = takle;
		this.schivolamentoDifensivo = schivolamentoDifensivo;
		this.tuffoPortiere = tuffoPortiere;
		this.maniPortiere = maniPortiere;
		this.calcioPortiere = calcioPortiere;
		this.posizionamentoPortiere = posizionamentoPortiere;
		this.riflessiPortiere = riflessiPortiere;
		this.velocitaPortiere = velocitaPortiere;
		this.totDifesa = this.capacitadifesa + this.salto + this.forza + this.bilanciamento + this.aggressivita + this.mentalitaAggressiva+
				this.mentalitaIntercetto + this.interesseDifensivo + this.takle + this.schivolamentoDifensivo + this.tuffoPortiere +
				this.maniPortiere + this.calcioPortiere + this.posizionamentoPortiere + this.riflessiPortiere + this.velocitaPortiere;
	}


	public int getCapacitadifesa() {
		return capacitadifesa;
	}


	public void setCapacitadifesa(int capacitadifesa) {
		this.capacitadifesa = capacitadifesa;
	}


	public int getSalto() {
		return salto;
	}


	public void setSalto(int salto) {
		this.salto = salto;
	}


	public int getForza() {
		return forza;
	}


	public void setForza(int forza) {
		this.forza = forza;
	}


	public int getBilanciamento() {
		return bilanciamento;
	}


	public void setBilanciamento(int bilanciamento) {
		this.bilanciamento = bilanciamento;
	}


	public int getAggressivita() {
		return aggressivita;
	}


	public void setAggressivita(int aggressivita) {
		this.aggressivita = aggressivita;
	}


	public int getMentalitaAggressiva() {
		return mentalitaAggressiva;
	}


	public void setMentalitaAggressiva(int mentalitaAggressiva) {
		this.mentalitaAggressiva = mentalitaAggressiva;
	}


	public int getMentalitaIntercetto() {
		return mentalitaIntercetto;
	}


	public void setMentalitaIntercetto(int mentalitaIntercetto) {
		this.mentalitaIntercetto = mentalitaIntercetto;
	}


	public int getInteresseDifensivo() {
		return interesseDifensivo;
	}


	public void setInteresseDifensivo(int interesseDifensivo) {
		this.interesseDifensivo = interesseDifensivo;
	}


	public int getTakle() {
		return takle;
	}


	public void setTakle(int takle) {
		this.takle = takle;
	}


	public int getSchivolamentoDifensivo() {
		return schivolamentoDifensivo;
	}


	public void setSchivolamentoDifensivo(int schivolamentoDifensivo) {
		this.schivolamentoDifensivo = schivolamentoDifensivo;
	}


	public int getTuttoPortiere() {
		return tuffoPortiere;
	}


	public void setTuttoPortiere(int tuffoPortiere) {
		this.tuffoPortiere = tuffoPortiere;
	}


	public int getManiPortiere() {
		return maniPortiere;
	}


	public void setManiPortiere(int maniPortiere) {
		this.maniPortiere = maniPortiere;
	}


	public int getCalcioPortiere() {
		return calcioPortiere;
	}


	public void setCalcioPortiere(int calcioPortiere) {
		this.calcioPortiere = calcioPortiere;
	}


	public int getPosizionamentoPortiere() {
		return posizionamentoPortiere;
	}


	public void setPosizionamentoPortiere(int posizionamentoPortiere) {
		this.posizionamentoPortiere = posizionamentoPortiere;
	}


	public int getRiflessiPortiere() {
		return riflessiPortiere;
	}


	public void setRiflessiPortiere(int riflessiPortiere) {
		this.riflessiPortiere = riflessiPortiere;
	}


	public int getVelocitaPortiere() {
		return velocitaPortiere;
	}


	public void setVelocitaPortiere(int velocitaPortiere) {
		this.velocitaPortiere = velocitaPortiere;
	}


	public int getTotDifesa() {
		return totDifesa;
	}
	
	
}
