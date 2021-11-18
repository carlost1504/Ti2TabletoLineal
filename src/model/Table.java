package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import exception.TableSizeValidation;
import exception.ValidationFormtPlayer;

public class Table {
	
	private Node first;
	private Node last;
	private Player firstPlayer;
	private Player lastPlayer;
	
	private int n, m;
	private String player;
	
	public Table() {
		
	}
	
	public Table(int n, int m,String player) {
		this.n = n;
		this.m = m;
		this.player=player;
	}
	
	public void initTable()throws TableSizeValidation {
		int numTabla=n*m;
		int validationSize=4*4;
		int i=0;
		if (numTabla>validationSize) {
			createTable(numTabla, i);
		}else {
			throw new TableSizeValidation(n, m);
		}
	}
	
	public void init() throws ValidationFormtPlayer {
		int i=0;
		String[] campoPlayer=player.split("");
		validationPlayer( campoPlayer,i);
		int contPlayer=campoPlayer.length;
		for(int x=0;x<campoPlayer.length;x++) {
			System.out.println(campoPlayer[x]);
		}
		createPlayer( campoPlayer, contPlayer, i);
		
		Player pyTempo=firstPlayer;
		System.out.println("\n");
		playerPrintLn( pyTempo );
		Player nodePlayer=firstPlayer;
		Node nodeTable=first;
		asignNum(nodePlayer);
		asigPlayerToTable( nodePlayer,  nodeTable);
	}
	
	/* ValidationPlayer
	 * el metodo mira si al entrar la cadena de caracteres esta presente elguno espacio;
	 * si es asi mandara una excetion para poderlo corregir;
	 * String[] campoPlayer=Arraylist de jugadores;
	 * int i=contador para poder ser recursivo;
	 */
	public void validationPlayer(String[] campoPlayer,int i) throws ValidationFormtPlayer {
		if(campoPlayer.length>i) {
			if(campoPlayer[i]==" ") {
				throw new ValidationFormtPlayer(player);
			}else {
				validationPlayer( campoPlayer,i+1);
			}
		}
	}
	
	public void asignNum(Player nodePlayer) {
		if(nodePlayer!=null) {
			nodePlayer.setPosition(1);
			nodePlayer=nodePlayer.getNext();
		}
	}
	
	/* Create a new player 
	 * <b> Pre: 
	 *  @Param playerNames
	 *  @Param playersAmount
	 *  @Param j counter  
	 *  </b>
	 */
	
	public void createPlayer(String[] playerNames,int playersAmount,int j) {
		if(playersAmount>0) {
			Player nodePlayer = new Player(playerNames[j],1);
			playerPos(nodePlayer);
			createPlayer(playerNames, playersAmount-1, j+1);
			//System.out.print(nodePlayer.toString());
			//System.out.println(playersAmount);
		}
	}
	
	public void playerPos(Player nodePlayer) {

		if(firstPlayer == null) {
			firstPlayer = nodePlayer;
			lastPlayer = nodePlayer;
		} else {
			
			lastPlayer.setNext(nodePlayer);
			nodePlayer.setPrev(lastPlayer);
			lastPlayer=nodePlayer;
		}
	}
	public void inicPlayerPrintLn( ) {
		Player pyTempo=firstPlayer;
		playerPrintLn( pyTempo );
	}
	public void playerPrintLn(Player pyTempo ) {
		if(pyTempo!=null) {
			System.out.println(pyTempo.toString());
			pyTempo=pyTempo.getNext();
			playerPrintLn(  pyTempo );
		}
	}
	
	public void createTable(int num,int i) {
		if(num>0) {
			
			Node node = new Node(i+1);
			addLast(node);
			createTable(num-1,i+1);
		}
		
	}

	public void addLast(Node node) {
		if(first == null) {
			first = node;
			last = first;
		} else {
			Node penultimo = last;
			last = node;
			penultimo.setNext(node);
			node.setPrev(penultimo);
		}
	}
	
	public void printList() {
		Node node = last;
		int i=0;
		
		for( i=0; i<n; i++) {
			String row="";
			if(i % 2==0) {
				for(int j=0; j<m; j++) {
					row=node.toString()+row;
					node = node.getPrev();
				}
			}else  {
				for(int j=0; j<m; j++) {
					row=row+node.toString();
					node = node.getPrev();
				}
			}
			System.out.print(row);
			System.out.println("\n");
		}
	}
	
	public String printlnList(int i,String row) {
		if(i<n) {
			if(i % 2==0) {
				for(int j=0; j<m; j++) {
					row=last.toString()+row;
					last = last.getPrev();
				}
				
			}else  {
				for(int j=0; j<m; j++) {
					row=row+last.toString();
					last = last.getPrev();
				}
			}
			return printlnList( i++, row);
		}else {
			return row;
		}
	}
	
	public int dado() {
		int resultados = (int)(Math.random()*6 + 1); 
		return resultados;
	}
	
	public void inicAsigPlayerToTable() {
		Player nodePlayer=firstPlayer;
		Node nodeTable=first;
		asigPlayerToTable( nodePlayer,  nodeTable);
	}
	
	public void asigPlayerToTable(Player nodePlayer, Node nodeTable) {
		if(nodePlayer!=null) {
			if(nodeTable!=null) {
				if ( nodePlayer.getPosition()==nodeTable.getId()) {
					ArrayList<Player> p=nodeTable.getP();
					p.add(nodePlayer);
					nodeTable.setP(p);
					System.out.println("addPlayer");
					nodeTable=first;
					nodePlayer=nodePlayer.getNext();
					asigPlayerToTable( nodePlayer,  nodeTable);
				}else {
					nodeTable=nodeTable.getNext();
					asigPlayerToTable( nodePlayer,  nodeTable);
				}
			}
		}
			
	}
	
	public void inicMovePlayers() {
		Player nodePlayer=firstPlayer;
		moverPlayer( nodePlayer);
	}
	
	public void moverPlayer(Player nodePlayer) {
		if(nodePlayer!=null) {
			int valmover=nodePlayer.getPosition()+dado();
			nodePlayer.setPosition(valmover);
			nodePlayer=nodePlayer.getNext();
			moverPlayer( nodePlayer);
		}
	}
	
	public void inicCleanTableArray() {
		 Node nodeTable=first;
		 cleanTableArray( nodeTable);
	}
	
	public void cleanTableArray(Node nodeTable) {
		if(nodeTable!=null) {
			ArrayList<Player> p=new ArrayList<>();
			nodeTable.setP(p);
			nodeTable=nodeTable.getNext();
		}
	}
	
	public void inicAddtypeCelda() {
		Node nodeTable=first.getNext();
		int Snake=0;
		int Ladders=0;
		double media=m*n;
		int cell= (int) (((int) ((media)*0.3)));
		addTypeCelda(nodeTable,Snake,Ladders,cell,media);
	}
	
	public void addTypeCelda(Node nodeTable, int Snake,	int Ladders,int cell, double media) {
		if(cell>0) {
			int typeOfElement= (int) ((Math.random() * (6 - 1)) + 1);
			 if(typeOfElement==1) {
				 if(Snake<cell) {
					 String nameType=("s"+Snake);
					 Elemnnt  p=new Elemnnt(nameType, 1, "S");
					 nodeTable.setTipoCelda(p);
					 System.out.println("add snake");
					 addTypeCelda(nodeTable.getNext(), Snake+1, Ladders, cell-1, media);
				 }
			 }
			 if(typeOfElement==2) {
				 if(Ladders<cell) {
					 String nameType=("L"+Ladders);
					 Elemnnt  p=new Elemnnt(nameType, 1, "L");
					 nodeTable.setTipoCelda(p);
					 System.out.println("add ladders");
					 addTypeCelda(nodeTable.getNext(), Snake, Ladders+1, cell-1, media);
				 }
			 } 
			 if(typeOfElement==3||typeOfElement==4||typeOfElement==5||typeOfElement==6) {
				 Elemnnt  p=new Elemnnt("nulo", 1, "nulo");
				 nodeTable.setTipoCelda(p);
				 System.out.println("add null");
				 addTypeCelda(nodeTable.getNext(), Snake, Ladders, cell-1, media);
			 }

			 
		}
	}
	
	public void AddtypeCelda(Node nodeTable, int Snake,	int Ladders,int cell,double media) {
		if(media>0) {
			if(cell>0) {
				int typeOfElement= (int) ((Math.random() * (4 - 1)) + 1);
				 if(typeOfElement==1) {
					 if(Snake<cell) {
						 String nameType=("s"+Snake);
						 Elemnnt  p=new Elemnnt(nameType, 1, "S");
						 nodeTable.setTipoCelda(p);
						 System.out.println(p.toString());
						 nodeTable=nodeTable.getNext();
						 System.out.println(media);
						 AddtypeCelda(nodeTable, Snake+1, Ladders, cell-1,media-1);
					 }
				 }else if(typeOfElement==2) {
					 if(Ladders<cell) {
						 String nameType=("L"+Ladders);
						 Elemnnt  p=new Elemnnt(nameType, 1, "L");
						 nodeTable.setTipoCelda(p);
						 System.out.println(p.toString());
						 nodeTable=nodeTable.getNext();
						 System.out.println(media);
						 AddtypeCelda(nodeTable, Snake, Ladders+1, cell-1,media-1);
					 }
				 } else {
					 Elemnnt  p=new Elemnnt("nulo", 0, "nulo");
					 nodeTable.setTipoCelda(p);
					 System.out.println("add null");
					 nodeTable=nodeTable.getNext();
					 System.out.println(media);
					 AddtypeCelda(nodeTable, Snake, Ladders, cell-1,media-1);
				 }
			} else {
				Elemnnt  p=new Elemnnt("nulo", 0, "nulo");
				nodeTable.setTipoCelda(p);
				System.out.println("add null");
				nodeTable=nodeTable.getNext();
				System.out.println(media);
				AddtypeCelda(nodeTable, Snake, Ladders, cell,media-1);
			}
		}
		
		
	}
	
	public void saveWinners(Player winner, String nickName) throws IOException {
    	String result = "";
    	if (new File("./data/winners.csv").exists()) {
    		BufferedReader br = new BufferedReader(new FileReader("./data/winners.csv"));    		
    		result = readWinners(br.readLine(), br);
    	}
        PrintWriter pw = new PrintWriter("./data/winners.csv");
        if (!result.equals("")) {
        	pw.println(result);
        }
        winner.setId(nickName);
        pw.println();
        pw.close();
    }
	
	public String readWinners(String line, BufferedReader br) throws IOException {
    	if (line == null) {
    		return "";
    	} else {
    		String lineBefore = br.readLine();
    		if (lineBefore == null || lineBefore.equals("")) {
    			return line + readWinners(lineBefore, br);
    		} else {    			
    			return line + "\n" + readWinners(lineBefore, br);
    		}
    	}
    }
	
}
