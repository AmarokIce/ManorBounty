package com.djinfinite.manors_bounty.utils.data_struct;

import org.apache.commons.lang3.builder.CompareToBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Quad<V1,V2,V3,V4> implements Comparable<Quad<V1,V2,V3,V4>>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private V1 value1;
    private V2 value2;
    private V3 value3;
    private V4 value4;

    public Quad(V1 value1, V2 value2, V3 value3, V4 value4) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }


    public static <V1,V2,V3,V4> Quad<V1,V2,V3,V4> of(final V1 value1,final V2 value2,final V3 value3,final V4 value4) {
        return new Quad<>(value1, value2, value3,value4);
    }

    @Override
    public int compareTo(final Quad<V1,V2,V3,V4> other) {
        return new CompareToBuilder().append(getValue1(), other.getValue1())
                .append(getValue2(), other.getValue2())
               .append(getValue3(), other.getValue3())
              .append(getValue4(), other.getValue4())
            .toComparison();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Quad<?, ?, ?, ?> quad)) return false;
        return Objects.equals(value1, quad.value1) && Objects.equals(value2, quad.value2) && Objects.equals(value3, quad.value3) && Objects.equals(value4, quad.value4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value1, value2, value3, value4);
    }

    public V1 getValue1(){
        return value1;
    }
    public V2 getValue2(){
        return value2;
    }
    public V3 getValue3(){
        return value3;
    }
    public V4 getValue4(){
        return value4;
    }

    public void setValue1(V1 value1) {
        this.value1 = value1;
    }

    public void setValue2(V2 value2) {
        this.value2 = value2;
    }

    public void setValue3(V3 value3) {
        this.value3 = value3;
    }

    public void setValue4(V4 value4) {
        this.value4 = value4;
    }
}
