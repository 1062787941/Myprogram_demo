��̽ӿ�
create table tab1(id integer primary key autoincrement ,name text unique)
}int   sqlite3_open(char  *path,   sqlite3 **db)  ==  sqlite_ok��
    ���ܣ���sqlite���ݿ�
         path�����ݿ��ļ�·��  ../xx.db
            db��ָ��sqlite�����ָ��
       ����ֵ���ɹ�����0��ʧ�ܷ��ش�����(����ֵ)//
}int   sqlite3_close(sqlite3 *db);
        ���ܣ��ر�sqlite���ݿ�
        ����ֵ���ɹ�����0��ʧ�ܷ��ش�����
}const  char  *sqlite3_errmsg(sqlite3 *db);
        ����ֵ�����ش�����Ϣ


# gcc  -o  test  test.c  -l sqlite3  / gcc filename.c  -o   outname     -lsqlite3

///******************************************************//
?int  sqlite3_exec(sqlite3*,  const char *sql,   sqlite3_callback,   void *,    char **errmsg );
���ܣ�ִ��һ�� sql ���ĺ�����
?��1��������ǰ��open�����õ���ָ�롣
?��2������const char *sql ��һ�� sql ��䣬��\0��β��
?��3������sqlite3_callback �ǻص������������ִ��֮��sqlite3��ȥ�������ṩ�������������ʲô�ǻص�����?��
��4������void * �������ṩ��ָ�룬����Դ����κ�һ��ָ��������������������ջᴫ���ص��������棬�������Ҫ����ָ����ص�������������NULL��

//******************************************************//