package backend.backend.libro.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LibroDTO {
    private Long id;
    private String nombre;
    private String autor;
    private LocalDate fechaEscritura;
    private Integer numeroEdicion;
    private Double precio;
    private String tipo; // Entretenimiento o Pedagógico
    private String famaEscritor; // Alta, Media, Baja
}
