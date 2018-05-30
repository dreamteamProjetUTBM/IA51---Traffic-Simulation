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
package framework.time;

import framework.time.AbstractTime;
import framework.time.AbstractTimeManager;
import io.sarl.lang.annotation.DefaultValue;
import io.sarl.lang.annotation.DefaultValueSource;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSourceCode;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.concurrent.TimeUnit;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Step-based Time manager.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.7")
@SarlElementType(10)
@SuppressWarnings("all")
public class StepTimeManager extends AbstractTimeManager {
  private float delay = 10f;
  
  private float t;
  
  private final float step;
  
  /**
   * @param stepDuration the duration of one simulation step (in ms)
   */
  public StepTimeManager(final float stepDuration) {
    this.step = AbstractTime.unitsToSeconds(stepDuration, TimeUnit.MILLISECONDS);
  }
  
  @DefaultValueSource
  @Override
  public synchronized float getCurrentTime(@DefaultValue("framework.time.StepTimeManager#GETCURRENTTIME_0") final TimeUnit unit) {
    TimeUnit _elvis = null;
    if (unit != null) {
      _elvis = unit;
    } else {
      _elvis = TimeUnit.SECONDS;
    }
    return AbstractTime.secondsToUnits(this.t, _elvis);
  }
  
  /**
   * Default value for the parameter unit
   */
  @SyntheticMember
  @SarlSourceCode("null")
  private final static TimeUnit $DEFAULT_VALUE$GETCURRENTTIME_0 = null;
  
  @DefaultValueSource
  @Override
  public synchronized float getLastStepDuration(@DefaultValue("framework.time.StepTimeManager#GETLASTSTEPDURATION_0") final TimeUnit unit) {
    TimeUnit _elvis = null;
    if (unit != null) {
      _elvis = unit;
    } else {
      _elvis = TimeUnit.SECONDS;
    }
    return AbstractTime.secondsToUnits(this.step, _elvis);
  }
  
  /**
   * Default value for the parameter unit
   */
  @SyntheticMember
  @SarlSourceCode("null")
  private final static TimeUnit $DEFAULT_VALUE$GETLASTSTEPDURATION_0 = null;
  
  @Override
  public synchronized void increment() {
    float _t = this.t;
    this.t = (_t + this.step);
  }
  
  @Override
  public synchronized float getSimulationDelay() {
    return this.delay;
  }
  
  @Override
  public synchronized void setSimulationDelay(final float delay) {
    this.delay = Math.max(0f, delay);
  }
  
  @Override
  @Pure
  public String toString() {
    return ((((("t=" + Float.valueOf(this.t)) + "; step=") + Float.valueOf(this.step)) + "; delay = ") + Float.valueOf(this.delay));
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
    StepTimeManager other = (StepTimeManager) obj;
    if (Float.floatToIntBits(other.delay) != Float.floatToIntBits(this.delay))
      return false;
    if (Float.floatToIntBits(other.t) != Float.floatToIntBits(this.t))
      return false;
    if (Float.floatToIntBits(other.step) != Float.floatToIntBits(this.step))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Float.floatToIntBits(this.delay);
    result = prime * result + Float.floatToIntBits(this.t);
    result = prime * result + Float.floatToIntBits(this.step);
    return result;
  }
}
