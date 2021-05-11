package Lab02;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Hospital {

    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Paciente> p = new ArrayList<Paciente>();
    public static ArrayList<Enfermedad> e = new ArrayList<Enfermedad>();
    public static ArrayList<Casos> c = new ArrayList<Casos>();
    public static byte num1;
    public static Casos cas;
    
    public static void main(String[]args ) throws IOException{
        
    	do{ 
            menu();
        }
        while(num1<4);
    	
    }
    public static void menu ()  throws IOException{
    	
        System.out.println("******MENÚ PRINCIPAL******" +
                "\n1. PACIENTES." +
                "\n2. ENFERMEDADES." +
                "\n3. CASOS." +
                "\n4. SALIR.");
        System.out.print("Num: ");
            num1 = scan.nextByte();
        switch(num1){
            case 1:
                pacientes();
                break;
            case 2:
                enfermedades();
                break;
            case 3:
                casos();
                break;
            case 4:
            	System.out.println("Fin del Programa.\nDatos guardados.");
            	reporte();
            	generartxt();
                break;
            default:
                System.out.println("Número ingresado incorrecto , intente de nuevo porfavor.");
                menu();
        }
    }
    public static void pacientes () throws IOException{
    	String codigo;
        System.out.println("****PACIENTES****" +
                "\n1. CREAR PACIENTE." +
                "\n2. VER PACIENTES." +
                "\n3. ACTUALIZAR DATOS DE UN PACIENTE." +
                "\n4. ELIMINAR PACIENTE." +
                "\n5. REGRESAR." +
                "\n6. SALIR.");
        System.out.print("Num: ");
        byte c_paciente= scan.nextByte();
        Paciente pac = new Paciente();
        switch(c_paciente){
            case 1:
                registroPaciente(pac);
                p.add(pac);
                System.out.println("Paciente guardado.");
                pacientes();
                break;
            case 2:
                ArrayPacientes();//Imprimir arraylist, to string
                pacientes();
                break;
            case 3://actualizar paciente
                System.out.print("Ingrese Código del Paciente: ");
                codigo=scan.next();
                System.out.println("Ingrese datos actualizados del paciente:");
                registroPaciente(pac);
                for(int i=0; i<p.size(); i++){
                    if(p.get(i).getCodigo().equalsIgnoreCase(codigo)){
                        registroPaciente(pac);
                        p.get(i).setNombres(pac.getNombres());
                        p.get(i).setPaterno(pac.getPaterno());
                        p.get(i).setMaterno(pac.getMaterno());
                        p.get(i).setDni(pac.getDni());
                        p.get(i).setCodigo(pac.getCodigo());
                        p.get(i).setGenero(pac.isGenero());
                        p.get(i).setNacimiento(pac.getNacimiento());
                        p.get(i).setPeso(pac.getPeso()); 
                        p.get(i).setTalla(pac.getTalla());
                        p.get(i).setDomicilio(pac.getDomicilio());
                        p.get(i).setTelefono(pac.getTelefono());
                        }
                }
                System.out.println("Datos del Paciente Actualizados.");
                pacientes();
                break;
            case 4:
                System.out.print("Ingrese Código del Paciente: ");
                codigo=scan.nextLine();
                for (int i = 0; i <p.size();i++) {
                	if(p.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                		p.remove(i) ;
                	}
                }
                System.out.println("Paciente Eliminado.");
                pacientes();
                break;
            case 5:
                System.out.println("Regresando...");
                menu();
                break;
            case 6:
                System.out.println("Fin del Programa.\nDatos guardados.");  //crear Base_de_Datos.txt
                reporte();
                break;
            default:
                System.out.println("Número ingresado incorrecto\n intente de nuevo");
                pacientes();
        }
        
    }
    public static void enfermedades () throws IOException{
    	String nombre;
        System.out.println("****ENFERMEDADES****" +
                "\n1. CREAR ENFERMEDAD." +
                "\n2. VER ENFERMEDADES." +
                "\n3. ACTUALIZAR DATOS DE UNA ENFERMEDAD." +
                "\n4. ELIMINAR ENFERMEDAD." +
                "\n5. REGRESAR." +
                "\n6. SALIR.");
        System.out.print("Num: ");
        byte c_enfermedad = scan.nextByte();
        Enfermedad enf = new Enfermedad();
        switch(c_enfermedad){
            case 1:
            	registroEnfermedad(enf);
                e.add(enf);
                System.out.println("Enfermedad guardada.");
                enfermedades();
                break;
            case 2:
                ArrayEnfermedades();
                enfermedades();
                break;
            case 3:
                System.out.print("Ingrese nombre de la Enfermedad: ");
                nombre=scan.next();
                System.out.println("Ingrese datos actualizados de la Enfermedad:");
                registroEnfermedad(enf);
                for(int i=0; i<e.size(); i++){
                    if(e.get(i).getNombre().equalsIgnoreCase(nombre)){
                        registroEnfermedad(enf);
                        e.get(i).setNombre(enf.getNombre());
                        e.get(i).setMedicacion(enf.getMedicacion());
                        e.get(i).setTiempo(enf.getTiempo());
                        }
                }
                System.out.println("Datos de la Enfermedad Actualizados.");
                enfermedades();
                break;
            case 4:
                System.out.print("Ingrese nombre de la Enfermedad: ");
                nombre=scan.nextLine();
                for (int i = 0; i <p.size();i++) {
                	if(e.get(i).getNombre().equalsIgnoreCase(nombre)) {
                		e.remove(i) ;
                	}
                }
                System.out.println("Enfermedad eliminada.");
                enfermedades();
                break;
            case 5:
                System.out.println("Regresando...");
                menu();
                break;
            case 6:
                System.out.println("Fin del Programa.\nDatos guardados.");  //crear Base_de_Datos.txt
                reporte();
                break;
            default:
                System.out.println("Número ingresado incorrecto, Intente de nuevo");
                enfermedades();
        }
        
    }
    public static void casos () throws IOException{
        String caso;
        System.out.println("****CASOS****" +
                "\n1. CREAR CASO." +
                "\n2. VER CASOS." +
                "\n3. ACTUALIZAR DATOS DE UN CASO." +
                "\n4. ELIMINAR CASO." +
                "\n5. REGRESAR." +
                "\n6. SALIR.");
        System.out.print("Num: ");
        byte c_caso = scan.nextByte();
        
        switch(c_caso){
            case 1:
            	cas = new Casos();
                c.add(registroCasos(cas));
                System.out.println("Caso guardado.");
                casos();
                break;
            case 2:
                ArrayCasos();
                menu();
                break;
            case 3:
                System.out.print("Ingrese codigo de caso: ");
                caso=scan.next();
                System.out.println("Ingrese datos actualizados de la Enfermedad:");
                registroCasos(cas);
                for(int i=0; i<e.size(); i++){
                    if(e.get(i).getNombre().equalsIgnoreCase(caso)){
                        registroCasos(cas);
                        c.get(i).setCodigo(cas.getCodigo());
                        c.get(i).setNombrePaciente(cas.getNombrePaciente());
                        c.get(i).setEnfermedad(cas.getEnfermedad());
                        c.get(i).setSaturacion(cas.getSaturacion());
                        c.get(i).setTemperatura(cas.getTemperatura());
                        }
                }
                System.out.println("Datos del caso Actualizados.");
                casos();
                break;
            case 4:
                System.out.print("Ingrese codigo de caso: ");
                caso=scan.nextLine();
                for (int i = 0; i <p.size();i++) {
                	if(c.get(i).getCodigo().equalsIgnoreCase(caso)) {
                		c.remove(i) ;
                	}
                }
                System.out.println("Caso eliminado.");
                casos();
                break;
            case 5:
                System.out.println("Regresando...");
                menu();
                break;
            case 6:
                System.out.println("Fin del Programa.\nDatos guardados.");  //crear Base_de_Datos.txt
                reporte();
                break;
            default:
                System.out.println("Número ingresado incorrecto, Intente de nuevo");
                casos();
        }
    }
    public static void reporte() {
        ArrayPacientes();
        System.out.println();
        ArrayEnfermedades();
        System.out.println();
        ArrayCasos(); //se repite
    }
    public static void ArrayPacientes(){//imprimir pácientes
    	//ordenar pacientes    
    	System.out.println("PACIENTES:");
    	for(int i = 0; i < p.size(); i++) {
                System.out.println((i+1)+":\t"+p.get(i).toString());
        }
    }
    public static void ArrayEnfermedades(){//imprimir enfermedades
        //ordenar enfermedades    
    	System.out.println("ENFERMEDADES:");
    	for(int i = 0; i < p.size(); i++) {
                System.out.println((i+1)+":\t"+e.get(i).toString());
        }
    }
    public static void ArrayCasos(){//imprimir casos
        //ordenar casos
    	ArrayList<String> nom = new ArrayList<String>();
    	ArrayList<Casos> c2 = new ArrayList<Casos>();
    	
    	for(int i=0; i<c.size(); i++) {
    		nom.add(c.get(i).getNombrePaciente());
    	}
    	
    	Collections.sort(nom);
    	
    	for(int i=0; i<c.size(); i++) {
    		for(int j=0; j<c.size(); j++) {
    			if(nom.get(i).equals(c.get(j).getNombrePaciente())) {
    				c2.add(c.get(j));
    			}
    		}
    	}
    	c = c2;
    	
    	System.out.println("CASOS:");
    	for(int i = 0; i < c.size(); i++) {
                System.out.println((i+1)+":\t"+c.get(i).toString());
        }
    }
    public static void registroPaciente(Paciente pac){
        System.out.print("Nombre: ");
        scan.nextLine();
        pac.setNombres(scan.nextLine());
        System.out.print("Paterno: ");
        pac.setPaterno(scan.nextLine());
        System.out.print("Materno: ");
        pac.setMaterno(scan.nextLine());
        System.out.print("Dni: ");
        pac.setDni(scan.nextLine());
        System.out.print("Domicilio: ");
        pac.setDomicilio(scan.nextLine());
        System.out.print("Codigo: ");
        pac.setCodigo(scan.nextLine());
        
        System.out.print("Genero(H)(M): ");
        String genero=scan.nextLine();
        
        if (genero.equalsIgnoreCase("H")){
        	pac.setGenero(true);
        }
        else if(genero.equalsIgnoreCase("M")){
        	pac.setGenero(false);
        }
        
        System.out.print("Nacimiento: ");
        pac.setNacimiento(scan.nextLine());
        
        System.out.print("Peso: ");
        pac.setPeso(scan.nextFloat());
        System.out.print("Talla: ");
        pac.setTalla(scan.nextFloat());
        System.out.print("Telefono: ");
        scan.nextLine();
        pac.setTelefono(scan.nextLine());
    }
    public static void registroEnfermedad(Enfermedad enf){
    	System.out.print("Nombre: ");
    	scan.nextLine();
    	enf.setNombre(scan.nextLine());
        System.out.print("Medicacion: ");
        enf.setMedicacion(scan.nextLine());
        System.out.print("Tiempo en días: ");
        enf.setTiempo(scan.nextShort());
        System.out.print("Notas: ");
        scan.nextLine();
        enf.setNotas(scan.nextLine());
    }
    public static Casos registroCasos(Casos cas){
    	Casos casR = new Casos();
    	System.out.print("Caso número: ");
    	scan.nextLine();
    	cas.setCodigo(scan.nextLine());
        System.out.print("Nombre del Paciente: ");
        cas.setNombrePaciente(scan.nextLine());
        System.out.print("Enfermedad: ");
        cas.setEnfermedad(scan.nextLine());
        System.out.print("Saturacion de Oxigeno(%): ");
        cas.setSaturacion(scan.nextByte());
        System.out.print("Temperatura: ");
        cas.setTemperatura(scan.nextFloat());
        casR = cas;
        return casR;
    }
    public static void generartxt () throws IOException{
    	File reporte = null;
    	BufferedWriter bw = null;
    	String genero="";
    	reporte = new File ("FP2-P_A_LAB_02_reporte.txt");
    	reporte.createNewFile();
	     	bw = new BufferedWriter(new FileWriter(reporte));
	     	
	     	bw.write("ENFERMEDADES\n");
	     	for(int i=0; i<e.size(); i++) {
	     		bw.write(e.get(i).getNombre()+" ...\n");
	     	}
	     	bw.write("...\n\n");
	     	
	     	bw.write("PACIENTES\n");
	     	for(int i=0; i<p.size(); i++) {
	     		if (p.get(i).isGenero()==true) {genero="Varon";}
		        else if(p.get(i).isGenero()==false) {genero="Mujer";}
	     		bw.write(p.get(i).getNombres()+" "+p.get(i).getPaterno()+"\t"+
	     		        genero+"\t"+p.get(i).getNacimiento()+"\t"+p.get(i).getTelefono()+"\t...\n");
	     	}
	     	bw.write("...\n\n");
	     	bw.write("CASOS\n");
	     	for(int i=0; i<c.size(); i++) {
	     		bw.write(c.get(i).toString()+"\n");
	     	}
	     	bw.write("...\n\n");
	     	bw.close();
	     	Desktop.getDesktop().open(reporte);
    }
}