package com.loftschool.moneytrackermarch18;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

public class ConfirmationDialog extends DialogFragment {

    private ConfirmationDialogListener listener = null;

    public void setListener(ConfirmationDialogListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle("Удалени")
                .setMessage("Вы уверны?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null) {
                            listener.onPositiveBtnClicked();
                        }
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null) {
                            listener.onNegativeBtnClicked();
                        }
                    }
                })
                .create();

        return dialog;
    }
}
