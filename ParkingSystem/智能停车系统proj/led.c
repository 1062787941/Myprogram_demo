#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/ioctl.h>

#define LEN_ON _IO('k', 1)
#define LEN_OFF _IO('k', 0)

int main(int argc, const char *argv[])
{
	int fd;

	if((fd = open("/dev/s5pc100_led_char", O_RDWR)) < 0)
	{
		perror("OPEN");
		exit(0);
	}
	while(1)
	{
		ioctl(fd, LEN_ON, 1);
		usleep(500000);
		ioctl(fd, LEN_OFF, 1);
		ioctl(fd, LEN_ON, 2);
		usleep(500000);
		ioctl(fd, LEN_OFF, 2);
		ioctl(fd, LEN_ON, 3);
		usleep(500000);
		ioctl(fd, LEN_OFF, 3);
	}

	close(fd);

	return 0;
}

