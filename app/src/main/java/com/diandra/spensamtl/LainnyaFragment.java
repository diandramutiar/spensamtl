package com.diandra.spensamtl;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class LainnyaFragment extends Fragment {


    public LainnyaFragment() {
        // Required empty public constructor
    }

    RelativeLayout Layout_sejarah, Layout_visimisi, Layout_tatatertib, Layout_kontak;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lainnya, container, false);
        Layout_sejarah = view.findViewById(R.id.layout_sejarah);
        Layout_sejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SejarahFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });

        Layout_visimisi = view.findViewById(R.id.layout_visimisi);
        Layout_visimisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new VisiMisiFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });

        Layout_tatatertib = view.findViewById(R.id.layout_tatatertib);
        Layout_tatatertib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new TataTertibFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });

        Layout_kontak = view.findViewById(R.id.layout_kontak);
        Layout_kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new KontakFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });

    return view;
}
}