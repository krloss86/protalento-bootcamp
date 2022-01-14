package ar.com.educacionit.enums;

public enum LoggersEnum {
	FS("FS"),//0
	CONSOLE("CONSOLE");//1
	
	private String valor;
	
	private LoggersEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}
	
	// 
	public static LoggersEnum getEnumFromStr(String strEnum) {
		LoggersEnum aux = null;
		if(strEnum != null) {
			LoggersEnum[] enums = LoggersEnum.values();
			for(LoggersEnum _enum : enums) {
				if(strEnum.equalsIgnoreCase(_enum.getValor())) {
					aux = _enum;
					break;
				}
			}
		}
		return aux;
	}
}
