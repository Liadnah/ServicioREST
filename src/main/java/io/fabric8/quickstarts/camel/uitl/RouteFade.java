package io.fabric8.quickstarts.camel.uitl;

import org.apache.camel.Exchange;
import org.hibernate.validator.internal.util.privilegedactions.GetMethodFromPropertyName;

import io.fabric8.quickstarts.camel.model.persona;

public class RouteFade {

//	public void traerNuemo(Exchange exchange) {
//
//		Integer a = (Integer) exchange.getProperty("precio");
//
//		a = a + 2000;
//
//		exchange.setProperty("precio", a);
//
//	}

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
		
	public void Salario(Exchange exchange) {
	
			String  num = (String) exchange.getProperty("salario");
				
			Double a  = Double.parseDouble(num);
	
			if(a <= 400) {
				a = a + (a*0.1);
				System.out.println("Su salario total es de: " + a);
			}
			else {
				a = a + (a*0.02);
				System.err.println("Su salario total es de: " + a);
			}
			exchange.setProperty("salario", a);

	}
	
	public void Informacion(Exchange exchange) {
		
		persona ResponsePersona = new persona();
		
		ResponsePersona.setNombre("Pukis");
		ResponsePersona.setEdad((String) exchange.getProperty("edad"));
		ResponsePersona.setSalario((String) exchange.getProperty("salario"));
		
		exchange.getIn().setBody(ResponsePersona);

		
	}
	
}


