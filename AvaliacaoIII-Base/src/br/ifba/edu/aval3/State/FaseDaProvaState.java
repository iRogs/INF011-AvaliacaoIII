package br.ifba.edu.aval3.State;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

/**
 * State: Interface que define os métodos que devem ser implementados pelos estados da prova.
 * Cada estado representa uma fase específica do processo de prova, como Pré Prova, Momento da Largada, Pista e Pós Prova.
 */
public interface FaseDaProvaState {

    public void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException;
    public void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException;
    public void registrar(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException;
    public void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException;
    public void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException; 
       
}