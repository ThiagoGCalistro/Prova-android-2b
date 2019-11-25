package br.com.eventou.prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.eventou.prova.Adapters.MusicsAdapter;
import br.com.eventou.prova.Models.Musics;

public class MainActivity extends AppCompatActivity {

    private ListView musics;
    private List<Musics> lMusics = new ArrayList<Musics>();
    private MusicsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musics = (ListView) findViewById(R.id.musics);
//
//        for(int i = 0; i <= 3; i++)
//        {
//            Musics m = new Musics("Alo", "Genero", "Calistro", i, 1996, 10.2);
//            lMusics.add(m);
//        }

        mAdapter = new MusicsAdapter(this, uteis.lMusicsGlobal);
        musics.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent new_music = new Intent(MainActivity.this, new_music.class);

        if (id == R.id.new_music) {
            startActivity(new_music);
        }
        if (id == R.id.close) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
