package project.config.auth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import project.model.Member;
import project.repository.MemberRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService {
	
	Logger logger = LogManager.getLogger(PrincipalDetailsService.class);

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
		logger.info("PrincipalDetailsService loadUserByUsername memId : "+memId);
		Member memberEntity = memberRepository.findByMemId(memId);
		logger.info("PrincipalDetailsService loadUserByUsername memberEntity : "+memberEntity);
		if(memberEntity != null) {
			return new PrincipalDetails(memberEntity);
		}
		return null;
	}

}
