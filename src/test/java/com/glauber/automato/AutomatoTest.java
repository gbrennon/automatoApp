package com.glauber.automato;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class AutomatoTest {
  private Automato a;

  @Before
  public void setUp() throws Exception {
    a = new Automato();
  }

  @Test
  public void testProcessaCaraterNaoExistente() throws Exception {
    a.addEstado("e0", "0", "e1", "e0", false);
    a.addEstado("e1", "1", "e2", "e1", false);
    a.addEstado("e2", "1", "e2", "e2", true);
    Assert.assertEquals(a.processa("1a10"), "Palavra contém carácter não incluso no alfabeto.");
  }
  @Test
  public void testProcessaPalavraValida() throws Exception {
    a.addEstado("e0", "0", "e1", "e0", false);
    a.addEstado("e1", "1", "e2", "e0", false);
    a.addEstado("e2", "1", "e2", "e2", true);
    Assert.assertEquals(a.processa("010"), "Automato chegou ao estado final. Estado = e2");
  }
  @Test
  public void testProcessaPalavraInvalida() throws Exception {
    a.addEstado("e0", "0", "e1", "e0", false);
    a.addEstado("e1", "1", "e2", "e1", false);
    a.addEstado("e2", "1", "e2", "e2", true);
    Assert.assertEquals(a.processa("110"), "Automato não chegou a seu estado final. Estado = e1");
  }
}