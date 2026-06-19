package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.RolRequestDTO;
import cl.dondevamos.backend.dto.response.RolResponseDTO;
import cl.dondevamos.backend.service.RolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {
    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RolResponseDTO> crear(@Valid @RequestBody RolRequestDTO rol) {
        RolResponseDTO response = service.crear(rol);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RolResponseDTO>> obtenerTodos() {
        List<RolResponseDTO> roles = service.obtenerTodos();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDTO> obtenerPorId(@PathVariable Integer id) {
        RolResponseDTO rol = service.obtenerPorId(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody RolRequestDTO rol) {
        RolResponseDTO response = service.actualizar(id, rol);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
