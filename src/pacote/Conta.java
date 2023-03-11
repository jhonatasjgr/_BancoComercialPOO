package pacote;

import java.text.SimpleDateFormat;

import java.util.Date;

public class Conta {
	
	
	Date dataHoraAtual = new Date();
	String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
	String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
	
	String extrato;
	
	
	private String nomeProprietario;
	private String cpfProprietario;
	private int numAgencia;
	private double saldo;
	public static int countAcconter;
	
	public Conta(String nomeProprietario, String cpfProprietario, int num, int cc) {
		super();
		this.setNomeProprietario(nomeProprietario);
		this.setCpfProprietario(cpfProprietario);
		this.setNumAgencia(num);
		this.setSaldo(0);
		this.setNumeroDaConta(cc);
	}
	
	public void sacar(double valor) {
		if(valor!=0&&valor<=this.getSaldo()){
			this.setSaldo(this.getSaldo()-valor);
			extrato= extrato + "\nSaque de " + valor + " realizado=="
					+ "Data: " + data + "  " +hora;
		}
	}
	public void depositar(double valor) {
		this.setSaldo(this.getSaldo()+valor);
		extrato=extrato + "\nDeposito de " + valor + " realizado=="
				+ "Data: " + data + "  " +hora;
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

	public int getNumAgencia() {
		return numAgencia;
	}


	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	
	
}
