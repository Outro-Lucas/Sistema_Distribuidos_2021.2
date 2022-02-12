package Calculator;

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TCPClient{
	private DataOutputStream out;
	private DataInputStream in;
	private Socket s;

	public void sendRequest(String msg){
	try{
			this.out.writeUTF(msg);
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());}
		
	

	}
	public  String getResponse(){
		try{
			return this.in.readUTF();
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());return "";}
		
	}
	public void close(){
		try{
			this.s.close();
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());}
		

	}

    public TCPClient(){ 
		Socket s = null;
		try{
			int serverPort = 7896;
			int clientPort = 5000;
			String localhost = "localhost";
			InetAddress aclient = InetAddress.getByName("127.0.0.2");
			this.s = new Socket(localhost, serverPort,aclient,clientPort);   
			this.in = new DataInputStream( this.s.getInputStream());
			this.out = new DataOutputStream( this.s.getOutputStream());	                        
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage()); System.exit(0);
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());System.exit(0);
		}catch (IOException e){System.out.println("readline:"+e.getMessage());System.exit(0);
		}
	}		      	
}
