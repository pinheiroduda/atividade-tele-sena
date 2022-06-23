public class Principal
{
    public static void main(String[] args){
        
        //instancia a classe ControleTeleSena
        ControleTeleSena controleTeleSena = new ControleTeleSena();
        
        String [] nomesDosParticipantes = {"Eduarda", "Sofia", "Julia", "Vitória","Marina", "Gabriela", "Bruna" , "Luciana", "Isabel", "Clarice", "Lucas", "Jian", "Matheus", "Luiz" ,"Oscar" , "Antônio", "Arthur", "João", "Augusto", "Caio"};
        
        /*
         * popula o array com nomes dos participantes
         * associa ao jogador a quantidade de tele senas compradas
         * insere o jogador na classe controleTeleSena e a informação da qtd de telesenas vendidas 
         */
        for (int i = 0; i < 20; i++) {
            Pessoa jogadorDaTeleSena = new Pessoa(nomesDosParticipantes[i]);
            jogadorDaTeleSena.addTeleSenasCompradas();
            controleTeleSena.inserePessoas(jogadorDaTeleSena);
            controleTeleSena.quantidadeDeTeleSenasVendidas(jogadorDaTeleSena);
        }
        
        //para cada jogador existente em Pessoa, busca suas informações
        for (Pessoa jogador : controleTeleSena.getPessoa()){
            System.out.println(jogador.toString());
            try {
                Thread.sleep(300);
            } catch (Exception e) {}
        }
        
        try {
                Thread.sleep(1000);
        } catch (Exception e) {}
        
        //realiza o sorteio dos numeros premiados
        ControleTeleSena.numeroSorteado = new int[60];
        ControleTeleSena.sortearNumero(ControleTeleSena.numeroSorteado);
        
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
        
        // exibe os números premiados
        System.out.println("\n Números Sorteados: ");
        for (int i = 0; i < 25; i++){
                System.out.print(ControleTeleSena.numeroSorteado[i]+" ");
        
            try {
                Thread.sleep(300);
            } catch (Exception e) {}
        }
        
        //calcula os valores de cada campo com base na quantidade de tele senas vendidas
        controleTeleSena.valorTotalDeVendas();
        controleTeleSena.valorDaPremiacao();
        controleTeleSena.valorDoLucro();
        
        //verifica a existência de ganhadores e calcula o prêmio de acordo com o numero de ganhadores
        Pessoa[] ganhadores = controleTeleSena.ganhador(); 
        double premioParaCadaGanhador = controleTeleSena.valorDaPremiacao() / ControleTeleSena.numeroDeGanhadores; 
        
        System.out.println("\n\n Resultado: ");
        System.out.println("Este concurso premiou "+ControleTeleSena.numeroDeGanhadores+" pessoa(s).");
        System.out.println("Nome da(s) pessoa(s) ganhadora(s): ");
        
        //para cada pessoa que é um ganhador, printa suas informações e define o valor do seu prêmio
        for(Pessoa novaPessoa : ganhadores){
            if (novaPessoa != null) {
                
                System.out.println(novaPessoa.getNome());
                
                novaPessoa.setValorDePremiacao(premioParaCadaGanhador);
            }
        }

        try {
                Thread.sleep(500);
        } catch (Exception e) {}
        
        //imprime as informações do sorteio
        System.out.println("O valor do prêmio para cada pessoa ganhadora é: R$" +premioParaCadaGanhador);
        System.out.println("\n Informações do concurso: ");
        controleTeleSena.informacoesDoConcurso();
    }
}
