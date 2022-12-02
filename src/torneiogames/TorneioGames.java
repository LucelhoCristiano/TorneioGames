package torneiogames;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Bianca Mayra - 322124358 Lucelho Cristiano - 32218540 Pedro Frois -
 * 322117445 Luidy Ribeiro - 322130128
 *
 * Questão: Vocês estão desenvolvendo um sistema para administrar um campeonato
 * de games. Assim, alguns dados serão necessários para controle deste torneio:
 * ● Competidores: Os inscritos no campeonato deverão registrar seus nomes,
 * endereços, e-mails, cpfs, celulares e apelido. ● Jogadores: Os competidores
 * devem cadastrar os seus jogadores virtuais (avatares). Eles possuem dados
 * como: nome, habilidade de luta, habilidade de defesa, habilidade de cura,
 * fraqueza principal e o apelido do seu competidor. ● Juizes: Os juizes da
 * competição devem ser registrados, com seus nomes, endereços, emails, cpfs,
 * celulares. ● Partida: A partida deve ter os dois competidores, hora de
 * inicio, pontos do primeiro jogador, pontos do segundo jogador e vencedor.
 * Algumas ações são requeridas durante o uso desse sistema: ● Os competidores
 * podem receber cartões de advertência: em caso de dois cartões ele deve ser
 * declarado como derrotado (pode ser via impressão) ● Os jogadores devem poder
 * receber dano. Este dano tem um limite de 1000 unidades. Caso o dano indicado
 * seja igual ao limite, ele deve morrer (ser derrotado)
 */
public class TorneioGames {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        DateFormat formatoDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        String nomeCompetidor, enderecoCompetidor, emailCompetidor, celularCompetidor, apelidoCompetidor,
                nomeJogador = "", habLuta = "", habDef = "", HabCura = "", fraqueza = "",
                nomeJuiz, enderecoJuiz, emailJuiz, celularJuiz;
        int opcao, rodada = 1, turno = 1, jogadorDaVez, jogadaDo1 = 0, jogadaDo2 = 0, cartoesJog1 = 0, cartoesJog2 = 0;
        boolean validar, derrota = false;
        long cpfCompetidor = 0, cpfJuiz = 0;
        Date horaInicio = new Date();

        Competidor competidor1 = null;
        Competidor competidor2 = null;
        Jogador jogador1 = null;
        Jogador jogador2 = null;

        for (int i = 0; i < 2; i++) {

            nomeCompetidor = (String) JOptionPane.showInputDialog(null, "DIGITE O NOME !", +(i + 1)
                    + "º COMPETIDOR  ",
                    3,
                    null,
                    null,
                    "Digite aqui.");

            enderecoCompetidor = (String) JOptionPane.showInputDialog(null, "DIGITE O ENDEREÇO !", +(i + 1)
                    + "º COMPETIDOR ",
                    3,
                    null,
                    null,
                    "Digite aqui.");

            emailCompetidor = (String) JOptionPane.showInputDialog(null, "DIGITE O EMAIL !", +(i + 1)
                    + "º COMPETIDOR ",
                    3,
                    null,
                    null,
                    "Digite aqui.");
            do {
                try {
                    cpfCompetidor = Long.parseLong((String) JOptionPane.showInputDialog(null, "DIGITE O CPF !", +(i + 1)
                            + "º COMPETIDOR ",
                            3,
                            null,
                            null,
                            "Digite aqui."));
                    validar = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Necessita-se de um valor numerico",
                            "Valor Invalido",
                            0);
                    validar = false;
                }

            } while (validar == false);

            celularCompetidor = (String) JOptionPane.showInputDialog(null, "DIGITE O CELULAR !", +(i + 1)
                    + "º COMPETIDOR ",
                    3,
                    null,
                    null,
                    "Digite aqui.");

            apelidoCompetidor = (String) JOptionPane.showInputDialog(null, "DIGITE O APELIDO !", +(i + 1)
                    + "º COMPETIDOR ",
                    3,
                    null,
                    null,
                    "Digite aqui.");

            JOptionPane.showMessageDialog(null,
                    " Cadastro Bem Sucedido",
                    "Sucedido",
                    1);

            if (i == 0) {
                competidor1 = new Competidor(nomeCompetidor, apelidoCompetidor, enderecoCompetidor, emailCompetidor, celularCompetidor, cpfCompetidor);
            } else {
                competidor2 = new Competidor(nomeCompetidor, apelidoCompetidor, enderecoCompetidor, emailCompetidor, celularCompetidor, cpfCompetidor);
            }

            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "____Opcoes Nomes____"
                        + "\n1- Chun-Li"
                        + "\n2- Blanka"
                        + "\n3- Zangief"
                        + "\n4- Honda"
                        + "\n_________________________________"
                        + "\n" + (i + 1) + "º Jogador:", (i + 1) + "º Jogador - Nome", 3));
                switch (opcao) {
                    case 1:
                        nomeJogador = "Chun-Li";
                        break;
                    case 2:
                        nomeJogador = "Blanka";
                        break;
                    case 3:
                        nomeJogador = "Zangief";
                        break;
                    case 4:
                        nomeJogador = "Honda";
                        break;
                }

                if (opcao != 1 & opcao != 2 & opcao != 3 & opcao != 4) {
                    JOptionPane.showMessageDialog(null,
                            "Jogador selecionado não existe!",
                            "Valor inválido",
                            0);
                }

            } while (opcao != 1 & opcao != 2 & opcao != 3 & opcao != 4);

            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "____Opcoes Habilidade Luta e Fraqueza____"
                        + "\n__Habilidade__          __Fraqueza__      "
                        + "\n1- Kung Fu                        Judo"
                        + "\n2- Taekwondo                   Boxe"
                        + "\n3- Muay Thai                 Wing Chun"
                        + "\n4- Boxe                         Taekwondo"
                        + "\n5- Wing Chun                Muay Thai"
                        + "\n6- Jiu Jitsu                      Capoeira"
                        + "\n7- Capoeira                     Jiu Jitsu"
                        + "\n8- Judo                            Kung Fu"
                        + "\n_________________________________"
                        + "\n" + (i + 1) + "º jogador: ", (i + 1) + "º Jogador - Habilidade Luta e Fraqueza", 3));
                switch (opcao) {
                    case 1:
                        habLuta = "Kung Fu";
                        fraqueza = "Judo";
                        break;
                    case 2:
                        habLuta = "Taekwondo";
                        fraqueza = "Boxe";
                        break;
                    case 3:
                        habLuta = "Muay Thai";
                        fraqueza = "Wing Chun";
                        break;
                    case 4:
                        habLuta = "Boxe";
                        fraqueza = "Taekwondo";
                        break;
                    case 5:
                        habLuta = "Wing Chun";
                        fraqueza = "Muay Thai";
                        break;
                    case 6:
                        habLuta = "Jiu Jitsu";
                        fraqueza = "Capoeira";
                        break;
                    case 7:
                        habLuta = "Capoeira";
                        fraqueza = "Jiu Jitsu";
                        break;
                    case 8:
                        habLuta = "Judo";
                        fraqueza = "Kung Fu";
                        break;
                }
                if (opcao != 1 & opcao != 2 & opcao != 3 & opcao != 4 & opcao != 5 & opcao != 6 & opcao != 7 & opcao != 8) {
                    JOptionPane.showMessageDialog(null,
                            "Habilidade / Fraqueza selecionada não existe!",
                            "Valor inválido",
                            0);
                }
            } while (opcao != 1 & opcao != 2 & opcao != 3 & opcao != 4 & opcao != 5 & opcao != 6 & opcao != 7 & opcao != 8);

            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "____Opcoes Defesas____"
                        + "\n1- Bloqueio"
                        + "\n2- Recuar"
                        + "\n_________________________________"
                        + "\n" + (i + 1) + "º Jogador:", (i + 1) + "º Jogador - Defesa", 3));
                switch (opcao) {
                    case 1:
                        habDef = "Bloqueio";
                        break;
                    case 2:
                        habDef = "Recuar";
                        break;
                }
                if (opcao != 1 & opcao != 2) {
                    JOptionPane.showMessageDialog(null,
                            "Defesa selecionada não existe!",
                            "Valor inválido",
                            0);
                }
            } while (opcao != 1 & opcao != 2);

            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "____Opcoes Cura____"
                        + "\n1- Chi"
                        + "\n2- Potion"
                        + "\n_________________________________"
                        + "\n" + (i + 1) + "º Jogador:", (i + 1) + "º Jogador - Cura", 3));
                switch (opcao) {
                    case 1:
                        HabCura = "Chi";
                        break;
                    case 2:
                        HabCura = "Potion";
                        break;
                }
                if (opcao != 1 & opcao != 2) {
                    JOptionPane.showMessageDialog(null,
                            "Cura selecionada não existe!",
                            "Valor inválido",
                            0);
                }
            } while (opcao != 1 & opcao != 2);

            if (i == 0) {
                jogador1 = new Jogador(nomeJogador, habLuta, habDef, HabCura, fraqueza, apelidoCompetidor);
            } else {
                jogador2 = new Jogador(nomeJogador, habLuta, habDef, HabCura, fraqueza, apelidoCompetidor);
            }

        }

        nomeJuiz = (String) JOptionPane.showInputDialog(null, "DIGITE O NOME !",
                " JUIZ ",
                3,
                null,
                null,
                "Digite aqui.");

        enderecoJuiz = (String) JOptionPane.showInputDialog(null, "DIGITE O ENDERECO !",
                " JUIZ ",
                3,
                null,
                null,
                "Digite aqui.");

        emailJuiz = (String) JOptionPane.showInputDialog(null, "DIGITE O EMAIL !",
                " JUIZ ",
                3,
                null,
                null,
                "Digite aqui.");
        do {
            try {
                cpfJuiz = Long.parseLong((String) JOptionPane.showInputDialog(null, "DIGITE O CPF !",
                        " JUIZ ",
                        3,
                        null,
                        null,
                        "Digite aqui."));
                validar = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Necessita-se de um valor numerico",
                        "Valor Invalido",
                        0);
                validar = false;
            }

        } while (validar == false);

        celularJuiz = (String) JOptionPane.showInputDialog(null, "DIGITE O CELULAR !",
                " JUIZ ",
                3,
                null,
                null,
                "Digite aqui.");

        Juiz juiz = new Juiz(nomeJuiz, enderecoJuiz, emailJuiz, celularJuiz, cpfJuiz);

        //COMO A PARTIDA FUNCIONA:
        // tem: 2 competidores, horaInicio, pontos do 1° e 2° jogador, vencedor
        // A cada partida derrotada o jogador perdedor ganha 1 cartão. Se ele chegar a 2, acabou o jogo.
        // Cada partida acaba assim que os 1000 pts de vida se forem
        // Vai ser de turno (cada hora um ataca)
        // Caso escolha atacar: 
        // gerar um numero aleatório de 100 a 200 para retirar vida do oponente.
        //Caso escolha defesa:
        //Recuar: leva dano 0
        //bloqueio: leva de 50 a 100
        //Se for fraqueza dele: leva 200 a 500
        // Caso escolha cura: 
        // Chi: ele recupera 200 de vida, pode usar toda rodada.
        // Potion: ele recupera 300 de vida.
        JOptionPane.showMessageDialog(null,
                "Data e hora de início da partida: " + formatoDataHora.format(horaInicio),
                "Início da Partida",
                2);

        do {

            for (turno = 1; turno < 3; turno++) {
                String apelidoDaVez = "";
                if (turno == 1) {
                    jogadorDaVez = 1;
                    apelidoDaVez = jogador1.apelido;
                }
                if (turno % 2 == 0 & turno != 1) {
                    jogadorDaVez = 2;
                    apelidoDaVez = jogador2.apelido;
                } else {
                    jogadorDaVez = 1;
                    apelidoDaVez = jogador1.apelido;
                }

                do {
                    opcao = Integer.parseInt((String) JOptionPane.showInputDialog(null, "JOGADOR DA VEZ (" + jogadorDaVez + "): " + apelidoDaVez
                            + "\n________Escolha________"
                            + "\n1- Atacar"
                            + "\n2- Defender"
                            + "\n3- Curar"
                            + "\n_________________________________"
                            + "\nHP atual do Jogador " + jogador1.apelido + " (1) : " + jogador1.vidaHP
                            + "\nHP atual do Jogador " + jogador2.apelido + " (2) : " + jogador2.vidaHP
                            + "\n" + (jogadorDaVez) + "º Jogador (" + apelidoDaVez + "): ",
                            rodada + "ª Rodada | " + turno + "º Turno",
                            3, null, null, "Digite aqui."));

                    if (opcao != 1 & opcao != 2 & opcao != 3) {
                        JOptionPane.showMessageDialog(null,
                                "Movimento não existe!",
                                "Valor inválido",
                                0);
                    }

                } while (opcao != 1 & opcao != 2 & opcao != 3);

                if (jogadorDaVez == 1) {
                    jogadaDo1 = opcao;
                } else {
                    jogadaDo2 = opcao;
                }
            }

            // Quer dizer que o ataque vai ser crítico
            if ((("Kung Fu".equals(jogador1.habLuta) && "Judo".equals(jogador2.habLuta)) || ("Judo".equals(jogador1.habLuta) && "Kung Fu".equals(jogador2.habLuta)))
                    || (("Taekwondo".equals(jogador1.habLuta) && "Boxe".equals(jogador2.habLuta)) || ("Boxe".equals(jogador1.habLuta) && "Taekwondo".equals(jogador2.habLuta)))
                    || (("Muay Thai".equals(jogador1.habLuta) && "Wing Chun".equals(jogador2.habLuta)) || ("Wing Chun".equals(jogador1.habLuta) && "Muay Thai".equals(jogador2.habLuta)))
                    || (("Jiu Jitsu".equals(jogador1.habLuta) && "Capoeira".equals(jogador2.habLuta)) || ("Capoeira".equals(jogador1.habLuta) && "Jiu Jitsu".equals(jogador2.habLuta)))) {
                //Caso ambos jogadores (ataque), ele receberá um dando aleatório de 100 a 200
                if (jogadaDo1 == 1 & jogadaDo2 == 1) {
                    jogador1.ReceberDanoCritico(jogadaDo1, jogadaDo2);
                    jogador2.ReceberDanoCritico(jogadaDo1, jogadaDo2);
                } // Se os dois escolherem "Defesa", ninguém leva dano. Logo, não faremos um if.
                //Caso ambos escolham curar
                else if (jogadaDo1 == 3 & jogadaDo2 == 3) {
                    jogador1.Curar();
                    jogador2.Curar();
                } //Caso 1 atacar e 2  defender
                else if (jogadaDo1 == 1 & jogadaDo2 == 2) {
                    jogador2.ReceberDanoCritico(jogadaDo1, jogadaDo2);
                } //Caso 2 atacar e 1  defender
                else if (jogadaDo1 == 2 & jogadaDo2 == 1) {
                    jogador1.ReceberDanoCritico(jogadaDo1, jogadaDo2);
                } // se HabDefesa = "Recuar" o dano será 0. Então não há necessidade de if.
                //Caso 1 escolha atacar e 2 curar
                else if (jogadaDo1 == 1 & jogadaDo2 == 3) {
                    jogador2.Curar();
                    jogador2.ReceberDanoCritico(jogadaDo1, jogadaDo2);
                } //Caso 2 escolha atacar e 1 curar
                else if (jogadaDo1 == 3 & jogadaDo2 == 1) {
                    jogador1.Curar();
                    jogador1.ReceberDanoCritico(jogadaDo1, jogadaDo2);
                } //Caso 1 escolha defender e 2 curar
                else if (jogadaDo1 == 2 & jogadaDo2 == 3) {
                    jogador2.Curar();
                } //Caso 2 escolha defender e 1 curar
                else if (jogadaDo1 == 3 & jogadaDo2 == 2) {
                    jogador1.Curar();
                }
            } //Ataque normal
            else {
                //Caso ambos jogadores (ataque), ele receberá um dando aleatório de 100 a 200
                if (jogadaDo1 == 1 & jogadaDo2 == 1) {
                    jogador1.ReceberDanoNormal(jogadaDo1, jogadaDo2);
                    jogador2.ReceberDanoNormal(jogadaDo1, jogadaDo2);
                } // Se os dois escolherem "Defesa", ninguém leva dano. Logo, não faremos um if.
                //Caso ambos escolham curar
                else if (jogadaDo1 == 3 & jogadaDo2 == 3) {
                    jogador1.Curar();
                    jogador2.Curar();
                } //Caso 1 atacar e 2  defender
                else if (jogadaDo1 == 1 & jogadaDo2 == 2) {
                    jogador2.ReceberDanoNormal(jogadaDo1, jogadaDo2);
                } //Caso 2 atacar e 1  defender
                else if (jogadaDo1 == 2 & jogadaDo2 == 1) {
                    jogador1.ReceberDanoNormal(jogadaDo1, jogadaDo2);
                } // se HabDefesa = "Recuar" o dano será 0. Então não há necessidade de if.
                //Caso 1 escolha atacar e 2 curar
                else if (jogadaDo1 == 1 & jogadaDo2 == 3) {
                    jogador2.Curar();
                    jogador2.ReceberDanoNormal(jogadaDo1, jogadaDo2);
                } //Caso 2 escolha atacar e 1 curar
                else if (jogadaDo1 == 3 & jogadaDo2 == 1) {
                    jogador1.Curar();
                    jogador1.ReceberDanoNormal(jogadaDo1, jogadaDo2);
                } //Caso 1 escolha defender e 2 curar
                else if (jogadaDo1 == 2 & jogadaDo2 == 3) {
                    jogador2.Curar();
                } //Caso 2 escolha defender e 1 curar
                else if (jogadaDo1 == 3 & jogadaDo2 == 2) {
                    jogador1.Curar();
                }
            }

            JOptionPane.showMessageDialog(null,
                    "Fim do turno de cada um"
                    + "\nHP atual do Jogador " + jogador1.apelido + " (1) : " + jogador1.vidaHP
                    + "\nHP atual do Jogador " + jogador2.apelido + " (2) : " + jogador2.vidaHP,
                    "Resultado",
                    1);
            
            if (jogador1.vidaHP <= 0) {
                cartoesJog1++;
                rodada++;
                JOptionPane.showMessageDialog(null,
                        "Jogador " + jogador1.apelido + " possui: " + cartoesJog1 + " cartões!"
                        + "\nSituação: " + jogador1.Situacao(cartoesJog1)
                        + "\n______________________________________________________"
                        + "\nJogador " + jogador2.apelido + " possui: " + cartoesJog2 + " cartões!"
                        + "\nSituação: " + jogador2.Situacao(cartoesJog2),
                        "FINAL DA RODADA " + rodada,
                        2);
                jogador1.vidaHP = 1000;
                jogador2.vidaHP = 1000;
            } else if (jogador2.vidaHP <= 0) {
                cartoesJog2++;
                rodada++;
                JOptionPane.showMessageDialog(null,
                        "Jogador " + jogador1.apelido + " (1) possui: " + cartoesJog1 + " cartões!"
                        + "\nSituação: " + jogador1.Situacao(cartoesJog1)
                        + "\n______________________________________________________"
                        + "\nJogador " + jogador2.apelido + " (2) possui: " + cartoesJog2 + " cartões!"
                        + "\nSituação: " + jogador2.Situacao(cartoesJog2),
                        "FINAL DA RODADA ",
                        2);
                jogador1.vidaHP = 1000;
                jogador2.vidaHP = 1000;
            }

            if (cartoesJog1 == 2) {
                derrota = true;

                JOptionPane.showMessageDialog(null,
                        "xxxxxxxxxxxxxxxxxxxxxxx GAME OVER xxxxxxxxxxxxxxxxxxxxxxx "
                        + "\n______________DADOS DO VENCEDOR_________________"
                        + "\nNome do Competidor: " + competidor2.nome
                        + "\nEndereço do Competidor: " + competidor2.getEndereco()
                        + "\nEmail do Competidor: " + competidor2.getEmail()
                        + "\nCPF do Competidor: " + competidor2.getCPF()
                        + "\nCelular: +55 " + competidor2.getCelular()
                        + "\nApelido: " + competidor2.apelido
                        + "\nSituação final: " + jogador2.Situacao(cartoesJog2)
                        + "\n______________ DADOS DO JOGADOR DO VENCEDOR______________"
                        + "\nNome do Jogador: " + jogador2.nome
                        + "\nHabilidade de Luta: " + jogador2.habLuta
                        + "\nHabilidade de Defesa: " + jogador2.habDefesa
                        + "\nHabilidade de Cura: " + jogador2.habCura
                        + "\nFraqueza principal: " + jogador2.fraqueza
                        + "\nApelido: " + jogador2.apelido
                        + "\n______________DADOS DO PERDEDOR_________________"
                        + "\nNome do Competidor: " + competidor1.nome
                        + "\nEndereço do Competidor: " + competidor1.getEndereco()
                        + "\nEmail do Competidor: " + competidor1.getEmail()
                        + "\nCPF do Competidor: " + competidor1.getCPF()
                        + "\nCelular: +55 " + competidor1.getCelular()
                        + "\nApelido: " + competidor1.apelido
                        + "\nSituação final: " + jogador1.Situacao(cartoesJog1)
                        + "\n______________ DADOS DO JOGADOR DO PERDEDOR______________"
                        + "\nNome do Jogador: " + jogador1.nome
                        + "\nHabilidade de Luta: " + jogador1.habLuta
                        + "\nHabilidade de Defesa: " + jogador1.habDefesa
                        + "\nHabilidade de Cura: " + jogador1.habCura
                        + "\nFraqueza principal: " + jogador1.fraqueza
                        + "\nApelido: " + jogador1.apelido
                        + "\n______________DADOS DO JUIZ_________________"
                        + "\nNome do Juiz: " + juiz.nome
                        + "\nEndereço do Juiz: " + juiz.getEndereco()
                        + "\nEmail do Juiz: " + juiz.getEmail()
                        + "\nCPF do Juiz: " + juiz.getCPF()
                        + "\nCelular: +55 " + juiz.getCelular()
                        + "\n______________DADOS DA PARTIDA_________________"
                        + "\nHorário de Início: " + formatoDataHora.format(horaInicio),
                        "FIM DE JOGO",
                        2);
            } else if (cartoesJog2 == 2) {
                derrota = true;

                JOptionPane.showMessageDialog(null,
                        "xxxxxxxxxxxxxxxxxxxxxxx GAME OVER xxxxxxxxxxxxxxxxxxxxxxx "
                        + "\n______________DADOS DO VENCEDOR_________________"
                        + "\nNome do Competidor: " + competidor1.nome
                        + "\nEndereço do Competidor: " + competidor1.getEndereco()
                        + "\nEmail do Competidor: " + competidor1.getEmail()
                        + "\nCPF do Competidor: " + competidor1.getCPF()
                        + "\nCelular: +55 " + competidor1.getCelular()
                        + "\nApelido: " + competidor1.apelido
                        + "\nSituação final: " + jogador1.Situacao(cartoesJog1)
                        + "\n______________ DADOS DO JOGADOR DO VENCEDOR______________"
                        + "\nNome do Jogador: " + jogador1.nome
                        + "\nHabilidade de Luta: " + jogador1.habLuta
                        + "\nHabilidade de Defesa: " + jogador1.habDefesa
                        + "\nHabilidade de Cura: " + jogador1.habCura
                        + "\nFraqueza principal: " + jogador1.fraqueza
                        + "\nApelido: " + jogador1.apelido
                        + "\n______________DADOS DO PERDEDOR_________________"
                        + "\nNome do Competidor: " + competidor2.nome
                        + "\nEndereço do Competidor: " + competidor2.getEndereco()
                        + "\nEmail do Competidor: " + competidor2.getEmail()
                        + "\nCPF do Competidor: " + competidor2.getCPF()
                        + "\nCelular: +55 " + competidor2.getCelular()
                        + "\nApelido: " + competidor2.apelido
                        + "\nSituação final: " + jogador1.Situacao(cartoesJog2)
                        + "\n______________ DADOS DO JOGADOR DO PERDEDOR______________"
                        + "\nNome do Jogador: " + jogador2.nome
                        + "\nHabilidade de Luta: " + jogador2.habLuta
                        + "\nHabilidade de Defesa: " + jogador2.habDefesa
                        + "\nHabilidade de Cura: " + jogador2.habCura
                        + "\nFraqueza principal: " + jogador2.fraqueza
                        + "\nApelido: " + jogador2.apelido
                        + "\n______________DADOS DO JUIZ_________________"
                        + "\nNome do Juiz: " + juiz.nome
                        + "\nEndereço do Juiz: " + juiz.getEndereco()
                        + "\nEmail do Juiz: " + juiz.getEmail()
                        + "\nCPF do Juiz: " + juiz.getCPF()
                        + "\nCelular: +55 " + juiz.getCelular()
                        + "\n______________DADOS DA PARTIDA_________________"
                        + "\nHorário de Início: " + formatoDataHora.format(horaInicio),
                        "FIM DE JOGO",
                        2);
            }

        } while (derrota == false);

    }
}
