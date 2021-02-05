package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Frequenta;

public class FrequentaDao {
	public void inserisciFrequenta(Frequenta f) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "INSERT INTO frequenta(id, idCorso,idDipendente,idIstruttore) VALUES(?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, f.getId());
			cmd.setInt(2, f.getIdCorso());
			cmd.setInt(3, f.getIdDipendente());
			cmd.setInt(4, f.getIdIstruttore());
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Frequenta> ritornaListaFrequenta() {
		List<Frequenta> l1 = new ArrayList<>();
		try {
		DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
		Connection dbConnection = ds.getConnection();
		java.sql.PreparedStatement cmd = null;
		String query = "SELECT * FROM frequenta";
		cmd = dbConnection.prepareStatement(query);
		// execute update SQL statement
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		while(esci) {
			Frequenta nuovo = new Frequenta(res.getInt("id"),res.getInt("idCorso"),res.getInt("idDipendente"),res.getInt("idIstruttore"));
			l1.add(nuovo);
			esci = res.next();
		}
		cmd.close();
		dbConnection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l1;
	}
	
	public Frequenta ritornaFrequenta(int id) {
		Frequenta nuovo = null;
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String query = "SELECT * FROM clienti WHERE id=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			// execute update SQL statement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
			nuovo = new Frequenta(res.getInt("id"),res.getInt("idCorso"),res.getInt("idDipendente"),res.getInt("idIstruttore"));
			}else {nuovo= new Frequenta(0,0,0,0);}
			cmd.close();
			dbConnection.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nuovo;
	}

	public void aggiornaFrequenta(Frequenta f) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "UPDATE frequenta SET idIstruttore=?, idCorso=?,idDipendente=? WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, f.getIdIstruttore());
			cmd.setInt(2, f.getIdCorso());
			cmd.setInt(3, f.getIdDipendente());
			cmd.setInt(4, f.getId());
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancellaFrequenta(Frequenta f) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "DELETE FROM frequenta WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, f.getId());
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
