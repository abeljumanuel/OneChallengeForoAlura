package com.alura.foroalura.domain.topicos;

import com.alura.foroalura.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime fechaCreacion;
    @NotNull
    private long autor_id;
    @NotNull
    private long curso_id;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Topico(DatosRegistroTopíco datosRegistroTopíco) {
        this.titulo = datosRegistroTopíco.titulo();
        this.mensaje = datosRegistroTopíco.mensaje();
        this.fechaCreacion = LocalDateTime.now(); // Set current timestamp
        this.autor_id = Long.parseLong(datosRegistroTopíco.idUsuario());
        this.curso_id = datosRegistroTopíco.idCurso();
        this.status = Status.ACTIVO;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.idUsuario() != null) {
            this.autor_id = Long.parseLong(datosActualizarTopico.idUsuario());
        }
        if (datosActualizarTopico.idCurso() > 0) {
            this.curso_id = datosActualizarTopico.idCurso();
        }
        if (datosActualizarTopico.titulo() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
    }

    public void desactivarTopico() {
        this.status = Status.INACTIVO;
    }
}