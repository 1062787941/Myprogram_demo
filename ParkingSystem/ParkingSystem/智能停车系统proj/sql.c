#include <stdio.h>
#include <sqlite3.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define PATH  "./test.db"
#define SQL_LEN  100

int main(int argc, char **argv)
{
	sqlite3 *db = NULL;
	char *errmsg = NULL;
	char sql[SQL_LEN];

	if ((sqlite3_open(PATH, &db)) != SQLITE_OK)
	{
		perror("打开出错");
		printf("why:%s\n", sqlite3_errmsg(db));
		exit(EXIT_FAILURE);
	}
	else
	{
		printf("sqlite3_open ok\n");
	}

	//***********创建 traval表********//
	memset(sql, 0, SQL_LEN);
	//printf("create table traval(id int, name text, addr text");
	sprintf(sql, "create table traval(id int, name text, addr text)");
	//sqlite3_exec(db, "create table traval(id int, name text, addr text)", NULL, NULL, &errmsg)
	if ((sqlite3_exec(db, sql, NULL, NULL, &errmsg)) != SQLITE_OK)
	{
		perror("创建出错");
		printf("why:%s\n", errmsg);
		exit(EXIT_FAILURE);
	}
	else
	{
		printf("create ok\n");
	}

	//insert into traval values(1, 'paris', 'French');
	//****向表中添加数据**************//	
	memset(sql, 0, SQL_LEN);
	//printf("create table traval(id int, name text, addr text");
	sprintf(sql, "insert into traval values(1, 'paris', 'French')");
	//sqlite3_exec(db, "insert into traval values(1, 'paris', 'French')", NULL, NULL, &errmsg)
	if((sqlite3_exec(db, sql, NULL, NULL, &errmsg)) != SQLITE_OK)
	{
		perror("添加出错");
		printf("why:%s\n", errmsg);
		exit(EXIT_FAILURE);
	}
	else
	{
		printf("insert into ok\n");
	}

	sqlite3_close(db);
	return 0;
}

