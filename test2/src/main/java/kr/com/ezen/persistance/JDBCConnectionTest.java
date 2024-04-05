package kr.com.ezen.persistance;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCConnectionTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

//	junit test를 위해 사용한 어노테이션
	@Test
	public void testConnection() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"test2",
					"1234"
					);
//			출력시 원하는 레벨로 설정하여 필요없는 에러는 안보이게 끔 설정 및 출력
			log.info("Con : " + con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
