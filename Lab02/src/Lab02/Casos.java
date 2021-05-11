package Lab02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Casos extends Enfermedad{

	private String codigo;
	private byte saturacion;
	private float temperatura;
	private String atencion;
	
	Casos(){
		codigo="202101";
		saturacion=0;
		temperatura=(float)0;
		getAtencion();
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String toString (Paciente p, Enfermedad enf) {
        if(enf.getNombre().equalsIgnoreCase("COVID-19")) {
        	enf.setMedicacion("medicacion para covid-19.");
        } else if(enf.getNombre().equalsIgnoreCase("Sarampion")) {
        	enf.setMedicacion("medicacion para sarampion.");
        } else if (enf.getNombre().equalsIgnoreCase("Anemia")) {
        	enf.setMedicacion("mediacacion para anemia.");
        }
		return p.getNombres()+" "+p.getPaterno()+" "+enf.getNombre()+" "+atencion+" "+enf.getMedicacion()+" Temp. "+temperatura+" Saturacion "+saturacion+". "+p.getDomicilio();
	}
}
