package co.edu.uniquindio.poo.parcial1.model;

import java.util.List;
import java.util.ArrayList;

public class ModalidadPremium extends ModalidadAlquiler {
    private String tipoCobertura;
    private int conductoresAdicionalesPermitidos;
    private List<String> caracteristicasEspeciales = new ArrayList<>();

    public ModalidadPremium() {
    }

    public ModalidadPremium(String codigo, String nombre, String descripcion, int duracionMinimaDias,
                            java.math.BigDecimal valorDiario, EstadoModalidad estado,
                            List<String> beneficios, String tipoCobertura,
                            int conductoresAdicionalesPermitidos, List<String> caracteristicasEspeciales) {
        super(codigo, nombre, descripcion, duracionMinimaDias, valorDiario, estado,
                TipoModalidad.PREMIUM, beneficios);
        this.tipoCobertura = tipoCobertura;
        this.conductoresAdicionalesPermitidos = conductoresAdicionalesPermitidos;
        setCaracteristicasEspeciales(caracteristicasEspeciales);
    }

    public String getTipoCobertura() { return tipoCobertura; }
    public void setTipoCobertura(String tipoCobertura) { this.tipoCobertura = tipoCobertura; }
    public int getConductoresAdicionalesPermitidos() { return conductoresAdicionalesPermitidos; }
    public void setConductoresAdicionalesPermitidos(int conductoresAdicionalesPermitidos) {
        this.conductoresAdicionalesPermitidos = conductoresAdicionalesPermitidos;
    }
    public List<String> getCaracteristicasEspeciales() { return caracteristicasEspeciales; }
    public void setCaracteristicasEspeciales(List<String> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales == null
                ? new ArrayList<>() : new ArrayList<>(caracteristicasEspeciales);
    }

    public void agregarCaracteristicaEspecial(String caracteristica) {
        if (caracteristica != null && !caracteristica.isBlank()
                && !caracteristicasEspeciales.contains(caracteristica)) {
            caracteristicasEspeciales.add(caracteristica);
        }
    }

    @Override
    public ModalidadPremium clonar() {
        return new ModalidadPremium(getCodigo(), getNombre(), getDescripcion(), getDuracionMinimaDias(),
                getValorDiario(), getEstado(), getBeneficios(), tipoCobertura,
                conductoresAdicionalesPermitidos, caracteristicasEspeciales);
    }
}
