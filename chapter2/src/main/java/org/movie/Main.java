package org.movie;

import org.movie.money.Money;
import org.movie.pricing.AmountDiscountPolicyImpl;
import org.movie.pricing.PercentDiscountPolicyImpl;
import org.movie.pricing.PeriodCondition;
import org.movie.pricing.SequenceCondition;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SequenceCondition sequenceCondition = new SequenceCondition(1);
        PeriodCondition periodCondition = new PeriodCondition(
                DayOfWeek.FRIDAY,
                LocalTime.of(8, 0),
                LocalTime.of(10, 0)
        );

        // 정액 할인 정책 설정 (기간 조건 & 정액 할인)
        AmountDiscountPolicyImpl amountDiscountPolicy = new AmountDiscountPolicyImpl(
                Money.wons(800),
                periodCondition
        );

        // Movie 객체 생성
        Movie avatar = new Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                amountDiscountPolicy
        );

        // 상영 정보 설정
        Screening screening = new Screening(
                avatar,
                1,
                LocalDateTime.of(2025, 3, 25, 11, 0)
        );

        // 고객 정보 설정
        Customer customer = new Customer("hyunwoo", "hyunwoo123");

        // 예약 생성
        Reservation reservation = screening.reserve(customer, 2);
        System.out.println("Reservation fee (amount discount): " + reservation.getFee());

        // 할인 정책 변경 (순번 조건 & 10% 할인)
        avatar.changeDiscountPolicy(new PercentDiscountPolicyImpl(
                0.1,
                sequenceCondition
        ));

        // 변경 후 다시 예약 생성
        Reservation newReservation = screening.reserve(customer, 2);
        System.out.println("Reservation fee (percent discount): " + newReservation.getFee());

    }
}