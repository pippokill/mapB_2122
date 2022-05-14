/*
 * Copyright (C) 2020 pierpaolo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package di.uniba.map.b.lab.swing;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.Keymap;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author pierpaolo
 */
public class Editor extends javax.swing.JFrame {

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
        init();
    }

    private void init() {
        initActionTable();
        Action newAction = new NewAction("New");
        newAction.putValue(Action.SMALL_ICON, new ImageIcon("img/general/New16.gif"));
        newAction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("img/general/New24.gif"));
        jmiNew.setAction(newAction);
        jToolBar1.add(newAction);
        undoAction.putValue(Action.SMALL_ICON, new ImageIcon("img/general/Undo16.gif"));
        undoAction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("img/general/Undo24.gif"));
        jmEdit.add(undoAction);
        jToolBar1.add(undoAction);
        redoAction.putValue(Action.SMALL_ICON, new ImageIcon("img/general/Redo16.gif"));
        redoAction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("img/general/Redo24.gif"));
        jmEdit.add(redoAction);
        jToolBar1.add(redoAction);
        jmEdit.add(new JSeparator());
        jToolBar1.add(new JSeparator());
        Action cutaction = getEditorActionByName(DefaultEditorKit.cutAction);
        cutaction.putValue(Action.NAME, "Cut");
        cutaction.putValue(Action.SMALL_ICON, new ImageIcon("img/general/Cut16.gif"));
        cutaction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("img/general/Cut24.gif"));
        jmEdit.add(cutaction);
        jToolBar1.add(cutaction);
        Action copyaction = getEditorActionByName(DefaultEditorKit.copyAction);
        copyaction.putValue(Action.NAME, "Copy");
        copyaction.putValue(Action.SMALL_ICON, new ImageIcon("img/general/Copy16.gif"));
        copyaction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("img/general/Copy24.gif"));
        jmEdit.add(copyaction);
        jToolBar1.add(copyaction);
        Action pasteaction = getEditorActionByName(DefaultEditorKit.pasteAction);
        pasteaction.putValue(Action.NAME, "Paste");
        pasteaction.putValue(Action.SMALL_ICON, new ImageIcon("img/general/Paste16.gif"));
        pasteaction.putValue(Action.LARGE_ICON_KEY, new ImageIcon("img/general/Paste24.gif"));
        jmEdit.add(pasteaction);
        jToolBar1.add(pasteaction);
        Keymap keymap = jepMain.getKeymap();
        KeyStroke keydown = KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK);
        keymap.addActionForKeyStroke(keydown, getEditorActionByName(DefaultEditorKit.downAction));
        KeyStroke keyup = KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK);
        keymap.addActionForKeyStroke(keyup, getEditorActionByName(DefaultEditorKit.upAction));

        jepMain.getDocument().addUndoableEditListener(new MyUndoableEditListener());
        jepMain.getDocument().addDocumentListener(new MyDocumentListener());
    }

    private Map<Object, Action> editorActionTable;

    private void initActionTable() {
        editorActionTable = new HashMap<>();
        Action[] actions = jepMain.getActions();
        for (Action action : actions) {
            editorActionTable.put(action.getValue(Action.NAME), action);
        }
    }

    private Action getEditorActionByName(String action) {
        return editorActionTable.get(action);
    }

    /**
     *
     */
    protected UndoManager undo = new UndoManager();

    /**
     *
     */
    protected UndoAction undoAction = new UndoAction("Undo");

    /**
     *
     */
    protected RedoAction redoAction = new RedoAction("Redo");

    /**
     *
     */
    protected class MyUndoableEditListener implements UndoableEditListener {

        /**
         *
         * @param e
         */
        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            undo.addEdit(e.getEdit());
        }

    }

    /**
     *
     */
    protected class UndoAction extends AbstractAction {

        /**
         *
         * @param name
         */
        public UndoAction(String name) {
            super(name);
        }

        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                undo.undo();
            } catch (CannotUndoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Undo exception", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    /**
     *
     */
    protected class RedoAction extends AbstractAction {

        /**
         *
         * @param name
         */
        public RedoAction(String name) {
            super(name);
        }

        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                undo.redo();
            } catch (CannotRedoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Redo exception", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    /**
     *
     */
    protected class MyDocumentListener implements DocumentListener {

        /**
         *
         * @param e
         */
        @Override
        public void insertUpdate(DocumentEvent e) {
            displayEditInfo(e);
        }

        /**
         *
         * @param e
         */
        @Override
        public void removeUpdate(DocumentEvent e) {
            displayEditInfo(e);
        }

        /**
         *
         * @param e
         */
        @Override
        public void changedUpdate(DocumentEvent e) {
            displayEditInfo(e);
        }

        private void displayEditInfo(DocumentEvent e) {
            saved = false;
            Document document = e.getDocument();
            int length = e.getLength();
            System.out.println(e.getType() + ": " + length + ", " + document.getLength() + "\tsaved: " + saved);
        }

    }

    private boolean saved = true;

    /**
     *
     */
    protected class NewAction extends AbstractAction {

        /**
         *
         * @param name
         */
        public NewAction(String name) {
            super(name);
        }

        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!saved) {
                int option = JOptionPane.showConfirmDialog(null, "Not saved. Are you sure?", "New document", JOptionPane.YES_NO_CANCEL_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    jepMain.setText("");
                    saved = true;
                } else if (option == JOptionPane.NO_OPTION) {
                    jmiSaveActionPerformed(e);
                } else if (option == JOptionPane.CANCEL_OPTION) {
                    return;
                }
            } else {
                jepMain.setText("");
                saved = true;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jepMain = new javax.swing.JEditorPane();
        jToolBar1 = new javax.swing.JToolBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiNew = new javax.swing.JMenuItem();
        jmiOpen = new javax.swing.JMenuItem();
        jmiSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiExit = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 400));
        jScrollPane1.setViewportView(jepMain);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);
        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        jmFile.setText("File");
        jmFile.setToolTipText("");

        jmiNew.setText("jMenuItem1");
        jmFile.add(jmiNew);

        jmiOpen.setText("Open...");
        jmiOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOpenActionPerformed(evt);
            }
        });
        jmFile.add(jmiOpen);

        jmiSave.setText("Save...");
        jmiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveActionPerformed(evt);
            }
        });
        jmFile.add(jmiSave);
        jmFile.add(jSeparator1);

        jmiExit.setText("Exit");
        jmFile.add(jmiExit);

        jMenuBar1.add(jmFile);

        jmEdit.setText("Edit");
        jMenuBar1.add(jmEdit);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOpenActionPerformed
        // TODO add your handling code here:
        if (!saved) {
            int option = JOptionPane.showConfirmDialog(null, "Not saved. Are you sure?", "Open document", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                jepMain.setText("");
                saved = true;
            } else if (option == JOptionPane.NO_OPTION) {
                jmiSaveActionPerformed(evt);
            } else if (option == JOptionPane.CANCEL_OPTION) {
                return;
            }
        } else {
            JFileChooser fc = new JFileChooser();
            fc.setMultiSelectionEnabled(false);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    StringBuilder sb = new StringBuilder();
                    while (reader.ready()) {
                        sb.append(reader.readLine());
                        sb.append("\n");
                    }
                    reader.close();
                    jepMain.setText(sb.toString());
                    saved = true;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "I/O Error: " + ex.getMessage(), "Error open file", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jmiOpenActionPerformed

    private void jmiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(file);
                writer.append(jepMain.getText());
                writer.close();
                saved = true;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "I/O Error: " + ex.getMessage(), "Error save file", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jmiSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JEditorPane jepMain;
    private javax.swing.JMenu jmEdit;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiNew;
    private javax.swing.JMenuItem jmiOpen;
    private javax.swing.JMenuItem jmiSave;
    // End of variables declaration//GEN-END:variables
}
