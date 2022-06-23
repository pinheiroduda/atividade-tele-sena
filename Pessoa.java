public class Pessoa
{
    private String nome;
    private TeleSena[] teleSenasCompradas;
    private double valorDePremiacao;
    private int qtdDeTeleSenasCompradas = 1 + (int)(Math.random() * 15);
    
    public Pessoa(String nome){
        this.nome = nome;
        this.teleSenasCompradas = new TeleSena[qtdDeTeleSenasCompradas];
        this.valorDePremiacao = 0;
    }
    
    //métodos de acesso
    public String getNome(){
        return this.nome;
    }
    
    public TeleSena[] getTeleSenasCompradas() {
        return this.teleSenasCompradas;
    }

    public double getValorDePremiacao() {
        return this.valorDePremiacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setValorDePremiacao(double valorDePremiacao){
         this.valorDePremiacao = valorDePremiacao;
    }
    
    //método para gerenciar as tele senas compradas
    public void addTeleSenasCompradas(){
        //itera por cada espaço do array de tele senas compradas, adicionando uma instância de TeleSena em cada posição
        for (int i = 0; i < getTeleSenasCompradas().length; i++){
            TeleSena novaTeleSena = new TeleSena();
            this.teleSenasCompradas[i] = novaTeleSena;
        }
    }
    
    //retorna informações dos participantes do sorteio
    public String toString(){
        return "O nome do(a) jogador(a) é: "+nome+" e a sua compra foi de "+getTeleSenasCompradas().length+" Tele Senas.";
    }
}
