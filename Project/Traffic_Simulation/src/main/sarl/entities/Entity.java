package entities;


import org.newdawn.slick.geom.Rectangle;
//import org.lwjgl.util.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class Entity {
	/**
	 * La position de l'entitï¿½
	 */
	protected Vector2f position;
	protected Vector2f size;

	/**
	 * Permet de savoir si l'entité est updatable
	 */
	protected boolean updatable;
	/**
	 * Permet de savoir si l'entité est dessinable
	 */
	protected boolean drawable;

	/**
	 * Construit une entitï¿½ qui possï¿½de la position et la taille donnï¿½e
	 * 
	 * @param _position
	 *            La position de l'entitï¿½
	 * @param _size
	 *            La taille de l'entitï¿½
	 */
	public Entity(Vector2f _position, Vector2f _size) {
		position = new Vector2f(_position.x, _position.y);
		size = new Vector2f(_size.x, _size.y);

		updatable = false;
		drawable = false;
	}

	/**
	 * Construit une entitï¿½ avec la position donnï¿½e mais une taille qui est
	 * de 0 pour la largeur ainsi que la hauteur de l'entitï¿½
	 * 
	 * @param _position
	 *            La position de l'entitï¿½
	 */
	public Entity(Vector2f _position) {
		position = new Vector2f(_position.x, _position.y);
		size = new Vector2f();
	}

	/**
	 * Rï¿½cupï¿½rer la position actuelle de l'entitï¿½
	 * 
	 * @return la position
	 */
	public Vector2f getPosition() {
		return position;
	}

	/**
	 * Donner une position qui sera la nouvelle position de l'entitï¿½
	 * 
	 * @param _position
	 *            la nouvelle position
	 */
	public void setPosition(Vector2f _position) {
		position.x = _position.x;
		position.y = _position.y;
	}

	/**
	 * Permet de dï¿½placer l'entitï¿½ par la valeur de l'offset donnï¿½ sur les
	 * axes x et y
	 * 
	 * @param _offset
	 *            les offset de dï¿½placement sur x et y
	 */
	public void move(Vector2f _offset) {
		position.x += _offset.x;
		position.y += _offset.y;
	}

	/**
	 * Permet de rï¿½cupï¿½rer un vecteur qui donne la taille de l'entitï¿½ (sa
	 * largeur dans x et sa hauteur dans y)
	 * 
	 * @return le vecteur contenant la taille
	 */
	public Vector2f getSize() {
		return size;
	}

	/**
	 * Permet de dï¿½finir la taille de l'entitï¿½
	 * 
	 * @param _size
	 *            la composante x reprï¿½sente la largeur et la composante y
	 *            reprï¿½sente la hauteur de l'entitï¿½
	 */
	public void setSize(Vector2f _size) {
		size.x = _size.x;
		size.y = _size.y;
	}

	/**
	 * Permet de rï¿½cupï¿½rer un rectangle dont les composantes reprï¿½sentent
	 * la position ainsi que la taille de l'entitï¿½ :<br>
	 * - x : position en x<br>
	 * - y : position en y<br>
	 * - width : largeur de l'entitï¿½<br>
	 * - height : hauteur de l'entitï¿½<br>
	 * Ce rectangle peut servir dans le cadre de la dï¿½tection d'un clique
	 * souris par exemple
	 * 
	 * @return
	 */
	public Rectangle getRect() {
		Rectangle rect = new Rectangle((int) position.x, (int) position.y, (int) size.x, (int) size.y);

		return rect;
	}

	/**
	 * Permet de savoir si l'entité peut être updaté
	 * 
	 * @return updatable
	 */
	public boolean isUpdateble() {
		return updatable;
	}

	/**
	 * Permet de savoir si l'entité peut être dessiné
	 * 
	 * @return drawable
	 */
	public boolean isDrawable() {
		return drawable;
	}
}