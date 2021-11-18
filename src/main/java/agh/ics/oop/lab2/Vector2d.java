package agh.ics.oop.lab2;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString(){
        return "(" + String.valueOf(this.x) + ", " + String.valueOf(this.y) + ")";
    }

    public boolean precedes(Vector2d other){
        return other.x <= this.x && other.y <= this.y;
    }

    public boolean follows(Vector2d other){
        return other.x >= this.x && other.y >= this.y;
    }


    public Vector2d upperRight(Vector2d other){
        int X;
        int Y;

        if (other.x > this.x){
            X = other.x;
        } else X = this.x;

        if (other.y >  this.y){
            Y = other.y;
        } else Y = this.y;

        return  new Vector2d(X, Y);
    }

    public Vector2d lowerLeft(Vector2d other){
        int X;
        int Y;

        if (other.x < this.x){
            X = other.x;
        } else X = this.x;

        if (other.y <  this.y){
            Y = other.y;
        } else Y = this.y;

        return  new Vector2d(X, Y);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d((this.x + other.x), (this.y + other.y));
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d((this.x - other.x)/2, (this.y - other.x)/2);
    }

    public boolean equals(Object other){
        return this == other;
    }

    public Vector2d opposite(){
        return new Vector2d(this.x * (-1), this.y * (-1));
    }

}


