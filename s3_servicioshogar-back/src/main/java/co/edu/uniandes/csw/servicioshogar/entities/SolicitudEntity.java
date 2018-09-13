/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.servicioshogar.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una solicitud en la persistencia y permite su
 * serialización.
 *
 * @author Steven Tarazona <ys.tarazona@uniandes.edu.co>
 */
@Entity
public class SolicitudEntity extends BaseEntity implements Serializable{
    
    private String direccion;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @PodamExclude
    @OneToMany(mappedBy = "solicitud")
    private List<ServicioEntity> servicios = new ArrayList<ServicioEntity>();

    /**
     * Devuelve la fecha de la solicitud.
     * @return fecha de la solicitud.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * modifica la fecha de la solicitud.
     * @param fecha. Nueva fecha.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve la direccion de la solicitud.
     * @return direccion de la solicitud.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Modifica la direccion de la solicitud.
     * @param direccion.Nueva direccion.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Devuelve los servicios de la solicitud.
     *
     * @return Lista de entidades de Servicio.
     */
    public List<ServicioEntity> getServicios() {
        return this.servicios;
    }

    /**
     * Modifica los servicios de la solicitud.
     *
     * @param servicios Los nuevos servicios.
     */
    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
    }
}
