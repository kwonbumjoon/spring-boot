package kr.com.ezen;

import java.util.List;

public interface MapperInterface {
	
	int insertMember(MemberVO vo);
	int updateMember(MemberVO vo);
	int deleteMember(int id);
	
	MemberVO selectMemberOne(int id);
//	선택한 데이터를 리스트에 담아서 가져오기 위해 사용
	List<MemberVO> selectMemberList();
}
