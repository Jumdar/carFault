package car;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GreetServer extends Thread{

	public boolean isLink() {
		return link;
	}

	public void setLink(boolean link) {
		this.link = link;
	}

	public ArrayList<String> getSendData() {
		return sendData;
	}

	public void setSendData(ArrayList<String> sendData) {
		this.sendData = sendData;
	}
	private ServerSocket serverSocket;
	private ArrayList<String> sendData;
	private Socket server;
	private boolean link = false;
	public GreetServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void run() {
		while(true)
		{
			try 
			{
				System.out.println("等待远程主机，端口号为："+serverSocket.getLocalPort()+"...");
				server = serverSocket.accept();
				System.out.println("远程主机地址："+server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
				int i = in.read();
				
				if(i == 1){
					System.out.println(i);
					this.setLink(true);
					for(String data:this.getSendData()){
		        		 System.out.println(data);
		        	}
					out.writeObject(this.getSendData());
					out.writeObject(null);
					out.flush();
					out.close();
					this.setLink(false);
				}
				if(this.isLink()){
				}
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
