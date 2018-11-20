package itech;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class ItechDropConf extends Configuration {

	@Valid
	@NotNull
	@JsonProperty("database")
	private DataSourceFactory database = new DataSourceFactory();
	
    @JsonProperty
    private String consumableValue;


    public String getConsumableValue() {
        return consumableValue;
    }
	public DataSourceFactory getDatabase() {
		return database;
	}
	public void setDatabase(DataSourceFactory database) {
		this.database = database;
	}
}
