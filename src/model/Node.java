package model;

import java.util.ArrayList;

public class Node {
	
	//values
		private int id;
		private  ArrayList<Player> p;
		private Elemnnt tipoCelda;
		
		//links
		private Node next;
		private Node prev;

		public Node(int id) {
			this.id = id;
			this.p=new ArrayList<>();
			this.tipoCelda= new Elemnnt();
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
		
		public Elemnnt getTipoCelda() {
			return tipoCelda;
		}

		public void setTipoCelda(Elemnnt tipoCelda) {
			this.tipoCelda = tipoCelda;
		}

		public String PrintlnPlayer() {
			String namePLayers="";
			if(p!=null) {
				for(int i=0;i<p.size();i++) {
					namePLayers=namePLayers+" "+p.get(i).getId();
				}
			}else {
				namePLayers="null";
			}
			return namePLayers;
		}
		
		public String printlnElemnt() {
			String mostrar="";
			if(tipoCelda.getName()==null||tipoCelda.getName().equals("nulo")) {
				mostrar=mostrar+"nulo";
				return mostrar;
			}else {
				mostrar=tipoCelda.getName();
				return mostrar;
			}
		}

		@Override
		public String toString() {
			return "[" + id + ", " + PrintlnPlayer()+ ", "+ printlnElemnt()+ "] ";
		}
		
	
	
}
