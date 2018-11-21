package itech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.skife.jdbi.v2.DBI;

import io.dropwizard.db.DataSourceFactory;
import itech.db.mapper.AtmosphericsMapper;
import itech.hotfix.Atmospherics;

public class DbRequests {

	private static DataSourceFactory dbf;
	private final static String insertAtmospherics = "INSERT INTO Atmospherics (Timestamp, Temperature, Humidity, CO2) VALUES";
	
	public void init(DataSourceFactory dsf) {
		this.dbf = dsf;
	}
	
	private static ResultSet connect(String query) {
		
		String host = "";
		String db = "";
		String u = dbf.getUser();
		String pw = dbf.getPassword();
		
		String url = String.format("jdbc:sqlserver://%s:1433;"
        		+ "database=%s;"
        		+ "user=%s;"
        		+ "password=%s;"
        		+ "encrypt=true;"
        		+ "trustServerCertificate=false;"
        		+ "hostNameInCertifcate=*.database.windows.net;"
        		+ "loginTimeout=30;", host, db, u, pw);
		
		// sql verbindung
		url = String .format("jdbc:mysql://%s", dbf.getUrl());
		
		try {
			Connection c = DriverManager.getConnection(url);
			
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(query);
			
			return r;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public static void insertAtmospheric(Atmospherics a) {
		
		String query = insertAtmospherics + "("+a.getTimestamp()+","+a.getTemperature()+","+a.getHumidity()+","+a.getCo2()+")";
		
		ResultSet rs = connect(query);
		
	}
	
	public Atmospherics getAtmospherics() {
		String query = "SELECT * FROM Atmospherics WHERE ";
		
		ResultSet rs = connect(query);
		
		Atmospherics a = AtmosphericsMapper.map(rs);
		
		return a;
		
	}
}
