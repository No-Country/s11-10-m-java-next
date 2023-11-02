package com.reparame.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reparame.demo.dtos.request.DatosRegistroServicioDTO;
import com.reparame.demo.enumeradores.Rubros;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Admin
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Servicio;
    
    private String descripcion;
    private Integer añosSector;
    private Integer precio;
    private Boolean alta;
    
    @Enumerated(EnumType.STRING)
    private Rubros rubro;
    
    @OneToMany(mappedBy = "servicio")
    private List<Ticket> tikets;

    @ManyToOne
    @JoinColumn(name="id_prestador")
    @JsonIgnore
    private Prestador prestador;
    
    public List<Ticket> getTickets(){
        return tikets;
    }

    public Servicio(DatosRegistroServicioDTO servicio){
        this.descripcion = servicio.descripcion();
        this.añosSector = servicio.añosSector();
        this.precio = servicio.precio();
        this.alta = true;
        this.rubro = servicio.rubro();
        this.tikets = (List<Ticket>) servicio.tiket();
        this.prestador = servicio.prestador();
    }
}
