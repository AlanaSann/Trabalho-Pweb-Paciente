package projeto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.demo.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
    
}
