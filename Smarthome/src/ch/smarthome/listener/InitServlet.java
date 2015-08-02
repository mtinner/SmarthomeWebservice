package ch.smarthome.listener;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

import ch.smarthome.helper.SharedLampState;

public class InitServlet extends HttpServlet {
	public void init(ServletConfig config){
		System.out.println("Servlet Started");
	}
}
