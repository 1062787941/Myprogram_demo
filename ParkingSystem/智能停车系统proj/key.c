#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/ioctl.h>

unsigned int key_read(int);

int main(int argc, const char *argv[])
{
	int fd;
	int temp;

	if((fd = open("/dev/s5pc100_key", O_RDWR)) < 0)
	{
		perror("OPEN");
		exit(0);
	}

	while(1)
	{
		if((temp = key_read(fd)) > 0)
		{
			switch (temp)
			{
			case 1:printf("1\n"); break;
			case 2:printf("2\n"); break;
			case 3:printf("3\n"); break;
			case 4:printf("4\n"); break;
			}
		}

	}
	close(fd);

	return 0;
}

unsigned int key_read(int fd)
{
	int temp;
	read(fd, &temp, sizeof(temp));
	return temp;
}
