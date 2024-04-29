package Game.game.view;

import Game.Data.constants;
import Game.game.Contoroler.Update;
import Game.game.Contoroler.impact;
import Game.game.model.characterModel.Epsilon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Game.Data.constants.PANEL_BACK_GRAND;
import static Game.game.model.characterModel.Epsilon.AthenaPower;

public class Shop extends JPanel implements Runnable {
    private JButton EXIT;
    JPanel me = this;
    private JLabel EpsilonHp;
    private JLabel Exp;
    private JButton shop1;
    private JButton shop2;
    private JButton shop3;
    private JLabel flag1;
    private JLabel flag2;
    private JLabel flag3;

    private boolean buy1 = true;
    private boolean buy2 = true;
    private boolean currentBuy = false;
    private boolean a = true;

    public Shop () {
        if (AthenaPower) {
            buy2 = true;
        }
    }

    @Override
    public void run () {
        setSize (constants.LOGIN_WIDTH, constants.LOGIN_HEIGHT);
        setLocation (constants.LOGIN_START_X, constants.LOGIN_START_Y);
        setVisible (true);
        setOpaque (true);
        setFocusable (true);
        requestFocus ();
        requestFocusInWindow ();
        setLayout (null);
        setBorder (BorderFactory.createLineBorder (Color.red, 5));
        setBackground (PANEL_BACK_GRAND);
        frameInGame.getFrame ().add (this);
        repaint ();
        EXIT = new JButton ();
        EXIT.setVisible (true);
        EXIT.setBounds (6, 6, 70, 41);
        EXIT.setIcon (new ImageIcon ("src\\sources\\photo\\Exit.png"));
        EXIT.addActionListener (new AbstractAction () {
            @Override
            public void actionPerformed (ActionEvent e) {
                frameInGame.getFrame ().remove (me);
                inputListener.stop = true;
                Update.FRAME_UPDATE.start ();
                Update.MODEL_UPDATE.start ();
                if (currentBuy) {
                    new Timer (5000, new AbstractAction () {
                        @Override
                        public void actionPerformed (ActionEvent e) {
                            if (!a) {
                                AthenaPower = false;
                                ((Timer) e.getSource ()).stop ();
                            } else {
                                a = false;
                            }
                        }
                    }).start ();
                }
                inputListener.aaa = true;
                frameInGame.getFrame ().repaint ();
            }
        });
        this.add (EXIT);
        shop1 = new JButton ();
        shop1.setIcon (new ImageIcon ("src\\sources\\photo\\shop1.png"));
        shop1.setBounds (constants.LOGIN_WIDTH / 3, constants.LOGIN_HEIGHT / 4, 432, 35);
        shop1.setVisible (true);
        shop1.setOpaque (true);
        shop1.addActionListener (new AbstractAction () {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (buy1 && Epsilon.getEpsilon ().decreaseEXP (100)) {
                    new impact (Epsilon.getEpsilon ().getCenter (), 200, 300);
                    flag1.setIcon (new ImageIcon ("src\\sources\\photo\\buyGREEN.png"));
                    buy1 = false;
                    repaint ();
                }
            }
        });
        this.add (shop1);
        shop3 = new JButton ();
        shop3.setIcon (new ImageIcon ("src\\sources\\photo\\shop3.png"));
        shop3.setBounds ((constants.LOGIN_WIDTH * 1) / 3, (constants.LOGIN_HEIGHT * 3) / 4, 304, 35);
        shop3.setVisible (true);
        shop3.setOpaque (true);
        shop3.addActionListener (new AbstractAction () {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (Epsilon.getEpsilon ().getHP () != 100) {
                    if (Epsilon.getEpsilon ().decreaseEXP (75)) {
                        Epsilon.getEpsilon ().increaseHp (10);
                        repaint ();
                    }
                }
            }
        });
        this.add (shop3);
        shop2 = new JButton ();
        shop2.setIcon (new ImageIcon ("src\\sources\\photo\\shop2.png"));
        shop2.setBounds ((constants.LOGIN_WIDTH * 1) / 3, constants.LOGIN_HEIGHT / 2, 406, 35);
        shop2.setVisible (true);
        shop2.setOpaque (true);
        shop2.addActionListener (new AbstractAction () {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (buy2 && Epsilon.getEpsilon ().decreaseEXP (300)) {
                    AthenaPower = true;
                    currentBuy = true;
                    repaint ();
                }
            }
        });
        this.add (shop2);
        flag1 = new JLabel (new ImageIcon ("src\\sources\\photo\\notBuyRed.png"));
        flag1.setVisible (true);
        flag1.setBounds ((constants.LOGIN_WIDTH) / 6, constants.LOGIN_HEIGHT / 4, 35, 35);
        flag1.setOpaque (true);
        this.add (flag1);
        if (buy2) {
            flag2 = new JLabel (new ImageIcon ("src\\sources\\photo\\notBuyRed.png"));
        } else {
            flag2 = new JLabel (new ImageIcon ("src\\sources\\photo\\buyGREEN.png"));
        }
        flag2.setVisible (true);
        flag2.setBounds ((constants.LOGIN_WIDTH) / 6, constants.LOGIN_HEIGHT / 2, 35, 35);
        flag2.setOpaque (true);
        this.add (flag2);
        flag3 = new JLabel (new ImageIcon ("src\\sources\\photo\\notBuyRed.png"));
        flag3.setVisible (true);
        flag3.setBounds ((constants.LOGIN_WIDTH) / 6, (constants.LOGIN_HEIGHT * 3) / 4, 35, 35);
        flag3.setOpaque (true);
        this.add (flag3);
        EpsilonHp = new JLabel ();
        EpsilonHp.setSize (new Dimension (60, 35));
        EpsilonHp.setVisible (true);
        EpsilonHp.setLocation (new Point (this.getWidth () - 2 - EpsilonHp.getWidth (), 2));
        EpsilonHp.setText ("HP: " + Epsilon.getEpsilon ());
        EpsilonHp.setFont (new Font ("Arial", Font.ITALIC, 13));
        EpsilonHp.setForeground (Color.WHITE);
        EpsilonHp.setOpaque (false);
        EpsilonHp.setBackground (Color.black);
        this.add (EpsilonHp);
        Exp = new JLabel ();
        Exp.setSize (new Dimension (200, 35));
        Exp.setVisible (true);
        Exp.setLocation (new Point (80, 2));
        Exp.setText ("exp :" + Epsilon.getEpsilon ());
        Exp.setFont (new Font ("Arial", Font.ITALIC, 13));
        Exp.getFont ().deriveFont (Font.BOLD);
        Exp.setForeground (new Color (100, 0, 250));
        Exp.setOpaque (false);
        Exp.setBackground (Color.black);
        this.add (Exp);
    }

    @Override
    public void paint (Graphics g) {
        EpsilonHp.setText ("HP: " + Epsilon.getEpsilon ().getHP ());
        Exp.setText ("exp :" + Epsilon.getEpsilon ().getExp ());
        super.paint (g);
    }
}
