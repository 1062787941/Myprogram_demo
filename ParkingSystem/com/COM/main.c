#include "IC_serial.h"

int main(int argc, char **argv)
{
	int serial_fd;
	unsigned char buf[LEN_BUF];

	open_port(&serial_fd);
	uart_init(serial_fd);

	bzero(buf, LEN_BUF);	
	read_from_serial(serial_fd, buf);
	printf("buf = %s\b", buf);
	printf("\n");
	return 0;
}
