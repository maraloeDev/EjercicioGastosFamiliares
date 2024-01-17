package com.example.controlgastos

data class Gastos(var gasto:Double, var concepto:String, var precio:Double){
    override fun toString(): String {
        return super.toString()
    }
}
