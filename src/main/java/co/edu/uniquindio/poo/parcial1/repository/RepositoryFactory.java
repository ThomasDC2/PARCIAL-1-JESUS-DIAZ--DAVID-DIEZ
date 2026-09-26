package co.edu.uniquindio.poo.parcial1.repository;

/** Crea la familia de repositorios que usa la aplicación. */
public interface RepositoryFactory {
    ClienteRepository crearClienteRepository();
    EmpresaRepository crearEmpresaRepository();
    VehiculoRepository crearVehiculoRepository();
    ModalidadRepository crearModalidadRepository();
    ServicioAdicionalRepository crearServicioAdicionalRepository();
    ReservaRepository crearReservaRepository();
}
