package com.example.wristhelp.ui.contactos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.wristhelp.R;

public class ContactosFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contactos, container, false);

        ImageButton crearContacto;
        crearContacto = (ImageButton)  root.findViewById(R.id.button_addContacto);

        crearContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Has creado un contacto", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}