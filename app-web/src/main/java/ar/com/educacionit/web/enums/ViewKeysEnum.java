package ar.com.educacionit.web.enums;

public enum ViewKeysEnum {

	USERNAME("username"),
	PASSWORD("password"),
	ERROR_GENERAL("error"), 
	USUARIO_PASSWORD_INVALIDO("Usuario/Password incorrectos"),
	USER("user"),
	UPLOAD_FILE("uploadfile"),
	UPLOAD_PREVIEW_KEY("upload_preview_key")
	;
	
	private final String param;
	
	private ViewKeysEnum(String param) {
		this.param = param;
	}
	
	public String getParam() {
		return this.param;
	}
}
