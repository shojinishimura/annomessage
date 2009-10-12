package jp.gr.java_conf.shoji.util.message.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jp.gr.java_conf.shoji.util.message.MessageHandler;
import jp.gr.java_conf.shoji.util.message.handlers.StringFormatMessageHandler;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Handler {
    Class<? extends MessageHandler> value() default StringFormatMessageHandler.class;
}