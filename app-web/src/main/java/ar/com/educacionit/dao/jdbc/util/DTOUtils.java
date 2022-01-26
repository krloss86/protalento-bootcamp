package ar.com.educacionit.dao.jdbc.util;

import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import ar.com.educacionit.dao.exceptions.GenericException;

//import org.slf4j.LoggerFactory;

public class DTOUtils {

	//private static Logger log = LoggerFactory.getLogger(DTOUtils.class);

	public static <T> List<T> populateDTOs(Class<T> obj, ResultSet rs) throws GenericException {
		//log.debug("populateDTOs - Start");
		//Cargo con reflection los dtos.
		List<T> dtos = new ArrayList<T>();
		try {
			List<Map<String,Object>>mapList = obtenerListaDeSetters(rs);
			T newInstanceOfDTO = null;
			for (Map<String, Object> map : mapList) {
				Class<?> paramTypes[] = new Class[1];
				Object paramValues[] = new Object[1];
				newInstanceOfDTO = obj.getDeclaredConstructor().newInstance();
				Iterator<String>iterador = map.keySet().iterator();
				String methodName;
				Method method;
				while(iterador.hasNext()){
					try{
						methodName = iterador.next();
						Object value = map.get(methodName);
						if(value != null){
							paramTypes[0] = Class.forName(value.getClass().getName());
							method = obj.getMethod(methodName, paramTypes);
							paramValues[0] = value;
							method.invoke(newInstanceOfDTO, paramValues);
						}
					}catch (NoSuchMethodException e) {
						System.err.println(e.getMessage());
						//En caso de exception, no setea ese campo y sigue con el siguiente.
						//log.debug(e.getMessage());
					}
				}
				dtos.add(newInstanceOfDTO);
			}
		}
		catch (Throwable e) {
			System.err.println(e.getMessage());
			//log.error(e.getMessage());
			throw new GenericException(e.getMessage(),e);
		}
		//log.debug("populateDTOs - End");
		return dtos;	
	}

	private static List<Map<String,Object>> obtenerListaDeSetters(ResultSet rs)throws SQLException{
		//log.debug("obtenerListaDeSetters - Start");
		Map<String,Object> mapa = null;
		List<Map<String,Object>>mapList = new ArrayList<Map<String,Object>>();
		while (rs.next()){
			mapa = new HashMap<String,Object>();
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = rs.getMetaData().getColumnCount();
			Object value = null;
			for (int i = 1; i <= columnCount; i++) {
				
				int type =  meta.getColumnType(i);
				
				//System.out.println(meta.getColumnName(i));
					
				if(type == Types.BIT) {
					value = rs.getObject(i)!=null ? rs.getInt(i) : null;
				}else if(type == Types.INTEGER || type == Types.NUMERIC) {
					value = rs.getObject(i)!=null ? rs.getLong(i) : null;
				}/*else if(type == Types.NUMERIC) {
					value = rs.getObject(i)!=null ? rs.getLong(i) : null;	
				}*/else if(type == Types.FLOAT) {
					value = rs.getObject(i)!=null ? rs.getFloat(i) : null;
				}else if(type == Types.DOUBLE || type == Types.REAL) {
					value = rs.getObject(i)!=null ? rs.getDouble(i) : null;
				}/*else if(type == Types.REAL) {
					value = rs.getObject(i)!=null ? rs.getBigDecimal(i) : null;
				}*/else if(meta.getColumnType(i) == Types.VARCHAR || meta.getColumnType(i) == Types.CHAR){
					value = rs.getString(i);
				}else if(meta.getColumnType(i) == Types.DATE || meta.getColumnType(i) == Types.TIMESTAMP){
					value = rs.getDate(i)!=null?new java.util.Date(rs.getTimestamp(i).getTime()):null;
				}else if (meta.getColumnType(i) == Types.CLOB){
					  Clob bodyOut = rs.getClob(i);
					  if(bodyOut!=null) {
					      int length = (int) bodyOut.length();
					      value = bodyOut.getSubString(1, length);
					  }else {
						  value = null;
					  }
				}/*else if(meta.getColumnType(i) == Types.BLOB) {
					value = rs.getBlob(i);
				}*/
				mapa.put("set"+DTOUtils.toJavaName(meta.getColumnName(i)),value);
			}
			mapList.add(mapa);
		}
		//log.debug("obtenerListaDeSetters - End");
		return mapList;
	}

	private static boolean isNumeric(int type) throws SQLException {
		return type == Types.NUMERIC || type == Types.INTEGER || type == Types.BIT || isFloating(type) ; 
	}
	
	private static boolean isFloating(int type) throws SQLException {
		return  type == Types.DOUBLE || type == Types.FLOAT || type == Types.REAL ; 
	}

	private static String convertToNameCase(String s){
		if(s == null || s.length() < 1){
			return s;
		}else{
			s = s.toLowerCase();
			StringBuffer buffer = new StringBuffer(s);
			buffer.setCharAt(0, Character.toUpperCase(buffer.charAt(0)));
			return buffer.toString();
		}
	}

	private static String toJavaName(String dbName){
		StringTokenizer st = new StringTokenizer(dbName, "_");
		StringBuffer sb = new StringBuffer();
		for(; st.hasMoreTokens(); sb.append(convertToNameCase(st.nextToken())));
		return sb.toString();
	}
}