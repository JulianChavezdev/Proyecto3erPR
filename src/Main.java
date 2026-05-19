import DAO.AsistenteDAO;
import DAO.DesarrolladorDAO;
import DAO.EventoDAO;
import DAO.ProyectoDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Asistente;
import model.Desarrollador;
import model.Evento;
import model.Proyecto;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyecto.odb");

        EventoDAO eventoDAO = new EventoDAO();
        AsistenteDAO asistenteDAO = new AsistenteDAO();


        Evento e = new Evento("Padel Cup Sevilla", "Sevilla", "2026-10-15", 25.0);
        eventoDAO.agregarEvento(e);
        e.setPrecio(35.0);
        eventoDAO.editarEvento(e, 10);
        eventoDAO.eliminarEvento(11);


        Asistente a = new Asistente("Natalia Gómez", "natalia.gomez@example.com", 25);
        asistenteDAO.agregarAsistente(a);
        a.setEmail("natalia.nuevo@example.com");
        asistenteDAO.editarAsistente(11, a);
        asistenteDAO.eliminarAsistente(11);
        asistenteDAO.registrarAsistente(1, 2, "2026-06-01");
        asistenteDAO.quitarInscripcion(1, 2);


        System.out.println("Lista de eventos y su número de participantes: " + eventoDAO.obtenerEventosConAsistentesTotales(6));

        System.out.println("Usuarios registrados en el evento con ID 1: " + eventoDAO.obtenerAsistentesDelEvento(1));

        System.out.println("Eventos que superan los 2 inscritos: " + eventoDAO.obtenerEventosConMasDe2Asistentes());

        System.out.println("Ranking de los 3 eventos con mayor recaudación: " + eventoDAO.obtenerTop3EventosPorIngresos());

        System.out.println("El evento con mayor precio localizado en Madrid: " + eventoDAO.obtenerEventoMasCostosoPorUbicacion("Madrid"));


        System.out.println("Detalle de asistentes junto a su inversión total: " + asistenteDAO.obtenerAsistentesConGastosTotales());

        System.out.println("Promedio de edad de las personas inscritas: " + asistenteDAO.obtenerEdadPromedio());

        System.out.println("Asistentes que aún no se han apuntado a ningún evento: " + asistenteDAO.obtenerAsistentesSinInscripciones());

        ProyectoDAO proyectoDAO = new ProyectoDAO(emf);
        DesarrolladorDAO desarrolladorDAO = new DesarrolladorDAO(emf);

        proyectoDAO.agregarProyecto(new Proyecto("Sistema ERP", 50000.0, "Java"));
        proyectoDAO.agregarProyecto(new Proyecto("App Delivery", 12000.0, "Kotlin"));
        proyectoDAO.agregarProyecto(new Proyecto("Portal E-commerce", 25000.0, "JavaScript"));
        proyectoDAO.agregarProyecto(new Proyecto("Motor IA Clasificador", 80000.0, "Python"));
        proyectoDAO.agregarProyecto(new Proyecto("Dashboard Cripto", 15000.0, "TypeScript"));
        proyectoDAO.agregarProyecto(new Proyecto("Gestor Hospitalario", 45000.0, "Java"));
        proyectoDAO.agregarProyecto(new Proyecto("Red Social Gaming", 30000.0, "C#"));
        proyectoDAO.agregarProyecto(new Proyecto("App Finanzas Personales", 8000.0, "Swift"));
        proyectoDAO.agregarProyecto(new Proyecto("Sistema Logística", 60000.0, "Go"));
        proyectoDAO.agregarProyecto(new Proyecto("Analítica Big Data", 95000.0, "Python"));

        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Ana García", 5, 35.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Luis Pérez", 2, 20.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Marta Ruiz", 8, 50.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Carlos Soler", 1, 15.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Elena Beltrán", 12, 65.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Jorge Sanz", 4, 30.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Sofía Vega", 6, 40.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Pablo Lara", 3, 25.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Lucía Ortiz", 10, 55.0));
        desarrolladorDAO.agregarDesarrollador(new Desarrollador("Iván Cano", 7, 42.0));

        desarrolladorDAO.vincularDesarrollador(11, 1);
        desarrolladorDAO.vincularDesarrollador(11, 6);
        desarrolladorDAO.vincularDesarrollador(12, 2);
        desarrolladorDAO.vincularDesarrollador(12, 3);
        desarrolladorDAO.vincularDesarrollador(13, 1);
        desarrolladorDAO.vincularDesarrollador(13, 4);
        desarrolladorDAO.vincularDesarrollador(13, 10);
        desarrolladorDAO.vincularDesarrollador(14, 2);
        desarrolladorDAO.vincularDesarrollador(15, 4);
        desarrolladorDAO.vincularDesarrollador(15, 9);
        desarrolladorDAO.vincularDesarrollador(15, 10);
        desarrolladorDAO.vincularDesarrollador(16, 6);
        desarrolladorDAO.vincularDesarrollador(16, 7);
        desarrolladorDAO.vincularDesarrollador(17, 3);
        desarrolladorDAO.vincularDesarrollador(17, 5);
        desarrolladorDAO.vincularDesarrollador(17, 10);
        desarrolladorDAO.vincularDesarrollador(18, 5);
        desarrolladorDAO.vincularDesarrollador(18, 8);
        desarrolladorDAO.vincularDesarrollador(19, 1);
        desarrolladorDAO.vincularDesarrollador(19, 9);
        desarrolladorDAO.vincularDesarrollador(19, 10);
        desarrolladorDAO.vincularDesarrollador(20, 4);
        desarrolladorDAO.vincularDesarrollador(20, 7);
        desarrolladorDAO.vincularDesarrollador(20, 10);
        desarrolladorDAO.vincularDesarrollador(12, 10);
        desarrolladorDAO.vincularDesarrollador(14, 10);
        desarrolladorDAO.vincularDesarrollador(16, 10);
        desarrolladorDAO.vincularDesarrollador(18, 10);
        desarrolladorDAO.vincularDesarrollador(13, 9);
        desarrolladorDAO.vincularDesarrollador(20, 9);



        Proyecto p = new Proyecto("Plataforma BugHunters", 2500.0, "Java");
        proyectoDAO.agregarProyecto(p);
        proyectoDAO.editarProyecto(p.getId(), "Ecosistema BugHunters Pro", 4500.0, "Java");
        proyectoDAO.eliminarProyecto(p.getId());


        Desarrollador d = new Desarrollador("Julian Chavez", 2, 15.0);
        desarrolladorDAO.agregarDesarrollador(d);
        desarrolladorDAO.editarDesarrollador(d.getId(), "Julian Chavez Senior", 4, 30.0);
        desarrolladorDAO.eliminarDesarrollador(d.getId());


        desarrolladorDAO.vincularDesarrollador(15, 3);
        desarrolladorDAO.quitarAsignacion(15, 3);


        System.out.println("Cantidad de programadores asignados a cada proyecto: " + proyectoDAO.obtenerCantidadDesarrolladoresPorProyecto());
        System.out.println("Equipo de desarrollo vinculado al proyecto 1: " + proyectoDAO.obtenerDesarrolladoresDelProyecto(1));
        System.out.println("Proyectos que cuentan con más de 5 programadores: " + proyectoDAO.obtenerProyectosConMasDeCincoDesarrolladores());
        System.out.println("Ranking de los 3 proyectos con mayor asignación económica: " + proyectoDAO.obtenerTop3PorPresupuesto());
        System.out.println("El proyecto de Python con la inversión más baja: " + proyectoDAO.obtenerProyectoMasEconomicoPorLenguaje("Python"));


        System.out.println("Trabajos asignados al desarrollador con ID 11: " + desarrolladorDAO.obtenerProyectosDelDesarrollador(11));
        System.out.println("Promedio de tiempo de experiencia del equipo: " + desarrolladorDAO.obtenerExperienciaMedia());
        System.out.println("Programadores que no están vinculados a ningún proyecto: " + desarrolladorDAO.obtenerDesarrolladoresSinProyectos());

        emf.close();
    }
}