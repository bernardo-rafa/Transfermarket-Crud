package br.com.transfermarket.model;

public class Jogador {
    private Long id;
    private String nome;
    private String clube;
    private String posicao;
    private Integer numeroCamisa;

    public Jogador() {
    }

    public Jogador(Long id, String nome, String clube, String posicao, Integer numeroCamisa) {
        this.id = id;
        this.nome = nome;
        this.clube = clube;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(Integer numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }
}