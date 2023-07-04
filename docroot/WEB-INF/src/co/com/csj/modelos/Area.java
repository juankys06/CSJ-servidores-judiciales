package co.com.csj.modelos;

public class Area {
	private int id;
	private String nombre;
	
	public Area(int id, String nombre){
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
}
