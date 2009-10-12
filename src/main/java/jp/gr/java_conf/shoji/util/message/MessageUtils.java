/**
 * 
 */
package jp.gr.java_conf.shoji.util.message;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import jp.gr.java_conf.shoji.util.message.annotations.Handler;
import jp.gr.java_conf.shoji.util.message.handlers.MessageFormatMessageHandler;
import jp.gr.java_conf.shoji.util.message.handlers.StringFormatMessageHandler;

/**
 * 
 * @author shoji
 * 
 */
public class MessageUtils {

    /**
     * create messages by MessageHandler annotated by @Handler if a given clazz
     * is not annotated by @Handler, use {@link StringFormatMessageHandler}.
     * 
     * @param <T>
     * @param clazz
     * @return
     */
    public static <T> T createMessages(Class<T> clazz) {
        Handler annotation = clazz.getAnnotation(Handler.class);
        Class<? extends MessageHandler> handlerClass;
        if (annotation == null) {
            return createMessagesByStringFormat(clazz);
        } else {
            handlerClass = annotation.value();
        }
        return createMessages(clazz, handlerClass);
    }

    /**
     * 
     * @param <T>
     * @param clazz
     * @param handlerClass
     * @return
     */
    public static <T> T createMessages(Class<T> clazz,
            Class<? extends MessageHandler> handlerClass) {
        try {
            MessageHandler handler = handlerClass.getConstructor(Class.class)
                    .newInstance(clazz);
            return createMessages(clazz, handler);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(e);
        } catch (SecurityException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 
     * @param <T>
     * @param clazz
     * @param handler
     * @return
     */
    public static <T> T createMessages(Class<T> clazz, MessageHandler handler) {
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[] { clazz }, handler);
        return clazz.cast(obj);
    }

    /**
     * create messages by {@link String#format(String, Object...)})
     * 
     * @param <T>
     * @param clazz
     * @return
     */
    public static <T> T createMessagesByStringFormat(Class<T> clazz) {
        return createMessages(clazz, new StringFormatMessageHandler(clazz));
    }

    /**
     * create messages by
     * {@link java.text.MessageFormat#format(String, Object...)}
     * 
     * @param <T>
     * @param clazz
     * @return
     */
    public static <T> T createMessagesByMessageFormat(Class<T> clazz) {
        return createMessages(clazz, new MessageFormatMessageHandler(clazz));
    }
}
