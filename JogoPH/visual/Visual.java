package visual;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import entities.*;
import round.*;

public class Visual {

    private static JPanel[] casas = new JPanel[40];
    private JFrame tabuleiro = new JFrame("Tabuleiro");
    private JLabel nome = new JLabel("JOGO DE TABULEIRO");
    private static Persons[] pessoas = new Persons[6];
    private int roundAtual = 0;
    private Round[] rounds = new Round[6];
    private ImageIcon logo = new ImageIcon(getClass().getResource("/imagens/tabuleiro.png"));

    private static ImageIcon icone = new ImageIcon(Visual.class.getResource("/imagens/pino.jpg"));
    private static JLabel[] pinos = {
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/vermelho.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/laranja.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/amarelo.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/verde.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/azul.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/roxo.png")))
    };

    private String[] opcoes1 = {"vermelho", "laranja", "amarelo", "verde", "azul", "roxo"};
    private int um=0;
    private int dois=0;
    private int tres=0;
    private static int valor = 0;
    private static JLabel[] dados = {
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado1p.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado2p.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado3p.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado4p.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado5p.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado6p.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado1b.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado2b.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado3b.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado4b.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado5b.png"))),
        new JLabel(new ImageIcon(Visual.class.getResource("/imagens/dado6b.png")))
    };
    private JButton sair = new JButton("Sair");
    private JButton rodar = new JButton("Rodar dados");
    private static JPanel mesa2 = new JPanel();

    public Visual(){
        setupTabuleiro();
        setupCasas();
    }

    public int inicio(){
        String[] opcoes = {"Jogar", "Sair"};

        int escolha = JOptionPane.showOptionDialog(null, "JOGO DE TABULEIRO", "Início", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, logo, opcoes, 0);
        return escolha;
    }

    public int jogadores(){
        ImageIcon icone2 = new ImageIcon(getClass().getResource("/imagens/pino.jpg"));
        String[] opcoes2 = {"2", "3", "4", "5", "6"};
        int i = 0;
        while(i == 0){

            Object entrada = JOptionPane.showInputDialog(null, "Quantos jogadores vão participar?", "Jogadores", JOptionPane.INFORMATION_MESSAGE, icone2, opcoes2, 0);
            try {
                valor = Integer.parseInt((String) entrada);
                for(i=0;i<valor;i++) {
                    gerarPessoa(i);
                }
                i = 1;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "tchau tchau :((", "Sair", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
        return valor;
    }

    public static int getValor(){
        return valor;
    }

    public void gerarPessoa(int i){
        char classe;
        int a=0;
        do{
            Object entrada = JOptionPane.showInputDialog(null, "Escolha sua cor", "Jogadores", JOptionPane.INFORMATION_MESSAGE, icone, opcoes1, 0);
            String entrada1 = entrada.toString();
            try {
                if (!entrada1.equals("já escolhido")) {
                    if (entrada1.equals("vermelho")) {
                        opcoes1[0] = "já escolhido";
                        classe = gerarClasse();
                        Persons pessoa = new Persons(classe, 0, entrada1);
                        pessoas[i] = pessoa;
                        Round round = new Round(pessoa);
                        rounds[i] = round;
                        casas[0].add(pinos[0]);
                    } else if (entrada1.equals("laranja")) {
                        opcoes1[1] = "já escolhido";
                        classe = gerarClasse();
                        Persons pessoa = new Persons(classe, 0, entrada1);
                        pessoas[i] = pessoa;
                        Round round = new Round(pessoa);
                        rounds[i] = round;
                        casas[0].add(pinos[1]);
                    } else if (entrada1.equals("amarelo")) {
                        opcoes1[2] = "já escolhido";
                        classe = gerarClasse();
                        Persons pessoa = new Persons(classe, 0, entrada1);
                        pessoas[i] = pessoa;
                        Round round = new Round(pessoa);
                        rounds[i] = round;
                        casas[0].add(pinos[2]);
                    } else if (entrada1.equals("verde")) {
                        opcoes1[3] = "já escolhido";
                        classe = gerarClasse();
                        Persons pessoa = new Persons(classe, 0, entrada1);
                        pessoas[i] = pessoa;
                        Round round = new Round(pessoa);
                        rounds[i] = round;
                        casas[0].add(pinos[3]);
                    } else if (entrada1.equals("azul")) {
                        opcoes1[4] = "já escolhido";
                        classe = gerarClasse();
                        Persons pessoa = new Persons(classe, 0, entrada1);
                        pessoas[i] = pessoa;
                        Round round = new Round(pessoa);
                        rounds[i] = round;
                        casas[0].add(pinos[4]);
                    } else {
                        opcoes1[5] = "já escolhido";
                        classe = gerarClasse();
                        Persons pessoa = new Persons(classe, 0, entrada1);
                        pessoas[i] = pessoa;
                        Round round = new Round(pessoa);
                        rounds[i] = round;
                        casas[0].add(pinos[5]);
                    }
                    a=1;
                } else {
                    JOptionPane.showMessageDialog(null, "Escolha uma cor válida", "Número inválido", JOptionPane.ERROR_MESSAGE);
                }
                i = 1;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "tchau tchau :((", "Sair", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }while(a==0);
    }

    public char gerarClasse(){
        char classe;
        if(um != valor-1 && dois != valor-1 && tres != valor-1) {
            String[] opcoes2 = {"com sorte", "azarado", "normal"};
            Object entrada = JOptionPane.showInputDialog(null, "Escolha sua classe", "Jogadores", JOptionPane.INFORMATION_MESSAGE, icone, opcoes2, 0);
            String entrada2 = entrada.toString();
            if(entrada2.equals("com sorte")){
                um++;
                classe = 'l';
            }
            else if(entrada2.equals("azarado")){
                dois++;
                classe = 'm';
            }
            else{
                tres++;
                classe = 'n';
            }
        }
        else{
            if(um == valor-1){
                String[] opcoes2 = {"azarado", "normal"};
                Object entrada2 = JOptionPane.showInputDialog(null, "Escolha sua classe", "Jogadores", JOptionPane.INFORMATION_MESSAGE, icone, opcoes2, 0);
                if(entrada2.equals("azarado")){
                    classe = 'm';
                }
                else{
                    classe = 'n';
                }
            }
            else if(dois == valor-1){
                String[] opcoes2 = {"com sorte", "normal"};
                Object entrada2 = JOptionPane.showInputDialog(null, "Escolha sua classe", "Jogadores", JOptionPane.INFORMATION_MESSAGE, icone, opcoes2, 0);
                if(entrada2.equals("com sorte")){
                    um++;
                    classe = 'l';
                }
                else{
                    tres++;
                    classe = 'n';
                }
            }
            else{
                String[] opcoes2 = {"com sorte", "azarado"};
                Object entrada2 = JOptionPane.showInputDialog(null, "Escolha sua classe", "Jogadores", JOptionPane.INFORMATION_MESSAGE, icone, opcoes2, 0);
                if(entrada2.equals("com sorte")){
                    um++;
                    classe = 'l';
                }
                else {
                    dois++;
                    classe = 'm';
                }
            }
        }
        return classe;
    }

    public void setupTabuleiro(){
        // tabuleiro.setLocationRelativeTo(null);
        tabuleiro.setLayout(null);
        tabuleiro.setSize(916, 601);
        tabuleiro.setResizable(false);
        tabuleiro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabuleiro.setIconImage(logo.getImage());
        tabuleiro.getContentPane().setBackground(new Color(0x272420));
    }

    public void gerarCor(JPanel casa) {
        Random gerador = new Random();
        casa.setBackground(gerador.nextInt(3) == 0 ? Color.pink : Color.lightGray);
    }

    public void setupCasas(){
        casas[0] = new JPanel();
        casas[0].setBackground(new Color(0xE09B9E));
        casas[0].setBounds(0, 460, 200, 100);

        tabuleiro.add(casas[0]);

        int j;
        for(j=1; j<11; j++){
            casas[j] = new JPanel();
            casas[j].setBounds(200+((j -1)*70), 480, 68, 80);
            if(j == 4){
                casas[j].setBackground(Color.green);
            }
            else if(j == 9){
                casas[j].setBackground(Color.red);
            }
            else {
                gerarCor(casas[j]);
            }
            tabuleiro.add(casas[j]);
        }

        casas[11] = new JPanel();
        casas[11].setBounds(830, 401, 68, 78);
        casas[11].setBackground(Color.lightGray);
        tabuleiro.add(casas[11]);

        int a = 0;
        for(j =12; j <19; j++) {
            casas[j] = new JPanel();
            casas[j].setBounds(830-(a*70), 320, 68, 80);
            a++;
            if(j == 12){
                casas[j].setBackground(Color.magenta);
            }
            else if(j == 14){
                casas[j].setBackground(Color.green);
            }
            else if(j == 16){
                casas[j].setBackground(Color.cyan);
            }
            else {
                gerarCor(casas[j]);
            }
            tabuleiro.add(casas[j]);
        }

        casas[19] = new JPanel();
        casas[19].setBounds(410, 241, 68, 78);
        casas[19].setBackground(Color.yellow);
        tabuleiro.add(casas[19]);

        int b = 0;
        for(j =20; j <27; j++) {
            casas[j] = new JPanel();
            casas[j].setBounds(410+(b*70), 160, 68, 80);
            b++;
            if(j == 24){
                casas[j].setBackground(Color.red);
            }
            else if(j == 26){
                casas[j].setBackground(Color.cyan);
            }
            else {
                gerarCor(casas[j]);
            }
            tabuleiro.add(casas[j]);
        }

        casas[27] = new JPanel();
        casas[27].setBounds(832, 81, 65, 78);
        casas[27].setBackground(Color.pink);
        tabuleiro.add(casas[27]);

        int c = 0;
        for(j =28; j <38; j++) {
            casas[j] = new JPanel();
            casas[j].setBounds(836-(c*63), 0, 61, 80);
            c++;
            if(j == 29){
                casas[j].setBackground(Color.green);
            }
            else if(j == 37){
                casas[j].setBackground(Color.red);
            }
            else if(j == 34){
                casas[j].setBackground(Color.yellow);
            }
            else {
                gerarCor(casas[j]);
            }
            tabuleiro.add(casas[j]);
        }

        casas[38] = new JPanel();
        casas[38].setBounds(200, 0, 67, 80);
        casas[38].setBackground(Color.lightGray);
        tabuleiro.add(casas[38]);

        casas[39] = new JPanel();
        casas[39].setBackground(new Color(0xD5E09C));
        casas[39].setBounds(0, 0, 200, 100);
        tabuleiro.add(casas[39]);
    }

    public void mesaDados(){
        SwingUtilities.invokeLater(()->{
            JScrollPane mesa = new JScrollPane();
            mesa.setBounds(54,160,300,240);
            mesa.setBackground(new Color(0x4B3621));
            mesa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            mesa2.setPreferredSize(new Dimension(280, 1000));
            mesa2.setBackground(new Color(0xF3DFA7));
            mesa.setViewportView(mesa2);

            JLabel nome = new JLabel("JOGO DE TABULEIRO");
            nome.setFont(new Font("Dialog Input", Font.BOLD, 16));
            mesa2.add(nome);

            botaoSair();
            botaoRodar();

            mesa2.add(rodar);
            mesa2.add(sair);

            tabuleiro.add(mesa);
            tabuleiro.setVisible(true);
        });
    }

    public void botaoSair(){
        sair.setPreferredSize(new Dimension(200, 40));
        sair.setBackground(Color.white);
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "tchau tchau :((", "Sair", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        });
    }

    public void botaoRodar(){
        rodar.setPreferredSize(new Dimension(200, 40));
        rodar.setBackground(Color.white);
        rodar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesa2.removeAll();
                mesa2.add(nome);
                int i = 0;

                do {
                    if (roundAtual < valor) {
                        if (!pessoas[roundAtual].isDont_play()) {
                            rounds[roundAtual].makeRound();

                            rounds[roundAtual].applyStatusEffects(pessoas);

                            roundAtual++;
                            i = 1;
                        }
                        else{
                            passarVez();
                            pessoas[roundAtual].setDont_play(false);
                            roundAtual++;
                        }
                    }
                    else {
                        roundAtual = 0;
                    }
                }while (i == 0);

                mesa2.add(rodar);
                mesa2.add(sair);
                mesa2.revalidate();
                mesa2.repaint();
            }
        });
    }

    private static int getLowerIndex() {
        int menorValor = 42;
        int pessoaAtras = 0;
        for (int p = 0; p < valor; p++) {
            if (pessoas[p].getHouse() < menorValor) {
                menorValor = pessoas[p].getHouse();
                pessoaAtras = p; // Atualiza a posição do menor valor encontrado
            }
        }
        return pessoaAtras;
    }

    public static void addDados(int gerado1, int gerado2){
        SwingUtilities.invokeLater(() -> {
            switch (gerado1) {
                case 1 -> mesa2.add(dados[0]);
                case 2 -> mesa2.add(dados[1]);
                case 3 -> mesa2.add(dados[2]);
                case 4 -> mesa2.add(dados[3]);
                case 5 -> mesa2.add(dados[4]);
                case 6 -> mesa2.add(dados[5]);
            }

            switch (gerado2) {
                case 1 -> mesa2.add(dados[6]);
                case 2 -> mesa2.add(dados[7]);
                case 3 -> mesa2.add(dados[8]);
                case 4 -> mesa2.add(dados[9]);
                case 5 -> mesa2.add(dados[10]);
                case 6 -> mesa2.add(dados[11]);
            }
            mesa2.revalidate();
            mesa2.repaint();
        });
    }

    public static JPanel getCasasI(int i){
        return casas[i];
    }

    public static JLabel getCor(int i){
        return pinos[i];
    }

    public static JLabel getCorNome(String cor){
        return switch (cor) {
            case "vermelho" -> pinos[0];
            case "laranja" -> pinos[1];
            case "amarelo" -> pinos[2];
            case "verde" -> pinos[3];
            case "azul" -> pinos[4];
            default -> pinos[5];
        };
    }

    public static void mexerBoneco(JLabel cor, JPanel casa_atual, JPanel casa_nova){
        SwingUtilities.invokeLater(() -> {
            casa_atual.remove(cor);
            casa_nova.add(cor);
            casa_atual.revalidate();
            casa_atual.repaint();
            casa_nova.revalidate();
            casa_nova.repaint();
        });

    }

    public static void andar(String cor, int casa, int soma){
        SwingUtilities.invokeLater(()->{
            int i;
            if(cor.equals("vermelho")) {
                i = 0;
            }
            else if(cor.equals("laranja")){
                i = 1;
            }
            else if(cor.equals("amarelo")){
                i = 2;
            }
            else if(cor.equals("verde")){
                i = 3;
            }
            else if(cor.equals("azul")){
                i = 4;
            }
            else{
                i = 5;
            }
            int nova = casa+soma;
            if(nova > 39){
                nova = 39;
            }
            mexerBoneco(getCor(i), getCasasI(casa), getCasasI(nova));
        });
    }

    public static void checarVitoria(int casa, String cor){
        if(casa == 39){
            switch (cor) {
                case "vermelho" -> {
                    JOptionPane.showMessageDialog(null, "VITÓRIA DO VERMELHO", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                case "laranja" -> {
                    JOptionPane.showMessageDialog(null, "VITÓRIA DO LARANJA", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                case "amarelo" -> {
                    JOptionPane.showMessageDialog(null, "VITÓRIA DO AMARELO", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                case "verde" -> {
                    JOptionPane.showMessageDialog(null, "VITÓRIA DO VERDE", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                case "azul" -> {
                    JOptionPane.showMessageDialog(null, "VITÓRIA DO AZUL", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                case "roxo" -> {
                    JOptionPane.showMessageDialog(null, "VITÓRIA DO ROXO", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }
    }

    public static void trocar(String cor1, String cor2, int indice1, int indice2){
        SwingUtilities.invokeLater(()-> {
            Component pino1 = getCorNome(cor1);
            Component pino2 = getCorNome(cor2);

            // Realize a troca dos componentes
            casas[indice1].remove(pino1);
            casas[indice2].remove(pino2);
            casas[indice1].remove(pino1);
            casas[indice2].remove(pino2);
            casas[indice1].add(pino2);
            casas[indice2].add(pino1);

            casas[indice1].revalidate();
            casas[indice1].repaint();
            casas[indice2].revalidate();
            casas[indice2].repaint();
        });
    }

    public static void passarVez(){
        JOptionPane.showMessageDialog(null, "PASSOU A VEZ", "Passou a vez", JOptionPane.ERROR_MESSAGE);
    }

    public static int voltarUmAoInicio(){
        int i;
        String[] opcoes = new String[valor];
        for(i=0;i<valor;i++){
            opcoes[i] = pessoas[i].getColor();
        }
        Object entrada = JOptionPane.showInputDialog(null, "Escolha uma cor pra voltar no início", "Voltar pro início", JOptionPane.INFORMATION_MESSAGE, icone, opcoes, 0);
        String entrada1 = entrada.toString();
        try {
            if (entrada1.equals(opcoes[0])) {
                int casa = pessoas[0].getHouse();
                casas[casa].remove(getCorNome(opcoes[0]));
                casas[0].add(getCorNome(opcoes[0]));
                casas[casa].revalidate();
                casas[casa].repaint();
                casas[0].revalidate();
                casas[0].repaint();
                return 0;
            } else if (entrada1.equals(opcoes[1])) {
                int casa = pessoas[1].getHouse();
                casas[casa].remove(getCorNome(opcoes[1]));
                casas[0].add(getCorNome(opcoes[1]));
                casas[casa].revalidate();
                casas[casa].repaint();
                casas[0].revalidate();
                casas[0].repaint();
                return 1;
            } else if (entrada1.equals(opcoes[2])) {
                int casa = pessoas[2].getHouse();
                casas[casa].remove(getCorNome(opcoes[2]));
                casas[0].add(getCorNome(opcoes[2]));
                casas[casa].revalidate();
                casas[casa].repaint();
                casas[0].revalidate();
                casas[0].repaint();
                return 2;
            } else if (entrada1.equals(opcoes[3])) {
                int casa = pessoas[3].getHouse();
                casas[casa].remove(getCorNome(opcoes[3]));
                casas[0].add(getCorNome(opcoes[3]));
                casas[casa].revalidate();
                casas[casa].repaint();
                casas[0].revalidate();
                casas[0].repaint();
                return 3;
            } else if (entrada1.equals(opcoes[4])) {
                int casa = pessoas[4].getHouse();
                casas[casa].remove(getCorNome(opcoes[4]));
                casas[0].add(getCorNome(opcoes[4]));
                casas[casa].revalidate();
                casas[casa].repaint();
                casas[0].revalidate();
                casas[0].repaint();
                return 4;
            } else {
                int casa = pessoas[5].getHouse();
                casas[casa].remove(getCorNome(opcoes[5]));
                casas[0].add(getCorNome(opcoes[5]));
                casas[casa].revalidate();
                casas[casa].repaint();
                casas[0].revalidate();
                casas[0].repaint();
                return 5;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "tchau tchau :((", "Sair", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return -1;
    }
}
