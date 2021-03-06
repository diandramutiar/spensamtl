package com.diandra.spensamtl;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class BeritaFragment extends Fragment {


    public BeritaFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private List<Berita> list;
    private ProgressDialog progressDialog;
    private BeritaAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_berita, container, false);
        getActivity().setTitle("Berita");
        recyclerView =  view.findViewById(R.id.recycler_berita);
        list = new ArrayList<>();
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Berita");
        progressDialog.setMessage("Loading berita...");
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        loadMyContent();
        gridLayoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new BeritaAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void loadMyContent() {
        AsyncTask<Void,Void,Void> task =new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://api.ngeartstudio.com/diandra/berita")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    JSONObject object = new JSONObject(response.body().string());
                    JSONArray array = object.getJSONArray("listBerita");
                    for (int i=0;i<array.length();i++){
                        JSONObject obj = array.getJSONObject(i);
                        Berita berita= new Berita(obj.getString("image"),obj.getString("judul"),obj.getString("link"));
                        list.add(berita);
                    }
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println("End of Content");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged(); progressDialog.dismiss();
            }
        };
        task.execute();
    }
}