package co.edu.uniquindio.poo.parcial1.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ModalidadAlquiler implements Serializable {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionMinimaDias;
    private BigDecimal valorDiario;
    private EstadoModalidad estado;
    private TipoModalidad tipo;
    private List<String> beneficios = new ArrayList<>();

    public ModalidadAlquiler() {
    }

    public ModalidadAlquiler(String codigo, String nombre, String descripcion, int duracionMinimaDias,
                             BigDecimal valorDiario, EstadoModalidad estado, TipoModalidad tipo,
                             List<String> beneficios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinimaDias = duracionMinimaDias;
        this.valorDiario = valorDiario;
        this.estado = estado;
        this.tipo = tipo;
        setBeneficios(beneficios);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getDuracionMinimaDias() { return duracionMinimaDias; }
    public void setDuracionMinimaDias(int duracionMinimaDias) { this.duracionMinimaDias = duracionMinimaDias; }
    public BigDecimal getValorDiario() { return valorDiario; }
    public void setValorDiario(BigDecimal valorDiario) { this.valorDiario = valorDiario; }
    public EstadoModalidad getEstado() { return estado; }
    public void setEstado(EstadoModalidad estado) { this.estado = estado; }
    public TipoModalidad getTipo() { return tipo; }
    public void setTipo(TipoModalidad tipo) { this.tipo = tipo; }
    public List<String> getBeneficios() { return beneficios; }
    public void setBeneficios(List<String> beneficios) {
        this.beneficios = beneficios == null ? new ArrayList<>() : new ArrayList<>(beneficios);
    }

    public void agregarBeneficio(String beneficio) {
        if (beneficio != null && !beneficio.isBlank() && !beneficios.contains(beneficio)) {
            beneficios.add(beneficio);
        }
    }

    public void eliminarBeneficio(String beneficio) {
        beneficios.remove(beneficio);
    }

    public ModalidadAlquiler clonar() {
        return new ModalidadAlquiler(codigo, nombre, descripcion, duracionMinimaDias,
                valorDiario, estado, tipo, beneficios);
    }
}
