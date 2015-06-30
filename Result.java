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
public class Result extends JTextArea implements Runnable {

    private int Chand;
    private String handpattern[];
    private static int score[] = {0, 0, 0, 0};
    private int Uhand;
    JTextArea area1, area2;

    public void showResult(int isWin) {
        run();
        switch (isWin) {
            case (0)://ユーザーの負け
                score[1]++;
                break;
            case (1)://ユーザーの勝ち
                score[0]++;
                break;
            case (2)://引き分け
                score[2]++;
                break;
            case (3)://ホールドボタン
                score[3]++;
                break;
        }
        dispScore(isWin);

    }

    public void dispScore(int isWin) {
        switch (isWin) {
            case (0)://ユーザーの負け
                this.setText(score[0] + "勝" + score[1] + "負" + score[2] + "引き分け\n降りた回数" + score[3]);
                break;
            case (1)://ユーザーの勝ち
                this.setText(score[0] + "勝" + score[1] + "負" + score[2] + "引き分け\n降りた回数" + score[3]);
                break;
            case (2)://引き分け
                this.setText(score[0] + "勝" + score[1] + "負" + score[2] + "引き分け\n降りた回数" + score[3]);
                break;
            case (3)://ホールドボタン
                this.setText(score[0] + "勝" + score[1] + "負" + score[2] + "引き分け\n降りた回数" + score[3]);
                break;
        }
    }

    private void showHand(Poker user, Poker com) {
    }

    public void run() {
        //一秒待機
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("エラー");
        }
    }
}
