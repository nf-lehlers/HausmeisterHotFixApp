package itech.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import itech.hotfix.Atmospherics;

public class AtmosphericsMapper {

	/**
	 * Mappt eine ResultSet auf eine Atmospherics Object
	 * @param rs
	 * @return
	 */
	public static Atmospherics map(ResultSet rs) {
		Atmospherics a = new Atmospherics();
		
		try {
			a.setTimestamp(rs.getTimestamp("Timestamp"));
			a.setTemperature(rs.getBigDecimal("Temperature"));
			a.setHumidity(rs.getBigDecimal("Humidity"));
			a.setCo2(rs.getBigDecimal("CO2"));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return a;
	}
	
	/**
	 * Mappt ein ResultSet auf eine Liste von Atmospherics
	 * @param rs
	 * @return
	 */
	public static List<Atmospherics> mapList(ResultSet rs) {
		List<Atmospherics> al = new ArrayList<>();
		
		try {
			if(!rs.isBeforeFirst()) {
				return al;
			} else {
				rs.next();
			}
			
			while(!rs.isAfterLast()){
				
				al.add(map(rs));
				
				rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
}
