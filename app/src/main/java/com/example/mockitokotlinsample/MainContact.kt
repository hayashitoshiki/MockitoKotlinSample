package com.example.mockitokotlinsample

interface MainContact {
    interface View{}

    interface Presenter{
        fun getName(id:Int):String
    }
}