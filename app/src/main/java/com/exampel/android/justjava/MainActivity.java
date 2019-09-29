package com.exampel.android.justjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected int quantity = 0;
    protected int price = 5;
    protected int order = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        calculatePrice();
        String message = createOrderSummary(order) + "\nTotal: $ " + calculatePrice() + "\nThank you";
        displayMessage(message);

    }

    public int calculatePrice() {
        order = quantity * price;
        return order;
    }


    public String createOrderSummary(int order) {
        String totalOrder = "Name: Kaptal Kunal" + "\nAdd whipped cream? " + whippedCream()+ "\nQuantity: " + quantity;
        return totalOrder;
    }

    public boolean whippedCream() {
        CheckBox whippedCream = findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = whippedCream.isChecked();
        return hasWhippedCream;
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity <= 0) {
        } else {
            quantity--;
        }
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.orderSummary_text_view);
        orderSummaryTextView.setText(message);
    }
}

