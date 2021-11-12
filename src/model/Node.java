package model;

import java.util.ArrayList;

public class Node {
	
	//values
		private int id;
		private  ArrayList<Player> p;
		
		//links
		private Node next;
		private Node prev;

		public Node(int id, ArrayList<Player> p) {
			this.id = id;
			this.p = p;
			p=new ArrayList<>();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public ArrayList<Player> getP() {
			return p;
		}

		public void setP(ArrayList<Player> p) {
			this.p = p;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
		public String PrintlnPlayer() {
			String namePLayers="";
			if(p!=null) {
				for(int i=0;i<p.size();i++) {
					namePLayers=namePLayers+" "+p.get(i).getId();
					System.out.println(namePLayers);
				}
			}else {
				namePLayers="null";
			}
			
			
			return namePLayers;
		}

		@Override
		public String toString() {
			return "[" + id + ", " + PrintlnPlayer() + "] ";
		}
		
	
	
}
