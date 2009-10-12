/**
 * �A�m�e�[�V���������p���A�����`�F�b�N�\�ȃ��b�Z�[�W���\�[�X�o���h����`���C�u����
 * 
 * �]���̃��b�Z�[�W���\�[�X�o���h�����`����ۂ̖��_�Ƃ��Ĉȉ��̂Q�������邱�Ƃ��ł���B
 * 
 * 1. ���b�Z�[�W���\�[�X�t�@�C���ƃv���O�����Ƃ̊ԂŁA������̃L�[�ɂ���ČĂяo���ׂ����b�Z�[�W���\�[�X��I�����Ă����B
 *    �L�[�̃^�C�v�~�X���������ꍇ�A���s���܂ł��̊ԈႢ�ɋC�����ɂ����B�܂��A���t�@�N�^�����O���ŃL�[�ƂȂ镶�����ς����ہA
 *    �ύX�R��̌����ɂȂ肦���B
 * 
 * 2. �t�H�[�}�b�g������ɂ��A���b�Z�[�W���J�X�^�}�C�Y�ł���悤�ɂ����Ƃ��A���Ԗڂɂǂ̒l���Z�b�g���Ȃ���΂Ȃ�Ȃ�����
 *    �����������b�Z�[�W���\�[�X�t�@�C���ɓ�����Ȃ���΂Ȃ�Ȃ��B�܂��A�ǂ�Ȍ^�̒l��n���Ȃ���΂Ȃ�Ȃ��������l�ł���B
 * 
 * �����ŁA�����̖��_���������邽�߂̃��b�Z�[�W���\�[�X�o���h����`���C�u������񋟂���B
 * �����̃A�C�f�A�́A�ȉ��̒ʂ�ł���B
 * 
 * 1. �A�m�e�[�V���������p���A������L�[�ɂ�郁�b�Z�[�W���\�[�X�̊֘A�t���������B
 * 2. ���b�Z�[�W���\�[�X�L�[�Ŏg�p����t�H�[�}�b�g��������擾����̂ł͂Ȃ��A���\�b�h�Ăяo���ň�����n���A
 *    �t�H�[�}�b�g�ςݕ�������擾�ł���悤�ɂ���B
 * 3. ���b�Z�[�W��`�̃A�m�e�[�V�����Ƃ��̃A�m�e�[�V�����Œ��߂��ꂽ���\�b�h�̃V�O�l�`���̒�`�̊֘A�t����
 *    ���邾���ŁA�ދ��Ŗʓ|�ȃ��\�b�h�{�̂̒�`�����Ȃ��Ă��悢�悤�ɂ���B
 * 
 * ���X�g���b�L�[�ȃR�[�f�B���O������K�v�����邪�A�]���̃��b�Z�[�W���\�[�X�o���h����`�����i�i�ɖ��m��
 * �~�X�������ɂ������̂ł���Ǝ��͍l���Ă���B
 * 
 * �R�[�h��F ���b�Z�[�W���\�[�X�o���h����`
 * 
 * <code>
 * public abstract class Bundle {
 *     public static final MessageDefinitions MESSAGES = MessageUtils.createMessages(MessageDefinitions.class);
 *     
 *     @Handler(StringFormatMessageHandler.class)
 *     public static interface MessageDefinitions {
 *         @Messages({
 *             @Message(value="default message"),
 *             @Message(value="�f�t�H���g�̃��b�Z�[�W", locale="ja")
 *             })
 *         String message1();
 *         
 *         @Messages({
 *             @Message(value="default message %1$s, %2$4d"),
 *             @Message(value="�f�t�H���g�̃��b�Z�[�W %1$s, %2$4d", locale="ja")
 *             })
 *         String message2(String str, int n);
 *     }
 * }
 * </code>
 * 
 * �R�[�h��: ���b�Z�[�W���\�[�X�o���h���̗��p
 * 
 * <code>
 * Bundle.MESSAGES.message1();
 * Bundle.MESSAGES.message2("ABC", 2);
 * </code>
 * 
 * import static��p����ƁABundle���ȗ����邱�Ƃ��\�ł���B
 * 
 * <code>
 * import static your.package.Bundle.*;
 * 
 * MESSAGES.message1();
 * </code>
 * 
 */
package jp.gr.java_conf.shoji.util.message;
