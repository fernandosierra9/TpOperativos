package dominio.categoria;

import dominio.usuario.Cliente;
import dominio.repositories.TypeRepo;

public class Categoria implements TypeRepo {
    private String nombre;
    private Integer consumoMinimo;
    private Integer consumoMaximo;
    private Double cargoFijo;
    private Double cargoVariable;

    public Categoria(String nombreCategoria, Integer consumoMinimo, Integer consumoMaximo, Double cargoFijo, Double cargoVariable) {
        this.nombre = nombreCategoria;
        this.consumoMinimo = consumoMinimo;
        this.consumoMaximo = consumoMaximo;
        this.cargoFijo = cargoFijo;
        this.cargoVariable = cargoVariable;
    }


    public boolean cumpleCondicion(Cliente cliente) {

        //Si consumo maximo es null quiere decir que cualquier numero es menor a este
        return cliente.consumoEnergeticoTotal() >= consumoMinimo &&
                (consumoMaximo == null || cliente.consumoEnergeticoTotal() <= consumoMaximo);
    }


    private Double getCargoFijo() {
        return this.cargoFijo;
    }

    public Double getCargoVariable() {
        return this.cargoVariable;
    }

    public Double calcularCostosPara(Cliente cliente) {
        return this.getCargoFijo() + this.getCargoVariable() * cliente.consumoEnergeticoTotal();
    }

    public String getNombreCategoria() {
        return this.nombre;
    }

}