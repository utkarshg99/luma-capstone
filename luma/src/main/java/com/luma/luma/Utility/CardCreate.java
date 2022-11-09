package com.luma.luma.Utility;

import com.luma.luma.Model.Card;
import com.luma.luma.Model.CardId;
import com.luma.luma.Model.Employee;
import com.luma.luma.Model.Loan;

import java.time.Instant;
import java.util.Date;

public class CardCreate {
    public static Card cardCreate(Employee emp, Loan loan){
        Card card = new Card();
        CardId cardid = new CardId();
        cardid.setEid(emp.getId());
        cardid.setLid(loan.getId());
        card.setCardid(cardid);
        card.setEid(emp);
        card.setLid(loan);
        card.setCid(Date.from(Instant.now()));
        return card;
    }
}
