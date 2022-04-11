package concatenar_e_normalizar_dados;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Medicao {
	//private Date data;
	//private Time hora;
	private String dataEHora;
	private List<Double> dadoSensores=new ArrayList<Double>();
	private boolean NaN;
	
	public Medicao(String linhaBruta) {
		this.dataEHora="";
		//dadosSensores=new List<Double>();
		String dadosSeparados[]=linhaBruta.split(" ");
		for(int i=0;i<dadosSeparados.length;i++) {
			if(i<2)
				dataEHora=dataEHora+dadosSeparados[i]+" ";
			if(dadosSeparados[i].equalsIgnoreCase("nan")) 
				dadoSensores.add(-1.0);
			if(i>=2)
				dadoSensores.add(Double.parseDouble(dadosSeparados[i]));
		}
		this.NaN=this.isNaN();
	}
	public boolean isNaN(){
		for(double valor:dadoSensores)
			if(valor==-1.0) 
				return true;
			
		return false;
	}
	public void setNaN(){
		this.NaN=false;
	}
	
	@Override
	
	public String toString(){
		String mensagem="";
		mensagem=dataEHora;
		for(Double dado:dadoSensores)
			mensagem=mensagem+dado+" ";
		
		return mensagem;
	}

}
