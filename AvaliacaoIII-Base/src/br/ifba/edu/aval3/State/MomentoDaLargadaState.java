package br.ifba.edu.aval3.State;

import java.time.Duration;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;


public class MomentoDaLargadaState implements FaseDaProvaState {

    @Override
    public void apresentarPraLargada(BoletimProva boletim) {
    }

    @Override
    public void registrarLargada(BoletimProva boletim) {
        boletim.transitarPara(new PistaState());
    }

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) {
              
        boletim.setMinutoPartidaEfetivoInterno(minutoPartidaEfetivo);
    }

    @Override
    public void registrar(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar passagem de prisma antes da largada.");
    }

    @Override
    public void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar chegada antes da largada.");
    }
}