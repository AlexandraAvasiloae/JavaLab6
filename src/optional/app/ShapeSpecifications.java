package optional.app;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ShapeSpecifications
{
    Color color;
    int nPoints;
    int x;
    int y;
    int sides;
    int radius;
    String shapeType;

    /**
     * constructor in case we want to create an object which retain the specifications of a regular polygon
     * @param shapeType
     * @param x
     * @param y
     * @param color
     * @param sides
     * @param radius
     */
    public ShapeSpecifications(String shapeType,int x,int y,Color color, int sides, int radius) {
        this.x=x;
        this.y=y;
        this.color = color;
        this.sides = sides;
        this.radius = radius;
        this.shapeType = shapeType;
    }

    /**
     * constructor in case we want to create an object which retain the specifications of a star
     * @param x
     * @param y
     * @param color
     * @param nPoints
     * @param radius
     * @param shapeType
     */
    public ShapeSpecifications(int x,int y,Color color, int nPoints, int radius, String shapeType) {
        this.x=x;
        this.y=y;
        this.color = color;
        this.nPoints = nPoints;
        this.radius = radius;
        this.shapeType= shapeType;
    }


}