package servicios;

import entidades.Editorial;
import java.security.spec.ECField;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class EditorialServicio {
    private EntityManagerFactory emf;

    public EditorialServicio() {
        this.emf=Persistence.createEntityManagerFactory("LibreriaPU");
    }
    public void crearEditorial(Editorial editorial){
        EntityManager em = emf.createEntityManager();
        em.getTransaction();
        em.persist(editorial);
        em.getTransaction().commit();
        em.close();
    }
    public void actualizarEditorial(Editorial editorial) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
        em.close();
    }
    public void eliminarEditorial(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            em.remove(editorial);
        }
        em.getTransaction().commit();
        em.close();
    }
    public Editorial obtenerEditorial(long id) {
        EntityManager em = emf.createEntityManager();
        Editorial editorial = em.find(Editorial.class, id);
        em.close();
        return editorial;
    }
     public List<Editorial> obtenerTodasLasEditoriales() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Editorial> query = em.createQuery("SELECT e FROM Editorial e", Editorial.class);
        List<Editorial> editoriales = query.getResultList();
        em.close();
        return editoriales;
    }
    
    
}
