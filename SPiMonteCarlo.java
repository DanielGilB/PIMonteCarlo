/**
 * @author Daniel Gil Bustillo
 */

import java.rmi.*;
import java.rmi.server.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo {
	
	int puntos;
	static AtomicInteger aciertos = new AtomicInteger(0);
	double x,y;
	
	public SPiMonteCarlo() throws RemoteException { super(); }
	
	public void reset() throws RemoteException{ 		  
		puntos = 0;
		aciertos.set(0);
	}
	  
	  public void masPuntos(int nPuntos)  throws RemoteException{ 
		 puntos = nPuntos;
		 
			for(int i=0; i<nPuntos; i++)
			{
				x=Math.random();
				y=Math.random();
				if((x*x + y*y <= 1))
				{
					aciertos.incrementAndGet();
				}
			}
	  }
	
	  public double resultado(){
		System.out.println("Aproximacion: "+(double)4*aciertos.get()/(double)puntos);
		  return (double)4*aciertos.get()/(double)puntos;
	  }
	  
		public static void main(String[] args)throws Exception{
			iPiMonteCarlo ORemoto = new SPiMonteCarlo();
			Naming.rebind("//127.0.0.1:1099/Servidor", ORemoto);  
			System.out.println("Servidor preparado");		
		}
}
