package it.polito.tdp.tesiSuperlega.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.tesiSuperlega.model.Event.EventType;;


public class Simulatore {

	private Squadra casa;
	private Squadra trasferta;
	private int intesa;
	private PriorityQueue<Event> queue;
	private Statistiche stat;
	private int totGiocatoriCasa;
	private int totGiocatoriTrasferta;
	private int totSostCasaDisp;
	private int totSostTrasfDisp;
	private int totAzioni;
	private double rapportoForza;
	final int durataPartita = 90; //min
	final int intervalloTemp = 5; //min
	double probEvento;
	int slotTemporali;
	
	public void init(Squadra casa, Squadra trasferta) {
		this.casa = casa;
		this.trasferta = trasferta;
		this.intesa = this.casa.intesaTotale()-this.trasferta.intesaTotale(); //se >0, aumenta del intesa% la prob di giocare un azione per la squadra di casa, se <0 viceversa
		this.queue = new PriorityQueue<>();
		this.stat = new Statistiche(this.casa, this.trasferta);
		this.totAzioni = 0;
		this.totGiocatoriCasa = 11;
		this.totGiocatoriTrasferta = 11;
		this.totSostCasaDisp = 5;
		this.totSostTrasfDisp = 5;
		this.probEvento = (double)10/18;
		this.rapportoForza = (double)(casa.getTotAttacco() + casa.getTotDifesa())/(trasferta.getTotAttacco() + trasferta.getTotDifesa());
		this.slotTemporali = this.durataPartita/this.intervalloTemp;
		//fisso un intervallo temporale di 5 minuti --> 90/5 = 18 slot temporali --> ogni slot ha probabilità 10/18 che si verifichi un evento
		
		int cont=0;
		while(cont<this.slotTemporali) {
			double prob = Math.random();
			
			if(prob<=this.probEvento) {
				this.totAzioni++;
				
			}
			cont++;
		}
		
		if(this.rapportoForza>=2) {
			//casa ha il doppio della probabilità di iniziare un'azione rispetto alla squadra in trasferta
			double azioneCasa = Math.random();
			if(azioneCasa<=(0.66+(this.intesa/100))) {
				//attacco squadra casa
				if(this.casa.getTotAttacco()>this.trasferta.getTotDifesa()) {
					//più probabile goal, rigore o espulsioneTrasf
					double prob = Math.random();
					
					if(prob<0.50) {
						this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));
					}
					else if(prob<0.8) { //30% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, casa));
					}
					else if(prob<0.85){
						this.queue.add(new Event(1, EventType.ESPULSIONE, trasferta));
					}
					else if(prob<0.9) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, casa));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));


					}
					
				}else {
					//poco probabile il gol, il rigore o espulsioneTrasferta
					double prob = Math.random();
					
					if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
						this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));
					}
					else if(prob<0.85) { //20% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, casa));
					}
					else if(prob<0.90){
						this.queue.add(new Event(1, EventType.ESPULSIONE, trasferta));
					}
					else if(prob<0.95) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, casa));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));


					}
				}
				
			}else {
				//attcca squadra in trasferta
				if(this.trasferta.getTotAttacco()>this.casa.getTotDifesa()) {
					//più probabile goal, rigore o espulsioneCasa
					double prob = Math.random();
					
					if(prob<0.50) {
						this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));
					}
					else if(prob<0.8) { //30% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, trasferta));
					}
					else if(prob<0.85){
						this.queue.add(new Event(1, EventType.ESPULSIONE, casa));
					}
					else if(prob<0.9) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, trasferta));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));


					}
					
				}else {
					//poco probabile il gol, il rigore o espulsioneCasa
					double prob = Math.random();
					
					if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
						this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));
					}
					else if(prob<0.85) { //20% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, trasferta));
					}
					else if(prob<0.90){
						this.queue.add(new Event(1, EventType.ESPULSIONE, casa));
					}
					else if(prob<0.95) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, trasferta));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));


					}
				}
			}
		}
		else if(this.rapportoForza<=0.5) {
			//trasf ha il doppio della probabilità di iniziare un'azione rispetto alla squadra in casa
			double azioneTrasf = Math.random();
			if(azioneTrasf<=(0.66-(this.intesa/100))) {
				//attacco squadra trasferta
				if(this.trasferta.getTotAttacco()>this.casa.getTotDifesa()) {
					//più probabile goal, rigore o espulsioneCasa
					double prob = Math.random();
					
					if(prob<0.50) {
						this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));
					}
					else if(prob<0.8) { //30% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, trasferta));
					}
					else if(prob<0.85){
						this.queue.add(new Event(1, EventType.ESPULSIONE, casa));
					}
					else if(prob<0.9) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, trasferta));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));


					}
					
				}else {
					//poco probabile il gol, il rigore o espulsioneCasa
					double prob = Math.random();
					
					if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
						this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));
					}
					else if(prob<0.85) { //20% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, trasferta));
					}
					else if(prob<0.90){
						this.queue.add(new Event(1, EventType.ESPULSIONE, casa));
					}
					else if(prob<0.95) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, trasferta));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));


					}
				}
				
			}else {
				//attcca squadra in casa
				if(this.casa.getTotAttacco()>this.trasferta.getTotDifesa()) {
					//più probabile goal, rigore o espulsioneTrasf
					double prob = Math.random();
					
					if(prob<0.50) {
						this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));
					}
					else if(prob<0.8) { //30% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, casa));
					}
					else if(prob<0.85){
						this.queue.add(new Event(1, EventType.ESPULSIONE, trasferta));
					}
					else if(prob<0.9) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, casa));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));


					}
					
				}else {
					//poco probabile il gol, il rigore o espulsioneTrasf
					double prob = Math.random();
					
					if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
						this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));
					}
					else if(prob<0.85) { //20% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, casa));
					}
					else if(prob<0.90){
						this.queue.add(new Event(1, EventType.ESPULSIONE, trasferta));
					}
					else if(prob<0.95) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, casa));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));


					}
				}
			}
				
			}
		else {
			//50 - 50
			double azione = Math.random();
			if(azione<=(0.5+(this.intesa/100))) {
				//attacco squadra casa
				if(this.casa.getTotAttacco()>this.trasferta.getTotDifesa()) {
					//più probabile goal, rigore o espulsioneTrasf
					double prob = Math.random();
					
					if(prob<0.50) {
						this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));
					}
					else if(prob<0.8) { //30% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, casa));
					}
					else if(prob<0.85){
						this.queue.add(new Event(1, EventType.ESPULSIONE, trasferta));
					}
					else if(prob<0.9) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, casa));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));


					}
					
				}else {
					//poco probabile il gol, il rigore o espulsioneTrasferta
					double prob = Math.random();
					
					if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
						this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));
					}
					else if(prob<0.85) { //20% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, casa));
					}
					else if(prob<0.90){
						this.queue.add(new Event(1, EventType.ESPULSIONE, trasferta));
					}
					else if(prob<0.95) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, casa));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, casa));


					}
				}
				
			}else {
				//attcca squadra in trasferta
				if(this.trasferta.getTotAttacco()>this.casa.getTotDifesa()) {
					//più probabile goal, rigore o espulsioneCasa
					double prob = Math.random();
					
					if(prob<0.50) {
						this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));
					}
					else if(prob<0.8) { //30% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, trasferta));
					}
					else if(prob<0.85){
						this.queue.add(new Event(1, EventType.ESPULSIONE, casa));
					}
					else if(prob<0.9) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, trasferta));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));


					}
					
				}else {
					//poco probabile il gol, il rigore o espulsioneCasa
					double prob = Math.random();
					
					if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
						this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));
					}
					else if(prob<0.85) { //20% probabilità di gol
						this.queue.add(new Event(1, EventType.GOL, trasferta));
					}
					else if(prob<0.90){
						this.queue.add(new Event(1, EventType.ESPULSIONE, casa));
					}
					else if(prob<0.95) {
						double inf = Math.random();
						if(inf<0.5)
							this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));
						else 
							this.queue.add(new Event(1, EventType.INFORTUNIO, casa));


					}
					else {
						//rigore
						double rigore = Math.random();
						if(rigore<0.8)
							this.queue.add(new Event(1, EventType.GOL, trasferta));
						else
							this.queue.add(new Event(1, EventType.PALLA_PERSA, trasferta));


					}
				}
			}
		}
	}

	public void run() {
		while(!this.queue.isEmpty()) {
			Event e = this.queue.poll();
			processEvent(e);
		}
	}

	private void processEvent(Event e) {
		EventType type = e.getType();
		
		if(e.getTime()<=this.totAzioni) {
			switch(type) {
			
			
			case PALLA_PERSA:
				if(this.rapportoForza>=2) {
					//casa ha il doppio della probabilità di iniziare un'azione rispetto alla squadra in trasferta
					double azioneCasa = Math.random();
					if(azioneCasa<=(0.66+(this.intesa/100))) {
						//attacco squadra casa
						if(this.casa.getTotAttacco()>this.trasferta.getTotDifesa()) {
							//più probabile goal, rigore o espulsioneTrasf
							double prob = Math.random();
							
							if(prob<0.50) {
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));
							}
							else if(prob<0.8) { //30% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
							}
							else if(prob<0.85){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, trasferta));
							}
							else if(prob<0.9) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));


							}
							
						}else {
							//poco probabile il gol, il rigore o espulsioneTrasferta
							double prob = Math.random();
							
							if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));
							}
							else if(prob<0.85) { //20% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
							}
							else if(prob<0.90){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, trasferta));
							}
							else if(prob<0.95) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));


							}
						}
						
					}else {
						//attcca squadra in trasferta
						if(this.trasferta.getTotAttacco()>this.casa.getTotDifesa()) {
							//più probabile goal, rigore o espulsioneCasa
							double prob = Math.random();
							
							if(prob<0.50) {
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));
							}
							else if(prob<0.8) { //30% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
							}
							else if(prob<0.85){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, casa));
							}
							else if(prob<0.9) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));


							}
							
						}else {
							//poco probabile il gol, il rigore o espulsioneCasa
							double prob = Math.random();
							
							if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));
							}
							else if(prob<0.85) { //20% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
							}
							else if(prob<0.90){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, casa));
							}
							else if(prob<0.95) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));


							}
						}
					}
				}
				else if(this.rapportoForza<=0.5) {
					//trasf ha il doppio della probabilità di iniziare un'azione rispetto alla squadra in casa
					double azioneTrasf = Math.random();
					if(azioneTrasf<=(0.66-(this.intesa/100))) {
						//attacco squadra trasferta
						if(this.trasferta.getTotAttacco()>this.casa.getTotDifesa()) {
							//più probabile goal, rigore o espulsioneCasa
							double prob = Math.random();
							
							if(prob<0.50) {
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));
							}
							else if(prob<0.8) { //30% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
							}
							else if(prob<0.85){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, casa));
							}
							else if(prob<0.9) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));


							}
							
						}else {
							//poco probabile il gol, il rigore o espulsioneCasa
							double prob = Math.random();
							
							if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));
							}
							else if(prob<0.85) { //20% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
							}
							else if(prob<0.90){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, casa));
							}
							else if(prob<0.95) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));


							}
						}
						
					}else {
						//attcca squadra in casa
						if(this.casa.getTotAttacco()>this.trasferta.getTotDifesa()) {
							//più probabile goal, rigore o espulsioneTrasf
							double prob = Math.random();
							
							if(prob<0.50) {
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));
							}
							else if(prob<0.8) { //30% probabilità di gol
								this.queue.add(new Event(1, EventType.GOL, casa));
							}
							else if(prob<0.85){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, trasferta));
							}
							else if(prob<0.9) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));


							}
							
						}else {
							//poco probabile il gol, il rigore o espulsioneTrasf
							double prob = Math.random();
							
							if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));
							}
							else if(prob<0.85) { //20% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
							}
							else if(prob<0.90){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, trasferta));
							}
							else if(prob<0.95) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));


							}
						}
					}
						
					}
				else {
					//50 - 50
					double azione = Math.random();
					if(azione<=(0.5+(this.intesa/100))) {
						//attacco squadra casa
						if(this.casa.getTotAttacco()>this.trasferta.getTotDifesa()) {
							//più probabile goal, rigore o espulsioneTrasf
							double prob = Math.random();
							
							if(prob<0.50) {
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));
							}
							else if(prob<0.8) { //30% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
							}
							else if(prob<0.85){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, trasferta));
							}
							else if(prob<0.9) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));


							}
							
						}else {
							//poco probabile il gol, il rigore o espulsioneTrasferta
							double prob = Math.random();
							
							if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));
							}
							else if(prob<0.85) { //20% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
							}
							else if(prob<0.90){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, trasferta));
							}
							else if(prob<0.95) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));
								else 
									this.queue.add(new Event(1, EventType.INFORTUNIO, trasferta));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));


							}
						}
						
					}else {
						//attcca squadra in trasferta
						if(this.trasferta.getTotAttacco()>this.casa.getTotDifesa()) {
							//più probabile goal, rigore o espulsioneCasa
							double prob = Math.random();
							
							if(prob<0.50) {
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));
							}
							else if(prob<0.8) { //30% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
							}
							else if(prob<0.85){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, casa));
							}
							else if(prob<0.9) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));


							}
							
						}else {
							//poco probabile il gol, il rigore o espulsioneCasa
							double prob = Math.random();
							
							if(prob<0.65) { //10% in più la probabilità di palla persa se ho una difesa più forte
								this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));
							}
							else if(prob<0.85) { //20% probabilità di gol
								this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
							}
							else if(prob<0.90){
								this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, casa));
							}
							else if(prob<0.95) {
								double inf = Math.random();
								if(inf<0.5)
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, trasferta));
								else 
									this.queue.add(new Event(e.getTime()+1, EventType.INFORTUNIO, casa));


							}
							else {
								//rigore
								double rigore = Math.random();
								if(rigore<0.8)
									this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
								else
									this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));


							}
						}
					}
				}
				
				break;
				
				
			case GOL:
				Giocatore gg = null;
				if(e.getSquadra().equals(casa)) {
					 gg = giocatoreEvento(casa, "GOL");
					this.stat.setGolCasa(this.stat.getGolCasa()+1);
				}
				else {
					 gg = giocatoreEvento(trasferta, "GOL");
					this.stat.setGolTrasferta(this.stat.getGolTrasferta()+1);
				}
				
				int minuto = trovaMinuto(e.getTime());
				MinEvento minevento = new MinEvento(minuto, "GOL", gg);
				this.stat.aggiungiEvento(minevento);
				
				//dopo un gol, al 95% palla persa (nel senso che si ricomincia), al 5% si verifica un espulsione della squadra che lo ha subito
				double prob = Math.random();
				if(prob<0.95) {
					if(e.getSquadra().equals(casa)) {
						this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));
					}
					else {
						this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));
					}
					
				}
				else {
					if(e.getSquadra().equals(casa)) {
						this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, trasferta));
					}
					else {
						this.queue.add(new Event(e.getTime()+1, EventType.ESPULSIONE, casa));
					}
				}
				
				break;
				
				
			
			case ESPULSIONE:
				
				Giocatore espulso = null;
					if(e.getSquadra().equals(casa)) {
						this.totGiocatoriCasa--;
						espulso = giocatoreEvento(casa, "ESPULSIONE");
						this.casa.getGiocatoriDellaSquadra().remove(espulso);
						//dopo un'espulsione al 70% si verifica un gol per la squadra avversaria
						double proba = Math.random();
						if(proba<0.7) {
							this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
						}
						else {
							this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));

						}
					}
					else {
						this.totGiocatoriTrasferta--;
						espulso = giocatoreEvento(trasferta, "ESPULSIONE");
						this.trasferta.getGiocatoriDellaSquadra().remove(espulso);
						//dopo un'espulsione al 70% si verifica un gol per la squadra avversaria
						double proba = Math.random();
						if(proba<0.7) {
							this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
						}
						else {
							this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));

						}
					}
					int min = trovaMinuto(e.getTime());
					MinEvento minevent = new MinEvento(min, "ESPULSIONE", espulso);
					this.stat.aggiungiEvento(minevent);				
					
				
				break;
			
				
				
			case INFORTUNIO:
				Giocatore infortunato = null;
				if(e.getSquadra().equals(casa)) {
					this.totSostCasaDisp--;
					infortunato = giocatoreEvento(casa, "INFORTUNIO");
					this.casa.getGiocatoriDellaSquadra().remove(infortunato);
					if(this.totSostCasaDisp<0) {
						//gioco con un giocatore in meno
						this.totGiocatoriCasa--;
						//come se fosse espulso
						double proba = Math.random();
						if(proba<0.7) {
							this.queue.add(new Event(e.getTime()+1, EventType.GOL, trasferta));
						}
						else {
							this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));

						}
					}
					else {
						this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, casa));
					}
				}
				else {
					this.totSostTrasfDisp--;
					infortunato = giocatoreEvento(trasferta, "INFORTUNIO");
					this.trasferta.getGiocatoriDellaSquadra().remove(infortunato);
					if(this.totSostTrasfDisp<0) {
						//gioco con un giocatore in meno
						this.totGiocatoriTrasferta--;
						//come se fosse espulso
						double proba = Math.random();
						if(proba<0.7) {
							this.queue.add(new Event(e.getTime()+1, EventType.GOL, casa));
						}
						else {
							this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));

						}
					}
					else {
						this.queue.add(new Event(e.getTime()+1, EventType.PALLA_PERSA, trasferta));
					}
				}
					
				int minu = trovaMinuto(e.getTime());
				MinEvento mineven = new MinEvento(minu, "INFORTUNIO", infortunato);
				this.stat.aggiungiEvento(mineven);				
				break;

			}
			
		}
		else {
			//fine simulazione
			//caso pareggio
			if(this.stat.getGolCasa()==this.stat.getGolTrasferta()) {
				//si va ai rigori
				if(calcolaRigori(casa)>=calcolaRigori(trasferta)) {
					this.stat.setVittoriaRigoriCasa(true);
					this.stat.setVittoria("Dopo i calci di rigore ha vinto: "+this.casa.getNomeSqaudra());
				}else {
					this.stat.setVittoriaRigoriTrasferta(true);
					this.stat.setVittoria("Dopo i calci di rigore ha vinto: "+this.trasferta.getNomeSqaudra());

				}
			}
		}
		
	}

	
	private Giocatore giocatoreEvento(Squadra squadra, String evento) {
		List<Giocatore> l = new ArrayList<>();
		Giocatore result = null;
		l.addAll(squadra.getGiocatoriDellaSquadra());
		
		if(evento.equals("GOL")) {
				
			Collections.sort(l, new Comparator<Giocatore>() {

				@Override
				public int compare(Giocatore o1, Giocatore o2) {
					return o2.getAttacco().getTotAttacco()-o1.getAttacco().getTotAttacco();
				}
				
			});
			
			double prob = Math.random();
			
			if(prob<=0.50) { //al 50% segna il giocatore con il tot attacco maggiore
				result = l.get(0);
			}
			else {
				l.remove(0); //rimuovo il migliore dal caso precedente
				Collections.shuffle(l);
				result = l.get(0); //ne prendo uno dei rimasti a caso dopo aver mischiato casualmente la lista
			}
		}
		else if(evento.equals("ESPULSIONE")) {
			Collections.sort(l, new Comparator<Giocatore>() {

				@Override
				public int compare(Giocatore o1, Giocatore o2) {
					return o2.getDifesa().getMentalitaAggressiva()-o1.getDifesa().getMentalitaAggressiva(); 
				}//un giocatore più aggressivo ha più probabilità di essere espulso
				
			});
			
			result = l.get(0);
			
		}
		else {
			//infortunio
			Collections.shuffle(l);
			//un giocatore casuale si infortunia
			result = l.get(0);
		}
		
		return result;
	}

	
	
	private int trovaMinuto(Integer time) {
		int moltiplicatore = this.durataPartita/this.totAzioni;
		int limite = time*moltiplicatore;
		
		double prob = Math.random()*moltiplicatore+1;
		return (int) (limite-prob);
		
	}

	
	private int calcolaRigori(Squadra squadra) {
		int tot=0;
		for(Giocatore g : squadra.getGiocatoriDellaSquadra()) {
			tot+=g.getAttacco().getMentalitaRigori();
		}
		
		return tot;
	}


	public Statistiche getStat() {
		return stat;
	}
}
