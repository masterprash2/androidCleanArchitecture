package com.example.urltestapp.di

import android.content.Context
import com.example.gateway.ConnectionGateway
import com.example.gateway.NetworkGateway
import com.example.gateway.scopes.AppScope
import com.example.gatewayimpl.DummyConnectionGateway
import com.example.gatewayimpl.UrlConnectionNetworkGateway
import com.example.urltestapp.*
import dagger.Module
import dagger.Provides

@Module
class AppModule {


    @AppScope
    @Provides
    fun networkGateway(context: Context) : NetworkGateway {
        return UrlConnectionNetworkGateway(context)
    }

    @AppScope
    @Provides
    fun connetionGateway() : ConnectionGateway {
        return DummyConnectionGateway()
    }

    @Provides
    @AppScope
    fun context(app : App) : Context {
        return app
    }

}
