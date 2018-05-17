package utils;


import Bean.Film;
import Bean.Firm;
import Bean.Person;

/**
 * Query 查询类
 * 1）处理查询的request参数
 * 2）生成对应的SQL语句
 */
public class Query {

    private String tableName;
    private String username;
    private String password;

    private String sql;             //查询对应的sql语句

    private Film film;
    private Firm firm;
    private Person person;

    //电影查询对应的构造函数
    public Query(String tableName, String username, String password, Film film){
        this.tableName = tableName;
        this.username = username;
        this.password = password;
        this.film = film;
    }

    //发行公司对应的构造函数
    public Query(String tableName, String username, String password, Firm firm){
        this.tableName = tableName;
        this.username = username;
        this.password = password;
        this.firm = firm;
    }

    //人物查询对应的构造函数
    public Query(String tableName, String username, String password, Person person){
        this.tableName = tableName;
        this.username = username;
        this.password = password;
        this.person = person;
    }


}
