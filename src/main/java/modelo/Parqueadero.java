/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanr
 */
public class Parqueadero {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    private final double TARIFA_AUTO = 3000;
    private final double TARIFA_MOTO = 1500;
    private final double TARIFA_CAMION = 8000;

    /**
     * Registra entrada de un vehiculo
     */
    public void registrarEntrada(Vehiculo v) {
        vehiculos.add(v);
        System.out.println("Vehiculo ingresado correctamente.");
    }

    /**
     * Registra salida y retorna el costo
     */
    public double registrarSalida(String placa) {
        Vehiculo v = buscarVehiculo(placa);

        if (v == null) {
            System.out.println("No se encontro un vehiculo con esa placa.");
            return 0;
        }

        double costo = calcularCosto(v);
        vehiculos.remove(v);
        return costo;
    }

    /**
     * Busca vehículo por placa
     */
    private Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Consulta estado del parqueadero
     */
    public void consultarEstado() {
        if (vehiculos.isEmpty()) {
            System.out.println("El parqueadero esta vacio.");
        } else {
            System.out.println("Vehiculos en el parqueadero:");
            for (Vehiculo v : vehiculos) {
                System.out.println("- " + v.getTipo() + " | Placa: " + v.getPlaca());
            }
        }
    }

    /**
     * Calcula costo segun tiempo y tipo
     */
    private double calcularCosto(Vehiculo v) {
        LocalDateTime ahora = LocalDateTime.now();
        long minutos = Duration.between(v.getHoraEntrada(), ahora).toMinutes();
        long horas = (long) Math.ceil(minutos / 60.0);

        double tarifa = 0;

        if (v instanceof Automovil) {
            tarifa = TARIFA_AUTO;
        } else if (v instanceof Motocicleta) {
            tarifa = TARIFA_MOTO;
        } else if (v instanceof Camion) {
            tarifa = TARIFA_CAMION;
        }

        return horas * tarifa;
    }
}
