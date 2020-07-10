import com.sun.java.swing.plaf.windows.resources.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JComponent implements ActionListener,
        MouseMotionListener {

    private int ballX = 300;
    private int ballY = 150;
    private int paddleX = 0;
    private int ballYSpeed = 7;
    private int ballXSpeed = 5;

    public static void main(String[] args){
        JFrame window = new JFrame("Pong game by John");
        PongGame game = new PongGame();

        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        Timer t = new Timer(40, game);
        t.start();

        window.addMouseMotionListener(game);
    }

    public Dimension getPreferredSize(){
        return new Dimension(800,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
//        background
        g.setColor(new Color(75, 11, 15));
        g.fillRect(0,0,800,600);
//          paddle
        g.setColor(new Color(21, 75, 21));
        g.fillRect(paddleX,510,150,15);

//        draw baw
        g.setColor(new Color(0x322BAE));
        g.fillOval(ballX,
                ballY,
                30,
                30);
    }

    public void actionPerformed(ActionEvent e) {
        ballX = ballX+ballXSpeed;
        ballY = ballY + ballYSpeed;
        if(ballX >=paddleX && ballX <= paddleX +150 && ballY >= 480){
            ballYSpeed = -7;
        }
        if (ballX >= 770){
            ballXSpeed = -5;
        }
        if (ballX <= 0){
            ballXSpeed = 5;
        }
        if (ballY <= 0){
            ballYSpeed = 7;
        }
        repaint();
    }

    public void mouseDragged(MouseEvent e) { }

    public void mouseMoved(MouseEvent e) {
        paddleX = e.getX()-75;
        repaint();
    }
}
