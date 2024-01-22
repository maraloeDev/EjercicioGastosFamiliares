package com.example.ejandroid01.ui.new

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBindings
import com.example.controlgastos.GastosProvider
import com.example.ejandroid01.MainActivityND
import com.example.ejandroid01.R
import com.example.ejandroid01.databinding.FragmentNewBinding
import com.example.ejandroid01.ui.list.ListFragment
import com.google.android.material.snackbar.Snackbar
import java.util.Date

class NewFragment : Fragment() {

    private var _binding: FragmentNewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewBinding.inflate(inflater, container, false)

        binding.btNew.setOnClickListener({

            var msj = ""

            var categoria = binding.tilEtCategoria.text.toString()
            var concepto = binding.tilEtConcepto.text.toString()
            var fechaTxt = binding.tilEtFecha.text.toString()
            var precioTxt = binding.tilEtPrecio.text.toString()

            if (!categoria.isNullOrBlank() && !concepto.isNullOrBlank()
                && !fechaTxt.isNullOrBlank() && !precioTxt.isNullOrBlank()
            ) {
                try {
                    var fecha = Date(fechaTxt)
                    var precio = precioTxt.toInt()
                    var user = "juan"
                    GastosProvider.gastos.add(GastosProvider.Gastos(categoria, concepto, fecha, precio, user))

                    // var intent3 = Intent(this, ListFragment::class.java)
                    // startActivity(intent3)

                } catch (e: Exception) {
                    msj = "Se produjo un error con los datos que introduciste." +
                            " Por favor revise que esten bien escritos"
                }
            } else {
                msj = "Debes introducir los datos para poder registrar el gasto"
            }

            if (!msj.isNullOrBlank()) {
                Snackbar.make(binding.root, msj, Snackbar.LENGTH_LONG).show()
            }
        })

        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
