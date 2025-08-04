## Integrantes:

    - Iainara Cerqueira dos Santos
    - Raí Salomão Alves Mangueira
    - Rodrigo Ansah Carvalho Frempong

## Padrões utilizados e justificativa:

### Questão 1 - Padrão State:

- **Justificativa:** O padrão State foi escolhido porque ele permite que um objeto altere seu comportamento quando seu estado interno muda, fazendo com que o objeto pareça ter mudado de classe. A classe BoletimProva precisa executar ações diferentes (como registrar largada, chegada, passagens) dependendo da fase da prova em que o atleta se encontra. Ao encapsular os comportamentos específicos de cada fase em objetos de estado separados, eliminamos a necessidade de condicionais.

    <ins>Context:</ins> BoletimProva 
    <ins>State:</ins> AbstractFaseDaProvaState (Classe Abstrata) e FaseDaProvaState (Interface)
    <ins>ConcreteState(s):</ins> 
        - MomentoDaLargadaState: Representa o estado de Momento da Largada, onde o boletim foi apresentado e a largada pode ser registrada.
        - PistaState: Representa o estado de Pista, onde a prova está em andamento.
        - PosProvaState: Representa o estado de Pós Prova, onde a prova já foi concluída.
        - PreProvaState: Representa o estado de Pré Prova, onde o boletim ainda não foi apresentado.
            
### Questão 2 - Padrão Chain Of Responsability:

- **Justificativa:** O padrão permite construir uma cadeia de objetos de processamento (as regras de apuração). Cada regra é encapsulada em seu próprio objeto "handler". Quando o método apurar do Apurador é invocado, ele passa o BoletimProva para o primeiro handler da cadeia. Este, por sua vez, processa o boletim e o passa para o próximo handler na sequência. Com isso, torna-se possível configurar dinamicamente a cadeia de apuração para diferentes provas, adicionando, removendo ou reordenando regras sem qualquer impacto nas classes existentes.

    <ins>Handler</ins>: 
        - ApuracaoHandler: Interface que define o método para a cadeia de responsabilidade de apuração.
        Cada handler na cadeia deve implementar este método para processar o boletim de prova.

    <ins>BaseHandler</ins>: 
        - RegraApuracaoHandler: A classe abstrata que define a estrutura da cadeia de responsabilidade.
        Cada handler na cadeia deve implementar o método apurar para processar o boletim de prova.

    <ins>ConcreteHandler(s)</ins>:
        - RegraChegadaRegistradaHandler: Primeira e mais fundamental regra, verifica se o atleta completou a prova.
        - RegraOrdemPrismasHandler: Verifica se os prismas foram visitados na ordem correta.
        - RegraPenalidadeAtrasoHandler: Modifica o tempo de prova, aplicando a penalidade de atraso.
        - RegraTempoMaximoHandler: Modifica o tempo de prova, aplicando a regra do tempo máximo. 
        - RegraTodosPrismasHandler: Verifica se todos os prismas do percurso foram registrados.