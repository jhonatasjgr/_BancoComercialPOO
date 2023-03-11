package pacote;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pacote.Conta;
@SuppressWarnings("unused")
public class Principal {
	public static int countAconter = Conta.countAcconter;
		
	
	@SuppressWarnings({ "null", "unused", "static-access" })
	public static void main(String[] args) {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
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
		boolean comparador = false;
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
			for (Cliente cl : clientes) {
				comparador = (cl.getCpf().equals(cpf))? true:false;
			}
			if(comparador==true) {
				JOptionPane.showMessageDialog(null,"CPF ja cadastrado", "ERRO", JOptionPane.ERROR_MESSAGE);
			}else {
				if(nome!=null && cpf!=null) {
				Cliente cliente = new Cliente(nome, cpf);
				clientes.add(cliente);
				JOptionPane.showMessageDialog(null, "Cliente " + nome + " cadastrado com sucesso");
				}
				}
			break;
			
		case 2:
				cpf =  JOptionPane.showInputDialog("Digite o cpf do Cliente proprietario da conta");
				nome = null;
				int num=0;
				String nom = null;
				
				for(Cliente cl : clientes) {
					comparador=(cl.getCpf().equals(cpf))? true:false;
					if(comparador==true) {
						cpf=cl.getCpf();
						nome = cl.getNome();
						Object[] ags = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
						Object agsc = JOptionPane.showInputDialog(null, "Escolha uma Agencia", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,ags, ags[0]);
						for(Agencia a: agencias) {
							if (a.getNomeAgencia().equals(agsc)) {
								num=a.getNumeroAgencia();
								nom=a.getNomeAgencia();
							}
						}
						Conta conta = new Conta(nome, cpf, num, countAconter);
						Agencia.contas.add(conta);
							JOptionPane.showMessageDialog(null, "Conta Criada na agencia de "+ nom +"\n"
									+ "PROPRIETARIO: " + nome + "\n"
											+ "CPF: " + cpf + "\n"
													+ "Numero da conta: " + Conta.countAcconter);
						countAconter++;
					}
				}
				
				if(comparador==false) {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado");
				}
			break;
		case 3:
			num=0;
			int posicao=0;
			comparador=false;
			String co = JOptionPane.showInputDialog("Digite o numero da Conta em que\n"
						+ "Deseja transferir de Agencia");
			for(Conta cos: Agencia.contas) {
			comparador = (Integer.parseInt(co)==(cos.getNumeroDaConta()))? true:false;
			posicao++;
			}
			if(comparador==true) {
				Object[] ags = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
				Object novaag = JOptionPane.showInputDialog(null, "Escolha a nova Agencia", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,ags, ags[0]);
				for(Agencia a: agencias) {
					if(a==novaag) {
					num = a.getNumeroAgencia();
					}
				}
				for(Conta cos : Agencia.contas) {
				cos.setNumAgencia(num);
			}
			JOptionPane.showMessageDialog(null, "Conta alterada para a agencia de " + novaag);
			} else {
				JOptionPane.showMessageDialog(null,"Conta não encontrada");
			}
			break;
		case 4:
			int posi=0;
			String pose = JOptionPane.showInputDialog(null, "Digite o numero da conta que deseja excluir");
			for(Conta cos : Agencia.contas) {
				if(cos.getNumeroDaConta()==Integer.parseInt(pose)) {
					pose=Integer.toString(posi);
				}
			posi++;
			}
			 try {
				 Agencia.contas.remove(Integer.parseInt(pose));
				 JOptionPane.showMessageDialog(null,"Conta excluida com sucesso");
			    } catch (IndexOutOfBoundsException e) {
			    	 JOptionPane.showMessageDialog(null,"Conta inexistente");
			    }
			break;
		case 5:
			co = JOptionPane.showInputDialog(null,"Digite o numero da conta que deseja depositar");
			for(Conta cos : Agencia.contas) {
				if(cos.getNumeroDaConta()==Integer.parseInt(co)){
					String valor = JOptionPane.showInputDialog(null,"Quanto deseja Depositar?: \n"
							+ "\nNÃO DIGITE VALOR QUEBRADO\n"
							+ "ESTOU COM PREGUIÇA DE converter");
					cos.depositar(Double.parseDouble(valor));
					JOptionPane.showMessageDialog(null,"R$"+valor+" depositado na conta de " + cos.getNomeProprietario());
				} else {
					
				}
			}
				
			
			break;
		case 6:
			int cccc = 0;
			int ccc = 0;
			co = JOptionPane.showInputDialog(null,"Digite o numero da conta que deseja SACAR");
			for(Conta cos : Agencia.contas) {
				if(cos.getNumeroDaConta()==Integer.parseInt(co)) {
					String valor = JOptionPane.showInputDialog(null,"Quanto deseja Sacar?: \n"
							+ "Saldo disponivel: " +cos.getSaldo()
							+ "\nNÃO DIGITE VALOR QUEBRADO\n"
							+ "ESTOU COM PREGUIÇA DE converter");
					if(Double.parseDouble(valor)<=cos.getSaldo()) {
						cos.sacar(Double.parseDouble(valor));
						JOptionPane.showMessageDialog(null,"R$"+valor+" sacado na conta de " + cos.getNomeProprietario());
					}
				}
			}
			
			break;
		case 7:
			String cod;
			String valor;
				co = JOptionPane.showInputDialog(null, "Digite o numero da conta remetente");
				for(Conta cos: Agencia.contas) {
					if(Integer.parseInt(co)==cos.getNumeroDaConta()) {
						cod = JOptionPane.showInputDialog(null, "Olá " +cos.getNomeProprietario()
						+"\n Digite o numero da conta destinataria");
					for(Conta cos2: Agencia.contas) {
						if(Integer.parseInt(cod)==cos2.getNumeroDaConta()) {
							 valor = JOptionPane.showInputDialog(null,"Quanto deseja transferir para " + cos2.getNomeProprietario()+"?\n"
									+ "Saldo disponivel: "+cos.getSaldo());
							if(Double.parseDouble(valor)>cos.getSaldo()) {
								cos2.depositar(Double.parseDouble(valor));
								cos.sacar(Double.parseDouble(valor));
								cos.extrato=cos.extrato + "Transferencia de " + valor+ " realizada para conta de "+cos2.getNomeProprietario();
								cos2.extrato=cos2.extrato + "Transferencia de "+ valor+" recebida da conta de "+cos.getNomeProprietario();
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
			for(Conta cos: Agencia.contas) {
				if(Integer.parseInt(co)==cos.countAcconter) {
					JOptionPane.showMessageDialog(null, "Saldo: "+cos.getSaldo());
				}
			}
			break;
		case 9:
			co = JOptionPane.showInputDialog(null, "Digite o numero da conta que deseja saber o extrato");
			for(Conta cos: Agencia.contas) {
				if(Integer.parseInt(co)==cos.countAcconter) {
					JOptionPane.showMessageDialog(null,cos.extrato);
				} else {
					JOptionPane.showMessageDialog(null,"Conta não encontrada");
				}
			}
			break;
		case 10:	
			int nContas = 0;
			double sContas = 0;
			int nAgencia;
			Object[] agg = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
			Object novaagg = JOptionPane.showInputDialog(null, "Escolha a nova Agencia para saber as informações", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,agg, agg[0]);
			for(Agencia a: agencias) {
				if(novaagg==a.getNomeAgencia()) {
					nAgencia=a.getNumeroAgencia();
					for(Conta c: Agencia.contas) {
						if(nAgencia==c.getNumAgencia()) {
							sContas=sContas+c.getSaldo();
							nContas++;	
						}
					}
				}
			}
			
			JOptionPane.showMessageDialog(null, "Agencia "+novaagg+"\nSaldo na Agencia: "+ sContas+"\nNumero de contas: "+nContas);
			break;
		case 11:
			int nnContas = 0;
			double ssContas = 0;
			int nnAgencia;
			String nonom;
			String noCpf;
			int noConta;
			String dados = "";
			Object[] aggg = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
			Object novaaggg = JOptionPane.showInputDialog(null, "Escolha a nova Agencia para saber as informações", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,aggg, aggg[0]);
			for(Agencia a: agencias) {
				if(novaaggg==a.getNomeAgencia()) {
					nnAgencia=a.getNumeroAgencia();
					for(Conta c: Agencia.contas) {
						if(nnAgencia==c.getNumAgencia()) {
							nonom=c.getNomeProprietario();
							noCpf=c.getCpfProprietario();
							noConta=c.getNumeroDaConta();
							dados=dados+"\nNumero da conta: "+noConta+"\nProprietario: "+nonom+"\nCPF do proprietario: "+noCpf+"\n";
						}
					}
				}
			}
			JOptionPane.showMessageDialog(null, dados);
			break;
		case 12:
			String cliente = "DADOS DOS CLIENTES\n";
			for(Cliente cli: clientes) {
				cliente = cliente+" Nome: "+cli.getNome()+"   CPF: "+cli.getCpf()+"\n";
			}
			JOptionPane.showMessageDialog(null,cliente);
			
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