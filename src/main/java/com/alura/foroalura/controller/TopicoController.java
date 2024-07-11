package com.alura.foroalura.controller;

import com.alura.foroalura.domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> todosTopicos(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByStatus(Status.ACTIVO, paginacion).map(DatosListadoTopicos::new));
    }

    @GetMapping("/especial")
    public ResponseEntity<Page<DatosListadoTopicos>> topicosEnAnio(@RequestParam(name = "anio") int anio,  @PageableDefault(size = 2) Pageable paginacion) {
        LocalDate firstDayOfYear = LocalDate.of(anio, 1, 1);
        LocalDate lastDayOfYear = LocalDate.of(anio, 12, 31);
        LocalDateTime firstDayOfYearAtMidnight = firstDayOfYear.atStartOfDay();
        LocalDateTime lastDayOfYearAt2359 = lastDayOfYear.atTime(LocalTime.MAX);

        return ResponseEntity.ok(topicoRepository.findByFechaCreacionBetweenOrderByFechaCreacionAsc(firstDayOfYearAtMidnight, lastDayOfYearAt2359, paginacion).map(DatosListadoTopicos::new));
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> adicionar(@RequestBody @Valid DatosRegistroTopíco datosRegistroTopíco,
                                            UriComponentsBuilder uriBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopíco));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso_id()
        );
        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.idTopico());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso_id()
        ));
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso_id()
        );
        return ResponseEntity.ok(datosTopico);
    }


}
