/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import Logic.Calculation;
import Model.Modelprogram;
/**
 *
 * @author IQBAL NOTEBOOK
 */
public class logic {
    
    public String sum_Totalprice(Modelprogram modelprogram) {
        Modelprogram cac = new Calculation();
        int sum_Totalprice = cac.calculate(modelprogram.getTicketprice(), modelprogram.getAmountticket());
        String total=(Integer.toString(sum_Totalprice));
        return total;
    }
}
