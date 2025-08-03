package br.ifba.edu.aval3.CoR;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.*;


// ConcreteHandler
public class RegraTempoMaximoHandler extends RegraApuracaoHandler {

    // O construtor agora est� correto, recebendo apenas a pr�xima regra.
    public RegraTempoMaximoHandler(RegraApuracaoHandler proxima) {
        super(proxima);
    }

    @Override
    public Duration apurar(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException {
        // Usa o apuradorContexto para obter o tempo m�ximo da prova.
        if (tempoAtual.compareTo(apuradorContexto.getTempoMaximo()) > 0) {
            throw new DNFException("O atleta finalizou a prova, após o tempo limite");
        }
        return passarParaProximo(boletim, tempoAtual, apuradorContexto);
    }
}