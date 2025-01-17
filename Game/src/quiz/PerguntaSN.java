package quiz;

public class PerguntaSN extends Pergunta {

    //atributos
    private static final int N_PERGUNTAS = 10;
    private final String[] perguntas = new String[N_PERGUNTAS];
    private String[] respostas = new String[N_PERGUNTAS];

    public PerguntaSN() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //metodos principais
    @Override
    public void definirPerguntas() {
    	perguntas[0] = "O efeito estufa é um evento decorrente da quebra da camada de ozônio?";
        respostas[0] = "n";

        perguntas[1] = "A partir do lixo orgânico é possivel produzir energia elétrica?";
        respostas[1] = "s";

        perguntas[2] = "A floresta Amazônica, a maior floresta tropical do mundo, nunca sofreu queimadas e quase não sofre com desmatamento ilegal.\n"
                + "Essa frase está correta?";
        respostas[2] = "n";
        
        perguntas[3] = " correto afirma que no Brasil temos mais de um decimo de toda a Ã¡gua potÃ¡vel do mundo?";
        respostas[3] = "s";
        
        perguntas[4] = "Em muitos lugares os hormônios femininos da pílula anticoncepcional liberados na Ã¡gua através dos \n"
                + "esgotos estão transformando peixes, repteis e anfíbios machos em fêmeas. Essa informação é verdadeira?";
        respostas[4] = "s";
        
        perguntas[5] = "Entre as vÃ¡rias consequências que o aquecimento global pode trazer uma delas é o aumento da atividade vulcânica,\n"
                + " o que pode desencadear diversas erupções por todo o mundo e o cobrindo de cinzas.\n"
                + "Você concorda com essa afirmação?";
        respostas[5] = "n";
        
        perguntas[6] = "A floresta amazônica a maior do mundo nunca sofreu queimadas e desmatamento";
        respostas[6] = "n";
        
        perguntas[7] = "A partir do lixo orgânico é possível obter energia elétrica ?";
        respostas[7] = "s";
        
        perguntas[8] = "Você sabia que ações diarias e rotineiras no seu dia a dia pode contribuir pode contribuir para a conservação e preservação em que vive ?";
        respostas[8] = "s";
        
        perguntas[9] = "O Brasil já produz energia a partir da combustão do lixo, produzindo vapor e energia para aquecimento residencial.";
        respostas[9] = "n";
        
        
    }

    @Override
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if (respostas[numeroPergunta].equals(resposta.toLowerCase().trim())) {
            jogador.adicionaPontos(10);
        } else {
            jogador.retiraPontos(10);
        }
    }

    @Override
    public boolean verificar(String resposta) {
        return (resposta != null && resposta.matches("s|n") && resposta != "");
    }

    public void executarPergunta(int numero, Player jogador) {
        String resposta = null;
        try {
            System.out.println(getPerguntas()[numero]);
            System.out.println("Responda com [s] para sim e [n] para não.");
            System.out.print("Resposta: ");
            resposta = super.getTecla().nextLine().toLowerCase().trim();
            verificarErro(resposta, 's');
            System.out.println("");
        } catch (RespostaInvalidaException ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            executarPergunta(numero, jogador);
        }
        checarResposta(numero, resposta, jogador);
    }

    //getters
    public static int getNumeroPerguntas() {
        return N_PERGUNTAS;
    }

    public String[] getPerguntas() {
        return perguntas;
    }

    public String[] getRespostas() {
        return respostas;
    }

}
