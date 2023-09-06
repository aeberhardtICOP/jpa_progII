package entidades;

import java.io.Serializable;
import java.util.Scanner;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private Boolean alta;
    
    public Autor(int id, String nombre) {
     
        this.id = id;
        this.nombre = nombre;
        this.alta = true;
        
    }

    public Autor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------");
        System.out.println("CARGA DE AUTOR");
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

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
    
}
