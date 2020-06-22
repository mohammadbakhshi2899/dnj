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
                        "student",
                        "https://florinafood.gr/imgs/paper-planes.jpg",
                        "3500",
                        true,
                        "15000 ",
                        3.5f ,
                        ""

                    )
                )
            }
            return arrayList
        }

        fun sendCategory(): List<String> {
            return arrayListOf(
                "دسر ها",
                "فینگر فود ها",
                "غذا ها",
                "شیرینی ها",
                "پیش غذا ها",
                "کیک ها"
            )
        }
    }
}