package Clases;

public class DispositivoInteligente extends Dispositivo
{
    public DispositivoInteligente(String nombre, double consumoEstimadoPorHora)
    {
        super(nombre,consumoEstimadoPorHora);
    }
    public double consumoUltimasXHoras(int X)
    {
        if(X >= horasDeUso)
        {
            return consumoEstimadoPorHora * horasDeUso;
        }
        else
        {
            return consumoEstimadoPorHora * X;
        }
    }

    public void modoAhorroDeEnergia()
    {
        estado = EstadoDispositivo.APAGADO.MODOAHORRO;
    }

}
