/**
 * 
 */
package jp.gr.java_conf.shoji.util.message.handlers;

import java.text.MessageFormat;
import java.util.Locale;

import jp.gr.java_conf.shoji.util.message.MessageHandler;

/**
 * 
 * @author shoji
 *
 */
public class MessageFormatMessageHandler extends MessageHandler {

    /**
     * 
     * @param proxiedInterface
     */
    public MessageFormatMessageHandler(Class<?> proxiedInterface) {
        super(proxiedInterface);
    }

    /*
     * (non-Javadoc)
     * @see jp.gr.java_conf.shoji.util.message.MessageHandler#format(java.util.Locale, java.lang.String, java.lang.Object[])
     */
    @Override
    protected String format(Locale locale, String format, Object[] args) {
        return MessageFormat.format(format, args);
    }

}
