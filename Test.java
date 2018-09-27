import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Yash on 5/5/2017.
 */
public class Test extends Frame {
    Ball b1;
    Rectangle r1;
    int score;

    Test() {

        super("Testing the Window");
        this.setSize(640, 480);
        this.setBackground(Color.black);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode=e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_UP:
                        r1.setY(-4);
                        break;
                    case KeyEvent.VK_DOWN:
                        r1.setY(+4);
                        break;
                }

            }
        });
        b1=new Ball(this.getWidth()/2,this.getHeight()/2,4.0,4.0);
        r1=new Rectangle();
        r1.setTest(this);

    }
    public void paint(Graphics g)
    {
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.BLUE);
        g2d.fillOval(b1.getX(),b1.getY(),20,20);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(r1.getX(),r1.getY(),20,150);

    }
    public boolean checkerX()
    {
        if(this.b1.getX()<0){
            this.b1.setX(this.getWidth()/2);
            this.b1.setY(this.getHeight()/2);
            this.score--;
            System.out.println("Score: "+score);
            return true;
        }
        if(this.b1.getX() < 0 || this.b1.getX() >= this.getWidth()) return true;
        else return false;
    }
    public boolean checkerY(){
        if(this.b1.getY() < 0 || this.b1.getY() >= this.getHeight()) return true;
        else return false;

    }
    public boolean checkerTurn(){
        if(r1.getX()+r1.getWeight()>=(b1.getX()+30)&& (r1.getY()+r1.getHeight()>=b1.getY()) && (r1.getY()<=b1.getY())) return true;
        else return false;
    }

    public static void main(String args[]) {
       Test test1= new Test();

       while (true) {

           test1.repaint();
           test1.b1.stepX();
           test1.b1.stepY();
           test1.repaint();
           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           if (test1.checkerX()) {


               test1.b1.invertX();
               continue;

           }
            if (test1.checkerY()) {

               test1.b1.inverY();
               continue;
           }
           if(test1.checkerTurn()) {
               test1.score=test1.score+2;
               System.out.println("Score: "+test1.score);
               test1.b1.invertX();
               test1.b1.inverY();

           }

       }


    }
}



