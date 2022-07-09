package com.finalproject.sistemaTurnosClinicaDental.security.config;

import com.finalproject.sistemaTurnosClinicaDental.entity.RolUsuario;
import com.finalproject.sistemaTurnosClinicaDental.entity.UsuarioApp;
import com.finalproject.sistemaTurnosClinicaDental.repository.UsuarioAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final UsuarioAppRepository usuarioAppRepository;

    @Autowired
    public DataLoader(UsuarioAppRepository usuarioAppRepository) {
        this.usuarioAppRepository = usuarioAppRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPasswordUser = passwordEncoder.encode("user");
        usuarioAppRepository.save(new UsuarioApp("Usuario", "user", "user@user.com",
                                                 hashedPasswordUser, RolUsuario.USER));

        String hashedPasswordAdmin = passwordEncoder.encode("admin");
        usuarioAppRepository.save(new UsuarioApp("Administrador", "admin", "admin@admin.com",
                                                 hashedPasswordAdmin, RolUsuario.ADMIN));
    }
}
