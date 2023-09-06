package entidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import servicios.*;
public class ControladoraLogica {
    ArrayList<Libro> libros;
    ArrayList<Editorial> editoriales;
    ArrayList<Autor> autores;
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    Scanner scanner = new Scanner(System.in);
    
     
    //LIBROS
    public void traerLibros(){
        //List<Libro>lista=lib.obtenerTodosLosLibros();
        List<Libro>lista=controlPersis.buscarLibros();
        ArrayList<Libro>lib = new ArrayList<> (lista);
        this.libros=lib;
    }
    public void mostrarLibros(){
        traerLibros();
        for(Libro l:libros){
            System.out.println("LIBRO ID: ("+l.getId()+") ISBN: "+l.getIsbn()
                    +"\nTitulo: "+l.getTiitulo()+" Año: "+l.getAnio()+
                    "\nAutor: "+l.getAutor().getNombre()+" "+" Editorial: "+l.getEditorial().getNombre()
                    +"\nEjemplares prestados: "+l.getEjemplaresPrestados()+" Ejemplares DISPONIBLES: "+l.getEjemplaresRestantes());
            System.out.println("-------------------------------------");
        }
    }
    public int buscarPosicionLibro(int id){
        boolean flag = false;
        int i=0;
        do{
            if(id==libros.get(i).getId()){
                return i;
            }
            i++;
        }while(flag!=true||i<libros.size());
     return -1;   
    }
    //EDITORIALES
    public void traerEditoriales(){
        //List<Editorial>lista=editServ.obtenerTodasLasEditoriales();
        List<Editorial>lista=controlPersis.buscarEditoriales();
        ArrayList<Editorial>edi = new ArrayList<>(lista);
        this.editoriales=edi;
    }
    public void mostrarEdioriales(){
        traerEditoriales();
        for (Editorial e : editoriales){
            System.out.println("EDITORIAL ID: ("+e.getId()+") NOMBRE: "+e.getNombre());
            System.out.println("-------------------------------------");
        }
    }
    public int buscarPosicionLEditorial(int id){
        boolean flag = false;
        int i=0;
        do{
            if(id==editoriales.get(i).getId()){
                return i;
            }
            i++;
        }while(flag!=true||i<editoriales.size());
     return -1;   
    }
    //AUTORES
    public void traerAutores(){
        //List<Autor>lista=autorServ.obtenerTodosLosAutores();
        List<Autor>lista=controlPersis.buscarAutores();
        ArrayList<Autor>aut = new ArrayList<>(lista);
        this.autores=aut;
    }
    public void mostrarAutores(){
        traerAutores();
        for(Autor a : autores){
            System.out.println("AUTOR ID: ("+a.getId()+") NOMBRE: "+a.getNombre());
            System.out.println("-------------------------------------");
        }
    }
    public int buscarPosicionAutor(int id){
        boolean flag = false;
        int i=0;
        do{
            if(id==autores.get(i).getId()){
                return i;
            }
            i++;
        }while(flag!=true||i<autores.size());
     return -1;   
    }
    
    //CREAR
     public void crearLibro(){
        Libro lib = new Libro();
        System.out.println("Seleccione id autor: (-1 para crear nuevo)");
        mostrarAutores();
        int id = scanner.nextInt();
        if(id==-1){
           Autor aut = new Autor();
           lib.setAutor(aut);
           controlPersis.cargarAutor(aut);
        }else{
            try{
            int pos=buscarPosicionAutor(id);
             lib.setAutor(autores.get(pos));
            }catch(IndexOutOfBoundsException e){
                System.out.println("No existe autor con ese id");
            }
        }
           
        System.out.println("Seleccione editorial: (-1 para crear nuevo)");
        mostrarEdioriales();
        int id2 = scanner.nextInt();
         if(id2==-1){
           Editorial edit = new Editorial();
           lib.setEditorial(edit);
           controlPersis.cargarEditorial(edit);
        }else{
            try{
            int pos=buscarPosicionLEditorial(id2);
             lib.setEditorial(editoriales.get(pos));
            }catch(IndexOutOfBoundsException e){
                System.out.println("No existe editorial con ese id");
            }
        }
        controlPersis.cargarLibro(lib);
    }
     public void crearAutor(){
         System.out.println("CARGA DE AUTOR:");
         Autor aut = new Autor();
         controlPersis.cargarAutor(aut);
     }
     
    public void crearEditorial(){
        System.out.println("CARGA DE EDITORIAL");
        Editorial edit = new Editorial();
        controlPersis.cargarEditorial(edit);
    }
}
