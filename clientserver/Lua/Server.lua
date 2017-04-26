require('socket');

port = 80;

server = socket.bind('*',port);
io.write("Waiting at the door "..port.."\n");
cnx = server:accept();
io.write("Connection success: ")
while true do
	msg = cnx:receive();
	reversedString = msg.reverse(msg);
	io.write(msg.."\n");
	io.write("Reply > ");
	cnx:send(reversedString .. "\n");

end
io.read();
