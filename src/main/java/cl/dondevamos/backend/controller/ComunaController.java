package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.ComunaRequestDTO;
import cl.dondevamos.backend.dto.response.ComunaResponseDTO;
import cl.dondevamos.backend.service.ComunaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunas")
@CrossOrigin(origins = "http://localhost:4200")
public class ComunaController {
    private final ComunaService service;

    public ComunaController(ComunaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ComunaResponseDTO> crear(@Valid @RequestBody ComunaRequestDTO comuna) {
        ComunaResponseDTO response = service.crear(comuna);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ComunaResponseDTO>> obtenerTodos() {
        List<ComunaResponseDTO> comunas = service.obtenerTodos();
        return new ResponseEntity<>(comunas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunaResponseDTO> obtenerPorId(@PathVariable Integer id) {
        ComunaResponseDTO comuna = service.obtenerPorId(id);
        return new ResponseEntity<>(comuna, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComunaResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody ComunaRequestDTO comuna) {
        ComunaResponseDTO response = service.actualizar(id, comuna);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
