package com.glauber.automato;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
  private Automato a;

  @Before
  public void setUp() {
    a = new Automato();
  }

  @Test
  public void testAutomatoAValido011010111() throws Exception {
    Assert.assertEquals(App.automatoA(a, "0110101011"), "Automato chegou ao estado final. Estado = e2");
  }

  @Test
  public void testAutomatoAInvalido54678() throws Exception {
    Assert.assertEquals(App.automatoA(a, "54678"), "Palavra contém carácter não incluso no alfabeto.");
  }

  @Test
  public void testAutomatoBValido0110110() throws Exception {
    Assert.assertEquals(App.automatoB(a, "0110110"), "Automato chegou ao estado final. Estado = e3");
  }

  @Test
  public void testAutomatoBInvalido01101100() throws Exception {
    Assert.assertEquals(App.automatoB(a, "01101100"), "Automato não chegou a seu estado final. Estado = e0");

  }

  @Test
  public void testAutomatoCValido0110001() throws Exception {
    Assert.assertEquals(App.automatoC(a, "0110001"), "Automato chegou ao estado final. Estado = e3");
  }

  @Test
  public void testAutomatoCInvalido0100100101() throws Exception {
    Assert.assertEquals(App.automatoC(a, "0100100101"), "Automato não chegou a seu estado final. Estado = e0");
  }

  @Test
  public void testAutomatoDValido1010110() throws Exception {
    Assert.assertEquals(App.automatoD(a, "10101100"), "Automato chegou ao estado final. Estado = e2");
  }

  @Test
  public void testAutomatoDValido1010100() throws Exception {
    Assert.assertEquals(App.automatoD(a, "1010100"), "Automato chegou ao estado final. Estado = e2");
  }

  @Test
  public void testAutomatoDInvalido10101010() throws Exception {
    Assert.assertEquals(App.automatoD(a, "1010100"), "Automato chegou ao estado final. Estado = e2");
  }

  @Test
  public void testAutomatoEValido110010011001() throws Exception {
    Assert.assertEquals(App.automatoE(a, "110010011001"), "Automato chegou ao estado final. Estado = e0");
  }

  @Test
  public void testAutomatoEInvalido1100100011001() throws Exception {
    Assert.assertEquals(App.automatoE(a, "1100100011001"), "Automato não chegou a seu estado final. Estado = e3");
  }

  @Test
  public void testAutomatoFValido0000() throws Exception {
    Assert.assertEquals(App.automatoF(a, "0000"), "Automato chegou ao estado final. Estado = e0");
  }

  @Test
  public void testAutomatoFInvalido00010() throws Exception {
    Assert.assertEquals(App.automatoF(a, "00010"), "Automato não chegou a seu estado final. Estado = e1");
  }

  @Test
  public void testAutomatoFIValido010010() throws Exception {
    Assert.assertEquals(App.automatoF(a, "010010"), "Automato chegou ao estado final. Estado = e0");
  }
}
