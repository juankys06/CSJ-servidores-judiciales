package co.com.csj.modelos;

public class entidad {
	private String nombre;
	private String id;
	
	public entidad() {
	}
	
	public entidad(String nombre, String id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
