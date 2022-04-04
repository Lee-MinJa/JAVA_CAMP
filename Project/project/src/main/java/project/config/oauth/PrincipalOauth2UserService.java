package project.config.oauth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import project.config.auth.PrincipalDetails;
import project.model.Member;
import project.repository.MemberRepository;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
	Logger logger = LogManager.getLogger(PrincipalOauth2UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		logger.info("userRequest : "+userRequest);
		logger.info("userRequest.getClientRegistration : "+userRequest.getClientRegistration());
		logger.info("userRequest.getAccessToken().getTokenValue() : "+userRequest.getAccessToken().getTokenValue());
		
		OAuth2User oauth2User = super.loadUser(userRequest);
		
		logger.info("oauth2User.getAttributes() : "+oauth2User.getAttributes());
		
		String provider = userRequest.getClientRegistration().getClientId();
		String providerId = oauth2User.getAttribute("sub");
		String memId = provider+"_"+providerId;
		String memPw = bCryptPasswordEncoder.encode("테스트");
		String memEmail = oauth2User.getAttribute("email");
		String memRoll = "ROLE_USER";
		
		Member memberEntity = memberRepository.findByMemId(memId);
		
		if(memberEntity == null) {
			memberEntity = Member.builder()
					.memId(memId)
					.memPw(memPw)
					.memEmail(memEmail)
					.memRole(memRoll)
					.provider(provider)
					.providerId(providerId)
					.build();
			memberRepository.save(memberEntity);
		}
		
		return new PrincipalDetails(memberEntity, oauth2User.getAttributes());
	}
	
}
