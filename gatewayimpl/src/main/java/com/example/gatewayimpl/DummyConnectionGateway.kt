package com.example.gatewayimpl

import com.example.gateway.ConnectionGateway

class DummyConnectionGateway : ConnectionGateway {
    override fun isConnected(): Boolean {
        return true
    }


}