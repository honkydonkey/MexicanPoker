/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokermain;

import javax.swing.JTextArea;

/**
 *
 * @author f1110801062
 */
public class TextAreaRenew extends JTextArea {

    String uh, ch;

    public void TextboxRenew(int x, int a, int b) {
        switch (a) {
            case (0):
                uh = "ロイヤルストレートフラッシュ";
                break;
            case (1):
                uh = "ストレートフラッシュ";
                break;
            case (2):
                uh = "フォーカード";
                break;
            case (3):
                uh = "フルハウス";
                break;
            case (4):
                uh = "フラッシュ";
                break;
            case (5):
                uh = "ストレート";
                break;
            case (6):
                uh = "スリーカード";
                break;
            case (7):
                uh = "ツーペア";
                break;
            case (8):
                uh = "ワンペア";
                break;
            case (9):
                uh = "ハイカード";
                break;
            case (10):
                uh = "";
                break;
        }

        switch (b) {
            case (0):
                ch = "ロイヤルストレートフラッシュ";
                break;
            case (1):
                ch = "ストレートフラッシュ";
                break;
            case (2):
                ch = "フォーカード";
                break;
            case (3):
                ch = "フルハウス";
                break;
            case (4):
                ch = "フラッシュ";
                break;
            case (5):
                ch = "ストレート";
                break;
            case (6):
                ch = "スリーカード";
                break;
            case (7):
                ch = "ツーペア";
                break;
            case (8):
                ch = "ワンペア";
                break;
            case (9):
                ch = "ハイカード";
                break;
            case (10):
                uh = "";
                break;
        }

        switch (x) {
            case (0):
                this.setText("始めるときはディールボタンを押してください");
                break;
            case (1):
                this.setText("ドローしますか？フォールドしますか？");
                break;
            case (2):
                this.setText("ショウダウンします。");
                break;
            case (3):
                this.setText("ショウダウンします。\nあなたは" + uh + "で\nCPUは"
                        + ch
                        + "です。\nあなたの勝ちですよ");
                break;
            case (4):
                this.setText("ショウダウンします。\nあなたは" + uh + "で\nCPUは"
                        + ch
                        + "です。\nあなたは負けですよ");
                break;
            case (5):
                this.setText("ショウダウンします。\nあなたは" + uh + "で\nCPUは"
                        + ch
                        + "です。\n引き分けですよ");
                break;
            case (6):
                this.setText("おりましたね");
                break;

        }

    }
}
