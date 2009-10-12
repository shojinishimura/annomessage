/**
 * 
 */
package jp.gr.java_conf.shoji.util.message.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

/**
 * 
 * @author shoji
 *
 */
@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface Message {
    String value();
    String locale() default "";
}
