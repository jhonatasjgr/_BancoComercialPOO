package pacote;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Conta {
	
	
	Date dataHoraAtual = new Date();
	String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
	String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	
	ArrayList<String> extrato = new ArrayList<>();
	
	
	private String nomeProprietario;
	private String cpfProprietario;
	private String nomeAgencia;
	private double saldo;
	public static int countAcconter=1;
	
	public Conta(String nomeProprietario, String cpfProprietario, String nomeAgencia, int cc) {
		super();
		this.setNomeProprietario(nomeProprietario);
		this.setCpfProprietario(cpfProprietario);
		this.setNomeAgencia(nomeAgencia);
		this.setSaldo(0);
		this.setNumeroDaConta(cc);
	}
	
	
	public void verificarExtrato() {
		for(int i=0; i<extrato.size(); i++) {
			System.out.println(extrato+"\n");
		}
	}
	public String getNomeAgencia() {
		return nomeAgencia;
	}


	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}


	public void sacar(double valor) {
		if(valor!=0&&valor>this.getSaldo()){
			this.setSaldo(this.getSaldo()-valor);
			extrato.add("Saque de " + valor + " realizado=="
					+ " Data: " + data + "  " +hora);
		}
	}
	public void depositar(Double valor) {
		this.setSaldo(this.getSaldo()+valor);
		extrato.add("deposito de " + valor + " realizado=="
				+ " Data: " + data + "  " +hora);
	}
	
	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getCpfProprietario() {
		return cpfProprietario;
	}

	public void setCpfProprietario(String cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public int getNumeroDaConta() {
		return countAcconter;
	}


	public void setNumeroDaConta(int numeroDaConta) {
		Conta.countAcconter = numeroDaConta;
	}
	
	
}
