package com.trybe.acc.java.sistemadevotacao;

/** Classe PessoaEleitora. */
public class PessoaEleitora extends Pessoa {
  private String cpf;
    
  public String getNome() {
    return super.nome;
  }
  
  @Override
  public String setNome(String nome) {
    return super.nome = nome;
  }
  
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /** Construtor. */
  PessoaEleitora(String nome, String cpf) {
    this.cpf = cpf;
    super.nome = nome;
  }

}
