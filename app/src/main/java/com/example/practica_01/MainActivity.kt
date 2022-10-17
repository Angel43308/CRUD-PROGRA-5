 package com.example.practica_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_01.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_view_design.*

 class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val data = ArrayList<Alumno>()
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        //Agregar elementos a la lista
        data.add(Alumno(
            "Angel Rojas",
            "20172976",
            "arojas10@ucol.mx" ,
            "https://laverdadnoticias.com/__export/1601372860028/sites/laverdad/img/2020/09/29/kimetsu_no_yaiba_diez_increibles_cosplay_de_nezuko_que_se_parecen_al_anime.jpg_1834093470.jpg"
            )
        )
        data.add(Alumno(
            "Rene Valenciaa",
            "20172123",
            "rvalencia11@ucol.mx" ,
            "https://static.wikia.nocookie.net/doblaje/images/7/74/KermitTheFrog-CutePhoto.jpg/revision/latest?cb=20141018050507&path-prefix=es"
            )
        )
        data.add(Alumno(
            "Ray Montelongo",
            "20172343",
            "rmontelongo22@ucol.mx" ,
            "https://static.wikia.nocookie.net/ssbb/images/7/7c/Charizard_en_Pokk%C3%A9n_Tournament.png/revision/latest?cb=20160106191002&path-prefix=es"
            )
        )
        data.add(Alumno(
            "Mario Neri",
            "20172155",
            "mneri33@ucol.mx" ,
            "https://static.wikia.nocookie.net/videojuego/images/4/43/Bulbasaur.png/revision/latest?cb=20110113231911"
            )
        )
        data.add(Alumno(
            "Piñaaa",
            "20172154",
            "pinaaaa44@ucol.mx" ,
            "https://static.wikia.nocookie.net/bobesponja/images/9/93/SpongeBob_House.png/revision/latest?cb=20210430180306"
            )
        )
        data.add(Alumno(
            "Mini pekka",
            "20172156",
            "panqueques43308@ucol.mx" ,
            "https://esports.eldesmarque.com/wp-content/uploads/2022/07/PEKKA3.jpg"
            )
        )


        // This will pass the ArrayList to our Adapter
        val adapter = AlumnoAdapter(this, data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : AlumnoAdapter.ClickListener{
            override fun onItemClick(view: View, position:Int){
                Toast.makeText(this@MainActivity,"onItemClick ${position}",Toast.LENGTH_LONG).show()
            }
        })

        //variable para recibir todos los extras
        val parExtra = intent.extras
        //variables que recibimos todos los extras
        val msje = parExtra?.getString("mensaje")
        val nombre = parExtra?.getString("nombre")
        val cuenta = parExtra?.getString("cuenta")
        val correo = parExtra?.getString("correo")
        val imagen = parExtra?.getString("imagen")
        //Toast.makeText(this,"${nombre}",Toast.LENGTH_LONG).show()
        if(msje=="nuevo"){
            val insertIndex:Int=data.count()
            data.add(insertIndex,
                Alumno(
                    "${nombre}",
                    "${cuenta}",
                    "${correo}",
                    "${imagen}"
                )
            )
            adapter.notifyItemInserted(insertIndex)
        }

        //Click en agregar
        faButton.setOnClickListener{
            val intento2= Intent(this,MainActivityNuevo::class.java)
            //intento2.putExtra("valor1","Hola mundo")
            startActivity(intento2)
        }

    }
}