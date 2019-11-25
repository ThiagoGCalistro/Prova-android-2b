package br.com.eventou.prova.Models;

public class Musics {
    private String titulo;
    private String genero;
    private String compositor;
    private int ano;
    private double duracao;

    public Musics(String titulo, String genero, String compositor, int ano, double duracao) {
        this.titulo = titulo;
        this.genero = genero;
        this.compositor = compositor;
        this.ano = ano;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
}
