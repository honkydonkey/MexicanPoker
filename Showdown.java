/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokermain;

import javax.swing.ImageIcon;

/**
 *
 * @author f1110801062
 */
public class Showdown {

    private CPU cp;
    public int isWin;
    private Judgment jud;
    public int[] PetternNumber;//何に使うのかわからん
    public Result res;
    public int[] c1, c2;
    public int[][] c3;
    ImageIcon[] icon3;

    public Showdown() {
        jud = new Judgment();
        res = new Result();
        cp = new CPU();
        c3 = new int[26][10];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 10; j++) {
                c3[i][j] = 0;
            }
        }
    }

    public int[][] cardChange(int uhand[][], int uhandRank[], int uhandSuit[], int chand[][], int chandRank[], int chandSuit[], int deck[]) {
     cp.exchangeJudgment(chand, chandRank, chandSuit, jud.handCheck(chand, chandRank, chandSuit));//ユーザの手札の判定に使うんじゃなかろうか

        int a = 0;
        //userの手札交換
        for (int i = 0; i < 13; i++) {
            for (int j = 1; j < 5; j++) {
                if (uhand[i][j] == 1) {
                    uhand[i][j] = 0;
                    uhand[i][0]--;
                    a++;
                }
            }
        }
        c1 = new int[a];
        for (int i = 0; i < c1.length; i++) {
            c1[i] = 0;
        }
        for (int j = 0; j < c1.length; j++) {
            int b = 0, d = 0;
            while (true) {
                b = (int) (Math.random() * 52);
                if (deck[b] != 0) {
                    d = deck[b];
                    break;
                }
            }
            c1[j] = d;
            deck[b] = 0;
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < 13; j++) {
                if (c1[i] >= 0 && c1[i] < 13) {
                    if ((c1[i] + 12) % 13 == j) {
                        uhand[j][1] = 3;
                        uhand[j][0]++;
                    }
                } else if (c1[i] >= 13 && c1[i] < 26) {
                    if ((c1[i] + 12) % 13 == j) {
                        uhand[j][2] = 3;
                        uhand[j][0]++;
                    }
                } else if (c1[i] >= 26 && c1[i] < 39) {
                    if ((c1[i] + 12) % 13 == j) {
                        uhand[j][3] = 3;
                        uhand[j][0]++;
                    }
                } else {
                    if ((c1[i] + 12) % 13 == j) {
                        uhand[j][4] = 3;
                        uhand[j][0]++;
                    }
                }

            }
        }
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 5; j++) {
                c3[i][j] = uhand[i][j];
            }
        }

        a = 0;
        //cpuの手札交換

        for (int i = 0; i < 13; i++) {
            for (int j = 1; j < 5; j++) {
                if (chand[i][j] == 1) {
                    chand[i][j] = 0;
                    chand[i][0]--;
                    a++;
                }
            }
        }
        c2 = new int[a];

        for (int i = 0; i < c2.length; i++) {
            c2[i] = 0;
        }
        for (int j = 0; j < a; j++) {
            int b = 0, d = 0;
            while (true) {
                b = (int) (Math.random() * 52);
                if (deck[b] != 0) {
                    d = deck[b];
                    break;
                }
            }
            c2[j] = d;
            deck[b] = 0;
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < 13; j++) {
                if (c2[i] >= 0 && c2[i] < 13) {
                    if ((c2[i] + 12) % 13 == j) {
                        chand[j][1] = 1;
                        chand[j][0]++;
                    }
                } else if (c2[i] >= 13 && c2[i] < 26) {
                    if ((c2[i] + 12) % 13 == j) {
                        chand[j][2] = 1;
                        chand[j][0]++;
                    }
                } else if (c2[i] >= 26 && c2[i] < 39) {
                    if ((c2[i] + 12) % 13 == j) {
                        chand[j][3] = 1;
                        chand[j][0]++;
                    }
                } else {
                    if ((c2[i] + 12) % 13 == j) {
                        chand[j][4] = 1;
                        chand[j][0]++;
                    }
                }

            }
        }
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 5; j++) {
                c3[i + 13][j + 5] = chand[i][j];
            }
        }

        PetternNumber = new int[2];
        for (int i = 0; i < 2; i++) {
            PetternNumber[i] = 0;
        }
        PetternNumber[0] = jud.handCheck(uhand, uhandRank, uhandSuit);
        PetternNumber[1] = jud.handCheck(chand, chandRank, chandSuit);

         isWin = jud.judge(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit, PetternNumber);
                 return c3;

    }
}
