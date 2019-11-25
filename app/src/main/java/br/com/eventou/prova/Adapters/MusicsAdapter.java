package br.com.eventou.prova.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.eventou.prova.MainActivity;
import br.com.eventou.prova.Models.Musics;
import br.com.eventou.prova.R;
import br.com.eventou.prova.new_music;
import br.com.eventou.prova.uteis;

public class MusicsAdapter extends BaseAdapter {
    private Context ctx;
    private int count;
    private List<Musics> mMusics;


    public MusicsAdapter(Context ctx, List<Musics> musics) {
        this.ctx = ctx;
        this.mMusics = musics;
    }

    @Override
    public int getCount() {
        return mMusics.size();
    }

    @Override
    public Object getItem(int i) {
        return mMusics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mMusics.get(i).getAno();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.musics_list_item, viewGroup, false);
        }

        Musics music = mMusics.get(i);

        TextView titulo = view.findViewById(R.id.txt_titulo);
        TextView genero = view.findViewById(R.id.txt_genero);
        TextView compositor = view.findViewById(R.id.txt_compositor);

        titulo.setText(music.getTitulo().toString());
        genero.setText(music.getGenero().toString());
        compositor.setText(music.getCompositor().toString());

        count = i;
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                uteis.lMusicsGlobal.remove(count);
                Intent new_music = new Intent(ctx, MainActivity.class);
                ctx.startActivity(new_music);
                return true;
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}
