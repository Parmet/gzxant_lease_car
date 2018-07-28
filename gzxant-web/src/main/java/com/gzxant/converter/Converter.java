package com.gzxant.converter;


import java.util.function.Function;

/**
 * Converter 抽象类
 * 实现对同样逻辑的转换类的抽取
 * @author: Fatal
 * @date: 2018/7/26 0026 19:32
 */
public abstract class Converter<A, B> {

    protected abstract B doForward(A a);
    protected abstract A doBackward(B b);

}
