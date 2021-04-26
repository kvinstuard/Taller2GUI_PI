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
public class Empleado {
    
    private String nombre;
    private int edad;
    private String sexo; 
    private String identificacion;
    private String fechaDeNacimiento; //en formato DD/MM/AAAA
    private String facultad;
    private ArrayList <String> covid = new ArrayList();
    private ArrayList <String> factoresRiesgo = new ArrayList(); 
    private int estatura;
    private int peso;
    private int estadoSalud;
    
    
    /**
     * Constructor de Empleado
     */
    public Empleado(String nombre, String sexo, String identificacion, String fechaDeNacimiento, String facultad,int estatura, int peso, ArrayList<String> factoresRiesgo){  
        this.nombre = nombre;
        this.sexo = sexo;
        this.identificacion = identificacion;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.facultad = facultad;
        this.estatura = estatura;
        this.peso = peso;
        this.factoresRiesgo = factoresRiesgo;
    }
    
    
    /**
     * Obtiene el nombre del empleado
     * @return String nombre del empleado
     **/
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Obtiene el sexo del empleado
     * @return String si es hombre o mujer
     */
    public String getSexo(){
        return sexo;
    }

    /**
     * Obtiene la identificacion del empleado
     * @return String numero de identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Obtiene la fecha de nacimiento del empleado
     * @return String con la fecha de nacimiento
     */
    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    
    /**
     * Obtiene la facultad del empleado
     * @return String la facultad a la que pertenece el empleado
     */
    public String getFacultad(){
        return facultad;
    }

    /**
     * Obtiene una lista con los factores de riesgo del empleado
     * @return ArrayList<String> con los factores de riesgo
     */
    public ArrayList<String> getFactoresRiesgo() {
        return factoresRiesgo;
    }
    
    /**
     * Obtiene un texto con los factores de riesgo del empleado
     * @return String con los factores de riesgo del empleado
     */
    public String getCadenaFactoresRiesgo() {
        String losFactRiesgo = "";
        for (int i = 0; i < factoresRiesgo.size(); i++) {
            losFactRiesgo += factoresRiesgo.get(i) + "\n";
        }
        return losFactRiesgo;
    }

    /**
     * Agrega los factores de riesgo del empleado
     * @param String con el factor de riesgo
     */
    public void setFactoresRiesgo(String factoresRiesgo) {
        this.factoresRiesgo.add(factoresRiesgo) ;
    }
    
    /**
     * Obtiene la estatura del empleado
     * @return int estatura del empleado  
     */
    public int getEstatura() {
        return estatura;
    }

    /**
     * Obtiene el peso del empleado
     * @return int peso empleado
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Obtiene estado de salud del empleado
     * @return int con el estado de salud del empleado
     */
    public int getEstadoSalud() {
        return estadoSalud;
    }

    /**
     * Agrega estado de salud al empleado
     * @param estadoSalud 
     */
    public void setEstadoSalud(int estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
    
    /**
     * Obtiene la edad del empleado 
     * @return int edad del empleado
     */
    public int getEdad(){
        int fecha;
        fecha = Integer.parseInt(this.fechaDeNacimiento.substring(6));
        edad = 2021 - fecha;
        return edad;
    }
    
    /**
     * Agrega sintomas de covid-19 
     * @param covid
     */

    public void setCovid(ArrayList<String> covid) {
        this.covid = covid;
    }
  
    /**
     * Obtiene los sintomas covid del empleado en un String
     * @return String los covid
     */
      
    public String getCovid() {
        String losCovid = "";
        for (int i = 0; i < covid.size(); i++) {
            losCovid += covid.get(i) + "\n";
        }
        return losCovid;
    }
    /**
     * Retorn los sintomas covid del empleado en un Arraylist 
     * @return String los covid
     */
    
   public ArrayList<String> getArrayCovid() {
       return covid;
   }
}
