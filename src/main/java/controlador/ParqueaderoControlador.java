/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.*;

/**
 *
 * @author juanr
 */
public class ParqueaderoControlador {

    private Parqueadero parqueadero;

    public ParqueaderoControlador() {
        parqueadero = new Parqueadero();
    }

    public void entradaAuto(String placa, String marca, String modelo, String combustible) {
        Automovil auto = new Automovil(placa, marca, modelo, combustible);
        parqueadero.registrarEntrada(auto);
    }

    public void entradaMoto(String placa, String marca, String modelo, int cilindraje) {
        Motocicleta moto = new Motocicleta(placa, marca, modelo, cilindraje);
        parqueadero.registrarEntrada(moto);
    }

    public void entradaCamion(String placa, String marca, String modelo, double carga) {
        Camion camion = new Camion(placa, marca, modelo, carga);
        parqueadero.registrarEntrada(camion);
    }

    public double salida(String placa) {
        return parqueadero.registrarSalida(placa);
    }

    public void consultarEstado() {
        parqueadero.consultarEstado();
    }
}
