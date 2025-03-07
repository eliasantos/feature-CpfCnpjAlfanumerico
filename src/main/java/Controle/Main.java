package Controle;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		System.out.print("Informe um CPF ou CNPJ: ");
		String documento = ler.next();

		// Remover apenas caracteres especiais, mantendo letras e números
		documento = documento.replaceAll("[^a-zA-Z0-9]", "");

		if (documento.length() == 11) {
			System.out.println("\nResultado:");
			if (ValidadorDocumento.validarCPF(documento)) {
				System.out.println("CPF válido: " + ValidadorDocumento.formatarCPF(documento));
			} else {
				System.out.println("Erro, CPF inválido!");
			}
		} else if (documento.length() == 14) {
			System.out.println("\nResultado:");
			if (ValidadorDocumento.validarCNPJ(documento)) {
				System.out.println("CNPJ válido: " + ValidadorDocumento.formatarCNPJ(documento));
			} else {
				System.out.println("Erro, CNPJ inválido!");
			}
		} else {
			System.out.println("Erro, documento inválido! Informe um CPF (11 dígitos) ou um CNPJ (14 dígitos).");
		}

		ler.close();
	}
}
