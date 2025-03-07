package Controle;

import java.util.InputMismatchException;

public class ValidadorDocumento {

	// Método para validar CPF
	public static boolean validarCPF(String CPF) {
		CPF = CPF.replaceAll("[^0-9]", ""); // Remove caracteres não numéricos

		if (CPF.length() != 11 || CPF.matches("(\\d)\\1{10}"))
			return false;

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm += (num * peso);
				peso--;
			}

			r = 11 - (sm % 11);
			dig10 = (r == 10 || r == 11) ? '0' : (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm += (num * peso);
				peso--;
			}

			r = 11 - (sm % 11);
			dig11 = (r == 10 || r == 11) ? '0' : (char) (r + 48);

			return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	// Método para validar CNPJ (usando o cálculo fornecido por você)
	public static boolean validarCNPJ(String CNPJ) {
		// Remover apenas caracteres especiais, mantendo letras e números
		CNPJ = CNPJ.replaceAll("[^a-zA-Z0-9]", "");

		if (CNPJ.length() != 14 || CNPJ.matches("(\\d)\\1{13}"))
			return false;

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
			// Cálculo do 1º dígito verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm += (num * peso);
				peso++;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			dig13 = (r == 0 || r == 1) ? '0' : (char) ((11 - r) + 48);

			// Cálculo do 2º dígito verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm += (num * peso);
				peso++;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			dig14 = (r == 0 || r == 1) ? '0' : (char) ((11 - r) + 48);

			// Verifica se os dígitos calculados conferem com os informados
			return (dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13));
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	// Método para formatar CPF (XXX.XXX.XXX-XX)
	public static String formatarCPF(String CPF) {
		return CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
	}

	// Método para formatar CNPJ (XX.XXX.XXX/XXXX-XX)
	public static String formatarCNPJ(String CNPJ) {
		return CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "/"
				+ CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14);
	}
}
