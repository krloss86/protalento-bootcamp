package ar.com.educacionit.web.enums;

public enum ViewEnums {

	LOGIN("/login.jsp"),
	LOGIN_SUCCESS("/loginSuccess.jsp"),
	HOME("/index.jsp"), 
	ERROR_GENERAL("/errorGeneral");
	
	private String view;
	
	private ViewEnums(String view) {
		this.view = view;
	}

	public String getView() {
		return view;
	}
	
}
