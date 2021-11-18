package main;

import java.io.IOException;
import java.util.Scanner;

import exception.TableSizeValidation;
import exception.ValidationFormtPlayer;
import model.Table;

public class Main {

	private Scanner sc=new Scanner(System.in); 
	
	public static void main(String[] args) {
		
		Main m=new Main();
		m.inicio();
		
		
	}
	
	public void inicio() {
		System.out.println("Starting new game...\n");
		System.out.println("Inserte una cadena (ejemplo: 5 4 2 3 #%*)\n" +
				 "Que da un tablero de juego de 5 x 4 con:\n2 serpientes, 3 escaleras y 3 jugadores, un jugador por cada simmbolo.");
		String toCreate = sc.nextLine();
	    String [] parts = toCreate.split(" ");
	    int n = Integer.parseInt(parts[0]);
	    int m = Integer.parseInt(parts[1]);
	    int snakes = Integer.parseInt(parts[2]);
	    int ladders = Integer.parseInt(parts[3]);
	    String players = parts[4];
	    Table table = new Table(snakes,ladders,n, m,players);
		try {
			table.initTable();
		} catch (TableSizeValidation e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			table.init();
		} catch (ValidationFormtPlayer e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		boolean exit=false;
		table.InicLimparArrayTabla();
		table.inicAddtypeCelda();
	    
		ciclo( exit, table);
		
		
		System.out.println("guardar ganadores: dijite 1");
		int ganar=sc.nextInt();
		if(ganar==1) {
			table.salveJavaByteCode();
		}
		
	}
	
	public void ciclo(boolean exit,Table table) {
		if(exit==false) {
			System.out.println("1 para tirar el dado o 2 para salir");
			int exitt=sc.nextInt();
			if(exitt==1) {
				table.iinicioMoverfichas();
				table.inicAsigPlayerToTabl();
				table.inicPlayerPrintLn( );
				table.printList();
				ciclo( exit, table);
			}else if(exitt==2) {
				exit=true;
				ciclo( exit, table);
			}
			
		}
	}

}
