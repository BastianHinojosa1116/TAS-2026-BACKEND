package cl.dondevamos.backend.service;

import cl.dondevamos.backend.dto.request.CategoriaRequestDTO;
import cl.dondevamos.backend.dto.response.CategoriaResponseDTO;
import cl.dondevamos.backend.entity.Categoria;
import cl.dondevamos.backend.exception.ResourceNotFoundException;
import cl.dondevamos.backend.mapper.CategoriaMapper;
import cl.dondevamos.backend.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaServiceImpl(CategoriaRepository repository, CategoriaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoriaResponseDTO crear(CategoriaRequestDTO categoria) {
        Categoria entity = mapper.toEntity(categoria);
        Categoria saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public CategoriaResponseDTO obtenerPorId(Integer id) {
        Categoria entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<CategoriaResponseDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaResponseDTO actualizar(Integer id, CategoriaRequestDTO categoria) {
        Categoria entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + id));
        mapper.updateEntity(categoria, entity);
        Categoria updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public void eliminar(Integer id) {
        Categoria entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + id));
        repository.delete(entity);
    }
}
