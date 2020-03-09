package ChessBoard;

import java.util.ArrayList;

import javax.tools.DocumentationTool.Location;

public abstract class AbstractGrid<E> implements Grid<E>
{
    public ArrayList<E> getNeighbors(Location loc)
    {
        ArrayList<E> neighbors = new ArrayList<E>();
        for (Location neighborLoc : getOccupiedAdjacentLocations(loc))
            neighbors.add(get(neighborLoc));
        return neighbors;
    }
    
	public ArrayList<E> getNeighborsInRange(Location loc, int range) {
		ArrayList<E> neighbors = new ArrayList<E>();
		
		Location hotspot;
		for(int row = loc.getRow() - range; row < loc.getRow() + range; row++) {
			for(int col = loc.getCol() - range; col < loc.getCol() + range; col++) {
				hotspot = new Location(row, col);
				if(!hotspot.equals(loc) && isValid(hotspot) && get(hotspot) != null) {
					neighbors.add(get(hotspot));
				}
			}
		}
		
		return neighbors;
	}

    public ArrayList<Location> getValidAdjacentLocations(Location loc)
    {
        ArrayList<Location> locs = new ArrayList<Location>();

        int d = Location.NORTH;
        for (int i = 0; i < Location.FULL_CIRCLE / Location.HALF_RIGHT; i++)
        {
            Location neighborLoc = loc.getAdjacentLocation(d);
            if (isValid(neighborLoc))
                locs.add(neighborLoc);
            d = d + Location.HALF_RIGHT;
        }
        return locs;
    }

    public ArrayList<Location> getEmptyAdjacentLocations(Location loc)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for (Location neighborLoc : getValidAdjacentLocations(loc))
        {
            if (get(neighborLoc) == null)
                locs.add(neighborLoc);
        }
        return locs;
    }

    public ArrayList<Location> getOccupiedAdjacentLocations(Location loc)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for (Location neighborLoc : getValidAdjacentLocations(loc))
        {
            if (get(neighborLoc) != null)
                locs.add(neighborLoc);
        }
        return locs;
    }

   public String toString()
        {
            String s = "{";
            for (Location loc : getOccupiedLocations())
            {
                if (s.length() > 1)
                    s += ", ";
                s += loc + "=" + get(loc);
            }
            return s + "}";
        }
}
