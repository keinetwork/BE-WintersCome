package com.winters.be.security;

import com.winters.be.db.jpa.entity.MemberEntity;
import com.winters.be.db.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> principal = memberRepository.findByUserid(username);
//        if(principal.isEmpty()){
//            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
//        }
//        UserRole.ADMIN.get
        return new UserDetailsImpl(principal.get());
    }

//    public void saverUser(SignUpRequest request){
//        User user = request.toEntity(passwordEncoder);
//        userRepository.save(user);
//    }
}
