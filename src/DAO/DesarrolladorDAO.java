package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import model.Desarrollador;
import model.Proyecto;

import java.util.List;

public class DesarrolladorDAO {

    private EntityManagerFactory emf;

    public DesarrolladorDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void agregarDesarrollador(Desarrollador desarrollador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(desarrollador);
        em.getTransaction().commit();
        em.close();
    }

    public void editarDesarrollador(int id, String nombre, int anyosExperiencia, double salario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Desarrollador desarrollador = em.find(Desarrollador.class, id);
        if (desarrollador != null) {
            desarrollador.setNombre(nombre);
            desarrollador.setAnyosExperiencia(anyosExperiencia);
            desarrollador.setSalario(salario);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void eliminarDesarrollador(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Desarrollador desarrollador = em.find(Desarrollador.class, id);
        if (desarrollador != null) {
            em.remove(desarrollador);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void vincularDesarrollador(int desarrolladorId, int proyectoId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Desarrollador desarrollador = em.find(Desarrollador.class, desarrolladorId);
        Proyecto proyecto = em.find(Proyecto.class, proyectoId);
        if (desarrollador != null && proyecto != null) {
            desarrollador.getProyectos().add(proyecto);
            proyecto.getDesarrolladores().add(desarrollador);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void quitarAsignacion(int desarrolladorId, int proyectoId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Desarrollador desarrollador = em.find(Desarrollador.class, desarrolladorId);
        Proyecto proyecto = em.find(Proyecto.class, proyectoId);
        if (desarrollador != null && proyecto != null) {
            desarrollador.getProyectos().remove(proyecto);
            proyecto.getDesarrolladores().remove(desarrollador);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Proyecto> obtenerProyectosDelDesarrollador(int id) {
        EntityManager em = emf.createEntityManager();
        Desarrollador desarrollador = em.find(Desarrollador.class, id);
        List<Proyecto> proyectos = desarrollador.getProyectos();
        proyectos.toString();
        em.close();
        return proyectos;
    }

    public double obtenerExperienciaMedia() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Double> query = em.createQuery(
                "select avg(d.anyosExperiencia) from Desarrollador d",
                Double.class);
        double media = query.getSingleResult();
        em.close();
        return media;
    }

    public List<Desarrollador> obtenerDesarrolladoresSinProyectos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Desarrollador> query = em.createQuery(
                "select d from Desarrollador d where d.proyectos is empty",
                Desarrollador.class);
        List<Desarrollador> desarrolladores = query.getResultList();
        em.close();
        return desarrolladores;
    }
}