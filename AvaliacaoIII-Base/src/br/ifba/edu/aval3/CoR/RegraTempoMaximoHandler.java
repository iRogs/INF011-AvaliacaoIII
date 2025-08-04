package br.ifba.edu.aval3.CoR;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.*;

/**
 * ConcreteHandler: Modifica o tempo de prova, aplicando a regra do tempo máximo.
 * Se o tempo atual exceder o tempo máximo definido no Apurador, lança uma exceção DNFException.
 */
public class RegraTempoMaximoHandler extends RegraApuracaoHandler {

    public RegraTempoMaximoHandler(RegraApuracaoHandler proxima) {
        super(proxima);
    }

    @Override
    public Duration apurar(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException {
        // Usa o apuradorContexto para obter o tempo máximo da prova.
        if (tempoAtual.compareTo(apuradorContexto.getTempoMaximo()) > 0) {
            throw new DNFException("O atleta finalizou a prova, após o tempo limite");
        }
        return passarParaProximo(boletim, tempoAtual, apuradorContexto);
    }
    
}