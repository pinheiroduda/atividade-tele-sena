public class TeleSena
{
    private int valorDeVenda;
    private int[] conjuntoDeNumero1;
    private int[] conjuntoDeNumero2;
    
    public TeleSena(){
        this.valorDeVenda = 10; 
        this.conjuntoDeNumero1 = new int[25];
        this.conjuntoDeNumero2 = new int[25];
        insereNumerosDoConjunto(conjuntoDeNumero1);
        insereNumerosDoConjunto(conjuntoDeNumero2);
    }
    
    //métodos de acesso
    public int getValorDeVenda(){
        return this.valorDeVenda;
    }
    
    public int[] getConjuntoDeNumero1(){
        return this.conjuntoDeNumero1;
    }
    
    public int[] getConjuntoDeNumero2(){
        return this.conjuntoDeNumero2;
    }
    
    //método que gera o conjunto de números das tele senas
    public void insereNumerosDoConjunto(int[] conjuntoDeNumeros) {
        int i = 0;
        while(i < conjuntoDeNumeros.length) {
            conjuntoDeNumeros[i] = 1 + (int)(Math.random() * 60);
            boolean isEqual = false;
            for(int j = 0; j < i; j++) {
                if(conjuntoDeNumeros[i] == conjuntoDeNumeros[j]){
                    isEqual = true;
                    break;
                } 
            }
            if(!isEqual){
                i++;
            }
        }
    }
}
