package gtics.implementacion.Repository;
import gtics.implementacion.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findByHospital_IdHospital(Integer idHospital);

}
