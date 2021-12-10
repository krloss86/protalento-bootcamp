package ar.com.educacionit.domain;

import ar.com.educacionit.dao.ICrud;
import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.dao.impl.SocioSQLCustom;

public class FindAllSociosTest2 {

	public static void main(String[] args) {
		
		//creo la implementacion que me permite acceder a la db (CRUDl)
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		//ArticuloDaoImpl articuloImpl = new ArticuloDaoImpl();
		//CuponDaoImpl c = new CuponDaoImpl();
		
		ICrud[] cruds = new ICrud[] {socioImpl, /*articuloImpl,CuponDaoImpl*/};
		
		for(ICrud unCrud : cruds) {
			if(unCrud instanceof SocioSQLCustom) {
				SocioSQLCustom sc = (SocioSQLCustom)unCrud;
				sc.selectCustom();
				
			}
		}
	}
}
