package br.com.raulivan.conexaodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Raulivan
 * @version 1.0
 * 
 * Classe de conexão com o banco de dados
 *
 */
public class JConnectionfactory {

	/**
	 * Váriavel que armazena a conexão
	 */
	private static Connection _connection;
	
	/**
	 * Método que retorna uma conexão com o banco de dados
	 * @param sgbd - Tipo de Banco de Dados
	 * @return Conexão com o Banco de dados
	 * @throws SQLException
	 * @throws Exception
	 * 
	 */
	public static Connection getConnection(TipoSGBD sgbd)  throws SQLException, Exception {
		
		if(_connection != null)
			return _connection;
		
		switch (sgbd) {
			case  MSSQL :
				return conectarSQLServer();
			case  MYSQL :
				return conectarMySQL();
			default:
				throw new Exception("Tipo de SGBD inválido");
			}
	}
	 

	/**
	 * Méto de conexão com o banco de dados Sql Server
	 * @return Conexão
	 * @throws SQLException
	 * @throws Exception
	 */
   private static Connection conectarSQLServer() throws SQLException, Exception{  
	   
	   String banco = "AGENDA_JAVA";  
	   String usuario = "sa";
	   String senha = "123456";
	   String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	   String servidor = "DESKTOP-F75NQ86\\SQLEXPRESS";  
	   Class.forName(driver);   
	   _connection = DriverManager.getConnection("jdbc:sqlserver://" 
			   + servidor + ";databaseName=" + banco, usuario, senha);  
     return _connection;  
   }  
   
   /**
    * Método que retorna uma conexão com o banco de dados My Sql
    * @return
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   private static Connection conectarMySQL() throws SQLException, ClassNotFoundException {  
       String banco = "AGENDA_JAVA"; 
       String usuario = "root";  
       String senha = "root"; 
       String driver = "com.mysql.jdbc.Driver";  
       String servidor = "localhost";  
       Connection conn;  
       Class.forName(driver);  
       conn = DriverManager.getConnection("jdbc:mysql://" 
    		   + servidor + ":3306/" + banco, usuario, senha);  
	   return conn;  
   }  
   
   /**
    * Fecha a conexão com o banco de dados
    * @throws SQLException
    */
   public static void fecharConexao() throws SQLException {
	   _connection.close();
   }
   
}





