/**
 * public: declaração de exportação pública de uma classe/método/função/variável/etc...
 * 
 * class: declaração de classe (objeto)
 * 
 * HelloWorld: nome da classe (principal), que tem que ser igual ao nome do arquivo HelloWorld.java
 * 
 * { --> "abre chaves": inicia o bloco de código
 * 
 * static: declaração de método/função/variável estática, pois essa declaração faz com que os dados não sejam perdidos/vazados na memória ou processamento
 * 
 * void (nulo): nesse caso significa que o método não irá retornar, ou seja, o retorno é nulo
 * 
 * main (principal): nome do método, neste caso é o método principal, que irá executar o projeto
 * 
 * ( --> "abre parênteses": início da declaração de parâmetros/argumentos
 * 
 * string (texto): é o tipo do parâmetro/argumento. serve também para declarar tipo de variável
 * 
 * [] --> "abre e fecha colchetes": declaração de uma matriz
 * 
 * args (argumentos): é o nome de um parâmetro/argumento
 * 
 * ) --> "fechar parenteses": fim da declaração de parâmetros/argumentos
 * 
 * system (sistema): declaração/invocação da classe "System"
 * 
 * . --> "ponto": operador de invocação
 * 
 * out (saída): depois do ponto, serve como uma declaração/invocação da sub-classe "out", proveniente da classe "System"
 * 
 * println (imprimir linha): depois do ponto, serve como uma declaração/invocação do método "println", pois logo após há um "abre parenteses"
 * 
 * Obs: Quando há um "new (novo)", é uma delcaração/invocação/criação de um novo objeto
 * 
 * "Hello World!": é o texto propriamente dito, dentro de aspas duplas
 * 
 * " " --> "aspas duplas": declaração/definição de texto
 * 
 * ; --> "ponto e vírugla": é a declaração da finalização da linha de código
 * 
 * } --> "fecha chaves": é a declaração de finalização de um bloco de código
 */

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello Wordl!");
    }
}
