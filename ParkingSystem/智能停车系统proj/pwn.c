#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ioctl.h>
#include <fcntl.h>

#define BEEP_ON _IO('k', 0)
#define BEEP_OFF _IO('k', 1)
#define BEEP_SET _IO('k', 2)

void set_fre(int, int);

int main(int argc, char **argv)
{
	int fd;

	if((fd = open("/dev/s5pc100_pwm_char", O_RDWR)) < 0)
	{
		perror("OPEN");
		exit(0);
	}
	set_fre(fd, 100);
	ioctl(fd, BEEP_ON);
	sleep(1);
	set_fre(fd, 200);
	ioctl(fd, BEEP_ON);
	sleep(1);
	set_fre(fd, 300);
	ioctl(fd, BEEP_ON);
	sleep(1);
	set_fre(fd, 400);
	ioctl(fd, BEEP_ON);
	sleep(1);
	ioctl(fd, BEEP_OFF);
	close(fd);

	return 0;
}

void set_fre(int fd, int temp)
{
	ioctl(fd, BEEP_SET, temp);
	return;
}
