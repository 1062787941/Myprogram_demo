#include <sys/types.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main(int argc, const char *argv[])
{
	int fd;
	char buf[] = "hello \n";

	if((fd = open("a.txt", O_RDWR|O_CREAT|O_TRUNC, 0666)) < 0)
	{
		perror("OPEN");
		exit(0);
	}
	write(fd, buf, strlen(buf));
	lseek(fd, 0, SEEK_SET);
	memset(buf, 0, sizeof(buf));
	read(fd, buf, 10);
	printf("%s\n", buf);
	
	close(fd);
	
	return 0;
}

