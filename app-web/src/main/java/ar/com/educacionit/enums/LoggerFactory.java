package ar.com.educacionit.enums;

public final class LoggerFactory {

	public static ILogger getLoggerFromEnum(LoggersEnum loggerEnum) throws RuntimeException{
		
		if(loggerEnum == null) {
			throw new RuntimeException("Debe indicar un LoggerEnum Valido");
		}
		
		if(loggerEnum == LoggersEnum.FS) {
			return new FSLogger();
		}else {
			return new ConsoleLogger();
		}
	}
}
