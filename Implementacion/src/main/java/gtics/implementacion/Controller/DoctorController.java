package gtics.implementacion.Controller;
import gtics.implementacion.Repository.DoctorRepository;
import gtics.implementacion.Repository.HospitalRepository;
import gtics.implementacion.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {

    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    DoctorController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping({"/doctor", "/doctor/lista"})
    public String doctor(Model model) {

        model.addAttribute("listaDoctores", doctorRepository.findAll());

        return "doctores_lista";
    }

    @GetMapping("/doctor/listaPacientes")
    public String doctorListaPacientes(Model model, @RequestParam("id") Integer idDoctor) {

        model.addAttribute("listaPacientes", pacienteRepository.findProximasCitas(idDoctor));
        return "doctores_listaPacientes";
    }

}
