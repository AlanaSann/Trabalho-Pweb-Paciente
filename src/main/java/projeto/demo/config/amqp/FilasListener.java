package projeto.demo.config.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import projeto.demo.model.Pacientes;
import projeto.demo.services.PacienteService;

@Component
public class FilasListener {

    @Autowired
    private PacienteService pacienteService;

    @RabbitListener(queues = "AgendamentosQueue")
    public void listenerMensagens(Mensagem mensagem) {
        Pacientes paciente = pacienteService.encontrarPaciente(new String(mensagem.getCpfPaciente()));
        pacienteService.enviarEmail(paciente.getEmail(), "Marcação de consulta", mensagem.toString());
    }
}
