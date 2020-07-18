package edu.ulima.demoexp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="EXPERIENCIAS")
public class Experiencias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long iduser;
    private String entidad;
    private String ocupacion;
    private String logro;
    private String visibilidad;
    private String fechaini;
    private String fechafin;
}