package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.config.ConfiguracionRentCar;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class ModalidadRepositoryArchivo extends ArchivoRepository<ModalidadAlquiler> implements ModalidadRepository {
    public ModalidadRepositoryArchivo() {
        super(ConfiguracionRentCar.getInstancia().getCarpetaDatos().resolve("modalidades.dat"),
                ModalidadAlquiler::getCodigo);
    }

    @Override public void guardar(ModalidadAlquiler modalidad) { guardarRegistro(modalidad); }
    @Override public Optional<ModalidadAlquiler> buscarPorCodigo(String codigo) { return buscarRegistro(codigo); }
    @Override public List<ModalidadAlquiler> listarTodas() { return listarRegistros(); }
    @Override public void actualizar(ModalidadAlquiler modalidad) { actualizarRegistro(modalidad); }
    @Override public void eliminarPorCodigo(String codigo) { eliminarRegistro(codigo); }
}
