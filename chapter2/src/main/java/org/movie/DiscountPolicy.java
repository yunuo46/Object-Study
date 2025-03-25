package org.movie;

import org.movie.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
