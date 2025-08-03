package br.ifba.edu.aval3.State;

import java.time.Duration;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class PistaState implements FaseDaProvaState {

    @Override
    public void registrar(BoletimProva boletim, Integer prismaID, Duration tempo) {
        boletim.getPassagensInterno().registrarPassagem(prismaID, tempo);
    }

    @Override
    public void registrarChegada(BoletimProva boletim, Duration tempo) {
        boletim.getPassagensInterno().registrarPassagem(Prisma.CHEGADA, tempo);
        boletim.transitarPara(new PosProvaState());
    }

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minuto) {
        boletim.setMinutoPartidaEfetivoInterno(minuto);
    }

    @Override
    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Fase não permite se apresentar pra largada.");
    }

    @Override
    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Atleta já largou.");
    }
}