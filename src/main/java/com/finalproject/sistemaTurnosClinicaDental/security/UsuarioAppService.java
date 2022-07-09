package com.finalproject.sistemaTurnosClinicaDental.security;

import com.finalproject.sistemaTurnosClinicaDental.entity.UsuarioApp;
import com.finalproject.sistemaTurnosClinicaDental.repository.UsuarioAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAppService implements UserDetailsService {
    private final UsuarioAppRepository usuarioAppRepository;

    @Autowired
    public UsuarioAppService(UsuarioAppRepository usuarioAppRepository) {
        this.usuarioAppRepository = usuarioAppRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioApp usuarioApp =
                usuarioAppRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User email not found"));
        return usuarioApp;
    }
}
