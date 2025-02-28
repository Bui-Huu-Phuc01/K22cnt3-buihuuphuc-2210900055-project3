package utils;

import javax.swing.JOptionPane;
import java.awt.Component;

public class MessageDialogHelper {
    public static void showMessage(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static boolean showConfirmDialog(Component parent, String message, String title) {
        int option = JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;
    }
}
