/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package negocio;

import dominio.Licencia;
import dominio.Persona;
import java.math.BigDecimal;
import java.util.Date;
import persistencia.ILicencia;

/**
 *
 * @author eduar
 */
public class NegocioLicencia implements ILicencia {

    @Override
    public void insertarLicencia(Date fechaExpedicion, Integer vigencia, BigDecimal monto, String tipo, Persona persona) {
        Licencia l = new Licencia();
        l.fechaExpedicion = fechaExpedicion;
        l.vigencia = vigencia;
        l.monto = monto;
        l.tipo = tipo;
        l.persona = persona;
    }

    @Override
    public void asignarLicencia() {
        
    }

    @Override
    public void calcularCosto() {
        
    }
    

}
