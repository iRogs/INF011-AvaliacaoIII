package br.ifba.edu.aval3.State;

import br.ifba.edu.aval.model.BoletimProva;

/**
 * Classe que representa o estado de Pós Prova, onde a prova já foi concluída.
 * Neste estado, não é permitido registrar largada, passagem de prisma ou chegada.
 */
public class PosProvaState extends AbstractFaseDaProvaState {

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) {
        boletim.setMinutoPartidaEfetivoInterno(minutoPartidaEfetivo);
    }
    
}