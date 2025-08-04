package br.ifba.edu.aval3.State;

import br.ifba.edu.aval.model.BoletimProva;

/**
 * Classe que representa o estado de Pré Prova, onde o boletim ainda não foi apresentado.
 * Neste estado, não é permitido registrar largada, passagem de prisma ou chegada.
 */
public class PreProvaState extends AbstractFaseDaProvaState {

    @Override
    public void apresentarPraLargada(BoletimProva boletim) {
        boletim.transitarPara(new MomentoDaLargadaState());
    }

}