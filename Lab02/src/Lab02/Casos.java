package Lab02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Casos {

	private String codigo;
	private String nombrePaciente;
	private String enfermedad;
	private byte saturacion;
	private float temperatura;
	private String atencion;
	private String domicilio;
	
	Casos(){
		codigo="0";
		nombrePaciente="anonimo";
		enfermedad="sin emfermedad";
		saturacion=0;
		temperatura=(float)0;
		atencion="sin fecha";
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	
	public byte getSaturacion() {
		return saturacion;
	}

	public void setSaturacion(byte saturacion) {
		this.saturacion = saturacion;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public Float getTemperatura() {
		return temperatura;
	}
	public String getAtencion() {
		Date hoy = new Date();
        String stringDia = "dd/MM/yyyy hh: mm a";
        SimpleDateFormat diaDate = new SimpleDateFormat(stringDia);
		atencion = ""+diaDate.format(hoy);
		return atencion;
	}
	
	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String toString () {
		String medicacion="";
        if(enfermedad.equalsIgnoreCase("COVID-19")) {
        	medicacion = "medicacion para covid-19.";
        } else if(enfermedad.equalsIgnoreCase("Sarampion")) {
        	medicacion = "medicacion para sarampion.";
        } else if (enfermedad.equalsIgnoreCase("Anemia")) {
        	medicacion = "mediacacion para anemia.";
        }
		return nombrePaciente+" "+enfermedad+" "+atencion+" "+medicacion+" Temp. "+temperatura+" Saturacion "+saturacion+". "+domicilio;
	}
}
