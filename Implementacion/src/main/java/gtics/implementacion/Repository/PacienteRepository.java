package gtics.implementacion.Repository;
import gtics.implementacion.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByHospital_IdHospital(Integer idHospital);

}
