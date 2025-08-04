package br.ifba.edu.aval3.State;

import java.time.Duration;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

/**
 * Classe que representa o estado de Pista, onde a prova está em andamento.
 * Neste estado, é permitido registrar passagens de prisma e chegada.
 */
public class PistaState extends AbstractFaseDaProvaState {

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

}