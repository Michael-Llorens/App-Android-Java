package com.example.youfitness.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youfitness.R;
import com.example.youfitness.api.Usuarios;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ImagenesAdapter extends RecyclerView.Adapter<ImagenesAdapter.ViewHoldreDatos> {

    private Context context;
    private List<Usuarios> listaUsuarios;
    private ImageView img;
    int cont;

    public ImagenesAdapter(Context context, List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        this.context = context;

    }

    @NonNull
    @Override
    public ImagenesAdapter.ViewHoldreDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_imagenes, null, false);

        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        return new  ViewHoldreDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagenesAdapter.ViewHoldreDatos holder, int position) {

        holder.asignarDatos(listaUsuarios.get(position).getName(),position);
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class ViewHoldreDatos extends RecyclerView.ViewHolder {

        TextView nombres;
        ImageView img;

        public ViewHoldreDatos(@NonNull View itemView) {
            super(itemView);
            cont++;
            img = itemView.findViewById(R.id.publicacion);
            nombres = itemView.findViewById(R.id.nombre);
            Log.e("fsdfasdfas", String.valueOf(cont));
        }

        public void asignarDatos(String nom,int position) {
            nombres.setText(nom);
            Picasso.get().load(listaUsuarios.get(position).getImagen()).resize(400,400).into(img);
            Log.e("fsdfasdfas","fasdfffffffffffffff");

        }
    }
}
