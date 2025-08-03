package br.ifba.edu.aval3.CoR;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.Apurador;
import br.ifba.edu.aval.model.BoletimProva;

public interface Handler {
    Duration apurar(BoletimProva x1, Duration x2, Apurador x3) throws DNFException, AtividadeNaoPermitidaException;
}
