package ch.smarthome.dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.glassfish.jersey.internal.util.PropertiesHelper;

import ch.smarthome.helper.PropertyHelper;

public class ClientLampSocket {
	public boolean startClient(int id) {
		boolean state = false;
		//int id = 3;
		PropertyHelper property = new PropertyHelper();
		try {
			String host;
			int serverPort = 9750;
			host = property.getProperty("ELITEBOOK");
			Socket s = new Socket(host, serverPort);
			
			DataOutputStream bw = new DataOutputStream(s.getOutputStream());
			bw.writeInt(id);
			//bw.close();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			state = Boolean.parseBoolean(br.readLine());
			s.close();
		} catch (UnknownHostException e) {
			System.out.println("Sock:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		}
		return state;
	}
}
