package servicios;

import entidades.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AutorServicio {
    private EntityManagerFactory emf;

    public AutorServicio() {
        this.emf=Persistence.createEntityManagerFactory("LibreriaPU");
    }
    public void crearAutor(Autor autor){
        EntityManager em = emf.createEntityManager();
        em.getTransaction();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();
    }
    public void actualizarAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
        em.close();
    }
    public void eliminarAutor(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Autor autor = em.find(Autor.class, id);
        if (autor != null) {
            em.remove(autor);
        }
        em.getTransaction().commit();
        em.close();
    }
    public Autor obtenerAutor(long id) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, id);
        em.close();
        return autor;
    }
     public List<Autor> obtenerTodosLosAutores() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Autor> query = em.createQuery("SELECT e FROM Autor e", Autor.class);
        List<Autor> editoriales = query.getResultList();
        em.close();
        return editoriales;
    }
}
