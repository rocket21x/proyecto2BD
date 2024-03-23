/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Licencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 
 * @author eduar
 */
public class LicenciaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public LicenciaDAO() {
        emf = Persistence.createEntityManagerFactory("NombreDeTuUnidadDePersistencia"); // Reemplaza "NombreDeTuUnidadDePersistencia" con el nombre de tu unidad de persistencia en persistence.xml
        em = emf.createEntityManager();
    }

    public void guardar(Licencia licencia) {
        try {
            em.getTransaction().begin();
            em.persist(licencia);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void actualizar(Licencia licencia) {
        try {
            em.getTransaction().begin();
            em.merge(licencia);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void eliminar(Licencia licencia) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(licencia) ? licencia : em.merge(licencia));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Licencia buscarPorNumero(Integer numeroLicencia) {
        return em.find(Licencia.class, numeroLicencia);
    }
    
    public void cerrar() {
        em.close();
        emf.close();
    }
}

