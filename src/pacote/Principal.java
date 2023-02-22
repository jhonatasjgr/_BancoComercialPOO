package pacote;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pacote.Conta;
@SuppressWarnings("unused")
public class Principal {
	public static int countAconter = Conta.countAcconter;
		
	
	@SuppressWarnings({ "null", "unused", "static-access" })
	public static void main(String[] args) {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Conta> contas = new ArrayList<Conta>();
		ArrayList<Agencia> agencias= new ArrayList<Agencia>(10);
	
		
		Agencia ag1 = new Agencia(1, "Bom Jesus");
		agencias.add(ag1);
		Agencia ag2 = new Agencia(2, "Cristino Castro");
		agencias.add(ag2);
		Agencia ag3 = new Agencia(3, "Teresina");
		agencias.add(ag3);
		Agencia ag4 = new Agencia(4, "Corrente");
		agencias.add(ag4);
		Agencia ag5 = new Agencia(5, "Redenção");
		agencias.add(ag5);
		Agencia ag6 = new Agencia(6, "Parnaiba");
		agencias.add(ag6);
		Agencia ag7 = new Agencia(7, "Santa Luz");
		agencias.add(ag7);
		Agencia ag8 = new Agencia(8, "Palmeira");
		agencias.add(ag8);
		Agencia ag9 = new Agencia(9, "Alvorada");
		agencias.add(ag9);
		Agencia ag10 = new Agencia(10, "Colonia");
		agencias.add(ag10);
		
		String op="1000";
		do{
		boolean comparador;
		op = JOptionPane.showInputDialog("   \n"
				+ "(1)Cadastrar usuario\n(2)Criar conta\n(3)Transferir Conta de Agencia\n"
				+ "(4)Encerrar Conta\n(----------------------------------------------------------)\n"
				+ "(5)Depositar\n(6)Sacar\n(7)Transferir\n(8)Saldo\n(9)Extrato\n"
				+ "(----------------------------------------------------------)\n"
				+ "(10)Quantidade de contas/saldo por Agencia\n(11)Lista de contas por Agencia\n(12)Dados do Cliente\n"
				+ "(0)FINALIZAR\n"
				+ "   ", "DIGITE AQUI");
		switch(Integer.parseInt(op)){
		case 1:
			String nome = JOptionPane.showInputDialog("Digite o nome do novo Cliente");
			String cpf = JOptionPane.showInputDialog("Digite o CPF do novo Cliente");
			 comparador=false;
			for (Cliente cl : clientes) {
				comparador = (cl.getCpf().equals(cpf))? true:false;
			}
			if(comparador==true) {
				JOptionPane.showMessageDialog(null,"CPF ja cadastrado", "ERRO", JOptionPane.ERROR_MESSAGE);
			}else {
				Cliente cliente = new Cliente(nome, cpf);
				clientes.add(cliente);
				JOptionPane.showMessageDialog(null, "Cliente " + nome + " cadastrado com sucesso");
			}
			break;
		case 2:
				comparador=false;
				cpf =  JOptionPane.showInputDialog("Digite o cpf do Cliente proprietario da conta");
				nome = null;
				String ag = null;
				for(Cliente cl : clientes) {
					comparador=(cl.getCpf().equals(cpf))? true:false;
					if(comparador==true) {
						cpf=cl.getCpf();
						nome = cl.getNome();
						Object[] ags = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
						Object agsc = JOptionPane.showInputDialog(null, "Escolha uma Agencia", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,ags, ags[0]);
						ag = (String)agsc;
					}
				}
				if(comparador==false) {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado");
				}
				Conta conta = new Conta(nome, cpf, ag,countAconter);
				contas.add(conta);
				if(comparador==true) {
					JOptionPane.showMessageDialog(null, "Conta Criada na agencia de " + ag + "\n"
							+ "PROPRIETARIO: " + nome + "\n"
									+ "CPF: " + cpf + "\n"
											+ "Numero da conta: " + Conta.countAcconter);
				}
				countAconter++;
			break;
		case 3:
			int posicao=0;
			comparador=false;
			String co = JOptionPane.showInputDialog("Digite o numero da Conta em que\n"
					+ "Deseja transferir de Agencia");
			for(Conta cos: contas) {
				comparador = (Integer.parseInt(co)==(cos.countAcconter))? true:false;
			posicao++;
			}
			if(comparador==true) {
				Object[] ags = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
				Object novaag = JOptionPane.showInputDialog(null, "Escolha a nova Agencia", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,ags, ags[0]);
			for(Conta cos : contas) {
				cos.setNomeAgencia((String)novaag);
			}
			JOptionPane.showMessageDialog(null, "Conta alterada para a agencia de " + novaag);
			}else {
				JOptionPane.showMessageDialog(null,"Conta não encontrada");
			}
			break;
		case 4:
			int posi=0;
			String pose = JOptionPane.showInputDialog(null, "Digite o numero da conta que deseja excluir");
			for(Conta cos : contas) {
				if(cos.getNumeroDaConta()==Integer.parseInt(pose)) {
					pose=Integer.toString(posi);
				}
			posi++;
			}
			 try {
			      contas.remove(Integer.parseInt(pose));
			    } catch (IndexOutOfBoundsException e) {
			        System.out.printf("\nErro: posição inválida (%s).",
			          e.getMessage());}
			break;
		case 5:
			co = JOptionPane.showInputDialog(null,"Digite o numero da conta que deseja depositar");
			for(Conta cos : contas) {
				if(cos.getNumeroDaConta()==Integer.parseInt(co)) {
					String valor = JOptionPane.showInputDialog(null,"Quanto deseja Depositar?: \n"
							+ "\nNÃO DIGITE VALOR QUEBRADO\n"
							+ "ESTOU COM PREGUIÇA DE CORRIGIR ESSE ERRO");
					cos.depositar(Double.parseDouble(valor));
					JOptionPane.showMessageDialog(null,"R$"+valor+" depositado na conta de " + cos.getNomeProprietario());
				}
			}
			break;
		case 6:
			co = JOptionPane.showInputDialog(null,"Digite o numero da conta que deseja SACAR");
			for(Conta cos : contas) {
				if(cos.getNumeroDaConta()==Integer.parseInt(co)) {
					String valor = JOptionPane.showInputDialog(null,"Quanto deseja Sacar?: \n"
							+ "Saldo disponivel: " +cos.getSaldo()
							+ "\nNÃO DIGITE VALOR QUEBRADO\n"
							+ "ESTOU COM PREGUIÇA DE CORRIGIR ESSE ERRO");
					if(Double.parseDouble(valor)<cos.getSaldo()) {
						cos.sacar(Double.parseDouble(valor));
						JOptionPane.showMessageDialog(null,"R$"+valor+" sacado na conta de " + cos.getNomeProprietario());
					}else {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente");
					}
				}
			}
			break;
		case 7:
			String cod;
			String valor;
				co = JOptionPane.showInputDialog(null, "Digite o numero da conta proprietaria");
				for(Conta cos:contas) {
					if(Integer.parseInt(co)==cos.getNumeroDaConta()) {
						cod = JOptionPane.showInputDialog(null, "Olá " +cos.getNomeProprietario()
						+"\n Digite o numero da conta remetente");
					for(Conta cos2: contas) {
						if(Integer.parseInt(cod)==cos2.getNumeroDaConta()) {
							 valor = JOptionPane.showInputDialog(null,"Quanto deseja transferir para " + cos2.getNomeProprietario()+"?\n"
									+ "Saldo disponivel: "+cos.getSaldo());
							if(Double.parseDouble(valor)>cos.getSaldo()) {
								cos2.depositar(Double.parseDouble(valor));
								cos.sacar(Double.parseDouble(valor));
								cos.extrato.add("Transferencia de " + valor+ " realizada para conta de "+cos2.getNomeProprietario());
								cos2.extrato.add("Transferencia de "+ valor+" recebida da conta de "+cos.getNomeProprietario());
								JOptionPane.showMessageDialog(null,"Transferencia de R$"+valor+" realizada de "+cos.getNomeProprietario()
								+ " para "+cos2.getNomeProprietario()+
								"\nData: " + cos.data+"  "+cos.hora);
							}else {
								JOptionPane.showMessageDialog(null, "Saldo insuficiente");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Conta destinataria não encontrada");
						}
					}
					}else {
						JOptionPane.showMessageDialog(null, "Conta  não encontrada");
					}
				}
				
			break;
		case 8:
			co = JOptionPane.showInputDialog(null, "Digite o numero da conta que deseja saber o saldo");
			for(Conta cos:contas) {
				if(Integer.parseInt(co)==cos.countAcconter) {
					JOptionPane.showMessageDialog(null, "Saldo: "+cos.getSaldo());
				}
			}
			break;
		case 9:
			co = JOptionPane.showInputDialog(null, "Digite o numero da conta que deseja saber o extrato");
			for(Conta cos:contas) {
				if(Integer.parseInt(co)==cos.countAcconter) {
					int tam =(int)cos.extrato.size();
					for(int i=0; i<tam; i++) {
						JOptionPane.showMessageDialog(null,cos.extrato+"\n");
					}
				} else {
					JOptionPane.showMessageDialog(null,"Conta não encontrada");
				}
			}
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		default:
			JOptionPane.showMessageDialog(null,"OPÇÃO INVALIDA", "ERRO", JOptionPane.ERROR_MESSAGE);
			break;
		case 0:
			break;
		}
		}while(Integer.parseInt(op)!=0);
	
	}
}
