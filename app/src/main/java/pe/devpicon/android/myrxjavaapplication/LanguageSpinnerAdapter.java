package pe.devpicon.android.myrxjavaapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pe.devpicon.android.myrxjavaapplication.model.Language;

/**
 * Created by armando on 8/2/17.
 */

public class LanguageSpinnerAdapter extends ArrayAdapter<Language>{
    public LanguageSpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Language> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View view = convertView;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.language_item, null);

            holder = new ViewHolder();
            holder.textView = (TextView) view.findViewById(android.R.id.text1);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Language language = getItem(position);
        holder.textView.setText(language.getName());

        return view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private class ViewHolder{
        TextView textView;

        public ViewHolder() {
        }

    }
}
