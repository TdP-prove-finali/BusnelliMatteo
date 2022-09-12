package it.polito.tdp.tesiSuperlega.model;

import java.util.Objects;

public class Giocatore {

	private int fifaId;
	private String nomeComune;
	private String nomeCompleto;
	private String ruolo;
	private int overall;
	private int valoreGiocatoreEuro;
	private int stipendio;
	private int eta;
	private int altezza;
	private double peso;
	private String squadraAttuale;
	private String campionatoAttuale;
	private int numeroDiMaglia;
	private String nazione;
	private String piedeForte;
	private int piedeDebole;
	private int stelleSkill;
	private int clausolaRescissoria;
	private Squadra squadraSuperlega;
	private Attacco attacco;
	private Difesa difesa;
	
	public Giocatore(int fifaId, String nomeComune, String nomeCompleto, String ruolo, int overall,
			int valoreGiocatoreEuro, int stipendio, int eta, int altezza, double peso, String squadraAttuale,
			String campionatoAttuale, int numeroDiMaglia, String nazione, String piedeForte, int piedeDebole, int stelleSkill,
			int clausolaRescissoria, Attacco attacco, Difesa difesa) {
		super();
		this.fifaId = fifaId;
		this.nomeComune = nomeComune;
		this.nomeCompleto = nomeCompleto;
		this.ruolo = ruolo;
		this.overall = overall;
		this.valoreGiocatoreEuro = valoreGiocatoreEuro;
		this.stipendio = stipendio;
		this.eta = eta;
		this.altezza = altezza;
		this.peso = peso;
		this.squadraAttuale = squadraAttuale;
		this.campionatoAttuale = campionatoAttuale;
		this.numeroDiMaglia = numeroDiMaglia;
		this.nazione = nazione;
		this.piedeForte = piedeForte;
		this.piedeDebole = piedeDebole;
		this.stelleSkill = stelleSkill;
		this.clausolaRescissoria = clausolaRescissoria;
		this.attacco = attacco;
		this.difesa = difesa;
		this.squadraSuperlega = null;
	}
	
	public int getFifaId() {
		return fifaId;
	}
	public void setFifaId(int fifaId) {
		this.fifaId = fifaId;
	}
	public String getNomeComune() {
		return nomeComune;
	}
	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public int getOverall() {
		return overall;
	}
	public void setOverall(int overall) {
		this.overall = overall;
	}
	public int getValoreGiocatoreEuro() {
		return valoreGiocatoreEuro;
	}
	public void setValoreGiocatoreEuro(int valoreGiocatoreEuro) {
		this.valoreGiocatoreEuro = valoreGiocatoreEuro;
	}
	public int getStipendio() {
		return stipendio;
	}
	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getAltezza() {
		return altezza;
	}
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getSquadraAttuale() {
		return squadraAttuale;
	}
	public void setSquadraAttuale(String squadraAttuale) {
		this.squadraAttuale = squadraAttuale;
	}
	
	public String getCampionatoAttuale() {
		return campionatoAttuale;
	}
	public void setCampionatoAttuale(String campionatoAttuale) {
		this.campionatoAttuale = campionatoAttuale;
	}
	public int getNumeroDiMaglia() {
		return numeroDiMaglia;
	}
	public void setNumeroDiMaglia(int numeroDiMaglia) {
		this.numeroDiMaglia = numeroDiMaglia;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public String getPiedeForte() {
		return piedeForte;
	}
	public void setPiedeForte(String piedeForte) {
		this.piedeForte = piedeForte;
	}
	public int getPiedeDebole() {
		return piedeDebole;
	}
	public void setPiedeDebole(int piedeDebole) {
		this.piedeDebole = piedeDebole;
	}
	public int getStelleSkill() {
		return stelleSkill;
	}
	public void setStelleSkill(int stelleSkill) {
		this.stelleSkill = stelleSkill;
	}
	public int getClausolaRescissoria() {
		return clausolaRescissoria;
	}
	public void setClausolaRescissoria(int clausolaRescissoria) {
		this.clausolaRescissoria = clausolaRescissoria;
	}
	public Attacco getAttacco() {
		return attacco;
	}
	public void setAttacco(Attacco attacco) {
		this.attacco = attacco;
	}
	public Difesa getDifesa() {
		return difesa;
	}
	public void setDifesa(Difesa difesa) {
		this.difesa = difesa;
	}
	
	public Squadra getSquadraSuperlega() {
		return squadraSuperlega;
	}

	public void setSquadraSuperlega(Squadra squadraSuperlega) {
		this.squadraSuperlega = squadraSuperlega;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fifaId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Giocatore other = (Giocatore) obj;
		return fifaId == other.fifaId;
	}
	@Override
	public String toString() {
		return "INFORMAZIONI GENERALI:\nRuolo: "+this.ruolo+"\nOverall: "+this.overall+"\nValore: "+this.valoreGiocatoreEuro+"€\nStipendio: "+
				this.stipendio+"€\nEta: "+this.eta+" anni\nAltezza: "+this.altezza+" cm\nPeso: "+this.peso+" kg\nSquadra attuale: "+this.squadraAttuale+
				"\nNumero di maglia: "+this.numeroDiMaglia+"\nNazione: "+this.nazione+"\nPiede forte: "+this.piedeForte+"\nStelle piede debole: "+
				this.piedeDebole+"\nStelle skill: "+this.stelleSkill+"\nClausola rescissoria: "+this.clausolaRescissoria+"€\n\nVALORI ATTACCO\nTiro: "+
				this.attacco.getTiro()+"\nPassaggio: "+this.attacco.getPassaggio()+"\nDribling: "+this.attacco.getDribling()+"\nCross: "+this.attacco.getCross()+
				"\nFinalizzazione: "+this.attacco.getFinalizzazione()+"\nColpo di testa: "+this.attacco.getColpoDiTesta()+"\nPassaggio corto: "+this.attacco.getPassaggioCorto()+
				"\nPassaggio lungo: "+this.attacco.getPassaggioLungo()+"\nControllo palla: "+this.attacco.getControlloPalla()+"\nPotenza di tiro: "+this.attacco.getPotenzaTiro()+
				"\nPotenza di tiro da lontano: "+this.attacco.getPotenzaTiroLontano()+"\nMentalita' rigori: "+this.attacco.getMentalitaRigori()+"\nTotale attacco: "+
				this.getAttacco().getTotAttacco()+"\n\nVALORI DIFESA\nDifesa: "+this.difesa.getCapacitadifesa()+"\nSalto: "+this.difesa.getSalto()+"\nForza: "+
				this.difesa.getForza()+"\nBilanciamento difensivo: "+this.difesa.getBilanciamento()+"\nAggressivit': "+this.difesa.getAggressivita()+"\nMentalita' aggressiva: "+
				this.difesa.getMentalitaAggressiva()+"\nInteresse difensivo: "+this.difesa.getInteresseDifensivo()+"\nTakle: "+this.difesa.getTakle()+
				"\nScivolamento difensivo: "+this.difesa.getSchivolamentoDifensivo()+"\nTuffo portiere: "+this.difesa.getTuttoPortiere()+"\nMani portiere: "+
				this.difesa.getManiPortiere()+"\nRinvio portiere: "+this.difesa.getCalcioPortiere()+"\nPosizionamento portiere: "+this.difesa.getPosizionamentoPortiere()+
				"\nRiflessi portiere: "+this.difesa.getRiflessiPortiere()+"\nVelocita' portiere: "+this.difesa.getVelocitaPortiere()+"\nTotale difesa: "+
				this.difesa.getTotDifesa()+"\n";
	}
	
	
	
	
	
	
	
	
	
	
}
