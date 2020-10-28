package com.example.room_database;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MainData> dataList;
    private Activity context;
    private RoomDB database;
    private ViewGroup parent;
    private int viewType;


    //constructor
    public MainAdapter(Activity context,List<MainData> dataList){

        this.context=context;
        this.dataList= dataList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_row_main,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        //Maindata
        MainData data= dataList.get(position);

        //database
        database=RoomDB.getInstance(context);
        //set text

        holder.textView.setText(data.getText());
        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainData d=dataList.get(holder.getAdapterPosition());
                //get id

                int sID = d.getID();
                //get text

                String sText=d.getText();
                //create dialog

                Dialog dialog=new Dialog(context);
                //setr content view
                dialog.setContentView(R.layout.dialog_update);
                //initialize width
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height= WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width,height);
                dialog.show();

                final EditText editText=dialog.findViewById(R.id.edit_text);

                Button btUpdate=dialog.findViewById(R.id.bt_update);

                editText.setText(sText);

                btUpdate.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        String uText=editText.getText().toString().trim();//grt updated text
                        //int sId=d.getID();
                        database.mainDao().update(sID,uText);//update text in db
                        dataList.clear();//notify
                        dataList.addAll(database.mainDao().getAll());
                        notifyDataSetChanged();
                    }
                });

            }
        });
                holder.btDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainData d=dataList.get(holder.getAdapterPosition());
                        database.mainDao().delete(d);
                        int position= holder.getAdapterPosition();
                        dataList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemChanged(position,dataList.size());
                    }
                });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView btEdit,btDelete;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            //variable assign

            textView = itemView.findViewById(R.id.text_view);
            btEdit = itemView.findViewById(R.id.bt_edit);
            btDelete = itemView.findViewById(R.id.bt_delete);
        }


    }
}


