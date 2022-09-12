package it.polito.tdp.tesiSuperlega.model;

public class Attacco {

	private int tiro;
	private int passaggio; 
	private int dribling;
	private int cross;	
	private int finalizzazione; 
	private int colpoDiTesta; 
	private int passaggioCorto; 
	private int passaggioLungo; 
	private int skillDribling; 
	private int controlloPalla; 
	private int potenzaTiro; 
	private int potenzaTiroLontano; 
	private int mentalitaRigori;
	private int totAttacco;
	
	public Attacco(int tiro, int passaggio, int dribling, int cross, int finalizzazione, int colpoDiTesta,
			int passaggioCorto, int passaggioLungo, int skillDribling, int controlloPalla, int potenzaTiro,
			int potenzaTiroLontano, int mentalitaRigori) {
		super();
		this.tiro = tiro;
		this.passaggio = passaggio;
		this.dribling = dribling;
		this.cross = cross;
		this.finalizzazione = finalizzazione;
		this.colpoDiTesta = colpoDiTesta;
		this.passaggioCorto = passaggioCorto;
		this.passaggioLungo = passaggioLungo;
		this.skillDribling = skillDribling;
		this.controlloPalla = controlloPalla;
		this.potenzaTiro = potenzaTiro;
		this.potenzaTiroLontano = potenzaTiroLontano;
		this.mentalitaRigori = mentalitaRigori;
		this.totAttacco = this.tiro + this.passaggio + this.dribling + this.cross + this.finalizzazione + this.colpoDiTesta + 
				this.passaggioCorto + this.passaggioLungo + this.skillDribling + this.controlloPalla + this.potenzaTiro + 
				this.potenzaTiroLontano + this.mentalitaRigori;
	}

	public int getTiro() {
		return tiro;
	}

	public void setTiro(int tiro) {
		this.tiro = tiro;
	}

	public int getPassaggio() {
		return passaggio;
	}

	public void setPassaggio(int passaggio) {
		this.passaggio = passaggio;
	}

	public int getDribling() {
		return dribling;
	}

	public void setDribling(int dribling) {
		this.dribling = dribling;
	}

	public int getCross() {
		return cross;
	}

	public void setCross(int cross) {
		this.cross = cross;
	}

	public int getFinalizzazione() {
		return finalizzazione;
	}

	public void setFinalizzazione(int finalizzazione) {
		this.finalizzazione = finalizzazione;
	}

	public int getColpoDiTesta() {
		return colpoDiTesta;
	}

	public void setColpoDiTesta(int colpoDiTesta) {
		this.colpoDiTesta = colpoDiTesta;
	}

	public int getPassaggioCorto() {
		return passaggioCorto;
	}

	public void setPassaggioCorto(int passaggioCorto) {
		this.passaggioCorto = passaggioCorto;
	}

	public int getPassaggioLungo() {
		return passaggioLungo;
	}

	public void setPassaggioLungo(int passaggioLungo) {
		this.passaggioLungo = passaggioLungo;
	}

	public int getSkillDribling() {
		return skillDribling;
	}

	public void setSkillDribling(int skillDribling) {
		this.skillDribling = skillDribling;
	}

	public int getControlloPalla() {
		return controlloPalla;
	}

	public void setControlloPalla(int controlloPalla) {
		this.controlloPalla = controlloPalla;
	}

	public int getPotenzaTiro() {
		return potenzaTiro;
	}

	public void setPotenzaTiro(int potenzaTiro) {
		this.potenzaTiro = potenzaTiro;
	}

	public int getPotenzaTiroLontano() {
		return potenzaTiroLontano;
	}

	public void setPotenzaTiroLontano(int potenzaTiroLontano) {
		this.potenzaTiroLontano = potenzaTiroLontano;
	}

	public int getMentalitaRigori() {
		return mentalitaRigori;
	}

	public void setMentalitaRigori(int mentalitaRigori) {
		this.mentalitaRigori = mentalitaRigori;
	}

	public int getTotAttacco() {
		return totAttacco;
	} 
	
	
	
}
