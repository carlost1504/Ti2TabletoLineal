package model;

public class Elemnnt {

	private String name;
	private int tipo;
	private String clase;
	/**
	 * @param name
	 * @param tipo
	 * @param clase
	 */
	public Elemnnt(String name, int tipo, String clase) {
		super();
		this.name = name;
		this.tipo = tipo;
		this.clase = clase;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	
	
	
}
