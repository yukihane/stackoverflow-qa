import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyView extends JPanel
{
        private int chara_i, chara_x, chara_y;
        private Image[] chara_array;
        private Image image;
        private Image sub;


        public MyView(Image[] chara_array)
        {
                MyModel model = new MyModel(chara_array);
                Toolkit tk = Toolkit.getDefaultToolkit();
                //model.getImage();
                this.image = tk.getImage("sogen.png");
                this.sub = tk.getImage("asi.png");
                //model.getChara_i();
                //model.getChara_x();
                //model.getChara_y();
                this.chara_i = 0;
                this.chara_x = 0;
                this.chara_y = 0;

                //model.setChara_array(chara_array);
                this.chara_array = chara_array;

                super.setPreferredSize(new Dimension(400, 400));
                super.setBackground(Color.white);

}


    /*  public void paint(Graphics g){
            Toolkit tk = Toolkit.getDefaultToolkit();
            Image image = tk.getImage("sogen2.png");
            g.drawImage(image,0,0,this);
        }*/

        public void paintComponent(Graphics g)
        {
                System.out.println("in paintComponent: ");


                super.paintComponent(g);
                g.drawImage(image,0,0,this);
                g.drawImage(sub,500,300,this);

                /*g.drawImage(this.chara_array[this.chara_i], this.chara_x * 10 + 30, this.chara_y * 10 + 15, this);
                g.drawImage(this.chara_array[this.chara_i], - this.chara_x * 10 + 530, -this.chara_y * 10 + 500, this);
                g.drawImage(this.chara_array[this.chara_i], this.chara_x * 10 + 30, -this.chara_y * 10 + 500, this);
                g.drawImage(this.chara_array[this.chara_i], - this.chara_x * 10 + 530, this.chara_y * 10 + 15, this);
                */

                g.drawImage(this.chara_array[this.chara_i], 500, 350, this);
                g.drawImage(this.chara_array[this.chara_i], 500, 350, this);
                g.drawImage(this.chara_array[this.chara_i], 500, 350, this);
                g.drawImage(this.chara_array[this.chara_i], 500, 350, this);




                this.chara_i++;
                this.chara_x++;
                this.chara_y++;

                if(this.chara_i == 3){
                        this.chara_i = 0;
                }
/*
                if((this.chara_x * 10 + 30) >= 550){
                        this.chara_x = 0;
                        this.chara_y = 0;

                }
*/

        }
}
