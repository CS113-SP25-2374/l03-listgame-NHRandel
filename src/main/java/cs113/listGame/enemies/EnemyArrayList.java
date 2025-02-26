package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.MoveToPoint;
import cs113.listGame.behaviors.Waiting;
import cs113.listGame.gamecore.GameObject;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class EnemyArrayList extends EnemyObject {
   ArrayList<Behavior> behaviors = new ArrayList<>();
   Random rand = new Random();

    public EnemyArrayList(ImageView imageView) { super(imageView); }

    @Override
    public void seedBehaviors() {
        Point2D dest = new Point2D(rand.nextDouble(500), rand.nextDouble(400));
        behaviors.add( new Waiting(this, 3000) );
        behaviors.add(new MoveToPoint(this, 4000, dest));
    }

    @Override
    public Behavior getNextBehavior() {
        if (behaviors.isEmpty()) {
            return null;
        }

        int index = rand.nextInt(behaviors.size());

        return behaviors.remove(index);
    }
}