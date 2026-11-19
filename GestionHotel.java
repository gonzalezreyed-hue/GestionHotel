import java.util.ArrayList;
import java.util.Scanner;

public class GestionHotel {

    static ArrayList<HabitacionHotel> habitaciones = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN HOTELERA =====");
            System.out.println("1. Crear objeto por defecto");
            System.out.println("2. Crear objeto con parámetros");
            System.out.println("3. Modificar atributos del objeto");
            System.out.println("4. Visualizar objetos registrados");
            System.out.println("5. Reservar habitación");
            System.out.println("6. Calcular hospedaje");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    habitaciones.add(new HabitacionHotel());
                    System.out.println("Habitación por defecto creada.");
                    break;
                case 2:
                    System.out.print("Número: ");
                    int numero = sc.nextInt();
                    System.out.print("Precio por noche: ");
                    double precio = sc.nextDouble();
                    System.out.print("Capacidad: ");
                    int capacidad = sc.nextInt();
                    System.out.print("¿Ocupada? (true/false): ");
                    boolean ocupada = sc.nextBoolean();
                    habitaciones.add(new HabitacionHotel(numero, precio, capacidad, ocupada));
                    System.out.println("Habitación creada.");
                    break;
                case 3:
                    int p3 = pedirPosicion();
                    if (p3 != -1) {
                        HabitacionHotel h = habitaciones.get(p3);
                        System.out.print("Nuevo número: ");
                        h.setNumero(sc.nextInt());
                        System.out.print("Nuevo precio por noche: ");
                        h.setPrecioNoche(sc.nextDouble());
                        System.out.print("Nueva capacidad: ");
                        h.setCapacidad(sc.nextInt());
                        System.out.print("¿Ocupada? (true/false): ");
                        h.setOcupada(sc.nextBoolean());
                        System.out.println("Habitación modificada.");
                    }
                    break;
                case 4:
                    if (habitaciones.isEmpty()) {
                        System.out.println("No hay habitaciones registradas.");
                    } else {
                        for (int i = 0; i < habitaciones.size(); i++) {
                            System.out.println("[" + i + "] " + habitaciones.get(i));
                        }
                    }
                    break;
                case 5:
                    int p5 = pedirPosicion();
                    if (p5 != -1) {
                        System.out.print("Número de personas: ");
                        habitaciones.get(p5).reservar(sc.nextInt());
                    }
                    break;
                case 6:
                    int p6 = pedirPosicion();
                    if (p6 != -1) {
                        System.out.print("Número de noches: ");
                        double total = habitaciones.get(p6).calcularHospedaje(sc.nextInt());
                        System.out.println("Total a pagar: $" + total);
                    }
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

    // Pide la posición y verifica que exista
    static int pedirPosicion() {
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
            return -1;
        }
        System.out.print("Posición de la habitación (0 a " + (habitaciones.size() - 1) + "): ");
        int pos = sc.nextInt();
        if (pos < 0 || pos >= habitaciones.size()) {
            System.out.println("Esa posición no existe.");
            return -1;
        }
        return pos;
    }
}
