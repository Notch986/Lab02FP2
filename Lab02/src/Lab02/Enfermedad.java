package Lab02;

public class Enfermedad {

	private String nombre;
	private short tiempo;
	private String medicacion;
	private String notas;
	
	Enfermedad(){
		nombre="sin enfermedades";
		tiempo=0;
		medicacion="sin medicación";
		notas="sin notas";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public short getTiempo() {
		return tiempo;
	}
	public void setTiempo(short tiempo) {
		this.tiempo = tiempo;
	}
	public String getMedicacion() {
		return medicacion;
	}
	public void setMedicacion(String medicacion) {
		this.medicacion = medicacion;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	public String toString () {
		return nombre+"\t"+medicacion+"\t"+tiempo+"días\t"+
				notas;
	}
}
