手工创建
      }使用sqlite3工具，通过手工输入SQL命令行完成数据库创建.
  }用户在Linux的命令行界面中输入sqlite3可启动sqlite3工具
                  安装命令
                        sudo apt-get update//更新源代码
                        sudo apt-get install sqlite
                        sudo apt-get install vim 
                        
常用指令修炼
}显示所有命令
    sqlite> .help
}退出sqlite3
    sqlite>.quit
}显示当前打开的数据库文件
  sqlite>.database
}显示数据库中所有表名
  sqlite>.tables
}查看表的结构
  sqlite>.schema  <table_name>    尖角号不需要输入
    例如:sqlite> .schema table1
     启动sqlite3程序，仅仅需要敲入带有SQLite数据库名字的"sqlite3"命令即可。如果文件不存在，则创建一个新的（数据库）文件。然后 sqlite3程序将提示你输入SQL。敲入SQL语句（以分号“；”结束），敲回车键之后，SQL语句就会执行。
        例如，创建一个包含一个表"tb11"名字为"ex1"的SQLite数据库，你可以这样做：
$sqlite3 ex1
SQLite version 3.3.17
Enter ".help" for instructions
sqlite> create table tbl1(one varchar(10), two smallint);
sqlite> insert into tbl1 values('hello!', 10);
sqlite> insert into tbl1 values('goodbye', 20);
sqlite> select * from tbl1;
hello!|10
goodbye|20
sqlite>
可以通过敲你所用系统的文件结束符（通常是Ctrl + D）或者中断字符（通常是Ctrl + C）。
    用“.separator”点命令来改变分界符。例如，为了把分割符改为一个逗号和一个空格，可以这样做：
sqlite> .separator ", "
sqlite> select * from tbl1;
hello, 10
goodbye, 20
sqlite>
在“line"模式下，每一个位于条记录中的列在它自己那行显示。每行由列名、一个等号和列数据组成。下一条记录以一个空行隔开。这是一个行模式输出的例子：
sqlite> .mode line
sqlite> select * from tbl1;
one = hello
two = 10
one = goodbye
two = 20
sqlite>
    在列模式下，每条记录在一个单独的行中以数据列对齐的方式显示。列如：
sqlite> .mode column
sqlite> select * from tbl1;
one          two       
----------   ----------
hello        10        
goodbye      20        
sqlite>
 
/*******************************************/
以下为SQL命令，每个命令以 ; 结束
}
}创建新表
     *sql="  "
    sqlite> create  table  <table_name> (f1  type1, f2  type2,…);
          例如:sqlite> create  table table1 (num int,data float,dis char(10));   name  text
                create table people(id, name, age);
}删除表
  sqlite>drop  table  <table_name>;

 }查询表中所有记录
        sqlite>select  *  from  <table_name>; 

}按指定条件查询表中记录
    sqlite>select  *  from  <table_name>  where  <expression>；
       例如sqlite> select * from  table1  where  num=*2;
         结果:2|30.0|laing haoa
    select * from table_name order by field asc;升序输出数据记录
    select * from table_name order by field desc
    select * from people where age>=10 and age <=15;
    select  name, age from people where age>= 10 and age<=15;
    select * from people limit 2;     //限制输出
    select * from people order by age;//按照年龄排序
}向表中添加新记录
  sqlite>insert  into  <table_name>  values (value1, value2,…);
         例如:sqlite> insert into table1 values(1,20.0,"good");

}按指定条件删除表中记录
  sqlite>delete  from  <table_name>  where  <expression>
    例如:sqlite> delete  from  table1  where  num=2;
}修改表中的内容
 sqlite> update people set name='xidada' where id=1
  sqlite>update  <table_name>  set  <f1=value1>, <f2=value2>…   where  <expression>;  

}在表中添加字段
sqlite>alter table <table_name> add column <field> <type>;
      例如:sqlite> alter table table1  add   column   yx  char(10);
删除指定列 alter table table_name drop column col_name;

step1:create table people(id, name, age, tel);//当前表，删除tel
step2:alter table people rename to temp;//备份为temp
step3:create tabel people(id, name, age); // 创建新表
step4:insert into people select id, name, age from temp;导出到新表
//************************************************************///
1.创建一个数据库， sqlite3  yourname.db    
2.向里面添加一个新数据表,表中内容为：编号，你的姓名，班级，学号(个人信息表);
3.再添加一个表table2，内容        ID     num，price，     count
                                                         0        2       12.5            25.0
                                                         1        5        15.6            。。   
4.向个人信息表添加 性别字段。     
5.删除你的价格表中的num = 5的数据；

标示符：
NULL：标识一个NULL值
INTERGER：整数类型
REAL：浮点数
TEXT：字符串  char(10) 
BLOB：二进制数
建立索引
当说数据表存在大量记录，索引有助于加快查找数据表速度。
create index index_name on table_name(field);
例，针对学生表stu_no字段，建立一个索引：
create index student_index on student_table(stu_no);
建立完成后，sqlite3在对该字段查询时，会自动使用该索引。
 
删除数据表或索引
drop table table_name;
drop index index_name;
