package entidades;

import java.io.Serializable;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private boolean alta;
    
    public Editorial(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.alta = true;
    }

    public Editorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("CARGA DE EDITORIAL");
        System.out.println("-----------------");
        System.out.println("Nombre:");
        this.nombre=scanner.nextLine();
        this.alta=true;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }
    
    
    
}
