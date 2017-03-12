/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template menuExcluir, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scriptsearch.entidy;

import com.scriptsearch.dao.ScriptDao;
import com.scriptsearch.view.TelaCadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author murilo.silva
 */
public class MouseListListener implements MouseListener {

    private JList list;
    private JPopupMenu menu;
    private int index;
    private JTextArea txtQuery;

    public MouseListListener(JList list, JTextArea txtQuery) {
        this.list = list;
        this.txtQuery = txtQuery;
        this.menu = new JPopupMenu();

        JMenuItem menuAlterar = new JMenuItem("Alterar");
        menuAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Script script = getScriptFromModel();
                new TelaCadastro(null, true, script);
                atualizarLista();
            }
        });

        JMenuItem menuExcluir = new JMenuItem("Excluir");
        menuExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Script script = getScriptFromModel();
                ScriptDao dao = new ScriptDao();
                dao.delete(script.getIdScript());
                atualizarLista();
            }
        });
        this.menu.add(menuAlterar);
        this.menu.add(menuExcluir);
    }

    private void atualizarLista() {
        ScriptDao dao = new ScriptDao();
        DefaultListModel model = (DefaultListModel) list.getModel();
        model.clear();
        List<Script> lista = new ArrayList<>();
        lista.addAll(dao.findAll());
        for (Script s : lista) {
            model.addElement(s);
        }
    }

    private Script getScriptFromModel() {
        DefaultListModel model = (DefaultListModel) list.getModel();
        Script script = (Script) model.get(index);
        return script;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.index = list.locationToIndex(e.getPoint());
        this.list.setSelectedIndex(this.index);
        Script script = getScriptFromModel();
        txtQuery.setText(script.getDsQuery());
        if (SwingUtilities.isRightMouseButton(e)) {
            this.menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
