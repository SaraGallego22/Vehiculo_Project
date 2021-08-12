import java.util.*;
import java.io.*;
public class Principal{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        System.out.println("¡Bienvenido!");
        System.out.print("Ingrese la cantidad de pisos del edificio: ");
        int pisos= scan.nextInt();
        System.out.print("Ingrese la cantidad de espacios para cada piso: ");
        int espacios= scan.nextInt();
        Vehiculo.vehiculos = new Vehiculo[espacios][pisos];
        Sensor.sensores = new Sensor[espacios][pisos];
        Vehiculo.tamano = espacios*pisos;
        for(int i=0; i<Sensor.sensores.length; i++){
            for(int j=0; j<Sensor.sensores[i].length; j++){
                Sensor.sensores[i][j] = new Sensor(0);
            }
        }
 
        System.out.print("Ingrese el valor del parqueadero para motos por hora: ");
        int valorMotos= scan.nextInt();
        System.out.print("Ingrese el valor del parqueadero para carros por hora: ");
        int valorCarros= scan.nextInt();
 
                    System.out.print(
            "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  0 | ⇒ |  Terminar ejecucion                                                               |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  1 | ⇒ |  Indicar espacios disponibles                                                     |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  2 | ⇒ |  Ingresar PLACA-MARCA-COLOR del vehiculo                                          |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  3 | ⇒ |  Ingresar PLACA-MARCA-COLOR-PRECIO del vehiculo                                   |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  4 | ⇒ |  Mostrar la informacion de los vehiculos ingresados en el sistema                 |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  5 | ⇒ |  Mostrar la cantidad de vehiculos ingresados en el sistema                        |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  6 | ⇒ |  Verificar el estado de un espacio                                                |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  7 | ⇒ |  Mostrar el estado de todos los espacios                                          |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  8 | ⇒ |  Presentar ordenadamente la informacion de los vehiculos con un color determinado |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  9 | ⇒ |  Presentar la informacion de los vehiculos ordenados por su valor comercial       |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO 10 | ⇒ |  Retirar vehiculo de un espacio determinado                                       |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO 11 | ⇒ |  Exportar fichero con la informacion de los vehiculos ingresados en el sistema    |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "Accion: ");         
        int num= scan.nextInt();
        while(num!=0){
            switch(num){
                case 1:
                System.out.println(Sensor.sensorLibre());
                break;
 
                case 2:
                System.out.println("¿Qué vehiculo desea ingresar?");
                System.out.print( "1. Carro || 2. Moto : ");
                int numClase = scan.nextInt();
             if(numClase == 1){                
                System.out.print("Ingrese el piso donde desea ubicar el carro: ");
                int piso= scan.nextInt()-1;
                System.out.print("Ingrese el espacio donde desea ubicar el carro: ");
                int espacio= scan.nextInt()-1;
                   if((piso > pisos)||(espacio > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                    break;
                   }
                    else if(Sensor.sensores[espacio][piso].getEstado() != 0){
                    System.out.println("Parqueadero ocupado, no se puede ejercer esta acción.");
                    break;
                   }else {
                    System.out.print("Ingrese la placa del carro: ");
                    String placa= scan.next();
                    System.out.print("Ingrese la marca del carro: ");
                    String marca= scan.next();
                    System.out.print("Ingrese el color del carro: ");
                    String color= scan.next();
                    Vehiculo vehiculo= new Carro(placa, marca, color, valorCarros);
                    Sensor.sensores[piso][espacio]= new Sensor(1);               
                    vehiculo.vehiculos[piso][espacio]=vehiculo;
                    System.out.println(vehiculo.toString());;
                    break;
                   }
             }else if(numClase == 2){
                  System.out.print("Ingrese el piso donde desea ubicar la moto: ");
                  int piso= scan.nextInt()-1;
                  System.out.print("Ingrese el espacio donde desea ubicar la moto: ");
                  int espacio= scan.nextInt()-1;
                   if((piso > pisos)||(espacio > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                    break;
                   }
                    else if(Sensor.sensores[piso][espacio].getEstado() != 0){
                    System.out.println("Parqueadero ocupado, no se puede ejercer esta acción.");
                    break;
                   }else {
                    System.out.print("Ingrese la placa de la moto: ");
                    String placa= scan.next();
                    System.out.print("Ingrese la marca de la moto: ");
                    String marca= scan.next();
                    System.out.print("Ingrese el color de la moto: ");
                    String color= scan.next();
                    Vehiculo vehiculo = new Moto(placa, marca, color, valorMotos);
                    Sensor.sensores[piso][espacio]= new Sensor(1);               
                    vehiculo.vehiculos[piso][espacio]=vehiculo;
                    System.out.println(vehiculo.toString());
                    break;
                }
             }else{
                System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                break;
             }
 
                case 3:
                System.out.println("¿Qué vehiculo desea ingresar?");
                System.out.print( "1. Carro || 2. Moto : ");
                int numClase2 = scan.nextInt();
             if(numClase2 == 1){                
                System.out.print("Ingrese el piso donde desea ubicar el carro: " );
                int piso2= scan.nextInt()-1;
                System.out.print("Ingrese el espacio donde desea ubicar el carro: " );
                int espacio2= scan.nextInt()-1;
                   if((piso2 > pisos)||(espacio2 > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                    break;
                   }
                    else if(Sensor.sensores[piso2][espacio2].getEstado() != 0){
                    System.out.println("Parqueadero ocupado, no se puede ejercer esta acción.");
                    break;
                   }else {
                    System.out.print("Ingrese la placa del carro: ");
                    String placa2= scan.next();
                    System.out.print("Ingrese la marca del carro: ");
                    String marca2= scan.next();
                    System.out.print("Ingrese el color del carro: ");
                    String color2= scan.next();
                    System.out.print("Ingrese el valor comercial del carro: ");
                    int valor= scan.nextInt();
                    Vehiculo vehiculo = new Carro(placa2,marca2,color2,valor, valorCarros);
                    Sensor.sensores[piso2][espacio2]= new Sensor(1);
                    Vehiculo.vehiculos[piso2][espacio2]=vehiculo;
                    System.out.println(vehiculo.toString());;
                    break;
                }            
             }else if(numClase2 == 2){
                  System.out.print("Ingrese el piso donde desea ubicar la moto: ");
                  int piso2= scan.nextInt()-1;
                  System.out.print("Ingrese el espacio donde desea ubicar la moto: ");
                  int espacio2= scan.nextInt()-1;
                   if((piso2 > pisos)||(espacio2 > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                    break;
                   }
                    else if(Sensor.sensores[piso2][espacio2].getEstado() != 0){
                    System.out.println("Parqueadero ocupado, no se puede ejercer esta acción.");
                    break;
                   }else {
                    System.out.print("Ingrese la placa de la moto: ");
                    String placa2= scan.next();
                    System.out.print("Ingrese la marca de la moto: ");
                    String marca2= scan.next();
                    System.out.print("Ingrese el color de la moto: ");
                    String color2= scan.next();
                    System.out.print("Ingrese el valor comercial de la moto: ");
                    int valor= scan.nextInt();
                    Vehiculo vehiculo = new Moto(placa2,marca2,color2,valor, valorMotos);
                    Sensor.sensores[piso2][espacio2]= new Sensor(1);
                    Vehiculo.vehiculos[piso2][espacio2]=vehiculo;
                    System.out.println(vehiculo.toString());;
                    break;
                }
             }else{
                System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
             }
 
                case 4: 
                System.out.println("La información de los vehiculos ingresados es: "+ "\n" +
                "----------------------------------------------------------------" + "\n" + Vehiculo.toStringVehiculos());
                break;
 
                case 5:
                System.out.println("La cantidad de vehiculos ingresados es: " + Vehiculo.cantidad);
                break;
 
                case 6:
                System.out.println("Ingrese el piso y el espacio del que desea conocer el estado: ");
                System.out.print("Piso: ");
                int piso3= scan.nextInt()-1;                
                System.out.print("Espacio: ");
                int espacio3= scan.nextInt()-1;                
                if((piso3 > pisos)||(espacio3 > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                }else{
                    System.out.println("El estado del sensor es: \n"+ Sensor.sensores[piso3][espacio3].toString());
                }
                break;
 
                case 7:
                System.out.println(Sensor.sensoresEstado());
                break;
 
                default:
                System.out.println("Comando incorrecto");
                break;
 
                case 8:
                System.out.print("Ingrese un color para obtener información de los vehiculos con este: ");
                String color= scan.next();
                System.out.println(Vehiculo.VehiculosColor(color));
                break;
 
                case 9:
 
                System.out.println("A continuación, la información de los vehiculos ordenados segun su valor comercial:");
                System.out.println("---------------------------------------------------------------------");
                System.out.println(Vehiculo.toStringVehiculos(Vehiculo.valorOrdenado()));
                break;
 
                case 10:
                System.out.println("Ingrese el piso y el espacio del que desea retirar el vehiculo: ");
                System.out.print("Piso: ");
                int piso4= scan.nextInt()-1;                
                System.out.print("Espacio: ");
                int espacio4= scan.nextInt()-1;                
                if((piso4 > pisos)||(espacio4 > espacios)){
                    System.out.println("Valores no reconocidos, no se puede ejercer esta acción.");
                }else if(Sensor.sensores[piso4][espacio4].getEstado() == 0){
                    System.out.println("No hay vehiculos en este espacio.");
                }else{
                    System.out.println(Vehiculo.salida(piso4,espacio4));
                }
                break;
 
                case 11:
                PrintStream archivo = new PrintStream("C:\\Users\\ALFONSO FIERRO\\Desktop\\infoVehiculos.txt");
                archivo.print(Vehiculo.toStringVehiculos());
                System.out.print("El archivo se ha exportado correctamente");
                archivo.close();
                break;
          }
            System.out.print(
            "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  0 | ⇒ |  Terminar ejecucion                                                               |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  1 | ⇒ |  Indicar espacios disponibles                                                     |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  2 | ⇒ |  Ingresar PLACA-MARCA-COLOR del vehiculo                                          |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  3 | ⇒ |  Ingresar PLACA-MARCA-COLOR-PRECIO del vehiculo                                   |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  4 | ⇒ |  Mostrar la informacion de los vehiculos ingresados en el sistema                 |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  5 | ⇒ |  Mostrar la cantidad de vehiculos ingresados en el sistema                        |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  6 | ⇒ |  Verificar el estado de un espacio                                                |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  7 | ⇒ |  Mostrar el estado de todos los espacios                                          |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  8 | ⇒ |  Presentar ordenadamente la informacion de los vehiculos con un color determinado |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO  9 | ⇒ |  Presentar la informacion de los vehiculos ordenados por su valor comercial       |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO 10 | ⇒ |  Retirar vehiculo de un espacio determinado                                       |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "| COMANDO 11 | ⇒ |  Exportar fichero con la informacion de los vehiculos ingresados en el sistema    |\n"
            + "†-----------------------------------------------------------------------------------------------------†\n"
            + "Accion: ");            
            num= scan.nextInt();
        } 
        System.out.println("Saliendo...");
    }
}
