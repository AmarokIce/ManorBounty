package com.djinfinite.manors_bounty.utils.data_struct;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class Quintuple<A, B, C, D, E> implements Comparable<Quintuple<A, B, C, D, E>>, Serializable {
    private A first;
    private B second;
    private C third;
    private D fourth;
    private E fifth;

    public Quintuple(A first, B second, C third, D fourth, E fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }
    public static <A, B, C, D, E> Quintuple<A, B, C, D, E> of(A first, B second, C third, D fourth, E fifth) {
        return new Quintuple<>(first, second, third, fourth, fifth);
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public C getThird() {
        return third;
    }

    public D getFourth() {
        return fourth;
    }

    public E getFifth() {
        return fifth;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public void setFifth(E fifth) {
        this.fifth = fifth;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public void setFourth(D fourth) {
        this.fourth = fourth;
    }

    public void setThird(C third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Quintuple<?, ?, ?, ?, ?> quintuple)) return false;
        return Objects.equals(first, quintuple.first) && Objects.equals(second, quintuple.second) && Objects.equals(third, quintuple.third) && Objects.equals(fourth, quintuple.fourth) && Objects.equals(fifth, quintuple.fifth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth, fifth);
    }

    @Override
    public int compareTo(@NotNull Quintuple<A, B, C, D, E> o) {
        return new CompareToBuilder()
                .append(getFirst(),o.getFirst())
                .append(getSecond(),o.getSecond())
                .append(getThird(),o.getThird())
                .append(getFourth(),o.getFourth())
                .append(getFifth(),o.getFifth())
                .toComparison();
    }
}
