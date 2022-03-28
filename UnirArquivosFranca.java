/*objetivo:
ler os arquivos da pasta
separar os arquivos por mês
unir os arquivos de um mês em um único arquivo*/

/*solução:
>>ler a pasta onde tem os arquivos e validar; OK
>>ler o primeiro arquivo e copiar em um novo arquivo;
>>ler os arquivos, do segundo ao "n" e copiar no novo arquivo;
>>somente comece a fazer firulas aqui!
*/

import java.util.Scanner;
//import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.FormatterClosedException;
import java.lang.SecurityException;
import java.io.*;

public class UnirArquivosFranca
{
	public static void main(String[] args) throws IOException
	{
		Scanner entrada=new Scanner(System.in);
		String caminho=null;
		String[] arquivos=null;
		System.out.print("Digite o local dos arquivos: ");
		caminho=entrada.nextLine();
		System.out.printf("Caminho digitado: %s\n", caminho);
		File localDosArquivos = new File(caminho);
		
		if(isValido(localDosArquivos))
		{
			arquivos=localDosArquivos.list();
			//System.out.printf("Diretório superior: %s", localDosArquivos.getParent());
			
			for(int i=0;i<arquivos.length;i++)
				mostraArquivo(localDosArquivos, arquivos[i], i);
			
		}
		else
		{
			System.out.println("NOPE!!");
		}
		entrada.close();
		
		
	}
	//-------------------------------------------------------//
	public static boolean isValido(File localDosArquivos)
	{
		if(localDosArquivos.exists())
			if(localDosArquivos.isDirectory())
				return true;
		return false;
	}
	//--------------------------------------------------------//
	public static void mostraArquivo(File localDosArquivos, String nomeArquivo, int i) throws IOException
	{
		try
		{
			String caminhoCompleto = localDosArquivos+"\\"+nomeArquivo;
			FileInputStream entrada = new FileInputStream(caminhoCompleto);
			InputStreamReader entradaFormatada = new InputStreamReader(entrada);
			BufferedReader entradaString = new BufferedReader(entradaFormatada);
		
			String linha = entradaString.readLine();
			System.out.printf("Lendo o arquivo: %s", nomeArquivo);
			
			if(i>0)
				linha=entradaString.readLine();
		
			//a função de normalizanção do NAN tem que entrar no máximo aqui
			while(linha != null)
			{
				//System.out.println(linha);
				//linha = removeNAN(linha);
				if(!validaLinha(linha))
					escreverArquivoCompleto(localDosArquivos, linha);
				
				linha = entradaString.readLine();
			}
			entrada.close();
			System.out.printf(" ...Lido!\n");
		}
		catch(IOException e)
		{
			System.err.print("Houston, we have a problem!\n");
		}
		
	}
	//-------------------------------------------//
	
	public static void escreverArquivoCompleto(File localDosArquivos, String linha)
	{
		try
		{
			String caminhoSaida = localDosArquivos.getParent()+"\\"+"dados_concatenados.txt";
			FileWriter fw = new FileWriter(caminhoSaida, true);
			BufferedWriter bw =new BufferedWriter(fw);
			
			bw.write(linha);
			bw.write("\n");
			
			bw.close();
			fw.close();
			//Formatter arquivoSaida=new Formatter(a, caminhoSaida);
			//arquivoSaida.format(linha);
			//arquivoSaida.close();
			
		}
		catch(SecurityException se)
		{
			System.err.println("O arquivo não pode ser criado!");
			System.exit(1);
		}
		catch(FileNotFoundException fnf)
		{
			System.err.println("Arquivo não encontrado!");
			System.exit(1);
		}
		catch(FormatterClosedException formatoDesconhecido)
		{
			System.err.println("Erro ao escrever.");
			System.exit(1);
		}
		catch(NoSuchElementException ee)
		{
			System.err.println("Entrada invãlida em formato.");
			System.exit(1);
		}
		catch(IOException e)
		{
			System.err.println("Falha de leitura ou escrita de arquivo.");
			System.exit(1);
		}
		
	}
	//------------------------------------------------------//
	public static String removeNAN(String linhaBruta) //version 1
	{
		/*estratégia:
		1 quebrar a linha em um vetor de string
		2 avaliar cada posição da string,se é nan. se sim, substituir por zero
		3 reconcatenar a string em uma linha
		4 retornar a linha
		*/
		String linhaNormalizada;
		String[] temporaria=linhaBruta.split("\t",0);
		linhaNormalizada=temporaria[0];

		for(int i=0;i<temporaria.length;i++)
		{
			if(temporaria[i].equalsIgnoreCase("nan"))
				temporaria[i]="0.000";
			if(i>0)
				linhaNormalizada=linhaNormalizada+temporaria[i]+"\t";
		}
		return linhaNormalizada;
	}
	//------------------------------------------------------------//
	public static boolean validaLinha(String linhaBruta)
	{
		if(linhaBruta.contains("nan")||linhaBruta.contains("NAN")||linhaBruta.contains("NaN"))
			return true;
		return false;
	}
	
	
}
