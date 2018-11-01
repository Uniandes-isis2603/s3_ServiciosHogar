/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.servicioshogar.ejb;


import co.edu.uniandes.csw.servicioshogar.entities.HojaDeVidaEntity;
import co.edu.uniandes.csw.servicioshogar.entities.PrestadorEntity;
import co.edu.uniandes.csw.servicioshogar.persistence.HojaDeVidaPersistence;
import co.edu.uniandes.csw.servicioshogar.persistence.PrestadorPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela Rocha
 */
@Stateless
public class PrestadorHojaDeVidaLogic {
     private static final Logger LOGGER = Logger.getLogger(PrestadorHojaDeVidaLogic.class.getName());

    @Inject
    private PrestadorPersistence prestadorPersistence;

    @Inject
    private HojaDeVidaPersistence hojaDeVidaPersistence;

  
    public HojaDeVidaEntity addHojaDeVida(Long prestadorId, Long hojaDeVidaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle una hoja de vida al prestador con id = {0}", prestadorId);
        HojaDeVidaEntity hojaDeVidaEntity = hojaDeVidaPersistence.find(hojaDeVidaId);
        PrestadorEntity prestadorEntity = prestadorPersistence.find(prestadorId);
        prestadorEntity.setHojaDeVida(hojaDeVidaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle una hoja de vida al prestador con id = {0}", prestadorId);
        return hojaDeVidaPersistence.find(hojaDeVidaId);
    }
    
    public HojaDeVidaEntity getHojaDeVida(Long prestadorId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de cosultar la hoja de vida de un prestador con id = {0}", prestadorId);
        HojaDeVidaEntity hojaDeVida = prestadorPersistence.find(prestadorId).getHojaDeVida();;
        LOGGER.log(Level.INFO, "Termina proceso de consultar la hoja de vida de un prestador con id = {0}", prestadorId);
        return hojaDeVida;
    }

    public PrestadorEntity replaceHojaDeVida(Long prestadorId, Long hojaDeVidaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar libro con id = {0}", prestadorId);
        HojaDeVidaEntity hojaDeVidaEntity = hojaDeVidaPersistence.find(hojaDeVidaId);
        PrestadorEntity prestadorEntity = prestadorPersistence.find(prestadorId);
        prestadorEntity.setHojaDeVida(hojaDeVidaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar prestador con id = {0}", prestadorEntity.getId());
        return prestadorEntity;
    }
  
    public void removeHojaDeVida(Long prestadorId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una hoja de vida del prestador con id = {0}", prestadorId);
        prestadorPersistence.find(prestadorId).setHojaDeVida(null);
        LOGGER.log(Level.INFO, "Termina el proceso de borrrar una hoja de vida del prestador con id={0}", prestadorId);
    }


}