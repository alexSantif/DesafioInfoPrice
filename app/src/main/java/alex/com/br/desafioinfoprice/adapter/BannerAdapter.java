package alex.com.br.desafioinfoprice.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import alex.com.br.desafioinfoprice.R;
import alex.com.br.desafioinfoprice.model.Banner;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder>
{
    private ArrayList<Banner> dataList;

    public BannerAdapter(ArrayList<Banner> dataList) {
        this.dataList = dataList;
    }

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_banner, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BannerViewHolder holder, int position) {
        Picasso.get().load(dataList.get(position).getUrlImagem()).into(holder.banner);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        ImageView banner;

        BannerViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
}
