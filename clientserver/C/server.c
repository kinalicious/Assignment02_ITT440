// Server side C/C++ program to demonstrate Socket programming
#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#define PORT 8080 

int main(int argc , char CONST *argv[])

{
    
	int socket_desc , client_sock , c , read_size;
    
	struct sockaddr_in server , client;
    
	char client_message[2000], temp;
    
	int i, j = 0;
  
	int server_fd, new_socket, valread;
   	struct sockaddr_in address;
  	int opt = 1;
  	int addrlen = sizeof(address);   
    
	
	// Creating socket file descriptor
    	if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0)
   	 {
    	    perror("socket failed");
    	    exit(EXIT_FAILURE);
    	}     
   

	// Forcefully attaching socket to the port 8080
   	 if (bind(server_fd, (struct sockaddr *)&address, sizeof(address))<0)
    	{
      	  perror("bind failed");
       	  exit(EXIT_FAILURE);
   	 }
    	if (listen(server_fd, 3) < 0)
   	 {
    	    perror("listen");
    	    exit(EXIT_FAILURE);
   	 }
   	 if ((new_socket = accept(server_fd, (struct sockaddr *)&address, (socklen_t*)&addrlen))<0)
  	  {
    		    perror("accept");
    		    exit(EXIT_FAILURE);
  	  }   

	//Receive a message from client
    
	while( (read_size = recv(client_sock , client_message , 2000 , 0)) > 0 )
    {
        
		//Reversing message from client
	i = 0;
	j = strlen(client_message) - 1;

	while(i < j){
		
			temp = client_message[i];
		
			client_message[i] = client_message[j];
		
			client_message[j] = temp;
		
			i++;
		
			j--;
	}
	
	
	
		//Send the message back to client 
        
		write(client_sock , client_message, strlen(client_message));
	
		//memset(client_message,'\0',sizeof(client_message));
    
		}
     
   

		 if(read_size == 0)
    {
       
			 puts("Client disconnected");
        
			fflush(stdout);
    
		}
    else if(read_size == -1)
    {
        
			perror("recv failed");
   
		 }
     
    
		return 0;
	
}

