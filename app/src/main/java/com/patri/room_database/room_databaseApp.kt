package com.patri.room_database

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Estamos implementando la libreria Dagger Hilt
//esto es que inyecta las clases en otras
/**Es decor si tenemos la clase coche inyectamos la clase motor dentro de coche.
 * Automatizamos la instancia de objetos dentro de objetos*/


@HiltAndroidApp
class room_databaseApp: Application()