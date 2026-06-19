package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.MunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.MunicipioResponseDTO;
import cl.dondevamos.backend.service.MunicipioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
@CrossOrigin(origins = "http://localhost:4200")
public class MunicipioController {
    private final MunicipioService service;

    public MunicipioController(MunicipioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MunicipioResponseDTO> crear(@Valid @RequestBody MunicipioRequestDTO municipio) {
        MunicipioResponseDTO response = service.crear(municipio);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MunicipioResponseDTO>> obtenerTodos() {
        List<MunicipioResponseDTO> municipios = service.obtenerTodos();
        return new ResponseEntity<>(municipios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioResponseDTO> obtenerPorId(@PathVariable Integer id) {
        MunicipioResponseDTO municipio = service.obtenerPorId(id);
        return new ResponseEntity<>(municipio, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MunicipioResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody MunicipioRequestDTO municipio) {
        MunicipioResponseDTO response = service.actualizar(id, municipio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
