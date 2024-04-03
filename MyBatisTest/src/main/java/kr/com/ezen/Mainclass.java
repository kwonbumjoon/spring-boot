package kr.com.ezen;

import java.io.InputStream;

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
			vo.setId(1);
			vo.setName("장합");
			vo.setPhone("010-3333-9999");
			vo.setAddress("서울시 도봉구");
			
//			정보 업데이트(새로운 정보 기입, 정보 수정)
//			mapper.updateMember(vo);
			
//			정보 업데이트(기존의 정보 삭제)
			mapper.deleteMember(1);

//			int result = mapper.insertMember(vo);
//			System.out.println("성공이면 " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
