#ifndef  _TEST_
#define _TEST_

#include <sys/types.h>
#include <sys/socket.h>
#include <stdlib.h>  
#include <string.h>
#include <linux/in.h>
//-------------------------------
#include <stdio.h>
#include <errno.h>

#include <strings.h>
#include <termios.h>

#include <sys/stat.h>
#include <fcntl.h>


#define LEN_BUF 11 
#define NAME_SERIAL "/dev/s3c2410_serial2"

extern void open_port(int *);
extern void uart_init(int);
extern void read_from_serial(int,  char *);
#endif

int my_sock( char* );


struct user
{
	int id;
	char name[20];
};
