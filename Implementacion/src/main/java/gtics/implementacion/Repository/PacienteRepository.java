package gtics.implementacion.Repository;
import gtics.implementacion.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByHospital_IdHospital(Integer idHospital);

    List<Paciente> findByDoctor_IdDoctor(Integer idDoctor);

    @Query(value = "SELECT * FROM paciente WHERE doctor_id = ?1 AND fecha_cita > CURDATE()", nativeQuery = true)
    List<Paciente> findProximasCitas(Integer idDoctor);

}
