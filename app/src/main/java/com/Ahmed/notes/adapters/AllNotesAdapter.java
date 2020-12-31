package com.Ahmed.notes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.omar98K.notes.R;
import com.Ahmed.notes.classes.Note;

import java.util.ArrayList;
import java.util.List;

public class AllNotesAdapter  extends RecyclerView.Adapter<AllNotesAdapter.ViewHolder>{

    private ArrayList<Note> data;
    private AllNotebooksAdapter.OnItemClickListener mListener;

    public AllNotesAdapter(ArrayList<Note> data){
        this.data = data;
    }


    //onItemClick
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(AllNotebooksAdapter.OnItemClickListener listener){
        mListener=listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.noteTitle.setText(data.get(position).titleOfNote);
        holder.noteContext.setText(data.get(position).contextOfNote);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void filterList(ArrayList<Note> filteredList) {
        data = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView noteTitle,noteContext,noteDate;
        public ViewHolder(View itemView) {
            super(itemView);
            noteTitle=itemView.findViewById(R.id.note_title);
            noteContext=itemView.findViewById(R.id.note_context);
            noteDate=itemView.findViewById(R.id.note_date);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null){
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}