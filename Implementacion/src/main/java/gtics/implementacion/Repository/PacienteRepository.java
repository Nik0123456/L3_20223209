package gtics.implementacion.Repository;
import gtics.implementacion.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query(value="SELECT p.* FROM paciente p WHERE p.doctor_id != ?1 ", nativeQuery = true)
    public List<Paciente> findPacientesNoAtendidos(Integer idDoctor);

    List<Paciente> findByHospital_IdHospital(Integer idHospital);
}
