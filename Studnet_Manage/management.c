#include "Information.h"
#include <stdlib.h>
#include <stdio.h>

//定义变量
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

//管理员端密码服务
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

			printf(" \n请输入帐号: ");
			scanf("%s",username1);
			printf(" \n请输入密码: ");
			scanf("%s",password1);
			system("cls");
		

			if  (strcmp(password1,USER2.password1) == 0 &&
				strcmp(username1,USER2.username1) == 0)
				{
					printf("恭喜登录成功\n");
					read();
					interfacetwo();
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

extern int ModifyPsw2(struct USER2 *USER2)
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
		if(strcmp(username1,USER2->username1) == 0 && strcmp(password1,USER2->password1) == 0)
		  {
		   printf("请输入新密码: ");
		   scanf("%s",password2);
		   printf("请再次输入新密码: ");
		   scanf("%s",password3);
			   if (strcmp(password2, password3) == 0 )
				   {
			strcpy(USER2->password1,password2);
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

void management()
{

    int i;
	ReadData2();
	while(1)
	{
		system("cls");
		printf("\t 1>>登录系统\n");	
		printf("\t 2>>修改密码\n");
		printf("\t 3>>退出系统\n");
		printf("\t 请输入代号: ");

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

//管理员登录后选择功能代码
void interfacetwo()
{
    int c_num;
	while(1)
	{
		void Printf_line_three();		
		Printf_line_three();
        printf("\n功能代号: ");
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
			printf("输入错误");
			system("pause");
			break;
		}
		system("cls");
	}
}

//登录后功能界面
void Printf_line_three()
{
	printf("======欢迎登陆管理员管理系统======\n");
    printf("          ===1>>增添===\n");
	printf("          ===2>>注销===\n");
	printf("     ===3>>输入学号查看学生信息===\n");
	printf("          ===4>>总览===\n");
	printf("          ===5>>修改===\n");
	printf("      ===6>>查看学分排名===\n");
	printf("         ===7>>查看留言===\n");
	printf("          ===8>>返回===\n");
}

//文件读取
void read()
{
	FILE *fp_file = NULL;
	int i;
	fp_file = fopen("d:\\xingong.txt","r");
	if(fp_file==NULL)
	{
		printf("\n暂时还未录入学生信息\n\n\n");
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

//文件保存
void save()
{
    FILE *fp_file = NULL;
	int i;
	fp_file = fopen("d:\\xingong.txt","w");
	if(NULL==fp_file)
	{
		printf("\n目前无学生信息\n");
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

//1.增添信息
void information()
{
	char ch;
	int j;
	printf("\n请输入新的学号:");
	gets(stu[num].account);
	while(strlen(stu[num].account)==0)
	{
		printf("学号不可为空，请重新输入:");
		gets(stu[num].account);
	}
	for(j=0;j<num;j++)
	if(strcmp(stu[j].account,stu[num].account)==0)
	{
		printf("因为已有重复账号，此条信息将不被记录.....\n");
		return;
	}

	fflush(stdin);
	printf("\n请输入姓名:");
	gets(stu[num].name);
	fflush(stdin);

	printf("\n请输入学院:");
	gets(stu[num].college); 
	fflush(stdin);

	printf("\n请输入专业年级班级:");
    gets(stu[num].year_class);
	fflush(stdin);
	
    printf("\n请输入课程-成绩:");
	gets(stu[num].lessons_score);
	fflush(stdin);
	
    printf("\n请输入学分:");
	scanf("%f",&stu[num].credit);
	fflush(stdin);
	
	printf("\n增添成功\n");
	printf("学号:%s\n姓名:%s\n学院:%s\n专业年级:%s\n课程-成绩:%s\n学分:%.2f\n",stu[num].account,stu[num].name,stu[num].college,stu[num].year_class,stu[num].lessons_score,stu[num].credit);
	num++;
	printf("是否继续添加(Y/N)?\n");
	ch=getche();
	tranking();
	if(ch=='y'||ch=='Y')
		information();
	else return;
}

//2.注销
void delete()
{
	char account[25];
	int i;
	char ch;
	printf("\t请输入要注销的学号：");
	gets(account);
	for(i=0;i<num;i++)
	{
		if(strcmp(stu[i].account,account)==0)
		{
			printf("\n你确认要删除%s号学号信息吗(y/n)?\n",stu[i].account);
			ch=getche();
			if(ch=='y'||ch=='Y') 
			{
				printf("\n学生号为%s的信息已经成功被删除，是否继续(y/n)?\n",stu[i].account);
				stu[i]=stu[num-1];num--;
				ch=getche();
				printf("\n");
				if(ch=='y'||ch=='Y') 
					delete();
				else return;
			}
			else 
			{
				printf("\n你选择不删除学号信息\n");
				getchar();
				return;
			}
		}
	}
	if(i==num) {printf("\n你所要删除的学生学号信息不存在\n");getchar();return;}
}

//3.查询
void tlook()
{
	char account[25];
	char ch;
	int i;
	if(num==0) 
	{
		printf("\n当前没有学生信息");
		return;
	}
	printf("\n请输入要查找学号:\n");
    gets(account);
	for(i=0;i<num;i++)
	{
		if(strcmp(stu[i].account,account)==0)
		{
			printf("\n");
			printf("学号:%s\n",stu[i].account);
			printf("姓名:%s\n",stu[i].name);
			printf("学院:%s\n",stu[i].college);
			printf("专业年级:%s\n",stu[i].year_class);
			printf("课程-成绩:%s\n",stu[i].lessons_score);
			printf("学分:%.2f\n",stu[i].credit);
			printf("是否继续(y/n)?\n");
			ch=getche();
			printf("\n");
			if(ch=='y'||ch=='Y') 
				tlook();
			else return;
		}
	}
    if(i==num) 
	{
		printf("\n\t\t账号信息不存在....");
		getch();
		return;
	}
}

//4.总览
void pandect()
{
    int i;
	system("cls");
	tranking();
	for(i=0;i<num;i++)
	{
		printf("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
		printf("学号:%s\n",stu[i].account);
		printf("姓名:%s\n",stu[i].name);
		printf("学院:%s\n",stu[i].college);
		printf("专业年级:%s\n",stu[i].year_class);
		printf("课程-成绩:%s\n",stu[i].lessons_score);
		printf("学分:%.2f\n",stu[i].credit);
		printf("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
	}
	if(num==0)
	{
		printf("\n目前学生数为0\n");
	}
	else 
	{
		printf("\n目前学生数为:%d\n",num);
	}
	getchar();
	return;
}

//5.修改
void revise()
{
	char account[25];
	int i;
	char ch;
	printf("\t请输入要修改的学号：");
	gets(account);
	for(i=0;i<num;i++)
	{
		if(strcmp(stu[i].account,account)==0)
		{
			printf("\n");
			printf("学号:%s\n",stu[i].account);
			printf("姓名:%s\n",stu[i].name);	
			printf("学院:%s\n",stu[i].college);
			printf("专业年级:%s\n",stu[i].year_class);
			printf("课程-成绩:%s\n",stu[i].lessons_score);
			printf("学分:%.2f\n",stu[i].credit);
			printf("是否继续修改(y/n)?");
			ch=getche();
			if(ch=='y'||ch=='Y')
			{
				fflush(stdin);
				printf("\n请输入学号:");
				gets(stu[i].account);
				fflush(stdin);
				
				printf("\n请输入姓名:");
				gets(stu[i].name);
				fflush(stdin);

				printf("\n请输入学院:");
				gets(stu[i].college);
				fflush(stdin);
				
				printf("\n请输入专业年级班级:");
				gets(stu[i].year_class);
				fflush(stdin);
				
				printf("\n请输入课程-成绩:");
				gets(stu[i].lessons_score);
				fflush(stdin);
				
				printf("\n请输入学分:");
				scanf("%f",&stu[i].credit);
				fflush(stdin);
				
				printf("\n修改成功\n");
				printf("学号:%s\n姓名:%s\n学院:%s\n专业年级:%s\n课程-成绩:%s\n学分:%.2f\n",stu[i].account,stu[i].name,stu[i].college,stu[i].year_class,stu[i].lessons_score,stu[i].credit);

			}
			else
			{
				printf("\n选择不修改\n");
				return;
			}
		}
	}
}
//进行排名
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

//6.排名
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
		printf("名次:%d\n",i+1);
		printf("学号:%s\t",stu[i].account);
		printf("姓名:%s\t",stu[i].name);
		printf("学院:%s\t",stu[i].college);
		printf("专业年级:%s\t",stu[i].year_class);
		printf("课程-成绩:%s\t",stu[i].lessons_score);
		printf("学分:%.2f\n",stu[i].credit);
		printf("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
	}
}
		
//7.查看留言
void massagelook()
{
	FILE *fp_file = NULL;
	char ch;
	fp_file = fopen("d:\\liuyan.txt","r");
	if(fp_file==NULL)
	{
		printf("\n暂无学生留言\n");
		return;
	}
	else
	{
		while((ch = fgetc(fp_file)) != EOF)
			fputc(ch,stdout);
		fclose(fp_file);
		printf("\n是否回复留言(Y/N)\n");
		ch=getche();
		if(ch=='y'||ch=='Y')
		{
			reply();
		}
	}
}

//回复
void reply()
{
	FILE *fp_file = NULL;
	char words[1000];
	printf("\n请输入内容\n");
	gets(words);
	fp_file = fopen("d:\\liuyan.txt","a");
	fprintf(fp_file,"%s\n",words);
	fclose(fp_file);
}