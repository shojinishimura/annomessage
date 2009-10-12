/**
 * アノテーションを活用し、引数チェック可能なメッセージリソースバンドル定義ライブラリ
 * 
 * 従来のメッセージリソースバンドルを定義する際の問題点として以下の２つを挙げることができる。
 * 
 * 1. メッセージリソースファイルとプログラムとの間で、文字列のキーによって呼び出すべきメッセージリソースを選択していた。
 *    キーのタイプミスがあった場合、実行時までその間違いに気がつきにくい。また、リファクタリング等でキーとなる文字列を変えた際、
 *    変更漏れの原因になりえた。
 * 
 * 2. フォーマット文字列により、メッセージをカスタマイズできるようにしたとき、何番目にどの値をセットしなければならないかを
 *    いちいちメッセージリソースファイルに当たらなければならない。また、どんな型の値を渡さなければならないかも同様である。
 * 
 * そこで、これらの問題点を解決するためのメッセージリソースバンドル定義ライブラリを提供する。
 * 実現のアイデアは、以下の通りである。
 * 
 * 1. アノテーションを活用し、文字列キーによるメッセージリソースの関連付けを避ける。
 * 2. メッセージリソースキーで使用するフォーマット文字列を取得するのではなく、メソッド呼び出しで引数を渡し、
 *    フォーマット済み文字列を取得できるようにする。
 * 3. メッセージ定義のアノテーションとそのアノテーションで注釈されたメソッドのシグネチャの定義の関連付けを
 *    するだけで、退屈で面倒なメソッド本体の定義をしなくてもよいようにする。
 * 
 * 少々トリッキーなコーディングをする必要があるが、従来のメッセージリソースバンドル定義よりも格段に明確で
 * ミスがおきにくいものであると私は考えている。
 * 
 * コード例： メッセージリソースバンドル定義
 * 
 * <code>
 * public abstract class Bundle {
 *     public static final MessageDefinitions MESSAGES = MessageUtils.createMessages(MessageDefinitions.class);
 *     
 *     @Handler(StringFormatMessageHandler.class)
 *     public static interface MessageDefinitions {
 *         @Messages({
 *             @Message(value="default message"),
 *             @Message(value="デフォルトのメッセージ", locale="ja")
 *             })
 *         String message1();
 *         
 *         @Messages({
 *             @Message(value="default message %1$s, %2$4d"),
 *             @Message(value="デフォルトのメッセージ %1$s, %2$4d", locale="ja")
 *             })
 *         String message2(String str, int n);
 *     }
 * }
 * </code>
 * 
 * コード例: メッセージリソースバンドルの利用
 * 
 * <code>
 * Bundle.MESSAGES.message1();
 * Bundle.MESSAGES.message2("ABC", 2);
 * </code>
 * 
 * import staticを用いると、Bundleを省略することが可能である。
 * 
 * <code>
 * import static your.package.Bundle.*;
 * 
 * MESSAGES.message1();
 * </code>
 * 
 */
package jp.gr.java_conf.shoji.util.message;
