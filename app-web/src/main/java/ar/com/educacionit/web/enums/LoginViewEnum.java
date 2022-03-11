package ar.com.educacionit.web.enums;

public enum LoginViewEnum {

	USERNAME("username"),
	PASSWORD("password")
	;
	
	private final String param;
	
	private LoginViewEnum(String param) {
		this.param = param;
	}
	
	public String getParam() {
		return this.param;
	}
}
