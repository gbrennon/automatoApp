package com.glauber.automato;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Automato {
  private String[] alfabeto = {"0", "1"};
  private String estadoInicial;
  private Map<String, Estado> estados = new HashMap<String, Estado>();


  public Automato() {
  }

  public void addEstado(String nome, String palavraValida, String proxEstado, String estadoAnterior, boolean estadoFinal) {
    Estado estado = new Estado(nome, palavraValida, proxEstado, estadoAnterior, estadoFinal);
    if(estados.isEmpty()) {
      this.estadoInicial = estado.getNome();
    }
    estados.put(nome, estado);
  }

  public Map<String, Estado> getEstados() {
    return estados;
  }

  public String processa(String input) {
    Estado estado = estados.get(estadoInicial);
    List<String> palavra = Arrays.asList(input.split("(?!^)"));
    for(String p: palavra) {
      if(!Arrays.asList(alfabeto).contains(p)) {
        return "Palavra contém carácter não incluso no alfabeto.";
      }
      estado = estados.get(estados.get(estado.getNome()).valida(p));

    }
    if(estado.isFinal()) {
      return "Automato chegou ao estado final. Estado = " + estado.getNome();
    } else {
      return "Automato não chegou a seu estado final. Estado = " + estado.getNome();
    }
  }
}
