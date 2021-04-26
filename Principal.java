/*
 * Kevin Stuard Marin C - 1927020 -3743
 * Ruzbellit Rossy Romero Ramirez - 1925456-2711
 * Jenny Alexandra Hernán9dez -1830335 - 3743
 */

package saluduniversidad;

import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Kevin Stuard Marin Concha  
 * @author Ruzbellit Rossy Romero Ramirez
 * @author Jenny Alexandra Hernández 
 */
public class Principal {
    
     public static void main(String[] args) {
       
        
        SaludUniversidad director = new SaludUniversidad();
         
        //Pruebas..
        
        ArrayList<String> e1Enfermedades = new ArrayList();
        e1Enfermedades.add("cancer");
        ArrayList<String> e2Enfermedades = new ArrayList();
        e2Enfermedades.add("cancer");
        e2Enfermedades.add("obesidad");
        ArrayList<String> e3Enfermedades = new ArrayList();
        e3Enfermedades.add("diabetes");
        e3Enfermedades.add("drogadiccion");
        ArrayList<String> e4Enfermedades = new ArrayList();
        e4Enfermedades.add("alcoholismo");
        
        Empleado e1 = new Empleado("Pepito", "hombre","12345","01/04/1985", "Ingenieria", 165, 59, e1Enfermedades );
        Empleado e2 = new Empleado("Juanita", "mujer","13132","27/09/1950", "Salud",200, 30, e2Enfermedades);
        Empleado e3 = new Empleado("vero",  "mujer","110709","dd/mm/1985", "Salud",170, 60, e3Enfermedades);
        Empleado e4 = new Empleado("Juan",  "hombre","148753","dd/mm/1940", "Ingenieria", 130, 54, e4Enfermedades);
       
        ArrayList<String> e4covid = new ArrayList();
        e4covid.add("Fiebre");
        director.anhadirEmpleado(e1); 
        e1.setCovid(e4covid);
        director.anhadirEmpleado(e2); 
        director.anhadirEmpleado(e3); 
        director.anhadirEmpleado(e4); 
               
        
        int opcion; //Guardaremos la opcion del usuario
        boolean salir = false;
        while(!salir){
            
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de la opcion que deseas elegir\n" +
                                             "1. Añadir Empleado y datos adicionales \n" +
                                             "2. Añadir un factor de riesgo a un empleado \n" +
                                             "3. Mostrar Informacion completa de un empleado \n" + 
                                             "4. recomendar programas pyp segun estado de salud\n" +
                                             "5. Generar listado de prioridad de vacunacion\n" +
                                             "6. Mostrar estadisticas en general\n" +
                                             "7. Mostrar estadisticas por Facultad\n" +
                                             "8. Agregar sintomas asociados al covid 19\n" +
                                             "9. Salir")); 
            
           switch(opcion){
               case 1:
                   JOptionPane.showMessageDialog(null, "Has seleccionado la opcion 1\n ***Añadir Empleado***");
                   String nombre = JOptionPane.showInputDialog("Digite el nombre del empleado");
                   
                   String sexo = JOptionPane.showInputDialog("Digite el sexo del empleado (¨Mujer¨ si es femenino y ¨hombre¨ si es masculino)");
                   String identificacion = JOptionPane.showInputDialog("Digite la identificacion del empleado");
                   String fechaNacimiento = JOptionPane.showInputDialog("Digite la fecha de nacimiento del empleado (DD/MM/AAAA)");
                   String facultad = JOptionPane.showInputDialog("Digite la facultad a la que pertenece el empleado\n" +
                                                                 "(Ingenieria - Salud - Humanidades - Artes Integradas - Ciencias Naturales y Exactas) ");
                   int estaturaEmp = 0;
                   do{
                   try {
                       estaturaEmp = Integer.parseInt(JOptionPane.showInputDialog("Digite la estatura del empleado (cm)"));
                   } catch(NumberFormatException ae) {
                    JOptionPane.showMessageDialog(null, "Digite la estatura en numeros");
                   }} while (estaturaEmp == 0);
                   int pesoEmp = 0;
                   do{
                   try {
                       pesoEmp = Integer.parseInt(JOptionPane.showInputDialog("Digite la peso del empleado"));
                   } catch(NumberFormatException ae) {
                    JOptionPane.showMessageDialog(null, "Digite el peso en numeros");
                   }} while (pesoEmp == 0);
                   String factoresRiesgo = JOptionPane.showInputDialog("¿Escriba cuales de las siguientes enfermedades padece el empleado:\n"
                                                                  + "diabetes, hipertension, obesidad, desnutricion, alcoholismo,\n"
                                                                  + " drogradiccion, inmunosuprimido, cardiopatias, cancer\n"
                                                                  + "(liste separando con comas)");
                   ArrayList<String> factRiesgoEmpleado = new ArrayList();
                   factRiesgoEmpleado.addAll(Arrays.asList(factoresRiesgo.split(", ")));
                   
                   Empleado empleado = new Empleado(nombre, sexo, identificacion,fechaNacimiento, facultad, estaturaEmp, pesoEmp, factRiesgoEmpleado);
                   director.anhadirEmpleado(empleado);
                  
                   JOptionPane.showMessageDialog(null, "Se ha guardado el empleado con exito");
                   break;
                case 2:
                   JOptionPane.showMessageDialog(null, "Has seleccionado la opcion 2\n " +
                           "***Añadir un factor de riesgo a un empleado***");
                   String identificacionEmplea = JOptionPane.showInputDialog("Digite la identificacion del empleado");
                   String factorAnhadirEmplea = JOptionPane.showInputDialog("Digite el factor de riesgo que desea añadir \n"
                                                                            + "(diabetes, hipertension, obesidad, desnutricion, alcoholismo," 
                                                                            + " \n drogradiccion, inmunosuprimido, cardiopatias, cancer)\n");
                   try {
                        Empleado emple = director.buscarEmpleadoPorId(identificacionEmplea);
                        emple.setFactoresRiesgo(factorAnhadirEmplea);
                        JOptionPane.showMessageDialog(null, "Factor de riesgo añadido con exito");   
                   } catch(NullPointerException ae) {
                    JOptionPane.showMessageDialog(null, "No se encontro el empleado...");
                   }
                   break;
                case 3:
                   JOptionPane.showMessageDialog(null, "Has seleccionado la opcion 3\n " +
                           "***Mostrar Informacion completa de un empleado***");
                   String identificacionEmpl = JOptionPane.showInputDialog("Digite la identificacion del empleado");
                   
                   try {
                        Empleado emple = director.buscarEmpleadoPorId(identificacionEmpl);
                        JOptionPane.showMessageDialog(null, director.infoCompletaEmpleado(emple));   
                   } catch(NullPointerException ae) {
                    JOptionPane.showMessageDialog(null, "No se encontro el empleado...");
                   }
                   break;
                case 4:
                   JOptionPane.showMessageDialog(null, "Has seleccionado la opcion 4\n " +
                           "***recomendar programas pyp segun estado de salud***");
                   director.determinarEstadoSalud();
                   JOptionPane.showMessageDialog(null, director.recomendarProgramasPYP());
                   director.reiniciarEstadoSalud();
                   break;
                case 5:
                   JOptionPane.showMessageDialog(null, "Has seleccionado la opcion 5\n " +
                           "***Generar listado de prioridad de vacunacion***");
                   director.determinarEstadoSalud();
                   JOptionPane.showMessageDialog(null, director.generarPrioridadVacunacion());
                   director.reiniciarEstadoSalud();
                   break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Has seleccionado la opcion 6\n " +
                            "***Mostrar estadisticas en general***");
                    director.determinarEstadoSalud();
                    JOptionPane.showMessageDialog(null, director.generarEstadisticasGenerales()); 
                    director.reiniciarEstadoSalud();
                   break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Has seleccionado la opcion 7\n " +
                            "***Mostrar estadisticas por Facultad***");
                    String cualFac = JOptionPane.showInputDialog("Digite la facultad a la que pertenece el empleado\n" +
                                                                 "(Ingenieria - Salud - Humanidades - Artes Integradas - Ciencias Naturales y Exactas) ");
                    director.determinarEstadoSalud();
                    JOptionPane.showMessageDialog(null, director.generarEstadisticasPorFacultad(cualFac));
                    director.reiniciarEstadoSalud();
                   break;
                case 8:
                   JOptionPane.showMessageDialog(null, "Has seleccionado la opcion 8\n " +
                           "***Agregar sintomas asociados al covid 19***");
                   String identificacionEmp = JOptionPane.showInputDialog("Digite la identificacion del empleado");
                   
                   try {
                        Empleado emple = director.buscarEmpleadoPorId(identificacionEmp);
                        
                        String covid = JOptionPane.showInputDialog("Escriba cuales de las siguientes sintomas padece el empleado:\n"
                                                                  + "Fiebre, Tos seca, Cansancio, Molestias y dolores, Dolor de garganta,"
                                                                  + " Perdida del sentido del olfato o gusto" +
                                                                    ", Dificultad para respirar");
                         ArrayList<String> sintomas = new ArrayList();
                        sintomas.addAll(Arrays.asList(covid.split(", ")));
                        
                        emple.setCovid(sintomas);
                        JOptionPane.showMessageDialog(null, director.agregarSintomasCovid(emple));   
                        
                   } catch(NullPointerException ae) {
                    JOptionPane.showMessageDialog(null, "No se encontro el empleado...");
                   }
                   break;
                case 9:
                   salir=true;
                   break;
                default:
                   System.out.println("Solo números entre 1 y 9");
                        }
            
            }  
    }

}