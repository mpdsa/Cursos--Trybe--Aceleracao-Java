package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/** Classe Principal. */
public class Principal {
  
  /** Método principal. */
  public static void main(String[] args) {
    short opcao = 0;
    int idCandidatoEleitor = 0;
    String nome;
    String cpf;
    String novaLinha = System.lineSeparator();
    StringBuilder menuCandidato = new StringBuilder()
        .append("Cadastrar pessoa candidata?").append(novaLinha)
        .append("1 - Sim").append(novaLinha)
        .append("2 - Não").append(novaLinha)
        .append("Entre com o número correspondente à opção desejada:");
    String menuCandidatoNome = "Entre com o nome da pessoa candidata:";
    String menuCandidatoNumero = "Entre com o número da pessoa candidata:";
    Scanner scan = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    
    do {
      System.out.println(menuCandidato);
      opcao = scan.nextShort();
      
      if (opcao == 1) {
        System.out.println(menuCandidatoNome);
        nome = scan.next();
        System.out.println(menuCandidatoNumero);
        idCandidatoEleitor = scan.nextInt();
        
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, idCandidatoEleitor);
      }
    } while (opcao != 2);
    
    
    opcao = 0;
    StringBuilder menuEleitor = new StringBuilder()
        .append("Cadastrar pessoa eleitora?").append(novaLinha)
        .append("1 - Sim").append(novaLinha)
        .append("2 - Não").append(novaLinha)
        .append("Entre com o número correspondente à opção desejada:");
    String menuEleitorNome = "Entre com o nome da pessoa eleitora:";
    String menuEleitorCpf = "Entre com o cpf da pessoa eleitora:";
    
    do {
      System.out.println(menuEleitor);
      opcao = scan.nextShort();
      
      if (opcao == 1) {
        System.out.println(menuEleitorNome);
        nome = scan.next();
        System.out.println(menuEleitorCpf);
        cpf = scan.next();
        
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (opcao != 2);
    
    
    opcao = 0;
    StringBuilder menuVotacao = new StringBuilder()
        .append("Entre com o número correspondente à opção desejada:").append(novaLinha)
        .append("1 - Votar").append(novaLinha)
        .append("2 - Resultado Parcial").append(novaLinha)
        .append("3 - Finalizar Votação").append(novaLinha);

    do {
      System.out.println(menuVotacao);
      opcao = scan.nextShort();
      
      if (opcao == 1) {
        System.out.println(menuEleitorCpf);
        cpf = scan.next();
        System.out.println(menuCandidatoNumero);
        idCandidatoEleitor = scan.nextInt();
        
        gerenciamentoVotacao.votar(cpf, idCandidatoEleitor);
      }
      
    } while (opcao != 3);
    
    scan.close();
    
    gerenciamentoVotacao.mostrarResultado();
  }

}
