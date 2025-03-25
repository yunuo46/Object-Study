package org.movie.pricing;

import org.movie.DiscountPolicy;
import org.movie.Screening;
import org.movie.money.Money;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
