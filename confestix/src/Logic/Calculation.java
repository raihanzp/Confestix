/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import Model.Modelprogram;
/**
 *
 * @author IQBAL NOTEBOOK
 */
public class Calculation extends Modelprogram{
    Modelprogram modelprogram = new Modelprogram();
    @Override
        public int calculate(int a, int b) {
        return (a*b) ;
    }
}
