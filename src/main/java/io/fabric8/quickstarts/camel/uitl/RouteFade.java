package io.fabric8.quickstarts.camel.uitl;

import org.apache.camel.Exchange;

public class RouteFade {

	public void traerNuemo(Exchange exchange) {

		Integer a = (Integer) exchange.getProperty("precio");

		a = a + 2000;

		exchange.setProperty("precio", a);

	}

	public void mayorEdad(Exchange exchange) {

		String  num = (String) exchange.getProperty("edad");
		
	    Integer a  = Integer.parseInt(num);

		if(a >= 18) {
			System.out.println("Puede entrar al bar");
		}
		else {
			System.err.println("No puede entrar al bar");
		}
		exchange.setProperty("edad", a);

	}

}
