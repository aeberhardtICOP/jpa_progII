package servicios;

import entidades.Libro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class LibroServicio {
    private EntityManagerFactory emf;

    public LibroServicio() {
        emf = Persistence.createEntityManagerFactory("LibreriaPU");
    }

    public void crearLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.close();
    }

    public Libro obtenerLibro(long id) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, id);
        em.close();
        return libro;
    }

    public List<Libro> obtenerTodosLosLibros() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
        List<Libro> libros = query.getResultList();
        em.close();
        return libros;
    }

    public void actualizarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminarLibro(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            em.remove(libro);
        }
        em.getTransaction().commit();
        em.close();
    }
}
