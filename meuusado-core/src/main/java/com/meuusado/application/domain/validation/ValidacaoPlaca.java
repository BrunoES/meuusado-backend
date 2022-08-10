package com.meuusado.application.domain.validation;

import com.meuusado.application.domain.Placa;

public interface ValidacaoPlaca {

    Boolean validar(Placa placa) throws Exception;

}
