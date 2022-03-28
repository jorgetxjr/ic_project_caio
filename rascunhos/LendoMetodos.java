import java.io.File;
import java.util.Scanner;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

public class LendoMetodos
{
	private Scanner entrada;
	
	public void abrir()
	{
		try
		{
			entrada= new Scanner(new File("teste.txt"));
		}
		catch(FileNotFoundException arquivoNaoEncontrado)
		{
			System.err.println("Não foi possível abrir o arquivo! Não encontraado");
			System.exit(1);//saída de erro
		}
	}
	
	public void ler()
	{
		try
		{
			while(entrada.hasNext())
				System.out.printf("%s - %d\n", entrada.next(), entrada.nextInt());
		}
		catch(NoSuchElementException entradaDiferente)
		{
			System.err.println("Entrada diferente da esperada");
			entrada.close();
			System.exit(1);
		}
	}
	
	public void fechar()
	{
		entrada.close();
	}
}