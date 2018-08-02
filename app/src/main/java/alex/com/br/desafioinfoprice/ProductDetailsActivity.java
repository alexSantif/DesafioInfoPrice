package alex.com.br.desafioinfoprice;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetailsActivity extends AppCompatActivity {

    ImageView imagemDetalhe;
    TextView nomeProduto, precoDeProduto, precoPorProduto, descricaoProduto;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        imagemDetalhe = findViewById(R.id.imagem_detalhe);
        nomeProduto = findViewById(R.id.nome_produto);
        precoDeProduto = findViewById(R.id.precoDe_produto);
        precoPorProduto = findViewById(R.id.precoPor_produto);
        descricaoProduto = findViewById(R.id.descricao_produto);
        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getIntentContent();
    }

    private void getIntentContent() {
        if(getIntent().hasExtra("nome")) {
            String imagem = getIntent().getStringExtra("imagem");
            String nome = getIntent().getStringExtra("nome");
            String precoDe = getIntent().getStringExtra("precoDe");
            String precoPor = getIntent().getStringExtra("precoPor");
            String descricao = getIntent().getStringExtra("descricao");

            Picasso.get().load(imagem).into(imagemDetalhe);
            nomeProduto.setText(nome);
            precoDeProduto.setText("De: " + precoDe);
            precoDeProduto.setPaintFlags(precoDeProduto.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            precoPorProduto.setText("Por: " + precoPor);
            descricaoProduto.setText(Html.fromHtml(descricao));
        }
    }
}
