package com.meuusado.application.services;

import com.meuusado.application.domain.Placa;
import com.meuusado.application.domain.validation.ValidacaoPlaca;
import com.meuusado.application.domain.validation.impl.ValidacaoFormatoPlacaImpl;
import com.meuusado.application.domain.validation.impl.ValidacaoTamanhoPlacaImpl;

import java.util.ArrayList;
import java.util.List;

public class PlacaServiceImpl {

	private List<ValidacaoPlaca> validacoesPlaca;

	public PlacaServiceImpl(List<ValidacaoPlaca> validacoesPlaca) {
		this.validacoesPlaca = validacoesPlaca;
	}

	public Boolean valida(Placa placa) throws Exception{
		for (ValidacaoPlaca validacaoPlaca : validacoesPlaca) {
			validacaoPlaca.validar(placa);
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		Placa placa = new Placa("ADC1234");

		List<ValidacaoPlaca> validacoesPlaca = new ArrayList<>();
		validacoesPlaca.add(new ValidacaoTamanhoPlacaImpl());
		validacoesPlaca.add(new ValidacaoFormatoPlacaImpl());

		PlacaServiceImpl placaService = new PlacaServiceImpl(validacoesPlaca);
		placaService.valida(placa);
	}

}
