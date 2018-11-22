package itech.hotfix;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Luka 19.11.18
 */
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class Atmospherics implements Serializable {

	private static final long serialVersionUID = 1L;

	private Timestamp timestamp;
	private BigDecimal temperature;
	private BigDecimal humidity;
	private BigDecimal co2;
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public BigDecimal getTemperature() {
		return temperature;
	}
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}
	public BigDecimal getHumidity() {
		return humidity;
	}
	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}
	public BigDecimal getCo2() {
		return co2;
	}
	public void setCo2(BigDecimal co2) {
		this.co2 = co2;
	}
}
