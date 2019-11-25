package br.com.eventou.prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.eventou.prova.Models.Musics;

public class new_music extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner_categoria;
    private SeekBar seekBar_ano;
    private SeekBar seekBar_duracao;
    private TextView txt_ano;
    private TextView txt_duracao;
    private EditText txt_titulo;
    private EditText txt_compositor;
    private Button btn_confirmar;
    private List<Musics> lMusics = new ArrayList<Musics>();

    int ano;
    String categoria;
    float duracao;
    int minimumValue = 1940;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_music);

        spinner_categoria = findViewById(R.id.spinner_categoria);
        seekBar_ano = findViewById(R.id.seekBar_ano);
        seekBar_duracao = findViewById(R.id.seekBar_duracao);
        txt_ano = findViewById(R.id.txt_ano);
        txt_duracao = findViewById(R.id.txt_duracao);
        btn_confirmar = findViewById(R.id.btn_confirmar);

        txt_titulo = findViewById(R.id.txt_titulo);
        txt_compositor = findViewById(R.id.txt_compositor);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categoria, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);;
        spinner_categoria.setAdapter(adapter);
        spinner_categoria.setOnItemSelectedListener(this);

        seekBar_ano.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txt_ano.setText(String.valueOf(i));
                ano = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() < minimumValue)
                    seekBar.setProgress(minimumValue);
            }
        });

        seekBar_duracao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float value = (float) ((float)i / 10.0);
                txt_duracao.setText(String.valueOf(value));
                duracao = value;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Musics m = new Musics(txt_titulo.getText().toString(), categoria, txt_compositor.getText().toString(), ano, duracao);
                lMusics.add(m);
                uteis.lMusicsGlobal.add(m);
                Intent new_music = new Intent(new_music.this, MainActivity.class);
                startActivity(new_music);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        categoria = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
