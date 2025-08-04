# Projeto da Avaliação III - Padrões de Projeto (INF011)

## Integrantes:

- Iainara Cerqueira dos Santos
- Raí Salomão Alves Mangueira
- Rodrigo Ansah Carvalho Frempong

## Padrões de Projeto Aplicados

### Questão 1: Refatoração do `BoletimProva`

#### **Padrão Aplicado: State**

- **Justificativa:** O padrão State foi escolhido porque ele permite que um objeto altere seu comportamento quando seu estado interno muda, fazendo com que o objeto pareça ter mudado de classe. A classe BoletimProva precisa executar ações diferentes (como registrar largada, chegada, passagens) dependendo da fase da prova em que o atleta se encontra. Ao encapsular os comportamentos específicos de cada fase em objetos de estado separados, eliminamos a necessidade de condicionais.

<ins>Context:</ins> BoletimProva 
<ins>State:</ins> AbstractFaseDaProvaState (Classe Abstrata) e FaseDaProvaState (Interface)
<ins>ConcreteState(s):</ins> 
- MomentoDaLargadaState: Representa o estado de Momento da Largada, onde o boletim foi apresentado e a largada pode ser registrada.
- PistaState: Representa o estado de Pista, onde a prova está em andamento.
- PosProvaState: Representa o estado de Pós Prova, onde a prova já foi concluída.
- PreProvaState: Representa o estado de Pré Prova, onde o boletim ainda não foi apresentado.
            
### Questão 2: Refatoração do `Apurador`

#### **Padrão Aplicado: Chain of Responsibility**

* [cite_start]**Justificativa:** O padrão Chain of Responsibility foi escolhido para desacoplar o `Apurador` das várias regras de validação e penalidade[cite: 28]. [cite_start]Ele permite construir uma cadeia de objetos de processamento (as regras)[cite: 32]. Quando a apuração é iniciada, o `BoletimProva` é passado ao longo da cadeia, e cada regra decide se processa a informação e/ou a passa para a próxima. [cite_start]Isso torna o sistema de apuração configurável, permitindo que regras sejam adicionadas, removidas ou reordenadas sem impactar as demais[cite: 32].

* **Participantes do Padrão:**
    * **Client:** `Apurador` - Responsável por construir a cadeia de regras e iniciar o processo de apuração passando o `BoletimProva` para o primeiro handler.
    * **Handler:** `RegraApuracaoHandler` (Classe Abstrata) - Define a interface para tratar as requisições e implementa a lógica para encaminhar a chamada ao próximo handler na cadeia.
    * **ConcreteHandler:**
        * [cite_start]`RegraChegadaRegistradaHandler`: Verifica se a chegada foi registrada, estabelecendo o tempo base da prova[cite: 25].
        * [cite_start]`RegraOrdemPrismasHandler`: Verifica se os prismas foram registrados na ordem correta, conforme definido no percurso[cite: 26].
        * [cite_start]`RegraTodosPrismasHandler`: Verifica se todos os prismas obrigatórios do percurso foram registrados pelo atleta[cite: 27].
        * [cite_start]`RegraPenalidadeAtrasoHandler`: Aplica penalidades em tempo, adicionando os minutos de atraso do atleta ao tempo final[cite: 27].
        * [cite_start]`RegraTempoMaximoHandler`: Verifica se o tempo de prova do atleta não excedeu o tempo máximo permitido[cite: 26].