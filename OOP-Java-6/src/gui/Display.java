package gui;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Display
{
    void draw(Object obj, Component c, Graphics2D g2, Rectangle rect);
}
