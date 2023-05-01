package ProjetoBanco;

public class ContaEspecial extends Conta {
	
	protected int numero, movimentos=0, opcao=0;
	protected double saldo=0, valor=0;
	boolean ativo, validaDebito = false, validaCredito = false;	
	double limite;

	public ContaEspecial(int numero, String cpf, double saldo, boolean ativo, double limite) {
		super(numero, cpf, saldo, ativo);
		this.limite = limite;
		
		System.out.println("CONTA ESPECIAL");
		
	}
	
	public double usarLimite (double valor) {
		if(saldo <= 0){
			limite = this.limite - valor;
			saldo = getSaldo() + valor;
			System.out.println("LIMITE RESTANTE: R$ " + limite);
		}
		return saldo;
	}
	
@Override
public double credito(double valor) {
	
	while (validaCredito == false ) {
		if (valor > 0) {
			saldo = getSaldo() + valor;
			validaCredito = true;
			movimentos ++;
		} else {
			System.out.println("NÃO É PERMITIDO CRÉDITO DE r$ 0,00 REAIS");
			System.out.println("DIGITE 1 PARA SAIR OU 2 PARA DIGITAR O VALOR NOVAMENTE\n");
			opcao = input.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("VOCÊ DIGITOU SAIR");
				System.out.println("VOLTE SEMPRE!" +"\n"+ "RiVER BANK - O BANCO QUE TE DESAFOGA");
				System.exit(0);
			default:
				if(opcao==2) {
				validaCredito = false;
				} else {
					System.out.println("OPÇÃO INVÁLIDA");
				}
				
			}

		}
	}
	return saldo;

}
public double debito (double valor) {
	while (validaDebito == false ) {
		if (saldo == 0 || saldo < valor) {
			System.out.println("NÃO É POSSÍVEL REALIZAR A OPERAÇÃO" + "\n" + "SALDO INSUFICIENTE"+ "\n" + "DIGITE 1 PARA SAIR OU 2 PARA DIGITAR O VALOR NOVAMENTE\n");
			opcao = input.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("VOCÊ DIGITOU SAIR");
				System.out.println("VOLTE SEMPRE!" +"\n"+ "RiVER BANK - O BANCO QUE TE DESAFOGA");
				System.exit(0);
			default:
				if(opcao==2) {
				validaCredito = false;
				} else {
					System.out.println("OPÇÃO INVÁLIDA\n");
				}
			}
				} else {
					validaDebito = true;
				}
		}
	return saldo;
}

}