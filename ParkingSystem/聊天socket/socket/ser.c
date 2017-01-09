#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <stdlib.h>  
#include <string.h>
#include <linux/in.h>

int main(int argc, const char *argv[])
{

	int my_sock;
	struct sockaddr_in ser;
	char buf[20] = "\0";
	socklen_t len;

	if((my_sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0)
	{
		perror("SOCKET"); 	
		exit(EXIT_FAILURE);
	}

	memset(&ser, 0, sizeof(ser));
	ser.sin_family = AF_INET;
	ser.sin_port = htons(8888);
	ser.sin_addr.s_addr = inet_addr("127.0.0.1");

	if(bind(my_sock, (struct sockaddr *)&ser, sizeof(ser)) < 0)
	{
		perror("BIND");
		exit(EXIT_FAILURE);
	}

	while(1)
	{
 		recvfrom(my_sock, buf, sizeof(buf), 0, (struct sockaddr *)&ser, &len);	
		printf("recv from cli:%s\n", buf);
		printf(">");
		memset(buf, 0, sizeof(buf));
		scanf("%s", buf);
		sendto(my_sock, buf, sizeof(buf), 0, (struct sockaddr *)&ser, len);
	}

	close(my_sock);
	return 0;
}

