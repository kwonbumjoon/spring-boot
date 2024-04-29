package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper replyMapper;
	
	private Long[] bnoArr = {11820L, 11819L, 11818L, 11817L, 11816L};
	
	@Test
	public void testMapper() {
		log.info(replyMapper);
	}
	
	@Test
	public void testCreate() {
		IntStream.range(1, 50).forEach(i -> {
			
			ReplyVO vo = ReplyVO.builder()
					.bno(bnoArr[i%5])
					.reply("두번째 테스트" + i)
					.replyer("replyer" + i)
					.build();
			replyMapper.insert(vo);
		});
	}

	
	
}
