import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Vehiculo{   
    //Campos generales del programa
    public static Vehiculo[][] vehiculos; 
    public static int tamano; //cantidad de espacios totales en el edificio
    public static int cantidad = 0;//contador de Autos dentro del parqueadero
    public static int cobro;
    //Atributos de caracterización para los objetos
    private String placa; //Placa del auto  
    private String marca; //Marca del auto 
    private String color; //Color del auto
    private String clase; //Clase de Vehiculo
    private LocalDateTime entrada; 
    private int valorComercial; //Precio del auto    
    public Vehiculo(){
        //constructor vacío, sin función.
    }
    public Vehiculo(String p, String m, String c){
        //constructor de un auto cuyo valor comercial es desconocido.
        this(p,m,c,30000000);
        this.setIngreso();
        this.setTipo(clase);
    }
    public Vehiculo(String p, String m, String c, int vC){
        //constructor de un auto cuyo valor comercial es conocido.
        this.setPlaca(p);
        this.setMarca(m);
        this.setColor(c);
        this.setValor(vC);
        this.setIngreso();
        this.setTipo(clase);
        Vehiculo.cantidad++;
    }
    //Métodos set&get (características por individuo)
    public void setMarca(String m){
        this.marca = m;
    }
    public void setPlaca(String p){
        this.placa = p;
    }
    public void setColor(String c){
        this.color = c;
    }
    public void setValor(int vC){
        this.valorComercial = vC;
    }
    public void setTipo(String tipo){
        this.clase = tipo;
    }    
    public void setIngreso(){
        final LocalDateTime ingreso = LocalDateTime.now();
        this.entrada = ingreso;
    }
    public LocalDateTime getIngreso(){
        return this.entrada;
    }
    public String getPlaca(){
        return this.placa;
    }
    public String getMarca(){
        return this.marca;
    }
    public String getColor(){
        return this.color;
    }
    public int getValor(){
        return valorComercial;
    }
    public int getCobro(){
        return this.cobro;
    }
    public String getTipo(){
        return this.clase;
    }
    public String toString(){
        String unitValue =
        " Placa: "+ this.getPlaca() + ", Marca: " + this.getMarca() + ", Color: " + this.getColor()
        + ", Valor comercial: " + this.getValor() + ", Tipo de vehículo: " + this.getTipo() + ", Hora de ingreso: "
        + toStringHora(this.getIngreso()) + "||"+"\n";
        return unitValue;            
    }
    public static String toStringHora(LocalDateTime ref){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-YY h:mm a");
        return dtf.format(ref);
    }
    public static String toStringVehiculos(Vehiculo[] ref){
        String fullInfo= "";
        for(Vehiculo vehiculo: ref){            
            fullInfo += vehiculo.toString();         
        }
        if(fullInfo == ""){
           fullInfo+= "No hay información disponible." + "\n";   
        }
        return fullInfo;
    }
    public static String toStringVehiculos(){
        String g="";
        for(int i=0; i<vehiculos.length; i++){
            for(int j=0; j<vehiculos[i].length; j++){
                if(vehiculos[i][j] != null){
                    g+= vehiculos[i][j].toString();  
                }
            }
        }   
        return g;
    }
    public static Vehiculo[] bubleSort (Vehiculo[] ref) {
        boolean swap = true;
        Vehiculo temp = new Vehiculo("x","x","x",1);
        Vehiculo[] ordenTemporal = new Vehiculo[ref.length];
        while(swap){
            swap = false;
            for(int i = 0;i < ref.length-1; i++){
                if(ref[i].getValor() > ref[i+1].getValor()){
                    temp = ref[i];
                    ref[i] = ref[i+1];
                    ref[i+1] = temp;                   
                    swap = true;
                }
            }
        }
        for(int i = 0;i < ordenTemporal.length; i++){
            ordenTemporal[i] = ref[i];
        }
        return ordenTemporal;
    }
    public static Vehiculo[] vehiculoToArray(){
        int c = 0;
        for(int i=0; i<Vehiculo.vehiculos.length; i++){
            for(int j=0; j<Vehiculo.vehiculos[i].length; j++){
                if(Vehiculo.vehiculos[i][j] != null){
                    c++;
                }
            }
        }
        Vehiculo[] array = new Vehiculo[c];
        int d = 0;
        for(int i=0; i<Vehiculo.vehiculos.length; i++){
            for(int j=0; j<Vehiculo.vehiculos[i].length; j++){
                if(Vehiculo.vehiculos[i][j] != null){
                    array[d] = Vehiculo.vehiculos[i][j]; 
                    d++;
                }
            }
        }
        return array;
    }
    public static Vehiculo[] valorOrdenado(){
        Vehiculo[] valoresOptimos = Vehiculo.vehiculoToArray();
        Vehiculo.bubleSort(valoresOptimos);
        return valoresOptimos;
    }
    public static String VehiculosColor(String c){
       String text="";
       for(int i=0; i<vehiculos.length; i++){
            for(int j=0; j<vehiculos[i].length; j++){
                if((vehiculos[i][j]!= null)&&(vehiculos[i][j].getColor().equalsIgnoreCase(c))){
                    text+= vehiculos[i][j].toString();     
                }
            }
       }
       if(text == ""){
           text+= "No se han encontrado vehiculos con este color..."+"\n";     
       }
        return text; 
    }
    public static LocalDateTime horaActual(){
        return LocalDateTime.now();
    } 
    public static String salida(int x, int y){
        Vehiculo mov = Vehiculo.vehiculos[x][y];//variable para acortar sintaxis.
        long pago = Duration.between(mov.getIngreso(),horaActual()).toMinutes()*(mov.getCobro()/60);
        Vehiculo.vehiculos[x][y] = null;//liberar espacio
        Sensor.sensores[x][y].setEstado(0);
        return "Total a pagar $"+pago;
    }
}
