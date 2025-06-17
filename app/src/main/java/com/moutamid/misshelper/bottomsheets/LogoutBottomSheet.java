package com.moutamid.misshelper.bottomsheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.moutamid.misshelper.R;

public class LogoutBottomSheet extends BottomSheetDialogFragment {

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.logout_bottom_sheet, container, false);
        ImageView buttonClose = view.findViewById(R.id.cancel);
        buttonClose.setOnClickListener(v -> dismiss());
        return view;
    }
}