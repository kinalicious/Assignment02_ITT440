import java.net.*;

import java.io.*;



public class client
{
	
	private static Socket socket;
	
	public static void main(String args[])
	{
		

	try
		{
				
		socket = new Socket("192.168.35.134",8080);

			

		//send the message to the server
				
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream();
));


			
		String msg = " ";
			
		String sendMessage = msg + "\n";
			
		bw.writeUTF(sendMessage);
			
		bw.flush();
			
		System.out.println("Message sent to the server: " + sendMessage);

			

		//Get the return message from the server
			
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		String message = br.readLine();
			
		System.out.println("Message received from the server: " + message);
		
	}
	
	catch (Exception exception)
		
		{
	exception.printStackTrace();
}
		
	finally
	{
			
		//closing the socket
			
		try
{
	socket.close();
	}
			
		catch (Exception e)
{
e.printStackTrace();
}
		
	}

	
}

