package br.ifba.edu.aval3.CoR;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.Apurador;
import br.ifba.edu.aval.model.BoletimProva;

/**
 * Interface que define o método para a cadeia de responsabilidade de apuração.
 * Cada handler na cadeia deve implementar este método para processar o boletim de prova.
 */
public interface ApuracaoHandler {

    public Duration apurar(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException;

}