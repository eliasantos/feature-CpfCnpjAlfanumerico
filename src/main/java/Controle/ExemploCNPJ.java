package Controle;

import java.util.Scanner;

public class ExemploCNPJ {

	public static void main(String[] args) {
	    Scanner ler = new Scanner(System.in);

	    System.out.printf("Informe um CNPJ: ");
	    String CNPJ = ler.next();

	    // Remover apenas caracteres especiais, mantendo letras e números
	    CNPJ = CNPJ.replaceAll("[^a-zA-Z0-9]", "");

	    System.out.printf("\nResultado: ");
	    if (ValidaCNPJ.isCNPJ(CNPJ)) { // Verifica se é um CNPJ válido
	        System.out.printf("%s\n", ValidaCNPJ.imprimeCNPJ(CNPJ)); // Só imprime se estiver formatado corretamente
	        System.out.println("Cnpj válido");
	    } else {
	        System.out.printf("Erro, CNPJ inválido !!!\n");
	    }
	}

}
