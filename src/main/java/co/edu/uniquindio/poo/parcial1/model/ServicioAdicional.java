package co.edu.uniquindio.poo.parcial1.model;

import java.math.BigDecimal;

public class ServicioAdicional {
    private String codigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private boolean disponible;

    public ServicioAdicional() {
    }

    public ServicioAdicional(String codigo, String nombre, String descripcion,
                             BigDecimal precio, boolean disponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
