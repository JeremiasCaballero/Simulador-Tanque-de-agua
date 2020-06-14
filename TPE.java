/* TPE MATEMATICA */

package metods;
import java.io.*;
public class TPE{

	public static void main(String[] args) {
		int opcion = 0;
		  double at = 0;
		  double h = 0;
		  double e = 0;
		  double s = 0;
		  double a = 0;
		  double c = 0;
		  double k = 0;
		  double g = 0;
		  double w = 0;
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("============== Bienvenido =========================");
			System.out.println("1) Simular con E y S Constantes");
			System.out.println("2) Simular con S(t) = K * t ");
			System.out.println("3) Simular con S(t) = W * t * t");
			System.out.println("4) Simular con S(t) = G/A * h(t)");
			System.out.print("Ingrese una opcion :");
			opcion = Integer.valueOf(entrada.readLine());
		}catch (Exception exc ) {
			System.out.println( exc );
		}
		switch(opcion) {
		  case 1:
			  try {
				  BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				  System.out.println("Ingrese At: ");
				  at = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese h: ");
				  h = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese e: ");
				  e = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese s: ");
				  s = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese a: ");
				  a = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese c: ");
				  c = Double.valueOf(entrada.readLine());
				Realizar_ejercicio_uno_constantes(at,h,e,s,a,c);
			  	}catch (Exception exc ) {
					System.out.println( exc );
				}
			  	break;
		  case 2:
			 
			  try {
				  BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				  System.out.println("Ingrese At: ");
				  at = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese h: ");
				  h = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese e: ");
				  e = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese a: ");
				  a = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese c: ");
				  c = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese k: ");
				  k = Double.valueOf(entrada.readLine());
				  Realizar_ejercicio_dos(at,h,e,a,c,k);
			  	}catch (Exception exc ) {
					System.out.println( exc );
				}
			  
			  //Realizar_ejercicio_dos(0.1,5,0,0.5,5,2);
		    break;
		  case 4:
			  try {
					  BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
					  System.out.println("Ingrese At: ");
					  at = Double.valueOf(entrada.readLine());
					  System.out.println("Ingrese h: ");
					  h = Double.valueOf(entrada.readLine());
					  System.out.println("Ingrese e: ");
					  e = Double.valueOf(entrada.readLine());
					  System.out.println("Ingrese g: ");
					  g = Double.valueOf(entrada.readLine());
					  System.out.println("Ingrese a: ");
					  a = Double.valueOf(entrada.readLine());
					  System.out.println("Ingrese c: ");
					  c = Double.valueOf(entrada.readLine());
					  Realizar_ejercicio_cuatro(at,h,e,a,c,g);
				  	}catch (Exception exc ) {
						System.out.println( exc );
					}
			  break;
		  case 3:
			  try {
				  BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
				  System.out.println("Ingrese At: ");
				  at = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese h: ");
				  h = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese e: ");
				  e = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese w: ");
				  w = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese a: ");
				  a = Double.valueOf(entrada.readLine());
				  System.out.println("Ingrese c: ");
				  c = Double.valueOf(entrada.readLine());
				  Realizar_ejercicio_tres(at,h,e,a,c,w);
				  
			  }catch (Exception exc ) {
					System.out.println( exc );
				}
			  break;
		}
		
	}
	private static void Realizar_ejercicio_tres(double at, double h, double e, double a, double c, double w) {
		double tiempo= 0;
		double tiempo2 = 1;
		int iteraciones = 0;
		double valor = 0;
		boolean tanqueVacio = false;
		boolean tanquelleno = false;
		while(tanqueVacio == false) {
			double resultado = h+((e-w*Math.pow(tiempo2*at,2))*at/a);
			tiempo2++;
			tiempo+=at;
			iteraciones++;
			if((resultado>= c/2) && (valor == 0)){
				valor = tiempo;
				System.out.println("El tanque llego a la mitad en :"+ valor + " segundos y"+iteraciones+" iteraciones");
			}
			h = resultado;
			
			if((h>=c) && (tanquelleno == false)){
				System.out.println("El tanque se lleno en: "+ tiempo + " segundos y "+iteraciones+" iteraciones");
				e = 0; // corto la entrada
				tanquelleno = true;
			}
			if (iteraciones>=1000000) {
				h=c;
			}
			if((h<=0)&&(tanqueVacio == false)) {
				System.out.println("El tanque se vacio en: "+ tiempo + " segundos y "+iteraciones+" iteraciones");
			tanqueVacio = true;
			}
		
		}
		System.out.println("Total de iteraciones  "+iteraciones);
	}
	private static void Realizar_ejercicio_cuatro(double at, double h, double e, double a, double c, double g) {
		double tiempo= 0;
		int iteraciones = 0;
		double valor = 0;
		boolean tanqueVacio = false;
		boolean tanquelleno = false;
		
		while(tanqueVacio == false) {
			double resultado = h+(e-(g/a)*h)*at/a;
			tiempo+=at;
			iteraciones++;
			if((resultado>= c/2) && (valor == 0)){
				valor = tiempo;
				System.out.println("El tanque llego a la mitad en :"+ valor + " segundos y"+iteraciones+" iteraciones");
			}
			h = resultado;
			
			if((h>=c) && (tanquelleno == false)){
				System.out.println("El tanque se lleno en: "+ tiempo + " segundos y "+iteraciones+" iteraciones");
				e = 0; // corto la entrada
				tanquelleno = true;
			}
			if (iteraciones>=1000000) {
				h=c;
			}
			if((h<=0.000000001)&&(tanqueVacio == false)) {
				System.out.println("El tanque se vacio en: "+ tiempo + " segundos y "+iteraciones+" iteraciones");
			tanqueVacio = true;
		}
			
			
		}
		System.out.println("Total de iteraciones  "+iteraciones);
		
		
	}
	public static void Realizar_ejercicio_uno_constantes(double at, double h, double e, double s, double a, double c) {
		System.out.println("=======================================");
		double tiempo=0;
		int iteraciones=0;
		double valor = 0;
		boolean tanqueVacio = false;
		boolean TanqueLleno = false;
		while (tanqueVacio == false) {

			double resultado= h+((e-s)*at/a);
			tiempo+=at;
			iteraciones++;
			if ((resultado >= c/2)&&(valor == 0 )){
				valor = tiempo;
				System.out.println("El tanque llego a C/2 en : "+ valor + " segundos y "+iteraciones+" iteraciones");
			}
			h=resultado;
			
			if((h>=c)&&(TanqueLleno == false)) {
				System.out.println("El tanque se lleno en: "+ tiempo + " segundos y "+iteraciones+" iteraciones");
				e = 0; // corto la entrada
				TanqueLleno = true;
			}
			if (iteraciones>=1000000) {
				h=c;
			}
		if((h<=0)&&(tanqueVacio == false)) {
			System.out.println("El tanque se vacio en: "+ tiempo + " segundos y "+iteraciones+" iteraciones");
			tanqueVacio = true;
		}
		} // cierre del while
		System.out.println("Total de iteraciones  "+iteraciones);
	}
	public static void Realizar_ejercicio_dos(double at,double h,double e,double a,double c,double k) {
		System.out.println("=======================================");
		double tiempo=0;
		int iteraciones=0;
		double valor = 0;
		boolean tanqueVacio = false;
		boolean TanqueLleno = false;
		
		while (tanqueVacio == false) {
			double salida = k*tiempo;
			double resultado= h+((e-salida)*at/a);
			tiempo+=at;	
			iteraciones++;
			if ((resultado >= c/2)&&(valor == 0 )){
				valor = tiempo;
				System.out.println("El tanque llego a C/2 en : "+ valor + " segundos y "+iteraciones+" iteraciones");
			}
			h=resultado;
			
			if((h>=c)&&(TanqueLleno == false)) {
				System.out.println("El tanque se lleno en: "+ tiempo + " segundos y "+iteraciones+" iteraciones");
				e = 0; // corto la entrada
				TanqueLleno = true;
			}
			if (iteraciones>=1000000) {
				h=c;
			}
		if((h<=0)&&(tanqueVacio == false)) {
			System.out.println("El tanque se vacio en: "+ tiempo + " segundos y "+iteraciones+" iteraciones");
			tanqueVacio = true;
		}
		}// cierre while
		System.out.println("Total de iteraciones  "+iteraciones);
	
	} 
}

