package pacote;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pacote.Conta;
@SuppressWarnings("unused")
public class Principal {
	public static int countAconter=1;
		
	

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Conta conta;
		Cliente cliente;
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
			boolean comparador;
			comparador=false;
			String nome = JOptionPane.showInputDialog("Digite o nome do novo Cliente");
			String cpf = JOptionPane.showInputDialog("Digite o CPF do novo Cliente");
			for (Cliente cl : clientes) {
				comparador = (cl.getCpf().equals(cpf))? true:false;
			}
			if(comparador==true) {
				JOptionPane.showMessageDialog(null,"CPF ja cadastrado", "ERRO", JOptionPane.ERROR_MESSAGE);
			}else {
				if(nome!=null && cpf!=null) {
				cliente = new Cliente(nome, cpf);
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
				boolean t1=false;
				for(Cliente cl : clientes) {
					if(Integer.parseInt(cl.getCpf())==Integer.parseInt(cpf)){
						t1=true;
						cpf=cl.getCpf();
						nome = cl.getNome();
						Object[] ags = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
						Object agsc = JOptionPane.showInputDialog(null, "Escolha uma Agencia", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,ags, ags[0]);
						for(Agencia a: agencias){
							if (a.getNomeAgencia().equals(agsc)) {
								num=a.getNumeroAgencia();
								nom=a.getNomeAgencia();
							}
						}
						conta = new Conta(nome, cpf, num);
						Agencia.contas.add(conta);
							JOptionPane.showMessageDialog(null, "Conta Criada na agencia de "+ nom +"\n"
									+ "PROPRIETARIO: " + nome + "\n"
											+ "CPF: " + cpf + "\n"
													+ "Numero da conta: " + countAconter);
							countAconter++;
						}
					}
				if(t1==false) {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			break;
		case 3:
			num=0;
			int posicao=0;
			boolean t=false;
			String co = JOptionPane.showInputDialog("Digite o numero da Conta em que\n"
						+ "Deseja transferir de Agencia");
			for(Conta cos: Agencia.contas) {
				if(Integer.parseInt(co)==(cos.getNumeroDaConta())) {
					t=true;
					Object[] ags = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
					Object novaag = JOptionPane.showInputDialog(null, "Escolha a nova Agencia", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,ags, ags[0]);
					for(Agencia a: agencias) {
						if(a.getNomeAgencia()==novaag) {
							num = a.getNumeroAgencia();
							cos.setNumAgencia(num);
						}
					}
			JOptionPane.showMessageDialog(null, "Conta alterada para a agencia de " + novaag);
			}
			} 
			if(t==false) {
				JOptionPane.showMessageDialog(null,"Conta não encontrada", "ERRO", JOptionPane.ERROR_MESSAGE);
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
			    	 JOptionPane.showMessageDialog(null,"Conta inexistente", "ERRO", JOptionPane.ERROR_MESSAGE);
			    }
			break;
		case 5:
			t=false;
			co = JOptionPane.showInputDialog(null,"Digite o numero da conta que deseja depositar");
			for(Conta cos : Agencia.contas) {
				if(cos.getNumeroDaConta()==Integer.parseInt(co)){
					t=true;
					String valor = JOptionPane.showInputDialog(null,"Conta: "+cos.getNumeroDaConta()+"\nProprietario"
					+cos.getNomeProprietario()+"\nQuanto deseja Depositar?");
					cos.depositar(Double.parseDouble(valor));
					JOptionPane.showMessageDialog(null,"R$"+valor+" depositado na conta de " + cos.getNomeProprietario());
					cos.extrato+="\nDeposito de R$" + valor + " realizado  "
							+ "Data: " + cos.data + "  " + cos.hora+".";
			}
			} if(t==false) {
				JOptionPane.showMessageDialog(null, "Conta não encontrada", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 6:
			int cccc = 0;
			int ccc = 0;
			t=false;
			co = JOptionPane.showInputDialog(null,"Digite o numero da conta que deseja SACAR");
			for(Conta cos : Agencia.contas) {
				if(cos.getNumeroDaConta()==Integer.parseInt(co)) {
					t=true;
					t=true;
					String valor = JOptionPane.showInputDialog(null,"Conta: "+cos.getNumeroDaConta()+
							"\nProprietario"+cos.getNomeProprietario()
							+"\nQuanto deseja Sacar?: \n"
							+ "Saldo disponivel: " +cos.getSaldo());
					if(Double.parseDouble(valor)<=cos.getSaldo()) {
						cos.sacar(Double.parseDouble(valor));
						JOptionPane.showMessageDialog(null,"R$"+valor+" sacado na conta de " + cos.getNomeProprietario());
						cos.extrato+= "\nSaque de R$" + valor + " realizado  "
								+ "Data: " + cos.data + "  " + cos.hora+".";
					}else {
						JOptionPane.showMessageDialog(null,"Saldo insuficiente", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
			} 
			if(t==false) {
				JOptionPane.showMessageDialog(null, "Conta não encontrada", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			break;
		case 7:
			String cod;
			String valor;
			t=false;
			boolean t2=false;
			boolean t3=false;
				co = JOptionPane.showInputDialog(null, "Digite o numero da conta remetente");
				for(Conta cos: Agencia.contas) {
					if(Integer.parseInt(co)==cos.getNumeroDaConta()) {
						t=true;
						cod = JOptionPane.showInputDialog(null, "Olá " +cos.getNomeProprietario()
						+"\n Digite o numero da conta destinataria");
					for(Conta cos2: Agencia.contas) {
						if(Integer.parseInt(cod)==cos2.getNumeroDaConta()&&Integer.parseInt(cod)!=Integer.parseInt(co)) {
							 valor = JOptionPane.showInputDialog(null,"Olá" +cos.getNomeProprietario()+".\nQuanto deseja transferir para " + cos2.getNomeProprietario()+"?\n"
									+ "Saldo disponivel: "+cos.getSaldo());
							if(Double.parseDouble(valor)<=cos.getSaldo()) {
								cos2.depositar(Double.parseDouble(valor));
								cos.sacar(Double.parseDouble(valor));
								cos.extrato=cos.extrato + "\nTransferencia de R$" + valor+ " realizada para conta de "+cos2.getNomeProprietario()+
										"  Data: "+cos.data+"  Hora: "+cos.hora+".";
								cos2.extrato=cos2.extrato + "\nTransferencia de R$"+ valor+" recebida da conta de "+cos.getNomeProprietario()+
										"  Data: "+cos.data+"  Hora: "+cos.hora+".";
								JOptionPane.showMessageDialog(null,"\nTransferencia de R$"+valor+" realizada de "+cos.getNomeProprietario()
								+ " para "+cos2.getNomeProprietario()+
								"\nData: " + cos.data+"  Hora: "+cos.hora+".");
							}else {
								JOptionPane.showMessageDialog(null, "Saldo insuficiente");
							}
						}
						if(Integer.parseInt(cod)==cos2.getNumeroDaConta()){
							t2=true;
						}
						if(Integer.parseInt(cod)==Integer.parseInt(co)) {
							t3=true;
						}
					}
					}
				}
				if(t==false) {
					JOptionPane.showMessageDialog(null, "Conta  não encontrada","ERRO", JOptionPane.ERROR_MESSAGE);
				}
				if(t2=false) {
					JOptionPane.showMessageDialog(null, "Conta destinataria não encontrada");
				}
				if(t3=false) {
					JOptionPane.showMessageDialog(null, "Não é possivel tranferir para a mesma conta", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			break;
		case 8:
			t=false;
			co = JOptionPane.showInputDialog(null, "Digite o numero da conta que deseja saber o saldo");
			for(Conta cos: Agencia.contas) {
				if(Integer.parseInt(co)==cos.getNumeroDaConta()) {
					JOptionPane.showMessageDialog(null, "Saldo: "+cos.getSaldo());
					t=true;
				}
			}
			if(t==false) {
				JOptionPane.showMessageDialog(null,"Conta não encontrada", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 9:
			t=false;
			co = JOptionPane.showInputDialog(null, "Digite o numero da conta que deseja saber o extrato");
			for(Conta cos: Agencia.contas) {
				if(Integer.parseInt(co)==cos.getNumeroDaConta()) {
					t=true;
					JOptionPane.showMessageDialog(null,cos.extrato);
			}
			} if(t==false) {
				JOptionPane.showMessageDialog(null,"Conta não encontrada","ERRO",JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		case 10:	
			int nContas = 0;
			double sContas = 0;
			int nAgencia = 0;
			Object[] agg = {ag1.getNomeAgencia(),ag2.getNomeAgencia(),ag3.getNomeAgencia(),ag4.getNomeAgencia(),ag5.getNomeAgencia(),ag6.getNomeAgencia(),ag7.getNomeAgencia(),ag8.getNomeAgencia(),ag9.getNomeAgencia(),ag10.getNomeAgencia(),};
			Object novaagg = JOptionPane.showInputDialog(null, "Escolha a nova Agencia para saber as informações", "Agencias", JOptionPane.INFORMATION_MESSAGE,null,agg, agg[0]);
			for(Agencia agen: agencias){
				if(novaagg==agen.getNomeAgencia()) {
					nAgencia=agen.getNumeroAgencia();
					for(Conta agenc: Agencia.contas) {
						if(agenc.getNumAgencia()==nAgencia) {
							nContas++;
							sContas+=agenc.getSaldo();
						}
					}
				}
			}
			if(nContas!=0) {
				JOptionPane.showMessageDialog(null, "AGENCIA: "+novaagg+"\nSALDO DA AGENCIA: "+sContas+
						"\n NUMERO DE CONTAS: "+nContas);
			}else {
				JOptionPane.showMessageDialog(null, "ESSA AGENCIA NÃO POSSUI NENHUMA CONTA","ERRO",JOptionPane.ERROR_MESSAGE);
			}
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
			for(Agencia agen: agencias){
				if(novaaggg==agen.getNomeAgencia()) {
					nnAgencia=agen.getNumeroAgencia();
					for(Conta agenc: Agencia.contas) {
						if(agenc.getNumAgencia()==nnAgencia) {
							nonom=agenc.getNomeProprietario();
							noCpf=agenc.getCpfProprietario();
							noConta=agenc.getNumeroDaConta();
							dados=dados+"\nNumero da conta: "+noConta+"\nProprietario: "+nonom+"\nCPF do proprietario: "+noCpf+".\n";
							nnContas++;
						}
					}
				}
			}
			if(nnContas!=0) {
			JOptionPane.showMessageDialog(null, dados);
			}else {
				JOptionPane.showMessageDialog(null, "Essa Agencia não possui Conta", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		case 12:
			String clienteD = "DADOS DOS CLIENTES\n";
			for(Cliente cli: clientes) {
				clienteD = clienteD+" Nome: "+cli.getNome()+"   CPF: "+cli.getCpf()+".\n";
			}
			JOptionPane.showMessageDialog(null,clienteD);
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