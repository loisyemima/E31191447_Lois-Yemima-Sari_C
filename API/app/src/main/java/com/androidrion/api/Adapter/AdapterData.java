package com.androidrion.api.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.androidrion.api.InsertData;
import com.androidrion.api.Model.ModelData;
import java.util.List;
import com.androidrion.api.R;


public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private List<ModelData> mItems ;
    private Context context;

    public AdapterData ( Context context, List<ModelData> items)
    {
        this.mItems = items;
        this.context = context;
    }

    //onCreateViewHolder(ViewGroup, int) untuk membuat RecyclerView.
// ViewHolder baru dan menginisialisasi beberapa bidang pribadi untuk digunakan oleh RecyclerView.
    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row,parent,
                false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    //	 onBindViewHolder(ViewHolder, int) untuk memperbarui konten RecyclerView.
//	 ViewHolder dengan item pada posisi tertentu dan juga menyiapkan beberapa bidang
//	 pribadi untuk digunakan oleh RecyclerView.
    @Override
    public void onBindViewHolder(HolderData holder, int position){
        ModelData md = mItems.get(position);
        holder.tvusername.setText(md.getUsername());
        holder.tvgrup.setText(md.getGrup());
        holder.tvnama.setText(md.getNama());
        holder.tvpassword.setText(md.getPassword());
        holder.md = md;
    }

    @Override
    public int getItemCount(){ return mItems.size();}


    class HolderData extends RecyclerView.ViewHolder{
        TextView tvusername, tvgrup, tvnama, tvpassword;
        ModelData md;
        public HolderData( View view){
            super(view);
            tvusername = (TextView) view.findViewById(R.id.username);
            tvgrup = (TextView) view.findViewById(R.id.grup);
            tvnama = (TextView) view.findViewById(R.id.nama);
            tvpassword = (TextView) view.findViewById(R.id.password);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick( View view){
                    Intent update = new Intent(context, InsertData.class);
                    update.putExtra("update",1);
                    update.putExtra("username", md.getUsername());
                    update.putExtra("grup", md.getGrup());
                    update.putExtra("nama", md.getNama());
                    update.putExtra("password", md.getPassword());

                    context.startActivity(update);

                }
            });
        }
    }
}
