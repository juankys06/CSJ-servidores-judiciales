package co.com.csj.modelos;

public class localizacion {
	private String cod_dane;
	private String cod_dane_departamento;
	private String nombre;
	
	public localizacion() {
		
	}
	
	public localizacion(String cod_dane, String cod_dane_departamento,
			String nombre) {
		super();
		this.cod_dane = cod_dane;
		this.cod_dane_departamento = cod_dane_departamento;
		this.nombre = nombre;
	}

	public String getCod_dane() {
		return cod_dane;
	}

	public void setCod_dane(String cod_dane) {
		this.cod_dane = cod_dane;
	}

	public String getCod_dane_departamento() {
		return cod_dane_departamento;
	}

	public void setCod_dane_departamento(String cod_dane_departamento) {
		this.cod_dane_departamento = cod_dane_departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
