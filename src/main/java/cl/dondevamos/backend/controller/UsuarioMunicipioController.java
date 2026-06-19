package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.UsuarioMunicipioRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioMunicipioResponseDTO;
import cl.dondevamos.backend.service.UsuarioMunicipioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-municipio")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioMunicipioController {
    private final UsuarioMunicipioService service;

    public UsuarioMunicipioController(UsuarioMunicipioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioMunicipioResponseDTO> crear(@Valid @RequestBody UsuarioMunicipioRequestDTO usuario) {
        UsuarioMunicipioResponseDTO response = service.crear(usuario);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioMunicipioResponseDTO>> obtenerTodos() {
        List<UsuarioMunicipioResponseDTO> usuarios = service.obtenerTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioMunicipioResponseDTO> obtenerPorId(@PathVariable Integer id) {
        UsuarioMunicipioResponseDTO usuario = service.obtenerPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioMunicipioResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody UsuarioMunicipioRequestDTO usuario) {
        UsuarioMunicipioResponseDTO response = service.actualizar(id, usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
