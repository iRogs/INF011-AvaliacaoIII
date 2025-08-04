package br.ifba.edu.aval3.CoR;

import java.time.Duration;
import br.ifba.edu.aval.model.*;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;

/**
 * Handler: A classe abstrata que define a estrutura da cadeia de responsabilidade.
 * Cada handler na cadeia deve implementar o método apurar para processar o boletim de prova.
 */
public abstract class RegraApuracaoHandler implements ApuracaoHandler{
    
    protected RegraApuracaoHandler proxima;

    public RegraApuracaoHandler(RegraApuracaoHandler proxima) {
        this.proxima = proxima;
    }
    
    // O método apurar recebe o Apurador como contexto.
    public abstract Duration apurar(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException;
    
    // Passa a responsabilidade para o próximo da cadeia.
    protected Duration passarParaProximo(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException {
        if (this.proxima != null) {
            return this.proxima.apurar(boletim, tempoAtual, apuradorContexto);
        }
        return tempoAtual;
    }

}