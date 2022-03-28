//package rascunhos;

public class ManipularStrings {
    public static void main(String[] args) 
    {
    String original="17/12/2021 12:08:24.670	31.9	32.0	219.9	219.3	17.1	29.6	29.4	31.9	29.8	28.9	32.0	nan	nan	nan	1.139	217.84	248	nan	0.363	0.372	0.372	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	2.513	196.50	493	0.736	213.50	156	2.701	0.893	0.906	0.904	235.54	236.72	235.97	620	205	208	207	12	14	16	621	210	214	213	50.00";
    String modificada;
    String[] temporaria = original.split("\t", 0);
    
    modificada=temporaria[0];

    for(int i=0;i<temporaria.length;i++)
    {
        //System.out.println(a);
        if(temporaria[i].equals("nan"))
            temporaria[i]="0.000";
        //System.out.println(a);
        if(i>0)
            modificada=modificada+temporaria[i]+"\t";
    }
    System.out.println(modificada);

    }
    

    
}
