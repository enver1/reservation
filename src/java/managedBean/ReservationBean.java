/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author casa
 */
@ManagedBean
@SessionScoped
public class ReservationBean {
private static final long serialVersionUID = -7258677092121565610L;
    private String name = "";
    private String totalValue = "120.00";
    private String email = "";
    private String emailAgain = "";
    private String date = "";
    private String tickets = "1";
    private String price = "120";
    private Map<String, Object> ticketAttrs;

    /**
     * Inicializar el mapa en el constructor de la siguiente manera:
     */
    public ReservationBean() {
        this.ticketAttrs = new HashMap<>();
        this.ticketAttrs.put("type", "number");
        this.ticketAttrs.put("min", "1");
        this.ticketAttrs.put("max", "4");
        this.ticketAttrs.put("required", "required");
        this.ticketAttrs.put("title",
                "Enter a number between 1 and 4 inclusive.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAgain() {
        return emailAgain;
    }

    public void setEmailAgain(String emailAgain) {
        this.emailAgain = emailAgain;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Map<String, Object> getTicketAttrs() {
        return ticketAttrs;
    }

    public void setTicketAttrs(Map<String, Object> ticketAttrs) {
        this.ticketAttrs = ticketAttrs;
    }

    public void calculateTotal(AjaxBehaviorEvent event)
            throws AbortProcessingException {
        int ticketsNum = 1;
        int ticketPrice = 0;
        int total;

        if (tickets.trim().length() > 0) {
            ticketsNum = Integer.parseInt(tickets);
        }
        if (price.trim().length() > 0) {
            ticketPrice = Integer.parseInt(price);
        }
        total = (ticketsNum * ticketPrice);
        totalValue = String.valueOf(total) + ".00";
    }

    public void clear(AjaxBehaviorEvent event)
            throws AbortProcessingException {
        name = "";
        email = "";
        emailAgain = "";
        date = "";
        price = "120.00";
        totalValue = "120.00";
        tickets = "1";
    }
}