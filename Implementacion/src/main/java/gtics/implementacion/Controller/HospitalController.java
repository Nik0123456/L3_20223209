package gtics.implementacion.Controller;
import gtics.implementacion.Entity.Hospital;
import gtics.implementacion.Repository.DoctorRepository;
import gtics.implementacion.Repository.HospitalRepository;
import gtics.implementacion.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HospitalController {

    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    HospitalController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }


    @GetMapping({"/hospital", "/hospital/lista"})
    public String hospital(Model model) {

        model.addAttribute("listaHospitales", hospitalRepository.findAll());

        return "hospital_lista";
    }

    @GetMapping("/hospital/listaDoctoresEspecifica")
    public String listaDoctoresEspecifica(Model model, @RequestParam("id") Integer idHospital) {

        model.addAttribute("listaDoctores", doctorRepository.findByHospital_IdHospital(idHospital));

        return "hospital_lista_doctores";
    }

    @GetMapping("/hospital/listaPacientesEspecifica")
    public String listaPacientesEspecifica(Model model, @RequestParam("id") Integer idHospital) {

        model.addAttribute("listaPacientes", pacienteRepository.findByHospital_IdHospital(idHospital));

        return "hospital_lista_pacientes";
    }


}
