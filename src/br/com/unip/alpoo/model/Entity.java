package br.com.unip.alpoo.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

abstract public class Entity {

	

	
	public abstract void setPreparement(PreparedStatement prep) throws SQLException;
}
