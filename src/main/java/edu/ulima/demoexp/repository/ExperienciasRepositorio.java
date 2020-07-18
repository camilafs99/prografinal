package edu.ulima.demoexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.ulima.demoexp.model.Experiencias;
import edu.ulima.demoexp.model.FormularioExp;

import java.util.List;
import java.util.Optional;

public interface ExperienciasRepositorio extends JpaRepository<Experiencias,Long>{


    public List<Experiencias> findByIduser(Long idUser);
    

    @Transactional
    public void deleteById(Long id);

}