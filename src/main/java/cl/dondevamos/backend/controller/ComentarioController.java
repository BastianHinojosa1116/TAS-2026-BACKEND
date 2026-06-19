package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.ComentarioRequestDTO;
import cl.dondevamos.backend.dto.response.ComentarioResponseDTO;
import cl.dondevamos.backend.service.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentarioController {
    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ComentarioResponseDTO> crear(@Valid @RequestBody ComentarioRequestDTO comentario) {
        ComentarioResponseDTO response = service.crear(comentario);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ComentarioResponseDTO>> obtenerTodos() {
        List<ComentarioResponseDTO> comentarios = service.obtenerTodos();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioResponseDTO> obtenerPorId(@PathVariable Integer id) {
        ComentarioResponseDTO comentario = service.obtenerPorId(id);
        return new ResponseEntity<>(comentario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComentarioResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody ComentarioRequestDTO comentario) {
        ComentarioResponseDTO response = service.actualizar(id, comentario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
