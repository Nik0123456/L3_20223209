package gtics.implementacion.Repository;
import gtics.implementacion.Entity.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByHospital_IdHospital(Integer idHospital);

    @Query(value = "SELECT * FROM paciente WHERE doctor_id = ?1 AND fecha_cita > CURDATE()", nativeQuery = true)
    List<Paciente> findProximasCitas(Integer idDoctor);

    @Transactional
    @Modifying
    @Query(value="UPDATE paciente SET doctor_id = ?2 WHERE doctor_id = ?1", nativeQuery = true)
    void derivarPaciente(Integer idOriginal, Integer idFinal);

}
