/**
 * $Id$
 * 
 * Copyright (c) 2011-17 Stephane GALLAND <stephane.galland@utbm.fr>.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * This program is free software; you can redistribute it and/or modify
 */
package framework.environment;

import com.google.common.base.Objects;
import framework.environment.AgentBody;
import framework.environment.MobileObject;
import framework.environment.SituatedObject;
import framework.math.Point2f;
import framework.math.Shape2f;
import framework.math.Vector2f;
import io.sarl.lang.annotation.DefaultValue;
import io.sarl.lang.annotation.DefaultValueSource;
import io.sarl.lang.annotation.DefaultValueUse;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSourceCode;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.io.Serializable;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Defined a perception unit.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.7")
@SarlElementType(10)
@SuppressWarnings("all")
public class Percept implements MobileObject, Serializable {
  private final UUID bodyId;
  
  private final UUID objectId;
  
  private Shape2f<?> shape;
  
  private Point2f position;
  
  private final float angle;
  
  private final Serializable type;
  
  private final float maxLinearSpeed;
  
  private final float maxLinearAcceleration;
  
  private Vector2f currentLinearMotion;
  
  private float maxAngularSpeed;
  
  private final float maxAngularAcceleration;
  
  private final float currentAngularSpeed;
  
  private final String name;
  
  private SituatedObject body;
  
  /**
   * @param perceivedObject is the perceived object.
   */
  @DefaultValueSource
  public Percept(final SituatedObject perceivedObject, @DefaultValue("framework.environment.Percept#NEW_0") final Serializable type) {
    this.objectId = perceivedObject.getID();
    this.name = perceivedObject.getName();
    this.shape = perceivedObject.getShape();
    this.position = perceivedObject.getPosition().clone();
    Serializable _elvis = null;
    if (type != null) {
      _elvis = type;
    } else {
      Serializable _type = perceivedObject.getType();
      _elvis = _type;
    }
    Serializable rtype = _elvis;
    Serializable _elvis_1 = null;
    if (rtype != null) {
      _elvis_1 = rtype;
    } else {
      String _name = perceivedObject.getClass().getName();
      _elvis_1 = _name;
    }
    this.type = _elvis_1;
    this.body = perceivedObject;
    if ((perceivedObject instanceof MobileObject)) {
      this.angle = ((MobileObject)perceivedObject).getAngle();
      this.maxAngularAcceleration = ((MobileObject)perceivedObject).getMaxAngularAcceleration();
      this.maxAngularSpeed = ((MobileObject)perceivedObject).getMaxAngularSpeed();
      this.maxLinearAcceleration = ((MobileObject)perceivedObject).getMaxLinearAcceleration();
      this.maxLinearSpeed = ((MobileObject)perceivedObject).getMaxLinearSpeed();
      this.currentAngularSpeed = ((MobileObject)perceivedObject).getCurrentAngularSpeed();
      this.currentLinearMotion = ((MobileObject)perceivedObject).getCurrentLinearMotion().clone();
    } else {
      this.angle = 0f;
      this.maxAngularAcceleration = 0f;
      this.maxAngularSpeed = 0f;
      this.maxLinearAcceleration = 0f;
      this.maxLinearSpeed = 0f;
      this.currentAngularSpeed = 0f;
      this.currentLinearMotion = null;
    }
    if ((perceivedObject instanceof AgentBody)) {
      this.bodyId = ((AgentBody)perceivedObject).getID();
    } else {
      this.bodyId = null;
    }
  }
  
  /**
   * Default value for the parameter type
   */
  @SyntheticMember
  @SarlSourceCode("null")
  private final static Serializable $DEFAULT_VALUE$NEW_0 = null;
  
  @Pure
  public SituatedObject getBody() {
    return this.body;
  }
  
  @Override
  public Percept clone() {
    try {
      Object _clone = super.clone();
      Percept clone = ((Percept) _clone);
      clone.currentLinearMotion = this.currentLinearMotion.clone();
      clone.position = this.position.clone();
      clone.shape = this.shape.clone();
      return clone;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if ((obj instanceof Percept)) {
      return (Objects.equal(this.bodyId, ((Percept)obj).bodyId) && Objects.equal(this.objectId, ((Percept)obj).objectId));
    }
    return false;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return Objects.hashCode(this.bodyId, this.objectId);
  }
  
  @Override
  @Pure
  public int compareTo(final SituatedObject o) {
    if ((o instanceof Percept)) {
      if ((this.bodyId != null)) {
        UUID _iD = ((Percept)o).getID();
        int c = (this.bodyId.compareTo(_iD));
        if ((c != 0)) {
          return c;
        }
      }
      if ((this.objectId != null)) {
        UUID _iD_1 = ((Percept)o).getID();
        return (this.objectId.compareTo(_iD_1));
      }
    }
    return Integer.MAX_VALUE;
  }
  
  /**
   * Replies the id of the body.
   * 
   * @return the id of the body.
   */
  @Pure
  public UUID getBodyID() {
    return this.bodyId;
  }
  
  /**
   * Replies the id of the body.
   * 
   * @return the id of the body.
   */
  public UUID getID() {
    return this.objectId;
  }
  
  @Override
  public Shape2f<?> getShape() {
    return this.shape;
  }
  
  @Override
  public float getX() {
    return this.position.getX();
  }
  
  @Override
  public float getY() {
    return this.position.getY();
  }
  
  @Override
  public Point2f getPosition() {
    return this.position;
  }
  
  @Override
  public float getAngle() {
    return this.angle;
  }
  
  @Override
  public Vector2f getDirection() {
    return Vector2f.toOrientationVector(this.angle);
  }
  
  @Override
  public float getMaxLinearSpeed() {
    return this.maxLinearSpeed;
  }
  
  @Override
  public float getMaxAngularSpeed() {
    return this.maxAngularSpeed;
  }
  
  @Override
  public float getMaxLinearAcceleration() {
    return this.maxLinearAcceleration;
  }
  
  @Override
  public float getMaxAngularAcceleration() {
    return this.maxAngularAcceleration;
  }
  
  @Override
  public float getCurrentAngularSpeed() {
    return this.currentAngularSpeed;
  }
  
  @Override
  public float getCurrentLinearSpeed() {
    Vector2f _currentLinearMotion = this.currentLinearMotion;
    float _length = 0f;
    if (_currentLinearMotion!=null) {
      _length=_currentLinearMotion.length();
    }
    return _length;
  }
  
  @Override
  public Vector2f getCurrentLinearMotion() {
    Vector2f _vector2f = new Vector2f();
    return this.currentLinearMotion.operator_elvis(_vector2f);
  }
  
  @Override
  public Serializable getType() {
    return this.type;
  }
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  @Pure
  public String toString() {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.name);
    if (_isNullOrEmpty) {
      _xifexpression = super.toString();
    } else {
      _xifexpression = this.name;
    }
    return _xifexpression;
  }
  
  /**
   * @optionalparam perceivedObject is the perceived object.
   */
  @DefaultValueUse("framework.environment.SituatedObject,java.io.Serializable")
  @SyntheticMember
  public Percept(final SituatedObject perceivedObject) {
    this(perceivedObject, $DEFAULT_VALUE$NEW_0);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 14511889873L;
}
