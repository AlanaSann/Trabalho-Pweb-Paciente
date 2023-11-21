package projeto.demo.config.amqp;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
public class Mensagem implements Serializable {
    private String cpfPaciente;
    private String crmMedico;
    private LocalDateTime dataConsulta;

}
