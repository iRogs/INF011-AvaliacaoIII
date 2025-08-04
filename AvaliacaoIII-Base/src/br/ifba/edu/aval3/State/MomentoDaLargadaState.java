package br.ifba.edu.aval3.State;

import br.ifba.edu.aval.model.BoletimProva;

/**
 * Classe que representa o estado de Momento da Largada, onde o boletim foi apresentado
 * e a largada pode ser registrada.
 * Neste estado, é permitido registrar a largada e atrasos na partida.
 */
public class MomentoDaLargadaState extends AbstractFaseDaProvaState {

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

}