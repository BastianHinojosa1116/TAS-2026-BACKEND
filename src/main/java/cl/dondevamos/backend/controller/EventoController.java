package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.EventoRequestDTO;
import cl.dondevamos.backend.dto.response.EventoResponseDTO;
import cl.dondevamos.backend.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {
    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> crear(@Valid @RequestBody EventoRequestDTO evento) {
        EventoResponseDTO response = service.crear(evento);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventoResponseDTO>> obtenerTodos() {
        List<EventoResponseDTO> eventos = service.obtenerTodos();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> obtenerPorId(@PathVariable Integer id) {
        EventoResponseDTO evento = service.obtenerPorId(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody EventoRequestDTO evento) {
        EventoResponseDTO response = service.actualizar(id, evento);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
