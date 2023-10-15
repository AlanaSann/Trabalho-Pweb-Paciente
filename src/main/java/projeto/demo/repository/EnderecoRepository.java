package projeto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.demo.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
    
}
