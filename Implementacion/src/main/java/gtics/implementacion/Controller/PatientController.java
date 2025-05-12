package gtics.implementacion.Controller;
import gtics.implementacion.Repository.DoctorRepository;
import gtics.implementacion.Repository.HospitalRepository;
import gtics.implementacion.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {

    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    PatientController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping({"/paciente", "/paciente/lista"})
    public String paciente(Model model) {

        model.addAttribute("listaPacientes", pacienteRepository.findAll());

        return "paciente_lista";
    }

    @GetMapping("/paciente/derivar")
    public String derivarPaciente(Model model, @RequestParam("id") Integer idPaciente) {

        model.addAttribute("idPaciente", idPaciente);
        model.addAttribute("listaDoctores", doctorRepository.findAll());

        return "formulario_derivar";
    }

    @PostMapping("/paciente/guardar")
    public String guardarPaciente(@RequestParam("idPaciente") Integer idPaciente,
                                  @RequestParam("doctor_original") Integer idOriginal,
                                  @RequestParam("doctor_final") Integer idFinal) {

        //Se interpreto que se estan derivando todos los pacientes de un doctor a otro
        //Originalmente pensaba que era derivar un solo paciente, por eso tenia la idPaciente

        pacienteRepository.derivarPaciente(idOriginal, idFinal);

        return "redirect:/paciente/lista";
    }

}
