/**
 * Created by Yash on 5/5/2017.
 */
public class Ball {
    private int x;
    private int y;
    private double speedX;
    private double speedY;
    Ball(int x,int y,double speedX,double speedY){
        this.x=x;
        this.y=y;
        this.speedX=speedX;
        this.speedY=speedY;


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }
    public void stepX(){
        x+=speedX;
    }
    public void stepY(){
        y+=speedY;
    }

    public void invertX(){
        this.speedX=this.speedX-(2*this.speedX);
    }
    public void inverY(){
        this.speedY=this.speedY-(2*this.speedY);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
