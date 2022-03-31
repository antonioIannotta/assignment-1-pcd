import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewerFrame extends JFrame {

    private VisualiserPanel panel;

    public ViewerFrame(VisualiserPanel.Context ctx, int w, int h) {
        setTitle("Bouncing Balls");
        setSize(w, h);
        setResizable(false);
        panel = new VisualiserPanel(w, h);
        getContentPane().add(panel);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }

            public void windowClosed(WindowEvent ev) {
                System.exit(-1);
            }
        });
    }

}

