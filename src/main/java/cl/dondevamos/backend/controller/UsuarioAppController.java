package cl.dondevamos.backend.controller;

import cl.dondevamos.backend.dto.request.UsuarioAppRequestDTO;
import cl.dondevamos.backend.dto.response.UsuarioAppResponseDTO;
import cl.dondevamos.backend.service.UsuarioAppService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-app")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioAppController {
    private final UsuarioAppService service;

    public UsuarioAppController(UsuarioAppService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioAppResponseDTO> crear(@Valid @RequestBody UsuarioAppRequestDTO usuario) {
        UsuarioAppResponseDTO response = service.crear(usuario);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioAppResponseDTO>> obtenerTodos() {
        List<UsuarioAppResponseDTO> usuarios = service.obtenerTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAppResponseDTO> obtenerPorId(@PathVariable Integer id) {
        UsuarioAppResponseDTO usuario = service.obtenerPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioAppResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody UsuarioAppRequestDTO usuario) {
        UsuarioAppResponseDTO response = service.actualizar(id, usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
