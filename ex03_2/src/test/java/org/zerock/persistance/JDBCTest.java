package org.zerock.persistance;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
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
					"book_ex",
					"book_ex"
					);
//			출력시 원하는 레벨로 설정하여 필요없는 에러는 안보이게 끔 설정 및 출력
			log.info("Con : " + con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
