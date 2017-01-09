#ifndef _TEST_
#define _TEST_

#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>
#include <errno.h>

#define LEN_NAME 20
#define LEN_CARD 20
#define LEN_NUM  10

typedef struct 
{
	char name[LEN_NAME];
	char card[LEN_CARD];
	char num[LEN_NUM];
	char type;
	float money;
	struct tm start_time;
	struct tm end_time;
}USER;


void init_user(USER **);
void input_user(USER *);
void user_start(USER *);
void user_end(USER *);
void print_user(const USER *);

#endif
