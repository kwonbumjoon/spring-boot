package org.zerock.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class PasswordTest {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	public void testPassword() {
		log.info("bCryptPasswordEncoder : " + bCryptPasswordEncoder);
		
		String str = "1234";
		
		String encodeStr = bCryptPasswordEncoder.encode(str);
		
		log.info("-----------------------------------------------");
		log.info(encodeStr);
		
		boolean match = bCryptPasswordEncoder.matches(str, encodeStr);
		log.info("-----------------------------------------------");
		log.info(match);
	}
}
