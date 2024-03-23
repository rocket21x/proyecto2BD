package dao;

import dominio.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 
 * @author eduar
 */
public class PersonaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDAO() {
        emf = Persistence.createEntityManagerFactory("NombreDeTuUnidadDePersistencia"); // Reemplaza "NombreDeTuUnidadDePersistencia" con el nombre de tu unidad de persistencia en persistence.xml
        em = emf.createEntityManager();
    }

    public void guardar(Persona persona) {
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void actualizar(Persona persona) {
        try {
            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void eliminar(Persona persona) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(persona) ? persona : em.merge(persona));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Persona buscarPorRFC(String RFC) {
        return em.find(Persona.class, RFC);
    }

    // Otros métodos según sea necesario

    public void cerrar() {
        em.close();
        emf.close();
    }
}
