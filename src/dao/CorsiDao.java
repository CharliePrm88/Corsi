package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Corsi;

public class CorsiDao {
	
	public void inserisciCorsi(Corsi c) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "INSERT INTO listacorsi(id, nome,data_inizio,data_fine) VALUES(?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, c.getId());
			cmd.setString(2, c.getNome());
			cmd.setDate(3, c.getData_inizio());
			cmd.setDate(4, c.getData_fine());
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
	
	public List<Corsi> ritornaListaCorsi() {
		List<Corsi> l1 = new ArrayList<>();
		try {
		DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
		Connection dbConnection = ds.getConnection();
		java.sql.PreparedStatement cmd = null;
		String query = "SELECT * FROM listacorsi";
		cmd = dbConnection.prepareStatement(query);
		// execute update SQL statement
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		while(esci) {
			Corsi nuovo = new Corsi(res.getInt("id"),res.getString("nome"),res.getDate("data_inizio"),res.getDate("data_fine"));
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
	
	public Corsi ritornaCorsi(int id) {
		Corsi nuovo = null;
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String query = "SELECT * FROM listacorsi WHERE id=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			// execute update SQL statement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
				nuovo = new Corsi(res.getInt("id"),res.getString("nome"),res.getDate("data_inizio"),res.getDate("data_fine"));
			}else {nuovo= new Corsi(0,"Corso non trovato",null,null);}
			cmd.close();
			dbConnection.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nuovo;
	}

	public void aggiornaCorsi(Corsi c) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "UPDATE listacorsi SET nome=?, data_inizio=?,data_fine=? WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, c.getNome());
			cmd.setDate(2, c.getData_inizio());
			cmd.setDate(3, c.getData_fine());
			cmd.setInt(4, c.getId());
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

	public void cancellaCorsi(Corsi c) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/corsi");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "DELETE FROM listacorsi WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, c.getId());
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
