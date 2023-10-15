package projeto.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import projeto.demo.model.Pacientes;

public interface PacienteRepository extends JpaRepository<Pacientes,Long>{
    public Page<Pacientes>findAllByStatus(Boolean status, Pageable pageable); //procura por status  
    public Optional<Pacientes> findByIdAndStatus(Long id, Boolean status);
}