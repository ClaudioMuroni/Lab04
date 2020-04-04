package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				
				Corso c = new Corso(codins, numeroCrediti, nome, periodoDidattico);
				corsi.add(c);
			}

			conn.close();
			
			return corsi;
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e); //Copiata
		}
	}
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO IGNORARE
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
		
		final String sql = "SELECT s.matricola, s.cognome, s.nome, s.cds, c.nome FROM studente AS s, iscrizione AS i, corso AS c\r\n" + 
				"WHERE s.matricola=i.matricola AND i.codins=c.codins AND c.nome=?";
		
		List<Studente> list = new ArrayList<Studente>();
		Studente s;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, corso.getNome());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int m = rs.getInt(1);
				String c = rs.getString(2);
				String n = rs.getString(3);
				String cds = rs.getString(4);
				
				s = new Studente(m, c, n, cds); 
				
				list.add(s);
			}
			
			conn.close();
			
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e); //Copiata
		}
		
		return list;
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
