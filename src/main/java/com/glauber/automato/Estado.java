package com.glauber.automato;

public class Estado {
  private String palavraValida;
  private String proxEstado;
  private String estadoAnterior;
  private String nome;
  private final boolean isFinal;

  public Estado(String nome, String palavraValida,  String proxEstado, String estadoAnterior, boolean isFinal) {
    this.palavraValida = palavraValida;
    this.proxEstado = proxEstado;
    this.estadoAnterior = estadoAnterior;
    this.nome = nome;
    this.isFinal = isFinal;
  }

  public String valida(String palavra) {
    if (palavra.equals(this.palavraValida))
      return proxEstado;
    return estadoAnterior;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public boolean isFinal() {
    return isFinal;
  }
}
