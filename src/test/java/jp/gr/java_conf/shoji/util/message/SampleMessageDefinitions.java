package jp.gr.java_conf.shoji.util.message;

import jp.gr.java_conf.shoji.util.message.annotations.Message;
import jp.gr.java_conf.shoji.util.message.annotations.Messages;

public interface SampleMessageDefinitions {
    @Messages( { @Message("default message"),
            @Message(value = "�f�t�H���g�̃��b�Z�[�W", locale = "ja") })
    String message1();

    @Messages( { @Message("default message %1$s, %2$04d") })
    String message2(String a, int b);
}
