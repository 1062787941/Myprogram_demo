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


//学生端密码登陆、修改
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

			printf(" \n请输入帐号: ");
			scanf("%s",username1);
			printf(" \n请输入密码: ");
			scanf("%s",password1);
			system("cls");
		

			if  (strcmp(password1,USER1.password1) == 0 &&
				strcmp(username1,USER1.username1) == 0)
				{
					printf("恭喜登录成功\n");
					sread();
					Interface();
				}

			else
				
				{
					fflush(stdin);
					++i;
					printf("账号或密码错误!\n");
					printf("请按任意键继续...\n");
					getchar();
				}
			} while (i<3);


		printf("三次输入错误，系统将自动退出!\n");
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
			printf("无法修改!\n");
			return 0;
		}
	do 
	{
		system("cls");
		printf("请输入账号: ");
		scanf("%s",username1);
		printf("请输入原密码: ");
		scanf("%s",password1);
		if(strcmp(username1,USER1->username1) == 0 && strcmp(password1,USER1->password1) == 0)
		  {
		   printf("请输入新密码: ");
		   scanf("%s",password2);
		   printf("请再次输入新密码: ");
		   scanf("%s",password3);
			   if (strcmp(password2, password3) == 0 )
				   {
			strcpy(USER1->password1,password2);
				   return 1;
				   }
			  else
				   {
					fflush(stdin);
					printf("两次输入的密码不相同，请重新输入\n");
					
						system("pause");
						break;
					}
			}
	  else
	  {
	   
	   ++i;
	   printf("账号或密码错误\n");
	   printf("请按任意键继续...\n");
	   getchar(); 
	  }
	} while (i<3);
	printf("三次输入错误，无法修改!\n");
	return 0;
}

//student函数入口（学生端入口）
void student()
{

    int i;
	ReadData1();
	while(1)
	{
		system("cls");
		printf("\t 1>>登录系统\n");	
		printf("\t 2>>修改密码\n");
		printf("\t 3>>退出系统\n");
		printf("\t 请输入代号: ");

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

//学生登陆后选择功能代码
void Interface()
{    
    int b_num;
	while(1)
	{
		void Printf_line_two();		
		Printf_line_two();
        printf("\n功能代号: ");
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
			printf("输入错误");
			system("pause");
			break;
		}
		system("cls");
	}
}

//登录后功能界面
void Printf_line_two()
{
	printf("======欢迎登陆学生账号管理系统======\n");
    printf("       ===1>>查看个人信息===\n");
	printf("       ===2>>查看个人排名===\n");
	printf("         ===3>>学生留言===\n");
	printf("         ===4>>查看回复===\n");
	printf("           ===5>>返回===\n");
}

//读取文件
void sread()
{
	FILE *fp_file = NULL;
	int i;
	fp_file = fopen("d:\\xingong.txt","r");
	if(fp_file==NULL)
	{
		printf("\n暂时还未录入学生信息\n");
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

//1.学生查看信息
void slook()
{
	char account[25];
	int i;
	char ch;
	if(number==0) 
	{
		printf("\n当前还未录入学生信息\n");
		return;
	}
	printf("\n请输入要查找学号:\n");
    gets(account);
	for(i=0;i<number;i++)
	{
		if(strcmp(stu2[i].account,account)==0)
		{
			printf("\n");
			printf("学号:%s\n",stu2[i].account);
			printf("姓名:%s\n",stu2[i].name);
			printf("学院:%s\n",stu2[i].college);
			printf("专业年级:%s\n",stu2[i].year_class);
			printf("课程-成绩:%s\n",stu2[i].lessons_score);
			printf("学分:%.2f\n",stu2[i].credit);
			printf("\n");
			ch=getche();
		}
	}

}

//2.学生查看排名
void sranking()
{
	char account[25];
	int i;
	printf("\n请输入查询学号:");
	gets(account);
	for(i=0;i<number;i++)
	{
		if(strcmp(stu2[i].account,account)==0)
		{
			printf("\n");
			printf("\t名次:%d\n",i+1);
			printf("\t学分:%.2f\n",stu2[i].credit);
		}
	}
	getchar();
	fflush(stdin);
	Interface();
}

//3.留言
void massage()
{
	FILE *fp_file = NULL;
	char words[1000];
	printf("\n请输入内容\n");
	gets(words);
	fp_file = fopen("d:\\liuyan.txt","w");
	fprintf(fp_file,"%s\n",words);
}

//4.查看回复
void replylook()
{
	FILE *fp_file;
	char ch;
	fp_file = fopen("d:\\liuyan.txt","r");
	while((ch = fgetc(fp_file)) != EOF)
		fputc(ch,stdout);
	fclose(fp_file);

}
