�ֹ�����
      }ʹ��sqlite3���ߣ�ͨ���ֹ�����SQL������������ݿⴴ��.
  }�û���Linux�������н���������sqlite3������sqlite3����
                  ��װ����
                        sudo apt-get update//����Դ����
                        sudo apt-get install sqlite
                        sudo apt-get install vim 
                        
����ָ������
}��ʾ��������
    sqlite> .help
}�˳�sqlite3
    sqlite>.quit
}��ʾ��ǰ�򿪵����ݿ��ļ�
  sqlite>.database
}��ʾ���ݿ������б���
  sqlite>.tables
}�鿴��Ľṹ
  sqlite>.schema  <table_name>    ��ǺŲ���Ҫ����
    ����:sqlite> .schema table1
     ����sqlite3���򣬽�����Ҫ�������SQLite���ݿ����ֵ�"sqlite3"����ɡ�����ļ������ڣ��򴴽�һ���µģ����ݿ⣩�ļ���Ȼ�� sqlite3������ʾ������SQL������SQL��䣨�Էֺš��������������ûس���֮��SQL���ͻ�ִ�С�
        ���磬����һ������һ����"tb11"����Ϊ"ex1"��SQLite���ݿ⣬�������������
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
����ͨ����������ϵͳ���ļ���������ͨ����Ctrl + D�������ж��ַ���ͨ����Ctrl + C����
    �á�.separator�����������ı�ֽ�������磬Ϊ�˰ѷָ����Ϊһ�����ź�һ���ո񣬿�����������
sqlite> .separator ", "
sqlite> select * from tbl1;
hello, 10
goodbye, 20
sqlite>
�ڡ�line"ģʽ�£�ÿһ��λ������¼�е��������Լ�������ʾ��ÿ����������һ���Ⱥź���������ɡ���һ����¼��һ�����и���������һ����ģʽ��������ӣ�
sqlite> .mode line
sqlite> select * from tbl1;
one = hello
two = 10
one = goodbye
two = 20
sqlite>
    ����ģʽ�£�ÿ����¼��һ�������������������ж���ķ�ʽ��ʾ�����磺
sqlite> .mode column
sqlite> select * from tbl1;
one          two       
----------   ----------
hello        10        
goodbye      20        
sqlite>
 
/*******************************************/
����ΪSQL���ÿ�������� ; ����
}
}�����±�
     *sql="  "
    sqlite> create  table  <table_name> (f1  type1, f2  type2,��);
          ����:sqlite> create  table table1 (num int,data float,dis char(10));   name  text
                create table people(id, name, age);
}ɾ����
  sqlite>drop  table  <table_name>;

 }��ѯ�������м�¼
        sqlite>select  *  from  <table_name>; 

}��ָ��������ѯ���м�¼
    sqlite>select  *  from  <table_name>  where  <expression>��
       ����sqlite> select * from  table1  where  num=*2;
         ���:2|30.0|laing haoa
    select * from table_name order by field asc;����������ݼ�¼
    select * from table_name order by field desc
    select * from people where age>=10 and age <=15;
    select  name, age from people where age>= 10 and age<=15;
    select * from people limit 2;     //�������
    select * from people order by age;//������������
}���������¼�¼
  sqlite>insert  into  <table_name>  values (value1, value2,��);
         ����:sqlite> insert into table1 values(1,20.0,"good");

}��ָ������ɾ�����м�¼
  sqlite>delete  from  <table_name>  where  <expression>
    ����:sqlite> delete  from  table1  where  num=2;
}�޸ı��е�����
 sqlite> update people set name='xidada' where id=1
  sqlite>update  <table_name>  set  <f1=value1>, <f2=value2>��   where  <expression>;  

}�ڱ�������ֶ�
sqlite>alter table <table_name> add column <field> <type>;
      ����:sqlite> alter table table1  add   column   yx  char(10);
ɾ��ָ���� alter table table_name drop column col_name;

step1:create table people(id, name, age, tel);//��ǰ��ɾ��tel
step2:alter table people rename to temp;//����Ϊtemp
step3:create tabel people(id, name, age); // �����±�
step4:insert into people select id, name, age from temp;�������±�
//************************************************************///
1.����һ�����ݿ⣬ sqlite3  yourname.db    
2.���������һ�������ݱ�,��������Ϊ����ţ�����������༶��ѧ��(������Ϣ��);
3.�����һ����table2������        ID     num��price��     count
                                                         0        2       12.5            25.0
                                                         1        5        15.6            ����   
4.�������Ϣ����� �Ա��ֶΡ�     
5.ɾ����ļ۸���е�num = 5�����ݣ�

��ʾ����
NULL����ʶһ��NULLֵ
INTERGER����������
REAL��������
TEXT���ַ���  char(10) 
BLOB����������
��������
��˵���ݱ���ڴ�����¼�����������ڼӿ�������ݱ��ٶȡ�
create index index_name on table_name(field);
�������ѧ����stu_no�ֶΣ�����һ��������
create index student_index on student_table(stu_no);
������ɺ�sqlite3�ڶԸ��ֶβ�ѯʱ�����Զ�ʹ�ø�������
 
ɾ�����ݱ������
drop table table_name;
drop index index_name;
