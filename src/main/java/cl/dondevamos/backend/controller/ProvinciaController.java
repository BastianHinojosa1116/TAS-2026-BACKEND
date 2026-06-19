package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.ProvinciaRequestDTO;
import cl.dondevamos.backend.dto.response.ProvinciaResponseDTO;
import cl.dondevamos.backend.service.ProvinciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincias")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciaController {
    private final ProvinciaService service;

    public ProvinciaController(ProvinciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProvinciaResponseDTO> crear(@Valid @RequestBody ProvinciaRequestDTO provincia) {
        ProvinciaResponseDTO response = service.crear(provincia);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProvinciaResponseDTO>> obtenerTodos() {
        List<ProvinciaResponseDTO> provincias = service.obtenerTodos();
        return new ResponseEntity<>(provincias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvinciaResponseDTO> obtenerPorId(@PathVariable Integer id) {
        ProvinciaResponseDTO provincia = service.obtenerPorId(id);
        return new ResponseEntity<>(provincia, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvinciaResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody ProvinciaRequestDTO provincia) {
        ProvinciaResponseDTO response = service.actualizar(id, provincia);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
