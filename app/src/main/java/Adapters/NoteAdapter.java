package Adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.melself.onlinenote.databinding.ItemListBinding;

import java.util.ArrayList;
import java.util.List;

import Data.DBNote;
import Model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<DBNote> mNote = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DBNote note = mNote.get(position);
        holder.bindView(note);
    }

    @Override
    public int getItemCount() {
        return mNote.size();
    }

    public void setNote(List<DBNote> note){
        this.mNote = note;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemListBinding binding;

        public ViewHolder(@NonNull ItemListBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void bindView(DBNote note){
            binding.nameTxt.setText(note.getHeading());
            binding.descriptionTxt.setText(note.getMain());
            binding.imageViewList.setImageURI(Uri.parse(note.getImage()));
        }
    }
}
