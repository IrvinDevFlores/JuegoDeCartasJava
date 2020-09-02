import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLa extends JFrame
{
    static final String gapList[] = {"0","10","15"};
    final static int maxGap = 20;
    JComboBox horGapComboBox;
    JComboBox verGapComboBox;
    JButton applyButton = new JButton("Applu gaps");
    GridLayout experimentLayout = new GridLayout(0,2);

    public GridLa(String name)
    {
        super(name);
        setResizable(false);
    }

    public void initGaps()
    {
        horGapComboBox = new JComboBox(gapList);
        verGapComboBox = new JComboBox(gapList);
    }

    public void addComponentToPane(final Container pane)
    {
        initGaps();
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);

        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2,3));


        JButton b = new JButton("Just Take");
        Dimension buttonSize = b.getPreferredSize();
        compsToExperiment.setPreferredSize(new Dimension((int)(buttonSize.getHeight() * 2.5) +maxGap,
                (int)(buttonSize.getHeight() * 3.5 ) + maxGap * 2));


        compsToExperiment.add(new JButton("Button 1"));

        compsToExperiment.add(new JButton("Button 2"));

        compsToExperiment.add(new JButton("Button 3"));

        compsToExperiment.add(new JButton("Long name"));

        compsToExperiment.add(new JButton("Button 5"));

        controls.add(new Label("Horizontal gap:"));
        controls.add(new Label("Vertical gap"));
        controls.add(new JLabel(""));
        controls.add(horGapComboBox);
        controls.add(verGapComboBox);
        controls.add(applyButton);

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String horGap = (String) horGapComboBox.getSelectedItem();
                String verGap = (String) horGapComboBox.getSelectedItem();

                experimentLayout.setHgap(Integer.parseInt(horGap));
                experimentLayout.setVgap(Integer.parseInt(verGap));

                experimentLayout.layoutContainer(compsToExperiment);
            }
        });
        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(new JSeparator(),BorderLayout.CENTER);
        pane.add(controls,BorderLayout.SOUTH);
    }

    public static  void main(String args[])
    {
        GridLa frame = new GridLa("Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addComponentToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


}
