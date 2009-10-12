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
@Target( { FIELD, METHOD, TYPE })
public @interface Messages {
    Message[] value();
}
