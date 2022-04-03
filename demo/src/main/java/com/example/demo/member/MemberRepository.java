package com.example.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	//select * from member where mem_id = ?
	public Member findByMemId(String memId);
}
