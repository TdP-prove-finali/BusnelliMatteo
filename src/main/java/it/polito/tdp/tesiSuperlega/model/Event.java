package it.polito.tdp.tesiSuperlega.model;

public class Event implements Comparable<Event>{

	public enum EventType{
		
		PALLA_PERSA,
		GOL,
		ESPULSIONE,
		INFORTUNIO
		}
	
	private Integer time;
	private EventType type;
	private Squadra squadra;
	
	public Event(Integer time, EventType type, Squadra squadra) {
		super();
		this.time = time;
		this.type = type;
		this.squadra = squadra;
	}


	public Integer getTime() {
		return time;
	}


	public void setTime(Integer time) {
		this.time = time;
	}


	public EventType getType() {
		return type;
	}


	public void setType(EventType type) {
		this.type = type;
	}


	public Squadra getSquadra() {
		return squadra;
	}

	
	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}


	@Override
	public int compareTo(Event o) {
		return this.time.compareTo(o.getTime());
	}
	
	
	
	
}
