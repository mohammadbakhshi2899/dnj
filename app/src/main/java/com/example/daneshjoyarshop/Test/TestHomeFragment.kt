package com.example.daneshjoyarshop.Test

import com.example.daneshjoyarshop.dataClass.DataProduct

class TestHomeFragment {


    companion object {
        fun productData(): List<DataProduct> {
            val arrayList = arrayListOf<DataProduct>()
            for (item in 1..9) {
                arrayList.add(
                    DataProduct(
                        item,
                        "15000",
                        "3500",
                        true,
                        "https://florinafood.gr/imgs/paper-planes.jpg",
                        "student"
                    )
                )
            }
            return arrayList
        }

        fun sendCategory(): List<String> {
            return arrayListOf(
                "دسر ها",
                "فینگر فود ها",
                "دسر هاغذا ها",
                "شیرینی ها",
                "پیش غذا ها",
                "کیک ها"
            )
        }
    }
}