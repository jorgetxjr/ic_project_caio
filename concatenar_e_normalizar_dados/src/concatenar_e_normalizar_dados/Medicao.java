package concatenar_e_normalizar_dados;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;
import java.text.*;

public class Medicao 
{
	private Date dataEHora;
	private List<Double> dadoSensores=new ArrayList<Double>();
	private SimpleDateFormat formatoDataCompleta=new SimpleDateFormat("dd/MM/yyy hh:mm:ss");
	//private SimpleDateFormat formatoCurto=new SimpleDateFormat("dd/MM/aaaa");
	//private GregorianCalendar gc;
	private final double NAN=-666.0;
	
	//aprendizado para a vida: se estiver fazendo um parse, há a chance de ter uma
	//exception. Ou você trata, ou você faz um throws.
	
	public Medicao(String linhaBruta) 
	{
		String dadosSeparados[]=linhaBruta.split("	");
		try
		{
			dataEHora=formatoDataCompleta.parse(dadosSeparados[0]);
			//não está acontecendo de forma correta. Ele está juntando meio dia e meia noite em uma
			//coisa só
		}
		catch(ParseException e)
		{
			e.getStackTrace();
		}
		
		for(int i=1;i<dadosSeparados.length;i++) {
			if(dadosSeparados[i].equals("nan")) 
				dadoSensores.add(NAN);
			else
				dadoSensores.add(Double.parseDouble(dadosSeparados[i]));
		}
		//this.gc.setTime(dataEHora);
	}
	//gets
	public Date getDataEHora() 
	{
		return this.dataEHora;
	}
	public List<Double> getDadosSensores()
	{
		return this.dadoSensores;
	}
	/*public int getDia() 
	{
		return gc.get(gc.DAY);
	}
	public int getMes() {}
	public void getHora() {}
	//ou dá para extrair da data tais informações???*/
	
	//sets
	public void setMedicao(int posicao, double valor) {}
	
	public boolean isNaN()
	{
		for(double valor:dadoSensores)
			if(valor==-666.0) 
				return true;
			
		return false;
	}
	
	@Override
	
	public String toString()
	{
		String mensagem="";
		mensagem=dataEHora+" ";//melhorar esta forma de exibição?
		for(Double dado:dadoSensores)
			mensagem=mensagem+dado+" ";
		
		return mensagem;
	}

}
