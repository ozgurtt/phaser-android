package org.cniska.invaders.world;

import org.cniska.invaders.Invaders;
import org.cniska.invaders.R;
import org.cniska.phaser.core.GameView;
import org.cniska.phaser.core.Updateable;
import org.cniska.phaser.node.Actor;
import org.cniska.phaser.scene.World;

public class Torpedo extends SpaceActor {

	/**
	 * Creates a new actor.
	 *
	 * @param view The game view.
	 * @param world The parent world.
	 */
	public Torpedo(GameView view, World world) {
		super(view, world);
		id = Invaders.ACTOR_TORPEDO;
	}

	@Override
	protected void init() {
		super.init();
		loadBitmap(R.drawable.missile_02);
		explosion.loadBitmap(R.drawable.explosion_03);
	}

	@Override
	public void update(Updateable parent) {
		super.update(parent);

		if (y > (view.getHeight() + 30)) {
			die();
		}
	}

	@Override
	public boolean collides(Actor other) {
		return (other instanceof Player || other instanceof Rocket) && intersects(other);
	}
}
