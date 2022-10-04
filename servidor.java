import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Aguardando conexao...");

		ServerSocket s = new ServerSocket(60000);

		while(true) {

			Socket conexao = s.accept();
			System.out.println("Cliente conectado!");
			char letra = gerarLetra();
			String letra_enviada = letra + "\n";

			ObjectInputStream input = new ObjectInputStream(conexao.getInputStream());
			DataOutputStream output = new DataOutputStream(conexao.getOutputStream());

			output.writeBytes(letra_enviada);
			output.flush();

			Object object = input.readObject();
			String[] respostas;
			respostas = (String[])object;
						
		}
		

		
	}

	private static char gerarLetra() {	
		Random r = new Random();
		char letra = (char)(r.nextInt(26) + 'a');
		return letra;
	}

}
