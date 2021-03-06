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

import framework.environment.Environment;
import framework.gui.WorldModelStateProvider;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.EventObject;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Event in environment.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.7")
@SarlElementType(10)
@SuppressWarnings("all")
public class EnvironmentEvent extends EventObject {
  /**
   * Replies the environment.
   * 
   * @return the environment.
   */
  @Pure
  public Environment getEnvironment() {
    return ((Environment) this.source);
  }
  
  /**
   * Replies the state provider.
   * 
   * @return the state provider.
   */
  @Pure
  public WorldModelStateProvider getStateProvider() {
    return ((WorldModelStateProvider) this.source);
  }
  
  @SyntheticMember
  public EnvironmentEvent(final Object arg0) {
    super(arg0);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = -2876690620L;
}
