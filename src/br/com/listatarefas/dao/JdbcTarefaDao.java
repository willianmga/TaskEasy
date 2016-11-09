package br.com.listatarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.listatarefas.model.Tarefa;

public class JdbcTarefaDao {
	
	private Connection connection;
	
	public JdbcTarefaDao() {
		
		this.connection = ConnectionFactory.getConnection();
		
	}

	public void inserir(Tarefa obj) {

		try {
			
			String sql = "Insert into Tarefa (descricao, finalizado, dataFinalizacao)" +  
				         "values (?,null,null)";			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, obj.getDescricao());
			//stmt.setBoolean(3, obj.isFinalizado());
			//stmt.setDate(3, new Date(obj.getDataFinalizacao().getTimeInMillis()));
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("SQLExeption: " + e.toString());
			e.printStackTrace();
			
		}
		
	}

	public void alterar(Tarefa obj) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Tarefa obj) {
		// TODO Auto-generated method stub
		
	}

	public List<Tarefa> getAll() {

		try {
			
			PreparedStatement stmt = connection.prepareStatement("Select * from Tarefa");
			ResultSet rs = stmt.executeQuery();
			
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			
			while (rs.next()) {
				
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				try {
					
					Calendar dataFinalizado = Calendar.getInstance();
					dataFinalizado.setTime(rs.getDate("dataFinalizacao"));
					tarefa.setDataFinalizacao(dataFinalizado);
					
				} catch(NullPointerException e) {
					tarefa.setDataFinalizacao(Calendar.getInstance());
				}

				tarefas.add(tarefa);
				
			}
			
			rs.close();
			stmt.close();			
			
			return tarefas;
			
		} catch(SQLException e) {

			e.printStackTrace();
			return new ArrayList<Tarefa>();
			
		}

	}

	public Tarefa getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
