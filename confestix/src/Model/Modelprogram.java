/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
/**
 *
 * @author IQBAL NOTEBOOK
 */
public class Modelprogram {

    public int ticketprice;
    public int amountticket;
    
    public int getAmountticket(){
        return amountticket;
    }
    public void setAmountticket(int amountticket){
        this.amountticket = amountticket;
    }
    
    public int getTicketprice(){
        return ticketprice;
    }
    public void setTicketprice(int ticketprice){
        this.ticketprice = ticketprice;
    }
    
    public int calculate(int a, int b){
		return (a * b) ;
	}
}
