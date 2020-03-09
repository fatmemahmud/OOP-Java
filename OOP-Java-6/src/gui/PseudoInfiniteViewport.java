package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class PseudoInfiniteViewport extends JViewport
{
  
    public interface Pannable
    {
        void panBy(int hDelta, int vDelta);

        boolean isPannableUnbounded();

        void showPanTip();
    }

    private JScrollPane scrollParent;
    private Point panPoint = new Point(0, 0);

   
    public PseudoInfiniteViewport(JScrollPane parent)
    {
        scrollParent = parent;
        setBackground(Color.lightGray);
    }

   
    public void setViewPosition(Point pt)
    {
        boolean isAdjusting = scrollParent.getVerticalScrollBar()
                .getValueIsAdjusting()
                || scrollParent.getHorizontalScrollBar().getValueIsAdjusting();
        boolean changed = true;

        if (viewIsUnbounded())
        {
            int hDelta = pt.x - panPoint.x;
            int vDelta = pt.y - panPoint.y;
            if (hDelta != 0 && vDelta == 0)
                getPannableView().panBy(hDelta, vDelta);
            else if (vDelta != 0 && hDelta == 0)
                getPannableView().panBy(hDelta, vDelta);
            else
                changed = false; // no pan action was taken
            panPoint = pt;
            if (!panPoint.equals(getPanCenterPoint()) && !isAdjusting)
            { // needs recentering
                panPoint = getPanCenterPoint();
                fireStateChanged(); // update scrollbars to match
            }
        }
        else
        // ordinary scroll behavior
        {
            changed = !getViewPosition().equals(pt);
            super.setViewPosition(pt);
        }
        if (changed || isAdjusting)
            getPannableView().showPanTip(); // briefly show tip
    }

    
    public Point getViewPosition()
    {
        return (viewIsUnbounded() ? getPanCenterPoint() : super
                .getViewPosition());
    }

    
    public Dimension getViewSize()
    {
        return (viewIsUnbounded() ? getView().getPreferredSize() : super
                .getViewSize());
    }

   

    private Pannable getPannableView()
    {
        return (Pannable) getView();
    }

    private boolean viewIsUnbounded()
    {
        Pannable p = getPannableView();
        return (p != null && p.isPannableUnbounded());
    }

    private Point getPanCenterPoint()
    {
        Dimension size = getViewSize();
        return new Point(size.width / 2, size.height / 2);
    }
}

