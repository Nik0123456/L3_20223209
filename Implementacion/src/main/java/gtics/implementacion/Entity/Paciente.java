package gtics.implementacion.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idPaciente;

    @Column(name="nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name="edad", nullable = false)
    private Integer edad;

    @Column(name="genero", nullable = false, length = 45)
    private String genero;

    @Column(name="diagnostico", nullable = false, length = 100)
    private String diagnostico;

    @Column(name="fecha_cita", nullable = false)
    private LocalDate fechaCita;

    @Column(name="numero_habitacion", nullable = false)
    private Integer numeroHabitacion;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;

}
