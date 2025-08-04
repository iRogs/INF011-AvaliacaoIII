package br.ifba.edu.aval3.CoR;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.*;

/**
 * ConcreteHandler: Modifica o tempo de prova, aplicando a penalidade de atraso.
 * Se o atleta tiver minutos de atraso, adiciona essa penalidade ao tempo atual.
 */
public class RegraPenalidadeAtrasoHandler extends RegraApuracaoHandler {

    public RegraPenalidadeAtrasoHandler(RegraApuracaoHandler proxima) {
        super(proxima);
    }

    @Override
    public Duration apurar(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException {
        long minutosAtraso = boletim.getMinutosAtraso();
        Duration tempoComPenalidade = tempoAtual.plus(Duration.ofMinutes(minutosAtraso));
        
        System.out.println("[RegraAtraso] Aplicando penalidade de " + minutosAtraso + " minutos ao atleta " + boletim.cboNumero());

        return passarParaProximo(boletim, tempoComPenalidade, apuradorContexto);
    }
    
}