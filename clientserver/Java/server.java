import java.io.*;

import java.net.*;



public class server
{
	
	private static Socket socket;
	
	public static void main(String[] args)
	throws Exception{
		
		try
		{
				
			ServerSocket serverSocket = new ServerSocket(8080);s
			System.out.println("Serve listening to port 8080");

			

			//Server is running always. This is done using this 
			while(true) loop
			
				while(true)
			{
				
				//Reading the message from the client
				
				socket = serverSocket.accept();

			
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream();));
				
				String msg = (String)br.readUTF();  				
				System.out.println("Message received from client is " + msg );

				

				//Reversing the message and forming the return message
				
				String returnMessage;
				

				try
				{
					
					char temp;
					
					char [] arr = msg.toCharArray();
					
					int len = arr.length;
					
					for ( int j=0; j<(msg.length())/2; j++,len--)
		{
						
						temp = arr[j];
						
						arr[j] = arr[len-1];
						
						arr[len-1] = temp;
					
					}

					
					returnMessage = String.valueOf(arr) + "\n";
				
				}
	catch(Exception e)
				
						{
returnMessage = "Please enter message\n";
	}

				

				//sending back the response to the client
							
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				bw.write(returnMessage);
				
				System.out.println("Message sent to client is" + returnMessage);
				
				bw.flush();
			
			}	
		
		}
				
				finally
		
			{
		try
{
socket.close();
}
			
					catch(Exception e){}
		
			}
	
		}

	}

	
}