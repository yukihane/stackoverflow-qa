package com.github.yukihane;

import static java.awt.Color.RED;

public class TurtleTrap4 {
    Turtle t;
    int x, y;
    int dx, dy;

    public void init(int xpos, int ypos, int xspeed, int yspeed) {
    this.x = xpos;
    this.y = ypos;
    this.dx = xspeed;
    this.dy = yspeed;
    this.t = new Turtle();
    this.t.move(xpos, ypos);
    this.t.penDown();
    }

    public static void setColor(java.awt.Color c) {
        // ここにメソッドが呼ばれたときの処理を実装する
    }

    public void step() {
    if (this.x < 20 || 340 < this.x)
        this.dx = -this.dx;
    if (this.y < 20 || 340 < this.y)
        this.dy = -this.dy;
    
    this.x += this.dx;
    this.y += this.dy;
    this.t.move(this.x, this.y);
    }

    public static void main(String[] args) {
    TurtleTrap4 trapA = new TurtleTrap4();
    trapA.init(100, 200, 10, 5);

    TurtleTrap4 trapB = new TurtleTrap4();
    trapB.init(150, 250, -10, 3);
    setColor(RED);



    while (true) {
        trapA.step();
        trapB.step();
    }
    }
}
