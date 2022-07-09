package com.finalproject.sistemaTurnosClinicaDental.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@ToString
@Entity
@Table(name = "usuarios_app")
public class UsuarioApp implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;
    private String name;

    @Column(unique = true)
    private String username;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private RolUsuario rolUsuario;

    public UsuarioApp() {
    }

    public UsuarioApp(String name, String username, String email, String password,
            RolUsuario rolUsuario) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rolUsuario = rolUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rolUsuario.name());

        return Collections.singletonList(grantedAuthority);
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
