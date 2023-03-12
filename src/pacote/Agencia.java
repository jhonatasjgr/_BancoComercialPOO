package pacote;

import java.util.ArrayList;

public class Agencia {
	
	

	static ArrayList<Conta> contas = new ArrayList<Conta>();
	
	private int numeroAgencia;
	private String nomeAgencia;
	
	public Agencia(int nu, String no) {
		this.setNumeroAgencia(nu);
		this.setNomeAgencia(no);
	}
	
	public int getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getNomeAgencia() {
		return nomeAgencia;
	}
	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}
	
}
