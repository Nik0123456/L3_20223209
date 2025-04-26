package gtics.implementacion.Controller;
import gtics.implementacion.Repository.DoctorRepository;
import gtics.implementacion.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {

    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;
    DoctorController(DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }


    @GetMapping({"/doctor", "/doctor/lista"})
    public String doctor(Model model) {

        model.addAttribute("listaDoctor", doctorRepository.findAll());

        return "doctor_lista";
    }

    @GetMapping("/doctor/listaNoAtendidos")
    public String listaNoAtendidos(Model model, @RequestParam(name="idDoctor") Integer idDoctor) {

        model.addAttribute("listaPacientes", pacienteRepository.findPacientesNoAtendidos(idDoctor));

        return "doctor_lista";
    }

}
