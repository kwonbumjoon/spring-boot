package kr.com.ezen.persistance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testGetTime() {
		log.info("=======================================");
		log.info(memberMapper.getClass().getName());
		log.info(memberMapper.getTime());
		log.info("=======================================");
	}
	
	@Test
	public void testInsert() {
		for(int i=1; i<20; i++) {
			MemberVO vo = MemberVO.builder()
					.id(i)
					.name("user " + i)	
					.phone("010-12" + i + "-1234")
					.address("경기도 수원시 " + i)
					.build();
			memberMapper.insertMember(vo);
		}
	}
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
				.id(5)
				.name("user 50")
				.phone("010-1255-1234")
				.address("경기도 수원시")
				.build();
		memberMapper.insertMember(vo);
	}
	
	@Test
	public void testDelete() {
		memberMapper.deleteMember(3);
	}
	
	@Test
	public void testSelectOne() {
		MemberVO vo = memberMapper.selectOneMember(5);
		log.info("==>>" + vo);
	}
	
	@Test
	public void testAllList() {
		memberMapper.selectAllList().forEach(vo -> log.info(vo));
	}
	
}
