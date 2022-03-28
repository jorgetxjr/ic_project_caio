import java.util.Scanner;
import java.io.File;

//estudo sobre a classe file!

public class FileStudy
{
	public static void main(String[] args)
	{
		Scanner entrada = new Scanner(System.in);
		System.out.print("Entre om um endereço válido de um arquivo: ");
		String caminho = entrada.nextLine();
		
		metodos(caminho);
	}
	
	public static void metodos(String caminho)
	{
		File arquivo = new File(caminho);
		
		if(arquivo.exists())
		{
			System.out.println("O caminho especificado existe!\nVamos aos testes:\n");
			if(arquivo.isAbsolute())
				System.out.println("É um caminho absoluto");
			else
				System.out.println("Não é um caminho absoluto");
			
			if(arquivo.isFile())
				System.out.printf("É um arquivo de tamanho %s bytes\n"
						+"última modificação %s\n"
						+"cujo o caminho é %s\n"
						+"de caminho absoluto %s\n"
						+"e está no diretório pai %s\n",
						arquivo.length(),arquivo.lastModified(), arquivo.getPath(), arquivo.getAbsolutePath(),arquivo.getParent());
						//semelhante ao printf do C
			else
			{
				System.out.println("É um diretório com os seguintes arquivos:");
				String[] arquivos=arquivo.list();
				
				for(String file: arquivos)
					System.out.println(file);
			}
		}
		else//de arquivo.exists()
		{
			System.out.printf("O caminho: %s\n não é um diretório ou arquivo válido.\n",arquivo);
		}
	}
}