package org.example;
import java.util.*;
import java.util.stream.Collectors;


/* para resolver este enunciado este codigo tomo como que cada sala tiene una pelicula
* en distintos horarios, cada entrada tiene un valor de $10*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declarar arraylist de objetos, segun su tipo
        List<Cliente> clientes = new ArrayList<>();
        List<Pelicula> cartelera = new ArrayList<>();
        List<Sala> salas = new ArrayList<>();

        //funciones inicializar cartelera
        inicializarCartelera(cartelera);
        inicializarSalas(salas, cartelera);

        //para este caso donde constantemente se pide
        // ingresar clientes y no dar opciones conviene un whiletrue
        while (true) {

            //menu
            System.out.println("----- Nuevo cliente -------");
            System.out.println("Ingrese Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese Correo: ");
            String correo = sc.nextLine();
            clientes.add(new Cliente(nombre, correo));
            mostrarCartelera(cartelera);
            System.out.println("Seleccione la película:");
            int opcionPelicula = sc.nextInt();
            sc.nextLine();

            //validacion de pelicula puede pasarse a funcion
            if (opcionPelicula < 1 || opcionPelicula > cartelera.size()) {
                System.out.println("Opción de película no válida.... volviendo atras");
                continue;
            }

            //-1 porque la lista parte de 0
            Pelicula peliculaSeleccionada = cartelera.get(opcionPelicula-1);
            //funcion mostrar
            mostrarSalasDisponibles(salas, peliculaSeleccionada);
            System.out.println("Seleccione la sala:");
            int opcionSala = sc.nextInt();
            sc.nextLine();

            //validacion de sala aqui se requiere añadir que la sala sea correcta xd
            if (opcionSala < 1 || opcionSala > salas.size()) {
                System.out.println("Opción de sala no válida.... volviendo atras");
                continue;
            }
//validacion que la sala selccionada tiene la pelicula
            Sala salaSeleccionada = salas.get(opcionSala-1);
            if (!salaSeleccionada.getPeliculas().contains(peliculaSeleccionada)) {
                System.out.println("La película seleccionada no está disponible en la sala elegida. Volviendo atrás.");
                continue;
            }

            //Obtener horarios
            System.out.println("Seleccione el horario:");
            for (int i = 0; i < salaSeleccionada.getHorarios().size(); i++) {
                System.out.println((i + 1) + ". " +salaSeleccionada.getHorarios().get(i));
            }

            int opcionHorario = sc.nextInt();
            sc.nextLine();

            //validar horario
            if (opcionHorario < 1 || opcionHorario > salaSeleccionada.getHorarios().size()) {
                System.out.println("Opción de horario no válida.....volviendo atras");
                continue;
            }
            //obtener horario
            String horarioSeleccionado = salaSeleccionada.getHorarios().get(opcionHorario-1);
            System.out.println("Ingrese la cantidad de entradas: ");
            int cantidadEntradas = sc.nextInt();
            sc.nextLine();
            //cantidad de entrada
            if (cantidadEntradas > salaSeleccionada.getNumeroAsientos()) {
                System.out.println("No hay suficientes entradas disponibles.... volviendo atras");
                continue;
            }
            //funcion procesar compra
            procesarCompra(clientes.get(clientes.size()-1),
                    salaSeleccionada, peliculaSeleccionada, horarioSeleccionado, cantidadEntradas);
            System.out.println("Escriba s para finalizar su compra / n para cerrar sistema y mostrar resumen (s/n).");
            String continuar = sc.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }




//funcion final
        mostrarEstadisticasVenta(salas);
    }

    private static void mostrarCartelera(List<Pelicula> cartelera) {
        System.out.println("Cartelera Disponible:");
        for (int i = 0; i < cartelera.size(); i++) {
            System.out.println(i+1+ ". "+cartelera.get(i).getTitulo());
        }
    }
//inicializar salas
    private static void inicializarSalas(List<Sala> salas, List<Pelicula> cartelera) {
        for (int i = 0; i < cartelera.size(); i++) {
            List<Pelicula> peliculasSala = new ArrayList<>();
            peliculasSala.add(cartelera.get(i));
            List<String> horariosSala = Arrays.asList("10:30", "13:00", "15:30"); // horarios predefinidos
            salas.add(new Sala(i + 1, peliculasSala, horariosSala, 100));
        }
    }

    //inicializar datos
    private static void inicializarCartelera(List<Pelicula> cartelera) {
        cartelera.add(new Pelicula("Pelicula1", "2024-05-15"));
        cartelera.add(new Pelicula("Pelicula2", "2024-05-16"));
        cartelera.add(new Pelicula("Pelicula3", "2024-05-17"));
    }

    //mostrar salas disponibles
    private static void mostrarSalasDisponibles(List<Sala> salas, Pelicula peliculaSeleccionada) {
        System.out.println("Salas Disponibles para " + peliculaSeleccionada.getTitulo() + ":");
        for (Sala sala : salas) {
            if (sala.getPeliculas().contains(peliculaSeleccionada)) {
                System.out.println("Sala "+sala.getNumeroSala()+": "+
                        "-Fecha: "+peliculaSeleccionada.getFecha()+
                        "-Horarios: "+sala.getHorarios()+"- Asientos Disponibles: "+sala.getNumeroAsientos());
            }
        }
    }
//procesar compra
    private static void procesarCompra(Cliente cliente,
                                       Sala sala, Pelicula pelicula, String horario,
                                       int cantidadEntradas) {
        System.out.println("--- Confirmación de Compra ------");
        System.out.println("Cliente: " +cliente.getNombre());
        System.out.println("Pelicula: " +pelicula.getTitulo());
        System.out.println("Sala: " +sala.getNumeroSala());
        System.out.println("Horario: " +horario);
        System.out.println("Cantidad de Entradas: " + cantidadEntradas);
        double precioTotal = cantidadEntradas * 10;//10 dolarucos por entrada
        System.out.println("Precio Total: $" + precioTotal);
        System.out.println("Compra realizada con éxito ----> volviendo");
        sala.venderEntradas(cantidadEntradas);
    }
    private static void mostrarEstadisticasVenta(List<Sala> salas) {
        Map<Pelicula, Integer> ventasPorPelicula = new HashMap<>();
        double ingresosTotales = 0;
        for (Sala sala : salas) {
            for (Pelicula pelicula : sala.getPeliculas()) {
                int cantidadVendida = sala.getNumeroAsientos();
                ventasPorPelicula.put(pelicula, ventasPorPelicula.getOrDefault(pelicula, 0) + cantidadVendida);
                ingresosTotales += cantidadVendida * 10;
            }
        }
        Pelicula peliculaMenosVendida = Collections.max(ventasPorPelicula.entrySet(), Map.Entry.comparingByValue()).getKey();
        Pelicula peliculaMasVendida = Collections.min(ventasPorPelicula.entrySet(), Map.Entry.comparingByValue()).getKey();
        Map<String, Long> horariosPopulares = salas.stream()
                .flatMap(sala -> sala.getHorarios().stream())
                .collect(Collectors.groupingBy(horario -> horario, Collectors.counting()));
        String horarioMasPopular = Collections.max(horariosPopulares.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Estadísticas de Venta:");
        System.out.println("Película menos vendida: "+peliculaMasVendida.getTitulo());
        System.out.println("Película mas vendida: "+peliculaMenosVendida.getTitulo());
        System.out.println("Ingresos totales: $"+ingresosTotales);
        System.out.println("Horario más popular: "+horarioMasPopular);
    }

}
