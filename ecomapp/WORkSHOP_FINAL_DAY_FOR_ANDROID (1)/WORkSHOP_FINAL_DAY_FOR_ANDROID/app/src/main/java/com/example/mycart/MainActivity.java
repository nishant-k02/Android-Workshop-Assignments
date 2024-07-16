package com.example.mycart;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycart.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    RecyclerView productRecyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        productRecyclerView = binding.productList;
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.setAdapter(new ProductAdapater(this,R.layout.product_cell,getProductList()));
    }

    private List<Product> getProductList(){


        // API CALL
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();

        product1.setTitle("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
        product1.setDescription("Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday");
        product1.setImage("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");

        Product product2 = new Product();

        product2.setTitle("Mens Casual Premium Slim Fit T-Shirts");
        product2.setDescription("Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.");
        product2.setImage("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg");

        Product product3 = new Product();

        product3.setTitle("Mens Cotton Jacket");
        product3.setDescription("great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.");
        product3.setImage("https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg");

        Product product4 = new Product();

        product4.setTitle("John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet");
        product4.setDescription("From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.");
        product4.setImage("https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        return productList;
    }
}