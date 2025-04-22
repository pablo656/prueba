package org.example;

/**
 * Clase que hace descuentos a productos.
 * @version 1.0
 */
public class Tarea6EDClase {
    /**
     * Descuento aplicado cuando el número de productos es diferente a 0.
     */
    public static final double descuento1 = 0.8;
    /**
     * Descuento aplicado cuando el número de productos es igual a a.
     */
    public static final double descuento2 = 0.95;

    /**
     * Aplica un descuento al precio de un producto dependiendo del número de productos.
     *
     * @param precioProducto El precio unitario del producto.
     * @param numProductos   El número de productos comprados.
     */
    public void aplicarDescuento(double precioProducto, int numProductos){
        double Total;
        if(numProductos>3)
            precioProducto-=5;
        if (numProductos!=0){
            Total = precioProducto* descuento1;
            extracted(Total);
        }else {
            Total = precioProducto* descuento2;
            extracted(Total);}}
    /**
     * Método que imprime el total a pagar y un mensaje de confirmación.
     *
     * @param Total El total calculado después de aplicar el descuento.
     */
    private void extracted(double Total) {
        System.out.println("El total a pagar es:"+ Total);
        System.out.println("Enviado");}}
