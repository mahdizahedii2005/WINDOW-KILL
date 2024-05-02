package Game.game.model.characterModel;

import Game.game.Contoroler.Spawn;
import Game.game.view.characterView.PrizeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.UUID;

import static Game.Data.constants.PRIZE_TIME;
import static Game.game.Contoroler.Controller.addPrizeView;

public class prize extends ObjectInGame {
    public static ArrayList<prize> prizeArrayList = new ArrayList<> ();
    int increaseHP;

    public prize (Point2D.Double center, Color color, int IncreaseHp) {
        super (center, color, UUID.randomUUID ().toString (), 1, PrizeView.radius);
        this.increaseHP = IncreaseHp;
        addPrizeView (id);
        switch (Spawn.spawnstate) {
            case first -> Epsilon.getEpsilon ().increaseExp (increaseHP * 1.2);
            case second -> Epsilon.getEpsilon ().increaseExp (increaseHP * 1.5);
            case third -> Epsilon.getEpsilon ().increaseExp (increaseHP * 1.8);
        }
        prizeArrayList.add (this);
        new Timer (PRIZE_TIME, new AbstractAction () {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (!die){
                    die = true;
                }else{
                    Die ();
                    ((Timer)e.getSource ()).stop ();
                }
            }
        }).start ();
    }

    boolean die = false;

    @Override
    public void Die () {
        prizeArrayList.remove (this);
        super.Die ();
    }

    public void Action () {
        Epsilon.getEpsilon ().increaseHp (increaseHP);
        Die ();
    }
}
