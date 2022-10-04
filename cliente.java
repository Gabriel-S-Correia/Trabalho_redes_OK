import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
	public static void main(String[] args) throws IOException {
	    
	    Scanner sc = new Scanner(System.in);
	    
	    Socket client = new Socket("localhost", 60000);
	    
	    BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
	    ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());  
	    
	    String letra = input.readLine();
	    System.out.println("Letra sorteada: "+letra);
	    
	    //ArrayList<String> respostas = new ArrayList<>();
	    String[] respostas = new String[3];
	    
	    String nome, lugar, objeto;
	    System.out.print("Digite um nome com a letra "+letra+": ");
	    nome = sc.nextLine();
	    System.out.print("Digite um lugar com a letra "+letra+": ");
	    lugar = sc.nextLine();
	    System.out.print("Digite um objeto com a letra "+letra+": ");
	    objeto = sc.nextLine();
	    
	    respostas[0] = (nome);
	    respostas[1] = (lugar);
	    respostas[2] = (objeto);
	    
	    output.writeObject(respostas);
	    output.flush();
	    
	    sc.close();
	    client.close();
	}
}
