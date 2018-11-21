package itech;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import itech.client.HelloWorldClient;
import itech.db.HotFixDAO;
import itech.resources.HotFixResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.client.Client;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.sqlobject.customizers.OverrideStatementRewriterWith;

public class ItechDropApp extends Application<ItechDropConf> {

    public static void main(String[] args) throws Exception {
        new ItechDropApp().run(args);
    }

    @Override
    public void run(ItechDropConf configuration, Environment environment) {
        Client client = setupClient(environment);
        environment.jersey().register(new HelloWorldClient(client));
        environment.jersey().register(new HotFixResource());
//        environment.jersey().register(new HelloWorldJsonResource());
//        environment.jersey().register(new HotFixResource());
        
        environment.jersey().register(new JsonProcessingExceptionMapper(true));
        
        
//        // Beispiel für eine konsumierbaren Wert
//        System.out.println(configuration.getConsumableValue());
        
        System.out.println("test");
        
        String hostName = "hhfserver.database.windows.net";
        String dbName = "HHFdb";
        String user = configuration.getDatabase().getUser();
        String password = configuration.getDatabase().getPassword();
        String url = String.format("jdbc:sqlserver://%s:1433;"
        		+ "database=%s;"
        		+ "user=%s;"
        		+ "password=%s;"
        		+ "encrypt=true;"
        		+ "trustServerCertificate=false;"
        		+ "hostNameInCertifcate=*.database.windows.net;"
        		+ "loginTimeout=30;", hostName, dbName, user, password);
        
//        String u = String.format("jdbc:sqlserver://hhfserver.database.windows.net:1433;"
//        		+ "database=HHFdb;"
//        		+ "user=Hausmeister@hhfserver;"
//        		+ "password={your_password_here};"
//        		+ "encrypt=true;"
//        		+ "trustServerCertificate=false;"
//        		+ "hostNameInCertificate=*.database.windows.net;"
//        		+ "loginTimeout=30;", args)
        
        Connection connection = null;
        
        try {
        	connection = DriverManager.getConnection(url);
        	String shema = connection.getSchema();
        	System.out.println(shema);
        	
        	String query = "INSERT INTO Atmospherics (Timestamp, Temperature, Humidity, CO2) VALUES ('2018-01-15 00:00:00:000', 20.3, 15.9, 12.78)";
        	
        	try (Statement statement = connection.createStatement(); ResultSet reSet = statement.executeQuery(query)) {
        		System.out.println("result");
        		connection.close();
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
        
        
//        DBI dbi = new DBI(configuration.getDatabase().getUrl(), configuration.getDatabase().getUser(), configuration.getDatabase().getPassword());
//        
//        HotFixDAO hfd = dbi.open(HotFixDAO.class);
//        
//        hfd.insertAtmosphericsDummy();
//        
//        hfd.close();
    }

    private Client setupClient(Environment environment) {
        return new JerseyClientBuilder(environment).build("REST Client");
    }
    
    @Override
    public void initialize(Bootstrap<ItechDropConf> bootstrap) {
    	super.initialize(bootstrap);
    	
    	bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
    }
}
