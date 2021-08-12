public class Sensor
{
   public static Sensor[][] sensores;
   private int estado;
   public Sensor(){
   }
   public Sensor(int e){
       this.estado=e;
   }
   public int getEstado(){
        return estado;
   }
   public void setEstado(int e){
        this.estado=e;
   }
   public String toString(){
       String info="";
       if(this.getEstado()==1){
           info="Estado: Ocupado";
       }else{
           info="Estado: Libre";
       }
       return info;
   }
   public static String sensorLibre(){
       String libre="";
       for(int i=0; i<sensores.length; i++){
           for(int j=0; j<sensores[i].length; j++){
               if(Sensor.sensores[i][j].getEstado() == 0){
                   libre+= "Libre --> piso: "+ (i+1) + " espacio: " + (j+1) + "\n";   
               }
          }
       }
       if(libre == ""){
           libre+= "No hay espacios disponibles en el parqueadero." + "\n";   
       }
       return libre;
   }
   public static String sensoresEstado(){
        String sen;
        String info="";
        for(int i=0; i<sensores.length; i++){
            for(int j=0; j<sensores[i].length; j++){
                if(sensores[i][j].getEstado() == 0){
                    sen="Libre";
                    info+= sen + "--> piso: "+ (i+1) + " espacio:" + (j+1) + "\n";   
                }else if(sensores[i][j].getEstado() != 0){
                    sen="Ocupado";
                    info+= sen + "--> piso: "+ (i+1) + " espacio:" + (j+1) + "\n";   
                }
            }
        }
        return info;
    }
}
