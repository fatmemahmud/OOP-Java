package ChessBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.tools.DocumentationTool.Location;

public class UnboundedGrid<E> extends AbstractGrid<E>
{
    private Map<Location, E> occupantMap;

   
    public UnboundedGrid()
    {
        occupantMap = new HashMap<Location, E>();
    }

    public int getNumRows()
    {
        return -1;
    }

    public int getNumCols()
    {
        return -1;
    }

    public boolean isValid(Location loc)
    {
        return true;
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> a = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet())
            a.add(loc);
        return a;
    }

    public E get(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        return occupantMap.get(loc);
    }

    public E put(Location loc, E obj)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        if (obj == null)
            throw new NullPointerException("obj == null");
        return occupantMap.put(loc, obj);
    }

    public E remove(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        return occupantMap.remove(loc);
    }

	@Override
	public boolean isValid(Location loc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E put(Location loc, E obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Location> getOccupiedLocations() {
		// TODO Auto-generated method stub
		return null;
	}
}

