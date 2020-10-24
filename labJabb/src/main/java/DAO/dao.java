package DAO;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public abstract class dao{
    protected DataSource ds = new MysqlDataSource();
    protected String user = "root";
    protected String password = "Z1s2e3z1s2e3";
}
