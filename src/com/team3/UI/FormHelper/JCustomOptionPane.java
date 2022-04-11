/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.UI.FormHelper;

import java.awt.Dialog;

/**
 *
 * @author MyPC
 */
public class JCustomOptionPane {

    public static Warning msgAlertDialog = new Warning(new javax.swing.JFrame(), true);
    public static Confirm msgConfirmDialog = new Confirm(new javax.swing.JFrame(), true);
    public static Promt msgPromtDialog = new Promt(new javax.swing.JFrame(), true);
   
    public void displayAlertPane(String title, String contents) {
        msgAlertDialog.lblTitle.setText(title);
        msgAlertDialog.lblMsg.setText(contents);
        msgAlertDialog.setTitle(title);
        msgAlertDialog.setVisible(true);
        msgAlertDialog.setModal(true);
        msgAlertDialog.setAlwaysOnTop(true);
        msgAlertDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

    }
    
    public void displayConfirmPane(String title, String contents) {
        msgConfirmDialog.lblTitle.setText(title);
        msgConfirmDialog.lblMsg.setText(contents);
        msgConfirmDialog.setTitle(title);
        msgConfirmDialog.setVisible(true);
        msgConfirmDialog.setModal(true);
        msgConfirmDialog.setAlwaysOnTop(true);
        msgConfirmDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

    }
    public void displayPromtPane(String title, String contents) {
        msgPromtDialog.lblTitle.setText(title);
        msgPromtDialog.lblMsg.setText(contents);
        msgPromtDialog.setTitle(title);
        msgPromtDialog.setVisible(true);
        msgPromtDialog.setModal(true);
        msgPromtDialog.setAlwaysOnTop(true);
        msgPromtDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

    }
    
    public boolean getState() {
        boolean tempState = false;
        
        if(msgConfirmDialog.option==true){
            tempState = true;
        } else
        if(msgConfirmDialog.option==false){  
            tempState = false;
        }  
        return tempState ;
    }
    
    public String getResult(){
     String result = msgPromtDialog.result;
        return result;      
    }
}
