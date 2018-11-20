package itech.db;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import itech.hotfix.Temp;

public interface HotFixDAO {

	@SqlQuery("SELECT * FROM test WHERE 1 = 1")
	public Temp getTempData();
	
	@SqlUpdate("INSERT INTO Atmospherics (Timestamp, Temperature, Humidity, CO2) VALUES ('2018-01-15 00:00:00:000', 20.3, 15.9, 12.78)")
	public void insertAtmosphericsDummy();
	
	void close();
}
