#include "Information.h"

void main()
{
	int n_num;
	while(1)
	{
		void Printf_line();		
		Printf_line();
        printf("\n功能代号: ");
		scanf("%d",&n_num);
		fflush(stdin);
		
		switch(n_num)
		{
		case 1:
			student();
			system("pause");
			break;
		case 2:
			management();
			system("pause");
			break;
		case 3:
			help();
			system("pause");
			break;
		case 4:
			printf("系统即将退出...");
			system("pause");
			exit(0);
			break;
		default:
			printf("输入错误");
			system("pause");
			break;
		}
		system("cls");
	}
}

void Printf_line()
{
	system("color 2f");
	printf("\n\n\n\n\n");
	printf("\t\t======欢迎进入学生账号管理系统======\n");
    printf("\t\t         ===1>>学生登陆===\n");
	printf("\t\t        ===2>>管理员登陆===\n");
	printf("\t\t           ===3>>帮助===\n");
	printf("\t\t           ===4>>退出===\n");
}

void help()
{
	printf("\n  本系统由皖西学院暑期C语言培训二班03组设计\n\t\t客服电话888888\n\t如有故障,请拨打客服,谢谢合作!\n");
}
