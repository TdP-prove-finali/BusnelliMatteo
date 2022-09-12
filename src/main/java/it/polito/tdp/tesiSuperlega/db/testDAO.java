package it.polito.tdp.tesiSuperlega.db;

import java.util.List;

import it.polito.tdp.tesiSuperlega.model.Giocatore;
import it.polito.tdp.tesiSuperlega.model.Squadra;

public class testDAO {

	public static void main(String[] args) {

		fifaDAO dao = new fifaDAO();
		//List<Giocatore> giocatori = dao.getAllGiocatori();
		for(int i = 0; i<40; i++) {
	//	System.out.println(giocatori.get(i));
		}
	
		List<Squadra> squadre = dao.getAllSquadre();
		
		for(Squadra s : squadre) {
			System.out.println(s.getNomeSqaudra());
		}
	}

}
