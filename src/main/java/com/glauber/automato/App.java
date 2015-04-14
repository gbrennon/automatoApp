package com.glauber.automato;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    Automato a = new Automato();
    Scanner sc = new Scanner(System.in);
    String opcao, palavra;

    while(true) {
      System.out.println("Escolha o automato a executar. Favor digitar a opção sem as aspas");
      System.out.println("Digite 'a' para a regra W contem 01.");
      System.out.println("Digite 'b' para a regra W termina em 110.");
      System.out.println("Digite 'c' para a regra W contem três zeros consecutivos.");
      System.out.println("Digite 'd' para a regra W contem 00 ou 11.");
      System.out.println("Digite 'e' para a regra W NÃO contem 3 zeros consecutivos.");
      System.out.println("Digite 'f' para a regra W tem um numero par de 1.");
      System.out.println("Digite 's' para sair.");
      System.out.println("Favor digitar a opção sem as aspas");

      opcao = sc.nextLine().toLowerCase();

      if(opcao.equals("s")) {
       break;
      }

      System.out.println("Digite palavra a ser validada: ");
      palavra = sc.nextLine();

      if (palavra != null && !palavra.isEmpty()) {
        if (opcao.equals("a")) {
          System.out.println(automatoA(a, palavra));
        } else if (opcao.equals("b")) {
          System.out.println(automatoB(a, palavra));
        } else if (opcao.equals("c")) {
          System.out.println(automatoC(a, palavra));
        } else if (opcao.equals("d")) {
          System.out.println(automatoD(a, palavra));
        } else if (opcao.equals("e")) {
          System.out.println(automatoE(a, palavra));
        } else if (opcao.equals("f")) {
          System.out.println(automatoF(a, palavra));
        }
      } else {
        System.out.println("Palavra vazia.");
      }
    }
  }

  protected static String automatoB(Automato a, String palavra) {
    a.addEstado("e0", "1", "e1", "e0", false);
    a.addEstado("e1", "1", "e2", "e0", false);
    a.addEstado("e2", "0", "e3", "e2", false);
    a.addEstado("e3", "1", "e1", "e0", true);
    return a.processa(palavra);
  }

  protected static String automatoA(Automato a, String palavra) {
    a.addEstado("e0", "0", "e1", "e0", false);
    a.addEstado("e1", "1", "e2", "e1", false);
    a.addEstado("e2", "1", "e2", "e2", true);
    return a.processa(palavra);
  }

  public static String automatoC(Automato a, String palavra) {
    a.addEstado("e0", "0", "e1", "e0", false);
    a.addEstado("e1", "0", "e2", "e0", false);
    a.addEstado("e2", "0", "e3", "e0", false);
    a.addEstado("e3", "0", "e3", "e3", true);
    return a.processa(palavra);
  }

  public static String automatoD(Automato a, String palavra) {
    a.addEstado("e0", "0", "e1", "e3", false);
    a.addEstado("e1", "0", "e2", "e3", false);
    a.addEstado("e2", "0", "e2", "e2", true);
    a.addEstado("e3", "1", "e2", "e1", false);
    return a.processa(palavra);
  }

  public static String automatoE(Automato a, String palavra) {
    a.addEstado("e0", "0", "e1", "e0", true);
    a.addEstado("e1", "0", "e2", "e0", true);
    a.addEstado("e2", "0", "e3", "e0", true);
    a.addEstado("e3", "1", "e3", "e3", false);
    return a.processa(palavra);
  }

  public static String automatoF(Automato a, String palavra) {
    a.addEstado("e0", "1", "e1", "e0", true);
    a.addEstado("e1", "1", "e0", "e1", false);
    return a.processa(palavra);
  }
}
