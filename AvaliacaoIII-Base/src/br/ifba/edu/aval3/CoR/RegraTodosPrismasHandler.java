package br.ifba.edu.aval3.CoR;

import java.time.Duration;
import java.util.List;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.*;

// ConcreteHandler: Verifica se todos os prismas do percurso foram registrados.
public class RegraTodosPrismasHandler extends RegraApuracaoHandler {

    public RegraTodosPrismasHandler(RegraApuracaoHandler proxima) {
        super(proxima);
    }

    @Override
    public Duration apurar(BoletimProva boletim, Duration tempoAtual, Apurador apuradorContexto) throws DNFException, AtividadeNaoPermitidaException {
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();
        for (Integer prismaId : ordemPrismas) {
            if (prismaId != Prisma.CHEGADA && boletim.getTempo(prismaId) == null) {
                throw new DNFException("Atleta não registrou um dos prismas: " + prismaId);
            }
        }
        return passarParaProximo(boletim, tempoAtual, apuradorContexto);
    }
}