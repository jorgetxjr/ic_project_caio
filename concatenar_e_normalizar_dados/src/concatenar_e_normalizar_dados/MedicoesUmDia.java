package concatenar_e_normalizar_dados;
/*TODO:
 * gets and sets DONE!
 * rever a funcionalidade de protected out
 * testar repetição de horas
 * ordenação - usando propriedades de arraylist ou
 * ordenação - faça na mão
 * remover NaN
 * */

import java.util.List;
import java.util.ArrayList;

public class MedicoesUmDia {
	private int dia;
	private int mes;
	private String titulos;
	private List<Medicao> medicoesDia=new ArrayList<>();
	private final double NAN=-666.0;
	
	public MedicoesUmDia(String titulos, int dia, int mes, Medicao novaMedicao) //OK
	{
		this.titulos=titulos;
		this.dia=dia;
		this.mes=mes;
		this.medicoesDia.add(novaMedicao);
	}
	//gets
	public int getDia() //OK
	{
		return this.dia;
	}
	public int getMes() //OK
	{
		return this.mes;
	}
	public String getTitulos() //OK
	{
		return this.titulos;
	}
	public List<Medicao> getMedicoes()//OK
	{
		return this.medicoesDia;
	}

	//sets
	public void setDia(int dia) //OK
	{
		this.dia=dia;
	}
	public void setMes(int mes)//OK 
	{
		this.mes=mes;
	}
	
	public void adicionarMedicao(Medicao nova) //OK
	{
		this.medicoesDia.add(nova);
	}
	//FAZER UMA FUNÇÃO DE ORDENAÇÃO
	public boolean isNaN() //OK
	{
		for(Medicao med: medicoesDia)
			if(med.isNaN())
				return true;
		return false;
	}
	public int[] acharPosicoesComNaN() 
	{
		int retorno[]= {0,0};
		
		for(Medicao med:this.medicoesDia)
		{
			if(med.isNaN()) //acha a linha com NaN
			{
				retorno[0]=medicoesDia.indexOf(med);
				//System.out.println("Número da medição com NaN: "+retorno[0]);
				
				for(int i=0;i<med.getDadosSensores().size();i++) 
				{
					if(med.getDadosSensores().get(i)==NAN) //acha a coluna com nan
					{
						retorno[1]=i;
						//System.out.println("Número da coluna com NaN: "+ retorno[1]);
						break;
					}
					
				}
				break;
			}
			
		}
		/*CUIDADO:
		 * Primeiro ítem;
		 * último ítem
		 */
		return retorno;
	}
	
	public int limiteDadosNaN(int [] inicioNaN) 
	{
		int limite=0;
		for(int i=inicioNaN[0];i<medicoesDia.size();i++) 
		{
			if(medicoesDia.get(i).getDadosSensores().get(inicioNaN[1])==NAN) 
				limite=i;
			
			else
				break;
		}
		
		return limite;
	}
	
	@Override
	public String toString() //OK
	{
		String mensagem=this.getTitulos();
		mensagem+="\n";
		for(int i=1;i<=medicoesDia.size();i++) 
		{
			mensagem=mensagem+i+" "+medicoesDia.get(i-1)+"\n";
		}
		
		return mensagem;
	}
	

}
