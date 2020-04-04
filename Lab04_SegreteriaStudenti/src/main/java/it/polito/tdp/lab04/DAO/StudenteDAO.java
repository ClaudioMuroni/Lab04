package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public Studente cercaStudByMatr(int matrn) {
		// TODO Auto-generated method stub
		
		final String sql = "SELECT * FROM studente\r\n" + 
				"WHERE matricola=?";
		Studente s = null;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, matrn);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int m = rs.getInt(1);
				String c = rs.getString(2);
				String n = rs.getString(3);
				String cds = rs.getString(4);
				
				s = new Studente(m, c, n, cds);
			}
			
			conn.close();
		}catch(SQLException e) {
			
			throw new RuntimeException("Errore Db", e);
		}
				
				
		return s;
	}

}
