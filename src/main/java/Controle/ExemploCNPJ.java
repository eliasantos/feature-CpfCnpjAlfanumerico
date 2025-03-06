package Controle;

import java.util.Scanner;

public class ExemploCNPJ {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		String CNPJ;

		System.out.printf("Informe um CNPJ: ");
		CNPJ = ler.next();

		System.out.printf("\nResultado: ");
//usando os métodos isCNPJ() e imprimeCNPJ() da classe "ValidaCNPJ"
		if (ValidaCNPJ.isCNPJ(CNPJ) == true) {
			System.out.printf("%s\n", ValidaCNPJ.imprimeCNPJ(CNPJ));
			System.out.println("Cnpj válido");
		} else {
			System.out.printf("Erro, CNPJ inválido !!!\n"); 
		}
	}

}
