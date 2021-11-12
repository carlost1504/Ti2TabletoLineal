package main;

import exception.TableSizeValidation;
import exception.ValidationFormtPlayer;
import model.Table;

public class Main {

	public static void main(String[] args) {
		
		Table table = new Table(5, 6,"qsrt");
		
		
		try {
			table.init();
		} catch (ValidationFormtPlayer e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		try {
			table.initTable();
		} catch (TableSizeValidation e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.printList();
		
	}

}
