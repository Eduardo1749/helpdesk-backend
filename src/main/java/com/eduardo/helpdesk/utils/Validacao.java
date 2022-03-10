package com.eduardo.helpdesk.utils;

public class Validacao {

	public static Boolean cpfEValido(String cpf) {
		if (cpf != null) {
			String cpfSoNumero = cpf.replace(".", "").replace("-", "");
			if (cpfSoNumero.matches("\\d{11}")) {
				int primeiroDigitoVerificador = ((int) cpfSoNumero.charAt(9)) - 48;
				int segundoDigitoVerificador = ((int) cpfSoNumero.charAt(10)) - 48;
				if (getPrimeiroDigito(cpfSoNumero) == primeiroDigitoVerificador
						&& getSegundoDigito(cpfSoNumero) == segundoDigitoVerificador) {
					return true;
				}
			}
		}
		return false;
	}

	private static int getPrimeiroDigito(String cpf) {
		int value = 0;
		int valuePosicao = 0;
		int multiplicador = 10;
		for (int i = 0; i < 9; i++) {
			valuePosicao = ((int) cpf.charAt(i)) - 48;
			value = value + (valuePosicao * multiplicador);
			multiplicador--;
		}
		int primeiroDigito = 11 - (value % 11);
		if (primeiroDigito == 10 || primeiroDigito == 11) {
			return 0;
		} else {
			return primeiroDigito;
		}
	}

	private static int getSegundoDigito(String cpf) {
		int value = 0;
		int valuePosicao = 0;
		int multiplicador = 11;
		for (int i = 0; i < 10; i++) {
			valuePosicao = ((int) cpf.charAt(i)) - 48;
			value = value + (valuePosicao * multiplicador);
			multiplicador--;
		}
		int segundoDigito = 11 - (value % 11);
		if (segundoDigito == 10 || segundoDigito == 11) {
			return 0;
		} else {
			return segundoDigito;
		}
	}

}
