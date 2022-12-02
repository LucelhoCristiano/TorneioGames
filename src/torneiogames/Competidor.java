package torneiogames;

/**
 * @author Bianca Mayra - 322124358
 *                 Lucelho Cristiano - 32218540
 *                 Pedro Frois - 322117445
 */
public class Competidor {
    public String nome, apelido;
    private String endereco, email, celular;
    private long CPF;
   
    

    public Competidor(String nome, String apelido, String endereco, String email, String celular, long CPF) {
        this.nome = nome;
        this.apelido = apelido;
        this.endereco = endereco;
        this.email = email;
        this.celular = celular;
        this.CPF = CPF;
        
    }
   

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }
    
    public String ReceberCartao (int cartoesRecebidos) {
        
        String situacao;
        
        if (cartoesRecebidos==2) {
            situacao = "Derrotado!";
        }
        else if (cartoesRecebidos==1) {
            situacao = "Advertido!";
        }
        else {
            situacao = "Sem cartões!";
        }
        return situacao;
    }
    
}
