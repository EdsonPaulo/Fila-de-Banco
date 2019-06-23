package  FilaBanco;

public class Pessoa 
{
    private int senha;
    private String nome;

    public Pessoa(int senha, String nome)
    {
        this.senha = senha;
        this.nome = nome;
    }

    public int getSenha() {
       return this.senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
     }
 
     public String getNome() {
         return this.nome;
     }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "senha = 0" + senha + " - " + nome + '}';
    }
}