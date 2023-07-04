package co.com.csj.modelos;

public class despacho {
	
	private String codigo;
	private String nombre;
	private int area;
	private String fecha;
	
	public despacho() {
	}
	
	public despacho(String codigo, String nombre, int area, String fecha) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.area = area;
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public int getArea(){
		return area;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setArea(int area){
		this.area = area;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
