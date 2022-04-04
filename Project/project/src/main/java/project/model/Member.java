package project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Data;

@DynamicInsert
@Entity
@Data
@SequenceGenerator (
			name="SEQ_MEMBER_GEN",
			sequenceName = "SEQ_MEMBER",
			initialValue = 1,
			allocationSize = 1
		)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER_GEN")
	@Column(name="mem_num")
	private int memNum;
	
	@Column(name="mem_code")
	private int memCode;
	
	@Column(name="mem_id")
	private String memId;
	
	@Column(name="mem_pw")
	private String memPw;
	
	@Column(name="mem_nick")
	private String memNick;
	
	@Column(name="mem_name")
	private String memName;
	
	@Column(name="mem_email")
	private String memEmail;
	
	@Column(name="mem_biznum")
	private String memBizNum;
	
	@Column(name="mem_bizname")
	private String memBizName;
	
	@Column(name="mem_tel")
	private String memTel;
	
	@Column(name="mem_join")
	private String memJoin;
	
	@Column(name="mem_role")
	private String memRole;
	
	private String provider;
	private String providerId;
	
	@Builder
	public Member(int memCode, String memId, String memPw, String memNick, String memName, String memEmail,
			String memBizNum, String memBizName, String memTel, String memJoin, String memRole, String provider,
			String providerId) {
		this.memCode = memCode;
		this.memId = memId;
		this.memPw = memPw;
		this.memNick = memNick;
		this.memName = memName;
		this.memEmail = memEmail;
		this.memBizNum = memBizNum;
		this.memBizName = memBizName;
		this.memTel = memTel;
		this.memJoin = memJoin;
		this.memRole = memRole;
		this.provider = provider;
		this.providerId = providerId;
	}
	
	
	
}
