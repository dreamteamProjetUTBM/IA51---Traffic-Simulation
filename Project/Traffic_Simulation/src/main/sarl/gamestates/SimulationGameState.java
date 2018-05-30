package gamestates;

import org.arakhne.afc.io.shape.ShapeFileReader;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import entities.Button;
import entities.EntityCollection;
import entities.EventEntityMouseClicked;
import logic.Map;
import environments.*;


public class SimulationGameState extends BasicGameState {

	private EntityCollection entities;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		entities = new EntityCollection();
		
		//entities.add(new Car());
		//ShapeFileReader reader = new ShapeFileReader<>(file, factory)
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException
	{
	}
	
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
	}

	@Override
	public int getID() {
		return SimulationWindow.GS_SIMULATION;
	}
	
}
