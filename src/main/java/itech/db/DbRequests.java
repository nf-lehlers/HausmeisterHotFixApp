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

import com.google.common.util.concurrent.Service.State;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import io.dropwizard.db.DataSourceFactory;
import itech.db.mapper.AtmosphericsMapper;
import itech.hotfix.Atmospherics;

public class DbRequests {

	private static DataSourceFactory dbf;
	private final static String insertAtmospherics = "INSERT INTO Atmospherics (Timestamp, Temperature, Humidity, CO2) VALUES ";
	private final static String selectAtmospherics = "SELECT * FROM Atmospherics ";
	
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
	 * Führt eine Insert oder Update Query durch
	 * @param s - Statement
	 * @param query - Query String 
	 * @return
	 */
	private static Integer insert(Statement s, String query) {
		try {
			return s.executeUpdate(query);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Führt eine Select Query durch
	 * @param s - Statement
	 * @param query - Query String
	 * @return
	 */
	private static ResultSet query(Statement s, String query) {
		try {
			return s.executeQuery(query);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	/**
	 * Fügt einen Atmospherics Datensatz der DB hinzu
	 * @param a
	 */
	public static void insertAtmospheric(Atmospherics a) {
		
		String query = insertAtmospherics + "('"+a.getTimestamp()+"',"+a.getTemperature()+","+a.getHumidity()+","+a.getCo2()+")";
		
		Statement s = connect();
		
		insert(s, query);
		
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
		
		insert(s, query);
		
		closeConnection(s);
	}
	
	/**
	 * Lädt alle Atmospherics Daten aus der DB
	 * @return
	 */
	public static List<Atmospherics> loadAllAtmospherics() {
		String query = selectAtmospherics;
		
		Statement s = connect();
		ResultSet rs = query(s, query);

		List<Atmospherics> al = AtmosphericsMapper.mapList(rs);
		
		closeConnection(s);
		
		return al;
	}
	
	public static List<Atmospherics> loadAtmosphericsForToday() {
		String query = selectAtmospherics + "WHERE DATE(Timestamp) = CURDATE()";
		
		Statement s = connect();
		ResultSet rs = query(s, query);
		
		List<Atmospherics> al = AtmosphericsMapper.mapList(rs);
		
		closeConnection(s);
		
		return al;
	}
	
	public static List<Atmospherics> loadAtmosphericsForYesterday() {
		String query = selectAtmospherics + "WHERE DATE(Timestamp) = CURDATE() - 1";
		
		Statement s = connect();
		ResultSet rs = query(s, query);
		
		List<Atmospherics> al = AtmosphericsMapper.mapList(rs);
		
		closeConnection(s);
		return al;
	}
	
	public static List<Atmospherics> loadAtmosphericsForLastMonth() {
		String query  = selectAtmospherics + "WHERE MONTH(Timestamp) = MONTH(NOW()) AND YEAR(Timestamp) = YEAR(NOW())";
		
		Statement s = connect();
		ResultSet rs = query(s, query);
		
		List<Atmospherics> al = AtmosphericsMapper.mapList(rs);
		
		closeConnection(s);
		return al;
	}
}
