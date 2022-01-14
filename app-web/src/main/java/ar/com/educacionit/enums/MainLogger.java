package ar.com.educacionit.enums;

import java.util.Scanner;

public class MainLogger {

	public static void main(String[] args) {
		//POR AHORA EL USUARIO NO INGRESA NADA!!!
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese una opcion (FS/CONSOLE)");
		String opcionLeidaPorElUsuario = teclado.next();		
		LoggersEnum fsEnum = LoggersEnum.getEnumFromStr(opcionLeidaPorElUsuario);
		
		ILogger logger = LoggerFactory.getLoggerFromEnum(fsEnum);
		
		logger.loguear();
		
		teclado.close();
	}

}
