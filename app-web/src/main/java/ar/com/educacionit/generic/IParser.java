package ar.com.educacionit.generic;

public interface IParser<T> {
	public T parse() throws ParseException;
	//public Collection<T> parseFile();
}
