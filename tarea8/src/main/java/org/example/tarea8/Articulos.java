package org.example.tarea8;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Articulos implements Serializable{
    @Id
    private int codigo;
    private String nombre;
    private int cantidad;
    private String descripcion;

    public Articulos() {
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    @Override
    public String toString() {
        return codigo + ","+ nombre +"," + cantidad +"," + descripcion;
    }
}
