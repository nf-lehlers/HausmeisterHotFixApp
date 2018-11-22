package itech.db.mapper;

import java.sql.ResultSet;

import itech.hotfix.Atmospherics;

public class AtmosphericsMapper {

	
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
}
