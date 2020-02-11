import java.awt.BorderLayout;
import java.foreign.NativeTypes;
import java.foreign.Scope;
import java.foreign.memory.Pointer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    private static final long serialVersionUID = 4648172894076113183L;

    public Main() {
        super("Rust GUI Frontend by Java Swing");
        setLayout(new BorderLayout());

        final JTextField nameField = new JTextField(20);

        final JTextField outputField = new JTextField(30);
        outputField.setEditable(false);

        final JButton greetButton = new JButton("greet");
        greetButton.addActionListener((e) -> {
            final Scope scope = greeter_lib.scope();

            final Pointer<Byte> name = scope.allocateCString(nameField.getText());
            final long size = 256;
            final Pointer<Byte> message = scope.allocateArray(NativeTypes.UINT8, size).elementPointer();

            greeter_lib.greet(name, message, size);

            final String retval = Pointer.toString(message);
            outputField.setText(retval);
        });

        add(nameField, BorderLayout.WEST);
        add(greetButton, BorderLayout.EAST);
        add(outputField, BorderLayout.SOUTH);
        pack();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            final Main app = new Main();
            app.setVisible(true);
        });
    }

}
