package alex.com.br.desafioinfoprice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import alex.com.br.desafioinfoprice.adapter.BannerAdapter;
import alex.com.br.desafioinfoprice.adapter.ProductAdapter;
import alex.com.br.desafioinfoprice.model.Banner;
import alex.com.br.desafioinfoprice.model.BannerList;
import alex.com.br.desafioinfoprice.model.Product;
import alex.com.br.desafioinfoprice.model.ProductList;
import alex.com.br.desafioinfoprice.rest.GetBannerDataService;
import alex.com.br.desafioinfoprice.rest.GetProductDataService;
import alex.com.br.desafioinfoprice.rest.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.support.v7.widget.DividerItemDecoration.HORIZONTAL;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BannerAdapter adapter;
    private ProductAdapter adapterProduct;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo_navbar);
        setTitle("a Lodjinha");

        GetBannerDataService service = RetrofitInstance.getRetrofitInstance().create(GetBannerDataService.class);

        GetProductDataService serviceProduct = RetrofitInstance.getRetrofitInstance().create(GetProductDataService.class);

        Call<BannerList> call = service.getBannerData();
        Call<ProductList> callProduct = serviceProduct.getProductData();

        call.enqueue(new Callback<BannerList>() {
            @Override
            public void onResponse(Call<BannerList> call, Response<BannerList> response) {
                generateBannerList(response.body().getBannerArrayList());
            }

            @Override
            public void onFailure(Call<BannerList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo deu errado, tente novamente!", Toast.LENGTH_SHORT).show();
            }
        });

        callProduct.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                generateProductList(response.body().getProductArrayList());
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo deu errado, tente novamente!", Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void generateBannerList(ArrayList<Banner> banDataList) {
        recyclerView = findViewById(R.id.recycler_view_banner_list);

        adapter = new BannerAdapter(banDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

    }

    private void generateProductList(ArrayList<Product> proDataList) {
        recyclerView = findViewById(R.id.recycler_view_products_list);

        adapterProduct = new ProductAdapter(MainActivity.this, proDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        DividerItemDecoration itemDecor = new DividerItemDecoration(MainActivity.this, VERTICAL);
        recyclerView.addItemDecoration(itemDecor);
        
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapterProduct);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
