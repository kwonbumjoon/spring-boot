package kr.com.ezen;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mainclass {

	public static void main(String[] args) {

		try {
			String resource = "kr/com/ezen/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//			System.out.println(sqlSessionFactory);

			SqlSession session = sqlSessionFactory.openSession(true);	// DB에 넣는 부분
			MapperInterface mapper = session.getMapper(MapperInterface.class);
			
			System.out.println("Session : " + session);

			MemberVO vo = new MemberVO();
//			member에 정보 기입
			vo.setId(4);
			vo.setName("조조");
			vo.setPhone("010-5555-8888");
			vo.setAddress("서울시 관악구");
			
//			정보 기입
//			mapper.insertMember(vo);
			
//			정보 업데이트(정보 수정)
//			mapper.updateMember(vo);
			
//			정보 업데이트(기존의 정보 삭제)
//			mapper.deleteMember(1);

//			int result = mapper.insertMember(vo);
//			System.out.println("성공이면 " + result);

//			선택한 member 값 불러오기
//			vo = mapper.selectMemberOne(1);
//			System.out.println(vo);
			
			List<MemberVO> list = mapper.selectMemberList();
			
			for(MemberVO v2 : list)
				System.out.println(v2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
