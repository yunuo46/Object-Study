package org.movie.pricing;

import org.movie.DiscountPolicyImpl;
import org.movie.DiscountCondition;
import org.movie.Screening;
import org.movie.money.Money;

public class AmountDiscountPolicyImpl extends DiscountPolicyImpl {
    private Money discountAmount;

    public AmountDiscountPolicyImpl(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}