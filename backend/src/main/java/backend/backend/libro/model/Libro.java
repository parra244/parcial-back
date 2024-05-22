package backend.backend.libro.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String autor;
    private LocalDate fechaEscritura;
    private Integer numeroEdicion;
    private Double precio;
    private String tipo; // Entretenimiento o Pedagógico
    private String famaEscritor; // Alta, Media, Baja

    private Boolean eliminado = false;
}
