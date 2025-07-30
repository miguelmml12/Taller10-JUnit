/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorsmp;
import org.junit.jupiter.api.*;
/**
 *
 * @author angel
 */
public class CalculatorSMPmain {
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DEL MÉTODO Solve ===");
        testSolveSumaSimple();
        testSolveRestaSimple();
        testSolveMultiplicacionSimple();
        testSolveDivisionExacta();
        testSolveJerarquiaOperaciones();
        testSolveCombinada();
        testSolveDivisionNoExacta();
        testSolveEntradaVacia();
        testSolveExpresionInvalida();

        System.out.println("\n=== PRUEBAS DEL MÉTODO MakeFormula ===");
        testMakeFormulaNoNula();
        testMakeFormulaContieneOperadores();
        testMakeFormulaEmpiezaNumero();
        testMakeFormulaLongitudMinima();
        testMakeFormulaAleatoriedad();
    }

    // ---------- PRUEBAS DEL MÉTODO Solve ----------

    @DisplayName("Solve: suma simple 2+3 = 5")
    static void testSolveSumaSimple() {
        String resultado = Operations.Solve("2+3");
        System.out.println("2+3 = " + resultado + " → " + (resultado.equals("5") ? "OK" : "FALLO"));
    }

    @DisplayName("Solve: resta simple 8-3 = 5")
    static void testSolveRestaSimple() {
        String resultado = Operations.Solve("8-3");
        System.out.println("8-3 = " + resultado + " → " + (resultado.equals("5") ? "OK" : "FALLO"));
    }

    @DisplayName("Solve: multiplicación simple 4*6 = 24")
    static void testSolveMultiplicacionSimple() {
        String resultado = Operations.Solve("4*6");
        System.out.println("4*6 = " + resultado + " → " + (resultado.equals("24") ? "OK" : "FALLO"));
    }

    @DisplayName("Solve: división exacta 20/4 = 5")
    static void testSolveDivisionExacta() {
        String resultado = Operations.Solve("20/4");
        System.out.println("20/4 = " + resultado + " → " + (resultado.equals("5") ? "OK" : "FALLO"));
    }

    @DisplayName("Solve: jerarquía de operaciones 2+3*4 = 14")
    static void testSolveJerarquiaOperaciones() {
        String resultado = Operations.Solve("2+3*4");
        System.out.println("2+3*4 = " + resultado + " → " + (resultado.equals("14") ? "OK" : "FALLO"));
    }

    @DisplayName("Solve: expresión con múltiples operadores 10+2*3-4/2 = 14")
    static void testSolveCombinada() {
        String resultado = Operations.Solve("10+2*3-4/2");
        System.out.println("10+2*3-4/2 = " + resultado + " → " + (resultado.equals("14") ? "OK" : "FALLO"));
    }

    @DisplayName("Solve: división no exacta 5/2 = 2 o 2.5")
    static void testSolveDivisionNoExacta() {
        String resultado = Operations.Solve("5/2");
        boolean ok = resultado.equals("2") || resultado.equals("2.5");
        System.out.println("5/2 = " + resultado + " → " + (ok ? "OK" : "FALLO"));
    }

    @DisplayName("Solve: entrada vacía devuelve 0 o error manejado")
    static void testSolveEntradaVacia() {
        String resultado = Operations.Solve("");
        boolean ok = resultado.equals("0") || resultado.toLowerCase().contains("error");
        System.out.println("'' = " + resultado + " → " + (ok ? "OK" : "FALLO"));
    }

    @DisplayName("Solve: expresión mal formada debe devolver error o valor seguro")
    static void testSolveExpresionInvalida() {
        String resultado = Operations.Solve("++*23");
        boolean ok = resultado.equals("0") || resultado.toLowerCase().contains("error");
        System.out.println("++*23 = " + resultado + " → " + (ok ? "OK" : "FALLO"));
    }

    // ---------- PRUEBAS DEL MÉTODO MakeFormula ----------

    @DisplayName("MakeFormula: genera fórmula no nula")
    static void testMakeFormulaNoNula() {
        String formula = Operations.MakeFormula();
        System.out.println("Fórmula generada (no nula): " + (formula != null ? "OK" : "FALLO"));
    }

    @DisplayName("MakeFormula: fórmula contiene operadores válidos")
    static void testMakeFormulaContieneOperadores() {
        String formula = Operations.MakeFormula();
        boolean contiene = formula.contains("+") || formula.contains("-") || formula.contains("*") || formula.contains("/");
        System.out.println("Contiene operadores: " + (contiene ? "OK" : "FALLO"));
    }

    @DisplayName("MakeFormula: fórmula empieza con número")
    static void testMakeFormulaEmpiezaNumero() {
        String formula = Operations.MakeFormula();
        boolean empieza = Character.isDigit(formula.charAt(0));
        System.out.println("Empieza con número: " + (empieza ? "OK" : "FALLO"));
    }

    @DisplayName("MakeFormula: longitud mínima de 3 caracteres")
    static void testMakeFormulaLongitudMinima() {
        String formula = Operations.MakeFormula();
        System.out.println("Longitud >= 3: " + (formula.length() >= 3 ? "OK" : "FALLO"));
    }

    @DisplayName("MakeFormula: múltiples llamadas producen distintas fórmulas")
    static void testMakeFormulaAleatoriedad() {
        String f1 = Operations.MakeFormula();
        String f2 = Operations.MakeFormula();
        boolean diferentes = !f1.equals(f2);
        System.out.println("Fórmulas distintas: " + (diferentes ? "OK" : "FALLO"));
    }

}