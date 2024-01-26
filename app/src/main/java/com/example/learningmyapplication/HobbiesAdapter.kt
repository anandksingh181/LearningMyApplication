package com.example.learningmyapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView




class HobbiesAdapter(val context: Context , val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0
        init {
            itemView.setOnClickListener {
                Toast.makeText(context,currentHobby!!.title + " Clicked ! " , Toast.LENGTH_SHORT).show()
            }
            val imgShare: ImageView = itemView.findViewById(R.id.imgShare)


              imgShare.setOnClickListener {
                  val message : String = "My hobby is : "+ currentHobby!!.title

                  val intent = Intent()
                  intent.action = Intent.ACTION_SEND
                  intent.putExtra(Intent.EXTRA_TEXT,message)
                  intent.type = "text/plain"

                  context.startActivity(Intent.createChooser(intent, "Share To : "))
            }
        }
        fun setData(hobby: Hobby? , pos: Int) {
             val txvTitle: TextView = itemView.findViewById(R.id.txvTitle)
              txvTitle.text = hobby!!.title

              this.currentHobby  = hobby
              this.currentPosition = pos
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
           val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent , false)
           return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby , position)
    }

}