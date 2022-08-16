package com.trybe.acc.java.sistemadevotacao;

/** Classe PessoaCandidata. */
public class PessoaCandidata extends Pessoa {
  private int votos;
  private int numero;

  public String getNome() {
    return super.nome;
  }

  @Override
  public String setNome(String nome) {
    return super.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    votos += 1;
  }
  
  PessoaCandidata(String nome, int numero) {
    super.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

}
