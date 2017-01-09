#include "include.h"

void init_user(USER **temp)
{
	if((*temp = (USER *)malloc(sizeof(USER))) == NULL)
	{
		perror("MALLOC");
		exit(EXIT_FAILURE);
	}
	return;
}


void input_user(USER *temp)
{
	printf("===WELCOME===\n");
	printf("Please input your name:");
	scanf("%[^\n]", temp->name);
	printf("Please input your card:");
	scanf("%s", temp->card);
	printf("Please input your num:");
	scanf("%s", temp->num);
	getchar();

	printf("TYPE:\n");
	printf("0---->5分/s\n");
	printf("1---->15分/s\n");
	printf("2---->25分/s\n");
	printf("3---->35分/s\n");

	temp->type = getchar();
	getchar();
	switch(temp->type)
	{
		case '0':temp->money = 5.00f;break;
		case '1':temp->money = 15.00f;break;
		case '2':temp->money = 25.00f;break;
		case '3':temp->money = 35.00f;break;
	}
	printf("input user info ok\n");
	return;
}

void user_start(USER *temp)
{
	time_t tmp;
	
	tmp = time(NULL);
	memcpy(&(temp->start_time), localtime(&tmp), sizeof(struct tm));
	return;
}

void user_end(USER *temp)
{
	time_t tmp;
	
	tmp = time(NULL);
	memcpy(&(temp->end_time), localtime(&tmp), sizeof(struct tm));
	return;
}

void print_user(const USER *temp)
{
	int val;
	
	val = temp->end_time.tm_sec - temp->start_time.tm_sec;	
	printf("name:%s\n", temp->name);
	printf("type:%c\n", temp->type);
	printf("time:%d\n", val);
	printf("money:%.2f\n", val * temp->money);
	return;
}
