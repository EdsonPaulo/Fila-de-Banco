package FilaBanco;

public class Fila_Array implements Fila{

    private final Object[] objectos;
    private int primeiro, ultimo, totalObjectos;

    public Fila_Array(int TAMANHO_FILA) {
        objectos = new Object[TAMANHO_FILA ];
        primeiro = 0;
        ultimo = TAMANHO_FILA - 1;
        totalObjectos = 0;
    }

    @Override
    public void inserir(Object object) {
        if(filaCheia()) 
            throw new Error("ERRO: Fila cheia!");
        ultimo++;
        if (ultimo == objectos.length) ultimo = 0;
        
	objectos[ultimo] = object;
	totalObjectos++;
    }

    @Override
    public Object remover() {
        if(filaVazia()) 
            throw new Error("ERRO: Fila vazia!");
	Object objectoRemovido = objectos[primeiro];
	objectos[primeiro] = null;
        primeiro++;
	if (primeiro == objectos.length) primeiro = 0;
        
	totalObjectos--;
	return objectoRemovido;
    }

    @Override
    public Object obterPrimeiroElemento() {
      if(filaVazia()) 
            throw new Error("ERRO: Fila vazia!");
	return objectos [primeiro];
    }

    @Override
    public void imprimirFila() {
        if(!filaVazia())//se nao estiver vazia
            for(Object obj: objectos)
                if(obj != null)
                    System.out.println(obj);
    }

    @Override
    public void limparFila() 
    {    
       while (totalObjectos > 0) {
	    objectos[primeiro] = null;
            primeiro++;
	    if (primeiro == objectos.length)    primeiro = 0;
	    totalObjectos--;
	}
    }   

    @Override
    public boolean filaCheia() {
       return totalObjectos == objectos.length;
    }

    @Override
    public boolean filaVazia() {
        return totalObjectos == 0;
    }

    public int getUltimo() {
        return ultimo;
    }


}
