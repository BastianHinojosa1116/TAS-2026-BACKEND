package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.FechaHorarioEventoRequestDTO;
import cl.dondevamos.backend.dto.response.FechaHorarioEventoResponseDTO;
import cl.dondevamos.backend.service.FechaHorarioEventoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fechas-evento")
@CrossOrigin(origins = "http://localhost:4200")
public class FechaHorarioEventoController {
    private final FechaHorarioEventoService service;

    public FechaHorarioEventoController(FechaHorarioEventoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FechaHorarioEventoResponseDTO> crear(@Valid @RequestBody FechaHorarioEventoRequestDTO fechaHorario) {
        FechaHorarioEventoResponseDTO response = service.crear(fechaHorario);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FechaHorarioEventoResponseDTO>> obtenerTodos() {
        List<FechaHorarioEventoResponseDTO> fechas = service.obtenerTodos();
        return new ResponseEntity<>(fechas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FechaHorarioEventoResponseDTO> obtenerPorId(@PathVariable Integer id) {
        FechaHorarioEventoResponseDTO fecha = service.obtenerPorId(id);
        return new ResponseEntity<>(fecha, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FechaHorarioEventoResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody FechaHorarioEventoRequestDTO fechaHorario) {
        FechaHorarioEventoResponseDTO response = service.actualizar(id, fechaHorario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
