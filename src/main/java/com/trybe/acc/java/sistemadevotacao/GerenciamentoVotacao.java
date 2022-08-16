package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/** Classe Gerenciamento Votação. */
public class GerenciamentoVotacao {
  int totalVotos;
  ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  ArrayList<String> cpfComputado = new ArrayList<String>();

  /** Cadastra Pessoa Candidata. */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);

    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }
    
    pessoasCandidatas.add(novoCandidato);
  }

  /** Cadastra Pessoa Eleitora. */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
    
    for (int i = 0; i < pessoasEleitoras.size(); i++) {
      if (pessoasEleitoras.get(i).getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    
    pessoasEleitoras.add(novoEleitor);
  }

  /** Registra pontos da votação. */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String checaCpf : cpfComputado) {
      if (checaCpf.contains(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }
    
    for (int i = 0; i < pessoasCandidatas.size(); i++) {
      System.out.println(pessoasCandidatas.get(i));
      
      if (pessoasCandidatas.get(i).getNumero() == numeroPessoaCandidata) {
        pessoasCandidatas.get(i).receberVoto();
        totalVotos += 1;
      }
    }
    
    cpfComputado.add(cpfPessoaEleitora);
  }

  /** Exibe resultado no console. */
  public void mostrarResultado() {
    for (PessoaCandidata candidato : pessoasCandidatas) {
      if (candidato.getVotos() == 0) {
        System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
        return;
      }
    }
    
    for (PessoaCandidata candidato : pessoasCandidatas) {
      double calculo = calcularPorcentagemVotos(candidato.getVotos());
      
      StringBuilder resultado = new StringBuilder()
          .append("Nome: " + candidato.getNome())
          .append(" - ")
          .append(candidato.getVotos() + " votos ")
          .append("(" + calculo + "%" + ")");
      
      System.out.println(resultado);
    }
    
    
    System.out.println("Total de votos: " + totalVotos);
    
  }
  
  private double calcularPorcentagemVotos(int votos) {
    return (votos * 100) / totalVotos;
  }

}
