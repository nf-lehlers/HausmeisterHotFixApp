package itech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.skife.jdbi.v2.DBI;

import io.dropwizard.db.DataSourceFactory;
import itech.db.mapper.AtmosphericsMapper;
import itech.hotfix.Atmospherics;

public class DbRequests {

	private static DataSourceFactory dbf;
	private final static String insertAtmospherics = "INSERT INTO Atmospherics (Timestamp, Temperature, Humidity, CO2) VALUES";
	
	public static void init(DataSourceFactory dsf) {
		dbf = dsf;
	}
	
	/**
	 * Erstellt eine Datenbank verbindung
	 * @return
	 */
	private static Statement connect() {
		
		String host = "";
		String db = "";
		String u = dbf.getUser();
		String pw = dbf.getPassword();
		
//		String url = String.format("jdbc:sqlserver://%s:1433;"
//        		+ "database=%s;"
//        		+ "user=%s;"
//        		+ "password=%s;"
//        		+ "encrypt=true;"
//        		+ "trustServerCertificate=false;"
//        		+ "hostNameInCertifcate=*.database.windows.net;"
//        		+ "loginTimeout=30;", host, db, u, pw);
		
		// sql verbindung
		
		Properties conProps = new Properties();
		conProps.put("user", "root@localhost");
		
		String url = "jdbc:mysql://"+dbf.getUrl()+":3306/HausmeisterHotFix";
		
		try {
			
			Connection c = DriverManager.getConnection(url, "root", null);
			
			return c.createStatement();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private static void closeConnection(Statement s) {
		try {
			Connection c = s.getConnection();
			c.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Fügt einen Atmospherics Datensatz der DB hinzu
	 * @param a
	 */
	public static void insertAtmospheric(Atmospherics a) {
		
		String query = insertAtmospherics + "('"+a.getTimestamp()+"',"+a.getTemperature()+","+a.getHumidity()+","+a.getCo2()+")";
		
		Statement s = connect();
		
		try {
			s.executeUpdate(query);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		closeConnection(s);
	}
	
	/**
	 * Fügt eine Liste von Atmospherics Datensätzen der DB hinzu
	 * @param al
	 */
	public static void insertAtmospheric(List<Atmospherics> al) {
		String query = insertAtmospherics;
		Iterator<Atmospherics> atmoIter = al.iterator();
		while(atmoIter.hasNext()) {
			Atmospherics a = atmoIter.next();
			query = query + "('" + a.getTimestamp() + "'," + a.getTemperature() + "," + a.getHumidity() + "," + a.getCo2() + ")";
			if(atmoIter.hasNext()) query = query + ",";
		}
		
		Statement s = connect();
		
		try {
			s.executeUpdate(query);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		closeConnection(s);
	}
	
	/**
	 * Lädt alle Atmospherics Daten aus der DB
	 * @return
	 */
	public static List<Atmospherics> loadAllAtmospherics() {
		String query = "SELECT * FROM Atmospherics";
		
		Statement s = connect();
		ResultSet rs = null;
		
		try {
			rs = s.executeQuery(query);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		List<Atmospherics> al = new ArrayList<>();
		
		try {
			if(rs.isBeforeFirst()) {
				rs.next();
			}
			
			while(!rs.isAfterLast()){
				
				al.add(AtmosphericsMapper.map(rs));
				
				rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection(s);
		
		return al;
	}
}
