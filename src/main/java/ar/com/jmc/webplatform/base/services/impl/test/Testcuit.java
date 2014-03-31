package ar.com.jmc.webplatform.base.services.impl.test;

public class Testcuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cuit = "30123456780";
		
		String primero = cuit.substring(0, 2);
		String segundo = cuit.substring(2, 10);
		String tercero = cuit.substring(10, 11);
		
		String cuit_ = primero + "-" + segundo + "-" + tercero;
		System.out.println(cuit_);

	}

}
