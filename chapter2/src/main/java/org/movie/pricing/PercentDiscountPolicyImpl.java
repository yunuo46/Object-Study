package org.movie.pricing;

import org.movie.DiscountPolicyImpl;
import org.movie.DiscountCondition;
import org.movie.Screening;
import org.movie.money.Money;

public class PercentDiscountPolicyImpl extends DiscountPolicyImpl {
    private double percent;

    public PercentDiscountPolicyImpl(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}