package br.ifba.edu.aval3.CoR;

import java.time.Duration;
import java.util.List;
import br.ifba.edu.aval.model.*;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;

// ConcreteHandler: Verifica se os prismas foram visitados na ordem correta.
public class RegraOrdemPrismasHandler extends RegraApuracaoHandler {

    public RegraOrdemPrismasHandler(RegraApuracaoHandler proxima) {
        super(proxima);
    }

    @Override
    public Duration apurar(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException {
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();
        for (int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
            Duration anterior = boletim.getTempo(ordemPrismas.get(iCont));
            Duration atual = boletim.getTempo(ordemPrismas.get(iCont + 1));
            if (anterior != null && atual != null) {
                if (anterior.compareTo(atual) > 0) {
                    throw new DNFException("Atleta registrou prisma fora da ordem");
                }
            }
        }
        return passarParaProximo(boletim, tempoAtual, apuradorContexto);
    }
}