package io.fabric8.quickstarts.camel.uitl;

import org.apache.camel.Exchange;
import org.hibernate.validator.internal.util.privilegedactions.GetMethodFromPropertyName;

import io.fabric8.quickstarts.camel.model.ResponseNumeros;
import io.fabric8.quickstarts.camel.model.numeros;
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
	
	public void ResultadoOperacion(Exchange exchange) {
		
		ResponseNumeros response_numeros = new ResponseNumeros();
		
		String  tipo_operacion = (String) exchange.getProperty("operacion");
		
		String  numero1 = (String) exchange.getProperty("num1");
		Double a  = Double.parseDouble(numero1);
		
		String  numero2 = (String) exchange.getProperty("num2");
		Double b  = Double.parseDouble(numero2);
		
		Double  resulta;
		
		
		if (tipo_operacion.contains("suma")){
        	
			resulta = a + b;
			response_numeros.setResultado(resulta);		
		}
		
		else if (tipo_operacion.contains("resta")){
        	
			resulta = a - b;
			response_numeros.setResultado(resulta);	
		}
		
		else if (tipo_operacion.contains("multiplicacion")){
        	
			resulta = a * b;
			response_numeros.setResultado(resulta);	
		}

		else if (tipo_operacion.contains("division")){
        	
			resulta = a / b;
			response_numeros.setResultado(resulta);	
		}
		
		else {
			resulta = null;
		}
		


        exchange.getIn().setBody(response_numeros);

	}
}


