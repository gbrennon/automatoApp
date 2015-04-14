package com.glauber.automato;

import org.junit.Assert;
import org.junit.Test;

public class EstadoTest {
  private Estado e;

  public EstadoTest() {
    e = new Estado("e0", "1", "e1", "e0", false);
  }

  @Test
  public void testValidaPalavraValida() throws Exception {
    String estado = e.valida("1");
    Assert.assertEquals("e1", estado);
  }

  @Test
  public void testValidaPalavraInvalida() throws Exception {
    String estado = e.valida("0");
    Assert.assertEquals("e0", estado);
  }

}