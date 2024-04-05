package kr.com.ezen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

//	생성자 주입
	private final MemberMapper memberMapper;

//	@Autowired 필드 주입
//	private MemberMapper Mapper;
	
	@Override
	public void insertMember(MemberVO vo) {
		memberMapper.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberMapper.updateMember(vo);
	}

	@Override
	public void deleteMember(int id) {
		memberMapper.deleteMember(id);
	}

	@Override
	public MemberVO SelectOne(int id) {
//		MemberVO vo = memberMapper.selectOneMember(id);
//		return vo;
		
		return memberMapper.selectOneMember(id);
	}

	@Override
	public List<MemberVO> list() {
		return memberMapper.selectAllList();
	}
	
}