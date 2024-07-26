import visual.*;

import javax.swing.*;

public class Principal{
    public static void main(String[] args) {

        Visual jogo = new Visual();
        int escolha = jogo.inicio();

        if(escolha == 0) {
            int numPlayer = jogo.jogadores();

            if(numPlayer != 0) {
                jogo.mesaDados();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "tchau tchau :((", "Sair", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
