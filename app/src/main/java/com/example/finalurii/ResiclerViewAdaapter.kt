package com.example.finalurii

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class ResiclerViewAdaapter : RecyclerView.Adapter<ResiclerViewAdaapter.ViewHolder>() {

    private val itemTitles = arrayOf("BMW M8","MASERATI MC20","HONDA NSX","TOYOTA SUPRA MK5","ASTON MARTIN DBS SUPERLEGGERA","BMW M1","PORSCHE 911 GT2 RS")
    private val itemDetails = arrayOf("The M8 is powered by a twin-turbo 4.4-liter V-8 that m" +
            "akes 617 horsepower and 553 pound-feet of torque. Performance figures i" +
            "nclude a 0–100 km/h (62 mph) acceleration time of 2.8 seconds.","The Maserati mc20 i" +
            "s powered by a 3.0-liter, twin-turbocharged V6 that  produ" +
            "ces 621 horsepower at 7,500 rpm and 538 pound-feet of torque at 3,000 rpm.","Known as a" +
            " japanese ferrari, It was powered by an 3.0 L V6 engine (270HP), which featured Honda's VTEC (Var" +
            "iable Valve Timing and Lift Electronic Control),  0-60 mph in 5.5 sec."
            ,"The latter include two turbocharged engines, a standard 255-hp 2.0-liter four-" +
                "cylinder and an optional 382-hp 3.0-liter inline-six. The 2.0 engine ca" +
                "n reach 60 MPH in five seconds and has a top speed of 155 MPH","5.2 L Aston Martin AE31 twin-turbocha" +
                "rged V12, 0-60 mph in less than  3.6 seconds.","The M1 coupé was hand-built between 1978 and 1981, Engine 3.5L DOHC 24-valve I-6/274 hp @ 6,500 rpm, 243 lb-ft @ 5,000" +
                " rpm   274HP , 0-100 in less than 4.5 seconds.","It uses the 911 GT2 RS road car's 690-hp twin-turbocharged 3.8-liter flat-six and seven-speed PDK du" +
                "al-clutch automatic transmission. 0-100 in less than 2.8 seconds.")
    private val itemImage = intArrayOf(
        R.drawable.bmw_m8,
        R.drawable.maserati,
        R.drawable.honda_nsx1,
        R.drawable.supra_new,
        R.drawable.aston_martin,
        R.drawable.bmw_m1,
        R.drawable.porshe)


    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        var image : ImageView
        var textTitle : TextView
        var textDec  : TextView

        init {

            image = itemView.findViewById(R.id.Item_image)
            textTitle = itemView.findViewById(R.id.item_title)
            textDec = itemView.findViewById(R.id.item_details)


        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_model,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles[position]
        holder.textDec.text = itemDetails[position]
        holder.image.setImageResource(itemImage[position])

        holder.itemView.setOnClickListener { v : View->

            Toast.makeText(v.context, "clicked  on this item", Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }


}