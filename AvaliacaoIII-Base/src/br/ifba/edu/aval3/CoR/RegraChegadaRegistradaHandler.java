package br.ifba.edu.aval3.CoR;

import java.time.Duration;
import br.ifba.edu.aval.model.*;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;

/**
 * ConcreteHandler: Primeira e mais fundamental regra, verifica se o atleta completou a prova.
 * Se o atleta não registrou a chegada, lança uma exceção DNFException.
 */
public class RegraChegadaRegistradaHandler extends RegraApuracaoHandler {

    public RegraChegadaRegistradaHandler(RegraApuracaoHandler proxima) {
        super(proxima);
    }

    @Override
    public Duration apurar(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException {
        Duration tempoChegada = boletim.getTempo(Prisma.CHEGADA);
        if (tempoChegada == null) {
            throw new DNFException("Atleta não registrou chegada");
        }
        // Se a chegada foi registrada, passa para a próxima regra com o tempo de chegada como base.
        return passarParaProximo(boletim, tempoChegada, apuradorContexto);
    }
    
}