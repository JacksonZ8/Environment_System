package org.example;

import javax.swing.*;

public class Main {
    static void main() {
        // ----- GUI -----
        JFrame frame = new JFrame("Environmental System");
        frame.setSize(900, 600);
        System GUI = new System();
        frame.add(GUI);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
