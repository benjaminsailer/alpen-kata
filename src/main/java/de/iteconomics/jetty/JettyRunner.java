package de.iteconomics.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyRunner {

	public static void main(String... args) {
	    try {
	        Server server = new Server(8080);
	        String rootPath = JettyRunner.class.getClassLoader().getResource(".").toString();
	        WebAppContext webapp = new WebAppContext(rootPath + "../../src/main/webapp", "");
	        server.setHandler(webapp);
	        server.start();
	        server.join();
	    } catch (Exception ex) {
	        System.err.println(ex);
	    }
	}
}
