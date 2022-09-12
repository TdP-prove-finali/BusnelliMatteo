package it.polito.tdp.tesiSuperlega.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Squadra {

	private int idSquadra;
	private String nomeSqaudra;
	private List<Giocatore> giocatoriDellaSquadra;
	private Graph<Giocatore, DefaultWeightedEdge> grafo;
	private int budgetRimasto;
	private double budgetPortiere;
	private double budgetDifesa;
	private double budgetCentrocampo;
	private double budgetAttacco;
	private int totAttacco;
	private int totDifesa;
	private int puntiSemifinale;
	private int diffPunti;

	
	public Squadra(int idSquadra, String nomeSqaudra) {
		super();
		this.idSquadra = idSquadra;
		this.nomeSqaudra = nomeSqaudra;
		this.giocatoriDellaSquadra = new ArrayList<>();
		this.puntiSemifinale = 0;
		this.diffPunti = 0;
	
	}

	public int getIdSquadra() {
		return idSquadra;
	}

	public String getNomeSqaudra() {
		return nomeSqaudra;
	}
	
	public List<Giocatore> getGiocatoriDellaSquadra() {
		return giocatoriDellaSquadra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSquadra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Squadra other = (Squadra) obj;
		return idSquadra == other.idSquadra;
	}

	@Override
	public String toString() {
		return nomeSqaudra;
	}

	public void creaGrafo() {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	}

	public void aggiungiVertici(Giocatore g) {
		this.grafo.addVertex(g);
	}

	public void creaArchi() {
		for(Giocatore g1 : this.grafo.vertexSet()) {
			for(Giocatore g2 : this.grafo.vertexSet()) {
				if(g1!=g2) {
					if(totSomiglianze(g1,g2)==3) {
						Graphs.addEdgeWithVertices(this.grafo, g1, g2, 3);
					}
					else if(totSomiglianze(g1,g2)==2) {
						Graphs.addEdgeWithVertices(this.grafo, g1, g2, 2);
					}
					else if(totSomiglianze(g1,g2)==1) {
						Graphs.addEdgeWithVertices(this.grafo, g1, g2, 1);
					}
					else if(totSomiglianze(g1,g2)==0) {
						Graphs.addEdgeWithVertices(this.grafo, g1, g2, 0);
					}
				}
			}
		}
	}
	
	private int totSomiglianze(Giocatore g1, Giocatore g2) {
		if(g1.getNazione().equals(g2.getNazione()) && g1.getCampionatoAttuale().equals(g2.getCampionatoAttuale()) && g1.getSquadraAttuale().equals(g2.getSquadraAttuale()))
			return 3;
		else if((g1.getNazione().equals(g2.getNazione()) && g1.getCampionatoAttuale().equals(g2.getCampionatoAttuale()) && !g1.getSquadraAttuale().equals(g2.getSquadraAttuale())) || (!g1.getNazione().equals(g2.getNazione()) && g1.getCampionatoAttuale().equals(g2.getCampionatoAttuale()) && g1.getSquadraAttuale().equals(g2.getSquadraAttuale()))){
			return 2;
		}
		else if(g1.getNazione().equals(g2.getNazione()) && !g1.getCampionatoAttuale().equals(g2.getCampionatoAttuale()) && g1.getSquadraAttuale().equals(g2.getSquadraAttuale())) {
			return 1;
		}
		else return 0;
	}
	
	public int intesaTotale() {
		int tot = 0;
		for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
			tot+=this.grafo.getEdgeWeight(e);
		}
		
		return tot;
	}

	public Graph<Giocatore, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}

	public int getBudgetRimasto() {
		return budgetRimasto;
	}
	
	

	public void setBudgetRimasto(int budgetRimasto) {
		this.budgetRimasto = budgetRimasto;
		this.budgetPortiere = 0.1*this.budgetRimasto;
		this.budgetDifesa = 0.3*this.budgetRimasto;
		this.budgetCentrocampo = 0.3*this.budgetRimasto;
		this.budgetAttacco = 0.3*this.budgetRimasto;
		
	}

	public void resetGrafo() {
		this.grafo = null;		
	}

	public void decrementaBudget(int stipendio) {
		this.budgetRimasto-=stipendio;
		
	}

	public double getBudgetPortiere() {
		return budgetPortiere;
	}

	public void setBudgetPortiere(double budgetPortiere) {
		this.budgetPortiere = budgetPortiere;
	}

	public double getBudgetDifesa() {
		return budgetDifesa;
	}

	public void setBudgetDifesa(double budgetDifesa) {
		this.budgetDifesa = budgetDifesa;
	}

	public double getBudgetCentrocampo() {
		return budgetCentrocampo;
	}

	public void setBudgetCentrocampo(double budgetCentrocampo) {
		this.budgetCentrocampo = budgetCentrocampo;
	}

	public double getBudgetAttacco() {
		return budgetAttacco;
	}

	public void setBudgetAttacco(double budgetAttacco) {
		this.budgetAttacco = budgetAttacco;
	}

	public int getTotAttacco() {
		return totAttacco;
	}

	public void setTotAttacco(int totAttacco) {
		this.totAttacco = totAttacco;
	}

	public int getTotDifesa() {
		return totDifesa;
	}

	public void setTotDifesa(int totDifesa) {
		this.totDifesa = totDifesa;
	}

	public void setIdSquadra(int idSquadra) {
		this.idSquadra = idSquadra;
	}

	public void setNomeSqaudra(String nomeSqaudra) {
		this.nomeSqaudra = nomeSqaudra;
	}

	public void setGiocatoriDellaSquadra(List<Giocatore> giocatoriDellaSquadra) {
		this.giocatoriDellaSquadra = giocatoriDellaSquadra;
	}

	public void setGrafo(Graph<Giocatore, DefaultWeightedEdge> grafo) {
		this.grafo = grafo;
	}

	public int getPuntiSemifinale() {
		return puntiSemifinale;
	}

	public void setPuntiSemifinale(int puntiSemifinale) {
		this.puntiSemifinale = puntiSemifinale;
	}

	public int getDiffPunti() {
		return diffPunti;
	}

	public void setDiffPunti(int diffPunti) {
		this.diffPunti = diffPunti;
	}

	
	
	
	
}
