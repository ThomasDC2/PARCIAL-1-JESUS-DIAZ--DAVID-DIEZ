package co.edu.uniquindio.poo.parcial1.repository;

public class ArchivoRepositoryFactory implements RepositoryFactory {
    @Override public ClienteRepository crearClienteRepository() { return new ClienteRepositoryArchivo(); }
    @Override public EmpresaRepository crearEmpresaRepository() { return new EmpresaRepositoryArchivo(); }
    @Override public VehiculoRepository crearVehiculoRepository() { return new VehiculoRepositoryArchivo(); }
    @Override public ModalidadRepository crearModalidadRepository() { return new ModalidadRepositoryArchivo(); }
    @Override public ServicioAdicionalRepository crearServicioAdicionalRepository() {
        return new ServicioAdicionalRepositoryArchivo();
    }
    @Override public ReservaRepository crearReservaRepository() { return new ReservaRepositoryArchivo(); }
}
