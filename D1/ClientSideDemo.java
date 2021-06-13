import java.net.*;
import java.io.*;
import java.util.*;

public class ClientSideDemo{
	public static void main(String arg[]){
		
		try{
			Socket s = new Socket("localhost",5000);
			
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			
			Scanner kb = new Scanner(System.in);
			while(true){
				
				String cmsg = kb.nextLine();
				dout.writeUTF(cmsg);
				
				String smsg = din.readUTF();
				System.out.println("Server Message:"+smsg);
			}
			
		}
		
		catch(Exception e){
			System.out.println("Error is:"+e);
		}
	}
}