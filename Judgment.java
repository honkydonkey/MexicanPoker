/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokermain;

/**
 *
 * @author f1110801062
 */
public class Judgment {

    public void cardSel(int hand[][], int handRank[], int handSuit[], int flag) {
        //1
        switch (flag) {
            case (0):
                sfulshsel(hand, handRank, handSuit);
                break;
            case (1):
                sfulshsel(hand, handRank, handSuit);
                break;
            case (2):
                foakindsel(hand, handRank, handSuit);
                break;
            case (3):
                fullhousesel(hand, handRank, handSuit);
                break;
            case (4):
                flushsel(hand, handRank, handSuit);
                break;
            case (5):
                straightsel(hand, handRank, handSuit);
                break;
            case (6):
                thoakindsel(hand, handRank, handSuit);
                break;
            case (7):
                towpairsel(hand, handRank, handSuit);
                break;
            case (8):
                onepairsel(hand, handRank, handSuit);
                break;
            case (9):
                kickersel(hand, handRank, handSuit, 5);
                break;

        }
        showdounhandsel(hand, handRank, handSuit);
    }

    public int flushjudge(int hand[][], int handRank[], int handSuit[]) {
        //2
        int counter = 0;
        int[] numberOfHandSuit = new int[4];
        int[] numberOfHandRank = new int[4];
        int flushflag;

        for (int i = 12; i >= 0; i--) {
            if (hand[i][0] >= 0) {
                for (int j = 1; j <= 4; j++) {
                    if (hand[i][j] >= 1) {
                        counter++;
                        numberOfHandSuit[j - 1]++;
                        if (numberOfHandSuit[j - 1] == 5) {
                            handSuit[0] = j - 1;
                            handRank[0] = numberOfHandRank[j - 1];
                            flushflag = 4;
                            return flushflag;
                        } else {
                            if (numberOfHandRank[j - 1] < (i + 2)) {
                                numberOfHandRank[j - 1] = (i + 2);
                            }
                        }
                    }
                }
                if (counter == 7) {
                    break;
                }
            }
        }
        flushflag = 0;
        return flushflag;
    }

    public int handCheck(int hand[][], int handRank[], int handSuit[]) {
        //3
        int flag;
        if (flushjudge(hand, handRank, handSuit) == 4 && straightjudge(hand, handRank, handSuit) == 5) {
            if (sflushjudge(hand, handRank, handSuit) == 1) {
                if (handRank[0] == 12) {
                    flag = 0;
                    return flag;
                } else {
                    flag = 1;
                    return flag;
                }
            } else {
                flag = 4;
                return flag;
            }
        } else {
            if (flushjudge(hand, handRank, handSuit) == 4) {
                flag = flushjudge(hand, handRank, handSuit);
            } else {
                flag = straightjudge(hand, handRank, handSuit);
            }
            if (flag == 0) {
                flag = otherjudge(hand, handRank, handSuit);
                return flag;
            } else {
                return flag;
            }
        }
    }

    public int judge(int uhand[][], int uhandRank[], int uhandSuit[], int chand[][], int chandRank[], int chandSuit[], int[] hpattern) {
        int num;
        int teh;
        int userhand = hpattern[0];
        int cpuhand = hpattern[1];
        int win;
        if (userhand > cpuhand) {
            //ユーザー敗北
            win = 0;
            return win;
        } else if (userhand < cpuhand) {
            //ユーザー勝利
            win = 1;
            return win;
        } else {
            switch (userhand) {
                case (0):
                    num = judgmentHandSuit(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        win = 1;
                        return win;
                        //ユーザ勝利
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利            
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }


                case (1):
                    num = judgmentHandSuit(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }


                case (2):
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                case (3):
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                    while (true) {
                        teh = NextHandRank(uhand, uhandRank, uhandSuit, 2);//意味わからん
                        if (teh == 0) {
                            //引きわけを返す
                            win = 2;
                            return win;
                        }
                        num = judgmentHandSuit(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                        if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                            //ユーザ勝利
                            win = 1;
                            return win;
                        } else if (num == 1) {
                            //ユーザ敗北
                            win = 0;
                            return win;
                        }
                    }

                case (4):
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                case (5):
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                    teh = NextHandRank(uhand, uhandRank, uhandSuit, 1);//よくわからない
                    num = judgmentHandSuit(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                case (6):
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                    teh = NextHandRank(uhand, uhandRank, uhandSuit, 1);//よくわからない
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                case (7):
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                    while (true) {
                        teh = NextHandRank(uhand, uhandRank, uhandSuit, 2);//意味わからん
                        if (teh == 0) {
                            //引きわけを返す
                            win = 2;
                            return win;
                        }
                        num = judgmentHandSuit(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                        if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                            //ユーザ勝利
                            win = 1;
                            return win;
                        } else if (num == 1) {
                            //ユーザ敗北
                            win = 0;
                            return win;
                        }
                    }

                case (8):
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                    while (true) {
                        teh = NextHandRank(uhand, uhandRank, uhandSuit, 1);//意味わからん
                        if (teh == 0) {
                            //引きわけを返す
                            win = 2;
                            return win;
                        }
                        num = judgmentHandSuit(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                        if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                            //ユーザ勝利
                            win = 1;
                            return win;
                        } else if (num == 1) {
                            //ユーザ敗北
                            win = 0;
                            return win;
                        }
                    }

                //break;
                case (9):
                    num = judgmentHandRank(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                    if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                        //ユーザ勝利
                        win = 1;
                        return win;
                    } else if (num == 1) {
                        //ユーザ敗北
                        win = 0;
                        return win;
                    }
                    while (true) {
                        teh = NextHandRank(uhand, uhandRank, uhandSuit, 1);//意味わからん
                        if (teh == 0) {
                            //引きわけを返す
                            win = 2;
                            return win;

                        }
                        num = judgmentHandSuit(uhand, uhandRank, uhandSuit, chand, chandRank, chandSuit);
                        if (num == 0) {//judgmentHandsuitで勝ちなら１負けなら２引きわけなら０を返す
                            //ユーザ勝利
                            win = 1;
                            return win;
                        } else if (num == 1) {
                            //ユーザ敗北
                            win = 0;
                            return win;
                        }


                    }
            }
            //4
        }
        return 0;
    }

    public int judgmentHandRank(int uhand[][], int uhandRank[], int uhandSuit[], int chand[][], int chandRank[], int chandSuit[]) {
        int users;
        users = uhandRank[0];
        int coms;
        coms = chandRank[0];
        if (users > coms) {
            return 0;
        } else if (users < coms) {
            return 1;
        } else {
            return 2;
        }
        //5
    }

    public int judgmentHandSuit(int uhand[][], int uhandRank[], int uhandSuit[], int chand[][], int chandRank[], int chandSuit[]) {
        int users;
        users = uhandSuit[0];
        int coms;
        coms = chandSuit[0];
        if (users > coms) {
            return 0;
        } else if (users < coms) {
            return 1;
        } else {
            return 2;
        }

        //6
    }

    public int NextHandRank(int hand[][], int handRank[], int handSuit[], int kind) {
        int i = handRank[0] - 2;
        while (i == 0) {
            if (hand[i][0] == kind) {
                return i + 1;
            }
            i--;
        }
        return 0;
        //7
    }

    public int otherjudge(int hand[][], int handRank[], int handSuit[]) {
        //8
        int[] oak = new int[5];
        int otherflag;
        for (int i = 12; i >= 0; i--) {
            int a = hand[i][0];
            oak[a]++;
        }
        int num;
        int flag;
        if (oak[4] == 1) {
            flag = 2;
            num = 4;
        } else {
            if (oak[3] == 2 || (oak[3] == 1 && oak[2] >= 1)) {
                flag = 3;
                num = 3;
            } else {
                if (oak[3] == 1) {
                    flag = 6;
                    num = 3;
                } else {
                    if (oak[2] >= 2) {
                        flag = 7;
                        num = 2;
                    } else {
                        if (oak[2] == 1) {
                            flag = 8;
                            num = 2;
                        } else {
                            flag = 9;
                            num = 1;
                        }
                    }
                }
            }
        }
        for (int i = 12; i >= 0; i--) {
            if (hand[i][0] == num) {
                handRank[0] = (i + 2);
            }
        }
        otherflag = flag;
        return otherflag;
    }

    public int sflushjudge(int hand[][], int handRank[], int handSuit[]) {
        //9
        int counter = 0;
        int sflushflag;
        int flushflag;

        for (int i = handRank[0] - 2; i >= 0; i--) {
            if (hand[i][handSuit[0] + 1] >= 1) {
                counter++;
                if (counter == 5) {
                    handRank[0] = i + 6;
                    sflushflag = 1;
                    return sflushflag;
                }
            } else {
                counter = 0;
            }
            if (i + counter >= 4) {
            } else {
                break;
            }
        }
        if (counter == 4 && hand[12][handSuit[0] + 1] >= 1) {
            handRank[0] = 5;
            sflushflag = 1;
            return sflushflag;
        } else {
            flushflag = flushjudge(hand, handRank, handSuit);
            sflushflag = flushflag;
            return sflushflag;
        }
    }

    public int straightjudge(int hand[][], int handRank[], int handSuit[]) {
        //10
        int counter = 0;
        int straightflag;
        for (int i = 12; i >= 0; i--) {
            if (hand[i][0] >= 1) {
                counter++;
                if (counter == 5) {
                    handRank[0] = i + 6;
                    straightflag = 5;
                    return straightflag;
                }
            } else {
                counter = 0;
            }
            if (i + counter >= 4) {
            } else {
                break;
            }
        }
        if (counter == 4 && hand[12][0] >= 1) {
            handRank[0] = 5;
            straightflag = 5;
            return straightflag;
        } else {
            straightflag = 0;
            return straightflag;
        }

    }

    public void flushsel(int hand[][], int handRank[], int handSuit[]) {
        //11
        int counter = 0;
        for (int i = 12; i >= 0; i--) {
            if (hand[i][handSuit[0] + 1] >= 1) {
                hand[i][handSuit[0] + 1] = 4;
                counter++;
                if (counter == 5) {
                    break;
                }
            }
        }
    }

    public void fullhousesel(int hand[][], int handRank[], int handSuit[]) {
        //12
        for (int j = 1; j <= 4; j++) {
            if (hand[handRank[0] - 1][j] >= 1) {
                hand[handRank[0] - 1][j] = 4;
            }
        }
        int counter = 0;
        for (int i = 12; i >= 0; i--) {
            if (hand[i][0] >= 2 && i != handRank[0] - 2) {
                for (int j = 1; j <= 4; j++) {
                    if (hand[handRank[0] - 2][j] >= 1) {
                        hand[i][j] = 4;
                        counter++;
                        if (counter == 2) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void kickersel(int hand[][], int handRank[], int handSuit[], int number) {
        //13
        int counter = 0;
        for (int i = 12; i >= 0; i--) {
            if (hand[i][0] != 0 && i != handRank[0] - 2) {
                for (int j = 1; j <= 4; j++) {
                    if (hand[i][j] >= 1) {
                        hand[i][j] = 4;
                        counter++;
                        if (counter == number) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void onepairsel(int hand[][], int handRank[], int handSuit[]) {
        //14
        for (int j = 1; j <= 4; j++) {
            if (hand[handRank[0] - 2][j] >= 1) {
                hand[handRank[0] - 2][j] = 4;
            }
        }
        kickersel(hand, handRank, handSuit, 3);
    }

    public void sfulshsel(int hand[][], int handRank[], int handSuit[]) {
        //15
        for (int i = handRank[0] - 2; i >= handRank[0] - 6; i--) {
            hand[i][handSuit[0] + 1] = 4;
        }
    }

    public void foakindsel(int hand[][], int handRank[], int handSuit[]) {
        //16
        for (int j = 1; j <= 4; j++) {
            hand[handRank[0] - 2][j] = 4;
        }
        kickersel(hand, handRank, handSuit, 1);
    }

    public void showdounhandsel(int hand[][], int handRank[], int handSuit[]) {
        //17
        int counter = 0;
        for (int i = 0; i <= 12; i++) {
            if (hand[i][0] == 0) {
            } else {
                for (int j = 4; j >= 1; j--) {
                    if (hand[i][j] <= 2) {
                        hand[i][j] = 0;
                        counter++;
                        if (counter == 2) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void thoakindsel(int hand[][], int handRank[], int handSuit[]) {
        //18
        for (int j = 1; j <= 4; j++) {
            if (hand[handRank[0] - 2][j] >= 1) {
                hand[handRank[0] - 2][j] = 4;
            }
        }
        int counter = 0;
        kickersel(hand, handRank, handSuit, 2);
    }

    public void towpairsel(int hand[][], int handRank[], int handSuit[]) {
        //19
        int i, j;
        for (j = 1; j <= 4; j++) {
            if (hand[handRank[0] - 2][j] >= 1) {
                hand[handRank[0] - 2][j] = 4;
            }
        }
        int counter = 0;
        for (i = handRank[0] - 3; i >= handRank[0] - 7; i--) {
            for (j = 1; j <= 4; j++) {
                if (hand[i][j] >= 1) {
                    hand[i][j] = 4;
                    counter++;
                }
                if (counter == 2) {
                    break;
                }
            }
        }
        kickersel(hand, handRank, handSuit, 1);
    }

    public void straightsel(int hand[][], int handRank[], int handSuit[]) {
        for (int i = handRank[0] - 2; i >= handRank[0] - 6; i--) {
            for (int j = 1; j <= 4; j++) {
                if (hand[i][j] >= 1) {
                    hand[i][j] = 4;
                }
            }
        }
    }
}
