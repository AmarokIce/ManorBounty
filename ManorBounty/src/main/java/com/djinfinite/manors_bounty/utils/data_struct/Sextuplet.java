package com.djinfinite.manors_bounty.utils.data_struct;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class Sextuplet<A, B, C, D, E, F> implements Comparable<Sextuplet<A, B, C, D, E, F>>, Serializable {
    private A first;
    private B second;
    private C third;
    private D fourth;
    private E fifth;
    private F sixth;

    public Sextuplet(A first, B second, C third, D fourth, E fifth, F sixth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
    }

    public static <A, B, C, D, E, F> Sextuplet<A, B, C, D, E, F> of(A first, B second, C third, D fourth, E fifth, F sixth) {
        return new Sextuplet<>(first, second, third, fourth, fifth, sixth);
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public C getThird() {
        return third;
    }

    public void setThird(C third) {
        this.third = third;
    }

    public D getFourth() {
        return fourth;
    }

    public void setFourth(D fourth) {
        this.fourth = fourth;
    }

    public E getFifth() {
        return fifth;
    }

    public void setFifth(E fifth) {
        this.fifth = fifth;
    }

    public F getSixth() {
        return sixth;
    }

    public void setSixth(F sixth) {
        this.sixth = sixth;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sextuplet<?, ?, ?, ?, ?, ?> sextuplet)) return false;
        return Objects.equals(first, sextuplet.first) && Objects.equals(second, sextuplet.second) && Objects.equals(third, sextuplet.third) && Objects.equals(fourth, sextuplet.fourth) && Objects.equals(fifth, sextuplet.fifth) && Objects.equals(sixth, sextuplet.sixth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth, fifth, sixth);
    }

    @Override
    public int compareTo(@NotNull Sextuplet<A, B, C, D, E, F> o) {
        return new CompareToBuilder()
                .append(getFirst(), o.getFirst())
                .append(getSecond(), o.getSecond())
                .append(getThird(), o.getThird())
                .append(getFourth(), o.getFourth())
                .append(getFifth(), o.getFifth())
                .append(getSixth(), o.getSixth())
                .toComparison();
    }
}
