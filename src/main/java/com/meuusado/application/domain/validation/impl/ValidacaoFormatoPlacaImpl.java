package com.meuusado.application.domain.validation.impl;

import com.meuusado.application.domain.Placa;
import com.meuusado.application.domain.validation.ValidacaoPlaca;

public class ValidacaoFormatoPlacaImpl implements ValidacaoPlaca  {
    @Override
    public Boolean validar(Placa placa) throws Exception{
        return true;
    }
}
