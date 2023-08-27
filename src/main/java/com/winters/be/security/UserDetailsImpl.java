package com.winters.be.security;

import com.winters.be.db.jpa.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private final MemberEntity memberEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> roleList = new ArrayList<>();
        roleList.add(new GrantedAuthority() {
            private static final long serialVersionUID = 1L;
            @Override
            public String getAuthority() {
                return "ROLE_"+memberEntity.getRole();
            }
        });
        return roleList;
    }

    @Override
    public String getPassword() {
        return "{noop}" + memberEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return memberEntity.getUserid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
