package br.ifba.edu.aval3.State;

import java.time.Duration;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class PreProvaState implements FaseDaProvaState {

    @Override
    public void apresentarPraLargada(BoletimProva boletim) {
        boletim.transitarPara(new MomentoDaLargadaState());
    }

    @Override
    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar largada antes de se apresentar.");
    }

    @Override
    public void registrar(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar passagem de prisma na fase de Pré Prova.");
    }

    @Override
    public void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar chegada na fase de Pré Prova.");
    }

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minuto) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar atraso na fase de Pré Prova.");
    }
}