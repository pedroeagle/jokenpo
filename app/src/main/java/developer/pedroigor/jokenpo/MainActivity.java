package developer.pedroigor.jokenpo;


import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int jogada, resultado = 3;
    int jogadas, vitorias, derrotas, empates = 0;
    Random randomNumberGenerate = new Random();

    public void jogadaPedra(View view){
        jogada = randomNumberGenerate.nextInt(3);
        switch(jogada) {
            case 0:
                resultado = 0;
                break;
            case 1:
                resultado = -1;
                break;
            case 2:
                resultado = 1;
                break;
        }
        escolhaUsuario(jogada);
    }
    public void jogadaPapel(View view){
        jogada = randomNumberGenerate.nextInt(3);
        switch(jogada) {
            case 0:
                resultado = 1;
                break;
            case 1:
                resultado = 0;
                break;
            case 2:
                resultado = -1;
                break;
        }
        escolhaUsuario(jogada);
    }
    public void jogadaTesoura(View view) {
        jogada = randomNumberGenerate.nextInt(3);
        switch(jogada) {
            case 0:
                resultado = -1;
                break;
            case 1:
                resultado = 1;
                break;
            case 2:
                resultado = 0;
                break;
        }
        escolhaUsuario(jogada);
    }
    public void zerar(View view){
        resultado = 100;
        this.derrotas = 0;
        this.jogadas = 0;
        this.vitorias = 0;
        this.empates = 0;
        escolhaUsuario(100);
    }
    @SuppressLint("SetTextI18n")
    public void escolhaUsuario(int jogada){
        ImageView imagemResultado = findViewById(R.id.resultado);
        TextView textoResultado = findViewById(R.id.textoResultado);
        TextView placarJogadas = findViewById(R.id.partidas);
        TextView placarVitorias = findViewById(R.id.vitorias);
        TextView placarDerrotas = findViewById(R.id.derrotas);
        TextView placarEmpates= findViewById(R.id.empates);
        switch(jogada) {
            case 0:
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case 1:
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case 2:
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
            default:
                imagemResultado.setImageResource(R.drawable.padrao);
                placarJogadas.setText(""+this.jogadas);
                placarVitorias.setText(""+this.vitorias);
                placarDerrotas.setText(""+this.derrotas);
                placarEmpates.setText(""+this.empates);
                break;
        }
        switch(this.resultado){
            case 0:
                textoResultado.setText("Empatou! '-'\nEscolha outra opção:");
                this.jogadas++;
                this.empates++;
                placarJogadas.setText(""+this.jogadas);
                placarEmpates.setText(""+this.empates);
                break;
            case 1:
                textoResultado.setText("Você ganhou! :)\nEscolha outra opção:");
                this.jogadas++;
                this.vitorias++;
                placarJogadas.setText(""+this.jogadas);
                placarVitorias.setText(""+this.vitorias);
                break;
            case -1:
                textoResultado.setText("Você perdeu! :(\nEscolha outra opção:");
                this.jogadas++;
                this.derrotas++;
                placarJogadas.setText(""+this.jogadas);
                placarDerrotas.setText(""+this.derrotas);
                break;
                default:
                    textoResultado.setText("Escolha uma opção:");
                    break;




        }
    }
}
