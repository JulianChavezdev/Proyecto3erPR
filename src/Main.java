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
        eventoDAO.insertarEvento(e);
        e.setPrecio(35.0);
        eventoDAO.actualizarEvento(e, 10);
        eventoDAO.borrarEvento(11);


        Asistente a = new Asistente("Natalia Gómez", "natalia.gomez@example.com", 25);
        asistenteDAO.insertarAsistente(a);
        a.setEmail("natalia.nuevo@example.com");
        asistenteDAO.actualizarAsistente(11, a);
        asistenteDAO.borrarAsistente(11);
        asistenteDAO.inscribirAsistente(1, 2, "2026-06-01");
        asistenteDAO.eliminarInscripcion(1, 2);


        System.out.println("Lista de eventos y su número de participantes: " + eventoDAO.obtenerEventosConTotalAsistentes(6));

        System.out.println("Usuarios registrados en el evento con ID 1: " + eventoDAO.obtenerAsistenteDeEventos(1));

        System.out.println("Eventos que superan los 2 inscritos: " + eventoDAO.obtenerEventoConMasDe2Asistentes());

        System.out.println("Ranking de los 3 eventos con mayor recaudación: " + eventoDAO.obtenerTop3Eventos());

        System.out.println("El evento con mayor precio localizado en Madrid: " + eventoDAO.obtenerEventoMasCaroPorUbicacion("Madrid"));


        System.out.println("Detalle de asistentes junto a su inversión total: " + asistenteDAO.obtenerAsistentesConGastoTotal());

        System.out.println("Promedio de edad de las personas inscritas: " + asistenteDAO.obtenerEdadMedia());

        System.out.println("Asistentes que aún no se han apuntado a ningún evento: " + asistenteDAO.obtenerAsistentesSinInscripcion());

        ProyectoDAO proyectoDAO = new ProyectoDAO(emf);
        DesarrolladorDAO desarrolladorDAO = new DesarrolladorDAO(emf);

        proyectoDAO.insertarProyecto(new Proyecto("Sistema ERP", 50000.0, "Java"));
        proyectoDAO.insertarProyecto(new Proyecto("App Delivery", 12000.0, "Kotlin"));
        proyectoDAO.insertarProyecto(new Proyecto("Portal E-commerce", 25000.0, "JavaScript"));
        proyectoDAO.insertarProyecto(new Proyecto("Motor IA Clasificador", 80000.0, "Python"));
        proyectoDAO.insertarProyecto(new Proyecto("Dashboard Cripto", 15000.0, "TypeScript"));
        proyectoDAO.insertarProyecto(new Proyecto("Gestor Hospitalario", 45000.0, "Java"));
        proyectoDAO.insertarProyecto(new Proyecto("Red Social Gaming", 30000.0, "C#"));
        proyectoDAO.insertarProyecto(new Proyecto("App Finanzas Personales", 8000.0, "Swift"));
        proyectoDAO.insertarProyecto(new Proyecto("Sistema Logística", 60000.0, "Go"));
        proyectoDAO.insertarProyecto(new Proyecto("Analítica Big Data", 95000.0, "Python"));

        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Ana García", 5, 35.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Luis Pérez", 2, 20.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Marta Ruiz", 8, 50.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Carlos Soler", 1, 15.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Elena Beltrán", 12, 65.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Jorge Sanz", 4, 30.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Sofía Vega", 6, 40.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Pablo Lara", 3, 25.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Lucía Ortiz", 10, 55.0));
        desarrolladorDAO.insertarDesarrollador(new Desarrollador("Iván Cano", 7, 42.0));

        desarrolladorDAO.asignarDesarrollador(11, 1);
        desarrolladorDAO.asignarDesarrollador(11, 6);
        desarrolladorDAO.asignarDesarrollador(12, 2);
        desarrolladorDAO.asignarDesarrollador(12, 3);
        desarrolladorDAO.asignarDesarrollador(13, 1);
        desarrolladorDAO.asignarDesarrollador(13, 4);
        desarrolladorDAO.asignarDesarrollador(13, 10);
        desarrolladorDAO.asignarDesarrollador(14, 2);
        desarrolladorDAO.asignarDesarrollador(15, 4);
        desarrolladorDAO.asignarDesarrollador(15, 9);
        desarrolladorDAO.asignarDesarrollador(15, 10);
        desarrolladorDAO.asignarDesarrollador(16, 6);
        desarrolladorDAO.asignarDesarrollador(16, 7);
        desarrolladorDAO.asignarDesarrollador(17, 3);
        desarrolladorDAO.asignarDesarrollador(17, 5);
        desarrolladorDAO.asignarDesarrollador(17, 10);
        desarrolladorDAO.asignarDesarrollador(18, 5);
        desarrolladorDAO.asignarDesarrollador(18, 8);
        desarrolladorDAO.asignarDesarrollador(19, 1);
        desarrolladorDAO.asignarDesarrollador(19, 9);
        desarrolladorDAO.asignarDesarrollador(19, 10);
        desarrolladorDAO.asignarDesarrollador(20, 4);
        desarrolladorDAO.asignarDesarrollador(20, 7);
        desarrolladorDAO.asignarDesarrollador(20, 10);
        desarrolladorDAO.asignarDesarrollador(12, 10);
        desarrolladorDAO.asignarDesarrollador(14, 10);
        desarrolladorDAO.asignarDesarrollador(16, 10);
        desarrolladorDAO.asignarDesarrollador(18, 10);
        desarrolladorDAO.asignarDesarrollador(13, 9);
        desarrolladorDAO.asignarDesarrollador(20, 9);



        Proyecto p = new Proyecto("Plataforma BugHunters", 2500.0, "Java");
        proyectoDAO.insertarProyecto(p);
        proyectoDAO.actualizarProyecto(p.getId(), "Ecosistema BugHunters Pro", 4500.0, "Java");
        proyectoDAO.borrarProyecto(p.getId());


        Desarrollador d = new Desarrollador("Julian Chavez", 2, 15.0);
        desarrolladorDAO.insertarDesarrollador(d);
        desarrolladorDAO.actualizarDesarrollador(d.getId(), "Julian Chavez Senior", 4, 30.0);
        desarrolladorDAO.borrarDesarrollador(d.getId());


        desarrolladorDAO.asignarDesarrollador(15, 3);
        desarrolladorDAO.eliminarAsignacion(15, 3);


        System.out.println("Cantidad de programadores asignados a cada proyecto: " + proyectoDAO.obtenerNumDesarrolladoresPorProyecto());
        System.out.println("Equipo de desarrollo vinculado al proyecto 1: " + proyectoDAO.obtenerDesarrolladoresDeProyecto(1));
        System.out.println("Proyectos que cuentan con más de 5 programadores: " + proyectoDAO.obtenerProyectosConMasDe5Desarrolladores());
        System.out.println("Ranking de los 3 proyectos con mayor asignación económica: " + proyectoDAO.obtenerTop3Presupuesto());
        System.out.println("El proyecto de Python con la inversión más baja: " + proyectoDAO.obtenerProyectoMasBaratoPorLenguaje("Python"));


        System.out.println("Trabajos asignados al desarrollador con ID 11: " + desarrolladorDAO.obtenerProyectosDeDesarrollador(11));
        System.out.println("Promedio de tiempo de experiencia del equipo: " + desarrolladorDAO.obtenerMediaExperiencia());
        System.out.println("Programadores que no están vinculados a ningún proyecto: " + desarrolladorDAO.obtenerDesarrolladoresSinProyecto());

        emf.close();
    }
}