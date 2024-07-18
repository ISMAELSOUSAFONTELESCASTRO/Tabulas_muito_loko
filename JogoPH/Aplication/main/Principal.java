package Aplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Entities.Board;
import Entities.Persons;
import Round.Round;
public class Principal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        System.out.print("Bem vindo ao JUJUTSU NO CASA BATTLE ROYALE" + "\n digite quantos jogadores participarão: ");
        int k = 0;
        int numero = 0;
        while(k != 1){
            numero = sc.nextInt();
            if(numero == 2 || numero == 3 || numero == 4 || numero == 5 || numero == 6){
                k++;
            }
            else{
                System.err.println("Digite um número válido!");
                System.out.print("digite o número de jogadores: ");
            }
        }
        Persons[] p = new Persons[numero]; /**Vetor com cada elemento sendo as pessoas que estão no jogo */
        Round[] r = new Round[numero];
        sc.nextLine();
        List<String> cores = new ArrayList<>();/**Cria uma lista com as cores do jogo */
        cores.add("vermelho");
        cores.add("amarelo");
        cores.add("azul");
        cores.add("preto");
        cores.add("branco");
        cores.add("marrom");
        for(int i = 0; i<numero; i++){/**Dentro do for inicializa os jogadores e seus atributos */
            String cor = b.selecionarCores(sc, i, cores);
            char type = b.selecionarStatus(p, i, numero);
            p[i] = new Persons(type, 0, cor);
            r[i] = new Round(p[i]);
            b.addPerson(p[i].getColor(), 0);
        }
        b.printBoard();
        k = 0;
        int rodada = 1;
        sc.nextLine();
        while(k != 1){/** Aqui os rouns acontecem mudando de casa até alguem ultrapassar a última casa ou chegar nela*/
            for(int i = 0; i<numero; i++){
                System.out.println("Rodada " + 0 + rodada);
                sc.nextLine();
                r[i].makeRound(b);
                if(p[i].getHouse() >= 39){
                    System.out.println("Feiticeiro com o pino da cor " + p[i].getColor() + " Ganhou a partida!");
                    k++;
                    break;
                }
                b.printBoard();
                rodada++;
            }
        }
        sc.close();
    }
}   
