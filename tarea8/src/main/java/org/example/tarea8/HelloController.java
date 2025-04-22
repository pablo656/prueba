package org.example.tarea8;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.persistence.*;
import java.util.List;

public class HelloController {
    @FXML
    private TextField Codigo, Nombre, Cantidad, Descripcion;

    @FXML
    private TextArea area;

   private EntityManagerFactory emf;
   private EntityManager em;

    @FXML
    public void initialize() {
        emf = Persistence.createEntityManagerFactory("myPU");
        em = emf.createEntityManager();
    }

    @FXML
    private void insertar(){
        try {
            Articulos articulo1 = new Articulos();
            articulo1.setCodigo(Integer.parseInt(Codigo.getText()));
            articulo1.setNombre(Nombre.getText());
            articulo1.setCantidad(Integer.parseInt(Cantidad.getText()));
            articulo1.setDescripcion(Descripcion.getText());
            em.getTransaction().begin();
            em.persist(articulo1);
            em.getTransaction().commit();
            Codigo.setText("");
            Nombre.setText("");
            Cantidad.setText("");
            Descripcion.setText("");
            area.setText("Articulo insertado correctamente");
        } catch (Exception e) {
            area.setText("Error al insertar el articulo: " + e.getMessage());
        }
    }

    @FXML
    private void buscar(){
        try{
        int codigo = Integer.parseInt(Codigo.getText());
        Articulos articulo = em.find(Articulos.class, codigo);
        if (articulo != null) {
            area.setText("Articulo encontrado: " + articulo.toString());
        } else {
            area.setText("Articulo no encontrado");
        }
        } catch (Exception e){
            area.setText("Error al buscar el articulo: " + e.getMessage());
        }
    }
    @FXML
    private void borrar(){
        try {
        int codigo = Integer.parseInt(Codigo.getText());
        Articulos articulo = em.find(Articulos.class, codigo);
        if (articulo != null) {
            em.getTransaction().begin();
            em.remove(articulo);
            em.getTransaction().commit();
            area.setText("Articulo eliminado correctamente");
        } else {
            area.setText("Articulo no encontrado");
        }
        }catch (Exception e){
            area.setText("Error al eliminar el articulo: " + e.getMessage());
        }
    }
    @FXML
    private void modificar(){
        try {
            int codigo = Integer.parseInt(Codigo.getText());
            Articulos articulo = em.find(Articulos.class, codigo);
            borrar();
            area.setText("");
            if (articulo != null) {
                insertar();
                area.setText("");
                area.setText("Articulo modificado correctamente");
            } else {
                area.setText("Articulo no encontrado");
            }
        } catch (Exception e) {
            area.setText("Error al modificar el articulo: " + e.getMessage());
        }
    }
    @FXML
    private void mostrar(){
        try {
            Query query = em.createQuery("SELECT a FROM Articulos a", Articulos.class);
            List<Articulos> articulos = query.getResultList();
            String contenido = "";
            for (Articulos articulo : articulos) {
                contenido =(articulo.toString() + "\r\n");
                area.appendText(contenido);
            }
        } catch (Exception e) {
            area.setText("Error al mostrar los articulos: " + e.getMessage());
        }
    }
    @FXML
    private void salir(){
        em.close();
        emf.close();
        System.exit(0);
    }
}
