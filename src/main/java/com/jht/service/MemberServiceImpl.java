package com.jht.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jht.mapper.MemberMapper;
import com.jht.model.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper mm; // MemberMapper mm = new MemberMapper();
	
	// 회원가입
	public void write(MemberDTO member) {
		// 회원가입 되게 해라.
		mm.write(member);
	}
	// 회원정보수정
	public void modify(MemberDTO member) {
		// 회원정보수정 되게 해라.
		mm.modify(member);
	}
	// 회원정보수정
	public void remove(MemberDTO member) {
		// 회원정보수정 되게 해라.
		mm.remove(member);
	}
	// 회원목록리스트(관리자)
	public ArrayList<MemberDTO> list() {
		// 회원 목록 리스트 보여줘.
		return mm.list();
	}
	// 회원상세내용(관리자)
	public MemberDTO detail(MemberDTO member) {
		// 회원상세내용 보여줘.
		return mm.detail(member);
	}
	// 로그인
	public MemberDTO login(MemberDTO member) {
		return mm.login(member);
	}

}
