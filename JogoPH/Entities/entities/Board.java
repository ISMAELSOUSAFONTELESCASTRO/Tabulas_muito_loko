package entities;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Board {
    private List<String>[] board;/**Cria um vetor de listas do tipo String */
    @SuppressWarnings("unchecked")/**Feito para suspender avisos de erros */
    public Board(){
        board = new ArrayList[40];
        for(int i = 0; i<40; i++){
            board[i] = new ArrayList<>();/**Instancia cada elemento do vetor para não serem valores nulos */
        }
    }
    
    public List<String>[] getBoard() {/**get e set*/
        return board;
    }
    public void setBoard(List<String>[] board) {
        this.board = board;
    }

    public void printBoard(){/**Printa o tabuleiro */
        for(int i = 0; i<41; i++){
            System.out.print(board[i]);
            System.out.println(" " + i);
        }
    }

    public void addPerson(String cor, int casa){/**Adiciona uma peça em uma casa específica */
        board[casa].add(cor);
    }

    public void removePerson(String cor, int casa){/**Remove uma peça em uma casa específica */
        board[casa].remove(cor);
    }

    public String selecionarCores(Scanner sc, int i, List<String> cores){/**Seleção das cores */
        String c = null;
        System.out.println("JOGADOR " + 0 + (i+1));
        System.out.print("digite uma das cores disponíveis");
        System.out.print(cores + ": ");
        int k = 0;
        while(k != 1){
            c = sc.next();
            if(c.equals(cores.get(0)) || c.equals(cores.get(1)) || c.equals(cores.get(2)) || c.equals(cores.get(3)) || c.equals(cores.get(4)) || c.equals(cores.get(5))){
                k++;
            }
            else{
                System.err.println("Digite uma cor válida!");
                System.out.print("digite uma das cores disponíveis: ");
            }
        }
        cores.remove(c);
        return c;
    }

    public char selecionarStatus(Persons[] p, int i, int numero){/**Seleção dos status iniciais */
        Random rd = new Random();
        int n;
        char x = 'p';
        if(i < numero && i != numero - 1){/**aqui os primeiros jogadores selecionam qualquer um do 3 status */
            n = rd.nextInt(3);
            if(n == 0){
                x = 'm';
            }
            else if(n == 1){
                x = 'n';
            }
            else{
                x = 'l';
            }
        }
        else{
            int j = 1;
            int k = 0;
            while(j != numero - 1){
                if(p[j].getType() != p[j-1].getType()){
                    k++;
                }
                j++;
            }
            if(k == 0){
                if(p[0].getType() == 'm'){
                    n = rd.nextInt(2-1) + 1;
                    if(n == 1){
                        x = 'n';
                    }
                    else{
                        x = 'l';
                    }
                }
                else if(p[0].getType() == 'n'){
                    int escolha = rd.nextInt(2);
                    int[] options = {2, 0};
                    n = options[escolha];
                    if(n == 0){
                        x = 'm';
                    }
                    else{
                        x = 'l';
                    }
                }
                else{
                    n = rd.nextInt(1);
                    if(n == 1){
                        x = 'n';
                    }
                    else{
                        x = 'm';
                    }
                }
            }
        }
        return x;
    }
}
