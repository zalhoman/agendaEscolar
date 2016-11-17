package br.com.renanzalheiros.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.renanzalheiros.agenda.modelo.Prova;

public class ProvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);

        List<String> topicosPortugues = Arrays.asList("Sujeito", "Predicado", "Objeto direto", "Objeto indireto");
        Prova provaPortugues = new Prova("Português", "16/11/2016", topicosPortugues);

        List<String> topicosMatematica= Arrays.asList("Limite", "Derivada", "Integral", "Integral de linha");
        Prova provaMatematica = new Prova("Matemática", "16/11/2016", topicosMatematica);

        List<Prova> provas = Arrays.asList(provaPortugues, provaMatematica);

        ArrayAdapter<Prova> adapter = new ArrayAdapter<Prova>(this, android.R.layout.simple_list_item_1, provas);

        ListView lista = (ListView) findViewById(R.id.provas_lista);
        lista.setAdapter(adapter);
        
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Prova prova = (Prova) parent.getItemAtPosition(position);
                Toast.makeText(ProvasActivity.this, "Clicou na prova de " + prova, Toast.LENGTH_SHORT).show();

                Intent detalhesProva = new Intent(ProvasActivity.this, DetalhesProvaActivity.class);
                detalhesProva.putExtra("prova", prova);

                startActivity(detalhesProva);
            }
        });
    }
}
