package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.AsistenciaEventoRequestDTO;
import cl.dondevamos.backend.dto.response.AsistenciaEventoResponseDTO;
import cl.dondevamos.backend.service.AsistenciaEventoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "http://localhost:4200")
public class AsistenciaEventoController {
    private final AsistenciaEventoService service;

    public AsistenciaEventoController(AsistenciaEventoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AsistenciaEventoResponseDTO> crear(@Valid @RequestBody AsistenciaEventoRequestDTO asistencia) {
        AsistenciaEventoResponseDTO response = service.crear(asistencia);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AsistenciaEventoResponseDTO>> obtenerTodos() {
        List<AsistenciaEventoResponseDTO> asistencias = service.obtenerTodos();
        return new ResponseEntity<>(asistencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaEventoResponseDTO> obtenerPorId(@PathVariable Integer id) {
        AsistenciaEventoResponseDTO asistencia = service.obtenerPorId(id);
        return new ResponseEntity<>(asistencia, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaEventoResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody AsistenciaEventoRequestDTO asistencia) {
        AsistenciaEventoResponseDTO response = service.actualizar(id, asistencia);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
