package environments;

import com.google.common.base.Objects;
import environments.EnvironmentObject;
import framework.environment.AgentBody;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.HashSet;
import java.util.UUID;
import org.arakhne.afc.gis.road.primitive.RoadSegment;
import org.arakhne.afc.math.geometry.d2.d.Point2d;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Data on a road segment
 */
@SarlSpecification("0.7")
@SarlElementType(10)
@SuppressWarnings("all")
public class RoadSegmentData {
  /**
   * Targeted segment
   */
  private RoadSegment segment;
  
  /**
   * EnvironmentObject located at the start of the segment
   */
  private EnvironmentObject objectAtStart;
  
  /**
   * EnvironmentObject located at the end of the segment
   */
  private EnvironmentObject objectAtEnd;
  
  /**
   * Agent bodies that are present on the segment
   */
  private HashSet<AgentBody> bodies;
  
  /**
   * Constructor
   */
  public RoadSegmentData(final RoadSegment segment) {
    this.segment = segment;
  }
  
  @Pure
  public EnvironmentObject getObjectAtStart() {
    return this.objectAtStart;
  }
  
  @Pure
  public EnvironmentObject getObjectAtEnd() {
    return this.objectAtEnd;
  }
  
  @Pure
  public RoadSegment getSegment() {
    return this.segment;
  }
  
  /**
   * @author Thomas Gredin
   * 
   * @description
   * Return the UUID of the segment stored.
   */
  @Pure
  public UUID getID() {
    return this.segment.getUUID();
  }
  
  /**
   * @author Thomas Gredin
   * 
   * @description
   * Return the Begin point position of the road segment.
   */
  @Pure
  public Point2d getBeginPoint() {
    return this.segment.getBeginPoint().getPoint();
  }
  
  /**
   * @author Thomas Gredin
   * 
   * @description
   * Return the End point position of the road segment.
   */
  @Pure
  public Point2d getEndPoint() {
    return this.segment.getEndPoint().getPoint();
  }
  
  /**
   * @author Thomas Gredin
   * 
   * @description
   * Return the collection of all agent bodies that are on the Road Segment.
   */
  @Pure
  public HashSet<AgentBody> getAgentBodies() {
    return this.bodies;
  }
  
  /**
   * @author Thomas Gredin
   * 
   * @description
   * Add an agent body to the Road Segment but before it check if this agent is not already
   * on it with its UUID.
   */
  public boolean appendAgentBody(final AgentBody body) {
    final Function1<AgentBody, Boolean> _function = (AgentBody el) -> {
      UUID _iD = el.getID();
      UUID _iD_1 = body.getID();
      return Boolean.valueOf(Objects.equal(_iD, _iD_1));
    };
    AgentBody _findFirst = IterableExtensions.<AgentBody>findFirst(this.bodies, _function);
    boolean _notEquals = (!Objects.equal(_findFirst, null));
    if (_notEquals) {
      return false;
    }
    this.bodies.add(body);
    return true;
  }
  
  /**
   * @author Thomas Gredin
   * 
   * @description
   * Remove an AgentBody from the Road Segment using its UUID.
   * return false if the body is on the segment end be removed, false
   * otherwise.
   */
  public boolean removeAgentBody(final AgentBody body) {
    final Function1<AgentBody, Boolean> _function = (AgentBody el) -> {
      UUID _iD = el.getID();
      UUID _iD_1 = body.getID();
      return Boolean.valueOf(Objects.equal(_iD, _iD_1));
    };
    AgentBody result = IterableExtensions.<AgentBody>findFirst(this.bodies, _function);
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      return false;
    }
    this.bodies.remove(result);
    return true;
  }
  
  public void setObjectAtStart(final EnvironmentObject object) {
    this.objectAtStart = object;
  }
  
  public void setObjectAtEnd(final EnvironmentObject object) {
    this.objectAtEnd = object;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
}
