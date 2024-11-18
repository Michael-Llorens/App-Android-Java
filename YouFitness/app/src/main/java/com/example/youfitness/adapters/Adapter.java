package com.example.youfitness.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.youfitness.R;
import com.example.youfitness.api.Usuarios;
import com.example.youfitness.api.UsuariosDAO;
import com.example.youfitness.fragments.HomeFragmen;
import com.squareup.picasso.Picasso;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List <Usuarios> listaUsuarios;
    private UsuariosDAO usuariosDAO = null;
    private Context context;
    private Cursor cursor;

    public Adapter(Context context, Cursor cursor) {
        this.usuariosDAO = new UsuariosDAO(context);
        this.usuariosDAO.abrir();
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_imagenes, null, false);

        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        cursor.moveToPosition(position);
        @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
        Picasso.get().load(listaUsuarios.get(position).getImagen()).resize(400,400).into(holder.img);
        holder.asignarDatos(nombre);


    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombres;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombres = itemView.findViewById(R.id.nombre);
            img = itemView.findViewById(R.id.publicacion);
        }

        public void asignarDatos(String nombre) {
            nombres.setText(nombre);

        }
    }
}
