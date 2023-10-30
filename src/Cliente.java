import java.util.Date;
public abstract class Cliente {
    private String endereco;
    private String nome;
    private Date dataCriacao;

    public Cliente(String nome, String endereco) {
            this.endereco = endereco;
            this.nome = nome;
            this.dataCriacao = new Date();
        }

    public String getEndereco() {
        return endereco;
    }
    public String getNome() {
        return nome;
    }

    public abstract boolean autenticar (String chave);

    }
