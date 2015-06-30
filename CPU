/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokermain;

/**
 *
 * @author f1110801062
 */
public class CPU {

    public void exchangeJudgment(int chand[][], int chandRank[], int chandSuit[], int flag) {
        //引数の数字によってテキストボックスに表示する文を指定し、その指示、情報の文を表示する。交換するカードを選択してドローボタンを押してください
        switch (flag) {
            case (0):
                rsflushex(chand, chandRank, chandSuit);
                break;
            case (1):
                sflushex(chand, chandRank, chandSuit);
                break;
            case (2):
                foakindex(chand, chandRank, chandSuit);
                break;
            case (3):
                fullhouseex(chand, chandRank, chandSuit);
                break;
            case (4):
                flushex(chand, chandRank, chandSuit);
                break;
            case (5):
                straightex(chand, chandRank, chandSuit);
                break;
            case (6):
                thoakindexex(chand, chandRank, chandSuit);
                break;
            case (7):
                twopairex(chand, chandRank, chandSuit);
                break;
            case (8):
                onepairex(chand, chandRank, chandSuit);
                break;
            case (9):
                hcardex(chand, chandRank, chandSuit);
                break;
        }
    }

    public void rsflushex(int chand[][], int chandRank[], int chandSuit[]) {
        //ロイヤルストレートラッシュが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        for (int i = 12; i >= 8; i--) {
            chand[i][chandRank[0] + 1] = 3;
        }


    }

    public void sflushex(int chand[][], int chandRank[], int chandSuit[]) {
        //ストレートフラッシュが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        for (int i = chandRank[0] - 2; i >= chandRank[0] - 6; i--) {
            chand[i][chandRank[0] + 1] = 3;
        }
        if (chandRank[0] == 10 && chand[12][chandSuit[0] + 1] >= 1) {
            chand[12][chandSuit[0] + 1] = 3;
        }
    }

    public void foakindex(int chand[][], int chandRank[], int chandSuit[]) {
        //フォーオブアカインドが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        for (int j = 1; j <= 4; j++) {
            chand[chandRank[0] - 2][j] = 3;
        }

    }

    public void fullhouseex(int chand[][], int chandRank[], int chandSuit[]) {
        //フルハウスが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        for (int j = 1; j <= 4; j++) {
            if (chand[chandRank[0] - 1][j] >= 1) {
                chand[chandRank[0] - 1][j] = 3;
            }
        }
        int counter = 0;
        for (int i = 12; i >= 0; i--) {
            if (chand[i][0] >= 2 && i != chandRank[0] - 2) {
                for (int j = 1; j <= 4; j++) {
                    if (chand[chandRank[0] - 2][j] >= 1) {
                        chand[i][j] = 3;
                        counter++;
                    }
                    if (counter == 2) {
                        return;
                    }
                }
            }
        }
    }

    public void flushex(int chand[][], int chandRank[], int chandSuit[]) {
        //フラッシュが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        int counter = 0;
        switch (straight(chand, chandRank, chandSuit, chandSuit[0] + 1)) {
            case (0):
                for (int i = 12; i >= 0; i--) {
                    if (chand[i][chandSuit[0] + 1] == 1 || chand[i][chandSuit[0] + 1] == 2) {
                        chand[i][chandSuit[0] + 1] = 3;
                        counter++;
                        if (counter == 5) {
                            break;
                        }
                    }
                }
                break;
            case (1):
                if (chandRank[0] == 4) {
                    for (int i = chandRank[0] - 2; i >= 0; i--) {
                        chand[i][chandSuit[0] + 1] = 3;
                    }
                    chand[12][chandSuit[0] + 1] = 3;
                } else {
                    for (int i = chandRank[0] - 2; i >= chandRank[0] - 5; i--) {
                        chand[i][chandSuit[0] + 1] = 3;
                    }
                    for (int i = 12; i >= 0; i--) {
                        if (chand[i][chandSuit[0] + 1] == 1 || chand[i][chandSuit[0] + 1] == 2) {
                            chand[i][chandSuit[0] + 1] = 3;
                            break;
                        }
                    }
                }
                break;
            case (2):
                if (chandRank[0] == 5) {
                    chand[3][chandSuit[0] + 1] = 3;
                    chand[2][chandSuit[0] + 1] = 3;
                    chand[1][chandSuit[0] + 1] = 3;
                    chand[12][chandSuit[0] + 1] = 3;
                } else {
                    chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;

                    for (int i = 12; i >= 0; i--) {
                        if (chand[i][chandSuit[0] + 1] == 1 || chand[i][chandSuit[0] + 1] == 2) {
                            chand[i][chandSuit[0] + 1] = 3;
                            break;
                        }
                    }
                }
                break;
            case (3):
                if (chandRank[0] == 5) {
                    chand[3][chandSuit[0] + 1] = 3;
                    chand[2][chandSuit[0] + 1] = 3;
                    chand[1][chandSuit[0] + 1] = 3;
                    chand[12][chandSuit[0] + 1] = 3;
                } else {
                    chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;

                    for (int i = 12; i >= 0; i--) {
                        if (chand[i][chandSuit[0] + 1] == 1 || chand[i][chandSuit[0] + 1] == 2) {
                            chand[i][chandSuit[0] + 1] = 3;
                            break;
                        }
                    }
                }
                break;
            case (4):
                if (chandRank[0] == 5) {
                    chand[3][chandSuit[0] + 1] = 3;
                    chand[2][chandSuit[0] + 1] = 3;
                    chand[1][chandSuit[0] + 1] = 3;
                    chand[12][chandSuit[0] + 1] = 3;
                } else {
                    chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                    chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;

                    for (int i = 12; i >= 0; i--) {
                        if (chand[i][chandSuit[0] + 1] == 1 || chand[i][chandSuit[0] + 1] == 2) {
                            chand[i][chandSuit[0] + 1] = 3;
                            break;
                        }
                    }
                    break;
                }
        }
    }

    public void straightex(int chand[][], int chandRank[], int chandSuit[]) {
        //ストレートが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        int[] count = new int[5];
        switch (flush(chand, chandRank, chandSuit, chandRank[0], chandRank[0] - 4)) {
            case (1):
                if (chandRank[0] == 5) {
                    for (int i = chandRank[0] - 2; i >= 0; i--) {
                        if (chand[i][chandSuit[0] + 1] >= 1) {
                            chand[i][chandSuit[0] + 1] = 3;
                            count[i - chandRank[0] + 4]++;
                        }
                    }
                    if (chand[12][chandSuit[0] + 1] >= 1) {
                        chand[12][chandSuit[0] + 1] = 3;
                        count[12]++;
                    }
                } else {
                    for (int i = chandRank[0] - 2; i >= chandRank[0] - 6; i--) {
                        if (chand[i][chandSuit[0] + 1] >= 1) {
                            chand[i][chandSuit[0] + 1] = 3;
                            count[i - (chandRank[0] + 4)]++;
                        }
                    }
                }

            case (0):
                for (int k = 2; k >= 1; k--) {
                    if (chandRank[0] == 5) {
                        for (int i = 3; i >= 0; i--) {
                            if (count[i + 1] == 0) {
                                for (int j = 1; j <= 4; j++) {
                                    if (chand[i][j] == k) {
                                        chand[i][j] = 3;
                                        count[i + 1]++;
                                        break;
                                    }
                                }
                            }
                        }
                        if (count[0] == 0) {
                            for (int j = 1; j <= 4; j++) {
                                if (chand[0][j] == k) {
                                    chand[0][j] = 3;
                                    count[0]++;
                                    break;
                                }
                            }
                        }

                    } else {

                        for (int i = chandRank[0] ; i >= chandRank[0] - 4; i--) {
                            if (count[i - (chandRank[0] + 6)] == 0) {
                                for (int j = 1; j <= 4; j++) {
                                    if (chand[i][j] == k) {
                                        chand[i][j] = 3;
                                        count[i - (chandRank[0] + 4)]++;

                                    }
                                }
                            }
                        }
                    }
                }
        }
    }

    public void thoakindexex(int chand[][], int chandRank[], int chandSuit[]) {
        //スリーオブアカインドが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        for (int j = 1; j <= 4; j++) {
            if (chand[chandRank[0] - 2][j] >= 1) {
                chand[chandRank[0] - 2][j] = 3;
            }
        }
    }

    public void twopairex(int chand[][], int chandRank[], int chandSuit[]) {  //if文のbreak 位置？？
        //ツーペアが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        int counter = 0;
        for (int j = 1; j <= 4; j++) {
            if (chand[chandRank[0] - 2][j] >= 1) {
                chand[chandRank[0] - 2][j] = 3;
            }
        }
        for (int i = chandRank[0] - 3; i >= 0; i--) {
            if (chand[i][0] == 2) {
                for (int j = 1; j <= 4; j++) {
                    if (chand[i][j] >= 1) {
                        chand[i][j] = 3;
                        counter++;
                        if (counter == 2) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void onepairex(int chand[][], int chandRank[], int chandSuit[]) {
        //ワンペアが成立しているときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        int counter = 0;
        if (flush(chand, chandRank, chandSuit, 14, 2) == 1) {
            if (straight(chand, chandRank, chandSuit, 0) >= 1) {
                if (straight(chand, chandRank, chandSuit, chandSuit[0] + 1) >= 1) {
                    switch (straight(chand, chandRank, chandSuit, chandSuit[0] + 1)) {
                        case (1):
                            if (chandRank[0] == 4) {
                                for (int i = chandRank[0] - 2; i >= chandRank[0] - 4; i--) {
                                    chand[i][chandSuit[0] + 1] = 3;
                                }
                                chand[12][chandSuit[0] + 1] = 3;
                                break;
                            } else {
                                for (int i = chandRank[0] - 2; i >= chandRank[0] - 5; i--) {
                                    chand[i][chandSuit[0] + 1] = 3;
                                }
                            }
                            break;
                        case (2):
                            if (chandRank[0] == 5) {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                                chand[12][chandSuit[0] + 1] = 3;
                                break;

                            } else {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;
                            }
                            break;
                        case (3):
                            if (chandRank[0] == 5) {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                                chand[12][chandSuit[0] + 1] = 3;
                                break;

                            } else {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;
                            }
                            break;
                        case (4):
                            if (chandRank[0] == 5) {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                                chand[12][chandSuit[0] + 1] = 3;
                                break;

                            } else {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;
                            }
                            break;
                    }
                    return;
                } else {
                    for (int i = 12; i >= 0; i--) {
                        if (chand[i][chandSuit[0] + 1] >= 1) {
                            chand[i][chandSuit[0] + 1] = 3;
                            counter++;
                            if (counter == 4) {
                                break;
                            }
                        }
                    }
                    return;
                }
            } else {
                for (int i = 12; i >= 0; i--) {
                    if (chand[i][chandSuit[0] + 1] >= 1) {
                        chand[i][chandSuit[0] + 1] = 3;
                        counter++;
                        if (counter == 4) {
                            break;
                        }
                    }
                }
            }
        } else {
            if (straight(chand, chandRank, chandSuit, 0) >= 1) {
                if (chandRank[0] <= 5) {
                    for (int i = chandRank[0] - 2; i >= 0 && i >= 0; i--) {
                        for (int j = 1; j <= 4; j++) {
                            if (chand[i][j] >= 1) {
                                chand[i][j] = 3;
                                break;
                            }
                        }
                    }
                    for (int j = 1; j <= 4; j++) {
                        if (chand[12][j] >= 1) {
                            chand[12][j] = 3;
                            break;
                        }
                    }
                } else {
                    for (int i = 12; i >= 0; i--) {
                        if (chand[i][0] == 2) {
                            chandRank[0] = i + 2;
                            break;
                        }
                    }
                    for (int j = 1; j <= 4; j++) {
                        if (chand[chandRank[0] - 2][j] >= 1) {
                            chand[chandRank[0] - 2][j] = 3;
                        }
                    }
                }
            }
        }
        return;
    }

    public void hcardex(int chand[][], int chandRank[], int chandSuit[]) {
        //ハイカードのときに　exchangeJudgmentから呼び出され、ホールドするカードを決定する
        int counter = 0;
        if (flush(chand, chandRank, chandSuit, 14, 2) == 1) {
            if (straight(chand, chandRank, chandSuit, 0) >= 1) {
                int[] a = new int[1];
                if (straight(chand, chandRank, chandSuit, chandSuit[0] + 1) >= 1) {
                    switch (straight(chand, chandRank, chandSuit, chandSuit[0] + 1)) {
                        case (1):
                            if (chandRank[0] == 4) {
                                for (int i = chandRank[0] - 2; i >= chandRank[0] - 4; i--) {
                                    chand[i][chandSuit[0] + 1] = 3;
                                }
                                chand[12][chandSuit[0] + 1] = 3;
                                break;
                            } else {
                                for (int i = chandRank[0] - 2; i >= chandRank[0] - 5; i--) {
                                    chand[i][chandSuit[0] + 1] = 3;
                                }
                            }
                            break;
                        case (2):
                            if (chandRank[0] == 5) {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                                chand[12][chandSuit[0] + 1] = 3;
                                break;

                            } else {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;
                            }
                            break;
                        case (3):
                            if (chandRank[0] == 5) {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                                chand[12][chandSuit[0] + 1] = 3;
                                break;

                            } else {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 4][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;
                            }
                            break;
                        case (4):
                            if (chandRank[0] == 5) {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                                chand[12][chandSuit[0] + 1] = 3;
                                break;

                            } else {
                                chand[chandRank[0] - 2][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 3][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 5][chandSuit[0] + 1] = 3;
                                chand[chandRank[0] - 6][chandSuit[0] + 1] = 3;
                            }
                            break;
                    }
                } else {
                    for (int i = 12; i >= 0; i--) {
                        if (chand[i][chandSuit[0] + 1] >= 1) {
                            chand[i][chandSuit[0] + 1] = 3;
                            counter++;
                            if (counter == 4) {
                                break;
                            }
                        }
                    }
                }
            } else {
                for (int i = 12; i >= 0; i--) {
                    if (chand[i][chandSuit[0] + 1] >= 1) {
                        chand[i][chandSuit[0] + 1] = 3;
                        counter++;
                        if (counter == 4) {
                            break;
                        }
                    }
                }
            }
        } else {
            if (straight(chand, chandRank, chandSuit, 0) >= 1) {
                if (chandRank[0] <= 5) {
                    for (int i = chandRank[0] - 2; i >= 0 && i >= 0; i--) {
                        for (int j = 1; j <= 4; j++) {
                            if (chand[i][j] >= 1) {
                                chand[i][j] = 3;
                                break;
                            }
                        }
                    }
                    for (int j = 1; j <= 4; j++) {
                        if (chand[12][j] >= 1) {
                            chand[12][j] = 3;
                            break;
                        }
                    }
                } else {
                    for (int i = chandRank[0] - 2; i >= chandRank[0] - 6; i--) {
                        for (int j = 1; j <= 4; j++) {
                            if (chand[i][j] >= 1) {
                                chand[i][j] = 3;
                            }
                        }
                    }
                }
            }

        }
    }

    public int straight(int chand[][], int chandRank[], int chandSuit[], int suit) {
        //ストレートのリーチ判定をする
        int sreach;
        int sreachflag;
        for (int i = 12; i >= 3; i--) {
            if (chand[i][suit] >= 1 && chand[i - 1][suit] >= 1 && chand[i - 2][suit] >= 1 && chand[i - 3][suit] >= 1) {
                chandRank[0] = i + 2;
                sreach = 1;
                return sreach;
            }
        }
        if (chand[2][suit] >= 1 && chand[1][suit] >= 1 && chand[0][suit] >= 1 && chand[12][suit] >= 1) {
            chandRank[0] = 4;
            sreach = 1;
            return sreach;
        } else {
            for (int i = 12; i >= 4; i--) {
                if (chand[i][suit] >= 1 && chand[i - 1][suit] >= 1 && chand[i - 2][suit] >= 1 && chand[i - 3][suit] == 0 && chand[i - 4][suit] >= 1) {
                    chandRank[0] = i + 2;
                    sreach = 2;
                    return sreach;
                }

            }
        }
        if (chand[3][suit] >= 1 && chand[2][suit] >= 1 && chand[1][suit] >= 1 && chand[0][suit] == 0 && chand[12][suit] >= 1) {
            chandRank[0] = 5;
            sreachflag = 2;
            return sreachflag;
        }
        for (int i = 12; i >= 4; i--) {
            if (chand[i][suit] >= 1 && chand[i - 1][suit] == 0 && chand[i - 2][suit] >= 1 && chand[i - 3][suit] >= 1 && chand[i - 4][suit] >= 1) {
                chandRank[0] = i + 2;
                sreachflag = 3;
                return sreachflag;
            }
        }
        if (chand[3][suit] >= 1 && chand[2][suit] == 0 && chand[1][suit] >= 1 && chand[0][suit] >= 1 && chand[12][suit] >= 1) {
            chandRank[0] = 5;
            sreachflag = 3;
            return sreachflag;
        }

        for (int i = 12; i >= 4; i--) {
            if (chand[i][suit] >= 1 && chand[i - 1][suit] >= 1 && chand[i - 2][suit] == 0 && chand[i - 3][suit] >= 1 && chand[i - 4][suit] >= 1) {
                chandRank[0] = i + 2;
                sreachflag = 4;
                return sreachflag;
            }
        }
        if (chand[3][suit] >= 1 && chand[2][suit] >= 1 && chand[1][suit] == 0 && chand[0][suit] >= 1 && chand[12][suit] >= 1) {
            chandRank[0] = 5;
            sreachflag = 4;
            return sreachflag;
        }

        return 0;
    }

    public int flush(int chand[][], int chandRank[], int chandSuit[], int uRank, int IRank) {
        //フラッシュのリーチ判定をする
        int counter = 0;
        int[] numberOfHandSuit = new int[4];
        int flushreachflag;
        if (IRank < 0) {
            IRank = 0;

            if (chand[12][0] >= 0) {
                for (int j = 1; j <= 4; j++) {
                    if (chand[12][j] >= 1) {
                        numberOfHandSuit[j - 1]++;
                    }
                }
            }
        } else {
            for (int i = uRank - 2; i >= IRank - 2; i--) {
                if (chand[i][0] >= 0) {
                    for (int j = 1; j <= 4; j++) {
                        if (chand[i][j] >= 1) {
                            counter++;
                            numberOfHandSuit[j - 1]++;
                            if (numberOfHandSuit[j - 1] == 4) {
                                chandSuit[0] = j - 1;
                                flushreachflag = 1;
                                return flushreachflag;
                            }
                        }
                    }
                    if (counter == 7) {
                        break;
                    }

                }
            }
        }
        flushreachflag = 0;
        return flushreachflag;
    }
}
