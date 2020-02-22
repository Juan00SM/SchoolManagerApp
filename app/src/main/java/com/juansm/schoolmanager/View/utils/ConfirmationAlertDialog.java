package com.juansm.schoolmanager.View.utils;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.juansm.schoolmanager.R;

public class ConfirmationAlertDialog {

    public final Long RESULT_CODE_POSITIVE = (long)1;
    public final Long RESULT_CODE_NEUTRE = (long)0;
    public final Long RESULT_CODE_NEGATIVE = (long)-1;

    private Long resultCode;
    public ConfirmationAlertDialog() {
    }

    public Long getResultCode(){
        return this.resultCode;
    }

    public AlertDialog createAndShowConfirmDialog(Context context, String title, String message) {
        resultCode = (long)0;
        return new AlertDialog.Builder(context)
                .setTitle(title != null && !title.equals("") ? title : context.getString(R.string.title_dialog_confirmation))
                .setMessage(message != null && !message.equals("") ? message : context.getString(R.string.message_dialog_confirmation))
                .setIcon(R.drawable.ic_storage)
                .setPositiveButton(context.getString(R.string.text_button_accept),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                resultCode=RESULT_CODE_POSITIVE;
                                dialog.cancel();
                            }
                        })
                .setNegativeButton(context.getString(R.string.text_button_cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                resultCode=RESULT_CODE_NEGATIVE;
                                dialog.cancel();
                            }
                        }).show();
    }
}
