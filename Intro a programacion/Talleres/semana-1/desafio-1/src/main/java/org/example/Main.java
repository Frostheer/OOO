package org.example;
import java.util.*;



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
        /*para este caso donde constantemente se pide
        * ingresar clientes y no dar opciones conviene un whiletrue*/
        while (true) {
            //menu
            System.out.println("----- Nuevo cliente ------");
            System.out.println("Ingrese Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese Correo: ");
            String correo = sc.nextLine();
            clientes.add(new Cliente(nombre, correo));
            mostrarCartelera(cartelera);
            System.out.println("Seleccione la pelicula:");
            int opcionPelicula = sc.nextInt();
            sc.nextLine();
            //validacion de pelicula puede pasarse a funcion
            if (opcionPelicula<1 || opcionPelicula>cartelera.size()) {
                System.out.println("Opcion de pelicula no valida.... volviendo atras");
                continue;
            }
            //-1 porque la lista parte de 0
            Pelicula peliculaSeleccionada = cartelera.get(opcionPelicula - 1);
            //funcion mostrar
            mostrarSalasDisponibles(salas, peliculaSeleccionada);
            System.out.println("Seleccione la sala:");
            int opcionSala = sc.nextInt();
            sc.nextLine();
            //validacion de sala aqui se requiere añadir que la sala sea correcta xd
            if (opcionSala < 1 || opcionSala > salas.size()) {
                System.out.println("pcion de sala no válida.... volviendo atras");
                continue;
            }
//la sala correcta bsbsbs
            Sala salaSeleccionada = salas.get(opcionSala-1);
            if (!salaSeleccionada.getPeliculas().contains(peliculaSeleccionada)) {
                System.out.println("La pelicula seleccionada no esta disponible en la sala elegida. Volviendo atras.");
                continue;
            }
            //Obtener horarios
            System.out.println("Seleccione el horario:");
            for (int i = 0; i<salaSeleccionada.getHorarios().size(); i++) {
                System.out.println((i + 1)+ ". "+salaSeleccionada.getHorarios().get(i));
            }

            int opcionHorario = sc.nextInt();
            sc.nextLine();
            //validar horario
            if (opcionHorario < 1 || opcionHorario > salaSeleccionada.getHorarios().size()) {
                System.out.println("Opcion de horario no válida.....volviendo atras");
                continue;
            }
            //obtener horario seguna la sala selecionada
            String horarioSeleccionado = salaSeleccionada.getHorarios().get(opcionHorario - 1);
            System.out.println("Ingrese la cantidad de entradas: ");
            int cantidadEntradas = sc.nextInt();
            sc.nextLine();
            //cantidad de entrada
            if (cantidadEntradas > salaSeleccionada.getNumeroAsientos()) {
                System.out.println("no hay suficientes entradas disponibles.... volviendo atras");
                continue;
            }
            //funcion procesar compra y construir entrada
            Entrada entrada = new Entrada(clientes.get(clientes.size()-1)
                    , salaSeleccionada, peliculaSeleccionada, horarioSeleccionado, cantidadEntradas);
            procesarCompra(entrada);

            System.out.println("escriba s para finalizar su compra / " +
                    "n para cerrar sistema y mostrar resumen (s/n).");
            String continuar = sc.nextLine();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }
        //funcion final
        mostrarEstadisticasVenta(salas);
    }

    private static void mostrarCartelera(List<Pelicula> cartelera) {
        System.out.println("Cartelera disponible:");
        for (int i = 0; i < cartelera.size(); i++) {
            System.out.println((i + 1) + ". " + cartelera.get(i).getTitulo());
        }
    }
//for que recorre la cartelera y la añade a la sala junto con un horario
    private static void inicializarSalas(List<Sala> salas, List<Pelicula> cartelera) {
        for (int i = 0; i < cartelera.size(); i++) {
            List<Pelicula> peliculasSala = new ArrayList<>();
            peliculasSala.add(cartelera.get(i));
            List<String> horariosSala = Arrays.asList("10:30", "13:00", "15:30");
            salas.add(new Sala(i + 1, peliculasSala, horariosSala, 100));
        }
    }
//iniciazliar cartelera
    private static void inicializarCartelera(List<Pelicula> cartelera) {
        cartelera.add(new Pelicula("Pelicula1", "2024-05-15"));
        cartelera.add(new Pelicula("Pelicula2", "2024-05-16"));
        cartelera.add(new Pelicula("Pelicula3", "2024-05-17"));
    }

    private static void mostrarSalasDisponibles(List<Sala> salas, Pelicula peliculaSeleccionada) {
        System.out.println("salas disponibles para "+peliculaSeleccionada.getTitulo()+":");
        //por sala se busca la que tenga la pelicula selecionada
        for (Sala sala : salas) {
            if (sala.getPeliculas().contains(peliculaSeleccionada)) {
                System.out.println("sala "+sala.getNumeroSala()+": "+
                        "-hecha: "+peliculaSeleccionada.getFecha()+
                        "-horarios: "+sala.getHorarios()+"- Asientos disponibles: "+
                        sala.getNumeroAsientos());
            }
        }
    }
//se procesa la compra mediante la entrada
    private static void procesarCompra(Entrada entrada) {
        Sala sala = entrada.getSala();
        sala.venderEntradas(entrada);
        System.out.println("--- Confirmacion de Compra ------");
        System.out.println("Cliente: " + entrada.getCliente().getNombre());
        System.out.println("Pelicula: " + entrada.getPelicula().getTitulo());
        System.out.println("Sala: " + sala.getNumeroSala());
        System.out.println("Horario: " + entrada.getHorario());
        System.out.println("Cantidad de Entradas: " + entrada.getCantidad());
        double precioTotal = entrada.getCantidad() * 10;//cada entrada vale 10 pavos
        System.out.println("Precio Total: $" + precioTotal);
        System.out.println("Compra realizada con exito ----> volviendo");
    }

//estadistica de venta por sala
    private static void mostrarEstadisticasVenta(List<Sala> salas) {
        Map<Pelicula, Integer> ventasPorPelicula = new HashMap<>();
        Map<String, Integer> ventasPorHorario = new HashMap<>();
        double ingresosTotales = 0;
        for (Sala sala : salas) {
            for (Entrada entrada : sala.getEntradasVendidas()) {
                Pelicula pelicula = entrada.getPelicula();
                String horario = entrada.getHorario();
                int cantidad = entrada.getCantidad();
                ventasPorPelicula.put(pelicula,
                        ventasPorPelicula.getOrDefault(pelicula, 0)+cantidad);
                ventasPorHorario.put(horario, ventasPorHorario.getOrDefault(horario, 0)
                        +cantidad);
                ingresosTotales += cantidad * 10;
            }
        }
        //funciones Collections para buscar el tope y el min 
        Pelicula peliculaMasVendida = Collections.max(ventasPorPelicula.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        Pelicula peliculaMenosVendida = Collections.min(ventasPorPelicula.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        String horarioMasPopular = Collections.max(ventasPorHorario.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        System.out.println("resumen estadistico de Venta:");
        System.out.println("pelicula mas vendida: "+peliculaMasVendida.getTitulo());
        System.out.println("pelicula menos vendida: "+peliculaMenosVendida.getTitulo());
        System.out.println("Ingresos totales: $"+ingresosTotales);
        System.out.println("horario mas popular: "+horarioMasPopular);
    }
}

