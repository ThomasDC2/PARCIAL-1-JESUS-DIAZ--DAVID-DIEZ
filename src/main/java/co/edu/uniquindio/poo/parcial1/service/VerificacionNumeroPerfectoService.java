package co.edu.uniquindio.poo.parcial1.service;

import java.math.BigInteger;

public class VerificacionNumeroPerfectoService {
    public boolean esNumeroPerfecto(String numeroTexto) {
        if (numeroTexto == null || !numeroTexto.matches("\\d+")) {
            return false;
        }

        BigInteger numero = new BigInteger(numeroTexto);
        if (numero.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }

        BigInteger sumaDivisores = BigInteger.ONE;
        for (BigInteger divisor = BigInteger.TWO;
             divisor.multiply(divisor).compareTo(numero) <= 0;
             divisor = divisor.add(BigInteger.ONE)) {
            if (numero.mod(divisor).equals(BigInteger.ZERO)) {
                sumaDivisores = sumaDivisores.add(divisor);
                BigInteger divisorComplementario = numero.divide(divisor);
                if (!divisorComplementario.equals(divisor)) {
                    sumaDivisores = sumaDivisores.add(divisorComplementario);
                }
                if (sumaDivisores.compareTo(numero) > 0) {
                    return false;
                }
            }
        }

        return sumaDivisores.equals(numero);
    }
}
