package torneiogames;

/**
 * @author Bianca Mayra - 322124358
 *                 Lucelho Cristiano - 32218540
 *                 Pedro Frois - 322117445
 */
public class Juiz {
    public String nome;
    private String endereco, email, celular;
    private long CPF;

    public Juiz(String nome, String endereco, String email, String celular, long CPF) {
        this.nome = nome;
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
    
}
