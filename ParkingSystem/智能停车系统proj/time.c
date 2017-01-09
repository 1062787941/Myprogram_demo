#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <errno.h>
int main(int argc, char **argv)
{
	time_t temp; //long tmp;
    struct tm *val = NULL;

	if((val = (struct tm *)malloc(sizeof(struct tm))) == NULL)
	{
		fprintf(stderr, "malloc error.%s\n", strerror(errno));
		exit(EXIT_FAILURE);
	}
    temp = time(NULL);
	memcpy(val, localtime(&temp), sizeof(struct tm));

	printf("date:%d-%d-%d %d:%d:%d\n", val->tm_year+1900, val->tm_mon+1\
			                            ,val->tm_mday, val->tm_hour\
										,val->tm_min, val->tm_sec);

	free(val);


	return 0;
}
