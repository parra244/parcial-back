package backend.backend.libro.controller;


import backend.backend.libro.dto.LibroDTO;
import backend.backend.libro.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public LibroDTO create(@RequestBody LibroDTO libroDTO) {
        return libroService.save(libroDTO);
    }

    @GetMapping
    public List<LibroDTO> getAll() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LibroDTO> getById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PutMapping("/{id}")
    public LibroDTO update(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        libroDTO.setId(id);
        return libroService.save(libroDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        libroService.deleteById(id);
    }

    @DeleteMapping("/soft/{id}")
    public void softDelete(@PathVariable Long id) {
        libroService.softDelete(id);
    }
}
