package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Istruttore;

public class IstruttoreDao {
	public void inserisciIstruttore(Istruttore i) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "INSERT INTO istruttore(matricola,nome, cognome,codiceFiscale) VALUES(?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, i.getMatricola());
			cmd.setString(2, i.getNome());
			cmd.setString(3, i.getCognome());
			cmd.setString(4, i.getCodiceFiscale());
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
	
	public List<Istruttore> ritornaListaIstruttore() {
		List<Istruttore> l1 = new ArrayList<>();
		try {
		DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
		Connection dbConnection = ds.getConnection();
		java.sql.PreparedStatement cmd = null;
		String query = "SELECT * FROM istruttore";
		cmd = dbConnection.prepareStatement(query);
		// execute update SQL statement
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		while(esci) {
			Istruttore nuovo = new Istruttore(res.getInt("matricola"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
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
	
	public Istruttore ritornaIstruttore(int id) {
		Istruttore nuovo = null;
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String query = "SELECT * FROM clienti WHERE matricola=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			// execute update SQL statement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
			nuovo = new Istruttore(res.getInt("matricola"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
			}else {nuovo= new Istruttore(0,"Istruttore","Non","Trovato");}
			cmd.close();
			dbConnection.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nuovo;
	}

	public void aggiornaIstruttore(Istruttore i) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "UPDATE istruttore SET nome=?, cognome=?,codiceFiscale=? WHERE matricola=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, i.getNome());
			cmd.setString(2, i.getCognome());
			cmd.setInt(4, i.getMatricola());
			cmd.setString(3, i.getCodiceFiscale());
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

	public void cancellaIstruttore(Istruttore i) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "DELETE FROM istruttore WHERE matricola=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, i.getMatricola());
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
