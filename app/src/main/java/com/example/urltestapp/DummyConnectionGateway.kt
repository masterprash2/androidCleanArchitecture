package com.example.urltestapp

class DummyConnectionGateway : ConnectionGateway {
    override fun isConnected(): Boolean {
        return true
    }


}