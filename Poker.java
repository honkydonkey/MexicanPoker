/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokermain;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author f1110801062
 */
class Poker extends Showdown implements ActionListener {

    public static int[] comnCard;
    public static int[] deck;
    private JPanel cardPanel;
    private JLabel cpuHandPanel1;
    private JLabel cpuHandPanel2;
    private JLabel cpuHandPanel3;
    private JLabel cpuHandPanel4;
    private JLabel cpuHandPanel5;
    private JLabel communityCardPanel1;
    private JLabel communityCardPanel2;
    private JLabel userHandPanel1;
    private JLabel userHandPanel2;
    private JLabel userHandPanel3;
    private JLabel userHandPanel4;
    private JLabel userHandPanel5;
    private JLabel deckPanel;
    private JButton dealButton;
    private JButton drawButton;
    private JButton foldButton;
    private JCheckBox ckbox1;
    private JCheckBox ckbox2;
    private JCheckBox ckbox3;
    private JCheckBox ckbox4;
    private JCheckBox ckbox5;
    private TextAreaRenew tex;
    public int[] userHandRank, cpuHandRank, userHandSuit, cpuHandSuit;
    public int[][] userHand;
    public int[][] cpuHand;
    private JFrame pokerFrame;
    ImageIcon icon1, icon2, icon3, icon4;//icon1...裏表紙 icon2...白紙 icon3...ユーザーの手札用 icon4...コミュニティカード用
    ImageIcon[] icon5;
    private int[][] c3;
    private int[] c4;
    public int counta;
    private int dealcount;//dealボタンが何回押されたかカウントしておく。
    private int textR;//textAreaRnewのための引数

    public Poker() {
        int d = 0;
        pokerFrame = new JFrame("HoldemPoker");

        userHand = new int[13][5];
        cpuHand = new int[13][5];
        userHandRank = new int[1];
        userHandSuit = new int[1];
        cpuHandRank = new int[1];
        cpuHandSuit = new int[1];

        userHandRank[0] = 0;
        cpuHandRank[0] = 0;
        userHandSuit[0] = 0;
        cpuHandSuit[0] = 0;
        c3 = new int[26][10];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 5; j++) {
                userHand[i][j] = 0;
                cpuHand[i][j] = 0;
                c3[i][j] = 0;
                c3[i + 13][j + 5] = 0;
            }
        }
        c4 = new int[5];

        for (int i = 0; i < 5; i++) {
            c4[i] = 0;
        }

        cardPanel = new JPanel();
        cardPanel.setLayout(null);

        cpuHandPanel1 = new JLabel();
        cpuHandPanel2 = new JLabel();
        cpuHandPanel3 = new JLabel();
        cpuHandPanel4 = new JLabel();
        cpuHandPanel5 = new JLabel();

        icon1 = new ImageIcon("52.gif");
        icon2 = new ImageIcon("53.gif");

        cpuHandPanel1.setIcon(icon2);
        cpuHandPanel2.setIcon(icon2);
        cpuHandPanel3.setIcon(icon2);
        cpuHandPanel4.setIcon(icon2);
        cpuHandPanel5.setIcon(icon2);

        JLabel cpu = new JLabel("COM");

        communityCardPanel1 = new JLabel();
        communityCardPanel2 = new JLabel();

        communityCardPanel1.setIcon(icon2);
        communityCardPanel2.setIcon(icon2);

        JLabel community = new JLabel("コミュニティーカード");

        userHandPanel1 = new JLabel();
        userHandPanel2 = new JLabel();
        userHandPanel3 = new JLabel();
        userHandPanel4 = new JLabel();
        userHandPanel5 = new JLabel();

        userHandPanel1.setIcon(icon2);
        userHandPanel2.setIcon(icon2);
        userHandPanel3.setIcon(icon2);
        userHandPanel4.setIcon(icon2);
        userHandPanel5.setIcon(icon2);

        JLabel player = new JLabel("PLAYER");

        deckPanel = new JLabel();
        deckPanel.setIcon(icon1);

        dealButton = new JButton("ディール");
        drawButton = new JButton("ドロー");
        foldButton = new JButton("フォールド");

        tex = new TextAreaRenew();
        tex.TextboxRenew(d, 10, 10);

        deck = new int[52];
        comnCard = new int[2];

        ckbox1 = new JCheckBox();
        ckbox2 = new JCheckBox();
        ckbox3 = new JCheckBox();
        ckbox4 = new JCheckBox();
        ckbox5 = new JCheckBox();

        cardPanel.add(cpu);
        cardPanel.add(community);
        cardPanel.add(player);

        dealButton.addActionListener(this);
        drawButton.addActionListener(this);
        foldButton.addActionListener(this);

        dealButton.setEnabled(true);
        drawButton.setEnabled(false);
        foldButton.setEnabled(false);

        dealButton.setBounds(700, 400, 120, 65);
        drawButton.setBounds(700, 475, 120, 65);
        foldButton.setBounds(700, 550, 120, 65);

        cardPanel.add(dealButton);
        cardPanel.add(drawButton);
        cardPanel.add(foldButton);

        cardPanel.add(cpuHandPanel1);
        cardPanel.add(cpuHandPanel2);
        cardPanel.add(cpuHandPanel3);
        cardPanel.add(cpuHandPanel4);
        cardPanel.add(cpuHandPanel5);

        cpu.setBounds(50, 20, 30, 30);

        cpuHandPanel1.setBounds(50 + 0, 50, 75, 100);
        cpuHandPanel2.setBounds(50 + 100, 50, 75, 100);
        cpuHandPanel3.setBounds(50 + 200, 50, 75, 100);
        cpuHandPanel4.setBounds(50 + 300, 50, 75, 100);
        cpuHandPanel5.setBounds(50 + 400, 50, 75, 100);

        cardPanel.add(userHandPanel1);
        cardPanel.add(userHandPanel2);
        cardPanel.add(userHandPanel3);
        cardPanel.add(userHandPanel4);
        cardPanel.add(userHandPanel5);

        player.setBounds(50, 470, 70, 30);

        userHandPanel1.setBounds(50 + 0, 500, 75, 100);
        userHandPanel2.setBounds(50 + 100, 500, 75, 100);
        userHandPanel3.setBounds(50 + 200, 500, 75, 100);
        userHandPanel4.setBounds(50 + 300, 500, 75, 100);
        userHandPanel5.setBounds(50 + 400, 500, 75, 100);

        cardPanel.add(ckbox1);
        cardPanel.add(ckbox2);
        cardPanel.add(ckbox3);
        cardPanel.add(ckbox4);
        cardPanel.add(ckbox5);

        ckbox1.setBounds(50 + 25, 600, 50, 50);
        ckbox2.setBounds(50 + 125, 600, 50, 50);
        ckbox3.setBounds(50 + 225, 600, 50, 50);
        ckbox4.setBounds(50 + 325, 600, 50, 50);
        ckbox5.setBounds(50 + 425, 600, 50, 50);

        cardPanel.add(communityCardPanel1);
        cardPanel.add(communityCardPanel2);

        community.setBounds(50, 245, 160, 30);

        communityCardPanel1.setBounds(50 + 0, 275, 75, 100);
        communityCardPanel2.setBounds(50 + 100, 275, 75, 100);

        deckPanel.setBounds(710, 270, 75, 100);

        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
        counta = 0;
        dealcount = 0;
        cardPanel.add(deckPanel);
        cardPanel.add(tex);
        cardPanel.add(super.res);
        res.setBounds(700, 50, 150, 150);
        tex.setBounds(280, 245, 300, 200);
        pokerFrame.getContentPane().add(cardPanel, BorderLayout.CENTER);
        pokerFrame.add(cardPanel);
        pokerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pokerFrame.setSize(950, 750);
        pokerFrame.setVisible(true);
    }

    public void reset() {

        userHandRank[0] = 0;
        cpuHandRank[0] = 0;
        userHandSuit[0] = 0;
        cpuHandSuit[0] = 0;
        c3 = new int[26][10];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 5; j++) {
                userHand[i][j] = 0;
                cpuHand[i][j] = 0;
                c3[i][j] = 0;
                c3[i + 13][j + 5] = 0;
            }
        }
        for (int i = 0; i < comnCard.length; i++) {
            comnCard[i] = 0;
        }
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
        for (int i = 0; i < 5; i++) {
            c4[i] = 0;
        }

        dealcount = 0;
        counta = 0;
    }

    public void userDeal() {
        int c[] = new int[5];
        for (int j = 0; j < 5; j++) {
            int a = 0, b = 0;
            while (true) {
                a = (int) (Math.random() * 52);
                if (deck[a] != 0) {
                    b = deck[a];
                    break;
                }
            }
            c[j] = b;
            deck[a] = 0;
        }
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = c.length - 1; j > i; j--) {
                if ((c[j] + 12) % 13 > (c[j - 1] + 12) % 13) {
                    int t = c[j];
                    c[j] = c[j - 1];
                    c[j - 1] = t;
                }

            }
        }
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = c.length - 1; j > i; j--) {
                if ((c[j] + 12) % 13 == (c[j - 1] + 12) % 13) {
                    if (c[j] < c[j - 1]) {
                        int t = c[j];
                        c[j] = c[j - 1];
                        c[j - 1] = t;
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            String aa = String.valueOf(c[i]);
            aa = aa.concat(".gif");
            switch (i) {
                case (0):
                    icon3 = new ImageIcon(aa);
                    userHandPanel1.setIcon(icon3);
                    break;
                case (1):
                    icon3 = new ImageIcon(aa);
                    userHandPanel2.setIcon(icon3);
                    break;
                case (2):
                    icon3 = new ImageIcon(aa);
                    userHandPanel3.setIcon(icon3);
                    break;
                case (3):
                    icon3 = new ImageIcon(aa);
                    userHandPanel4.setIcon(icon3);
                    break;
                case (4):
                    icon3 = new ImageIcon(aa);
                    userHandPanel5.setIcon(icon3);
                    break;

            }

        }

        for (int i = 0; i < comnCard.length; i++) {
            for (int j = 0; j < 13; j++) {
                if (comnCard[i] >= 0 && comnCard[i] < 13) {
                    if ((comnCard[i] + 12) % 13 == j) {
                        userHand[j][1] = 2;
                        userHand[j][0]++;
                    }
                } else if (comnCard[i] >= 13 && comnCard[i] < 26) {
                    if ((comnCard[i] + 12) % 13 == j) {
                        userHand[j][2] = 2;
                        userHand[j][0]++;
                    }
                } else if (comnCard[i] >= 26 && comnCard[i] < 39) {
                    if ((comnCard[i] + 12) % 13 == j) {
                        userHand[j][3] = 2;
                        userHand[j][0]++;
                    }
                } else {
                    if ((comnCard[i] + 12) % 13 == j) {
                        userHand[j][4] = 2;
                        userHand[j][0]++;
                    }
                }

            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < 13; j++) {
                if (c[i] >= 0 && c[i] < 13) {
                    if ((c[i] + 12) % 13 == j) {
                        userHand[j][1] = 3;
                        userHand[j][0]++;
                    }
                } else if (c[i] >= 13 && c[i] < 26) {
                    if ((c[i] + 12) % 13 == j) {
                        userHand[j][2] = 3;
                        userHand[j][0]++;
                    }
                } else if (c[i] >= 26 && c[i] < 39) {
                    if ((c[i] + 12) % 13 == j) {
                        userHand[j][3] = 3;
                        userHand[j][0]++;
                    }
                } else {
                    if ((c[i] + 12) % 13 == j) {
                        userHand[j][4] = 3;
                        userHand[j][0]++;
                    }
                }

            }
        }
    }

    public void cpuDeal() {
        int c[] = new int[5];
        for (int j = 0; j < 5; j++) {
            int a = 0, b = 0;
            while (true) {
                a = (int) (Math.random() * 52);
                if (deck[a] != 0) {
                    b = deck[a];
                    break;
                }
            }
            c[j] = b;
            deck[a] = 0;
        }
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = c.length - 1; j > i; j--) {
                if ((c[j] + 12) % 13 > (c[j - 1] + 12) % 13) {
                    int t = c[j];
                    c[j] = c[j - 1];
                    c[j - 1] = t;
                }
            }
        }
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = c.length - 1; j > i; j--) {
                if ((c[j] + 12) % 13 == (c[j - 1] + 12) % 13) {
                    if (c[j] < c[j - 1]) {
                        int t = c[j];
                        c[j] = c[j - 1];
                        c[j - 1] = t;
                    }
                }
            }
        }
        cpuHandPanel1.setIcon(icon1);
        cpuHandPanel2.setIcon(icon1);
        cpuHandPanel3.setIcon(icon1);
        cpuHandPanel4.setIcon(icon1);
        cpuHandPanel5.setIcon(icon1);



        for (int i = 0; i < comnCard.length; i++) {
            for (int j = 0; j < 13; j++) {
                if (comnCard[i] >= 0 && comnCard[i] < 13) {
                    if ((comnCard[i] + 12) % 13 == j) {
                        cpuHand[j][1] = 2;
                        cpuHand[j][0]++;
                    }
                } else if (comnCard[i] >= 13 && comnCard[i] < 26) {
                    if ((comnCard[i] + 12) % 13 == j) {
                        cpuHand[j][2] = 2;
                        cpuHand[j][0]++;
                    }
                } else if (comnCard[i] >= 26 && comnCard[i] < 39) {
                    if ((comnCard[i] + 12) % 13 == j) {
                        cpuHand[j][3] = 2;
                        cpuHand[j][0]++;
                    }
                } else {
                    if ((comnCard[i] + 12) % 13 == j) {
                        cpuHand[j][4] = 2;
                        cpuHand[j][0]++;
                    }
                }

            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < 13; j++) {
                if (c[i] >= 0 && c[i] < 13) {
                    if ((c[i] + 12) % 13 == j) {
                        cpuHand[j][1] = 1;
                        cpuHand[j][0]++;
                    }
                } else if (c[i] >= 13 && c[i] < 26) {
                    if ((c[i] + 12) % 13 == j) {
                        cpuHand[j][2] = 1;
                        cpuHand[j][0]++;
                    }
                } else if (c[i] >= 26 && c[i] < 39) {
                    if ((c[i] + 12) % 13 == j) {
                        cpuHand[j][3] = 1;
                        cpuHand[j][0]++;
                    }
                } else {
                    if ((c[i] + 12) % 13 == j) {
                        cpuHand[j][4] = 1;
                        cpuHand[j][0]++;
                    }
                }

            }
        }

    }

    public void buttonAble(int x) {
        switch (x) {
            case (1):
                drawButton.setEnabled(true);
                foldButton.setEnabled(true);
                break;
            case (2):
                dealButton.setEnabled(true);
        }

    }

    public void buttonUnable(int x) {
        switch (x) {
            case (1):
                dealButton.setEnabled(false);
                break;
            case (2):
                drawButton.setEnabled(false);
                foldButton.setEnabled(false);
                buttonAble(x);
                break;

        }
    }

    public void comnDeal() {

        for (int j = 0; j < 2; j++) {
            int a = 0, b = 0;
            while (true) {
                a = (int) (Math.random() * 52);
                if (deck[a] != 0) {
                    b = deck[a];
                    break;
                }
            }
            comnCard[j] = b;
            deck[a] = 0;
        }
        if ((comnCard[0] + 12) % 13 < (comnCard[1] + 12) % 13) {
            int t = comnCard[0];
            comnCard[0] = comnCard[1];
            comnCard[1] = t;
        }
        if ((comnCard[0] + 12) % 13 == (comnCard[1] + 12) % 13) {
            if (comnCard[0] > comnCard[1]) {
                int t = comnCard[0];
                comnCard[0] = comnCard[1];
                comnCard[1] = t;

            }
        }
        for (int i = 0; i < 2; i++) {
            String aa = String.valueOf(comnCard[i]);
            aa = aa.concat(".gif");
            switch (i) {
                case (0):
                    icon4 = new ImageIcon(aa);
                    communityCardPanel1.setIcon(icon4);
                    break;
                case (1):
                    icon4 = new ImageIcon(aa);
                    communityCardPanel2.setIcon(icon4);
                    break;


            }

        }
    }

    public void holdselect() {
        int[] ckcount = new int[5];
        for (int i = 0; i < 5; i++) {
            ckcount[i] = 0;
        }
        if (ckbox1.isSelected()) {
            ckcount[0] = 1;
        }
        if (ckbox2.isSelected()) {
            ckcount[1] = 1;
        }
        if (ckbox3.isSelected()) {
            ckcount[2] = 1;
        }
        if (ckbox4.isSelected()) {
            ckcount[3] = 1;
        }
        if (ckbox5.isSelected()) {
            ckcount[4] = 1;
        }
        for (int i = 4; i >= 0; i--) {
            counta = 0;
            if (ckcount[i] == 1) {
                for (int j = 12; j >= 0; j--) {
                    for (int k = 1; k < 5; k++) {
                        if ((userHand[j][k] == 3) && (userHand[j][k] == 3)) {
                            counta++;
                        }
                        if ((counta == (i + 1)) && (userHand[j][k] == 3)) {
                            userHand[j][k] = 1;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int b = 0, d = 0;
        if (e.getSource() == dealButton) {
            if (dealcount == 0) {
                textR = 1;
                buttonAble(textR);
                comnDeal();
                userDeal();
                cpuDeal();
                buttonUnable(textR);
                dealcount++;
                tex.TextboxRenew(textR, 10, 10);
            } else {
                reset();
            }
        } else if (e.getSource() == drawButton) {
            textR = 2;
            holdselect();
            buttonUnable(textR);
            int timecount;

            tex.TextboxRenew(textR, 10, 10);
            c3 = super.cardChange(userHand, userHandRank, userHandSuit, cpuHand, cpuHandRank, cpuHandSuit, deck);
            //c3にcpuの交換したカード、userの交換したカードを返してくる。
            //以下で現在のuserHand、cpuHandの更新
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 5; j++) {
                    userHand[i][j] = c3[i][j];
                    cpuHand[i][j] = c3[i + 13][j + 5];

                }
            }
            //userのラベルに画像を表示
            int a1 = 0;
            d = 0;
            for (int i = 12; i >= 0; i--) {
                b = 0;
                for (int j = 1; j < 5; j++) {
                    if (userHand[i][j] == 3) {
                        int h = 13 * b + ((13 - a1) % 13);
                        if (h != comnCard[0] && h != comnCard[1]) {
                            if (d < 5) {
                                c4[d] = 13 * b + ((13 - a1) % 13);
                                d++;
                            } else {
                                d = 0;
                            }
                        }
                    }
                    b++;
                }
                a1++;
            }
            for (int i = 0; i < 5; i++) {
                String aa = String.valueOf(c4[i]);
                aa = aa.concat(".gif");
                switch (i) {
                    case (0):
                        icon3 = new ImageIcon(aa);
                        userHandPanel1.setIcon(icon3);
                        break;
                    case (1):
                        icon3 = new ImageIcon(aa);
                        userHandPanel2.setIcon(icon3);
                        break;
                    case (2):
                        icon3 = new ImageIcon(aa);
                        userHandPanel3.setIcon(icon3);
                        break;
                    case (3):
                        icon3 = new ImageIcon(aa);
                        userHandPanel4.setIcon(icon3);
                        break;
                    case (4):
                        icon3 = new ImageIcon(aa);
                        userHandPanel5.setIcon(icon3);
                        break;

                }

            }
            //cpuのラベルに画像を表示
            a1 = 0;
            int f = 0;
            for (int i = 0; i < 5; i++) {
                c4[i] = 0;
            }
            for (int i = 12; i >= 0; i--) {
                b = 0;
                for (int j = 1; j <= 4; j++) {
                    if (cpuHand[i][j] == 3 || cpuHand[i][j] == 1) {
                        int h = 13 * b + ((13 - a1) % 13);
                        if (h != comnCard[0] && h != comnCard[1]) {
                            if (f < 5) {
                                c4[f] = 13 * b + ((13 - a1) % 13);
                                f++;
                            } else {
                                f = 0;
                            }
                        }
                    }
                    b++;
                }
                a1++;
            }

            for (int i = 0; i < 5; i++) {
                String aa = String.valueOf(c4[i]);
                aa = aa.concat(".gif");
                switch (i) {
                    case (0):
                        icon3 = new ImageIcon(aa);
                        cpuHandPanel1.setIcon(icon3);
                        break;
                    case (1):
                        icon3 = new ImageIcon(aa);
                        cpuHandPanel2.setIcon(icon3);
                        break;
                    case (2):
                        icon3 = new ImageIcon(aa);
                        cpuHandPanel3.setIcon(icon3);
                        break;
                    case (3):
                        icon3 = new ImageIcon(aa);
                        cpuHandPanel4.setIcon(icon3);
                        break;
                    case (4):
                        icon3 = new ImageIcon(aa);
                        cpuHandPanel5.setIcon(icon3);
                        break;

                }

            }
            super.res.showResult(isWin);
            switch (super.isWin) {
                case (0):
                    int a2 = 4;
                    tex.TextboxRenew(a2, super.PetternNumber[0], super.PetternNumber[1]);
                    break;
                case (1):
                    int a3 = 3;
                    tex.TextboxRenew(a3, super.PetternNumber[0], super.PetternNumber[1]);
                    break;
                case (2):
                    int a4 = 5;
                    tex.TextboxRenew(a4, super.PetternNumber[0], super.PetternNumber[1]);
                    break;
            }
            reset();
        } else if (e.getSource() == foldButton) {
            textR = 2;
            buttonUnable(textR);
            tex.TextboxRenew(textR + 4, 10, 10);
            int a2 = 3;
            super.res.showResult(a2);
            reset();
        }
    }
}
