import java.net.*;
import java.io.*;
import java.util.*;

public class ServerSideDemo{
	public static void main(String arg[]){
		
		try{
			System.out.println("Server is waiting fot Client to connect....");
			ServerSocket ss = new ServerSocket(5000);
			Socket clientSocket = ss.accept();
			System.out.println("Client is now connected...");
			
			DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
			
			DataInputStream din = new DataInputStream(clientSocket.getInputStream());
			
			Scanner kb = new Scanner(System.in);
			while(true){
				
				String cmsg = din.readUTF();
				System.out.println("Client Message:"+cmsg);
				
				String smsg = kb.nextLine();
				dout.writeUTF(smsg);
			}
		}
		
		catch (Exception e){
			System.out.println("Error is:"+e);
		}
		
	}
}