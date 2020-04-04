package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO corsoDAO = new CorsoDAO();
	StudenteDAO studenteDAO = new StudenteDAO();
	
	public List<Corso> getTuttiICorsi() {
		
		return corsoDAO.getTuttiICorsi();
	}

	public Studente cercaStudByMatr(String matrs) {
		// TODO Auto-generated method stub
		
		int matrn;
		try {
			matrn = Integer.parseInt(matrs);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return studenteDAO.cercaStudByMatr(matrn);
	}

}
