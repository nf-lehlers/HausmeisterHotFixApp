package itech.hotfix;

import java.time.LocalTime;

/**
 * @author Luka 19.11.18
 */
public class Atmospherics {

	private LocalTime timestamp;
	private Number temperature;
	private Number humidity;
	private Number co2;
	
	
	public LocalTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalTime timestamp) {
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
