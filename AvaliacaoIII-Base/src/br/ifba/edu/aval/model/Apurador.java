package br.ifba.edu.aval.model;

import java.time.Duration;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval3.CoR.RegraApuracaoHandler;

public class Apurador {
	
	private Duration tempoMaximo;
    private RegraApuracaoHandler cadeiaDeRegras;

	public Apurador(Duration tempoMaximoProva, RegraApuracaoHandler cadeiaDeRegras) {
		this.tempoMaximo = tempoMaximoProva;
        
        this.cadeiaDeRegras = cadeiaDeRegras;
	}
	
	public Duration getTempoMaximo() {
		return this.tempoMaximo;
	}
	
	public Duration apurar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {
        // O processo de apuração agora é simplesmente iniciar a chamada na cadeia de responsabilidade.
        if(this.cadeiaDeRegras != null) {
            // A chamada inicial passa o "this" como contexto e o tempo base como ZERO.
            return this.cadeiaDeRegras.apurar(boletim, Duration.ZERO, this);
        }
        
        // Comportamento fallback caso nenhuma regra seja definida.
        return boletim.getTempo(Prisma.CHEGADA);
	}	
}