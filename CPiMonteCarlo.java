/**
 * @author Daniel Gil Bustillo
 */
import java.rmi.Naming;
import java.util.Scanner;

public class CPiMonteCarlo {
	public static void main(String[] args)throws Exception{
		iPiMonteCarlo RefObRemoto = (iPiMonteCarlo)Naming.lookup("//127.0.0.1:1099/Servidor");  
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el numero de puntos: ");
		RefObRemoto.masPuntos(sc.nextInt());
		System.out.println("La aproximación es: "+RefObRemoto.resultado());
		RefObRemoto.reset();
		
	}
}
