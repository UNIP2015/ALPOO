package br.com.unip.alpoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import br.com.unip.alpoo.model.Curso;
import br.com.unip.alpoo.model.Entity;

public class DAOCurso extends DAOConnect {
	
	public DAOCurso() {
		super.getConnection();
		
		this.table = "curso";
			
		this.attributes = new String[4];
		this.attributes[0] = "NOME";
		this.attributes[1] = "TIPO";
		this.attributes[2] = "CARGA";
		this.attributes[3] = "COD_INSTITUTO";
		
		this.totalFields = this.attributes.length;
		
	}

	@Override
	public boolean save(Entity e) {
		this.boot();
		
		Curso c = (Curso) e;
		String sql = "INSERT INTO "+this.table+" ("+this.getFields()+") values" + this.convertStatementsField();
		Connection conn = this.getConnection();
		
		System.out.println(sql);
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, c.getNome());
			preparedStmt.setString(2, c.getTipo());
			preparedStmt.setString(3, c.getCargaHoraria() +"");
			preparedStmt.setString(4, c.getCodInstitulo() + "");
			preparedStmt.execute();
		      conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		
		
		
		return false;
	}

	@Override
	protected void boot() {
		String sql = "CREATE TABLE IF NOT EXISTS "+this.table;
		sql += "(";
		sql += "ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,";
		for(String field : this.attributes){
			sql += field + " VARCHAR(255) NOT NULL,";
		}
		String pattern = "\\,$";
		sql = sql.replaceAll(pattern,"");
		
		sql += ");";
		
		try {
			PreparedStatement pre = this.getConnection().prepareStatement(sql);
			pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Curso> all() {
		Connection conn = this.getConnection();
		List<Curso> ls = new ArrayList<Curso>();
		try {
			Statement state = conn.createStatement();
			String sql = "SELECT * FROM "+this.table;
			ResultSet rs = state.executeQuery(sql);
			
			
			while (rs.next())
		    {
				Curso c = new Curso();
				c.setNome(rs.getString("NOME"));
				c.setCargaHoraria(rs.getString("CARGA"));
				c.setCodInstitulo(rs.getInt("COD_INSTITUTO"));
				c.setTipo(rs.getString("TIPO"));
				c.setId(rs.getInt("ID"));
				ls.add(c);
		    }
			
			return ls;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return ls;
	}

	
	
	
	
	
	
	
	
}
