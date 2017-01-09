#include <sqlite3.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	int a;
	char name[20];
	char num[20];
}USER;

int main(int argc, const char *argv[])
{
	sqlite3 *my_sql = NULL;
	char buf[100] = "\0";
	sqlite3_stmt *my_stmt;
	USER temp, result;

	temp.a = 11;
	strcpy(temp.name, "jack");
	strcpy(temp.num, "119");
	

	if(sqlite3_open("sqlite.db", &my_sql)  != SQLITE_OK)
	{
		fprintf(stderr, "open my sql:%s\n", sqlite3_errmsg(my_sql));
		exit(EXIT_FAILURE);
	}
//--------------------------------------------------------------------------
	sprintf(buf, "create table if not exists %s (user_info blob);", "tb1");
	if(sqlite3_prepare(my_sql, buf, strlen(buf), &my_stmt, NULL) != SQLITE_OK)
	{
		fprintf(stderr, "prepare my sql:%s\n", sqlite3_errmsg(my_sql));
		exit(EXIT_FAILURE);
	}

	if(sqlite3_step(my_stmt) != SQLITE_DONE)
	{
		printf("not over\n");
		exit(EXIT_FAILURE);
	}
	sqlite3_finalize(my_stmt);
//--------------------------------------------------------------------------
	sprintf(buf, "insert into %s values (?);", "tb1");
	if(sqlite3_prepare(my_sql, buf, strlen(buf), &my_stmt, NULL) != SQLITE_OK)
	{
		fprintf(stderr, "prepare my sql:%s\n", sqlite3_errmsg(my_sql));
		exit(EXIT_FAILURE);
	}
	if(sqlite3_bind_blob(my_stmt, 1, &temp, sizeof(temp), NULL) != SQLITE_OK)
	{
		fprintf(stderr, "bind my sql:%s\n", sqlite3_errmsg(my_sql));
		exit(EXIT_FAILURE);
	}

	if(sqlite3_step(my_stmt) != SQLITE_DONE)
	{
		printf("not over\n");
		exit(EXIT_FAILURE);
	}
	sqlite3_finalize(my_stmt);
//--------------------------------------------------------------------------
	sprintf(buf, "select * from %s;", "tb1");
	if(sqlite3_prepare(my_sql, buf, strlen(buf), &my_stmt, NULL) != SQLITE_OK)
	{
		fprintf(stderr, "prepare my sql:%s\n", sqlite3_errmsg(my_sql));
		exit(EXIT_FAILURE);
	}

	while(sqlite3_step(my_stmt) == SQLITE_ROW)
	{
		memcpy(&result, (USER *)sqlite3_column_blob(my_stmt, 0), sizeof(USER));
		printf("a:%d\n name:%s\n num:%s\n", result.a, result.name, result.num);
	}
	sqlite3_finalize(my_stmt);
//--------------------------------------------------------------------------
	sqlite3_close(my_sql);
	return 0;
}


