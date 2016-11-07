package br.com.unip.alpoo.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.unip.alpoo.model.Entity;

public abstract class DAOConnect {
	private final  static Connection connection = DAOConnect.buildConnection();  
	
	protected String[] attributes;
	protected int totalFields;
	protected String table;
	
	protected static Connection buildConnection(){
		try {
			 
			// Carregando o JDBC Driver padrão
			 
			String driverName = "com.mysql.jdbc.Driver";                        
			 
			Class.forName(driverName);
			 
			  
			 
			// Configurando a nossa conexão com um banco de dados//
			 
            String serverName = "localhost";    //caminho do servidor do BD
 
            String mydatabase ="alpoo";        //nome do seu banco de dados
 
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
 
            String username = "root";        //nome de um usuário de seu BD      
 
            String password = "root";      //sua senha de acesso
			            
			 
            Connection connection = DriverManager.getConnection(url, username, password);
			 
			  
			 
	        //Testa sua conexão//  
	 
            if (connection != null) {
 
                return connection;
 
            } else {
 
                throw new SQLException("Não foi possível criar uma conexão");
 
            }
			 
			  
			 
        } catch (ClassNotFoundException e) {  //Driver não encontrado
 
  
 
            System.out.println("O driver expecificado nao foi encontrado.");
 
            return null;
 
        } catch (SQLException e) {
        //Não conseguindo se conectar ao banco
			 
        	System.out.println(e.getMessage());
//            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
 
            return null;
 
        }
	}
	
	protected Connection getConnection(){
		try {
			if(this.connection.isClosed()){
				return this.buildConnection();
			}else{
				return this.connection;
			}
		} catch (SQLException e) {
			
			return this.buildConnection();
		}
		
	}
	
	abstract public boolean save(Entity obj);
	
	protected String getFields(){
		
		String fieldString = "";
		for(String field : this.attributes){
			fieldString += field + ",";
		}
		
		String pattern = "\\,$";
		fieldString = fieldString.replaceAll(pattern,"");
		
		return fieldString;
	}
	
	
	protected String convertStatementsField(){
		String statements = "(";
		
		for(int i = 0; i < this.totalFields; i++){
			statements +=  "?,";
		}
		String pattern = "\\,$";
		statements = statements.replaceAll(pattern,"");
		statements += ")";
		
		
		
		return statements;
	}
	
	/**
	 * @desc Executa o código ao dar boot
	 */
	abstract protected void boot();
	abstract protected List<?> all();
	
	
	
}
