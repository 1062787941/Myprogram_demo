#include "Information.h"

void main()
{
	int n_num;
	while(1)
	{
		void Printf_line();		
		Printf_line();
        printf("\n���ܴ���: ");
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
			printf("ϵͳ�����˳�...");
			system("pause");
			exit(0);
			break;
		default:
			printf("�������");
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
	printf("\t\t======��ӭ����ѧ���˺Ź���ϵͳ======\n");
    printf("\t\t         ===1>>ѧ����½===\n");
	printf("\t\t        ===2>>����Ա��½===\n");
	printf("\t\t           ===3>>����===\n");
	printf("\t\t           ===4>>�˳�===\n");
}

void help()
{
	printf("\n  ��ϵͳ������ѧԺ����C������ѵ����03�����\n\t\t�ͷ��绰888888\n\t���й���,�벦��ͷ�,лл����!\n");
}
