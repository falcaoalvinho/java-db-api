package br.edu.senaisp.controller;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;

import br.edu.senaisp.dao.ClienteDAO;
import br.edu.senaisp.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/TesteAPI")
public class Teste extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("POSTOU GOSTOSO");
		
		BufferedReader br = req.getReader();
		
		String json = "";
		String linha = "";
		
		while ((linha = br.readLine()) != null) {
			json += linha;
		}
		
		Gson gson 		= new Gson();
		Cliente cliente = gson.fromJson(json, Cliente.class);
		ClienteDAO dao 	= new ClienteDAO();
		dao.novo(cliente);
		
		resp.getWriter().append("\nEIIIIITA COMO POSTA");
	}
	
}
