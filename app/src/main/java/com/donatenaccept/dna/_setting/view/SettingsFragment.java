package com.donatenaccept.dna._setting.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.login.LoginActivity;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by neha on 2/3/17.
 */

public class SettingsFragment extends Fragment implements View.OnClickListener {

    TextView tvLogout, tvSelectedTone;
    RelativeLayout llNotificationSounds;
    LinearLayout llChangePassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        findViewById(view);

        if (Utility.getPreferences(getActivity(), "selectedTone").equalsIgnoreCase("")) {
            tvSelectedTone.setText("None");
        } else {
            tvSelectedTone.setText(Utility.getPreferences(getActivity(), "selectedTone"));
        }
        return view;
    }

    private void findViewById(View view) {

        llNotificationSounds = (RelativeLayout) view.findViewById(R.id.setting_sound);
        llNotificationSounds.setOnClickListener(this);
        tvSelectedTone = (TextView) view.findViewById(R.id.setting_selected_ringtone);

        llChangePassword = (LinearLayout) view.findViewById(R.id.setting_change_password);
        llChangePassword.setOnClickListener(this);

        tvLogout = (TextView) view.findViewById(R.id.setting_logout);
        tvLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_sound:
                Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Notification Tone");
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, false);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, Uri.parse(Utility.getPreferences(getActivity(), "selectedToneUri")));
                startActivityForResult(intent, 5);
                break;

            case R.id.setting_change_password:
                Intent mIntent = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(mIntent);
                break;


            case R.id.setting_logout:
                showLogoutDialog();
                break;
        }
    }

    private void showDeleteUserDialog() {
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(getActivity());

        // set title
        alertDialogBuilder.setTitle("Alert");

        // set dialog message
        alertDialogBuilder
                .setMessage("You will not receive any notifications. Continue ?")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        // create alert dialog
        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    private void showLogoutDialog() {
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(getActivity());

        // set title
        alertDialogBuilder.setTitle("Alert");

        // set dialog message
        alertDialogBuilder
                .setMessage("Do you want to Logout ?")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Utility.addPreferences(getActivity(), Constants.keyLoginCheck, false);
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                        getActivity().finishAffinity();

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        // create alert dialog
        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }


    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent intent) {
        if (resultCode == Activity.RESULT_OK && requestCode == 5) {
            Uri uri = intent.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);

            if (uri != null) {
                String selectedTone = RingtoneManager.getRingtone(getActivity(), uri).getTitle(getActivity());
                tvSelectedTone.setText(selectedTone);
                Utility.addPreferences(getActivity(), "selectedToneUri", uri.toString());
                Utility.addPreferences(getActivity(), "selectedTone", selectedTone);
            }
        }
    }
}
