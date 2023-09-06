package servicios;
import entidades.Libro;
import entidades.Autor;
import entidades.Editorial;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ControladoraPersistencia {
    EditorialJpaController editJpa = new EditorialJpaController();
    AutorJpaController autorJpa = new AutorJpaController();
    LibroJpaController libroJpa = new LibroJpaController();
    
    public void cargarLibro(Libro libro){
        libroJpa.create(libro);
        System.out.println("Cargado Con Exito!!!");
    }
    public void cargarAutor(Autor autor){
        autorJpa.create(autor);
        System.out.println("Cargado Con Exito!!!");
    }
    public void cargarEditorial(Editorial edit){
        editJpa.create(edit);
        System.out.println("Cargado Con Exito!!!");
    }
    
    
    public List<Libro> buscarLibros(){
        List<Libro>lista=libroJpa.findLibroEntities();
        return lista;
    }
    public List<Autor> buscarAutores(){
        List<Autor>lista=autorJpa.findAutorEntities();
        return lista;
    }
    public List<Editorial> buscarEditoriales(){
        List<Editorial>lista=editJpa.findEditorialEntities();
        return lista;
    }
    
    
    public void editarLibro(Libro libro){
        try {
            libroJpa.edit(libro);
        } catch (Exception ex) {
            System.out.println("No existe ese objeto!");
        }
    }
    public void editarEditorial(Editorial editorial){
        try {
            editJpa.edit(editorial);
        } catch (Exception ex) {
            System.out.println("No existe ese objeto!");
        }
    }
    public void editarAutor(Autor autor){
        try {
            autorJpa.edit(autor);
        } catch (Exception ex) {
            System.out.println("No existe ese objeto!");
        }
    }
}
