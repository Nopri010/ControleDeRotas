package entities;

public class Veiculo {
	    private String placa;
	    private int ano;
	    private int numeroPortas;

	    public Veiculo(String placa, int ano, int numeroPortas) {
	        this.placa = placa;
	        this.ano = ano;
	        this.numeroPortas = numeroPortas;
	    }

	    public String getPlaca() {
	        return placa;
	    }

	    public int getAno() {
	        return ano;
	    }

	    public int getNumeroPortas() {
	        return numeroPortas;
	    }

	    @Override
	    public String toString() {
	        return "Placa: " + placa + ", Ano: " + ano + ", Número de Portas: " + numeroPortas;
	    }
	}
