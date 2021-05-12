package Lab02;

public class Paciente {
	
	private String nombres;
	private String paterno;
	private String materno;
	private String dni;
	private String codigo;
	private boolean genero;
	private String nacimiento;
	private float peso;
	private float talla;
	private String domicilio;
	private String telefono;
	
	Paciente(){
		nombres="anonimo";
		paterno="sin Apellido Paterno";
		materno="sin Apellido Materno";
		dni="sin DNI";
		codigo="sin código";
		nacimiento="";
		peso=(float) 0;
		talla=(float) 0;
		domicilio="sin domicilio";
		telefono="sin telefono";
	}
	
	public String getNombres(){
		return nombres;
	}	
	public void setNombres(String nombres){
		this.nombres = nombres;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		if (genero.equalsIgnoreCase("H")){
        	this.genero=true;
        }
        else if(genero.equalsIgnoreCase("M")){
        	this.genero=false;
        }
	}	
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public Float getTalla() {
		return talla;
	}
	public void setTalla(Float talla) {
		this.talla = talla;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String toString () {
		String gen;
		if(genero == true) { gen ="Varon";} else {gen = "Mujer";}
		return nombres+" "+paterno+" "+materno+" "+
				gen+" "+nacimiento+" "+telefono+" "+peso+" "+talla+
				" "+domicilio;
	}
}
