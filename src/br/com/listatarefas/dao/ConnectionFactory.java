package br.com.listatarefas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection;
	private static int qtdeVezesConectado;
	
	private ConnectionFactory() {
		
		// singleton
		
	}
	
	public static Connection getConnection() {
		
	//	if (connection == null) {
			abreConexao();
		//}
		
		return connection;
		
	}
	
	private static void abreConexao() {
		
		
        String servidor = "YOUR_SERVER_IP"; 
        String porta = "SERVER_PORT";
        String dataBase = "DATABASE_NAME";

		
		try {
			
	   	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	  
	        String connectionUrl = "jdbc:sqlserver://" + servidor + ":" + porta + ";" +
	                             "databaseName="+ dataBase +";user=SERVER_USERNAME;password=SERVER_PASSWORD";			
			
			connection = DriverManager.getConnection(connectionUrl);
			qtdeVezesConectado ++;
			
			System.out.println("Qtde Vezes Conectado: " + qtdeVezesConectado);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println("Falha ao acessar o banco de dados. \n" + 
						       "Poss�veis Causas: \n\n" +
						       "- Seu computador n�o est� conectado � internet.\n" + 
						       "- O Servidor n�o est� dispon�vel.\n\n" + 
					           "Verifique os itens acima e tente novamente\n" + 
						       e.toString());
			
		}
	
	}
	
}
