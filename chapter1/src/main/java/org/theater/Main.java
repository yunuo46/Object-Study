package org.theater;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        TicketOffice ticketOffice = new TicketOffice(100L, new Ticket(), new Ticket());
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

        Invitation invitation = new Invitation(LocalDateTime.now());
        Audience audience = new Audience(new Bag(invitation, 100L));
        theater.enter(audience);
    }
}