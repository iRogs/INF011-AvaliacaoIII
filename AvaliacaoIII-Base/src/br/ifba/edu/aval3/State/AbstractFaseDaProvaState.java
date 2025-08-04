package br.ifba.edu.aval3.State;

import java.time.Duration;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

/**
 * Classe abstrata que implementa o comportamento padrão para todos os estados.
 * Define métodos que lançam exceções padrão quando chamados, indicando que a operação não é permitida na fase atual da prova.
 */
public abstract class AbstractFaseDaProvaState implements FaseDaProvaState {

    protected void lancaExcecaoPadrao() throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Esta operação não é permitida na fase atual da prova.");
    }

    @Override
    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        lancaExcecaoPadrao();
    }

    @Override
    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException {
        lancaExcecaoPadrao();
    }

    @Override
    public void registrar(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        lancaExcecaoPadrao();
    }

    @Override
    public void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException {
        lancaExcecaoPadrao();
    }

    @Override
    public void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
        lancaExcecaoPadrao();
    }

}