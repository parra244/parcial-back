package backend.backend.libro.service;



import backend.backend.libro.dto.LibroDTO;
import backend.backend.libro.model.Libro;
import backend.backend.libro.repository.LibroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private ModelMapper modelMapper;

    public LibroDTO save(LibroDTO libroDTO) {
        Libro libro = modelMapper.map(libroDTO, Libro.class);
        libro = libroRepository.save(libro);
        return modelMapper.map(libro, LibroDTO.class);
    }

    public List<LibroDTO> findAll() {
        return libroRepository.findByEliminadoFalse().stream()
                .map(libro -> modelMapper.map(libro, LibroDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<LibroDTO> findById(Long id) {
        return libroRepository.findById(id)
                .map(libro -> modelMapper.map(libro, LibroDTO.class));
    }

    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }

    public void softDelete(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        libro.ifPresent(l -> {
            l.setEliminado(true);
            libroRepository.save(l);
        });
    }
}
