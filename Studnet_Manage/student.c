#include "Information.h"

struct student
{
	char account[20];
	char name[20];
	char college[20];
	char year_class[20];
	char lessons_score[20];
	float credit;
};
struct student stu2[100];
int number = 0;


//ѧ���������½���޸�
FILE *fp1;
extern struct USER1
{
	char username1[20];
	char password1[20];
}USER1={"123","123"};



int ReadFromFile1(struct USER1 *USER1)
{
	if(fread(USER1,1,sizeof(struct USER1),fp1)==1)
		return 1;
	return 0;
}



void WriteToFile1(struct USER1 USER1)
	{
		fwrite(&USER1,1,sizeof(struct USER1),fp1);
	}



void ReadData1()
	{
		fp1=fopen("d:\\stu.txt","ab+");
	if (fp1==NULL)
		exit(0);
	else
		ReadFromFile1(&USER1);
		fclose(fp1);
	}



void SaveData1()
	{
		fp1=fopen("d:\\stu.txt","wb+");
		if(fp1==NULL)
			exit(0);
		else
			WriteToFile1(USER1);
		fclose(fp1);
	}


extern int User1()
{
	int i=0;
	char username1[20];
	char password1[20];

		do 
			{

			printf(" \n�������ʺ�: ");
			scanf("%s",username1);
			printf(" \n����������: ");
			scanf("%s",password1);
			system("cls");
		

			if  (strcmp(password1,USER1.password1) == 0 &&
				strcmp(username1,USER1.username1) == 0)
				{
					printf("��ϲ��¼�ɹ�\n");
					sread();
					Interface();
				}

			else
				
				{
					fflush(stdin);
					++i;
					printf("�˺Ż��������!\n");
					printf("�밴���������...\n");
					getchar();
				}
			} while (i<3);


		printf("�����������ϵͳ���Զ��˳�!\n");
		return 0;
}
extern int ModifyPsw1(struct USER1 *USER1)
{
	char password2[20];
	char password3[20];
	char username1[20];
	char password1[20];

	static int i=0;
	if(i==3)
		{
			printf("�޷��޸�!\n");
			return 0;
		}
	do 
	{
		system("cls");
		printf("�������˺�: ");
		scanf("%s",username1);
		printf("������ԭ����: ");
		scanf("%s",password1);
		if(strcmp(username1,USER1->username1) == 0 && strcmp(password1,USER1->password1) == 0)
		  {
		   printf("������������: ");
		   scanf("%s",password2);
		   printf("���ٴ�����������: ");
		   scanf("%s",password3);
			   if (strcmp(password2, password3) == 0 )
				   {
			strcpy(USER1->password1,password2);
				   return 1;
				   }
			  else
				   {
					fflush(stdin);
					printf("������������벻��ͬ������������\n");
					
						system("pause");
						break;
					}
			}
	  else
	  {
	   
	   ++i;
	   printf("�˺Ż��������\n");
	   printf("�밴���������...\n");
	   getchar(); 
	  }
	} while (i<3);
	printf("������������޷��޸�!\n");
	return 0;
}

//student������ڣ�ѧ������ڣ�
void student()
{

    int i;
	ReadData1();
	while(1)
	{
		system("cls");
		printf("\t 1>>��¼ϵͳ\n");	
		printf("\t 2>>�޸�����\n");
		printf("\t 3>>�˳�ϵͳ\n");
		printf("\t ���������: ");

		scanf("%d",&i);
		if(i==1)User1();
		if(i==2)ModifyPsw1(&USER1);
		if(i==3)
		{
			SaveData1();
			exit(0);
		}
	}
}

//ѧ����½��ѡ���ܴ���
void Interface()
{    
    int b_num;
	while(1)
	{
		void Printf_line_two();		
		Printf_line_two();
        printf("\n���ܴ���: ");
		scanf("%d",&b_num);
		fflush(stdin);
		
		switch(b_num)
		{
		case 1:
			slook();
			system("pause");
			break;
		case 2:
			sranking();
			system("pause");
		case 3:
			massage();
			system("pause");
			break;
		case 4:
			replylook();
			system("pause");
			break;
		case 5:
			student();
			system("pause");
			exit(0);
		default:
			printf("�������");
			system("pause");
			break;
		}
		system("cls");
	}
}

//��¼���ܽ���
void Printf_line_two()
{
	printf("======��ӭ��½ѧ���˺Ź���ϵͳ======\n");
    printf("       ===1>>�鿴������Ϣ===\n");
	printf("       ===2>>�鿴��������===\n");
	printf("         ===3>>ѧ������===\n");
	printf("         ===4>>�鿴�ظ�===\n");
	printf("           ===5>>����===\n");
}

//��ȡ�ļ�
void sread()
{
	FILE *fp_file = NULL;
	int i;
	fp_file = fopen("d:\\xingong.txt","r");
	if(fp_file==NULL)
	{
		printf("\n��ʱ��δ¼��ѧ����Ϣ\n");
	}
	else
	{
		fscanf(fp_file,"%d",&number);
		for(i=0;!feof(fp_file);i++)
		{
			fscanf(fp_file,"%s\t%s\t%s\t%s\t%s\t%f\n",stu2[i].account,stu2[i].name,stu2[i].college,stu2[i].year_class,stu2[i].lessons_score,&stu2[i].credit);
		}
		fclose(fp_file);
	}
}

//1.ѧ���鿴��Ϣ
void slook()
{
	char account[25];
	int i;
	char ch;
	if(number==0) 
	{
		printf("\n��ǰ��δ¼��ѧ����Ϣ\n");
		return;
	}
	printf("\n������Ҫ����ѧ��:\n");
    gets(account);
	for(i=0;i<number;i++)
	{
		if(strcmp(stu2[i].account,account)==0)
		{
			printf("\n");
			printf("ѧ��:%s\n",stu2[i].account);
			printf("����:%s\n",stu2[i].name);
			printf("ѧԺ:%s\n",stu2[i].college);
			printf("רҵ�꼶:%s\n",stu2[i].year_class);
			printf("�γ�-�ɼ�:%s\n",stu2[i].lessons_score);
			printf("ѧ��:%.2f\n",stu2[i].credit);
			printf("\n");
			ch=getche();
		}
	}

}

//2.ѧ���鿴����
void sranking()
{
	char account[25];
	int i;
	printf("\n�������ѯѧ��:");
	gets(account);
	for(i=0;i<number;i++)
	{
		if(strcmp(stu2[i].account,account)==0)
		{
			printf("\n");
			printf("\t����:%d\n",i+1);
			printf("\tѧ��:%.2f\n",stu2[i].credit);
		}
	}
	getchar();
	fflush(stdin);
	Interface();
}

//3.����
void massage()
{
	FILE *fp_file = NULL;
	char words[1000];
	printf("\n����������\n");
	gets(words);
	fp_file = fopen("d:\\liuyan.txt","w");
	fprintf(fp_file,"%s\n",words);
}

//4.�鿴�ظ�
void replylook()
{
	FILE *fp_file;
	char ch;
	fp_file = fopen("d:\\liuyan.txt","r");
	while((ch = fgetc(fp_file)) != EOF)
		fputc(ch,stdout);
	fclose(fp_file);

}
