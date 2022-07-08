package com.finalproject.sistemaTurnosClinicaDental.repository;

import com.finalproject.sistemaTurnosClinicaDental.entity.UsuarioApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UsuarioAppRepository extends JpaRepository<UsuarioApp, Long> {
    Optional<UsuarioApp> findByEmail(String email);
}
