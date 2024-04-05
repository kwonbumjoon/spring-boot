package kr.com.ezen.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	@Autowired
	private MemberMapper mapper;
	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.id(120)
				.name("한조")
				.phone("010-3333-4444")
				.address("경기도 화성시")
				.build();
		mapper.insertMember(vo);
	}
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
				.id(120)
				.name("겐지")
				.phone("010-5555-6666")
				.address("경기도 수원시")
				.build();
		mapper.updateMember(vo);	
	}
	
	@Test
	public void testDelete() {
		log.info(mapper.deleteMember(120));
	}
	
	@Test
	public void testAllList() {
		mapper.selectAllList().forEach(vo -> log.info(vo));
	}
}
