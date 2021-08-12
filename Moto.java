import java.util.*;
public class Moto extends Vehiculo
{   
    public static int cobro;
    private static final String clase = "Moto";
    public Moto(String placa, String marca, String color, int cobro){
        super(placa,marca,color);
        super.setIngreso();
        super.setTipo(clase);
        this.setCobro(cobro);
    }
    public Moto(String placa, String marca, String color, int vC, int cobro){
        super(placa,marca,color);
        super.setValor(vC);
        super.setTipo(clase);
        super.setIngreso();
        this.setCobro(cobro);
    }
    public void setCobro(int cobro){
        super.cobro = cobro;
        this.cobro = cobro;
    }
    public int getCobro(){
        return this.cobro;
    }
}
