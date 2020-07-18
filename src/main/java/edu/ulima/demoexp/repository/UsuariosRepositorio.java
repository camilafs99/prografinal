package edu.ulima.demoexp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import edu.ulima.demoexp.model.*;

public interface UsuariosRepositorio extends JpaRepository<Usuario,Long> {

    public List<Usuario> findById(String id);

    @Transactional 
    public void deleteById(Long id);

}


