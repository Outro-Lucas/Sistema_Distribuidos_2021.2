package servidor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RodoviariaDespachante {

	public byte[] selecionaEqueleto(Mensagem request) {

		Class<?> objRef = null;
		Method method = null;
		byte[] resposta = null;
		try {
			objRef = Class.forName("servidor."+request.getObjectRef()+"Esqueleto");
			String methodName = request.getMethod();
			System.out.println("Executando: " + methodName);
			method = objRef.getMethod(methodName, byte[].class);
			resposta = (byte[]) method.invoke(objRef.newInstance(),
					request.getArgs());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}