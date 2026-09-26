package co.edu.uniquindio.poo.parcial1.config;

import co.edu.uniquindio.poo.parcial1.controller.ClienteController;
import co.edu.uniquindio.poo.parcial1.controller.EmpresaController;
import co.edu.uniquindio.poo.parcial1.controller.ConsultaClienteController;
import co.edu.uniquindio.poo.parcial1.controller.ModalidadController;
import co.edu.uniquindio.poo.parcial1.controller.RentCarController;
import co.edu.uniquindio.poo.parcial1.controller.ReporteIngresosController;
import co.edu.uniquindio.poo.parcial1.controller.ReservaController;
import co.edu.uniquindio.poo.parcial1.controller.ServicioAdicionalController;
import co.edu.uniquindio.poo.parcial1.controller.VehiculoController;
import co.edu.uniquindio.poo.parcial1.repository.ArchivoRepositoryFactory;
import co.edu.uniquindio.poo.parcial1.repository.RepositoryFactory;
import co.edu.uniquindio.poo.parcial1.repository.ClienteRepository;
import co.edu.uniquindio.poo.parcial1.repository.EmpresaRepository;
import co.edu.uniquindio.poo.parcial1.repository.ModalidadRepository;
import co.edu.uniquindio.poo.parcial1.repository.ReservaRepository;
import co.edu.uniquindio.poo.parcial1.repository.ServicioAdicionalRepository;
import co.edu.uniquindio.poo.parcial1.repository.VehiculoRepository;
import co.edu.uniquindio.poo.parcial1.service.CalculadoraAlquiler;
import co.edu.uniquindio.poo.parcial1.service.ClienteService;
import co.edu.uniquindio.poo.parcial1.service.ConsultaClienteService;
import co.edu.uniquindio.poo.parcial1.service.EmpresaService;
import co.edu.uniquindio.poo.parcial1.service.ModalidadService;
import co.edu.uniquindio.poo.parcial1.service.ReporteIngresosService;
import co.edu.uniquindio.poo.parcial1.service.ReservaService;
import co.edu.uniquindio.poo.parcial1.service.ServicioAdicionalService;
import co.edu.uniquindio.poo.parcial1.service.VehiculoService;
import co.edu.uniquindio.poo.parcial1.service.VerificacionNumeroPerfectoService;

public class AplicacionRentCar {
    private final RepositoryFactory repositoryFactory = new ArchivoRepositoryFactory();
    private final ClienteRepository clienteRepository = repositoryFactory.crearClienteRepository();
    private final EmpresaRepository empresaRepository = repositoryFactory.crearEmpresaRepository();
    private final VehiculoRepository vehiculoRepository = repositoryFactory.crearVehiculoRepository();
    private final ModalidadRepository modalidadRepository = repositoryFactory.crearModalidadRepository();
    private final ServicioAdicionalRepository servicioRepository = repositoryFactory.crearServicioAdicionalRepository();
    private final ReservaRepository reservaRepository = repositoryFactory.crearReservaRepository();

    private final ClienteService clienteService = new ClienteService(clienteRepository);
    private final EmpresaService empresaService = new EmpresaService(empresaRepository);
    private final VehiculoService vehiculoService = new VehiculoService(vehiculoRepository);
    private final ModalidadService modalidadService = new ModalidadService(modalidadRepository);
    private final ServicioAdicionalService servicioAdicionalService = new ServicioAdicionalService(servicioRepository);
    private final ReservaService reservaService = new ReservaService(reservaRepository, new CalculadoraAlquiler(),
            clienteRepository, vehiculoRepository, modalidadRepository, servicioRepository);
    private final ConsultaClienteService consultaClienteService = new ConsultaClienteService(
            clienteRepository, new VerificacionNumeroPerfectoService());
    private final ReporteIngresosService reporteIngresosService = new ReporteIngresosService(reservaRepository);

    public Object crearControlador(Class<?> tipo) {
        if (tipo == RentCarController.class) return new RentCarController();
        if (tipo == ClienteController.class) return new ClienteController(clienteService);
        if (tipo == EmpresaController.class) return new EmpresaController(empresaService);
        if (tipo == VehiculoController.class) return new VehiculoController(vehiculoService);
        if (tipo == ModalidadController.class) return new ModalidadController(modalidadService);
        if (tipo == ServicioAdicionalController.class) return new ServicioAdicionalController(servicioAdicionalService);
        if (tipo == ReservaController.class) return new ReservaController(reservaService);
        if (tipo == ConsultaClienteController.class) return new ConsultaClienteController(consultaClienteService);
        if (tipo == ReporteIngresosController.class) return new ReporteIngresosController(reporteIngresosService);
        throw new IllegalArgumentException("No hay controlador configurado para " + tipo.getName());
    }
}
