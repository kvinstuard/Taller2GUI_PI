/*
 * Kevin Stuard Marin C - 1927020 -3743
 * Ruzbellit Rossy Romero Ramirez - 1925456-2711
 * Jenny Alexandra Hernández -1830335 - 3743
 */

package saluduniversidad;

import java.util.ArrayList;

/**
 * @author Kevin Stuard Marin Concha  
 * @author Ruzbellit Rossy Romero Ramirez
 * @author Jenny Alexandra Hernández 
 */
public class SaludUniversidad {

    //arrayList de empleados
    private ArrayList <Empleado> listaEmpleados;
    private ArrayList <Empleado> EmpleadosPrioridadAlta = new ArrayList();
    private ArrayList <Empleado> EmpleadosPrioridadMediaAlta = new ArrayList();
    private ArrayList <Empleado> EmpleadosPrioridadMedia = new ArrayList();
    private ArrayList <Empleado> EmpleadosPrioridadBaja = new ArrayList();
    
    
    //array con los factores de riesgo
    private String [] factoresRiesgo = {"diabetes","hipertension","obesidad","tabaquismo","sedentarismo",
                                    "alcoholismo","drogradiccion","inmunosuprimido","cancer","cardiopatias"};
    //array con programas de prevencion y promocion
    private String [] programasPYP = {"Deteccion cancer de cervix","Hipertension y diabetes","Prenatal","Planificacion familiar",
                                    "Deteccion cancer de seno","Salud oral","Agudeza visual"};
    //array con los factores covid
    private String [] factoresCovid = {"Fiebre, Tos seca, Cansancio, Molestias y dolores, Dolor de garganta, Perdida del sentido del olfato o gusto"
                                    + ", Dificultad para respirar"};
    
    /**
     * Constructor de Empleado
     */
    public SaludUniversidad(){
        listaEmpleados =  new ArrayList();    
    }
    
    /**
     * Añade empleado a la lista de empleados
     * @param empleado que se desea añadir
     */
    public void anhadirEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
    }
    
    /**
     * Obtiene la lista de empleados
     * @return array de lista de empleados
     */
    public ArrayList<Empleado> getListaEmpleados(){
        return listaEmpleados;
    }
    
    /**
     * Funcion que encuentra un Empleado de la lista de empleados
     * @param identificacion del empleado a buscar
     * @return Empleado encontrado
     */
    public Empleado buscarEmpleadoPorId(String identificacion){
        Empleado empleadoEncontrado = null ;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).getIdentificacion().equalsIgnoreCase(identificacion)){
                empleadoEncontrado = listaEmpleados.get(i);
            }
          }
        return empleadoEncontrado;
    }
    
    /**
     * Devuelve un texto con toda la informacion de un empleado
     * @param empleadoEncontrado empleado del que se obtiene la informacion
     * @return String texto de la info del empleado
     */
    public String infoCompletaEmpleado(Empleado empleadoEncontrado){
        String info = "";
        info += "Nombre: " + empleadoEncontrado.getNombre() + "\n" +
                "Identificacion: " + empleadoEncontrado.getIdentificacion() + "\n" +
                "Facultad: " + empleadoEncontrado.getFacultad() + "\n" +
                "Edad: " + empleadoEncontrado.getEdad() + "\n" +
                "Sexo: " + empleadoEncontrado.getSexo() + "\n" +
                "Fecha de nacimiento (DD/MM/AAAA): " + empleadoEncontrado.getFechaDeNacimiento() + "\n" +               
                "Estatura (cm): " + empleadoEncontrado.getEstatura() + "\n" +
                "Peso: " + empleadoEncontrado.getPeso() + "\n"+
                "Enfermedades: " + "\n"+empleadoEncontrado.getCadenaFactoresRiesgo() + "\n" +
                "Sintomas Covid: " +"\n"+ empleadoEncontrado.getCovid() + "\n";
        return info;
    }
    
   /*
    *funcion para determinar el estado de salud de los empleados:
    *el objetivo es generar una serie de puntajes por empleado los que despues seran agrupados
    *en una categoria acorde a este puntaje. ej: empleado 1->puntaje:20 (if.. puntajeSalud > 10 && puntajeSalud< 35 -> Mala salud
    * 
    */
    public void determinarEstadoSalud(){
        
        for (int i = 0; i < listaEmpleados.size(); i++) {
           //Este for chequea si tiene alguna enfermedad preexistente -> asigna puntajes de acuerdo
            for (int j = 0; j < factoresRiesgo.length; j++) {
                
                if(listaEmpleados.get(i).getFactoresRiesgo().contains(factoresRiesgo[j])){  
                   listaEmpleados.get(i).setEstadoSalud(30);
                }
            }
            //Verifica el rango de edad de la persona -> asigna puntajes de acuerdo
            if(listaEmpleados.get(i).getEdad() >= 70){
                listaEmpleados.get(i).setEstadoSalud(listaEmpleados.get(i).getEstadoSalud()+50);
            }
             if(listaEmpleados.get(i).getEdad() >= 40 && listaEmpleados.get(i).getEdad() < 70 ){
                listaEmpleados.get(i).setEstadoSalud(listaEmpleados.get(i).getEstadoSalud()+30);
            }
            if(listaEmpleados.get(i).getEdad() >= 20 && listaEmpleados.get(i).getEdad() < 40 ){
                listaEmpleados.get(i).setEstadoSalud(listaEmpleados.get(i).getEstadoSalud()+10);
            }
            //Los hombre tienen mas probabilidades de morir por la mayoria de enfermedad, incluyendo el covid-19
            if(listaEmpleados.get(i).getSexo().equals("hombre")){
                listaEmpleados.get(i).setEstadoSalud(listaEmpleados.get(i).getEstadoSalud()+15);
                
            }
            //Verifica los diferentes puntajes y almacena los empleados en diferentes arraylist dependiendo su prioridad
            
            if(listaEmpleados.get(i).getEstadoSalud() >= 80){
                EmpleadosPrioridadAlta.add(listaEmpleados.get(i));  
            }
            
            if(listaEmpleados.get(i).getEstadoSalud() >= 60 && listaEmpleados.get(i).getEstadoSalud() < 80){
                EmpleadosPrioridadMediaAlta.add(listaEmpleados.get(i));
            }
            
            if(listaEmpleados.get(i).getEstadoSalud() >= 35 && listaEmpleados.get(i).getEstadoSalud() < 60){
                EmpleadosPrioridadMedia.add(listaEmpleados.get(i));
            }
            
            if(listaEmpleados.get(i).getEstadoSalud() >= 0 && listaEmpleados.get(i).getEstadoSalud() < 35){
                EmpleadosPrioridadBaja.add(listaEmpleados.get(i));
            }
              
        }     
        
    }
    
    /**
     * Funcion que reinicia la lista de prioridades de empleados
     */
    public void reiniciarEstadoSalud(){
        EmpleadosPrioridadAlta.clear();
        EmpleadosPrioridadMediaAlta.clear();
        EmpleadosPrioridadMedia.clear();
        EmpleadosPrioridadBaja.clear();
    }
    
    /**
     * Funcion que recomienda programas PYP segun los grupos de cada prioridad
     * @return texto con los programs de PYP para empleados
     */
    public String recomendarProgramasPYP(){
        
        String text = "";
        
        for (int i = 0; i < EmpleadosPrioridadAlta.size(); i++) {
            //mayores de 70 años, con enfermedades preexistentes, pueden ser hombres
            text += "Empleado: "+EmpleadosPrioridadAlta.get(i).getNombre()+"\n";
            text += "PROGRAMAS DE PREVENCION Y PROMOCION RECOMENDADOS:\n"+"-"+programasPYP[1]+"\n"+"-"+programasPYP[5]+
                              "\n"+"-"+programasPYP[6]+"\n--------------------------\n";  
        }
        
        for (int i = 0; i < EmpleadosPrioridadMediaAlta.size(); i++) {
            //entre 40 y 60, enfermedades preexistentes, pueden ser hombres.
            text += "Empleado: "+EmpleadosPrioridadMediaAlta.get(i).getNombre()+"\n";
            
            if(EmpleadosPrioridadMediaAlta.get(i).getSexo().equals("hombre")){
            text += "PROGRAMAS DE PREVENCION Y PROMOCION RECOMENDADOS:\n"+"-"+programasPYP[1]+
                               "\n"+"-"+programasPYP[5]+"\n"+"-"+programasPYP[6]+"\n--------------------------\n";
            }else{
            text += "PROGRAMAS DE PREVENCION Y PROMOCION RECOMENDADOS:\n"+"-"+programasPYP[0]+"\n"+"-"+programasPYP[1]+
                              "\n"+"-"+programasPYP[4]+"\n"+"-"+programasPYP[5]+"\n"+"-"+programasPYP[6]+"\n--------------------------\n";
                
            } 
        }
        
        for (int i = 0; i < EmpleadosPrioridadMedia.size(); i++) {
            //personas con enfermedades preexistente entr 20 y 40
            text += "Empleado: "+EmpleadosPrioridadMedia.get(i).getNombre()+"\n";
            if(EmpleadosPrioridadMedia.get(i).getSexo().equals("hombre")){
            text += "PROGRAMAS DE PREVENCION Y PROMOCION RECOMENDADOS:\n"+"-"+programasPYP[1]+"\n"+"-"+programasPYP[3]+"\n"+"-"+programasPYP[5]+
                    "\n"+"-"+programasPYP[6]+"\n--------------------------\n";  
            }else{
            text += "PROGRAMAS DE PREVENCION Y PROMOCION RECOMENDADOS:\n"+"-"+programasPYP[0]+"\n"+"-"+programasPYP[1]+"\n"+"-"+programasPYP[2]+
                            "\n"+"-"+programasPYP[3]+"\n"+"-"+programasPYP[5]+"\n"+"-"+programasPYP[6]+"\n--------------------------\n";  
            }
        }
        
        for (int i = 0; i < EmpleadosPrioridadBaja.size(); i++) {
            //hombres o mujeres sanos.
            text += "Empleado: "+EmpleadosPrioridadBaja.get(i).getNombre()+"\n";
            
            if(EmpleadosPrioridadBaja.get(i).getSexo().equals("hombre")){
            text += "PROGRAMAS DE PREVENCION Y PROMOCION RECOMENDADOS:"+"\n"+"-"+programasPYP[1]+
                              "\n"+"-"+programasPYP[3]+"\n"+"-"+programasPYP[5]+"\n"+"-"+programasPYP[6]+"\n--------------------------\n";
            }else{
            text += "PROGRAMAS DE PREVENCION Y PROMOCION RECOMENDADOS:"+"\n"+"-"+programasPYP[0]+"\n"+"-"+programasPYP[1]+
                              "\n"+"-"+programasPYP[2]+"\n"+"-"+programasPYP[3]+"\n"+"-"+programasPYP[5]+"\n"+"-"+programasPYP[6]+"\n--------------------------\n";
                
            }
        }
        return text;
    }
    
    /**
     * Funcion que genera una prioridad de vacunacion
     * @return texto diciendo los empleados con mayor prioridad
     */
    public String generarPrioridadVacunacion(){
        
        String aux = " "; 
        
        if(EmpleadosPrioridadAlta.isEmpty() != true){
            aux += "\nLos empleados con mayor prioridad son: ";
            for (int i = 0; i < EmpleadosPrioridadAlta.size(); i++) {
            
             aux += "\n-------------------------\n" + "Empleado #"+(i+1)
                                +"\nNombre: "+EmpleadosPrioridadAlta.get(i).getNombre()
                                +"\nIdentificacion: "+EmpleadosPrioridadAlta.get(i).getIdentificacion();
            }
        }
        
        if(EmpleadosPrioridadMediaAlta.isEmpty() != true){
            aux += "\nLos empleados con prioridad media alta son: ";
            for (int i = 0; i < EmpleadosPrioridadMediaAlta.size(); i++) {
              aux += "\n--------------------------\n" + "Empleado #"+(i+1)
                                +"\nNombre: "+EmpleadosPrioridadMediaAlta.get(i).getNombre()
                                +"\nIdentificacion: "+EmpleadosPrioridadMediaAlta.get(i).getIdentificacion();
            }
        }
        
        if(EmpleadosPrioridadMedia.isEmpty() != true){
            aux += "\nLos empleados con prioridad media son: ";
            for (int i = 0; i < EmpleadosPrioridadMedia.size(); i++) {
              aux += "\n--------------------------\n" + "Empleado #"+(i+1)
                                +"\nNombre: "+EmpleadosPrioridadMedia.get(i).getNombre()
                                +"\nIdentificacion: "+EmpleadosPrioridadMedia.get(i).getIdentificacion();
           }
        }
        
        if(EmpleadosPrioridadBaja.isEmpty() != true){
           aux += "\nLos empleados con menor prioridad son: ";
           for (int i = 0; i < EmpleadosPrioridadBaja.size(); i++) {
              aux += "\n--------------------------\n" + "Empleado #"+(i+1)
                                +"\nNombre: "+EmpleadosPrioridadBaja.get(i).getNombre()
                                +"\nIdentificacion: "+EmpleadosPrioridadBaja.get(i).getIdentificacion();
           }
        }
        return aux;
    }
    
    /**
     * Funcion auxiliar para mostrar informacion de los empleados por prioridad
     * @param prioridad empleado 
     * @return texto con info basica del empleado
     */
    public String empleadosPorPrioridad(ArrayList<Empleado> prioridad){
        String aux = "los empleados son: \n";
         for (int i = 0; i < prioridad.size(); i++) {
            aux += "nombre: " + prioridad.get(i).getNombre() + " -" +" Identificacion: "+ prioridad.get(i).getIdentificacion() 
                    + "\n";
         }
         return aux;
    }
    
    /**
     * Genera estadisticas en general de los empleados
     * @return String de cuantos y como se encuentran los empleados 
     */
    public String generarEstadisticasGenerales(){
       
        String estadisticaGeneral = "En general en la universidad del valle: \n";
        estadisticaGeneral += "se encuentran: " + EmpleadosPrioridadAlta.size() + " empleados en prioridad alta\n"
                + empleadosPorPrioridad(EmpleadosPrioridadAlta)
                + "se encuentran: " + EmpleadosPrioridadMediaAlta.size() + " empleados en prioridad media alta\n"
                + empleadosPorPrioridad(EmpleadosPrioridadMediaAlta)
                + "se encuentran: " + EmpleadosPrioridadMedia.size() + " empleados en prioridad media\n"
                + empleadosPorPrioridad(EmpleadosPrioridadMedia)
                + "se encuentran: " + EmpleadosPrioridadBaja.size() + " empleados en prioridad baja\n"
                + empleadosPorPrioridad(EmpleadosPrioridadBaja);
        return estadisticaGeneral;
    }
    
    /**
     * Genera estadisticas por facultad, dice como se encuentran los empleados y la cantidad
     * @param cualFacultad facultad que se quiere investigar
     * @return informe de como se encuentran los empleados de esa facultad
     */
    public String generarEstadisticasPorFacultad(String cualFacultad) {
        
        int contadorAlta = 0;
        String pAltaEmpl = "";
        for (int i = 0; i < EmpleadosPrioridadAlta.size(); i++) {
           if(EmpleadosPrioridadAlta.get(i).getFacultad().equalsIgnoreCase(cualFacultad)){
               contadorAlta += 1;
               pAltaEmpl += "nombre: " + EmpleadosPrioridadAlta.get(i).getNombre() + "\n" +
                       " Identificacion: "+ EmpleadosPrioridadAlta.get(i).getIdentificacion() + "\n";
               
           }
        }
        String pAlta = "Se encuentran " + contadorAlta + " Empleados en condicion Alta\n";
        if(EmpleadosPrioridadAlta.isEmpty() == false){
            pAlta += "los cuales son:\n" + pAltaEmpl;
        }
        
        int contadorMAlta = 0;
        String pMAltaEmpl = "";
        for (int i = 0; i < EmpleadosPrioridadMediaAlta.size(); i++) {
           if(EmpleadosPrioridadMediaAlta.get(i).getFacultad().equalsIgnoreCase(cualFacultad)){
               contadorMAlta += 1;
               pMAltaEmpl += "nombre: " + EmpleadosPrioridadMediaAlta.get(i).getNombre() + "\n" +
                       " Identificacion: "+ EmpleadosPrioridadMediaAlta.get(i).getIdentificacion() + "\n";
               
           }
        }
        String pMAlta = "Se encuentran " + contadorMAlta + " Empleados en condicion Media Alta\n";
        if(EmpleadosPrioridadMediaAlta.isEmpty() == false){
            pMAlta += "los cuales son:\n" + pMAltaEmpl;
        }
        
        int contadorMedia = 0;
        String pMediaEmpl = "";
        for (int i = 0; i < EmpleadosPrioridadMedia.size(); i++) {
           if(EmpleadosPrioridadMedia.get(i).getFacultad().equalsIgnoreCase(cualFacultad)){
               contadorMedia += 1;
               pMediaEmpl += "nombre: " + EmpleadosPrioridadMedia.get(i).getNombre() + "\n" +
                       " Identificacion: "+ EmpleadosPrioridadMedia.get(i).getIdentificacion() + "\n";
               
           }
        }
        String pMedia = "Se encuentran " + contadorMedia + " Empleados en condicion Media\n";
        if(EmpleadosPrioridadMedia.isEmpty() == false){
            pMedia += "los cuales son:\n" + pMediaEmpl;
        }
        
        int contadorBaja = 0;
        String pBajaEmpl = "";
        for (int i = 0; i < EmpleadosPrioridadBaja.size(); i++) {
           if(EmpleadosPrioridadBaja.get(i).getFacultad().equalsIgnoreCase(cualFacultad)){
               contadorBaja += 1;
               pBajaEmpl += "nombre: " + EmpleadosPrioridadBaja.get(i).getNombre() + "\n" +
                       " Identificacion: "+ EmpleadosPrioridadBaja.get(i).getIdentificacion() + "\n";
           }
        }
        String pBaja = "Se encuentran " + contadorBaja + " Empleados en condicion Baja\n" ;
        if(EmpleadosPrioridadBaja.isEmpty() == false){
            pBaja += "los cuales son:\n" + pBajaEmpl;
        }
        
        return "En la facultad " + cualFacultad + " de la universidad del valle: \n"
                + pAlta + pMAlta + pMedia + pBaja;
    }
    
    /**
     * Genera estadisticas por facultad, dice como se encuentran los empleados y la cantidad
     * @param otroEmpleado empleado al cual se le quieren agregar sintomas de covid
     * @return String con recomendaciones de salud
     */
    
    public String agregarSintomasCovid(Empleado otroEmpleado){
        
        String text = "";
     
        if(otroEmpleado.getArrayCovid().isEmpty() == false){
            text +="Se recomienda que el empleado " + otroEmpleado.getNombre() + " se aisle de forma preventiva durante 14 dias\n"
                 + " Comuniquese en Bogotá: +57(1) 330 5041\n | Celular: 192 |\n Resto del país: 018000955590";
        }
        return text;
    }
    
}