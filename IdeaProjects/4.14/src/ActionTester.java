import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JButton RedButton = new JButton("Red");
        RedButton.addActionListener(ColourButtonListener());

        JButton GreenButton = new JButton("Green");
        GreenButton.addActionListener(ColourButtonListener());

        JButton BlueButton = new JButton("Blue");
        BlueButton.addActionListener(
                ColourButtonListener());

        icon = new CircleIcon(100);
        label = new JLabel(icon);

        frame.setLayout(new FlowLayout());
        frame.add(RedButton);
        frame.add(GreenButton);
        frame.add(BlueButton);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static ActionListener ColourButtonListener()
    {
        return new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        String cmd = event.getActionCommand();
                        switch(cmd){
                        case "Red":
                            icon.setColor(Color.RED);
                            break;
                        case "Blue":
                            icon.setColor(Color.BLUE);
                            break;
                        case "Green":
                            icon.setColor(Color.GREEN);
                            break;
                        default:
                            break;
                    }
                        label.repaint();
                    }
                };
    }

    private static CircleIcon icon;
    private static JLabel label;
}
