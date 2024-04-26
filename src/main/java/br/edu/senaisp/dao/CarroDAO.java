package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.senaisp.model.Carro;

public class CarroDAO {
	
	private final String SQLINSERT = "INSERT INTO carro (marca, modelo, proprietario) VALUES(?, ?, ?)";
	 
	public int novo(Carro carro) {
		int id=-1;
		try {
			Connection con = dao.conexao();
 
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);
 
				ps.setString(1, carro.getMarca());
				ps.setString(1, carro.getModelo());
				ps.setInt(3, carro.getProprietario().getId());
 
				ps.execute();
 
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
			}
 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}	
	
	public int novo(Carro carro, Connection con) throws SQLException {
		int id=-1;
 
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);
 
				ps.setString(1, carro.getMarca());
				ps.setString(1, carro.getModelo());
				ps.setInt(3, carro.getProprietario().getId());
 
				ps.execute();
 
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
			}
 
		return id;
		
	}
}
