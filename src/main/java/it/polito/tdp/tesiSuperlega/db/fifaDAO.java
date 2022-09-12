package it.polito.tdp.tesiSuperlega.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.tesiSuperlega.model.Attacco;
import it.polito.tdp.tesiSuperlega.model.Difesa;
import it.polito.tdp.tesiSuperlega.model.Giocatore;
import it.polito.tdp.tesiSuperlega.model.Squadra;


public class fifaDAO {

	public void getAllGiocatori(Map<Integer, Giocatore> idMap){
		String sql = "SELECT * FROM giocatore " ;
		try {
			Connection conn = ConnectDB.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
						
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				if(!idMap.containsKey(res.getInt("fifa_id"))) {
					Attacco attacco = new Attacco(res.getInt("tiro"), res.getInt("passaggio"), res.getInt("dribling"),res.getInt("cross"), 
							res.getInt("finalizzazione"), res.getInt("colpo_di_testa"), res.getInt("passaggio_corto"), res.getInt("passaggio_lungo"), 
							res.getInt("skill_dribling"), res.getInt("controllo_palla"), res.getInt("potenza_tiro"), res.getInt("potenza_tiro_lontano"),
							res.getInt("mentalita_rigori"));
					
					Difesa difesa = new Difesa(res.getInt("difesa"), res.getInt("salto"), res.getInt("forza"),res.getInt("bilanciamento"), res.getInt("aggressivita"),  
							res.getInt("mentalita_aggressiva"), res.getInt("mentalita_intercetto"), res.getInt("interesse_difensivo"),res.getInt("takle"),
							res.getInt("scivolamento_difensivo"), res.getInt("tuffo_portiere"),res.getInt("mani_portiere"),res.getInt("calcio_portiere"),
							res.getInt("posizionamento_portiere"), res.getInt("riflessi_portiere"),res.getInt("velocita_portiere"));
					
					Giocatore g = new Giocatore(res.getInt("fifa_id"), res.getString("nome_corto"), res.getString("nome_lungo"),
							res.getString("ruolo"), res.getInt("overall"), res.getInt("valore_euro"), res.getInt("stipendio"),
							res.getInt("eta"), res.getInt("altezza_cm"), res.getDouble("peso_kg"), res.getString("squadra_attuale"),
							res.getString("campionato_attuale"),res.getInt("numero_maglia"), res.getString("nazione"), res.getString("piede_preferito"), res.getInt("piede_debole"),
							res.getInt("stelle_skill"), res.getInt("clausola_rescissoria"), attacco, difesa);
					
					idMap.put(res.getInt("fifa_id"), g);
				}
					
					
			}
			
			conn.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	
/*	public List<Giocatore> getAllGiocatoriByRuolo(String ruolo){
		String sql = "SELECT * FROM giocatore WHERE ruolo = ? " ;
		try {
			Connection conn = ConnectDB.getConnection() ;
			List<Giocatore> result = new ArrayList<>();
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setString(1, ruolo);
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				
					Attacco attacco = new Attacco(res.getInt("tiro"), res.getInt("passaggio"), res.getInt("dribling"),res.getInt("cross"), 
							res.getInt("finalizzazione"), res.getInt("colpo_di_testa"), res.getInt("passaggio_corto"), res.getInt("passaggio_lungo"), 
							res.getInt("skill_dribling"), res.getInt("controllo_palla"), res.getInt("potenza_tiro"), res.getInt("potenza_tiro_lontano"),
							res.getInt("mentalita_rigori"));
					
					Difesa difesa = new Difesa(res.getInt("difesa"), res.getInt("salto"), res.getInt("forza"),res.getInt("bilanciamento"), res.getInt("aggressivita"),  
							res.getInt("mentalita_aggressiva"), res.getInt("mentalita_intercetto"), res.getInt("interesse_difensivo"),res.getInt("takle"),
							res.getInt("scivolamento_difensivo"), res.getInt("tuffo_portiere"),res.getInt("mani_portiere"),res.getInt("calcio_portiere"),
							res.getInt("posizionamento_portiere"), res.getInt("riflessi_portiere"),res.getInt("velocita_portiere"));
					
					Giocatore g = new Giocatore(res.getInt("fifa_id"), res.getString("nome_corto"), res.getString("nome_lungo"),
							res.getString("ruolo"), res.getInt("overall"), res.getInt("valore_euro"), res.getInt("stipendio"),
							res.getInt("eta"), res.getInt("altezza_cm"), res.getDouble("peso_kg"), res.getString("squadra_attuale"),
							res.getString("campionato_attuale"), res.getInt("numero_maglia"), res.getString("nazione"), res.getString("piede_preferito"), res.getInt("piede_debole"),
							res.getInt("stelle_skill"), res.getInt("clausola_rescissoria"), attacco, difesa);
					
				result.add(g);
					
					
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	public List<Squadra> getAllSquadre(){
		String sql = "SELECT * FROM squadra ORDER BY nomeSquadra " ;
		try {
			Connection conn = ConnectDB.getConnection() ;

			PreparedStatement st = conn.prepareStatement(sql) ;
			
			List<Squadra> result = new ArrayList<Squadra>() ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
					Squadra s = new Squadra(res.getInt("idSquadra"), res.getString("nomeSquadra"));
							
					result.add(s);
					
			}
			
			conn.close();
			return result ;

		} catch (SQLException e) {
			e.printStackTrace();
			return null ;
		}
	}
	
/*	public List<Giocatore> getPortieri(){
		String sql = "SELECT * FROM giocatore WHERE ruolo = 'P' " ;
		try {
			Connection conn = ConnectDB.getConnection() ;
			List<Giocatore> result = new ArrayList<>();
			PreparedStatement st = conn.prepareStatement(sql) ;
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				
					Attacco attacco = new Attacco(res.getInt("tiro"), res.getInt("passaggio"), res.getInt("dribling"),res.getInt("cross"), 
							res.getInt("finalizzazione"), res.getInt("colpo_di_testa"), res.getInt("passaggio_corto"), res.getInt("passaggio_lungo"), 
							res.getInt("skill_dribling"), res.getInt("controllo_palla"), res.getInt("potenza_tiro"), res.getInt("potenza_tiro_lontano"),
							res.getInt("mentalita_rigori"));
					
					Difesa difesa = new Difesa(res.getInt("difesa"), res.getInt("salto"), res.getInt("forza"),res.getInt("bilanciamento"), res.getInt("aggressivita"),  
							res.getInt("mentalita_aggressiva"), res.getInt("mentalita_intercetto"), res.getInt("interesse_difensivo"),res.getInt("takle"),
							res.getInt("scivolamento_difensivo"), res.getInt("tuffo_portiere"),res.getInt("mani_portiere"),res.getInt("calcio_portiere"),
							res.getInt("posizionamento_portiere"), res.getInt("riflessi_portiere"),res.getInt("velocita_portiere"));
					
					Giocatore g = new Giocatore(res.getInt("fifa_id"), res.getString("nome_corto"), res.getString("nome_lungo"),
							res.getString("ruolo"), res.getInt("overall"), res.getInt("valore_euro"), res.getInt("stipendio"),
							res.getInt("eta"), res.getInt("altezza_cm"), res.getDouble("peso_kg"), res.getString("squadra_attuale"),
							res.getString("campionato_attuale"), res.getInt("numero_maglia"), res.getString("nazione"), res.getString("piede_preferito"), res.getInt("piede_debole"),
							res.getInt("stelle_skill"), res.getInt("clausola_rescissoria"), attacco, difesa);
					
					result.add(g);
					
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	public List<Giocatore> getDifensori(){
		String sql = "SELECT * FROM giocatore WHERE ruolo = 'D' " ;
		try {
			Connection conn = ConnectDB.getConnection() ;
			List<Giocatore> result = new ArrayList<>();
			PreparedStatement st = conn.prepareStatement(sql) ;
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				
					Attacco attacco = new Attacco(res.getInt("tiro"), res.getInt("passaggio"), res.getInt("dribling"),res.getInt("cross"), 
							res.getInt("finalizzazione"), res.getInt("colpo_di_testa"), res.getInt("passaggio_corto"), res.getInt("passaggio_lungo"), 
							res.getInt("skill_dribling"), res.getInt("controllo_palla"), res.getInt("potenza_tiro"), res.getInt("potenza_tiro_lontano"),
							res.getInt("mentalita_rigori"));
					
					Difesa difesa = new Difesa(res.getInt("difesa"), res.getInt("salto"), res.getInt("forza"),res.getInt("bilanciamento"), res.getInt("aggressivita"),  
							res.getInt("mentalita_aggressiva"), res.getInt("mentalita_intercetto"), res.getInt("interesse_difensivo"),res.getInt("takle"),
							res.getInt("scivolamento_difensivo"), res.getInt("tuffo_portiere"),res.getInt("mani_portiere"),res.getInt("calcio_portiere"),
							res.getInt("posizionamento_portiere"), res.getInt("riflessi_portiere"),res.getInt("velocita_portiere"));
					
					Giocatore g = new Giocatore(res.getInt("fifa_id"), res.getString("nome_corto"), res.getString("nome_lungo"),
							res.getString("ruolo"), res.getInt("overall"), res.getInt("valore_euro"), res.getInt("stipendio"),
							res.getInt("eta"), res.getInt("altezza_cm"), res.getDouble("peso_kg"), res.getString("squadra_attuale"),
							res.getString("campionato_attuale"), res.getInt("numero_maglia"), res.getString("nazione"), res.getString("piede_preferito"), res.getInt("piede_debole"),
							res.getInt("stelle_skill"), res.getInt("clausola_rescissoria"), attacco, difesa);
					
					result.add(g);
					
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	public List<Giocatore> getCentrocampisti(){
		String sql = "SELECT * FROM giocatore WHERE ruolo = 'C' " ;
		try {
			Connection conn = ConnectDB.getConnection() ;
			List<Giocatore> result = new ArrayList<>();
			PreparedStatement st = conn.prepareStatement(sql) ;
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				
					Attacco attacco = new Attacco(res.getInt("tiro"), res.getInt("passaggio"), res.getInt("dribling"),res.getInt("cross"), 
							res.getInt("finalizzazione"), res.getInt("colpo_di_testa"), res.getInt("passaggio_corto"), res.getInt("passaggio_lungo"), 
							res.getInt("skill_dribling"), res.getInt("controllo_palla"), res.getInt("potenza_tiro"), res.getInt("potenza_tiro_lontano"),
							res.getInt("mentalita_rigori"));
					
					Difesa difesa = new Difesa(res.getInt("difesa"), res.getInt("salto"), res.getInt("forza"),res.getInt("bilanciamento"), res.getInt("aggressivita"),  
							res.getInt("mentalita_aggressiva"), res.getInt("mentalita_intercetto"), res.getInt("interesse_difensivo"),res.getInt("takle"),
							res.getInt("scivolamento_difensivo"), res.getInt("tuffo_portiere"),res.getInt("mani_portiere"),res.getInt("calcio_portiere"),
							res.getInt("posizionamento_portiere"), res.getInt("riflessi_portiere"),res.getInt("velocita_portiere"));
					
					Giocatore g = new Giocatore(res.getInt("fifa_id"), res.getString("nome_corto"), res.getString("nome_lungo"),
							res.getString("ruolo"), res.getInt("overall"), res.getInt("valore_euro"), res.getInt("stipendio"),
							res.getInt("eta"), res.getInt("altezza_cm"), res.getDouble("peso_kg"), res.getString("squadra_attuale"),
							res.getString("campionato_attuale"), res.getInt("numero_maglia"), res.getString("nazione"), res.getString("piede_preferito"), res.getInt("piede_debole"),
							res.getInt("stelle_skill"), res.getInt("clausola_rescissoria"), attacco, difesa);
					
					result.add(g);
					
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	public List<Giocatore> getAttaccanti(){
		String sql = "SELECT * FROM giocatore WHERE ruolo = 'A' " ;
		try {
			Connection conn = ConnectDB.getConnection() ;
			List<Giocatore> result = new ArrayList<>();
			PreparedStatement st = conn.prepareStatement(sql) ;
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				
				
					Attacco attacco = new Attacco(res.getInt("tiro"), res.getInt("passaggio"), res.getInt("dribling"),res.getInt("cross"), 
							res.getInt("finalizzazione"), res.getInt("colpo_di_testa"), res.getInt("passaggio_corto"), res.getInt("passaggio_lungo"), 
							res.getInt("skill_dribling"), res.getInt("controllo_palla"), res.getInt("potenza_tiro"), res.getInt("potenza_tiro_lontano"),
							res.getInt("mentalita_rigori"));
					
					Difesa difesa = new Difesa(res.getInt("difesa"), res.getInt("salto"), res.getInt("forza"),res.getInt("bilanciamento"), res.getInt("aggressivita"),  
							res.getInt("mentalita_aggressiva"), res.getInt("mentalita_intercetto"), res.getInt("interesse_difensivo"),res.getInt("takle"),
							res.getInt("scivolamento_difensivo"), res.getInt("tuffo_portiere"),res.getInt("mani_portiere"),res.getInt("calcio_portiere"),
							res.getInt("posizionamento_portiere"), res.getInt("riflessi_portiere"),res.getInt("velocita_portiere"));
					
					Giocatore g = new Giocatore(res.getInt("fifa_id"), res.getString("nome_corto"), res.getString("nome_lungo"),
							res.getString("ruolo"), res.getInt("overall"), res.getInt("valore_euro"), res.getInt("stipendio"),
							res.getInt("eta"), res.getInt("altezza_cm"), res.getDouble("peso_kg"), res.getString("squadra_attuale"),
							res.getString("campionato_attuale"), res.getInt("numero_maglia"), res.getString("nazione"), res.getString("piede_preferito"), res.getInt("piede_debole"),
							res.getInt("stelle_skill"), res.getInt("clausola_rescissoria"), attacco, difesa);
					
					result.add(g);
					
			}
			
			conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}	*/
	
	
}
