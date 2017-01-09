编程接口
create table tab1(id integer primary key autoincrement ,name text unique)
}int   sqlite3_open(char  *path,   sqlite3 **db)  ==  sqlite_ok；
    功能：打开sqlite数据库
         path：数据库文件路径  ../xx.db
            db：指向sqlite句柄的指针
       返回值：成功返回0，失败返回错误码(非零值)//
}int   sqlite3_close(sqlite3 *db);
        功能：关闭sqlite数据库
        返回值：成功返回0，失败返回错误码
}const  char  *sqlite3_errmsg(sqlite3 *db);
        返回值：返回错误信息


# gcc  -o  test  test.c  -l sqlite3  / gcc filename.c  -o   outname     -lsqlite3

///******************************************************//
?int  sqlite3_exec(sqlite3*,  const char *sql,   sqlite3_callback,   void *,    char **errmsg );
功能：执行一条 sql 语句的函数。
?第1个参数是前面open函数得到的指针。
?第2个参数const char *sql 是一条 sql 语句，以\0结尾。
?第3个参数sqlite3_callback 是回调，当这条语句执行之后，sqlite3会去调用你提供的这个函数。（什么是回调函数?）
第4个参数void * 是你所提供的指针，你可以传递任何一个指针参数到这里，这个参数最终会传到回调函数里面，如果不需要传递指针给回调函数，可以填NULL。

//******************************************************//