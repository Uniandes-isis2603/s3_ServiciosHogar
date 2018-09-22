/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.servicioshogar.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Carlos Eduardo Robles
 */
@Entity
public class CalificacionEntity  extends BaseEntity implements Serializable
{
    //------------------------------------------
    //-----------------Atributos----------------
    //------------------------------------------
    private Double calificacion /*Calificacion del servicio del 0 al 5*/;
    private String comentario /*Comentario con respecto al servicio*/;
    
    /**
     * Relacion con servicio.
     */
    @PodamExclude
    @OneToOne
    private ServicioEntity servicio;

    //------------------------------------------
    //------------------Metodos-----------------
    //------------------------------------------
    /**
     * Devuelve la calificacion del servicio.
     * @return calificacion del servicio.
     */
    public Double getCalificacion() {return calificacion;}

    /**
     * Asigna la calificacion del servicio segun la 'calificacion' ingresada por paramtero.
     * @param calificacion - Calificacion a asignar al servicio.
     */
    public void setCalificacion(Double calificacion) {this.calificacion = calificacion;}

    /**
     * Devuelve el comentario del servicio.
     * @return comentario del servicio.
     */
    public String getComentario() {return comentario;}

    /**
     * Asigna el comentario del servicio segun el 'comentario' ingresado por parametro.
     * @param comentario - Comentario a asignar a la calificacion del servcio.
     */
    public void setComentario(String comentario) {this.comentario = comentario;}

    /**
     * Devuelve el servicio asociado con la calificacion.
     * @return servicio asociado con la calificacion.
     */
    public ServicioEntity getServicio() {return servicio;}

    /**
     * Asigna el servicio al que la calificacion pertenece.
     * @param servicio - Servicio al que la calificacion pertenece.
     */
    public void setServicio(ServicioEntity servicio) {this.servicio = servicio;}
    
}
