package torneiogames;

import java.util.Random;

/**
 * @author Bianca Mayra - 322124358 Lucelho Cristiano - 32218540 Pedro Frois -
 * 322117445
 */
public class Jogador {

    public String nome, habLuta, habDefesa, habCura, fraqueza, apelido;
    public int vidaHP = 1000;

    public Jogador(String nome, String habLuta, String habDefesa, String habCura, String fraqueza, String apelido) {
        this.nome = nome;
        this.habLuta = habLuta;
        this.habDefesa = habDefesa;
        this.habCura = habCura;
        this.fraqueza = fraqueza;
        this.apelido = apelido;
    }

    public void Curar(){
        if ("Chi".equals(habCura)) {
                vidaHP += 200;
            } else {
                // Caso potion
                vidaHP += 300;
            }
    }
    
    public void ReceberDanoNormal(int opcaoJogador1, int opcaoJogador2) {
        Random random = new Random();
            int minimo = 100;
            int maximo = 200;
            vidaHP -= random.nextInt((maximo - minimo) + 1) + minimo;
    }

    public void ReceberDanoCritico(int opcaoJogador1, int opcaoJogador2) {
            vidaHP -= 500;
    }

    public String Situacao (int cartoes){
        String situacao = "";
        if(cartoes==0){
            situacao = "Sem cartões!";
        }
        else if (cartoes==1){
            situacao = "Advertência!!";
        }
        else if (cartoes==2){
            situacao = "Eliminado!!!";
        }
        return situacao;
    }
    
}
