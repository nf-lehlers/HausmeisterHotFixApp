package itech.db;

import org.skife.jdbi.v2.DBI;

public class Connect {

	public void connect(String user, String pw) {
		DBI dbi = new DBI("jdbc:mysql:url", user, pw);
		
		HotFixDAO hfdao = dbi.onDemand(HotFixDAO.class);
		
		
	}
}
