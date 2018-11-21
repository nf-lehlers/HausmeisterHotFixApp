package itech.hotfix;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Luka 19.11.18
 */
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)
public class Atmospherics {

	private LocalDateTime timestamp;
	private Number temperature;
	private Number humidity;
	private Number co2;
	
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Number getTemperature() {
		return temperature;
	}
	public void setTemperature(Number temperature) {
		this.temperature = temperature;
	}
	public Number getHumidity() {
		return humidity;
	}
	public void setHumidity(Number humidity) {
		this.humidity = humidity;
	}
	public Number getCo2() {
		return co2;
	}
	public void setCo2(Number co2) {
		this.co2 = co2;
	}
}
