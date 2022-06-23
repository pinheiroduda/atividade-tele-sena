public class ControleTeleSena
{
    private Pessoa[] pessoas;
    private TeleSena teleSenas;
    
    private int quantidadeDeTeleSenaVendidas;
    private int valorTotalDeVendas;
    private double valorDaPremiacao;
    private double valorDoLucro;
    private int numeroDePessoas;
    
    static boolean ganhadorEncontrado;
    static int[] numeroSorteado;
    static int numeroDeGanhadores;
    
    public ControleTeleSena(){
        pessoas = new Pessoa[20];
        teleSenas = new TeleSena();
        this.quantidadeDeTeleSenaVendidas = 0;
        this.valorTotalDeVendas = 0;
        this.valorDaPremiacao = 0;
        this.valorDoLucro = 0;
        
    }
    
    //método de acesso
    public Pessoa[] getPessoa(){
        return this.pessoas;
    }
    
    //métodos auxiliares que setam as quantidades e valores
    public int quantidadeDeTeleSenasVendidas(Pessoa pessoaParticipante){
        this.quantidadeDeTeleSenaVendidas += pessoaParticipante.getTeleSenasCompradas().length;
        return this.quantidadeDeTeleSenaVendidas;
    }
    
    public double valorTotalDeVendas(){
        this.valorTotalDeVendas = quantidadeDeTeleSenaVendidas * teleSenas.getValorDeVenda();
        return this.valorTotalDeVendas;
    }
    
    public double valorDaPremiacao(){
        this.valorDaPremiacao = valorTotalDeVendas * 0.8;
        return this.valorDaPremiacao;
    }
    
    public double valorDoLucro(){
        this.valorDoLucro = valorTotalDeVendas * 0.2;
        return this.valorDoLucro;
    }
    
    //métodos que para inserir pessoas
    public int inserePessoas(Pessoa novaPessoa){
        pessoas[numeroDePessoas] = novaPessoa;
        return numeroDePessoas++;
    }

    //método que realiza o sorteio dos números da tele sena
    public static void sortearNumero(int[] numeroSorteado){   
        int i = 0;
        while (i < 60) {
            numeroSorteado[i] = (int) ((Math.random() * 60) + 1);
            boolean isEqual = false;
            for (int j = 0; j < i; j++) {
                if (numeroSorteado[i] == numeroSorteado[j]) {
                    isEqual = true;
                    break;
                }
            }
            if(!isEqual){
                i++;
            }
        }
    } 
    
    //verifica a existência do ganhador
    public Pessoa[] ganhador(){
        Pessoa[] ganhadores = new Pessoa[20];
        ganhadorEncontrado = false;
        int contador = 0; 
        int exibeMensagem = 1;
        
        /*
         * enquanto ganhadores forem encontrados, o numero de ganhadores é incrementado e a variável de ganhador encontrado é setada como verdadeira
         * isso é realizado levando em conta os dois conjuntos de números existentes na tele sena
         */
        
        while(!ganhadorEncontrado) {
            for (Pessoa novaPessoa : pessoas) {
                int numerosCorretos = 0;
                for (TeleSena teleSena : novaPessoa.getTeleSenasCompradas()) {
                    numerosCorretos= 0;
                    for (int numeroDoConjunto : teleSena.getConjuntoDeNumero1()){
                        for (int i = 0; i < 25 + contador; i++) { 
                            if (numeroSorteado[i] == numeroDoConjunto) {
                                numerosCorretos++; 
                                if (numerosCorretos == 25){
                                    ganhadores[numeroDeGanhadores] = novaPessoa;
                                    numeroDeGanhadores++;
                                    ganhadorEncontrado = true;
                                }
                            }
                        }
                    }
                    numerosCorretos = 0;
                    for (int numeroDoConjunto : teleSena.getConjuntoDeNumero2()) {
                        for (int i = 0; i < 25 + contador; i++) { 
                            if (numeroSorteado[i] == numeroDoConjunto) {
                                numerosCorretos++; 
                                if (numerosCorretos == 25) {
                                    ganhadores[numeroDeGanhadores] = novaPessoa;
                                    numeroDeGanhadores++;
                                    ganhadorEncontrado = true;
                                }
                            }
                        }
                    }
                }
             }
            contador++;
            
            //caso não existam ganhadores após o sorteio dos 25 números, números continuam sendo sorteados até que exista um ganhador
            if(!ControleTeleSena.ganhadorEncontrado){
                
                while(exibeMensagem == 1){
                    System.out.println("\nNão foram encontrados ganhadores, o sorteio de números continuará até que se encontre alguma Tele Sena premiada");
                    exibeMensagem++;
                }
                
                System.out.print("  " + numeroSorteado[25 + contador] );
                try {
                    Thread.sleep(200);
                } catch (Exception e) {}
            }
        }
        return ganhadores;
    }
    
    //imprime as informações gerais do concurso
    public void informacoesDoConcurso(){
        System.out.println("O valor total das vendas foi: R$"+this.valorTotalDeVendas);
        System.out.println("O valor da premiação total foi: R$"+this.valorDaPremiacao);
        System.out.println("O lucro do concurso foi: R$"+this.valorDoLucro);
        System.out.println("A quantidade de Tele Senas vendida foi: "+this.quantidadeDeTeleSenaVendidas);
    }
}
