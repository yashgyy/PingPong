/**
 * Created by Yash on 5/5/2017.
 */
public class Rectangle {
private int x;
private int y;
final private int height;
final private int weight;
private Test t1;
Rectangle(){
    x=0;
    y=100;
    weight=50;
    height = 150;
}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private boolean checkY(int x){
    if((y+height+x)>=t1.getHeight() || (y+x)<=0 ) return false;
    else return true;
    }



    public void setY(int y) {
        if(checkY(y))
            this.y = this.y+y;
        else
            return;
    }

    public void setTest(Test T1){
    this.t1=T1;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
