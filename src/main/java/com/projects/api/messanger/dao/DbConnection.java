package com.projects.api.messanger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projects.api.messanger.model.Message;
import com.projects.api.messanger.model.UserProfiles;

public class DbConnection {
	
	public Statement stmnt = null;
    public ResultSet rows = null;
   public Connection con = null;
   public PreparedStatement pstmnt =null; 
   public static String username = "root";
   public static String password = "";
   public static  String url = "jdbc:mysql://localhost:3306/messanger";
    
 /*   public Connection dbConnector() {

     
        try {
        	
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Connection successfull");
            } else {
                System.out.println("Connection not successfull");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {

            ex.printStackTrace();

        }

        return con;

    }*/
    
 /*   public List<Message> viewAllMessages()
    {
    	String query = "select message,user_id,created_date from message";
    	con = dbConnector();
    	if(con == null)
    	{
    		System.out.println("null");
    	}
    	Message msgInstance = new Message();
    	List<Message> msgBean = null;
    	try {
			pstmnt = con.prepareStatement(query);
			rows = pstmnt.executeQuery();
			msgBean = new ArrayList<Message>();
			while(rows.next())
			{
				msgInstance.setMessage(rows.getString("message"));
				msgInstance.setCreatedDte(rows.getDate("created_date"));
				//msgInstance.setSender(rows.getInt("user_id"));
			}
			msgBean.add(msgInstance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return msgBean;
    }*/ 
   private static Map<Long, Message> messages = new HashMap<>();
   private static Map<String, UserProfiles> profiles = new HashMap<>();
   
   public static Map<Long, Message> getMessages()
   {
	   return messages;
   }
   public static Map<String, UserProfiles> getProfiles()
   {
	   return profiles;
   }
   
   

}
