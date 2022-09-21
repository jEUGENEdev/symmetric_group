package org.math.exc;

public class ArgsFailException extends Throwable {
    public ArgsFailException() {
        super("Что-то не так с аргументами. Пожалуйста! Перепроверьте этот нюанс.");
    }
}
