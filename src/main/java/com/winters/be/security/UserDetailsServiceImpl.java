package com.winters.be.security;

import com.winters.be.db.jpa.entity.MemberEntity;
import com.winters.be.db.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> principal = memberRepository.findByUsername(username);
        if(principal.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        MemberEntity member = principal.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+member.getRole()));
        return new User(member.getUsername(), member.getPassword(), authorities);
//        return new UserDetailsImpl(principal.get());
    }

//    public void saverUser(SignUpRequest request){
//        User user = request.toEntity(passwordEncoder);
//        userRepository.save(user);
//    }
}
