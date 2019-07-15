package goodcar.BLL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DecisionClient {
	public String client(String object) throws ClassNotFoundException{  
		String serverName = "47.95.7.178";
		int port = 8000;
		String getData = "";
		try
		{
			System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
			Socket client = new Socket(serverName, port);
			System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeChars(object);
			out.flush();
			client.shutdownOutput();
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			getData=in.readLine();
			client.close();
		}catch(IOException e){
		     e.printStackTrace();
		     System.out.println(e);
		}
		return getData;
	}
}
