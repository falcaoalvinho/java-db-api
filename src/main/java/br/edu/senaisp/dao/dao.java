//CLASSE PARA CRIAR CONEXÕES COM O BANCO DE DADOS
package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dao {
	
	public static Connection conexao() throws SQLException, ClassNotFoundException {
		//DRIVER E ENDEREÇO USADOS
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";

		//INFROMAÇÕES PARA ACESSO DO BANCO
		String dbName = "garagem";
		String dbUsername = "root";
		String dbPassword = "root";
		
		//ATRIBUIÇÃO DOS VALORES PARA CRIAÇÃO DE UMA CONEXÃO
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		return con;
	}
}
