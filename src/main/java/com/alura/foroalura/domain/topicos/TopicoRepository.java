package com.alura.foroalura.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByStatus(Status status, Pageable pageable);

    Page<Topico> findByFechaCreacionBetweenOrderByFechaCreacionAsc(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
