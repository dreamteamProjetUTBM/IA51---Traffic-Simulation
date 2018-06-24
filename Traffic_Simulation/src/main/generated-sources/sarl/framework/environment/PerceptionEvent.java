/**
 * $Id$
 * 
 * Copyright (c) 2014-17 Stephane GALLAND <stephane.galland@utbm.fr>.
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

import framework.environment.Percept;
import framework.time.TimePercept;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Event;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * This event contains percepts.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 */
@SarlSpecification("0.7")
@SarlElementType(15)
@SuppressWarnings("all")
public class PerceptionEvent extends Event {
  public final Percept body;
  
  public final TimePercept time;
  
  public final List<Percept> perceptions;
  
  public float perceptionDistance;
  
  public PerceptionEvent(final List<Percept> p, final Percept b, final TimePercept t, final float perceptionDistance) {
    this.perceptions = p;
    this.body = b;
    this.time = t;
    this.perceptionDistance = perceptionDistance;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PerceptionEvent other = (PerceptionEvent) obj;
    if (Float.floatToIntBits(other.perceptionDistance) != Float.floatToIntBits(this.perceptionDistance))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.perceptionDistance);
    return result;
  }
  
  /**
   * Returns a String representation of the PerceptionEvent event's attributes only.
   */
  @SyntheticMember
  @Pure
  protected void toString(final ToStringBuilder builder) {
    super.toString(builder);
    builder.add("body", this.body);
    builder.add("time", this.time);
    builder.add("perceptions", this.perceptions);
    builder.add("perceptionDistance", this.perceptionDistance);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 2630670636L;
}
