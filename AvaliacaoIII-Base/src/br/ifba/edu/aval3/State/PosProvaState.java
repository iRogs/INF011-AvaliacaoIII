package br.ifba.edu.aval3.State;

import java.time.Duration;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class PosProvaState implements FaseDaProvaState {

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) {
        boletim.setMinutoPartidaEfetivoInterno(minutoPartidaEfetivo);
    }

    @Override
    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("A prova já foi concluída.");
    }

    @Override
    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("A prova já foi concluída.");
    }

    @Override
    public void registrar(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar passagem de prisma após a chegada.");
    }

    @Override
    public void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("A chegada já foi registrada.");
    }
}