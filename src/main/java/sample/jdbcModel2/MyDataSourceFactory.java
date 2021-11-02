package sample.jdbcModel2;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class MyDataSourceFactory {

	public static DataSource getOracleDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		// Mtsql이면 MysqlDataSource
		OracleDataSource oracleDS = null;
		
		try {
			/* "db.properties"라는 파일에 접속정보를 저장한 뒤, 이를 읽어서 처리하는 방식이다.
			 	이전의 DriverManager를 활용한 방식보다 더 편해졌다. */
			fis = new FileInputStream("db.properties");
			props.load(fis);
			oracleDS = new OracleDataSource();
			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return oracleDS;
	}
}
