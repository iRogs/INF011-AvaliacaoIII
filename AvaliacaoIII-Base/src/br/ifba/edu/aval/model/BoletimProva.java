package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval1.prototype.ListaPassagens;
import br.ifba.edu.aval3.State.FaseDaProvaState;
import br.ifba.edu.aval3.State.PreProvaState;

// Context: Gerencia o estado atual e delega as chamadas para ele.
public class BoletimProva {
	
	public String cboNumero;
	public ListaPassagens passagens;
	public Long minutoPartidaPrevisto;
	public Long minutoPartidaEfetivo;
	
	private FaseDaProvaState faseAtual;
	
	public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
		this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
		this.faseAtual = new PreProvaState(); 
	}
	
	public void transitarPara(FaseDaProvaState novoEstado) {
		this.faseAtual = novoEstado;
	}
	
	public ListaPassagens getPassagensInterno() {
		return this.passagens;
	}
	
	public void setMinutoPartidaEfetivoInterno(Long minuto) {
		this.minutoPartidaEfetivo = minuto;
	}
	
	public List<Integer> getOrdemPrismas() {
		return this.passagens.getOrdemPassagem();
	}
	
	public String cboNumero() {
		return this.cboNumero;
	}
	
	public Duration getTempo(Integer prismaID) {
		return this.passagens.getTempo(prismaID);
	}
	
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		this.faseAtual.apresentarPraLargada(this);
	}
	
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		this.faseAtual.registrarLargada(this);
	}
	
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		this.faseAtual.registrar(this, prismaID, tempo);
	}
	
	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		this.faseAtual.registrarChegada(this, tempo);
	}
	
	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		this.faseAtual.registrarAtrasoPartida(this, minutoPartidaEfetivo);
	}

	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		if(this.minutoPartidaEfetivo >= this.minutoPartidaPrevisto)
			return minutoPartidaEfetivo - minutoPartidaPrevisto;
		throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso");
	}	
	
	@Override
	public String toString() {
		return "BoletimProva [cboNumero=" + cboNumero + ", passagens=" + passagens + "]";
	}
}