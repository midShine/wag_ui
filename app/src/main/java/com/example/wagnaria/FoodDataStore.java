package com.example.wagnaria;

import java.util.ArrayList;

public class FoodDataStore {
    public static String[][] data = new String[][]{
            {"Banana Toast","$50","This served from Ambon's Banana with high quality and imported french bread, and all sweets seasoning","Get 20% discount for couple order","banana_toast"},
            {"Beef Steak","$180","This served from fresh and high quality beef tenderloin and it's grilled with our secret sweet sour sauce","Get 15% discount if reserved table","beef_steak"},
            {"Blueberry Toast","$55","This served from fresh imported ireland blueberrys that taste is sweet with little bit sour, it's nice for your breakfast","There's no promo for this month","blueberry_toast"},
            {"Chicken Steak","$150","This served from high quality chicken breast and it's grilled with sweet spicy sauce","There's no promo for this month","chiken_steak"},
            {"Lasagna","$100","This served from pork meat with an original italian sauce","Get 20% discount for family set","lasagna"},
            {"Algerian Beef Steak","$165","This served from high quality local beef and cooked in medium with Algerian spices","There's no promo for this month","medium_beef_steak"},
            {"Pork Ribs","$145","This served from local high quality pork ribs and it's cooked with local spice and our secret sauce","There's no promo for this month","pork_ribs"},
            {"Shrimp Pasta","$150","This served with fresh local shrimp and cooked in american style with local spice","Get 15% discount every afternoon in Saturday","seafood_pasta"},
            {"Bolognese Pasta","$125","This served in italian style bolognese with our original sauce","There's no promo for this month","spagetti_bolognese"},
            {"Strawberry Pancake","$50","This served with fresh local berrys and imported new zealand milk and cooked with an local honey","There's no promo for this month","strawberry_pancake"},
    };

    public static ArrayList<FoodDataset> getListData(){
        ArrayList<FoodDataset> list = new ArrayList<>();
        for (String[] aData : data){
            FoodDataset fooddata = new FoodDataset();
            fooddata.setFood(aData[0]);
            fooddata.setPrice(aData[1]);
            fooddata.setDetail(aData[2]);
            fooddata.setPromo(aData[3]);
            fooddata.setPhoto(aData[4]);

            list.add(fooddata);
        }

        return list;
    }
}
