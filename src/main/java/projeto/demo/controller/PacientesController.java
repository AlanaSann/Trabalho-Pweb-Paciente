package projeto.demo.controller;
import java.util.List;

import javax.swing.SortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.demo.model.Pacientes;
import projeto.demo.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
    
@Autowired
private PacienteService pacienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Pacientes> cadastrar(@RequestBody Pacientes paciente){
        return ResponseEntity.created(null).body(pacienteService.cadastarPacientes(paciente));
    }
    
    @GetMapping("/listar/{page}")
    public Page<Pacientes> listarPacientes(@PathVariable int page){
        Pageable pageable = PageRequest.of(page, 10,Sort.by(Sort.Direction.ASC,"nome"));
        return pacienteService.listarPacientes(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacientes> getPaciente(@PathVariable Long id){
        return ResponseEntity.ok().body(pacienteService.encontrarPaciente(id));
    }

    @DeleteMapping("/deletar/{id}")
    public Object deletarPacientes(@PathVariable Long id){
        pacienteService.deletarPacientes(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pacientes> atualizarPacientes(@PathVariable Long id,@RequestBody Pacientes paciente){
        return ResponseEntity.created(null).body(pacienteService.attPacientes(id, paciente));
    }
}
