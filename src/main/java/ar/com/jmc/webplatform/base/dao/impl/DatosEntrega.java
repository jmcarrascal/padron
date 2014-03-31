/*
 * Usuarios.java
 *
 * Created on 21 de septiembre de 2003, 12:14
 */

package ar.com.jmc.webplatform.base.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.jmc.webplatform.base.model.Entrega;
import ar.com.jmc.webplatform.base.model.Padron;


/**
 *
 * @author  JMC y Andres Yebra
 */
public class DatosEntrega {
    
    public DatosEntrega() {
    	try {
			this.setConnNueva(getConnection()) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private Connection connNueva; 
    
    public Connection getConnNueva() {
		return connNueva;
	}



	public void setConnNueva(Connection connNueva) {
		this.connNueva = connNueva;
	}



	public Connection getConnection() throws Exception {

    String system           = "192.168.0.100";
    String collectionName   = "LIBIVASG1";
    String tableName        = "DD.CLI";
    System.out.println(system);

    Connection connection   = null;

    try {
        
        Class.forName("com.ibm.as400.access.AS400JDBCDriver");	
        
        connection = DriverManager.getConnection ("jdbc:as400://"
        + system + "/" + collectionName,"qsecofer","c2259");
         
        return connection;
    }catch(Exception e){
        System.out.println(e.toString());
    }  
    return connection;
    }

    
    public void updatePadron(List<Padron> padronList){
        try{
        Connection con = getConnNueva();      
        for(Padron padron : padronList){
	        PreparedStatement pstmt = con.prepareStatement("update \"DD.CLI\" set CLPOLI = ? where CLCUIT = ?");
	        pstmt.setDouble(1, padron.getAlicuota());
	        pstmt.setString(2, padron.getCuit());    
	        pstmt.executeUpdate();
	        pstmt.close();
        }
        }
        catch(Exception e){
        	e.printStackTrace();
        }
    }
}
