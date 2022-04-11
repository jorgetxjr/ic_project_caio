package concatenar_e_normalizar_dados;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String umaLinha="03/01/2022 00:00:24.682	0.0	0.0	0.0	0.0	11.8	11.1	10.9	11.3	11.5	11.5	10.9	0.000	0.00	0	0.000	0.00	0	65.535	0.000	0.000	0.000	655.35	655.35	655.35	0	0	0	0	0	0	0	0	0	0	0	655.35	0.000	0.00	0	0.000	0.00	0	65.535	0.000	0.000	0.000	655.35	655.35	655.35	0	0	0	0	0	0	0	0	0	0	0	655.35";
		String linhaComNaN="03/01/2022 12:32:24.672	42.5	42.7	227.6	227.6	16.9	24.2	24.0	26.9	25.2	23.3	26.4	nan	nan	nan	1.061	222.89	235	nan	0.348	0.359	0.363	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	nan	2.707	192.46	520	0.822	215.88	176	2.914	0.962	0.977	0.975	236.72	237.62	237.26	671	222	225	224	12	14	16	672	227	232	231	50.00";
		Medicao medicaoTeste=new Medicao(linhaComNaN);
		System.out.println(medicaoTeste);

	}

}
