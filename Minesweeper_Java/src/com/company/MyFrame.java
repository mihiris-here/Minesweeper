package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//https://www.flaticon.com/
public class MyFrame extends JFrame {

    private int[][] tiles = new Board(2).getBoard();
    private int sizeofButton = 15;
    private JPanel[][] jp = new JPanel[tiles[0].length][tiles.length];


    MyFrame() {
        //20x20 buttons
        System.out.println(tiles.length + ", " + tiles[0].length);
        for (int i = 0; i < tiles.length; i++){
            System.out.println(Arrays.toString(tiles[0]));
        }

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                JButton jb = new JButton();
                jb.setBounds(j * sizeofButton, i * sizeofButton, sizeofButton, sizeofButton);
                this.add(jb);

                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int x = jb.getX() / sizeofButton;
                        int y = jb.getY() / sizeofButton;

                        // Remove the button from the parent container
                        MyFrame.this.remove(jb);

                        // Create and add a new JPanel in its place
                        jp[x][y] = new JPanel();
                        jp[x][y].setBounds(x * sizeofButton, y * sizeofButton, sizeofButton, sizeofButton);
                        jp[x][y].setBackground(Color.GRAY);
                        MyFrame.this.add(jp[x][y]);

                        // Repaint the frame to update the layout
                        MyFrame.this.revalidate();
                        MyFrame.this.repaint();
                    }
                });
            }
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Minesweeper");
        this.setSize(tiles[0].length*(6+sizeofButton), tiles.length*(6+sizeofButton));
        this.setVisible(true);



    }


}
