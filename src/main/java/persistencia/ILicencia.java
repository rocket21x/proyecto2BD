/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import dominio.Persona;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author eduar
 */
public interface ILicencia {
    public void insertarLicencia(Date fechaExpedicion, Integer vigencia, BigDecimal monto, String tipo, Persona persona); 
    
    public void asignarLicencia();
    
    public void calcularCosto();
}
