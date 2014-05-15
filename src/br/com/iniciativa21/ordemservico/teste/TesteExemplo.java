package br.com.iniciativa21.ordemservico.teste;

import static junit.framework.Assert.*;

import org.junit.Test;

public class TesteExemplo {

	@Test
	public void testaUmMetodoQualquer(){
		int valorQueMeuMetodoDeveRetornar1 = 10;
		int valorQueMeuMetodoDeveRetornar2 = 20;
		assertEquals(valorQueMeuMetodoDeveRetornar1, umMetodoQualqu1er(1));
		assertEquals(valorQueMeuMetodoDeveRetornar2, umMetodoQualqu1er(2));
	}

	private int umMetodoQualqu1er(int nro) {
		return nro * 10;
	}
	
}
