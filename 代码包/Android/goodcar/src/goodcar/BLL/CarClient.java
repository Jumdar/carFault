package goodcar.BLL;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class CarClient {
	public ArrayList<String> client(){  
		String serverName = "10.0.2.2";
		int port = 6066;
		ArrayList<String> getData = null;
		try
		{
	    	System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
			Socket client = new Socket(serverName, port);
			System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.write(1);
			out.flush();
			client.shutdownOutput();
			InputStream inFromServer = client.getInputStream();
			ObjectInputStream in = new ObjectInputStream(inFromServer);
			getData = (ArrayList<String>) in.readObject();
			if(getData!=null){
				for(String data:getData){
					System.out.println(data);
				}
			}
			else{
			    System.out.println("没有东西"); 
			}
			client.close();
		}catch(IOException e){
		     e.printStackTrace();
		     System.out.println(e);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return getData;
	}
}
