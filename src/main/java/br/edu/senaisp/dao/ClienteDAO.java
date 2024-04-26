//CLASSE QUE RELACIONA CONEXÕES DO BANCO A OBJETOS DO TIPO CLIENTE
package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.edu.senaisp.model.Carro;
import br.edu.senaisp.model.Cliente;

public class ClienteDAO{
	
	//COMANDO SQL DE INSERT PARA CLIENTE
	private final String SQLINSERT = "INSERT INTO cliente (nome, cpf) VALUES (?, ?)";
	
	//MÉTODO QUE GERE UM NOVO CLIENTE DAO
	public int novo(Cliente cliente) {
		int id = 0;
		try {
			Connection con = dao.conexao();

			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getCpf());

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

	public int novoCompleto(Cliente cliente) {
		int id = 0;
		try {
			Connection con = dao.conexao();
			
			con.setAutoCommit(false);
			
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getCpf());

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
				
				CarroDAO carroDao = new CarroDAO();
				
				for (Carro carro : cliente.getCarros()) {
					carro.setProprietario(cliente);
					carroDao.novo(carro, con);
				}
				con.commit();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
}

