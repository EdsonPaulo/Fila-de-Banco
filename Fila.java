package FilaBanco;

public interface Fila {
    
    void inserir(Object object); //enqueue - adicionar elemento no fim da fila
    
    Object remover(); //dequeue - remover elemento no inicio da fila
    
    Object obterPrimeiroElemento(); //head - obter o primeiro elemento da fila
    
    void imprimirFila(); //listar elementos da fila

    void limparFila(); //remover todos os elementos da fila

    boolean filaCheia(); //verificar se a fila está cheia

    boolean filaVazia(); //verificar se a fila está vazia
}
