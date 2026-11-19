public class HabitacionHotel {
    private int numero;
    private double precioNoche;
    private int capacidad;
    private boolean ocupada;

    // Constructor por defecto
    public HabitacionHotel() {
        this.numero = 101;
        this.precioNoche = 120000;
        this.capacidad = 2;
        this.ocupada = false;
    }

    // Constructor con parámetros
    public HabitacionHotel(int numero, double precioNoche, int capacidad, boolean ocupada) {
        this();
        setNumero(numero);
        setPrecioNoche(precioNoche);
        setCapacidad(capacidad);
        this.ocupada = ocupada;
    }

    // Getters
    public int getNumero() { return numero; }
    public double getPrecioNoche() { return precioNoche; }
    public int getCapacidad() { return capacidad; }
    public boolean isOcupada() { return ocupada; }

    // Setters con validaciones
    public void setNumero(int numero) {
        if (numero > 0) this.numero = numero;
        else System.out.println("Número inválido, se deja el anterior.");
    }

    public void setPrecioNoche(double precioNoche) {
        if (precioNoche > 0) this.precioNoche = precioNoche;
        else System.out.println("Precio inválido, se deja el anterior.");
    }

    public void setCapacidad(int capacidad) {
        if (capacidad > 0) this.capacidad = capacidad;
        else System.out.println("Capacidad inválida, se deja la anterior.");
    }

    public void setOcupada(boolean ocupada) { this.ocupada = ocupada; }

    // Método 1: reservar
    public boolean reservar(int personas) {
        if (ocupada) {
            System.out.println("La habitación " + numero + " ya está ocupada.");
            return false;
        }
        if (personas <= 0 || personas > capacidad) {
            System.out.println("Capacidad no válida. Máximo " + capacidad + " personas.");
            return false;
        }
        ocupada = true;
        System.out.println("Reserva exitosa de la habitación " + numero + " para " + personas + " personas.");
        return true;
    }

    // Método 2: calcular hospedaje
    public double calcularHospedaje(int noches) {
        if (noches <= 0) {
            System.out.println("El número de noches debe ser mayor a 0.");
            return 0;
        }
        double total = precioNoche * noches;
        if (noches >= 5) {
            total = total * 0.90; // 10% de descuento
            System.out.println("Se aplicó un 10% de descuento.");
        }
        return total;
    }

    @Override
    public String toString() {
        return "Habitación " + numero + " | Precio/noche: $" + precioNoche
                + " | Capacidad: " + capacidad + " | Ocupada: " + (ocupada ? "Sí" : "No");
    }
}
