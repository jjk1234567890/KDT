package com.jht.mapper;

import java.util.ArrayList;

import com.jht.model.MemberDTO;

public interface MemberMapper {
	public void write(MemberDTO member);
	
	public ArrayList<MemberDTO> list();
	
	public MemberDTO detail(MemberDTO member);
	
	public MemberDTO login(MemberDTO member);
	
	public void modify(MemberDTO member);
	
	public void remove(MemberDTO member);
	
	
}