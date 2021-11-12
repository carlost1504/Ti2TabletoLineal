package model;

public class Player {

	private String id;  
	private int position;
	
	//links
	private Player next;
	private Player prev;

	
	/**
	 * @param id
	 */
	public Player(String id,int position) {
		super();
		this.id = id;
		this.position=position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Player getNext() {
		return next;
	}

	public void setNext(Player next) {
		this.next = next;
	}

	public Player getPrev() {
		return prev;
	}

	public void setPrev(Player prev) {
		this.prev = prev;
	}

	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "[" + id+" "+position + "]";
	}
	
	
	
}
