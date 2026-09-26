package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.Vehiculo;
import co.edu.uniquindio.poo.parcial1.config.ConfiguracionRentCar;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class VehiculoRepositoryArchivo extends ArchivoRepository<Vehiculo> implements VehiculoRepository {
    public VehiculoRepositoryArchivo() {
        super(ConfiguracionRentCar.getInstancia().getCarpetaDatos().resolve("vehiculos.dat"),
                Vehiculo::getPlaca);
    }

    @Override public void guardar(Vehiculo vehiculo) { guardarRegistro(vehiculo); }
    @Override public Optional<Vehiculo> buscarPorPlaca(String placa) { return buscarRegistro(placa); }
    @Override public List<Vehiculo> listarTodos() { return listarRegistros(); }
    @Override public void actualizar(Vehiculo vehiculo) { actualizarRegistro(vehiculo); }
    @Override public void eliminarPorPlaca(String placa) { eliminarRegistro(placa); }
}
