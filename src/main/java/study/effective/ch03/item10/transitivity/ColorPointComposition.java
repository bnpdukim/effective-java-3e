package study.effective.ch03.item10.transitivity;

import java.awt.*;

public class ColorPointComposition {
    private final Point point;
    private final Color color;
    public ColorPointComposition(int x, int y, Color color) {
        this.point = new Point(x,y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if( !(o instanceof ColorPointComposition) ) return false;

        ColorPointComposition colorPoint = (ColorPointComposition)o;

        return colorPoint.point.equals(point) && colorPoint.color.equals(color);
    }
}
