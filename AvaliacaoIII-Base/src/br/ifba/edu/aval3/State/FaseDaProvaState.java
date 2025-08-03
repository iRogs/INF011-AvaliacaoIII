package br.ifba.edu.aval3.State;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;


//State
public interface FaseDaProvaState {

    public abstract void apresentarPraLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException;
    public abstract void registrarLargada(BoletimProva boletim) throws AtividadeNaoPermitidaException;
    public abstract void registrar(BoletimProva boletim, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException;
    public abstract void registrarChegada(BoletimProva boletim, Duration tempo) throws AtividadeNaoPermitidaException;
    public abstract void registrarAtrasoPartida(BoletimProva boletim, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException; 
       
}
