#include "include.h"

int main(int argc, char **argv)
{
	while(1)
	{
		char array[20];
		int serial_fd;
		char buf[LEN_BUF];

		open_port(&serial_fd);
		uart_init(serial_fd);

		bzero(buf, LEN_BUF);	
		read_from_serial(serial_fd, buf);
		printf("buf = %s\n", buf);


		my_sock(buf);//客户端传输数据至服务器

	}
	return 0;
}
