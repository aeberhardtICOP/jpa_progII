package entidades;

import java.io.Serializable;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Long isbn;
    private String tiitulo;
    private int anio;
    private int ejemplares;
    private int ejemplaresPrestados;
    private int ejemplaresRestantes;
    private boolean alta;
    @OneToOne
    private Autor autor;
    @OneToOne
    private Editorial editorial;

    public Libro(int id, Long isbn, String tiitulo, int anio, int ejemplares, Autor autor, Editorial editorial) {
        this.id = id;
        this.isbn = isbn;
        this.tiitulo = tiitulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = 0;
        this.ejemplaresRestantes = ejemplares-ejemplaresPrestados;
        this.alta = true;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("CARGA DE LIBRO");
        System.out.println("-----------------");
        this.alta=true;
        System.out.println("ISBN:");
        this.isbn=scanner.nextLong();
        System.out.println("TITULO:");
        this.tiitulo=scanner.nextLine();
        System.out.println("AÑO: ");
        this.anio=scanner.nextInt();
        System.out.println("CANTIDAD DE EJEMPLARES: ");
        this.ejemplares=scanner.nextInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTiitulo() {
        return tiitulo;
    }

    public void setTiitulo(String tiitulo) {
        this.tiitulo = tiitulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(int ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public int getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(int ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    public void prestamoEjemplar(){
        this.ejemplaresPrestados++;
        this.ejemplaresRestantes=ejemplares-ejemplaresPrestados;
    }
}
