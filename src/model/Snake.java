package model;

public class Snake {

	private String name;
	private int tipo;
	/**
	 * @param name
	 * @param tipo
	 */
	public Snake(String name, int tipo) {
		super();
		this.name = name;
		this.tipo = tipo;
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
	
	
}
