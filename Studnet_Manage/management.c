#include "Information.h"
#include <stdlib.h>
#include <stdio.h>

//�������
struct student
{
	char name[20];
	char account[20];
	char year_class[20];
	char lessons_score[20];
	char college[20];
	float credit;
};
struct student stu[100];
int num = 0;

//����Ա���������
FILE *fp1;
extern struct USER2
{
	char username1[20];
	char password1[20];
}USER2={"123","123"};

int ReadFromFile2(struct USER2 *USER2)
{
	if(fread(USER2,1,sizeof(struct USER2),fp1)==1)
		return 1;
	return 0;
}

void WriteToFile2(struct USER2 USER2)
	{
		fwrite(&USER2,1,sizeof(struct USER2),fp1);
	}

void ReadData2()
	{
		fp1=fopen("d:\\admin.txt","ab+");
	if (fp1==NULL)
		exit(0);
	else
		ReadFromFile2(&USER2);
		fclose(fp1);
	}

void SaveData2()
	{
		fp1=fopen("d:\\admin.txt","wb+");
		if(fp1==NULL)
			exit(0);
		else
			WriteToFile2(USER2);
		fclose(fp1);
	}

extern int User2()
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
		

			if  (strcmp(password1,USER2.password1) == 0 &&
				strcmp(username1,USER2.username1) == 0)
				{
					printf("��ϲ��¼�ɹ�\n");
					read();
					interfacetwo();
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

extern int ModifyPsw2(struct USER2 *USER2)
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
		if(strcmp(username1,USER2->username1) == 0 && strcmp(password1,USER2->password1) == 0)
		  {
		   printf("������������: ");
		   scanf("%s",password2);
		   printf("���ٴ�����������: ");
		   scanf("%s",password3);
			   if (strcmp(password2, password3) == 0 )
				   {
			strcpy(USER2->password1,password2);
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

void management()
{

    int i;
	ReadData2();
	while(1)
	{
		system("cls");
		printf("\t 1>>��¼ϵͳ\n");	
		printf("\t 2>>�޸�����\n");
		printf("\t 3>>�˳�ϵͳ\n");
		printf("\t ���������: ");

		scanf("%d",&i);
		if(i==1)User2();
		if(i==2)ModifyPsw2(&USER2);
		if(i==3)
		{
			SaveData2();
			exit(0);
		}
	}
}

//����Ա��¼��ѡ���ܴ���
void interfacetwo()
{
    int c_num;
	while(1)
	{
		void Printf_line_three();		
		Printf_line_three();
        printf("\n���ܴ���: ");
		scanf("%d",&c_num);
		fflush(stdin);
		
		switch(c_num)
		{
		case 1:
			information();
			save();
			system("pause");
			break;
		case 2:
			delete();
			save();
			system("pause");
			break;
		case 3:
			tlook();
			system("pause");
			break;
		case 4:
			pandect();
			save();
			system("pause");
			break;
		case 5:
			revise();
			save();
			system("pause");
			break;
		case 6:
			trankinglook();
			system("pause");
			break;
		case 7:
			massagelook();
			system("pause");
			break;
		case 8:
			management();
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
void Printf_line_three()
{
	printf("======��ӭ��½����Ա����ϵͳ======\n");
    printf("          ===1>>����===\n");
	printf("          ===2>>ע��===\n");
	printf("     ===3>>����ѧ�Ų鿴ѧ����Ϣ===\n");
	printf("          ===4>>����===\n");
	printf("          ===5>>�޸�===\n");
	printf("      ===6>>�鿴ѧ������===\n");
	printf("         ===7>>�鿴����===\n");
	printf("          ===8>>����===\n");
}

//�ļ���ȡ
void read()
{
	FILE *fp_file = NULL;
	int i;
	fp_file = fopen("d:\\xingong.txt","r");
	if(fp_file==NULL)
	{
		printf("\n��ʱ��δ¼��ѧ����Ϣ\n\n\n");
	}
	else
	{
		fscanf(fp_file,"%d",&num);
		for(i=0;!feof(fp_file);i++)
		{
			fscanf(fp_file,"%s\t%s\t%s\t%s\t%s\t%f\n",stu[i].account,stu[i].name,stu[i].college,stu[i].year_class,stu[i].lessons_score,&stu[i].credit);
		}
		fclose(fp_file);
	}
}

//�ļ�����
void save()
{
    FILE *fp_file = NULL;
	int i;
	fp_file = fopen("d:\\xingong.txt","w");
	if(NULL==fp_file)
	{
		printf("\nĿǰ��ѧ����Ϣ\n");
	}
	else
	{
		fprintf(fp_file,"%d\n",num);
		for(i=0;i<num;i++)
			fprintf(fp_file,"%s\t%s\t%s\t%s\t%s\t%f\n",stu[i].account,stu[i].name,stu[i].college,stu[i].year_class,stu[i].lessons_score,stu[i].credit);
	}
	fclose(fp_file);
	return;
}

//1.������Ϣ
void information()
{
	char ch;
	int j;
	printf("\n�������µ�ѧ��:");
	gets(stu[num].account);
	while(strlen(stu[num].account)==0)
	{
		printf("ѧ�Ų���Ϊ�գ�����������:");
		gets(stu[num].account);
	}
	for(j=0;j<num;j++)
	if(strcmp(stu[j].account,stu[num].account)==0)
	{
		printf("��Ϊ�����ظ��˺ţ�������Ϣ��������¼.....\n");
		return;
	}

	fflush(stdin);
	printf("\n����������:");
	gets(stu[num].name);
	fflush(stdin);

	printf("\n������ѧԺ:");
	gets(stu[num].college); 
	fflush(stdin);

	printf("\n������רҵ�꼶�༶:");
    gets(stu[num].year_class);
	fflush(stdin);
	
    printf("\n������γ�-�ɼ�:");
	gets(stu[num].lessons_score);
	fflush(stdin);
	
    printf("\n������ѧ��:");
	scanf("%f",&stu[num].credit);
	fflush(stdin);
	
	printf("\n����ɹ�\n");
	printf("ѧ��:%s\n����:%s\nѧԺ:%s\nרҵ�꼶:%s\n�γ�-�ɼ�:%s\nѧ��:%.2f\n",stu[num].account,stu[num].name,stu[num].college,stu[num].year_class,stu[num].lessons_score,stu[num].credit);
	num++;
	printf("�Ƿ�������(Y/N)?\n");
	ch=getche();
	tranking();
	if(ch=='y'||ch=='Y')
		information();
	else return;
}

//2.ע��
void delete()
{
	char account[25];
	int i;
	char ch;
	printf("\t������Ҫע����ѧ�ţ�");
	gets(account);
	for(i=0;i<num;i++)
	{
		if(strcmp(stu[i].account,account)==0)
		{
			printf("\n��ȷ��Ҫɾ��%s��ѧ����Ϣ��(y/n)?\n",stu[i].account);
			ch=getche();
			if(ch=='y'||ch=='Y') 
			{
				printf("\nѧ����Ϊ%s����Ϣ�Ѿ��ɹ���ɾ�����Ƿ����(y/n)?\n",stu[i].account);
				stu[i]=stu[num-1];num--;
				ch=getche();
				printf("\n");
				if(ch=='y'||ch=='Y') 
					delete();
				else return;
			}
			else 
			{
				printf("\n��ѡ��ɾ��ѧ����Ϣ\n");
				getchar();
				return;
			}
		}
	}
	if(i==num) {printf("\n����Ҫɾ����ѧ��ѧ����Ϣ������\n");getchar();return;}
}

//3.��ѯ
void tlook()
{
	char account[25];
	char ch;
	int i;
	if(num==0) 
	{
		printf("\n��ǰû��ѧ����Ϣ");
		return;
	}
	printf("\n������Ҫ����ѧ��:\n");
    gets(account);
	for(i=0;i<num;i++)
	{
		if(strcmp(stu[i].account,account)==0)
		{
			printf("\n");
			printf("ѧ��:%s\n",stu[i].account);
			printf("����:%s\n",stu[i].name);
			printf("ѧԺ:%s\n",stu[i].college);
			printf("רҵ�꼶:%s\n",stu[i].year_class);
			printf("�γ�-�ɼ�:%s\n",stu[i].lessons_score);
			printf("ѧ��:%.2f\n",stu[i].credit);
			printf("�Ƿ����(y/n)?\n");
			ch=getche();
			printf("\n");
			if(ch=='y'||ch=='Y') 
				tlook();
			else return;
		}
	}
    if(i==num) 
	{
		printf("\n\t\t�˺���Ϣ������....");
		getch();
		return;
	}
}

//4.����
void pandect()
{
    int i;
	system("cls");
	tranking();
	for(i=0;i<num;i++)
	{
		printf("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
		printf("ѧ��:%s\n",stu[i].account);
		printf("����:%s\n",stu[i].name);
		printf("ѧԺ:%s\n",stu[i].college);
		printf("רҵ�꼶:%s\n",stu[i].year_class);
		printf("�γ�-�ɼ�:%s\n",stu[i].lessons_score);
		printf("ѧ��:%.2f\n",stu[i].credit);
		printf("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
	}
	if(num==0)
	{
		printf("\nĿǰѧ����Ϊ0\n");
	}
	else 
	{
		printf("\nĿǰѧ����Ϊ:%d\n",num);
	}
	getchar();
	return;
}

//5.�޸�
void revise()
{
	char account[25];
	int i;
	char ch;
	printf("\t������Ҫ�޸ĵ�ѧ�ţ�");
	gets(account);
	for(i=0;i<num;i++)
	{
		if(strcmp(stu[i].account,account)==0)
		{
			printf("\n");
			printf("ѧ��:%s\n",stu[i].account);
			printf("����:%s\n",stu[i].name);	
			printf("ѧԺ:%s\n",stu[i].college);
			printf("רҵ�꼶:%s\n",stu[i].year_class);
			printf("�γ�-�ɼ�:%s\n",stu[i].lessons_score);
			printf("ѧ��:%.2f\n",stu[i].credit);
			printf("�Ƿ�����޸�(y/n)?");
			ch=getche();
			if(ch=='y'||ch=='Y')
			{
				fflush(stdin);
				printf("\n������ѧ��:");
				gets(stu[i].account);
				fflush(stdin);
				
				printf("\n����������:");
				gets(stu[i].name);
				fflush(stdin);

				printf("\n������ѧԺ:");
				gets(stu[i].college);
				fflush(stdin);
				
				printf("\n������רҵ�꼶�༶:");
				gets(stu[i].year_class);
				fflush(stdin);
				
				printf("\n������γ�-�ɼ�:");
				gets(stu[i].lessons_score);
				fflush(stdin);
				
				printf("\n������ѧ��:");
				scanf("%f",&stu[i].credit);
				fflush(stdin);
				
				printf("\n�޸ĳɹ�\n");
				printf("ѧ��:%s\n����:%s\nѧԺ:%s\nרҵ�꼶:%s\n�γ�-�ɼ�:%s\nѧ��:%.2f\n",stu[i].account,stu[i].name,stu[i].college,stu[i].year_class,stu[i].lessons_score,stu[i].credit);

			}
			else
			{
				printf("\nѡ���޸�\n");
				return;
			}
		}
	}
}
//��������
void tranking()
{
	int i,j;
	struct student t;
	for(i=0;i<num-1;i++)
	{
		for(j=i+1;j<num;j++)
		{
			if(stu[i].credit<stu[j].credit)
			{
				t=stu[i];
				stu[i]=stu[j];
				stu[j]=t;
			}
		}
	}
}

//6.����
void trankinglook()
{
	int i,j;
	struct student t;
	for(i=0;i<num-1;i++)
	{
		for(j=i+1;j<num;j++)
		{
			if(stu[i].credit<stu[j].credit)
			{
				t=stu[i];
				stu[i]=stu[j];
				stu[j]=t;
			}
		}
	}
	printf("\n");
	for(i=0;i<num;i++)
	{
		printf("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
		printf("����:%d\n",i+1);
		printf("ѧ��:%s\t",stu[i].account);
		printf("����:%s\t",stu[i].name);
		printf("ѧԺ:%s\t",stu[i].college);
		printf("רҵ�꼶:%s\t",stu[i].year_class);
		printf("�γ�-�ɼ�:%s\t",stu[i].lessons_score);
		printf("ѧ��:%.2f\n",stu[i].credit);
		printf("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
	}
}
		
//7.�鿴����
void massagelook()
{
	FILE *fp_file = NULL;
	char ch;
	fp_file = fopen("d:\\liuyan.txt","r");
	if(fp_file==NULL)
	{
		printf("\n����ѧ������\n");
		return;
	}
	else
	{
		while((ch = fgetc(fp_file)) != EOF)
			fputc(ch,stdout);
		fclose(fp_file);
		printf("\n�Ƿ�ظ�����(Y/N)\n");
		ch=getche();
		if(ch=='y'||ch=='Y')
		{
			reply();
		}
	}
}

//�ظ�
void reply()
{
	FILE *fp_file = NULL;
	char words[1000];
	printf("\n����������\n");
	gets(words);
	fp_file = fopen("d:\\liuyan.txt","a");
	fprintf(fp_file,"%s\n",words);
	fclose(fp_file);
}