/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

/**
 *
 * @author ferreira
 */
public class Jogo {
    private int[] Player=new int[2];
    public int[] Tabuleiro=new int[9];
    private static int Maquina=1,Humano=0,Atual;
    private int Numero_de_jogadas,Vencedor,Jogada;

    public Jogo() {
        Player[0]=1;
        Player[1]=-1;
        Tabuleiro[0]=0;
        Tabuleiro[1]=0;
        Tabuleiro[2]=0;
        Tabuleiro[3]=0;
        Tabuleiro[4]=0;
        Tabuleiro[5]=0;
        Tabuleiro[6]=0;
        Tabuleiro[7]=0;
        Tabuleiro[8]=0;
        Numero_de_jogadas=0;    
        Vencedor=0;
    }

    public void Escolher1() {
        Atual=0;
    }
    public void Escolher2() {
        Atual=1;
    }
    public void Reiniciar_Partida(){
        Tabuleiro[0]=0;
        Tabuleiro[1]=0;
        Tabuleiro[2]=0;
        Tabuleiro[3]=0;
        Tabuleiro[4]=0;
        Tabuleiro[5]=0;
        Tabuleiro[6]=0;
        Tabuleiro[7]=0;
        Tabuleiro[8]=0;
        Numero_de_jogadas=0;    
        Vencedor=0;
    }
    public void QuemVenceu(){
        if((Tabuleiro[0]+Tabuleiro[1]+Tabuleiro[2])==3){
            Vencedor=1;
        }
        else if((Tabuleiro[3]+Tabuleiro[4]+Tabuleiro[5])==3){
            Vencedor=1;
        }
        else if((Tabuleiro[6]+Tabuleiro[7]+Tabuleiro[8])==3){
            Vencedor=1;
        }
        else if((Tabuleiro[0]+Tabuleiro[3]+Tabuleiro[6])==3){
            Vencedor=1;
        }
        else if((Tabuleiro[1]+Tabuleiro[4]+Tabuleiro[7])==3){
            Vencedor=1;
        }
        else if((Tabuleiro[2]+Tabuleiro[8]+Tabuleiro[5])==3){
            Vencedor=1;
        }
        else if((Tabuleiro[0]+Tabuleiro[4]+Tabuleiro[8])==3){
            Vencedor=1;
        }
        else if((Tabuleiro[2]+Tabuleiro[4]+Tabuleiro[6])==3){
            Vencedor=1;
        }
        //Vitorias do jogador 1
        if((Tabuleiro[0]+Tabuleiro[1]+Tabuleiro[2])==-3){
            Vencedor=2;
        }
        else if((Tabuleiro[3]+Tabuleiro[4]+Tabuleiro[5])==-3){
            Vencedor=2;
        }
        else if((Tabuleiro[6]+Tabuleiro[7]+Tabuleiro[8])==-3){
            Vencedor=2;
        }
        else if((Tabuleiro[0]+Tabuleiro[3]+Tabuleiro[6])==-3){
            Vencedor=2;
        }
        else if((Tabuleiro[1]+Tabuleiro[4]+Tabuleiro[7])==-3){
            Vencedor=2;
        }
        else if((Tabuleiro[2]+Tabuleiro[8]+Tabuleiro[5])==-3){
            Vencedor=2;
        }
        else if((Tabuleiro[0]+Tabuleiro[4]+Tabuleiro[8])==-3){
            Vencedor=2;
        }
        else if((Tabuleiro[2]+Tabuleiro[4]+Tabuleiro[6])==-3){
            Vencedor=2;
        }
        //Vitoria jogador 2
        else if(Numero_de_jogadas==9 & Vencedor==0){
            Vencedor=3;
        }
        
}  

    public void setJogada(int Jogada) {
        this.Jogada = Jogada;
    }
    public void setJogada_Machine(int Jogada) {
        //Socket
    }

public int getAtual() {
    return Atual;
}

public int getNumero_de_jogadas() {
    return Numero_de_jogadas;
}

public int getVencedor() {
    return Vencedor;
}


public boolean QuemJoga(){
    if(Atual == Humano){
        return true;
    }
    return false;
    


}   

public boolean Jogar(boolean QuemJoga,int Dificuldade){
    if(Dificuldade==0){
    if(QuemJoga==true){
                if(Tabuleiro[Jogada]==0){
            Tabuleiro[Jogada]=Player[Atual];
            if(Atual==0)
                Atual=1;
            else
                Atual=0;
        this.QuemVenceu();
        if(Vencedor==0 & Numero_de_jogadas+2<=9){
            Tabuleiro[MinMax()]=Player[Atual];      
            if(Atual==0)
                Atual=1;
            else
                Atual=0;
            Numero_de_jogadas=Numero_de_jogadas+2;
        }
        else{
        Numero_de_jogadas=Numero_de_jogadas+1;
        }
            
   
            return true;
        }
        else{
            return false;
        }
    }
    else{
        Tabuleiro[MinMax()]=Player[Atual];
        if(Atual==0)
                Atual=1;
            else
                Atual=0;
            Numero_de_jogadas=Numero_de_jogadas+1;
            return true;
    } 
    }
    if(Dificuldade==1){
    if(QuemJoga==true){
                if(Tabuleiro[Jogada]==0){
            Tabuleiro[Jogada]=Player[Atual];
            if(Atual==0)
                Atual=1;
            else
                Atual=0;
        this.QuemVenceu();
        if(Vencedor==0 & Numero_de_jogadas+2<=9){
            Tabuleiro[MinMaxHard()]=Player[Atual];      
            if(Atual==0)
                Atual=1;
            else
                Atual=0;
            Numero_de_jogadas=Numero_de_jogadas+2;
        }
        else{
        Numero_de_jogadas=Numero_de_jogadas+1;
        }
            
   
            return true;
        }
        else{
            return false;
        }
    }
    else{
        Tabuleiro[MinMaxHard()]=Player[Atual];
        if(Atual==0)
                Atual=1;
            else
                Atual=0;
            Numero_de_jogadas=Numero_de_jogadas+1;
            return true;
    } 
    }
    return false;    
}
private int[] PreencheH(int[] matriz){
    int[] matriz_=new int[9];
    matriz_=matriz.clone();
    for(int i=0;i<9;i++){
        if(matriz_[i]==0){
            matriz_[i]=1;
        }
    }
    return matriz_;
}
private int[] PreencheM(int[] matriz){
    int[] matriz_=new int[9];
    matriz_=matriz.clone();
    for(int i=0;i<9;i++){
        if(matriz_[i]==0){
            matriz_[i]=-1;
        }
    }
    return matriz_;
}
public int MinMax(){
    int jogada=0;
    int chanceH=0,chanceM=0,chanceMax=-10;
    int[] matriz=new int[9],matrizH=new int[9],matrizM=new int[9];
    for(int i=0;i<9;i++){
        matriz=this.Tabuleiro.clone();
        chanceH=0;
        chanceM=0;
        if(matriz[i]==0){
        matriz[i]=-1;
        matrizH=PreencheH(matriz);
        matrizM=PreencheM(matriz);
        
        if(matrizH[0]+matrizH[1]+matrizH[2]==3)
            chanceH++;
        if(matrizM[0]+matrizM[1]+matrizM[2]==-3)
            chanceM++;
        if(matrizH[3]+matrizH[4]+matrizH[5]==3)
            chanceH++;
        if(matrizM[3]+matrizM[4]+matrizM[5]==-3)
            chanceM++;
        if(matrizH[6]+matrizH[7]+matrizH[8]==3)
            chanceH++;
        if(matrizM[6]+matrizM[7]+matrizM[8]==-3)
            chanceM++;
        if(matrizH[0]+matrizH[3]+matrizH[6]==3)
            chanceH++;
        if(matrizM[0]+matrizM[3]+matrizM[6]==-3)
            chanceM++;
        if(matrizH[1]+matrizH[4]+matrizH[7]==3)
            chanceH++;
        if(matrizM[1]+matrizM[4]+matrizM[7]==-3)
            chanceM++;
        if(matrizH[2]+matrizH[5]+matrizH[8]==3)
            chanceH++;
        if(matrizM[2]+matrizM[5]+matrizM[8]==-3)
            chanceM++;
        if(matrizH[0]+matrizH[4]+matrizH[8]==3)
            chanceH++;
        if(matrizM[0]+matrizM[4]+matrizM[8]==-3)
            chanceM++;
        if(matrizH[2]+matrizH[4]+matrizH[6]==3)
            chanceH++;
        if(matrizM[2]+matrizM[4]+matrizM[6]==-3)
            chanceM++;
        if(chanceM-chanceH>chanceMax){
            chanceMax=chanceM-chanceH;
            jogada=i;
        }
        
     }
    }
    
    
    return jogada;
    
}
public boolean Venceu(int[] matriz){
    if(Math.abs(matriz[0]+matriz[1]+matriz[2])==3){
            return true;
        }
        else if(Math.abs(matriz[3]+matriz[4]+matriz[5])==3){
            return true;
        }
        else if(Math.abs(matriz[6]+matriz[7]+matriz[8])==3){
            return true;
        }
        else if(Math.abs(matriz[0]+matriz[3]+matriz[6])==3){
            return true;
        }
        else if(Math.abs(matriz[1]+matriz[4]+matriz[7])==3){
            return true;
        }
        else if(Math.abs(matriz[2]+matriz[8]+matriz[5])==3){
            return true;
        }
        else if(Math.abs(matriz[0]+matriz[4]+matriz[8])==3){
            return true;
        }
        else if(Math.abs(matriz[2]+matriz[4]+matriz[6])==3){
            return true;
        }
    return false;
    
}
public int MinMaxHard(){
        int jogada=0;
    int chanceH=0,chanceM=0,chanceMax=-10;
    int[] matriz=new int[9],matrizH=new int[9],matrizM=new int[9];
    for(int i=0;i<9;i++){
        matriz=this.Tabuleiro.clone();
        chanceH=0;
        chanceM=0;
        if(Numero_de_jogadas==2){
            if((matriz[0]==1 & matriz[8]==1) | (matriz[2]==1 & matriz[6]==1)){   
                return 3;
            }
            
            if((matriz[0]==1 | matriz[2]==1) & matriz[7]==1){
                return 6;
        }
            if((matriz[8]==1 | matriz[2]==1) & matriz[3]==1){
                return 6;
        }
            if((matriz[8]==1 | matriz[6]==1) & matriz[1]==1){
                return 0;
        }
        if((matriz[0]==1 | matriz[6]==1) & matriz[7]==1){
                return 5;
        }    
           
        }
        if(matriz[i]==0){
        matriz[i]=-1;
        if(Venceu(matriz)){
            return i;      }  
        matriz[i]=1;
        if(Venceu(matriz)){
            return i;      
        }  
        matriz[i]=-1;
        
        //MinMax
        matrizH=PreencheH(matriz);
        matrizM=PreencheM(matriz);
        
        if(matrizH[0]+matrizH[1]+matrizH[2]==3)
            chanceH++;
        if(matrizM[0]+matrizM[1]+matrizM[2]==3)
            chanceM++;
        if(matrizH[3]+matrizH[4]+matrizH[5]==3)
            chanceH++;
        if(matrizM[3]+matrizM[4]+matrizM[5]==3)
            chanceM++;
        if(matrizH[6]+matrizH[7]+matrizH[8]==3)
            chanceH++;
        if(matrizM[6]+matrizM[7]+matrizM[8]==3)
            chanceM++;
        if(matrizH[0]+matrizH[3]+matrizH[6]==3)
            chanceH++;
        if(matrizM[0]+matrizM[3]+matrizM[6]==3)
            chanceM++;
        if(matrizH[1]+matrizH[4]+matrizH[7]==3)
            chanceH++;
        if(matrizM[1]+matrizM[4]+matrizM[7]==3)
            chanceM++;
        if(matrizH[2]+matrizH[5]+matrizH[8]==3)
            chanceH++;
        if(matrizM[2]+matrizM[5]+matrizM[8]==3)
            chanceM++;
        if(matrizH[0]+matrizH[4]+matrizH[8]==3)
            chanceH++;
        if(matrizM[0]+matrizM[4]+matrizM[8]==3)
            chanceM++;
        if(matrizH[2]+matrizH[4]+matrizH[6]==3)
            chanceH++;
        if(matrizM[2]+matrizM[4]+matrizM[6]==3)
            chanceM++;
        if(chanceM-chanceH>chanceMax){
            chanceMax=chanceM-chanceH;
            jogada=i;
        }
        
     }
    }
    return jogada;
    
    
}
            
}
    
    
    
    

