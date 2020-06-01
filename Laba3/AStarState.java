import java.util.HashMap;



/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D karta;

    private HashMap<Location, Waypoint> otkrWP;
    private HashMap<Location, Waypoint> zakrWP;


    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D karta)
    {
        if (karta == null)
            throw new NullPointerException("karta cannot be null");

        this.karta = karta;

        otkrWP = new HashMap<>();
        zakrWP = new HashMap<>();
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return karta;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        if(this.openWP.size()==0) return null;
        var tmp = this.otkrWP.values();
        double minVal = 1e10;
        Waypoint result = null;
        for(Waypoint w: tmp)
        {
           if(minVal > w.getTotalCost())
           {
               minVal = w.getTotalCost();
               result = w;
           }
        }
        return result;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOtkrWaypoint(Waypoint newWP)
    {
        if(!otkrWP.containsKey(newWP.loc))
        {
            otkrWP.put(newWP.loc,newWP);
            return true;
        }
        else
        {
            var wp = otkrWP.get(newWP.loc);
            if(wp.getPreviousCost() > newWP.getPreviousCost())
            {
                otkrWP.put(newWP.loc, newWP);
                return true;
            }
            else return false;
        }
    }


    /** Returns the current number of open waypoints. **/
    public int numOtkrWaypoints()
    {
        return this.otkrWP.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void zakrWaypoint(Location loc)
    {
        zakrWP.put(loc,otkrWP.get(loc));
        otkrWP.remove(loc);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        return zakrWP.containsKey(loc);
    }
}

