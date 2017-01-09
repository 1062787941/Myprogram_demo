#include "include.h"

int main(int argc, char *argv[])
{
	USER *temp = NULL;

	init_user(&temp);

	input_user(temp);
	user_start(temp);
	printf("stop car start,press any key over.\n");
	getchar();
	user_end(temp);
	print_user(temp);
	free(temp);

	return 0;
}
