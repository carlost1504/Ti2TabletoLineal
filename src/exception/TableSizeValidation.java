package exception;

public class TableSizeValidation extends Exception{

	public TableSizeValidation(int n,int m) {
		super("el tamaño de la tabla tiene que ser mayor a 4x4 los valores ingresados son menores a esto: "+n+"x"+ m);
		
	}

}
