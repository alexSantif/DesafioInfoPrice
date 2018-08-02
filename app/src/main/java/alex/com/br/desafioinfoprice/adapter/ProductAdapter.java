package alex.com.br.desafioinfoprice.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import alex.com.br.desafioinfoprice.ProductDetailsActivity;
import alex.com.br.desafioinfoprice.R;
import alex.com.br.desafioinfoprice.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<Product> dataList;
    private Context context;

    public ProductAdapter(Context context, ArrayList<Product> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_product, parent, false);
        return new ProductAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ProductViewHolder holder, final int position) {
        Picasso.get().load(dataList.get(position).getUrlImagem()).into(holder.product);
        holder.descricao.setText(dataList.get(position).getNome());
        holder.precoDe.setText("De: " + dataList.get(position).getPrecoDe().toString());
        holder.precoDe.setPaintFlags(holder.precoDe.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        holder.precoPor.setText("Por: " + dataList.get(position).getPrecoPor().toString());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("imagem", dataList.get(position).getUrlImagem());
                intent.putExtra("nome", dataList.get(position).getNome());
                intent.putExtra("precoDe", dataList.get(position).getPrecoDe().toString());
                intent.putExtra("precoPor", dataList.get(position).getPrecoPor().toString());
                intent.putExtra("descricao", dataList.get(position).getDescricao());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView product;
        TextView descricao, precoDe, precoPor;
        LinearLayout layout;

        ProductViewHolder(View itemView) {
            super(itemView);
            product = itemView.findViewById(R.id.product);
            descricao = itemView.findViewById(R.id.descricao);
            precoDe = itemView.findViewById(R.id.precoDe);
            precoPor = itemView.findViewById(R.id.precoPor);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
