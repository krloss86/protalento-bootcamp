package ar.com.educacionit.web.enums;

public enum ViewEnums implements Enumerable{

	LOGIN("/login.jsp"),
	LOGIN_SUCCESS("/loginSuccess.jsp"),
	HOME("/index.jsp"), 
	ERROR_GENERAL("/errorGeneral.jsp"), 
	UPLOAD_PREVIEW("/preview.jsp"), 
	UPLOAD("/upload.jsp"), 
	RESULTADO_PREVIEW("/resultadoPreview.jsp"), 
	LISTADO_GENERAL("/listadoGeneral.jsp"), 
	NUEVO("/nuevo.jsp");
	
	private String view;
	
	private ViewEnums(String view) {
		this.view = view;
	}

	public String getView() {
		return view;
	}
	
	@Override
	public String getParam() {
		return this.getView();
	}
}
