package itech.db.mapper;

import java.sql.ResultSet;

import itech.hotfix.Atmospherics;

public class AtmosphericsMapper {

	
	public static Atmospherics map(ResultSet rs) {
		Atmospherics a = new Atmospherics();
		
		try {
			a.setTimestamp(rs.getTimestamp("Timestamp").toLocalDateTime());
			a.setTemperature(rs.getDouble("Temperature"));
			a.setHumidity(rs.getDouble("Humidity"));
			a.setCo2(rs.getDouble("CO2"));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return a;
	}
}
